/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Management;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author techverse
 */
public class UserAccounts extends javax.swing.JFrame {

    /**
     * Creates new form UserAccounts
     */
    public UserAccounts() {
        initComponents();
        fetchDataAndUpdateTable();
        this.setLocationRelativeTo(null);
    }
    
     private void fetchDataAndUpdateTable() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservations", "root", "mysql");
            CallableStatement stmt = conn.prepareCall("{call SelectUsers()}");
            ResultSet rs = stmt.executeQuery();

            // Create a DefaultTableModel with column names
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("EmployeeNumber");
            model.addColumn("Full Name");
            model.addColumn("Department");
            model.addColumn("UserName");
            model.addColumn("PassWord");
           

            // Add rows to the model
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("EmployeeNumber"),
                    rs.getString("Fullname"),
                    rs.getString("Department"),
                    rs.getString("Username"),
                    rs.getString("ThePassWord"),
                  
                    
                });
            }

            // Set the model to the jTable1
            jTable1.setModel(model);

            //JOptionPane.showMessageDialog(null, "Data fetched successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An Error Occured While Fetching The The Data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back_btn = new javax.swing.JButton();
        AddAccount_btn = new javax.swing.JButton();
        deleteAccount_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THE USERS ACCOUNTS");

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EmployeeNumber", "Fullname", "UserName", "Department", "PassWord"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        back_btn.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        back_btn.setText("BACK");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        AddAccount_btn.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        AddAccount_btn.setText("ADD ACCOUNT");
        AddAccount_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAccount_btnActionPerformed(evt);
            }
        });

        deleteAccount_btn.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        deleteAccount_btn.setText("DELETE ACCOUNT");
        deleteAccount_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccount_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteAccount_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddAccount_btn)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(deleteAccount_btn)
                    .addComponent(AddAccount_btn))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
      Home theHome=new Home();
      theHome.setVisible(true);
      this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_back_btnActionPerformed

    private void AddAccount_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAccount_btnActionPerformed
        AddAccount Adding=new AddAccount();
        Adding.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_AddAccount_btnActionPerformed

    private void deleteAccount_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccount_btnActionPerformed
        
        
                                                  
    // Get the selected row index
    int selectedRowIndex = jTable1.getSelectedRow();

    // Check if a row is selected
    if (selectedRowIndex != -1) {
        // Get the primary key or unique identifier of the selected row
        int primaryKey = Integer.parseInt(jTable1.getValueAt(selectedRowIndex,0).toString());

        // Execute SQL DELETE statement to remove the row from the database table
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservations", "root", "mysql");
            CallableStatement stmt = conn.prepareCall("DELETE FROM theusers WHERE EmployeeNumber= ?");
            stmt.setInt(1,primaryKey );
            stmt.executeUpdate();
            stmt.close();
            conn.close();

            // Remove the selected row from the table model
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRowIndex);

           int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to Delete this Account?", "Confirm Back", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {


            JOptionPane.showMessageDialog(null, "Account deleted successfully.");
        }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error deleting row: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
    
}
        
    
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteAccount_btnActionPerformed

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
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAccounts().setVisible(true);
}
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAccount_btn;
    private javax.swing.JButton back_btn;
    private javax.swing.JButton deleteAccount_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
