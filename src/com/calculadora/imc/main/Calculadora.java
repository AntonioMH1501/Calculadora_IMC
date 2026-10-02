package com.calculadora.imc.main;

import com.calculadora.imc.controller.IMCController;
import com.calculadora.imc.view.VistaCalculadora;
/**
 *
 * @author Antonio Muñoz Herrera
 */
public class Calculadora {
    
    public static void main(String[] args){
        VistaCalculadora vista = new VistaCalculadora();
        new IMCController(vista);
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
}
