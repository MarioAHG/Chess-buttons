package buttons;

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
    public static JButton botonGuardado2=null;
    public static JButton botonGuardado1=null;
    public static Icon iconGuardado1=null;
    public static Icon iconGuardado2=null;

    public static void FunctionOfButtons(JButton boton2) {
        botonGuardado2=boton2;
        botonGuardado1=boton1;
        iconGuardado1=iconG;
        iconGuardado2=boton2.getIcon();
        //String code = boton2.getName();
        if(boton2!=boton1){
        if (iconG != null) {
            boton2.setIcon(iconG);
            iconG = null;
            boton1.setIcon(null);
            Memory.text=boton1.getName()+boton2.getName();
            System.out.println(Memory.text);
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
    }
}