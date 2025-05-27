package buttons;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author technologyrooms
 */
public class Memory {

    public static javax.swing.JFrame PlayView = null;
    public static javax.swing.JFrame pConfView = null;
    public static javax.swing.JFrame HomeView = null;
    public static UCI engine = null;
    public static String gameId = null;
    //public static String text="position startpos moves";
    public static String text = "";
    public static HashMap<String, JButton> names = new HashMap<String, JButton>();
    public static ArrayList<Icon[]> posiciones = new ArrayList<>();
    public static boolean toPromote=false;
    public static Icon[] iconos=new Icon[12];

    public static void guardarPosicion() {
        Icon[] Pos = new Icon[64];
        int i = 0;
        for (String key : names.keySet()) {
            Pos[i] = names.get(key).getIcon();
            i = i + 1;
        }
        posiciones.add(Pos);
    }
//    public static Icon[] iconosBlancas={
//        new ImageIcon(Memory.class.getResource("/resources/Wp00.png")),
//        new ImageIcon(Memory.class.getResource("/resources/Wk00.png")),
//        new ImageIcon(Memory.class.getResource("/resources/Wb00.png")),
//        new ImageIcon(Memory.class.getResource("/resources/Wq00.png")),
//        new ImageIcon(Memory.class.getResource("/resources/Wr00.png")),
//        new ImageIcon(Memory.class.getResource("/resources/Wki00.png"))
//        
//    };
    public static boolean contieneBlanca(JButton boton, JButton boton1){
        
        boolean res=false;
        if(boton.getIcon()!=null&&boton1!=null){
        if(((ImageIcon)boton.getIcon()).getDescription().contains("Wp00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Wk00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Wb00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Wq00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Wr00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Wki00.png")){
            res=true;
        }}
        return res;
    }
//     public static ArrayList<Icon> iconosNegras = new ArrayList<>();
//
//    static {
//        iconosBlancas.add(new ImageIcon(Memory.class.getResource("/buttons/resources/Bb00.png")));
//        iconosBlancas.add(new ImageIcon(Memory.class.getResource("/buttons/resources/Bk00.png")));
//        iconosBlancas.add(new ImageIcon(Memory.class.getResource("/buttons/resources/Bki00.png")));
//        iconosBlancas.add(new ImageIcon(Memory.class.getResource("/buttons/resources/Bp00.png")));
//        iconosBlancas.add(new ImageIcon(Memory.class.getResource("/buttons/resources/Bq00.png")));
//        iconosBlancas.add(new ImageIcon(Memory.class.getResource("/buttons/resources/Br00.png")));
//    };
    //public static boolean rewindMaked = true;

}
