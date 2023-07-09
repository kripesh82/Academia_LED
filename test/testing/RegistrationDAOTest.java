package testing;

import connection.DbConnection;
import DAO.RegistrationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.RegistrationModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RegistrationDAOTest {

    private RegistrationDAO registrationDAO;
    private Connection connection;

    public RegistrationDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        // Set up any necessary preconditions
    }

    @AfterClass
    public static void tearDownClass() {
        // Clean up after all tests have run
    }

    @Before
    public void setUp() {
        registrationDAO = new RegistrationDAO();
        connection = DbConnection.dbConnect();
    }

    @After
    public void tearDown() {
        // Clean up after each test
    }

    @Test
    public void testRegister() {
        System.out.println("testRegister");

        // Create a registration model with test data
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setFname("John");
        registrationModel.setLname("Doe");
        registrationModel.setUsername("johndoe");
        registrationModel.setStaffid("123");
        registrationModel.setPassword("password");
        registrationModel.setSecurity("lily");

        // Perform the registration
        boolean result = registrationDAO.register(registrationModel);

        // Verify the result
        assertTrue(result);
        // You can add additional assertions to validate the behavior

        // Clean up after the test
        try {
            // Delete the registered user from the database
            String deleteSql = "DELETE FROM users WHERE username = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setString(1, registrationModel.getUsername());
            deleteStatement.executeUpdate();
            deleteStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: Write additional test methods for other scenarios, such as checking for existing username, handling exceptions, etc.
}
