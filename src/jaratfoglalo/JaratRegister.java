/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaratfoglalo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bakcsányi Dominik
 */
public class JaratRegister extends javax.swing.JFrame {

    /**
     * Creates new form JaratRegister
     */
    public JaratRegister() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        regUsername = new javax.swing.JTextField();
        registerPassword1 = new javax.swing.JPasswordField();
        registerPassword2 = new javax.swing.JPasswordField();
        emailField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        jLabel3.setText("Password again:");

        jLabel4.setText("e-mail:");

        registerButton.setText("Register Now");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        regUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerPassword1)
                    .addComponent(registerPassword2)
                    .addComponent(regUsername)
                    .addComponent(emailField))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(regUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(registerPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(registerPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerButton)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            String registerName = regUsername.getText();
            String registerPass = registerPassword2.getText();
            String rgel = registerPassword1.getText();
            String registerEmail = emailField.getText();

            Statement stm = con.createStatement();
            String sql1 = "SELECT * FROM users WHERE userfield='" + registerName + "'";
            ResultSet rs = stm.executeQuery(sql1);
            if (!registerEmail.contains("@") || !registerEmail.contains(".")) {
                System.out.println("Invalid email");
                JOptionPane.showMessageDialog(this, "Please enter a valid email");
            } else {
                if (registerName == "" || registerPass == "" || registerEmail == "") {
                    System.out.println("All fields has to be filled out!");
                    JOptionPane.showMessageDialog(this, "All fields has to be filled out!");
                } else {
                    if (!rgel.matches(registerPass)) {
                        System.out.println("Given password do not match");
                        JOptionPane.showMessageDialog(this, "Given password do not match!");
                        regUsername.setText("");
                        registerPassword1.setText("");
                        registerPassword2.setText("");
                        emailField.setText("");
                    } else {
                        if (rs.next()) {
                            System.out.println("Username is already taken!");
                            JOptionPane.showMessageDialog(this, "Username is already taken!");
                            regUsername.setText("");
                            registerPassword1.setText("");
                            registerPassword2.setText("");
                            emailField.setText("");
                        } else {
                            String sql = "INSERT INTO `users` (`id`, `userfield`, `passwordfield`, `email`) VALUES (NULL, '" + registerName + "', '" + registerPass + "', '" + registerEmail + "')";
                            stm.executeUpdate(sql);
                            JOptionPane.showMessageDialog(this, "Sikeres regisztráció!");
                            dispose();
                            JaratLogin lg = new JaratLogin();
                            lg.show();
                            //INSERT INTO `users` (`id`, `user`, `pass`, `email`) VALUES (NULL, 'admin', 'admin', 'valami@email.hu');
                        }
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:

    }//GEN-LAST:event_registerButtonActionPerformed

    private void regUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(JaratRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JaratRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JaratRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JaratRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JaratRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField regUsername;
    private javax.swing.JButton registerButton;
    private javax.swing.JPasswordField registerPassword1;
    private javax.swing.JPasswordField registerPassword2;
    // End of variables declaration//GEN-END:variables
}
