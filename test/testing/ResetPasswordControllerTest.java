///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package testing;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import model.ResetPasswordModel;
//import view.ResetPassword;
//import DAO.ResetPasswordDAO;
//import controller.ResetPasswordController;
///**
// *
// * @author neera
// */
//public class ResetPasswordControllerTest {
//      private ResetPasswordController controller;
//    private ResetPasswordModel model;
//    private ResetPasswordDAO dao;
//    private ResetPassword view;
//
//    @Before
//    public void setUp() {
//        model = new ResetPasswordModel();
//        dao = new ResetPasswordDAO();
//        view = new ResetPassword();
//        controller = new ResetPasswordController(model, dao, view);
//    }
//
//    @Test
//    public void testValidateFields_AllFieldsFilled_ReturnsTrue() {
//        // Arrange
//        view.txtUsernameReset.setText("username");
//        view.txtOldPassword.setText("oldPassword");
//        view.txtNewPassword.setText("newPassword");
//        view.txtConfirmPassword.setText("newPassword");
//
//        // Act
//        boolean result = controller.validateFields();
//
//        // Assert
//        assertTrue(result);
//    }
//
//    @Test
//    public void testValidateFields_MissingFields_ReturnsFalse() {
//        // Arrange
//        view.txtUsernameReset.setText("");
//        view.txtOldPassword.setText("oldPassword");
//        view.txtNewPassword.setText("");
//        view.txtConfirmPassword.setText("newPassword");
//
//        // Act
//        boolean result = controller.validateFields();
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    public void testValidateFields_InvalidUsername_ReturnsFalse() {
//        // Arrange
//        view.txtUsernameReset.setText("invalidUsername");
//        view.txtOldPassword.setText("oldPassword");
//        view.txtNewPassword.setText("newPassword");
//        view.txtConfirmPassword.setText("newPassword");
//
//        // Act
//        boolean result = controller.validateFields();
//
//        // Assert
//        assertFalse(result);
//    }
//}
