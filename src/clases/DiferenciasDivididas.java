/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author bryan
 */
public class DiferenciasDivididas {

    public DiferenciasDivididas() {
    }

    /**
     * Este metodo sirve para armar un polinomio a partir de pares ordenados.
     *
     * @param x Espera un arreglo de double donde esten las "x".
     * @param y Espera un arreglo de double donde esten las "y".
     * @return El polinomio de diferencias divididas.
     */
    public String getDiferenciasDivididas(double x[], double y[]) {
        return new Evaluar().armarPolinomio(x, y);
    }

}
