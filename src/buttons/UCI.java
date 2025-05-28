/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttons;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.ArrayList;
/**
 *
 * @author technologyrooms
 */



/**
 * UCIEngine abstracts communication with the Stockfish engine via UCI,
 * using only move lists (no direct FEN manipulation).
 */
public class UCI {
    private final Process process;
    private final BufferedWriter writer;
    private final BlockingQueue<String> outputQueue;
    private final Thread outputReaderThread;
    private final Object commandLock = new Object();
    private final Map<String, GameState> games = new ConcurrentHashMap<>();

    // Internal representation of a game: list of moves from start position
    private static class GameState {
        List<String> moves = new ArrayList<>();
        List<String> currentFenBoard = new ArrayList<>();
    }

    /**
     * Encapsulates UCI result data: best move and evaluation.
     */
    public static class UciResult {
        public final String bestMove;
        public final Integer cpScore;   // centipawn score (null if mate)
        public final Integer mateScore; // mate in N (null if cp)

        public UciResult(String bestMove, Integer cpScore, Integer mateScore) {
            this.bestMove = bestMove;
            this.cpScore = cpScore;
            this.mateScore = mateScore;
        }

        @Override
        public String toString() {
            if (cpScore != null) {
                return String.format("BestMove=%s, Eval=%d cp", bestMove, cpScore);
            } else if (mateScore != null) {
                return String.format("BestMove=%s, Mate=%d", bestMove, mateScore);
            } else {
                return String.format("BestMove=%s", bestMove);
            }
        }
    }

