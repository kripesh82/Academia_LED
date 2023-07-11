package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ResetPasswordModel;
import java.sql.*;
import javax.swing.JButton;
import view.Login;
import view.ResetPassword;
import DAO.ResetPasswordDAO;
import view.StudentDataEntry;
public class ResetPasswordController implements ActionListener {

    private ResetPasswordModel mod;
    private ResetPasswordDAO resetDAO;
    private ResetPassword resetPage;
    private JButton btnReset;

    public ResetPasswordController(ResetPasswordModel mod, ResetPasswordDAO resetDAO, ResetPassword resetPage) {
        this.mod = mod;
        this.resetDAO = resetDAO;
        this.resetPage = resetPage;
        this.resetPage.btnReset.addActionListener(this);
    }

    public void start() {
        resetPage.setTitle("Reset Password");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetPage.btnReset) {
            if (validateFields()) {
                mod.setUsername(resetPage.txtUsernameReset.getText());
                mod.setOld_password(resetPage.txtOldPassword.getText());
                mod.setNew_password(resetPage.txtNewPassword.getText());
                mod.setConfirm_password(resetPage.txtConfirmPassword.getText());

                if (mod.getNew_password().equals(mod.getConfirm_password())) {
                    if (resetDAO.update(mod)) {
                        JOptionPane.showMessageDialog(null, "Password Changed Sucessfully");
                        Login lp = new Login();
                        lp.show();
                        resetPage.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error in Updating");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "New password and Confirm password do not match.");
                }
            }
        }
    }

    public boolean validateFields() {
        String username = resetPage.txtUsernameReset.getText();
        String oldPassword = resetPage.txtOldPassword.getText();
        String newPassword = resetPage.txtNewPassword.getText();
        String confirmPassword = resetPage.txtConfirmPassword.getText();

        if (username.isEmpty() || oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }

        // Check if the username exists
        if (!resetDAO.checkUsernameExists(username)) {
            JOptionPane.showMessageDialog(null, "Username does not exist.");
            return false;
        }

        // Validate the old password
        if (!resetDAO.checkOldPassword(username, oldPassword)) {
            JOptionPane.showMessageDialog(null, "Invalid old password.");
            return false;
        }

        return true;
    }
}
