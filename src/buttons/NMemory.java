/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buttons;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Mario
 */
public class NMemory {
    public static javax.swing.JFrame NPlayView = null;
    //public static javax.swing.JFrame NpConfView = null;
    //public static javax.swing.JFrame NHomeView = null;
    public static javax.swing.JFrame NRevView=null;
    public static UCI Nengine = null;
    public static String NgameId = null;
    //public static String text="position startpos moves";
    public static String Ntext = "";
    public static HashMap<String, JButton> Nnames = new HashMap<String, JButton>();
    public static ArrayList<Icon[]> Nposiciones = new ArrayList<>();
    public static boolean NtoPromote=false;
    public static Icon[] Niconos=new Icon[12];
    public static int NLEVELorELO=1500;
    public static HashMap<String, JLabel> Nadds = new HashMap<String, JLabel>();
    public static String NmovesMatch="";
    public static String NfirstMove="";
    public static void NguardarPosicion() {
        Icon[] Pos = new Icon[64];
        int i = 0;
        for (String key : Nnames.keySet()) {
            Pos[i] = Nnames.get(key).getIcon();
            i = i + 1;
        }
        Nposiciones.add(Pos);
    }
    public static boolean contieneNegra(JButton boton, JButton boton1){
        
        boolean res=false;
        if(boton.getIcon()!=null&&boton1!=null){
        if(((ImageIcon)boton.getIcon()).getDescription().contains("Bp00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Bk00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Bb00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Bq00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Br00.png")||((ImageIcon)boton.getIcon()).getDescription().contains("Bki00.png")){
            res=true;
        }}
        return res;
    }
}
