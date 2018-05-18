/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author bryan
 */
public class Evaluar {

    JEP jp = new JEP();

    public Evaluar() {
        jp.addStandardFunctions();
        jp.addStandardConstants();
        jp.addComplex();
        jp.setImplicitMul(true);
    }

    /**
     * Este metodo sirve para evaluar una funcion.
     *
     * @param valor El valor que tomara la variable x.
     * @param funcion La funcion que debe ir en funcion de x.
     * @return El valor da la funcion ya evaluadada.
     */
    public double evaluarFuncion(double valor, String funcion) {
        jp.addVariable("x", valor);
        jp.parseExpression(funcion);
        return jp.getValue();
    }

    /**
     * Este metodo sirve para obtener el valos de n factorial.
     *
     * @param numero Espera el numero de el cual se obtendra el factorial.
     * @return El factorial de el numero.
     */
    public long factorial(int numero) {
        long factorial = 1;
        while (numero != 0) {
            factorial *= numero;
            numero--;
        }
        return factorial;
    }

    /**
     * Este metodo sirve para calcular el error teorico de Lagrange
     *
     * @param x Espera un arreglo con los valores de x.
     * @param y Espera un arreglo con los valores de y.
     * @param valor Espera el valor de la funcion.
     * @return El error teorico.
     */
    public double getErrorLagrange(double[] x, double[] y, double valor) {
        String base = "(c-x)", error = "(fn/t)";

        for (int i = 0; i < x.length; i++) {
            error += (base.replace("c", String.valueOf(valor)).replace("x", String.valueOf(x[i])));
        }

        error = error.replaceAll("t", String.valueOf(factorial(x.length)));
        return evaluarFuncion(y[y.length - 1], error.replaceAll("fn", "x"));
    }

    /**
     * Este metodo sirve para calcular el error teorico de interpolacion.
     *
     * @param x Espera un arreglo con los valores de x.
     * @param y Espera un arreglo con los valores de y.
     * @param valor Espera el valor de la funcion.
     * @param funcion Espera la funcion.
     * @return El error teorico de interpolacion.
     */
    public double getErrorInterpolacion(double[] x, double[] y, double valor, String funcion) {
        Evaluar ev = new Evaluar();
        double res;
        String base = "(c-x)", error = "(fx)", rs[];

        for (int i = 0; i < x.length; i++) {
            error += (base.replace("c", String.valueOf(valor)).replace("x", String.valueOf(x[i])));
        }
        try {
            res = ev.evaluarFuncion(Double.parseDouble(funcion.replaceAll("[x].*", "")), error.replaceAll("fx", "x"));
        } catch (NumberFormatException e) {
            rs = funcion.split(" ");
            double r = Double.parseDouble(rs[rs.length - 1].replaceAll("[(].*[)]", ""));
            res = ev.evaluarFuncion(r, error.replaceAll("fx", "x"));
        }
        return res;
    }

    /**
     * Este metodo sirve para derivar.
     *
     * @param funcion Espera la funcion cual derivar.
     * @return La funcion derivada.
     */
    public String Derivada(String funcion) {
        String derivada = "";
        DJep dj = new DJep();

        dj.addStandardConstants();
        dj.addStandardFunctions();
        dj.addComplex();
        dj.setAllowUndeclared(true);
        dj.setAllowAssignment(true);
        dj.setImplicitMul(true);
        dj.addStandardDiffRules();

        try {
//                Node nd = dj.parse(funcion);
//                Node diff = dj.differentiate(nd,"x");
//                Node sim = dj.simplify(diff);
//                dj.println(sim);

            Node nd = dj.parse("diff (" + funcion + ", x)");
            Node s = dj.simplify(dj.preprocess(nd));
            derivada = dj.toString(s);

        } catch (ParseException e) {
            System.out.println(e);
        }

        return derivada;
    }

    /**
     * Este metodo sirve para derivar valores de un arreglo de double.
     *
     * @param x Espera un arreglo de double.
     * @param funcion Espera la funcion a derivar.
     * @return Un arreglo de double de la funcion derivada evaluada con x.
     */
    public double[] getArrayDerivada(double[] x, String funcion) {
        String derivada = Derivada(funcion);
        double[] derivados = new double[x.length];

        for (int i = 0; i < x.length; i++) {
            derivados[i] = evaluarFuncion(x[i], derivada);
        }

        return derivados;
    }

