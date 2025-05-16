package buttons;


import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author technologyrooms
 */
public class Reglas {
    public static void Castle(JButton boton1 , JButton boton2){
          if((boton1.getName()+boton2.getName()).equals("e1g1")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) Memory.names.get("a1").getIcon()).getDescription().contains("Wr00.png")){
                Memory.names.get("f1").setIcon( Memory.names.get("h1").getIcon());
                 Memory.names.get("h1").setIcon(null);        
            }
            if((boton1.getName()+boton2.getName()).equals("e1c1")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) Memory.names.get("h1").getIcon()).getDescription().contains("Wr00.png")){
                 Memory.names.get("d1").setIcon( Memory.names.get("a1").getIcon());
                 Memory.names.get("a1").setIcon(null);        
            }
            if((boton1.getName()+boton2.getName()).equals("e8g8")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Bki00.png")&&((ImageIcon) Memory.names.get("h8").getIcon()).getDescription().contains("Br00.png")){
                 Memory.names.get("f8").setIcon( Memory.names.get("h8").getIcon());
                 Memory.names.get("h8").setIcon(null);        
            }
            if((boton1.getName()+boton2.getName()).equals("e8c8")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Bki00.png")&&((ImageIcon) Memory.names.get("a8").getIcon()).getDescription().contains("Br00.png")){
                 Memory.names.get("d8").setIcon( Memory.names.get("a8").getIcon());
                 Memory.names.get("a8").setIcon(null);        
            }

    }
    
    public static void En(JButton boton1 , JButton boton2){
        if( !(boton1.getName().substring(0, 1).equals(boton2.getName().substring(0, 1))) &&

            ((ImageIcon)boton1.getIcon()).getDescription().contains("Wp00.png") &&
                    boton2.getIcon()== null){
                       Memory.names.get(boton2.getName().substring(0, 1)+(Integer.parseInt(boton2.getName().substring(1, 2))-1 )).setIcon(null);
            }
//         if(Function.st1!=null && Function.st2!=null){
//        if( !(Memory.names.get(Function.st1).getName().substring(0, 1).equals(Memory.names.get(Function.st2).getName().substring(0, 1))) &&
//
//            ((ImageIcon)Memory.names.get(Function.st1).getIcon()).getDescription().contains("Bp00.png") &&
//                    Memory.names.get(Function.st2).getIcon()== null){
//                       Memory.names.get(Memory.names.get(Function.st2).getName().substring(0, 1)+(Integer.parseInt(Memory.names.get(Function.st2).getName().substring(1, 2))-1 )).setIcon(null);
//            }
//    }
        
       }
}
