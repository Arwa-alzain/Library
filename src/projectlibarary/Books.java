
package projectlibarary;

import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;




public class Books extends javax.swing.JFrame {

    private Connection con;
     Statement stmt ;
     String loggedInUser;

    
    /**
     * Creates new form Books
     */
    public Books(String loggedInUser) {
        initComponents();
        loadBooksToTable();
        setLocationRelativeTo(null);
        this.loggedInUser = loggedInUser;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String url = "jdbc:ucanaccess://" + "DB\\DatabaseFinal.accdb";
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Books.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database connection failed: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadBooksToTable() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear existing rows

    String query = "SELECT * FROM [Books Data]";
    try (Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + "DB\\DatabaseFinal.accdb");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            int bookId = rs.getInt("BookID");
            String title = rs.getString("Title");
            String author = rs.getString("Author");
            String genre = rs.getString("Genre");

            // Format PublicationDate
            String publicationDate = rs.getString("PublicationDate");
            if (publicationDate != null && publicationDate.contains(" ")) {
                publicationDate = publicationDate.split(" ")[0];
            }

            String description = rs.getString("Description");
            String available = rs.getString("Availability");

            model.addRow(new Object[]{bookId, title, author, genre, publicationDate, description, available});
        }

    } catch (SQLException e) {
        System.out.println("Error loading books into table: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 247, 240));
        jPanel1.setMinimumSize(new java.awt.Dimension(1070, 590));
        jPanel1.setPreferredSize(new java.awt.Dimension(1031, 590));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(74, 73, 71));
        jPanel2.setPreferredSize(new java.awt.Dimension(210, 563));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 226, 226));
        jLabel1.setText("@All rights belong to Iqraa Library");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectlibarary/Images/logo1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 590));

        jButton1.setBackground(new java.awt.Color(250, 247, 240));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectlibarary/Images/arrow (2).png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Book ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 110, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Title:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 110, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Author:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 110, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setText("Genre:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 110, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setText("Publication Date:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 120, -1));

        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 280, 25));

        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 280, 25));

        jTextField3.setBorder(null);
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 280, 25));

        jTextField4.setBorder(null);
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 280, 25));

        jTextField5.setBorder(null);
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 280, 25));

        jButton3.setBackground(new java.awt.Color(177, 116, 87));
        jButton3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 130, 40));

        jButton2.setBackground(new java.awt.Color(177, 116, 87));
        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 130, 40));

        jButton4.setBackground(new java.awt.Color(177, 116, 87));
        jButton4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 130, 40));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel10.setText("Search Book :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 110, 20));

        jTextField7.setBorder(null);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 240, 25));

        jButton5.setBackground(new java.awt.Color(177, 116, 87));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.setPreferredSize(new java.awt.Dimension(74, 17));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 100, 90, 25));

        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 280, 25));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel8.setText("Availability:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 120, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "Title", "Author", "Genre", "PuplicationDate", "Description", "Availability"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 650, -1));

        jButton6.setBackground(new java.awt.Color(177, 116, 87));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Reset");
        jButton6.setPreferredSize(new java.awt.Dimension(74, 17));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, 90, 25));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel9.setText("Description");
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 120, -1));

        jTextField8.setToolTipText("");
        jTextField8.setBorder(null);
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 280, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    try {
        String bookId = jTextField1.getText();
        String title = jTextField2.getText();
        String author = jTextField3.getText();
        String genre = jTextField4.getText();
        String publicationDate = jTextField5.getText(); // Should be YYYY-MM-DD
        String description = jTextField8.getText();
        String available = jTextField6.getText();

        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || genre.isEmpty() || publicationDate.isEmpty() || description.isEmpty() || available.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!publicationDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Publication Date must be in the format YYYY-MM-DD.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String query = "UPDATE [Books Data] SET Title = ?, Author = ?, Genre = ?, PublicationDate = ?, Availability = ?, Description = ? WHERE BookID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.setDate(4, java.sql.Date.valueOf(publicationDate)); // Ensures only the date part is saved
            pstmt.setString(5, available);
            pstmt.setString(6, description);
            pstmt.setInt(7, Integer.parseInt(bookId));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(this, "Book updated successfully!");
                loadBooksToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Error updating the book.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Book ID must be a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            // TODO add your handling code here:
    try {
        // Step 1: Get input from text fields
        String bookId = jTextField1.getText();
        String title = jTextField2.getText();
        String author = jTextField3.getText();
        String genre = jTextField4.getText();
        String publicationDate = jTextField5.getText();
        String description = jTextField8.getText();
        String available = jTextField6.getText();

        // Validate inputs
        if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || genre.isEmpty() || publicationDate.isEmpty() || available.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Prepare SQL query
        String query = "INSERT INTO [Books Data] (BookID, Title, Author, Genre, PublicationDate, Description, Availability) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        // Execute query
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, Integer.parseInt(bookId));
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setString(4, genre);

            try {
                java.sql.Date sqlDate = java.sql.Date.valueOf(publicationDate); // Validate date format
                pstmt.setDate(5, sqlDate);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pstmt.setString(6, description);
            pstmt.setString(7, available);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(this, "Book added successfully!");
                loadBooksToTable(); // Refresh table
            } else {
                JOptionPane.showMessageDialog(this, "Error adding the book.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MousePressed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    int row = jTable1.getSelectedRow();  // Get selected row

    // Retrieve data from the selected row
    String bookId = jTable1.getValueAt(row, 0).toString();  // BookID (first column)
    String title = jTable1.getValueAt(row, 1).toString();   // Title (second column)
    String author = jTable1.getValueAt(row, 2).toString();  // Author (third column)
    String genre = jTable1.getValueAt(row, 3).toString();   // Genre (fourth column)
    String publicationDate = jTable1.getValueAt(row, 4).toString(); // PublicationDate (fifth column)
    String description = jTable1.getValueAt(row, 5) == null ? "" : jTable1.getValueAt(row, 5).toString();
    String availability = jTable1.getValueAt(row, 6).toString();  // Availability (sixth column)

    // Set the values in the text fields
    jTextField1.setText(bookId);
    jTextField2.setText(title);
    jTextField3.setText(author);
    jTextField4.setText(genre);
    jTextField5.setText(publicationDate);
    jTextField8.setText(description); // Set description
    jTextField6.setText(availability);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    String bookId = jTextField1.getText();  // Get the BookID from the text field (set from JTable click)
    
    if (bookId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a book to delete.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Confirm deletion
    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this book?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        // Prepare the DELETE SQL query
        String query = "DELETE FROM [Books Data] WHERE BookID = ?";
        
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            
            // Set the BookID to the PreparedStatement
            pstmt.setInt(1, Integer.parseInt(bookId));
            
            // Execute the DELETE query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(this, "Book deleted successfully!");
                loadBooksToTable();  // Refresh the table after deletion
            } else {
                JOptionPane.showMessageDialog(this, "Error deleting the book.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField8.setText("");
    jTextField6.setText("");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    String searchQuery = jTextField7.getText().trim();  // Get the text from the search field

    // Validate that the search query is a valid number (BookID)
    int bookIdInt;
    try {
        bookIdInt = Integer.parseInt(searchQuery);  // Ensure BookID is a valid integer
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid numeric BookID.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Form the SQL query to search by BookID
    String query = "SELECT * FROM [Books Data] WHERE BookID = ?";

    // Prepare and execute the query
    try (PreparedStatement pstmt = con.prepareStatement(query)) {

        pstmt.setInt(1, bookIdInt);  // Set BookID parameter for the query
        
        // Execute the query and get the result set
        ResultSet rs = pstmt.executeQuery();

        // Clear the existing rows in the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);  // Clear previous results

        // Add rows to the table based on the search result
        if (rs.next()) {
            // Retrieve data from the result set
            int bookId = rs.getInt("BookID");
            String title = rs.getString("Title");
            String author = rs.getString("Author");
            String genre = rs.getString("Genre");
            String publicationDate = rs.getString("PublicationDate");
            String description = rs.getString("Description");
            String availability = rs.getString("Availability");

            // Add a row to the table
            model.addRow(new Object[]{bookId, title, author, genre, publicationDate, description, availability});
        } else {
            JOptionPane.showMessageDialog(this, "No book found with the given BookID.", "No Results", JOptionPane.INFORMATION_MESSAGE);
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String searchQuery = jTextField7.getText().trim();  // Get the text from the search field
        // If the search field is empty, load all books into the table
    if (searchQuery.isEmpty()) {
        loadBooksToTable();  // Reload all books in the table
        return;  // Exit if the search field is empty (show all records)
    }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new HomePageManager(loggedInUser).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

              /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
// 
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Books().setVisible(true);
//            }
//        }); 
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