    /**
     * Este metodo sirve para crear una matriz.
     *
     * @param x Espera un arreglo que contenga los valores de "x"
     * @param y Espera un arreglo que contenga los valores de "x"
     * @return La matriz modificada para ocuparla.
     */
    public double[][] crearMatriz(double[] x, double[] y) {
        double[][] Matriz = new double[x.length + 1][x.length];
        for (int i = 0; i < x.length; i++) {
            Matriz[0][i] = x[i];
            Matriz[1][i] = y[i];
        }
        return Matriz;
    }

    /**
     * ESte metodo sirve para calcular las "b".
     *
     * @param x Espera un arreglo de double donde esten las "x".
     * @param y Espera un arreglo de double donde esten las "y".
     * @param fx Espera un arreglo de double donde esten las "x" derivadas.
     * @return Las "b" calculadas.
     */
    public double[] calcularB(double[] x, double[] y, double[] fx) {
        int ifx = 0;
        double Matriz[][] = crearMatriz(x, y), bn[] = new double[x.length];

        for (int i = 2, k = 1; i <= x.length; i++, k++) {
            for (int j = i - 1; j < x.length; j++) {
                if ((Matriz[i - 1][j] - Matriz[i - 1][j - 1]) == 0 && (Matriz[0][j] - Matriz[0][j - k]) == 0) {
                    Matriz[i][j] = fx[ifx];
                    ifx++;
                } else {
                    Matriz[i][j] = (Matriz[i - 1][j] - Matriz[i - 1][j - 1]) / (Matriz[0][j] - Matriz[0][j - k]);
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            bn[i] = Matriz[i + 1][i];
        }

        return bn;
    }

    /**
     * ESte metodo sirve para calcular las "b".
     *
     * @param x Espera un arreglo de double donde esten las "x".
     * @param y Espera un arreglo de double donde esten las "y".
     * @return Las "b" calculadas.
     */
    public double[] calcularB(double[] x, double[] y) {
        double Matriz[][] = crearMatriz(x, y), bn[] = new double[x.length];

        for (int i = 2, k = 1; i <= x.length; i++, k++) {
            for (int j = i - 1; j < x.length; j++) {
                Matriz[i][j] = (Matriz[i - 1][j] - Matriz[i - 1][j - 1]) / (Matriz[0][j] - Matriz[0][j - k]);
            }
        }

        for (int i = 0; i < x.length; i++) {
            bn[i] = Matriz[i + 1][i];
        }

        return bn;
    }

    /**
     * Este metodo sirve para armar un polinomio a partir de pares ordenamos
     * (usando derivadas).
     *
     * @param x Espera un arreglo de double donde esten las "x".
     * @param y Espera un arreglo de double donde esten las "y".
     * @param fx Espera un arreglo de double donde esten las "x" derivadas.
     * @return El polonomio calculado.
     */
    public String armarPolinomio(double[] x, double[] y, double[] fx) {
            final String base = "(x-#)";
            String polinomio = "", polis[], piv;
            double[] bn = calcularB(x, y, fx);

            for (int i = 0; i < x.length; i++) {
                if (bn[i] < 0) {
                    polinomio += " " + bn[i];
                } else {
                    polinomio += " +" + bn[i];
                }

                for (int j = 0; j < i; j++) {
                    if (bn[i] != 0) {
                        polinomio += base.replace("#", String.valueOf(x[j])).replace("--", "+");
                    }
                }
            }
            polis = polinomio.replaceAll("^ [+]", "").split(" ");

            try {
                piv = new Multiplicar().reducirToString(polis);
            } catch (Exception e) {
                System.out.println(e);
                return polinomio;
            }
            return piv;
        }

    /**
     * Este metodo sirve para armar un polinomio a partir de pares ordenamos
     * (usando derivadas).
     *
     * @param x Espera un arreglo de double donde esten las "x".
     * @param y Espera un arreglo de double donde esten las "y".
     * @return El polonomio calculado.
     */
    public String armarPolinomio(double[] x, double[] y) {
        final String base = "(x-#)";
        String polinomio = "", polis[];
        double[] bn = calcularB(x, y);

        for (int i = 0; i < x.length; i++) {
            if (bn[i] < 0) {
                polinomio += " " + bn[i];
            } else {
                polinomio += " +" + bn[i];
            }

            for (int j = 0; j < i; j++) {
                if (bn[i] != 0) {
                    polinomio += base.replace("#", String.valueOf(x[j])).replace("--", "+");
                }
            }
        }
        polis = polinomio.replaceAll("^ [+]", "").split(" ");
        return new Multiplicar().reducirToString(polis);
    }
}
