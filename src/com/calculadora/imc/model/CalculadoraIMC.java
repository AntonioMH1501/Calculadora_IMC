
package com.calculadora.imc.model;

/**
 *
 * @author Antonio Muñoz Herrera
 */
public class CalculadoraIMC {
    
    double peso, altura, imc;
    
    public double calcular(double peso, double altura){
        imc = peso / (altura * altura);
        return imc;
    }
    
    public String clasificar(double imc){
        
    }
}
