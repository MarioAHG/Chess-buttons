package buttons;

import java.util.ArrayList;
import java.util.HashMap;
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

    public static void guardarPosicion() {
        Icon[] Pos = new Icon[64];
        int i = 0;
        for (String key : names.keySet()) {
            Pos[i] = names.get(key).getIcon();
            i = i + 1;
        }
        posiciones.add(Pos);
    }
    //public static boolean rewindMaked = true;

}
