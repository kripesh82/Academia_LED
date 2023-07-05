package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ForgotPasswordModel;
import java.sql.*;
import javax.swing.JButton;
import view.Login;
import view.ForgotPassword;
import DAO.ForgotPasswordDAO;

public class ForgotPasswordConroller implements ActionListener {

    private ForgotPasswordModel fpmod;
    private ForgotPasswordDAO fpDAO;
    private ForgotPassword fpPage;
    private JButton btnChange;

    public ForgotPasswordConroller(ForgotPasswordModel fpmod, ForgotPasswordDAO fpDAO, ForgotPassword fpPage) {
        this.fpmod = fpmod;
        this.fpDAO = fpDAO;
        this.fpPage = fpPage;
        this.fpPage.btnChangePass.addActionListener(this);
    }

    public void start() {
        fpPage.setTitle("Forgot Password");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fpPage.btnChangePass) {
            if (validateFields()) {
                fpmod.setUsername(fpPage.txtUsername.getText());
                fpmod.setSecurity(fpPage.txtSecurityQuestion.getText());
                fpmod.setNew_password(fpPage.txtNewPassword.getText());
                fpmod.setConfirm_password(fpPage.txtConNewPassword.getText());

                if (fpmod.getNew_password().equals(fpmod.getConfirm_password())) {
                    if (fpDAO.update(fpmod)) {
                        JOptionPane.showMessageDialog(null, "Password Changed Sucessfully");
                        Login lp = new Login();
                        lp.show();
                        fpPage.dispose();
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Error in Changing");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "New password and Confirm password do not match.");
                }
            }
        }
    }

    private boolean validateFields() {
        String username = fpPage.txtUsername.getText();
        String security = fpPage.txtSecurityQuestion.getText();
        String newPassword = fpPage.txtNewPassword.getText();
        String confirmPassword = fpPage.txtConNewPassword.getText();

        if (username.isEmpty() || security.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }

        // Check if the username exists
        if (!fpDAO.checkUsernameExists(username)) {
            JOptionPane.showMessageDialog(null, "Username does not exist.");
            return false;
        }

        // Validate the old password
        if (!fpDAO.checkSecurity(username, security)) {
            JOptionPane.showMessageDialog(null, "Invalid Security Answer");
            return false;
        }

        return true;
    }
}