    /**
     * Starts the Stockfish process.
     * @param enginePath command or path to the Stockfish binary
     */
    public UCI(String enginePath) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(enginePath);
        pb.redirectErrorStream(true);
        process = pb.start();
        writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        outputQueue = new LinkedBlockingQueue<>();
        outputReaderThread = startReaderThread();
    }

    private Thread startReaderThread() {
        Thread t = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    outputQueue.offer(line);
                }
            } catch (IOException ignored) {
            }
        }, "Stockfish-OutputReader");
        t.setDaemon(true);
        t.start();
        return t;
    }

    private void sendCommand(String cmd) throws IOException {
        writer.write(cmd);
        writer.newLine();
        writer.flush();
    }

    private String waitFor(String token) throws InterruptedException {
        String line;
        while ((line = outputQueue.take()) != null) {
            if (line.contains(token)) return line;
        }
        return null;
    }

    /**
     * Initialize the UCI protocol.
     */
    public void init() throws IOException, InterruptedException {
        synchronized (commandLock) {
            sendCommand("uci");
            waitFor("uciok");
            sendCommand("isready");
            waitFor("readyok");
        }
    }

    /**
     * Limit strength and set Elo (1000–3000).
     */
    public void setElo(int elo) throws IOException, InterruptedException {
        synchronized (commandLock) {
            sendCommand("setoption name UCI_LimitStrength value true");
            sendCommand("setoption name UCI_Elo value " + elo);
            sendCommand("isready");
            waitFor("readyok");
        }
    }

    /**
     * Create a new game context (start from standard initial position).
     * @return a unique game identifier
     */
    public String createGame() {
        String id = UUID.randomUUID().toString();
        games.put(id, new GameState());
        return id;
    }

    /**
     * Add a SAN/UCI move string to a game.
     * e.g. "e2e4", "g1f3", etc.
     */
    public void makeMove(String gameId, String move) {
        GameState gs = games.get(gameId);
        if (gs == null) throw new IllegalArgumentException("Unknown game ID: " + gameId);
        gs.moves.add(move);
    }

    /**
     * Clear all moves for a game (reset to starting position).
     */
    public void resetGame(String gameId) {
        GameState gs = games.get(gameId);
        if (gs == null) throw new IllegalArgumentException("Unknown game ID: " + gameId);
        gs.moves.clear();
    }

    /**
     * Ask Stockfish for the best move and evaluation at given depth.
     */
    public UciResult getBestMove(String gameId, int timeout) throws IOException, InterruptedException {
        GameState gs = games.get(gameId);
        if (gs == null) throw new IllegalArgumentException("Unknown game ID: " + gameId);

        synchronized (commandLock) {
            outputQueue.clear();
            sendCommand("ucinewgame");
            sendCommand("isready");
            waitFor("readyok");

            // Build "position" command using moves only
            StringBuilder pos = new StringBuilder("position startpos");
            if (!gs.moves.isEmpty()) {
                pos.append(" moves ");
                pos.append(String.join(" ", gs.moves));
            }
            sendCommand(pos.toString());
            sendCommand("go movetime " + timeout);

            String best = null;
            Integer cp = null;
            Integer mate = null;
            String line;
            while ((line = outputQueue.take()) != null) {
                if (line.startsWith("info") && line.contains(" score ")) {
                    String[] parts = line.split(" ");
                    for (int i = 0; i < parts.length - 1; i++) {
                        if ("cp".equals(parts[i])) cp = Integer.parseInt(parts[i+1]);
                        else if ("mate".equals(parts[i])) mate = Integer.parseInt(parts[i+1]);
                    }
                } else if (line.startsWith("bestmove")) {
                    best = line.split(" ")[1];
                    break;
                }
            }
            return new UciResult(best, cp, mate);
        }
    }

    public List<String> getBoardDisplay(String gameId) throws IOException, InterruptedException {
        GameState gs = games.get(gameId);
        synchronized (commandLock) {
            outputQueue.clear();
            // 1) reload the position with every move
            StringBuilder pos = new StringBuilder("position startpos");
            if (!gs.moves.isEmpty()) {
                pos.append(" moves ").append(String.join(" ", gs.moves));
            }
            sendCommand(pos.toString());

            // 2) now dump it
            sendCommand("d");

            List<String> board = new ArrayList<>();
            String line;
            while ((line = outputQueue.take()) != null) {
                board.add(line);
                if (line.startsWith("Fen:")) {
                    String currentFenString = line.replaceFirst("Fen:", "").trim();
                    gs.currentFenBoard.add(currentFenString);
                    System.out.println(currentFenString);
                    break;
                }
            }
            return board;
        }
    }


    /**
     * Shut down the engine process cleanly.
     */
    public void shutdown() throws IOException, InterruptedException {
        synchronized (commandLock) {
            sendCommand("quit");
        }
        process.waitFor();
        outputReaderThread.interrupt();
    }
    //ilegal moves
    public boolean ilegalmoves(String gameId){
        try{
        GameState gs = games.get(gameId);
        if (gs == null) throw new IllegalArgumentException("Unknown game ID: " + gameId);
        List<String> moves = gs.moves;
        String lastMove=moves.get(moves.size()-1);
        moves.remove(moves.size()-1);
        List<String> tableroAnterior=getBoardDisplay(gameId);
        Memory.engine.makeMove(gameId, lastMove);
        List<String> tableroActual=getBoardDisplay(gameId);
        boolean eq=true;
        for(int i=0;i<tableroAnterior.size();i++){
            if(!tableroAnterior.get(i).equals(tableroActual.get(i))){
                eq=false;
            }
        }
        if(eq==true){
           //System.out.println("Moves1:"+moves);
            moves.remove(moves.size()-1);
        }
        //System.out.println("Moves2:"+moves);
        return eq;
        }catch( Exception e){
            System.out.println("Error in legal moves");
            System.out.println(e);
            return true;
        }
        
    }
    public void rewindCode(String gameId){
      GameState gs = games.get(gameId);
        if (gs == null) throw new IllegalArgumentException("Unknown game ID: " + gameId);
        List<String> moves = gs.moves;
        System.out.println(moves);
        moves.remove(moves.size()-1);
        moves.remove(moves.size()-1);
        //System.out.println(moves);
    }
    
    public void saveMatch(String gameId){
     GameState gs = games.get(gameId);
        if (gs == null) throw new IllegalArgumentException("Unknown game ID: " + gameId);
        List<String> moves = gs.moves;
        for(int i=0;i<moves.size();i++){
            if(i!=moves.size()-1){
            Memory.movesMatch=Memory.movesMatch+moves.get(i)+",";
            }else{
            Memory.movesMatch=Memory.movesMatch+moves.get(i);}
        }
    }
}

