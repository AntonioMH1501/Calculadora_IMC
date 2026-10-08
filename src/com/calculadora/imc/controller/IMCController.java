
package com.calculadora.imc.controller;

import com.calculadora.imc.model.CalculadoraIMC;
import com.calculadora.imc.view.VistaCalculadora;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Antonio Muñoz Herrera
 */
public class IMCController implements java.awt.event.ActionListener {
    
    private final VistaCalculadora vista;
    private final CalculadoraIMC calculadora = new CalculadoraIMC();
    
    public IMCController(VistaCalculadora vista){
        this.vista = vista;
        
        this.vista.getBtnCalcular().addActionListener(this);
    }
    
    @Override
        public void actionPerformed(java.awt.event.ActionEvent e){
            hacerCalculo();
        }

    
    private void hacerCalculo(){
        /*Se cambian los caracteres de "," por ".", ya que para dividir los 
        números con los decimales se debería usar el "."*/
        String pesoIntro = vista.getTxtPeso().getText().trim().replace(",", ".");
        String alturaIntro = vista.getTxtAltura().getText().trim().replace(",", ".");
        
        try{
            double peso = Double.parseDouble(pesoIntro); 
            double altura = Double.parseDouble(alturaIntro); 
            
            /*Los valores de peso y altura no podrán ser negativos ni 0*/
            if (peso <= 0 || altura <=0){
                vista.getLblResultado().setText("");
                vista.getLblClasificacion().setText("Error: Datos deben ser mayores que 0");
                vista.getLblClasificacion().setForeground(Color.RED);
                return;
            }
                
            double imc = calculadora.calcular(peso, altura);
            String clasificacion = calculadora.clasificar(imc);
            /*Con el %.2f lo que se busca es que el IMC se calcule solo con 2 
            decimales*/
            vista.getLblResultado().setText(String.format("Tu IMC es: %.2f", imc));
            vista.getLblClasificacion().setText("Clasificación: " + clasificacion);
            
            aplicarColorClasificacion(clasificacion);

        }catch(NumberFormatException ex) {
            vista.getLblResultado().setText("");
            vista.getLblClasificacion().setText("Error: Introduce solo números válidos");
            vista.getLblClasificacion().setForeground(Color.RED);
        }
    }
    
    private void aplicarColorClasificacion(String clasificacion) {
        /*Salida del texto de la Clasificación del IMC según */
        switch (clasificacion) {
            case "Peso Normal":
                vista.getLblClasificacion().setForeground(new Color(0, 150, 0));
                break;
            case "Bajo Peso":
            case "Sobrepeso":
                vista.getLblClasificacion().setForeground(Color.ORANGE);
                break;
            case "Obesidad":
                vista.getLblClasificacion().setForeground(Color.RED);
                break;
            default:
                vista.getLblClasificacion().setForeground(Color.BLACK);
                break;
        }
    }
}
