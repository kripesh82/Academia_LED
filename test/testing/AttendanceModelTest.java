//package testing;
//
//import org.junit.Test;
//
//import java.sql.Date;
//import model.AttendanceModel;
//
//import static org.junit.Assert.assertEquals;
//
//public class AttendanceModelTest {
//
//    @Test
//    public void testGetAtStudentId() {
//        AttendanceModel instance = new AttendanceModel();
//        int expected = 1;
//        instance.setAtStudentId(expected);
//        int result = instance.getAtStudentId();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testSetAtStudentId() {
//        AttendanceModel instance = new AttendanceModel();
//        int expected = 1;
//        instance.setAtStudentId(expected);
//        int result = instance.getAtStudentId();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testGetAtStudentName() {
//        AttendanceModel instance = new AttendanceModel();
//        String expected = "Pawan Chaudhary";
//        instance.setAtStudentName(expected);
//        String result = instance.getAtStudentName();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testSetAtStudentName() {
//        AttendanceModel instance = new AttendanceModel();
//        String expected = "Pawan Chaudhary";
//        instance.setAtStudentName(expected);
//        String result = instance.getAtStudentName();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testGetAtDate() {
//        AttendanceModel instance = new AttendanceModel();
//        Date expected = Date.valueOf("2002-08-21");
//        instance.setAtDate(expected);
//        Date result = instance.getAtDate();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testSetAtDate() {
//        AttendanceModel instance = new AttendanceModel();
//        Date expected = Date.valueOf("2002-08-21");
//        instance.setAtDate(expected);
//        Date result = instance.getAtDate();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testGetAttendanceStatus() {
//        AttendanceModel instance = new AttendanceModel();
//        String expected = "Present";
//        instance.setAttendanceStatus(expected);
//        String result = instance.getAttendanceStatus();
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testSetAttendanceStatus() {
//        AttendanceModel instance = new AttendanceModel();
//        String expected = "Present";
//        instance.setAttendanceStatus(expected);
//        String result = instance.getAttendanceStatus();
//        assertEquals(expected, result);
//    }
//}
