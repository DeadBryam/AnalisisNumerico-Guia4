/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.DiferenciasDivididas;
import clases.Evaluar;
import clases.Hermite;
import clases.Lagrange;
import clases.Multiplicar;
import clases.Newton;
import java.util.Arrays;

/**
 *
 * @author bryan
 */
public class form extends javax.swing.JFrame {

    Evaluar ev = new Evaluar();
    Newton ne = new Newton();
    /**
     * Creates new form form
     */
    public form() {
        initComponents();
        llenarTbl();
        System.out.println(ne.getNewton(new double[]{2.0,3.0,5.0,7.0}, new double[]{5.0,4.0,6.0,8.0}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        btnLagranja = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><p align=\"center\">El censo de una poblacion de una determinada <br>ciudad proporciona los siguientes datos del <br> numero de habitantes en diferentes anios<p></html>");

        tblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Anios", "Poblacion", "Datos para hermite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblMain);

        btnLagranja.setText("Lagrange");
        btnLagranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLagranjaActionPerformed(evt);
            }
        });

        jButton2.setText("Newton");

        jButton3.setText("Hermite");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Diferencias divididas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Trazadores cubicos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnLagranja)
                            .addGap(65, 65, 65)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton4)
                        .addGap(30, 30, 30)
                        .addComponent(jButton5)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLagranja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 310));

        tblRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Anios", "Poblacion", "Error"
            }
        ));
        jScrollPane3.setViewportView(tblRes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTbl() {
        double x[] = {1910, 1930, 1950, 1960, 1980}, y[] = {125350, 133420, 117183, 120323, 145311}, z[] = {1964, 2000, 2010, 2018};
        for (int i = 0; i < x.length; i++) {
            tblMain.setValueAt(x[i], i, 0);
            tblMain.setValueAt(y[i], i, 1);
        }
        for (int i = 0; i < z.length; i++) {
            tblRes.setValueAt(z[i], i, 0);
        }
    }

    private void btnLagranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLagranjaActionPerformed
        jPanel1.show(false);
        jPanel2.show();
        double x[] = new double[tblMain.getRowCount()], y[] = new double[tblMain.getRowCount()];
        Lagrange lg = new Lagrange();
        String polinomio;

        for (int i = 0; i < tblMain.getRowCount(); i++) {
            x[i] =  (double) tblMain.getModel().getValueAt(i, 0);
            y[i] = (double) tblMain.getModel().getValueAt(i, 1);
        }

        polinomio = new Multiplicar().reducirToString(lg.getLn(x, y));

        for (int i = 0; i < tblRes.getRowCount(); i=i+2) {
            System.out.println((double) tblRes.getValueAt(i, 0));
            tblRes.setValueAt(ev.evaluarFuncion(Double.parseDouble(String.valueOf(tblRes.getValueAt(i, 0))), polinomio), i, 1);
            tblRes.setValueAt(ev.getErrorLagrange(x, y, Double.parseDouble(String.valueOf(tblRes.getValueAt(i, 0)))), i, 2);
        }

    }//GEN-LAST:event_btnLagranjaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jPanel1.show(false);
        jPanel2.show();
        double x[] = new double[tblMain.getRowCount()], y[] = new double[tblMain.getRowCount()];
        DiferenciasDivididas dd = new DiferenciasDivididas();
        String polinomio;

        for (int i = 0; i < tblMain.getRowCount(); i++) {
            x[i] = (double) tblMain.getModel().getValueAt(i, 0);
            y[i] = (double) tblMain.getModel().getValueAt(i, 1);
        }

        polinomio = dd.getDiferenciasDivididas(x, y);

        for (int i = 0; i < tblRes.getRowCount(); i++) {
            System.out.println((double) tblRes.getValueAt(i, 0));
            tblRes.setValueAt(ev.evaluarFuncion(Double.parseDouble(String.valueOf(tblRes.getValueAt(i, 0))), polinomio), i, 1);
            tblRes.setValueAt(ev.getErrorInterpolacion(x, y, Double.parseDouble(String.valueOf(tblRes.getValueAt(i, 0))), polinomio), i, 2);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jPanel1.show(false);
        jPanel2.show();
    //    double x[] = new double[tblMain.getRowCount() * 2], y[] = new double[tblMain.getRowCount() * 2], z[] = new double[tblMain.getRowCount()];
        double x[] = {1910.0, 1910.0, 1930.0, 1930.0, 1950.0, 1950.0, 1960.0, 1960.0, 1980.0, 1980.0}, y[] = {125350.0, 125350.0, 133420.0, 133420.0, 117183.0, 117183.0, 120323.0, 120323.0, 145311.0, 145311.0},z[] = {1964,2000,2010,2018,2020};
        Hermite hr = new Hermite();
        String polinomio;
//
//        for (int i = 1; i <= tblMain.getRowCount(); i++) {
//            x[(i-1)*2] = (double) tblMain.getModel().getValueAt(i-1, 0);
//            x[(i*2)-1] = (double) tblMain.getModel().getValueAt(i-1, 0);
//            y[(i-1)*2] = (double) tblMain.getModel().getValueAt(i-1, 1);
//            y[(i*2)-1] = (double) tblMain.getModel().getValueAt(i-1, 1);
//            z[i-1] = (double) tblMain.getModel().getValueAt(i-1, 2);
//            System.out.println(i+" "+tblMain.getModel().getValueAt(i-1, 2));
//        }
        
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(z));
        polinomio = hr.getHermite(x, y, z);

        for (int i = 0; i < tblRes.getRowCount(); i++) {
            System.out.println((double) tblRes.getValueAt(i, 0));
            tblRes.setValueAt(ev.evaluarFuncion(Double.parseDouble(String.valueOf(tblRes.getValueAt(i, 0))), polinomio), i, 1);
            tblRes.setValueAt(ev.getErrorInterpolacion(x, y, Double.parseDouble(String.valueOf(tblRes.getValueAt(i, 0))), polinomio), i, 2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLagranja;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblMain;
    private javax.swing.JTable tblRes;
    // End of variables declaration//GEN-END:variables
}
