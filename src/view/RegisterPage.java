/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.JTextField;
//import Controller.*;
//import Model_prac.*;
import java.awt.event.ActionListener;

/**
 *
 * @author neera
 */
public class RegisterPage extends javax.swing.JFrame {

    //RegisterModel model;
    /**
     * Creates new form RegistrationPage
     */
    public RegisterPage() {
        initComponents();
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

        logo = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        register = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        staffID = new javax.swing.JLabel();
        create_password = new javax.swing.JLabel();
        reenter_password = new javax.swing.JLabel();
        existingUSer = new javax.swing.JLabel();
        txt_fname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_staffID = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_conPassword = new javax.swing.JPasswordField();
        btn_reset = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        regiser_form_enclosure = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Agency FB", 0, 49)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/logo_transparent_legit (1).png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 30, 293, 81));

        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/line.png"))); // NOI18N
        getContentPane().add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 122, 1074, 14));

        btn_login.setBackground(new java.awt.Color(3, 175, 228));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Login");
        btn_login.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_login.setBorderPainted(false);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 460, 107, 50));

        register.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("Register");
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 224, -1, -1));

        firstname.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        firstname.setForeground(new java.awt.Color(255, 255, 255));
        firstname.setText("First Name");
        getContentPane().add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 319, -1, -1));

        lastname.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lastname.setForeground(new java.awt.Color(255, 255, 255));
        lastname.setText("Last Name");
        getContentPane().add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 406, -1, -1));

        username.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 498, -1, -1));

        staffID.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        staffID.setForeground(new java.awt.Color(255, 255, 255));
        staffID.setText("Staff ID");
        getContentPane().add(staffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 589, -1, -1));

        create_password.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        create_password.setForeground(new java.awt.Color(255, 255, 255));
        create_password.setText("Create Password");
        getContentPane().add(create_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, -1, -1));

        reenter_password.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        reenter_password.setForeground(new java.awt.Color(255, 255, 255));
        reenter_password.setText("Re-enter Password");
        getContentPane().add(reenter_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 406, -1, -1));

        existingUSer.setFont(new java.awt.Font("Segoe UI Semibold", 1, 45)); // NOI18N
        existingUSer.setForeground(new java.awt.Color(255, 255, 255));
        existingUSer.setText("Existing User?");
        getContentPane().add(existingUSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 370, -1, -1));

        txt_fname.setText("Enter First Name");
        getContentPane().add(txt_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 348, 249, 32));

        txt_lname.setText("Enter Last Name");
        getContentPane().add(txt_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 434, 249, 32));

        txt_username.setText("Enter Username");
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 526, 249, 32));

        txt_staffID.setText("Enter StaffId");
        getContentPane().add(txt_staffID, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 618, 249, 32));

        txt_password.setText("Enter Password");
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 249, 32));

        txt_conPassword.setText("Confirm PAssword");
        txt_conPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_conPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_conPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 435, 249, 32));

        btn_reset.setBackground(new java.awt.Color(239, 185, 103));
        btn_reset.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_reset.setBorderPainted(false);
        getContentPane().add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 514, 232, 41));

        btn_register.setBackground(new java.awt.Color(212, 45, 45));
        btn_register.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_register.setText("Register");
        btn_register.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_register.setBorderPainted(false);
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 561, 232, 51));

        regiser_form_enclosure.setBackground(new java.awt.Color(0, 0, 0));
        regiser_form_enclosure.setForeground(new java.awt.Color(241, 254, 255));
        regiser_form_enclosure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/Register form.png"))); // NOI18N
        regiser_form_enclosure.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(), null));
        getContentPane().add(regiser_form_enclosure, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 194, 650, 531));

        background.setBackground(new java.awt.Color(239, 185, 103));
        background.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/images/background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_conPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_conPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_conPasswordActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
       //RegisterContoller rc = new RegisterController(this);
                                                  

    
                                       
    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loginActionPerformed

    
public void addLoginListener(ActionListener log){
    //btn_register.addActionListener(log);
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
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JButton btn_reset;
    private javax.swing.JLabel create_password;
    private javax.swing.JLabel existingUSer;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel line;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel reenter_password;
    private javax.swing.JLabel regiser_form_enclosure;
    private javax.swing.JLabel register;
    private javax.swing.JLabel staffID;
    private javax.swing.JPasswordField txt_conPassword;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_staffID;
    private javax.swing.JTextField txt_username;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
