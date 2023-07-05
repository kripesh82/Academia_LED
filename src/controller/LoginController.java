package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginModel;
import DAO.LoginDAO;
import view.Login;
import view.RegisterPage;
import view.StudentDataEntry;
import view.ForgotPassword;

public class LoginController implements ActionListener {
    private LoginModel mod;
    private LoginDAO modDAO;
    private RegisterPage regpage;
    private Login loginpage;
    private ForgotPassword forgotPage;

    public LoginController(LoginModel mod, LoginDAO modDAO, Login loginpage) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.loginpage = loginpage;
        
        this.loginpage.btnRegister.addActionListener(this);
        this.loginpage.btnLogin.addActionListener(this);
        this.loginpage.btnClear.addActionListener(this);
        this.loginpage.btnForgotPassword.addActionListener(this);
        
    }
        public void start() {
        loginpage.setTitle("Login Page");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginpage.btnRegister) {
            RegisterPage registrationPage = new RegisterPage();
            registrationPage.setVisible(true);
            loginpage.dispose();
        } else if (e.getSource() == loginpage.btnLogin) {
            String username = loginpage.txtUsername.getText();
            String password = loginpage.txtPassword.getText();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter both username and password");
                return;
            }

            if (modDAO.login(username, password)) {
                JOptionPane.showMessageDialog(null, "Login Successful");
                loginpage.dispose();
                StudentDataEntry studentPage = new StudentDataEntry();
                studentPage.setVisible(true);
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                loginpage.txtUsername.setText(null);
                loginpage.txtPassword.setText(null);
            }
        } else if (e.getSource() == loginpage.btnClear) {
            loginpage.txtUsername.setText(null);
            loginpage.txtPassword.setText(null);
        }
            else if (e.getSource() == loginpage.btnForgotPassword) {
            forgotPage = new ForgotPassword();
            forgotPage.setVisible(true);
            loginpage.dispose();
        }
    }
}
