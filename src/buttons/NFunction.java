/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttons;

import buttons.UCI.UciResult;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */

public class NFunction {
    public static JButton Nboton1 = null;
    public static Icon NiconG = null;
    public static UciResult Nres=null;
    public static String Nst1="";
    public static String Nst2="";
    public static String NstPromPiece="";
    public static Icon Nst1Icon =null;
    public static boolean Nstockfishplayed=false;
    public static void FunctionOfButtons(JButton boton2) throws IOException, InterruptedException {
        boolean Nbo=false;
        if(Nboton1!=null){
            Nbo=NMemory.contieneNegra(boton2,Nboton1);
        }
        if(boton2!=Nboton1&&Nbo==false){
        if (NiconG != null) {
            NMemory.Ntext=Nboton1.getName()+boton2.getName();
            ////////CORONACIÓN
            if(NMemory.NtoPromote){
                NMemory.Ntext=NMemory.Ntext+TableroNegras.NaddProm;
            }
            System.out.println("///////////"+Memory.text);
            NMemory.Nengine.makeMove(NMemory.NgameId, NMemory.Ntext);
            ////////CORONACIÓN
            if(NMemory.Nengine.ilegalmoves(NMemory.NgameId)==false){
            Reglas.NCastle(Nboton1, boton2);
            Reglas.En(Nboton1, boton2);
            Reglas.Promotion(boton2);
            if(NMemory.NtoPromote){
                TableroNegras.NaddProm="";
                NMemory.NtoPromote=false;
            }else{
            boton2.setIcon(NiconG);}
            NiconG = null;
            Nboton1.setIcon(null);
            Nboton1=null;
            System.out.println(NMemory.Ntext);
//            try {
                Nres = NMemory.Nengine.getBestMove(NMemory.NgameId, 1000);
                NMemory.Nengine.makeMove(NMemory.NgameId, Nres.bestMove);
                Nstockfishplayed=true;
//            } catch (IOException ex) {
//                Logger.getLogger(NFunction.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(NFunction.class.getName()).log(Level.SEVERE, null, ex);
//            }
            /////////////////
            System.out.println("st:"+Nres.bestMove);
            //System.out.println("gid:"+Memory.gameId);
            }else{
                JOptionPane.showMessageDialog(null,NMemory.Ntext,"Movimiento ilegal",JOptionPane.INFORMATION_MESSAGE);
                NiconG=null;
                Nboton1=null;
                TableroNegras.NaddProm="";
                NMemory.NtoPromote=false;
                System.out.println("ILEGAL MOVEMENT");
            }
        } else {
            if (boton2.getIcon() != null) {
                NiconG = boton2.getIcon();
                Nboton1 = boton2;
            }
        }
    } else{
            if(Nbo){
            System.out.println("It contains it");
            NiconG=boton2.getIcon();
            Nboton1=boton2;
            Nboton1.setIcon(boton2.getIcon());
            
            Nbo=false;
            }else{
            if(boton2==Nboton1){
            NiconG=null;
            Nboton1=null;}}
        }
        if(Nres != null && Nres.bestMove.length()==4&&Nstockfishplayed==true){
            Nst1=Nres.bestMove.substring(0,2);
            Nst2=Nres.bestMove.substring(2);
            System.out.println("1:"+Nst1);
            System.out.println("2:"+Nst2);
            //System.out.println(Memory.names.get(st1));
            Reglas.NCastle(NMemory.Nnames.get(Nst1),NMemory.Nnames.get(Nst2));
            Reglas.En(NMemory.Nnames.get(Nst1),NMemory.Nnames.get(Nst2));
            
            Nst1Icon=NMemory.Nnames.get(Nst1).getIcon();
            NMemory.Nnames.get(Nst1).setIcon(null);
            NMemory.Nnames.get(Nst2).setIcon(Nst1Icon);
            Nstockfishplayed=false;
            NMemory.NguardarPosicion();
            Nst1="";
            Nst2="";
            Nst1Icon=null;
        }else{
         if(Nres != null && Nres.bestMove.length()==5&&Nstockfishplayed==true){
             Nst1=Nres.bestMove.substring(0,2);
             Nst2=Nres.bestMove.substring(2,4);
             NstPromPiece=Nres.bestMove.substring(4);
             System.out.println("1:"+Nst1);
             System.out.println("2:"+Nst2);
             System.out.println("stP:"+NstPromPiece);
             NMemory.Nnames.get(Nst1).setIcon(null);
             if(NstPromPiece.equals("q")){
                 NMemory.Nnames.get(Nst2).setIcon(NMemory.Niconos[10]);
             }
             if(NstPromPiece.equals("r")){
                 NMemory.Nnames.get(Nst2).setIcon(NMemory.Niconos[6]);
             }
             if(NstPromPiece.equals("b")){
                 NMemory.Nnames.get(Nst2).setIcon(NMemory.Niconos[8]);
             }
             if(NstPromPiece.equals("k")){
                 NMemory.Nnames.get(Nst2).setIcon(NMemory.Niconos[7]);
             }
             
             Nstockfishplayed=false;
             NMemory.NguardarPosicion();
             Nst1="";
             Nst2="";
             NstPromPiece="";
             Nst1Icon=null;
        }
        }
        
    }
}
