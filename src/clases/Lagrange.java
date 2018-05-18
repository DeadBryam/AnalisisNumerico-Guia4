/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class Lagrange {

        public Lagrange() {
        }

        /**
         * Este metodo sirve para obtener las Ln.
         * @param x Espera un arreglo de double donde esten las "x".
         * @param y Espera un arreglo de double donde esten las "y".
         * @return Un arreglo de string que contiene los Ln.
         */
        public String[] getLn(double[] x, double[] y) {
            final String base = "(x-#)";
            String[] ln = new String[x.length];

            for (int i = 0; i < ln.length; i++) {
                ln[i] = String.valueOf(y[i]);
                for (int j = 0; j < x.length; j++) {
                    if (i != j) {
                        ln[i] += base.replace("#", String.valueOf(x[j])).replace("--", "+");
                    }
                }
                ln[i] += "/";
                for (int k = 0; k < x.length; k++) {
                    if (i != k) {
                        ln[i] += (new StringBuilder(base).reverse().toString()).replace("#", String.valueOf(x[i])).replace("x", String.valueOf(x[k])).replaceAll("--", "+").replaceAll("[(]", ")").replaceAll("[)]\\b", "(").replaceAll("[)]-", "(-");
                    }
                }
            }
            return ordenar(ln);
        }

        /**
         * Este metodo sirve para dividir las funciones y dejarlas de una manera mas entendible.
         * @param funcion Espera una funcion de la forma a(x-x0)(x-x1)...(x-xn) / (xi-x0)(xi-x1)...(xi-xn).
         * @return Los mismos polinomios pero con el coeficiente operado.
         */
        public String splitear(String funcion) {
            double suma = 1, fx;
            String[] nums = funcion.split("/")[1].replaceAll("--", "+").replaceAll("^[(]", "").replaceAll("[)]$", "").split("[)][(]");
            for (String num : nums) {
                String[] pol = num.replace("--", "+").replaceAll("[+]", " +").replaceAll("[-]", " -").trim().split(" ");
                suma *= (Double.parseDouble(pol[0]) + Double.parseDouble(pol[1]));
            }
            fx = Double.parseDouble(funcion.replaceAll("[(].*[)]", ""));

            if (fx != 0) {
                // System.out.println(String.valueOf(new evaluar().Evaluar(fx, "x/"+funcion.split("/")[1].replaceAll("--", "+")))+ funcion.split("/")[0].replaceAll("^\\d+.\\d+", ""));;
                return fx / suma + funcion.split("/")[0].replaceAll("^\\d+.\\d+", "");
            }
            return null;
        }

        /**
         * Este metodo ordenar los polinomios para luego ser operados o reducidos.
         * @param ln Un arreglo de string que contenga funciones de la forma a(x-x0)(x-x1)...(x-xn) / (xi-x0)(xi-x1)...(xi-xn).
         * @return Los polinomios reducidos.
         */
        public String[] ordenar(String[] ln) {
            List<String> lnCambiado = new ArrayList<>();
            for (String string : ln) {
                if (splitear(string) != null) {
                    lnCambiado.add(splitear(string));
                }
            }
            return lnCambiado.toArray(new String[lnCambiado.size()]);
        }
    
}
