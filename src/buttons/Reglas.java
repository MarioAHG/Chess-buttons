package buttons;


import javax.swing.Icon;
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
          if((boton1.getName()+boton2.getName()).equals("e1g1")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) Memory.names.get("h1").getIcon()).getDescription().contains("Wr00.png")){
                Memory.names.get("f1").setIcon( Memory.names.get("h1").getIcon());
                 Memory.names.get("h1").setIcon(null);        
            }
            if((boton1.getName()+boton2.getName()).equals("e1c1")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) Memory.names.get("a1").getIcon()).getDescription().contains("Wr00.png")){
                 Memory.names.get("d1").setIcon( Memory.names.get("a1").getIcon());
                 Memory.names.get("a1").setIcon(null);        
            }
////            System.out.println("////////////////////////////////////"+Function.st1+Function.st2);
////            System.out.println((boton1.getName()+boton2.getName()));
////            if((boton1.getName()+boton2.getName()).equals("e8g8")){System.out.println("ENTRÓ EN LA PRIMERA");}
////            if(((ImageIcon)boton1.getIcon()).getDescription().contains("Bki00.png")){System.out.println("ENTRÓ EN LA SEGUNDA");}
////            if(((ImageIcon) Memory.names.get("h8").getIcon()).getDescription().contains("Br00.png")){System.out.println("ENTRÓ EN LA TERCERA");}
//// EL ERROR ERA PORQUE NO SE HABÍAN DECLARADO LOS BOTONES
//// CONDICIÓN ANTERIOR:
//// if((boton1.getName()+boton2.getName()).equals("e8g8")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Bki00.png")&&((ImageIcon) Memory.names.get("h8").getIcon()).getDescription().contains("Br00.png"))
            if((Function.st1+Function.st2).equals("e8g8")&& ((ImageIcon) Memory.names.get("e8").getIcon()).getDescription().contains("Bki00.png")&&((ImageIcon) Memory.names.get("h8").getIcon()).getDescription().contains("Br00.png")){
//                 System.outst2.println("ENTERED");
//                 System.out.println(Function.st1);
//                 System.out.println(Function.st2);
                Memory.names.get("f8").setIcon( Memory.names.get("h8").getIcon());
                 Memory.names.get("h8").setIcon(null);        
            }
            
              if((Function.st1+Function.st2).equals("e1g1")&& ((ImageIcon) Memory.names.get("e1").getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) Memory.names.get("h1").getIcon()).getDescription().contains("Wr00.png")){
//                 System.outst2.println("ENTERED");
//                 System.out.println(Function.st1);
//                 System.out.println(Function.st2);
                Memory.names.get("f1").setIcon( Memory.names.get("h1").getIcon());
                 Memory.names.get("h1").setIcon(null);        
            }
