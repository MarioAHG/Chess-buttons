package buttons;

import buttons.UCI.UciResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author technologyrooms
 */
public class Function {

    public static JButton boton1 = null;
    public static Icon iconG = null;
    //public static JButton botonGuardado2=null;
    //public static JButton botonGuardado1=null;
    //public static Icon iconGuardado1=null;
    //public static Icon iconGuardado2=null;
    public static UciResult res=null;
    public static String st1="";
    public static String st2="";
    public static Icon st1Icon =null;
    //public static Icon st2Icon =null;
    public static boolean stockfishplayed=false;

    public static void FunctionOfButtons(JButton boton2) {
        //botonGuardado2=boton2;
        //botonGuardado1=boton1;
        //iconGuardado1=iconG;
        //iconGuardado2=boton2.getIcon();
        //String code = boton2.getName();
        if(boton2!=boton1){
        if (iconG != null) {
            Memory.text=boton1.getName()+boton2.getName();
            Memory.engine.makeMove(Memory.gameId, Memory.text);
            if(Memory.engine.ilegalmoves(Memory.gameId)==false){
            Reglas.Castle(boton1, boton2);
            Reglas.En(boton1, boton2);
            boton2.setIcon(iconG);
            iconG = null;
            boton1.setIcon(null);
            //System.out.println(boton1.getIcon());
            System.out.println(Memory.text);
            try {
                //Memory.engine.makeMove(Memory.gameId, Memory.text);
                res = Memory.engine.getBestMove(Memory.gameId, 1000);
                Memory.engine.makeMove(Memory.gameId, res.bestMove);
                stockfishplayed=true;
            } catch (IOException ex) {
                Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("st:"+res.bestMove);
            //System.out.println("gid:"+Memory.gameId);
            }else{
                iconG=null;
                boton1=null;
                System.out.println("ILEGAL MOVEMENT");
            }
        } else {
            if (boton2.getIcon() != null) {
                iconG = boton2.getIcon();
                boton1 = boton2;
            }
        }
    } else{
            iconG=null;
            boton1=null;
        }
        if(res != null && res.bestMove.length()==4&&stockfishplayed==true){
            st1=res.bestMove.substring(0,2);
            st2=res.bestMove.substring(2);
            st1Icon=Memory.names.get(st1).getIcon();
            Memory.names.get(st1).setIcon(null);
            //st2Icon=Memory.names.get(st2).getIcon();
            Memory.names.get(st2).setIcon(st1Icon);
            stockfishplayed=false;
            Memory.guardarPosicion();
            //Memory.rewindMaked=false;
        }
    }
}