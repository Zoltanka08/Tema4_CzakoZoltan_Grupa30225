/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4_czakozoltan_grupa30225;

import javax.swing.JOptionPane;

/**
 *
 * @author Zoli
 */

public class AccountViewer extends javax.swing.JFrame {

    /**
     * Creates new form AccountViewer
     */
    
    private RetragereNumerar retragere = new RetragereNumerar();
    
    public AccountViewer() {
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

        AccountContentLabel = new javax.swing.JLabel();
        InterogareSoldButton = new javax.swing.JButton();
        RetragereNumerarButton = new javax.swing.JButton();
        CerereChitantaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATM");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AccountContentLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        AccountContentLabel.setText("0 RON");
        getContentPane().add(AccountContentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 174, 87));

        InterogareSoldButton.setText("Inerogare Sold");
        InterogareSoldButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InterogareSoldButtonMouseClicked(evt);
            }
        });
        getContentPane().add(InterogareSoldButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 58, 125, -1));

        RetragereNumerarButton.setText("Retragere Numerar");
        RetragereNumerarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RetragereNumerarButtonMouseClicked(evt);
            }
        });
        getContentPane().add(RetragereNumerarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 120, -1, -1));

        CerereChitantaButton.setText("Cerere Chitanta");
        CerereChitantaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerereChitantaButtonMouseClicked(evt);
            }
        });
        getContentPane().add(CerereChitantaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 179, 125, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atm.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 260, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InterogareSoldButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InterogareSoldButtonMouseClicked
        this.AccountContentLabel.setText(ATM.getAccount().getValue() + " RON");
    }//GEN-LAST:event_InterogareSoldButtonMouseClicked

    private void RetragereNumerarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RetragereNumerarButtonMouseClicked
        this.retragere.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_RetragereNumerarButtonMouseClicked

    private void CerereChitantaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerereChitantaButtonMouseClicked
        Bank.generateReceipt(ATM.getAccount());
        JOptionPane.showMessageDialog(null, "A receipt has been created  successfully!",
					  "Success", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_CerereChitantaButtonMouseClicked

    /**
     * @param args the command line arguments
     */
 /*   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
     /*   try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountViewer().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountContentLabel;
    private javax.swing.JButton CerereChitantaButton;
    private javax.swing.JButton InterogareSoldButton;
    private javax.swing.JButton RetragereNumerarButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}