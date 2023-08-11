///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
// */
//package testing;
//
//import controller.FeeController;
//import DAO.FeeDAO;
//import model.FeeModel;
//import view.StudentDataEntry;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author SMASHED TOMATOES
// */
//public class FeeControllerTest {
//    private StudentDataEntry feepage;
//    private FeeDAO feeDAO;
//    private FeeModel feemod;
//    private FeeController feeController;
//
//    
//    public FeeControllerTest() {
//    }
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
//        feepage = new StudentDataEntry();
//        feeDAO = new FeeDAO();
//        feemod = new FeeModel();
//        feeController = new FeeController(feemod, feeDAO, feepage);
//    }
//    
//    @After
//    public void tearDown() {
//            // Clean up after each test
//        feemod.setStudent_id(123); // Set the student ID for cleanup
//        feeDAO.delete(feemod);
//    }
//
//    /**
// * Test of actionPerformed method, of class FeeController for add operation.
// */
//@Test
//public void testAddActionPerformed() {
//    System.out.println("testAddActionPerformed");
//
//    // Search student ID to get first name and last name
//    feepage.txtFeeID.setText("10");
//    feepage.btnFeeSearch.doClick();
//    
//    feepage.lableFeeFName.setText(feemod.getFirst_name());
//    feepage.labelFeeLName.setText(feemod.getLast_name());
//
//    // Set the marks
//    feepage.comboBox.setSelectedIndex(1); // Assuming the selected index corresponds to a specific option
//    feepage.txtTution.setText("100");
//    feepage.txtECA.setText("50");
//    feepage.txtMic.setText("30");
//    feepage.txtOthers.setText("20");
//    feepage.txtDue.setText("40");
//
//    feepage.btnFeeAdd.doClick();
//    
//    boolean expResult = true;
//    boolean result = feeDAO.add(feemod);
//    assertEquals(expResult,result);
//}
//    
//}
