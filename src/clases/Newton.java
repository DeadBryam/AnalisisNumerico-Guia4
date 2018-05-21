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
public class Newton {

    Evaluar ev = new Evaluar();
    
    public List<Double> calcularB(double[] x, double[] y) {
        List<Double> b = new ArrayList<>();
        b.add(y[0]);
        for (int i = 0; i < x.length - 1; i++) {
            switch (i) {
                case 0:
                    b.add((y[i + 1] - y[i]) / (x[i + 1] - x[i]));
                    break;
                case 1:
                    b.add((((y[i + 1] - y[i]) / (x[i + 1] - x[i])) - b.get(i)) / (x[i + 1] - x[i - 1]));
                    break;
                case 2:
                    b.add((((((y[i + 1] - y[i]) / (x[i + 1] - x[i])) - ((y[i] - y[i - 1])
                            / (x[i] - x[i - 1]))) / (x[i + 1] - x[i - 1])) - b.get(i))
                            / (x[i + 1] - x[i - 2]));
                    break;
                case 3:
                    b.add((((((((y[i + 1] - y[i]) / (x[i + 1] - x[i])) - ((y[i] - y[i - 1]) / (x[i] - x[i - 1])))
                            / (x[i + 1] - x[i - 1])) - (((y[i] - y[i - 1]) / (x[i] - x[i - 1])) - ((y[i - 1] - y[i - 2])
                            / (x[i - 1] - x[i - 2]))) / (x[i] - x[i - 2]))
                            / (x[i + 1] - x[i - 2])) - b.get(i)) / (x[i + 1] - x[i - 3]));
            }
        }
        return b;
    }
    
    public String getNewton(double x[], double y[]){
        return ev.armarPolinomioFormulaNewton(x, y, calcularB(x, y));
    }
}
