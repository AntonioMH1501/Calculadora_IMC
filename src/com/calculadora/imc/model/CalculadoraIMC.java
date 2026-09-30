
package com.calculadora.imc.model;

/**
 *
 * @author Antonio Muñoz Herrera
 */
public class CalculadoraIMC {
    
    double peso, altura, imc;
    String textoDevuelto;
    
    public double calcular(double peso, double altura){
        imc = peso / (altura * altura);
        return imc;
    }
    
    public String clasificar(double imc){
        if(imc < 18.5){
            textoDevuelto = "Bajo Peso";
        }else if(imc < 24.9){
            textoDevuelto = "Peso Normal";
        }else if(imc < 29.9){
            textoDevuelto = "Sobrepeso";
        }else if(imc >= 30){
            textoDevuelto = "Obesidad";
        }
        
        return textoDevuelto;
    }
}
