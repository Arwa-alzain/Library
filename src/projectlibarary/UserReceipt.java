/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectlibarary;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author shenz
 */
public class UserReceipt extends javax.swing.JDialog {

 
    public UserReceipt(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Receipts");
    }
    
    public void displayBorrowingReceipt(BorrowingData borrowingData) {

        jLabel3.setText(borrowingData.getUserID());
        jLabel4.setText(borrowingData.getUserID());
        jLabel13.setText(borrowingData.getBookID());
        jLabel20.setText(borrowingData.getBookID());
        jLabel18.setText(borrowingData.getBorrowingID());
        jLabel23.setText(borrowingData.getBorrowingID());
        jLabel10.setText(borrowingData.getBorrowDate());
        jLabel19.setText(borrowingData.getReturnDate());
        jLabel29.setText(borrowingData.getCalculatedReturnDate());
        jLabel25.setText(borrowingData.getTitle());
        jLabel27.setText(borrowingData.getTitle());
        jLabel17.setText(borrowingData.getAllowedBorrowRange());
        jLabel6.setVisible(false);


        if (borrowingData.getReturnDate() == null || borrowingData.getReturnDate().isEmpty()) {

        SwingUtilities.invokeLater(new Runnable() {
            
        public void run() {
            jLabel26.setVisible(false);
            jLabel27.setVisible(false);
            jLabel12.setVisible(false);
            jLabel4.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            jLabel20.setVisible(false);
            jLabel23.setVisible(false);
            jLabel19.setVisible(false);
            jLabel2.setVisible(false);
            jLabel6.setVisible(true);

            jPanel2.revalidate();
            jPanel2.repaint();
        }
    });
}

    

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(250, 247, 240));
        jPanel2.setMinimumSize(new java.awt.Dimension(395, 395));
        jPanel2.setPreferredSize(new java.awt.Dimension(395, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(177, 116, 87));
        jLabel8.setText("- Thank You For Borrowing From IQRAA - ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("-");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("-");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setText("User ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jLabel5.setBackground(new java.awt.Color(177, 116, 87));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(177, 116, 87));
        jLabel5.setText("Borrowing Receipt :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 194, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel7.setText("Book ID:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("-");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel9.setText("Borrow Range:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("-");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("-");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel14.setText("Borrowing ID:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(177, 116, 87));
        jLabel22.setText("Returning Receipt :");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 194, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 580, 10));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("User ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("-");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel16.setText("Retuen Date:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 80, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("-");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 80, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("-");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel12.setText("Book ID:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel15.setText("Borrowing ID:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("-");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, -1, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel24.setText("Book Title:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("-");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel26.setText("Book Title:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("-");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel28.setText("Deadline:");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel29.setText("-");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel30.setText("Borrow Date:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 580, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Book Not Returned Yet.");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserReceipt dialog = new UserReceipt(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
