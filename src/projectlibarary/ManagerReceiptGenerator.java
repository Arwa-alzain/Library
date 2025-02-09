/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectlibarary;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.*;
import java.util.regex.*;
import javax.swing.*;
/**
 *
 * @author shenz
 */
public class ManagerReceiptGenerator extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    Connection conx;
    
    private void connectToDatabase() {
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String pathToDB = "DB\\DatabaseFinal.accdb";
            String url = "jdbc:ucanaccess://" + pathToDB;
            conx = DriverManager.getConnection(url);

        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(UserHistory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(UserHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillList() {
     DefaultListModel<String> listModel1 = new DefaultListModel<>();

    try {
        
        String sql = "SELECT Title, BookID, UserID, BorrowDate "
                + "FROM [Borrowing Data] "
                + "WHERE Status = 'Borrowed' AND ReturnDate IS NULL";

        PreparedStatement stmt = conx.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        int i = 1;

        
        while (rs.next()) {
            int bookID = rs.getInt("BookID");
            int userID = rs.getInt("UserID");
            Date borrowDate = rs.getDate("BorrowDate");
            String title = rs.getString("Title");
            


            String text = i + ".  " + title + ",   BookID: " + bookID + ",   UserID: " + userID
                    + ",   Borrowed on: " + borrowDate.toString();

            listModel1.addElement(text);
            i++; 
        }

      
        jList2.setModel(listModel1);
        jList2.revalidate();
        jList2.repaint();

    } catch (SQLException ex) {
        Logger.getLogger(ManagerReceiptGenerator.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error fetching data: " + ex.getMessage());
    }
}


    
   private void searchByTitle(String title) {
     DefaultListModel<String> listModel1 = new DefaultListModel<>();
   // boolean found = false;
    try {
        // Update the query to search by Title
        String sql = "SELECT Title, BookID, UserID, BorrowDate, ReturnDate "
                    + "FROM [Borrowing Data] WHERE Status = 'Borrowed' AND ReturnDate IS NULL AND Title LIKE ?";
        PreparedStatement stmt = conx.prepareStatement(sql);
        stmt.setString(1, "%" + title + "%"); 
        ResultSet rs = stmt.executeQuery();
        
        int i = 1;
        
        while (rs.next()) {
            int bookID = rs.getInt("BookID");
            int userID = rs.getInt("UserID");
            Date borrowDate = rs.getDate("BorrowDate");
            String Title = rs.getString("Title");

            
            
            String text = i + ".  " + Title + ",   BookID: " + bookID + ",   UserID: " + userID
                    + ",   Borrowed on: " + borrowDate.toString();

            listModel1.addElement(text);
            i++; 
        }

        // Update list model
        jList2.setModel(listModel1);
        jList2.revalidate();
        jList2.repaint();


    } catch (SQLException ex) {
        Logger.getLogger(ManagerReceiptGenerator.class.getName()).log(Level.SEVERE, null, ex);
    }
}


     
   String loggedInUser;
    public ManagerReceiptGenerator(String loggedInUser) {
        this.loggedInUser = loggedInUser;
        initComponents();
        connectToDatabase();
        fillList();
        setLocationRelativeTo(null);
        setTitle("Receipts Generator");

                
            
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
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setMinimumSize(new java.awt.Dimension(1070, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(74, 73, 71));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(229, 226, 226));
        jLabel10.setText("@All rights belong to Iqraa Library");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectlibarary/Images/logo1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 590));

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.setFocusable(false);
        jList2.setVerifyInputWhenFocusTarget(false);
        jList2.setVisibleRowCount(10);
        jScrollPane2.setViewportView(jList2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 227, 670, 250));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 330, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Search books by title:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 194, 70));

        jButton2.setBackground(new java.awt.Color(177, 116, 87));
        jButton2.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.setToolTipText("");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton2.setDefaultCapable(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setRequestFocusEnabled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 80, 30));

        jButton3.setBackground(new java.awt.Color(177, 116, 87));
        jButton3.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Generate Return Receipt");
        jButton3.setToolTipText("");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton3.setDefaultCapable(false);
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setRequestFocusEnabled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 500, 170, 37));

        jButton1.setBackground(new java.awt.Color(250, 247, 240));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectlibarary/Images/arrow (2).png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, -1, -1));

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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String searchText = jTextField1.getText().trim();
        if (searchText.isEmpty()) {
            //display all if textfeild is empty
            fillList();
        } else {
            searchByTitle(searchText);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    String selectedItem = jList2.getSelectedValue();
    
    
    if (selectedItem == null || selectedItem.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a borrowing record from the list.");
        return;
    }
   

    String bookIDString = extractBookID(selectedItem);

    if (bookIDString == null) {
        JOptionPane.showMessageDialog(this, "BookID not found in the selected record.");
        return;
    }

    // Parse the BookID
    int bookID;
    int userID = 0; // Default value in case userID is not found

    try {
        bookID = Integer.parseInt(bookIDString);  // Convert the BookID to an integer
        userID = Integer.parseInt(extractUserID(selectedItem));  // Assuming you have a method to extract UserID
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid BookID or UserID format.");
        return;
    }

    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
    updateReturnDate(bookID, userID, currentDate);
}
    
    
    private String extractUserID(String selectedItem) {
    //get UserID
    String regex = "UserID:\\s*(\\d+)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(selectedItem);

    if (matcher.find()) {
        return matcher.group(1);
    } else {
        return null;
    }
}


