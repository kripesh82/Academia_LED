//package testing;
//
//import controller.RegistrationController;
//import DAO.RegistrationDAO;
//import model.RegistrationModel;
//import view.RegisterPage;
//import view.Login;
//import java.awt.event.ActionEvent;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import java.sql.Connection;
//import connection.DbConnection;
//
//public class RegistrationControllerTest {
//    private RegisterPage regpage;
//    private RegistrationDAO dao;
//    private RegistrationModel mod;
//    private RegistrationController controller;
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        regpage = new RegisterPage();
//        dao = new RegistrationDAO();
//        mod = new RegistrationModel();
//        controller = new RegistrationController(mod, dao, regpage);
//    }
//
//    @After
//    public void tearDown() {
//        // Clean up after each test
//        Connection connection = DbConnection.dbConnect();  // Obtain the database connection
//        try {
//            // Delete the registered user from the database
//            String deleteSql = "DELETE FROM users WHERE username = ?";
//            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
//            deleteStatement.setString(1, mod.getUsername());
//            deleteStatement.executeUpdate();
//            deleteStatement.close();
//            connection.close();  // Close the connection
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test of actionPerformed method, of class RegistrationController.
//     */
//    @Test
//    public void testActionPerformed() throws SQLException {
//        System.out.println("actionPerformed");
//
//        regpage.txtFirstName.setText("John");
//        regpage.txtLastName.setText("Doe");
//        regpage.txtUsername.setText("johndoe8");
//        regpage.txtStaffId.setText("123");
//        regpage.txtPassword.setText("password");
//        regpage.txtConfirmPassword.setText("password");
//        regpage.txtSecurityQuestion.setText("lily");
//
//        controller.actionPerformed(new ActionEvent(regpage.btnRegister, ActionEvent.ACTION_PERFORMED, ""));
//
//        boolean expResult = true;
//        boolean result = dao.register(mod);
//        assertEquals(expResult, result);
//    }
//}
