package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.RegistrationModel;
import DAO.RegistrationDAO;
import view.RegisterPage;
import view.Login;

public class RegistrationController implements ActionListener {

    private RegistrationModel mod;
    private RegistrationDAO modDAO;
    private RegisterPage regpage;
    private Login loginpage;

    public RegistrationController(RegistrationModel mod, RegistrationDAO modDAO, RegisterPage regpage) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.regpage = regpage;

        this.regpage.btnRegister.addActionListener(this);
        this.regpage.btnLogin.addActionListener(this);
        this.regpage.resetButton.addActionListener(this);
    }

    public void start() {
        regpage.setTitle("Registration Page");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regpage.btnRegister) {
            if (validateFields()) {
                mod.setFname(regpage.txtFirstName.getText());
                mod.setLname(regpage.txtLastName.getText());
                mod.setUsername((regpage.txtUsername.getText()));
                mod.setStaffid((regpage.txtStaffId.getText()));
                mod.setPassword(regpage.txtPassword.getText());
                mod.setConpassword(regpage.txtConfirmPassword.getText());
                mod.setSecurity(regpage.txtSecurityQuestion.getText());

                if (!mod.getPassword().equals(mod.getConpassword())) {
                    JOptionPane.showMessageDialog(null, "Password and Confirm Password do not match");
                    return;
                }

                try {
                    int staffId = Integer.parseInt(mod.getStaffid());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Staff ID must be an integer");
                    return;
                }

                if (modDAO.register(mod)) {
                    JOptionPane.showMessageDialog(null, "Registered Successfully");
                    clear();
                } else {
//                    JOptionPane.showMessageDialog(null, "Cannot be Registered");
                    clear();
                }
            }
        } else if (e.getSource() == regpage.resetButton) {
            clear();
        } else if (e.getSource() == regpage.btnLogin) {
            Login loginPage = new Login();
            loginPage.setVisible(true);
            regpage.dispose();
        }
    }

    public void clear() {
        regpage.txtFirstName.setText(null);
        regpage.txtLastName.setText(null);
        regpage.txtUsername.setText(null);
        regpage.txtStaffId.setText(null);
        regpage.txtPassword.setText(null);
        regpage.txtConfirmPassword.setText(null);
        regpage.txtSecurityQuestion.setText(null);
    }

    public boolean validateFields() {
        if (regpage.txtFirstName.getText().isEmpty() || regpage.txtLastName.getText().isEmpty()
                || regpage.txtUsername.getText().isEmpty() || regpage.txtStaffId.getText().isEmpty() || regpage.txtSecurityQuestion.getText().isEmpty()
                || regpage.txtPassword.getText().isEmpty() || regpage.txtConfirmPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields");
            return false;
            
        }if (regpage.txtFirstName.getText().equals("Enter First Name")
            || regpage.txtLastName.getText().equals("Enter Last Name")
            || regpage.txtUsername.getText().equals("Enter Username")
            || regpage.txtStaffId.getText().equals("Enter StaffId")
            || regpage.txtPassword.getText().equals("Enter Password")
            || regpage.txtPassword.getText().equals("Enter your Pet's Name")
            || regpage.txtConfirmPassword.getText().equals("Confirm Password")) {
            JOptionPane.showMessageDialog(null, "Please enter valid information");
            return false;
        }
        return true;
    }
}
