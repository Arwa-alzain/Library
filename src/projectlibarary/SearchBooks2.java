/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectlibarary;
import java.awt.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.*;
//import projectlibarary.SearchBooks3;
/**
 *
 * @author Hp
 */
public class SearchBooks2 extends javax.swing.JFrame {
    Connection con;
    private String selectedGenre;
    ArrayList<String> searchresults = new ArrayList<>();
    private int userId;
    String loggedInUser;
    /**
     * Creates new form SearchBooks2
     */
    public SearchBooks2(String loggedInUser,int userId) {
        this.userId = userId;
        this.loggedInUser = loggedInUser;
        initComponents();
        eventhandling();
        
         try {
            String driverPath = "net.ucanaccess.jdbc.UcanaccessDriver";
            Class.forName(driverPath);
            String PathToDatabase = "DB\\DatabaseFinal.accdb";
            String url = "jdbc:ucanaccess://" + PathToDatabase;
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(SearchBooks2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }
         
         this.setLocationRelativeTo(null);
    }
    private void eventhandling(){
        jRadioButton1non.addActionListener(evt -> selectedGenre = "Non-Fiction");
        jRadioButton1fic.addActionListener(evt -> selectedGenre = "Fiction");
        jRadioButton1his.addActionListener(evt -> selectedGenre = "History");
        jRadioButton1bio.addActionListener(evt -> selectedGenre = "Biography");
        jRadioButton1scien.addActionListener(evt -> selectedGenre = "Science");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jRadioButton1non = new javax.swing.JRadioButton();
        jRadioButton1fic = new javax.swing.JRadioButton();
        jRadioButton1his = new javax.swing.JRadioButton();
        jRadioButton1bio = new javax.swing.JRadioButton();
        jRadioButton1scien = new javax.swing.JRadioButton();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search Books By Genre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "newest", "oldest" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 90, 30));

        jButton2_search.setBackground(new java.awt.Color(177, 116, 87));
        jButton2_search.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2_search.setForeground(new java.awt.Color(255, 255, 255));
        jButton2_search.setText("search");
        jButton2_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_searchActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));

        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 350, 180));

        buttonGroup1.add(jRadioButton1non);
        jRadioButton1non.setText("Non-Fiction");
        jPanel1.add(jRadioButton1non, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        buttonGroup1.add(jRadioButton1fic);
        jRadioButton1fic.setText("Fiction");
        jPanel1.add(jRadioButton1fic, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        buttonGroup1.add(jRadioButton1his);
        jRadioButton1his.setText("History");
        jPanel1.add(jRadioButton1his, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        buttonGroup1.add(jRadioButton1bio);
        jRadioButton1bio.setText("Biograghy");
        jPanel1.add(jRadioButton1bio, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        buttonGroup1.add(jRadioButton1scien);
        jRadioButton1scien.setText("Science");
        jPanel1.add(jRadioButton1scien, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, -1, -1));

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

    private void jButton2_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_searchActionPerformed
        // TODO add your handling code here:
        if(selectedGenre == null){
            JOptionPane.showMessageDialog(this, "Please Select a genre!", "Select genre", JOptionPane.INFORMATION_MESSAGE);
        }
        String query = "SELECT * FROM [Books Data] WHERE Genre = ?";
           try(PreparedStatement stmt = con.prepareStatement(query)){
               stmt.setString(1, selectedGenre);
               try(ResultSet rs = stmt.executeQuery()){
                   SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");//date format
                   while(rs.next()){
                       String title = rs.getString("Title");
                       java.sql.Date pubDate = rs.getDate("PublicationDate");
                       String formatting = (pubDate != null) ? dateformat.format(pubDate) : "N/A";
                       searchresults.add(title+" ("+formatting+")");
                   }
               }
           } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
           if (searchresults.isEmpty()){
           JOptionPane.showMessageDialog(this, "Not found books","Search Results", JOptionPane.INFORMATION_MESSAGE);
       }else{
           jList1.setListData(searchresults.toArray(new String[0]));
                  }
        
    }//GEN-LAST:event_jButton2_searchActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    String selectedFilter = (String) jComboBox1.getSelectedItem();
    ArrayList<String> filteredResults = new ArrayList<>();
    int currentYear = Year.now().getValue();
    for (String book : searchresults) {
        try {
            //take publication date part
            String[] parts = book.split("\\(");
            String dateStr = parts[1].replace(")", "").trim();
            //take the year from the date string
            int year = Integer.parseInt(dateStr.split("-")[0]);
            // Apply the filter based on the year
            if ("newest".equalsIgnoreCase(selectedFilter) && year >= currentYear - 5) {
                filteredResults.add(book);
            } else if ("oldest".equalsIgnoreCase(selectedFilter) && year < currentYear - 5) {
                filteredResults.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error processing book entry: " + book + " | " + e.getMessage());
        }
    }
    if(filteredResults.isEmpty()){
        JOptionPane.showMessageDialog(this, "No books match the filter.", "Filter Results", JOptionPane.INFORMATION_MESSAGE);
    }
    jList1.setListData(filteredResults.toArray(new String[0]));
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
         if (evt.getClickCount() == 2) {
        String selectedBook = jList1.getSelectedValue();
        if (selectedBook != null && !selectedBook.isEmpty()) {
            String bookTitle = selectedBook.split("\\(")[0].trim();//split the date from the title
            SearchBooks3 sb3 = new SearchBooks3(loggedInUser, userId,bookTitle);
            sb3.setVisible(true);
            this.dispose();
        }}
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        new SearchBooks1(loggedInUser,userId).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchBooks2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchBooks2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchBooks2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchBooks2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBooks2(1).setVisible(true);
            }
        });*/
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2_search;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1bio;
    private javax.swing.JRadioButton jRadioButton1fic;
    private javax.swing.JRadioButton jRadioButton1his;
    private javax.swing.JRadioButton jRadioButton1non;
    private javax.swing.JRadioButton jRadioButton1scien;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