//// CONDICIÓN ANTERIOR:
//// if((boton1.getName()+boton2.getName()).equals("e8c8")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Bki00.png")&&((ImageIcon) Memory.names.get("a8").getIcon()).getDescription().contains("Br00.png")){

            if((Function.st1+Function.st2).equals("e8c8")&& ((ImageIcon) Memory.names.get("e8").getIcon()).getDescription().contains("Bki00.png")&&((ImageIcon) Memory.names.get("a8").getIcon()).getDescription().contains("Br00.png")){
                 Memory.names.get("d8").setIcon( Memory.names.get("a8").getIcon());
                 Memory.names.get("a8").setIcon(null);        
            }
            
            if((Function.st1+Function.st2).equals("e1c1")&& ((ImageIcon) Memory.names.get("e1").getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) Memory.names.get("a1").getIcon()).getDescription().contains("Wr00.png")){
                 Memory.names.get("d1").setIcon( Memory.names.get("a1").getIcon());
                 Memory.names.get("a1").setIcon(null);        
            }

    }
    
    public static void En(JButton boton1 , JButton boton2){
        if(Function.st1.equals("")&& Function.st2.equals("")){
        if( !(boton1.getName().substring(0, 1).equals(boton2.getName().substring(0, 1))) &&

            ((ImageIcon)boton1.getIcon()).getDescription().contains("Wp00.png") &&
                    boton2.getIcon()== null){
                       Memory.names.get(boton2.getName().substring(0, 1)+(Integer.parseInt(boton2.getName().substring(1, 2))-1 )).setIcon(null);
            }
        
         if( !(boton1.getName().substring(0, 1).equals(boton2.getName().substring(0, 1))) &&

            ((ImageIcon)boton1.getIcon()).getDescription().contains("Bp00.png") &&
                    boton2.getIcon()== null){
                       Memory.names.get(boton2.getName().substring(0, 1)+(Integer.parseInt(boton2.getName().substring(1, 2))+1 )).setIcon(null);
            }
        }
         
         if(!Function.st1.equals("")&& !Function.st2.equals("")){
             
            
                 System.out.println(Function.st2.substring(0, 1)+(Integer.parseInt(Function.st2.substring(1, 2))+1 )+ "Hola");
                 if( !(Function.st1.substring(0, 1).equals(Function.st2.substring(0, 1))) &&

            ((ImageIcon)Memory.names.get(Function.st1).getIcon()).getDescription().contains("Wp00.png") &&
                    Memory.names.get(Function.st2).getIcon()== null){
                       Memory.names.get(Function.st2.substring(0, 1)+(Integer.parseInt(Function.st2.substring(1, 2))-1 )).setIcon(null);
            }
           
           if( !(Function.st1.substring(0, 1).equals(Function.st2.substring(0, 1))) &&

            ((ImageIcon)Memory.names.get(Function.st1).getIcon()).getDescription().contains("Bp00.png") &&
                    Memory.names.get(Function.st2).getIcon()== null){
               
                       Memory.names.get(Function.st2.substring(0, 1)+(Integer.parseInt(Function.st2.substring(1, 2))+1 )).setIcon(null);
            }
             
                     
             
             
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
    //CUANDO PONGO LO DE ABAJO ME SALE ERROR
    //public static ImageIcon reinaIcon = new ImageIcon(Reglas.class.getResource("/Wq00.png"));
    public static void Promotion(JButton boton2){
        if(Memory.toPromote==true){
         if(NewJFramePrincipal.addProm.equals("q")){
        boton2.setIcon(Memory.iconos[3]);
        }
         if(NewJFramePrincipal.addProm.equals("r")){
        boton2.setIcon(Memory.iconos[0]);
        }
         if(NewJFramePrincipal.addProm.equals("n")){
        boton2.setIcon(Memory.iconos[1]);
        }
         if(NewJFramePrincipal.addProm.equals("b")){
        boton2.setIcon(Memory.iconos[2]);
        }
        }
    }
////    public static ImageIcon reinaIcon = new ImageIcon(Reglas.class.getResource("/Wq00.png"));
////        public static ImageIcon torreIcon = new ImageIcon(Reglas.class.getResource("/Wr00.png"));
////        public static ImageIcon alfilIcon = new ImageIcon(Reglas.class.getResource("/Wb00.png"));
////        public static ImageIcon caballoIcon = new ImageIcon(Reglas.class.getResource("/Wk00.png"));
//    public static int Promotion(JButton boton){
//        //////CORONACIÓN
//        Object[] opciones = {
//            new JLabel(reinaIcon),
//            new JLabel(torreIcon),
//            new JLabel(alfilIcon),
//            new JLabel(caballoIcon)
//        };
//        int seleccion=5;
//        if(Memory.toPromote){
//                seleccion = JOptionPane.showOptionDialog(
//                null,
//                "Elige una pieza para la promoción:",
//                "Promoción de Peón",
//                JOptionPane.DEFAULT_OPTION,
//                JOptionPane.PLAIN_MESSAGE,
//                null,
//                opciones,
//                null
//        );}
//            
//            return seleccion;
//    }
    
    public static void NCastle(JButton boton1 , JButton boton2){
          if((boton1.getName()+boton2.getName()).equals("e8g8")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Bki00.png")&&((ImageIcon) NMemory.Nnames.get("h8").getIcon()).getDescription().contains("Br00.png")){
                NMemory.Nnames.get("f8").setIcon( NMemory.Nnames.get("h8").getIcon());
                 NMemory.Nnames.get("h8").setIcon(null);        
            }
            if((boton1.getName()+boton2.getName()).equals("e8c8")&& ((ImageIcon)boton1.getIcon()).getDescription().contains("Bki00.png")&&((ImageIcon) NMemory.Nnames.get("a8").getIcon()).getDescription().contains("Br00.png")){
                 NMemory.Nnames.get("d8").setIcon( NMemory.Nnames.get("a8").getIcon());
                 NMemory.Nnames.get("a8").setIcon(null);        
            }

            if((NFunction.Nst1+NFunction.Nst2).equals("e1g1")&& ((ImageIcon) NMemory.Nnames.get("e1").getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) NMemory.Nnames.get("h1").getIcon()).getDescription().contains("Wr00.png")){

                NMemory.Nnames.get("f1").setIcon( NMemory.Nnames.get("h1").getIcon());
                 NMemory.Nnames.get("h1").setIcon(null);        
            }
            
//              if((Function.st1+Function.st2).equals("e1g1")&& ((ImageIcon) Memory.names.get("e1").getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) Memory.names.get("h1").getIcon()).getDescription().contains("Wr00.png")){
//
//                Memory.names.get("f1").setIcon( Memory.names.get("h1").getIcon());
//                 Memory.names.get("h1").setIcon(null);        
//            }

            if((NFunction.Nst1+NFunction.Nst2).equals("e1c1")&& ((ImageIcon) NMemory.Nnames.get("e1").getIcon()).getDescription().contains("Wki00.png")&&((ImageIcon) NMemory.Nnames.get("a1").getIcon()).getDescription().contains("Wr00.png")){
                 NMemory.Nnames.get("d1").setIcon( NMemory.Nnames.get("a1").getIcon());
                 NMemory.Nnames.get("a1").setIcon(null);        
            }}
}
