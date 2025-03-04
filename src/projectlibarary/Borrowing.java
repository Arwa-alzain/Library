/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectlibarary;

import projectlibarary.SearchBooks3;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class Borrowing extends javax.swing.JFrame {
    Connection con;
    private int userId, bookId;
    private String title;
    private SearchBooks3 parentclass;
    /**
     * Creates new form Borrowing
     */
    public Borrowing(SearchBooks3 parentclass,int userId, int bookId, String title) {
        
        this.parentclass = parentclass;
        this.userId=userId;
        this.bookId=bookId;
        this.title=title;
        initComponents();
        try {
            String driverPath = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driverPath);
            String PathToDatabase = "DB\\DatabaseFinal.accdb";
            String url = "jdbc:ucanaccess://" + PathToDatabase;
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(Borrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if (con == null){
            JOptionPane.showMessageDialog(this, "Database connection is not established.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setLocationRelativeTo(null);
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1Confirm = new javax.swing.JButton();
        jButton2cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Choose the desired time limit of days to borrow the book");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3-7", "8-15", "16-30" }));

        jButton1Confirm.setBackground(new java.awt.Color(177, 116, 87));
        jButton1Confirm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1Confirm.setForeground(new java.awt.Color(255, 255, 255));
        jButton1Confirm.setText("Confirm");
        jButton1Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ConfirmActionPerformed(evt);
            }
        });

        jButton2cancel.setBackground(new java.awt.Color(177, 116, 87));
        jButton2cancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2cancel.setForeground(new java.awt.Color(255, 255, 255));
        jButton2cancel.setText("Cancel");
        jButton2cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jButton1Confirm)
                                .addGap(46, 46, 46)
                                .addComponent(jButton2cancel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1Confirm)
                    .addComponent(jButton2cancel))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ConfirmActionPerformed
        // TODO add your handling code here:
        String timeLimit = (String) jComboBox1.getSelectedItem();
        java.sql.Date  borrowDate = new java.sql.Date(System.currentTimeMillis());//current date
        int dayrange = DayRange(timeLimit);
        java.sql.Date returnDate = calcReturnDate(borrowDate,dayrange);//calc return date
        if (timeLimit == null || bookId == 0) {
        JOptionPane.showMessageDialog(this, "Invalid borrowing data.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
        String query = "INSERT INTO [Borrowing Data] (UserID, BookID, Title, BorrowDate, Status, AllowedBorrowRange, CalculatedReturnDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, bookId);
            stmt.setString(3, title);
            stmt.setDate(4, borrowDate); //current date
            stmt.setString(5, "Borrowed"); //set status to Borrowed
            stmt.setString(6, timeLimit);
            stmt.setDate(7, returnDate);
            stmt.executeUpdate(); 
            editavailability(bookId);//change the availability
            if(parentclass != null){
            parentclass.updateStatus("Checked Out");
            }
            JOptionPane.showMessageDialog(this, "Borrowing process completed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error confirming borrowing: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ConfirmActionPerformed
    private void resetBookData(){//to abel borrowing books to time in the same running
        bookId = 0;
        title = "";
    }
    private int DayRange(String timeLimit){//split the range and take the large num
        String[] range = timeLimit.split("-");
        int dayrange = Integer.parseInt(range[1].trim());
        return dayrange;
    }
    private java.sql.Date calcReturnDate(java.sql.Date borrowDate, int dayrange){//calc the return date
        Calendar cal = Calendar.getInstance();
        cal.setTime(borrowDate);
        cal.add(Calendar.DAY_OF_MONTH, dayrange);
        return new java.sql.Date(cal.getTimeInMillis());
    }
    private void jButton2cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2cancelActionPerformed
    private void editavailability(int BookId){//edit the state after borrowing
        String query = "UPDATE [Books Data] SET Availability = 'Checked Out' WHERE BookID = ?";
        try(PreparedStatement stmt = con.prepareStatement(query)){
            stmt.setInt(1, BookId);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Borrowing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(Borrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borrowing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Borrowing(null,1,1,"").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Confirm;
    private javax.swing.JButton jButton2cancel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
