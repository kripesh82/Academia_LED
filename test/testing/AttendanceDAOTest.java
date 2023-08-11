//package testing;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import DAO.AttendanceDAO;
//
//import java.sql.Date;
//import java.util.List;
//import model.AttendanceModel;
//
//import static org.junit.Assert.*;
//
//public class AttendanceDAOTest {
//
//    private static AttendanceDAO attendanceDAO;
//
//    @BeforeClass
//    public static void setUpClass() {
//        attendanceDAO = new AttendanceDAO();
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//        attendanceDAO = null;
//    }
//
//    @Before
//    public void setUp() {
//        // Any setup tasks, if required
//    }
//
//    @After
//    public void tearDown() {
//        // Any cleanup tasks, if required
//    }
//
//    @Test
//    public void testAddAttendanceData() {
//        System.out.println("testAddAttendanceData");
//
//        // Test data
//        int studentId = 1;
//        String studentName = "John Doe";
//        String date = "2023-07-11";
//        String attendance = "Present";
//
//        boolean result = attendanceDAO.addAttendanceData(studentId, studentName, date, attendance);
//        assertTrue(result);
//
//        // Clean up the test data
////        attendanceDAO.deleteAttendanceData(studentId, date);
//    }
//
//    @Test
//    public void testGetAttendanceData() {
//        System.out.println("testGetAttendanceData");
//
//        // Test data
//        int studentId = 1;
//        String studentName = "John Doe";
//        String date = "2023-07-11";
//        String attendance = "Present";
//
//        // Insert test data
//        attendanceDAO.addAttendanceData(studentId, studentName, date, attendance);
//
//        // Retrieve attendance data
//        List<AttendanceModel> attendanceList = attendanceDAO.getAttendanceData(studentId);
//        assertFalse(attendanceList.isEmpty());
//
//        // Verify the retrieved data
//        AttendanceModel attendanceModel = attendanceList.get(0);
//        assertEquals(studentId, attendanceModel.getAtStudentId());
//        assertEquals(studentName, attendanceModel.getAtStudentName());
//        assertEquals(Date.valueOf(date), attendanceModel.getAtDate());
//        assertEquals(attendance, attendanceModel.getAttendanceStatus());
//
//        // Clean up the test data
//        attendanceDAO.deleteAttendanceData(studentId, date);
//    }
//
//    @Test
//    public void testGetAttendanceDataByDate() {
//        System.out.println("testGetAttendanceDataByDate");
//
//        // Test data
//        int studentId = 1;
//        String studentName = "John Doe";
//        String date = "2023-07-11";
//        String attendance = "Present";
//
//        // Insert test data
//        attendanceDAO.addAttendanceData(studentId, studentName, date, attendance);
//
//        // Retrieve attendance data by date
//        List<AttendanceModel> attendanceList = attendanceDAO.getAttendanceDataByDate(date);
//        assertFalse(attendanceList.isEmpty());
//
//        // Verify the retrieved data
//        AttendanceModel attendanceModel = attendanceList.get(0);
//        assertEquals(studentId, attendanceModel.getAtStudentId());
//        assertEquals(studentName, attendanceModel.getAtStudentName());
//        assertEquals(Date.valueOf(date), attendanceModel.getAtDate());
//        assertEquals(attendance, attendanceModel.getAttendanceStatus());
//
//        // Clean up the test data
//        attendanceDAO.deleteAttendanceData(studentId, date);
//    }
//
//    @Test
//    public void testGetAttendanceDataByStudentAndDate() {
//        System.out.println("testGetAttendanceDataByStudentAndDate");
//
//        // Test data
//        int studentId = 1;
//        String studentName = "John Doe";
//        String date = "2023-07-11";
//        String attendance = "Present";
//
//        // Insert test data
//        attendanceDAO.addAttendanceData(studentId, studentName, date, attendance);
//
//        // Retrieve attendance data by student and date
//        List<AttendanceModel> attendanceList = attendanceDAO.getAttendanceDataByStudentAndDate(studentId, date);
//        assertFalse(attendanceList.isEmpty());
//
//        // Verify the retrieved data
//        AttendanceModel attendanceModel = attendanceList.get(0);
//        assertEquals(studentId, attendanceModel.getAtStudentId());
//        assertEquals(studentName, attendanceModel.getAtStudentName());
//        assertEquals(Date.valueOf(date), attendanceModel.getAtDate());
//        assertEquals(attendance, attendanceModel.getAttendanceStatus());
//
//        // Clean up the test data
//        attendanceDAO.deleteAttendanceData(studentId, date);
//    }
//
//    @Test
//    public void testDeleteAttendanceData() {
//        System.out.println("testDeleteAttendanceData");
//
//        // Test data
//        int studentId = 1;
//        String studentName = "John Doe";
//        String date = "2023-07-11";
//        String attendance = "Present";
//
//        // Insert test data
//        attendanceDAO.addAttendanceData(studentId, studentName, date, attendance);
//
//        // Delete attendance data
//        boolean result = attendanceDAO.deleteAttendanceData(studentId, date);
//        assertTrue(result);
//
//        // Verify that the data is deleted
//        List<AttendanceModel> attendanceList = attendanceDAO.getAttendanceData(studentId);
//        assertTrue(attendanceList.isEmpty());
//    }
//}
