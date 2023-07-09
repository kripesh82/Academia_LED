/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ForgotPasswordModel;
import java.sql.*;
import javax.swing.JButton;
import view.Login;
import view.ForgotPassword;
import DAO.ForgotPasswordDAO;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import controller.ForgotPasswordConroller;
/**
 *
 * @author neera
 */
public class ForgotPasswordControllerTest {
    
    private ForgotPasswordConroller controller;
    private ForgotPasswordModel model;
    private ForgotPasswordDAO dao;
    private ForgotPassword view;

    @Before
    public void setUp() {
        model = new ForgotPasswordModel();
        dao = new ForgotPasswordDAO();
        view = new ForgotPassword();
        controller = new ForgotPasswordConroller(model, dao, view);
    }

    @Test
    public void testValidateFields_AllFieldsFilled_ReturnsTrue() {
        // Arrange
        view.txtUsername.setText("username");
        view.txtSecurityQuestion.setText("securityAnswer");
        view.txtNewPassword.setText("newPassword");
        view.txtConNewPassword.setText("newPassword");

        // Act
        boolean result = controller.validateFields();

        // Assert
        assertTrue(result);
    }

    @Test
    public void testValidateFields_MissingFields_ReturnsFalse() {
        // Arrange
        view.txtUsername.setText("");
        view.txtSecurityQuestion.setText("securityAnswer");
        view.txtNewPassword.setText("newPassword");
        view.txtConNewPassword.setText("newPassword");

        // Act
        boolean result = controller.validateFields();

        // Assert
        assertFalse(result);
    }

    @Test
    public void testValidateFields_InvalidUsername_ReturnsFalse() {
        // Arrange
        view.txtUsername.setText("invalidUsername");
        view.txtSecurityQuestion.setText("securityAnswer");
        view.txtNewPassword.setText("newPassword");
        view.txtConNewPassword.setText("newPassword");

        // Act
        boolean result = controller.validateFields();

        // Assert
        assertFalse(result);
    }
}
