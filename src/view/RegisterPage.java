/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import DAO.RegistrationDAO;
import model.*;
import controller.*;
import view.Login;
import javax.swing.JOptionPane;

//import Controller.*;
//import Model_prac.*;
import java.awt.event.ActionListener;

/**
 *
 * @author neera
 */
public class RegisterPage extends javax.swing.JFrame {
    private RegistrationController controller;

    //RegisterModel model;
    /**
     * Creates new form RegistrationPage
     */
    public RegisterPage() {
        initComponents();
                RegistrationModel model = new RegistrationModel();
        RegistrationDAO dao = new RegistrationDAO();
        
        controller = new RegistrationController(model, dao, this);
        
        controller.start();
        
    }
    
//    public RegisterModel getUser(){
//        model = new RegisterModel();
//        return model;
//    
//    }
    

    
    public void setMessage(String msg){
        JOptionPane.showMessageDialog(this,msg);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterSecurityQuestion = new javax.swing.JTextField();
        reenter_password1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        register = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        staffID = new javax.swing.JLabel();
        create_password = new javax.swing.JLabel();
        reenter_password = new javax.swing.JLabel();
        existingUSer = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtStaffId = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        resetButton = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        regiser_form_enclosure = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Agency FB", 0, 49)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterSecurityQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterSecurityQuestionActionPerformed(evt);
            }
        });
        getContentPane().add(enterSecurityQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, 250, 30));

        reenter_password1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        reenter_password1.setForeground(new java.awt.Color(255, 255, 255));
        reenter_password1.setText("Enter Security Question");
        getContentPane().add(reenter_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, -1, 30));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/logo_transparent_legit (1).png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 30, 293, 81));

        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/line.png"))); // NOI18N
        getContentPane().add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 122, 1074, 14));

        btnLogin.setBackground(new java.awt.Color(3, 175, 228));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(897, 450, 260, 60));

        register.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("Register");
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 224, -1, -1));

        firstname.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        firstname.setForeground(new java.awt.Color(255, 255, 255));
        firstname.setText("First Name");
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 319, -1, -1));

        lastname.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lastname.setForeground(new java.awt.Color(255, 255, 255));
        lastname.setText("Last Name");
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 406, -1, -1));

        username.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 498, -1, -1));

        staffID.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        staffID.setForeground(new java.awt.Color(255, 255, 255));
        staffID.setText("Staff ID");
        getContentPane().add(staffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 589, -1, -1));

        create_password.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        create_password.setForeground(new java.awt.Color(255, 255, 255));
        create_password.setText("Create Password");
        getContentPane().add(create_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        reenter_password.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        reenter_password.setForeground(new java.awt.Color(255, 255, 255));
        reenter_password.setText("Re-enter Password");
        getContentPane().add(reenter_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 406, -1, -1));

        existingUSer.setFont(new java.awt.Font("Segoe UI Semibold", 1, 45)); // NOI18N
        existingUSer.setForeground(new java.awt.Color(255, 255, 255));
        existingUSer.setText("Existing User?");
        getContentPane().add(existingUSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, -1, -1));

        txtFirstName.setText("Enter First Name");
        getContentPane().add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 348, 249, 32));

        txtLastName.setText("Enter Last Name");
        getContentPane().add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 434, 249, 32));

        txtUsername.setText("Enter Username");
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 526, 249, 32));

        txtStaffId.setText("Enter StaffId");
        getContentPane().add(txtStaffId, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 618, 249, 32));

        txtPassword.setText("Enter Password");
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 249, 32));

        txtConfirmPassword.setText("Confirm PAssword");
        txtConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 435, 249, 32));

        resetButton.setBackground(new java.awt.Color(121, 173, 35));
        resetButton.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Clear");
        resetButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        resetButton.setBorderPainted(false);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 580, 250, 40));

        btnRegister.setBackground(new java.awt.Color(212, 45, 45));
        btnRegister.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegister.setBorderPainted(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 630, 250, 51));

        regiser_form_enclosure.setBackground(new java.awt.Color(0, 0, 0));
        regiser_form_enclosure.setForeground(new java.awt.Color(241, 254, 255));
        regiser_form_enclosure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/Register form.png"))); // NOI18N
        regiser_form_enclosure.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(), null));
        getContentPane().add(regiser_form_enclosure, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 194, 650, 531));

        background.setBackground(new java.awt.Color(239, 185, 103));
        background.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1300, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmPasswordActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
                               
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed

    }//GEN-LAST:event_resetButtonActionPerformed

    private void enterSecurityQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterSecurityQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterSecurityQuestionActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

           try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(RegisterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new RegisterPage().setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    public javax.swing.JButton btnLogin;
    public javax.swing.JButton btnRegister;
    private javax.swing.JLabel create_password;
    private javax.swing.JTextField enterSecurityQuestion;
    private javax.swing.JLabel existingUSer;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel line;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel reenter_password;
    private javax.swing.JLabel reenter_password1;
    private javax.swing.JLabel regiser_form_enclosure;
    private javax.swing.JLabel register;
    public javax.swing.JButton resetButton;
    private javax.swing.JLabel staffID;
    public javax.swing.JPasswordField txtConfirmPassword;
    public javax.swing.JTextField txtFirstName;
    public javax.swing.JTextField txtLastName;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtStaffId;
    public javax.swing.JTextField txtUsername;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
