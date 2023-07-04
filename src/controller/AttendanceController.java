package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.AttendanceDAO;
import DAO.StudentDAO;
import model.AttendanceModel;
import model.StudentModel;
import view.StudentDataEntry;

public class AttendanceController implements ActionListener {
    private StudentModel stMod;
    private AttendanceDAO atDAO;
    private StudentDataEntry atPage;
    private AttendanceModel atMod;
    private JTable jTableAttendance;
    private JTable jTableatDisplay;
    private JDateChooser dateChooser;

    public AttendanceController(StudentModel stMod, AttendanceModel atMod, AttendanceDAO atDAO, StudentDataEntry atPage) {
        this.stMod = stMod;
        this.atMod = atMod;
        this.atDAO = atDAO;
        this.atPage = atPage;

        this.jTableAttendance = atPage.jTableAttendance;
        this.jTableatDisplay = atPage.jTableatDisplay;
        this.atPage.jButtonatAdd.addActionListener(this);
        this.atPage.jButtonatRefresh.addActionListener(this);
        this.dateChooser = atPage.dateChooser;
        this.atPage.jButtonatSearchStdID.addActionListener(this);
        this.atPage.jButtonatSearchDate.addActionListener(this);
        this.atPage.jButtonatClear.addActionListener(this);
        this.atPage.jButtonatDelete.addActionListener(this);
    }

    public void atstart() {
        refreshTableat();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == atPage.jButtonatAdd) {
            int rowCount = jTableAttendance.getRowCount();
            Date selectedDate = dateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);

            for (int i = 0; i < rowCount; i++) {
                int studentId = (int) jTableAttendance.getValueAt(i, 0);
                String studentName = (String) jTableAttendance.getValueAt(i, 1);
                Boolean attendanceValue = (Boolean) jTableAttendance.getValueAt(i, 3);
                String attendance = attendanceValue != null && attendanceValue ? "Present" : "Absent";

                if (atDAO.addAttendanceData(studentId, studentName, formattedDate, attendance)) {
                    System.out.println("Attendance data added");
                } else {
                    System.out.println("Attendance data could not be added");
                }
            }

            JOptionPane.showMessageDialog(null, "Attendance data added successfully for all students.");
        }

        if (e.getSource() == atPage.jButtonatSearchStdID) {
            if (atPage.jDateChooserSearch.getDate() != null && !atPage.jTextFieldatStdIDSearch.getText().isEmpty()) {
                searchAttendanceByStudentAndDate();
            } else if (!atPage.jTextFieldatStdIDSearch.getText().isEmpty()) {
                searchAttendanceByStudentID();
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            }
        }

        if (e.getSource() == atPage.jButtonatSearchDate) {
            if (atPage.jDateChooserSearch.getDate() != null && !atPage.jTextFieldatStdIDSearch.getText().isEmpty()) {
                searchAttendanceByStudentAndDate();
            } else if (atPage.jDateChooserSearch.getDate() != null) {
                searchAttendanceByDate();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a date.");
            }
        }
        
        if (e.getSource() == atPage.jButtonatDelete) {
            int selectedRow = jTableatDisplay.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to delete.");
                return;
            }

            int studentId = (int) jTableatDisplay.getValueAt(selectedRow, 0);
            Date selectedDate = dateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);

            if (atDAO.deleteAttendanceData(studentId, formattedDate)) {
                JOptionPane.showMessageDialog(null, "Attendance data deleted successfully.");
                refreshTableat();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete attendance data.");
            }
        }

        if (e.getSource() == atPage.jButtonatClear) {
            atclear();
        }

        if (e.getSource() == atPage.jButtonatRefresh) {
            refreshTableat();
        }
    }

        private void refreshTableat() {
        DefaultTableModel atmodel = (DefaultTableModel) jTableAttendance.getModel();
        atmodel.setRowCount(0); // Clear existing table data

        // Retrieve all students from the database
        StudentDAO studentDAO = new StudentDAO();
        List<StudentModel> students = studentDAO.getAllStudents(); 

        // Iterate through the students and add them to the table
        for (StudentModel student : students) {
            Object[] row = {student.getStudent_id(), (student.getFirst_name()+" "+ student.getLast_name())};
            atmodel.addRow(row);
        }
        }

    private void searchAttendanceByStudentAndDate() {
        int studentId = Integer.parseInt(atPage.jTextFieldatStdIDSearch.getText());
        Date selectedDate = atPage.jDateChooserSearch.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(selectedDate);

        List<AttendanceModel> attendanceList = atDAO.getAttendanceDataByStudentAndDate(studentId, formattedDate);

        if (!attendanceList.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTableatDisplay.getModel();
            model.setRowCount(0);

            for (AttendanceModel attendance : attendanceList) {
                Object[] row = { attendance.getAtStudentId(), attendance.getAtStudentName(), attendance.getAtDate(), attendance.getAttendanceStatus() };
                model.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No attendance found for the specified student and date.");
        }
    }

    private void searchAttendanceByStudentID() {
        int studentId = Integer.parseInt(atPage.jTextFieldatStdIDSearch.getText());

        List<AttendanceModel> attendanceList = atDAO.getAttendanceData(studentId);

        if (!attendanceList.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTableatDisplay.getModel();
            model.setRowCount(0);

            for (AttendanceModel attendance : attendanceList) {
                Object[] row = { attendance.getAtStudentId(), attendance.getAtStudentName(), attendance.getAtDate(),attendance.getAttendanceStatus() };
                model.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No attendance found for the specified student ID.");
        }
    }

    private void searchAttendanceByDate() {
        Date selectedDate = atPage.jDateChooserSearch.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(selectedDate);

        List<AttendanceModel> attendanceList = atDAO.getAttendanceDataByDate(formattedDate);

        if (!attendanceList.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTableatDisplay.getModel();
            model.setRowCount(0);

            for (AttendanceModel attendance : attendanceList) {
                Object[] row = { attendance.getAtStudentId(), attendance.getAtStudentName(),attendance.getAtDate(), attendance.getAttendanceStatus() };
                model.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No attendance found for the specified date.");
        }
    }

    private void atclear() {
        atPage.jTextFieldatStdIDSearch.setText("");
        atPage.jDateChooserSearch.setDate(null);

        DefaultTableModel model = (DefaultTableModel) jTableatDisplay.getModel();
        model.setRowCount(0);
    }
}
