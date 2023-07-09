package testing;

import controller.StudentController;
import DAO.StudentDAO;
import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.StudentModel;
import view.StudentDataEntry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentControllerTest {
    private StudentDataEntry stupage;
    private StudentDAO dao;
    private StudentModel mod;
    private StudentController controller;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        stupage = new StudentDataEntry();
        dao = new StudentDAO();
        mod = new StudentModel();
        controller = new StudentController(mod, dao, stupage);
    }

    @After
    public void tearDown() {
         // Clean up after each test
        Connection connection = DbConnection.dbConnect();  // Obtain the database connection
        try {
            // Delete the registered user from the database
            String deleteSql = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.setInt(1, mod.getStudent_id());
            deleteStatement.executeUpdate();
            deleteStatement.close();
            connection.close();  // Close the connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of actionPerformed method, of class StudentController for add operation.
     */
    @Test
    public void testAddActionPerformed() {
        System.out.println("testAddActionPerformed");

        stupage.txtFirstName.setText("John");
        stupage.txtLastName.setText("Doee");
        stupage.txtAge.setText("25");
        stupage.txtAddress.setText("123 ABC Street");
        stupage.txtEmail.setText("john.doe@example.com");
        stupage.txtPhoneNumber.setText("1234567890");

        stupage.btnAdd.doClick();

        boolean expResult = true;
        boolean result = dao.add(mod);
        assertEquals(expResult, result);
    }

    /**
     * Test of actionPerformed method, of class StudentController for delete operation.
     */
    @Test
    public void testDeleteActionPerformed() {
        System.out.println("testDeleteActionPerformed");

        // First, add a student record to the database for deletion
        stupage.txtFirstName.setText("Jane");
        stupage.txtLastName.setText("Smith");
        stupage.txtAge.setText("20");
        stupage.txtAddress.setText("456 XYZ Street");
        stupage.txtEmail.setText("jane.smith@example.com");
        stupage.txtPhoneNumber.setText("9876543210");

        stupage.btnAdd.doClick();

        // Get the ID of the added student record
        int studentID = mod.getStudent_id();

        // Delete the student record
        stupage.txtID.setText(String.valueOf(studentID));
        stupage.jButtonDelete.doClick();

        // Verify if the student record is deleted from the database
        boolean expResult = false;
        boolean result = dao.search(mod);
        assertEquals(expResult, result);
    }

    /**
     * Test of actionPerformed method, of class StudentController for update operation.
     */
    @Test
    public void testUpdateActionPerformed() {
        System.out.println("testUpdateActionPerformed");

        // First, add a student record to the database for updating
        stupage.txtFirstName.setText("Michael");
        stupage.txtLastName.setText("Johnson");
        stupage.txtAge.setText("22");
        stupage.txtAddress.setText("789 PQR Street");
        stupage.txtEmail.setText("michael.johnson@example.com");
        stupage.txtPhoneNumber.setText("5555555555");

        stupage.btnAdd.doClick();

        // Search for the student record using the ID
        stupage.txtID.setText("10");
        stupage.btnSearch.doClick();

        // Update the student record
        stupage.txtFirstName.setText("Updated First Name");
        stupage.txtLastName.setText("Updated Last Name");
        stupage.txtAge.setText("30");
        stupage.txtAddress.setText("Updated Address");
        stupage.txtEmail.setText("updated.email@example.com");
        stupage.txtPhoneNumber.setText("987654321");

        stupage.btnUpdate.doClick();

        // Verify if the student record is updated in the database
        boolean expResult = true;
        boolean result = dao.search(mod);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testClearActionPerformed() {
        System.out.println("testClearActionPerformed");

        stupage.txtID.setText("123");
        stupage.txtFirstName.setText("John");
        stupage.txtLastName.setText("Doe");
        stupage.txtAge.setText("25");
        stupage.txtAddress.setText("123 ABC Street");
        stupage.txtEmail.setText("john.doe@example.com");
        stupage.txtPhoneNumber.setText("1234567890");

        stupage.btnClear.doClick();
        boolean result;

        if (stupage.txtID.getText().isEmpty() || stupage.txtFirstName.getText().isEmpty() || stupage.txtLastName.getText().isEmpty()
                || stupage.txtAge.getText().isEmpty() || stupage.txtAddress.getText().isEmpty()
                || stupage.txtEmail.getText().isEmpty() || stupage.txtPhoneNumber.getText().isEmpty()) {
            result = true;
        }
        else{
            result= false;
        }
        
        boolean expResult = true;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of actionPerformed method, of class StudentController for refresh operation.
     */
    @Test
    public void testRefreshActionPerformed() {
        System.out.println("testRefreshActionPerformed");

        // Add a student record to the database
        stupage.txtFirstName.setText("John");
        stupage.txtLastName.setText("Doe");
        stupage.txtAge.setText("25");
        stupage.txtAddress.setText("123 ABC Street");
        stupage.txtEmail.setText("john.doe@example.com");
        stupage.txtPhoneNumber.setText("1234567890");

        stupage.btnAdd.doClick();

        // Refresh the table
        stupage.btnRefresh.doClick();

        // Verify if the table is refreshed
        assertTrue(stupage.jTable.getRowCount() > 0);
    }

    /**
     * Test of actionPerformed method, of class StudentController for search operation.
     */
    @Test
    public void testSearchActionPerformed() {
        System.out.println("testSearchActionPerformed");

        // Add a student record to the database
        stupage.txtFirstName.setText("John");
        stupage.txtLastName.setText("Doe");
        stupage.txtAge.setText("25");
        stupage.txtAddress.setText("123 ABC Street");
        stupage.txtEmail.setText("john.doe@example.com");
        stupage.txtPhoneNumber.setText("1234567890");

        stupage.btnAdd.doClick();

        // Search for the student record
        stupage.txtID.setText(String.valueOf(mod.getStudent_id()));
        stupage.btnSearch.doClick();

        // Verify if the searched record is displayed in the fields
        assertEquals(String.valueOf(mod.getStudent_id()), stupage.txtID.getText());
        assertEquals("John", stupage.txtFirstName.getText());
        assertEquals("Doe", stupage.txtLastName.getText());
        assertEquals("25", stupage.txtAge.getText());
        assertEquals("123 ABC Street", stupage.txtAddress.getText());
        assertEquals("john.doe@example.com", stupage.txtEmail.getText());
        assertEquals("1234567890", stupage.txtPhoneNumber.getText());
    }
}
