package buttons;

import buttons.UCI.UciResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
    public static String stPromPiece="";
    public static Icon st1Icon =null;
    //public static Icon st2Icon =null;
    public static boolean stockfishplayed=false;

    public static void FunctionOfButtons(JButton boton2) {
        //botonGuardado2=boton2;
        //botonGuardado1=boton1;
        //iconGuardado1=iconG;
        //iconGuardado2=boton2.getIcon();
        //String code = boton2.getName();
        boolean bo=false;
        if(boton1!=null){
            bo=Memory.contieneBlanca(boton2,boton1);
            //System.out.println("Icono1::"+boton1.getIcon());
        }
        //System.out.println("Icono2::"+boton2.getIcon());
        //System.out.println(Memory.iconosBlancas);
        //JOptionPane.showMessageDialog(null, "icono", "icono", JOptionPane.INFORMATION_MESSAGE, Memory.iconosBlancas.get(0));
        if(boton2!=boton1&&bo==false){
        if (iconG != null) {
            Memory.text=boton1.getName()+boton2.getName();
            ////////CORONACIÓN
            if(Memory.toPromote){
                //Memory.toPromote=false;
                Memory.text=Memory.text+NewJFramePrincipal.addProm;
                //NewJFramePrincipal.addProm="";
            }
            System.out.println("///////////"+Memory.text);
            Memory.engine.makeMove(Memory.gameId, Memory.text);
            ////////CORONACIÓN
            if(Memory.engine.ilegalmoves(Memory.gameId)==false){
            Reglas.Castle(boton1, boton2);
            Reglas.En(boton1, boton2);
            Reglas.Promotion(boton2);
            if(Memory.toPromote){
                NewJFramePrincipal.addProm="";
                Memory.toPromote=false;
            }else{
            boton2.setIcon(iconG);}
            iconG = null;
            boton1.setIcon(null);
            //
            boton1=null;
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
                JOptionPane.showMessageDialog(null,Memory.text,"Movimiento ilegal",JOptionPane.INFORMATION_MESSAGE);
                iconG=null;
                boton1=null;
                NewJFramePrincipal.addProm="";
                Memory.toPromote=false;
                System.out.println("ILEGAL MOVEMENT");
            }
        } else {
            if (boton2.getIcon() != null) {
                iconG = boton2.getIcon();
                boton1 = boton2;
            }
        }
    } else{
            if(bo){
            System.out.println("It contains it");
            iconG=boton2.getIcon();
            boton1=boton2;
            boton1.setIcon(boton2.getIcon());
            
            bo=false;
            }else{
            if(boton2==boton1){
            iconG=null;
            boton1=null;}}
        }
        if(res != null && res.bestMove.length()==4&&stockfishplayed==true){
            //System.out.println("Entered");
            st1=res.bestMove.substring(0,2);
            st2=res.bestMove.substring(2);
            System.out.println("1:"+st1);
            System.out.println("2:"+st2);
            //System.out.println(Memory.names.get(st1));
            Reglas.Castle(Memory.names.get(st1),Memory.names.get(st2));
            
//            try{Reglas.En(Memory.names.get(st1), Memory.names.get(st2)); System.out.println("AHHHHHH");}catch(Exception e){
//                System.out.println("Error");
//            }
            Reglas.En(Memory.names.get(st1),Memory.names.get(st2));
            
            st1Icon=Memory.names.get(st1).getIcon();
            Memory.names.get(st1).setIcon(null);
            //st2Icon=Memory.names.get(st2).getIcon();
            Memory.names.get(st2).setIcon(st1Icon);
            stockfishplayed=false;
            Memory.guardarPosicion();
            st1="";
            st2="";
            st1Icon=null;
            //boton1=null;
            //Memory.rewindMaked=false;
        }else{
         if(res != null && res.bestMove.length()==5&&stockfishplayed==true){
             st1=res.bestMove.substring(0,2);
             st2=res.bestMove.substring(2,4);
             stPromPiece=res.bestMove.substring(4);
             System.out.println("1:"+st1);
             System.out.println("2:"+st2);
             System.out.println("stP:"+stPromPiece);
             Memory.names.get(st1).setIcon(null);
             if(stPromPiece.equals("q")){
                 Memory.names.get(st2).setIcon(Memory.iconos[10]);
             }
             if(stPromPiece.equals("r")){
                 Memory.names.get(st2).setIcon(Memory.iconos[6]);
             }
             if(stPromPiece.equals("b")){
                 Memory.names.get(st2).setIcon(Memory.iconos[8]);
             }
             if(stPromPiece.equals("k")){
                 Memory.names.get(st2).setIcon(Memory.iconos[7]);
             }
             ////FALTAN LAS CONDICIONES PARA LAS OTRAS PIEZAS
             stockfishplayed=false;
             Memory.guardarPosicion();
             st1="";
             st2="";
             stPromPiece="";
             st1Icon=null;
        }
        }
        //System.out.println("iconG:"+iconG);
        //System.out.println("boton1:"+boton1);
        ////COSAS ADICIONALES:
        
    }
}