package testing;

import controller.LoginController;
import DAO.LoginDAO;
import model.LoginModel;
import view.Login;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * author Aryan
 */
public class LoginControllerTest {
    Login lview = new Login();
    LoginDAO dao = new LoginDAO();
    LoginModel mod = new LoginModel();
    
 
    public LoginControllerTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of actionPerformed method, of class LoginController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
         
        LoginController controller = new LoginController(dao, lview, mod);
        lview.txtUsername.setText("admin");
        lview.txtPassword.setText("admin");
        lview.btnLogin.doClick();

        boolean expResult = true;
        boolean result = dao.login(lview.txtUsername.getText(), lview.txtPassword.getText());
        assertEquals(expResult, result);
    }
}
