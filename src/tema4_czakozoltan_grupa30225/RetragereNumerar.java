/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4_czakozoltan_grupa30225;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Zoli
 */
public class RetragereNumerar extends javax.swing.JFrame {

    /**
     * Creates new form RetragereNumerar
     */
    
    private Chitanta chitanta = new Chitanta();
    private static double value = 0;
    
    public RetragereNumerar() {
        this.setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Button10 = new javax.swing.JButton();
        Button20 = new javax.swing.JButton();
        Button50 = new javax.swing.JButton();
        Button100 = new javax.swing.JButton();
        Button200 = new javax.swing.JButton();
        Button500 = new javax.swing.JButton();
        OKButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SumaText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Retragere Numerar");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button10.setText("10");
        Button10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button10MouseClicked(evt);
            }
        });
        getContentPane().add(Button10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));

        Button20.setText("20");
        Button20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button20MouseClicked(evt);
            }
        });
        getContentPane().add(Button20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        Button50.setText("50");
        Button50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button50MouseClicked(evt);
            }
        });
        getContentPane().add(Button50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 178, -1, -1));

        Button100.setText("100");
        Button100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button100MouseClicked(evt);
            }
        });
        getContentPane().add(Button100, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 52, -1, -1));

        Button200.setText("200");
        Button200.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button200MouseClicked(evt);
            }
        });
        getContentPane().add(Button200, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 115, -1, -1));

        Button500.setText("500");
        Button500.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button500MouseClicked(evt);
            }
        });
        getContentPane().add(Button500, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 178, -1, -1));

        OKButton.setText("OK");
        OKButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKButtonMouseClicked(evt);
            }
        });
        getContentPane().add(OKButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 266, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Alta Suma:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));
        getContentPane().add(SumaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 111, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numerar.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button10MouseClicked
        this.value = 10.00;
        try {
            ATM.getAccount().withdrawMoney((double) 10.00);
            this.chitanta.setVisible(true);
            this.setVisible(false);
        } catch (InsufficientMoneyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Error r){
            JOptionPane.showMessageDialog(null, r.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Button10MouseClicked

    private void Button20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button20MouseClicked
        this.value = 20.00;
        try {
            ATM.getAccount().withdrawMoney((double) 20.00);
            this.chitanta.setVisible(true);
            this.setVisible(false);
        } catch (InsufficientMoneyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Error r){
            JOptionPane.showMessageDialog(null, r.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_Button20MouseClicked

    private void Button50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button50MouseClicked
        this.value = 50.00;
        try {
            ATM.getAccount().withdrawMoney((double) 50.00);
            this.chitanta.setVisible(true);
            this.setVisible(false);
        } catch (InsufficientMoneyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Error r){
            JOptionPane.showMessageDialog(null, r.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Button50MouseClicked

    private void Button100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button100MouseClicked
        this.value = 100.00;
        try {
            ATM.getAccount().withdrawMoney((double) 100.00);
            this.chitanta.setVisible(true);
            this.setVisible(false);
        } catch (InsufficientMoneyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Error r){
            JOptionPane.showMessageDialog(null, r.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Button100MouseClicked

    private void Button200MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button200MouseClicked
        this.value = 200.00;
        try {
            ATM.getAccount().withdrawMoney((double) 200.00);
            this.chitanta.setVisible(true);
            this.setVisible(false);
        } catch (InsufficientMoneyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Error r){
            JOptionPane.showMessageDialog(null, r.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Button200MouseClicked

    private void Button500MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button500MouseClicked
        this.value = 500.00;
        try {
            ATM.getAccount().withdrawMoney((double) 500.00);
            this.chitanta.setVisible(true);
            this.setVisible(false);
        } catch (InsufficientMoneyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Error r){
            JOptionPane.showMessageDialog(null, r.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Button500MouseClicked

    private void OKButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKButtonMouseClicked
        double value;
        
        try
        {
            value = Double.parseDouble(this.SumaText.getText());
            this.value = value;
            ATM.getAccount().withdrawMoney(value);
            this.chitanta.setVisible(true);
            this.setVisible(false);
        }catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InsufficientMoneyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }catch (Error r){
            JOptionPane.showMessageDialog(null, r.getMessage(),
					  "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OKButtonMouseClicked

    public static double getValue()
    {
        return value;
    }
    
    /**
     * @param args the command line arguments
     */
 /*   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RetragereNumerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RetragereNumerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RetragereNumerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RetragereNumerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
   /*     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RetragereNumerar().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button10;
    private javax.swing.JButton Button100;
    private javax.swing.JButton Button20;
    private javax.swing.JButton Button200;
    private javax.swing.JButton Button50;
    private javax.swing.JButton Button500;
    private javax.swing.JButton OKButton;
    private javax.swing.JTextField SumaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
