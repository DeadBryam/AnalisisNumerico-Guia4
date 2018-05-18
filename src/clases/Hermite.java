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
public class Hermite {

    public Hermite() {
    }

    /**
     * Este metodo sirve para armar un polinomio a partir de pares ordenados.
     *
     * @param x Espera un arreglo de double donde esten las "x".
     * @param y Espera un arreglo de double donde esten las "y".
     * @param fx Espera un arreglo de double donde esten las "x" derivadas.
     * @return El polonomio de hermite.
     */
    public String getHermite(double x[], double y[], double fx[]) {
        return new Evaluar().armarPolinomio(x, y, fx);
    }
}
