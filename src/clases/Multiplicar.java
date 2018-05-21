/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bryan
 */
public class Multiplicar {

    public Multiplicar() {
    }

    /**
     * Este metodo sirve para multiplicar polinomios.
     *
     * @param tamanio Resive el tamanio de polinomios a multiplicar.
     * @param polinomios Resive un string con polinomios de la forma
     * a(x-xo)(x-x1)...(x-xn).
     * @return Retorna la reduccion de los metodos.
     */
    public String[] multPolinomios(int tamanio, String polinomios) {
        String[] polSeparados = polinomios.replaceAll("^[+//-]\\d+.\\d+[E][+//-]\\d+", "").replaceAll("^[+//-]\\d+.\\d+", "").replaceAll("^\\d+.\\d+", "").replaceAll("^[(]", "").replaceAll("[)]$", "").split("[)][(]");
        String[] separados, resul;
        List<String[]> modificados = new ArrayList<>();
        List<String> polRes;
        String[][] mult = new String[2][tamanio];
        double coeficiente;

        for (String separado : polSeparados) {
            separados = separado.replace("+", " +").replace("-", " -").split(" ");
            separados[0] = separados[0].replaceAll("[x][x^]\\d+", "").replace("x", "");
            if (separados[0].isEmpty() || separados[0].equals("-") || separados[0].equals("+")) {
                separados[0] = "1";
            }
            modificados.add(separados);
        }

        //calcular polinomio sin la x
        resul = modificados.get(0);
        for (int i = 1; i < modificados.size(); i++) {
            polRes = new ArrayList<>();
            for (int j = 0; j < resul.length; j++) {
                mult[0][j] = String.valueOf(Double.parseDouble(resul[j]) * Double.parseDouble(modificados.get(i)[0]));
                mult[1][j + 1] = String.valueOf(Double.parseDouble(resul[j]) * Double.parseDouble(modificados.get(i)[1]));
            }
            polRes.add(String.valueOf(mult[0][0]));
            for (int j = 1; j < resul.length; j++) {
                polRes.add(String.valueOf(Double.parseDouble(mult[0][j]) + Double.parseDouble(mult[1][j])));
            }
            polRes.add(mult[1][resul.length]);
            resul = polRes.toArray(new String[polRes.size()]);;
        }

        //multiplicar coeficientes vacio
        coeficiente = Double.parseDouble(polinomios.replaceAll("[(].*[)]", ""));
        for (int i = 0; i < resul.length; i++) {
            resul[i] = String.valueOf(Double.parseDouble(resul[i]) * coeficiente);
        }

        //agregar X
        return agregarX(resul);
    }

    /**
     * Este metodo sirve para agregar las "x" a un polinomio.
     * @param resul Espera un arreglo de String de esta forma [1 , 3.45, 234325, 3.444 ].
     * @return El mismo arreglo pero con las "x" incluidas.
     */
    public String[] agregarX(String[] resul) {
        for (int i = 0; i < resul.length; i++) {
            if (i < resul.length - 2) {
                resul[i] += ("x^" + String.valueOf(resul.length - (i + 1)));
            } else if (i < resul.length - 1) {
                resul[i] += ("x");
            }
        }
        return resul;
    }

    /**
     * Este metodo sirve para simplificar los Ln de el metodo de lagrange.
     * @param lns Espera un arreglo de String que contenta polinomios de la siguente forma en cada espacio a(x-x0)(x-x1)...(x-xn).
     * @return Retorna un arreglo con los polinomios reducidos.
     */
    public String[] reducir(String[] lns) {
        int tamanio = lns.length + 1;
        List<String[]> redux = new ArrayList<>();
        Double[] reducido = new Double[tamanio - 1];
        String[] s = new String[reducido.length];

        for (String ln : lns) {
            redux.add(multPolinomios(tamanio, ln));
        }

        for (int i = 0; i < redux.size(); i++) {
            reducido[lns.length - (i + 1)] = 0.0;
            for (int j = 0; j < redux.size(); j++) {
                int t = redux.get(j).length - (i + 1);
                if (t >= 0) {
                    reducido[lns.length - (i + 1)] += Double.parseDouble(redux.get(j)[t].replaceAll("[x][x^]\\d+", "").replaceAll("x", ""));
                }
            }
        }

        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(reducido[i]);
        }
        return agregarX(s);
    }

    /**
     * Este metodo sirve para simplificar los Ln de el metodo de lagrange.
     * @param lns Espera un arreglo de String que contenta polinomios de la siguente forma en cada espacio a(x-x0)(x-x1)...(x-xn).
     * @return Retorna un String con los polinomios reducidos.
     */
    public String reducirToString(String[] lns) {
        String[] aString = reducir(lns);
        String funcionStrong = "";
        for (String string : aString) {
            if (string.contains("-")) {
                funcionStrong += string;
            } else {
                funcionStrong += "+" + string;
            }
        }
        return funcionStrong;
    }

}