private String extractBookID(String selectedItem) {
    // get BookID
    String regex = "BookID:\\s*(\\d+)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(selectedItem);

    if (matcher.find()) {
        return matcher.group(1); 
    } else {
        return null;
    }
}
private void updateReturnDate(int bookID, int userID, java.sql.Date returnDate) {

    String updateQuery = "UPDATE [Borrowing Data] SET ReturnDate = ?, Status = ?, ReturnStatus = ? WHERE BookID = ? AND UserID = ?";

    try (PreparedStatement stmt = conx.prepareStatement(updateQuery)) {
        stmt.setDate(1, returnDate);
        stmt.setString(2, "Returned");

        String returnStatus = "";
        String calcReturnDateSQL = "SELECT CalculatedReturnDate FROM [Borrowing Data] WHERE BookID = ? AND UserID = ?";
        try (PreparedStatement calcStmt = conx.prepareStatement(calcReturnDateSQL)) {
            calcStmt.setInt(1, bookID);
            calcStmt.setInt(2, userID);
            ResultSet rs = calcStmt.executeQuery();

            if (rs.next()) {
                Date calculatedReturnDate = rs.getDate("CalculatedReturnDate");
                if (calculatedReturnDate != null && calculatedReturnDate.before(new java.sql.Date(System.currentTimeMillis()))) {
                    returnStatus = "Late";  // If return is after the calculated return date
                } else {
                    returnStatus = "On Time";  // If return is on time
                }
            }
        }

        stmt.setString(3, returnStatus);
        stmt.setInt(4, bookID);
        stmt.setInt(5, userID);
        int rowsUpdated = stmt.executeUpdate();

        if (rowsUpdated > 0) {
            // Update Availability in [Books Data] to "Available"
            updateBookAvailability(bookID);

            // Delete notification for the book
            deleteNotificationForBook(bookID, userID);

            // Show return receipt
            ManagerReceipt mr = new ManagerReceipt(this, true);
            mr.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error: Book record not found.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating return details: " + e.getMessage());
    }
}

private void updateBookAvailability(int bookID) {
    // Update Availability in Books Data
    String availabilityUpdateQuery = "UPDATE [Books Data] SET Availability = ? WHERE BookID = ?";
    
    try (PreparedStatement stmt = conx.prepareStatement(availabilityUpdateQuery)) {
        stmt.setString(1, "Available");  // Set availability to "Available"
        stmt.setInt(2, bookID);  // Specify the bookID
        
        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Book availability updated to 'Available' for BookID: " + bookID);
        } else {
            System.out.println("No matching book found to update availability for BookID: " + bookID);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating book availability: " + e.getMessage());
    }
}



private void deleteNotificationForBook(int bookID, int userID) {
    String deleteQuery = "DELETE FROM [Notifications Data] WHERE BookID = ? AND UserID = ?";

    try (PreparedStatement stmt = conx.prepareStatement(deleteQuery)) {
        stmt.setInt(1, bookID);
        stmt.setInt(2, userID);
        int rowsDeleted = stmt.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Notification deleted successfully for BookID: " + bookID + " and UserID: " + userID);
        } else {
            System.out.println("No matching notification found for BookID: " + bookID + " and UserID: " + userID);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error deleting notification: " + e.getMessage());
    }



    ///////////////////////////////////////////////////
      

        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new HomePageManager(loggedInUser).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    

    
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
            java.util.logging.Logger.getLogger(ManagerReceiptGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerReceiptGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerReceiptGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerReceiptGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerReceiptGenerator("").setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
