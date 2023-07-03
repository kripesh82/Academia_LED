/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.StudentDAO;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.StudentModel;
import model.AttendanceModel;
import view.ResultPage;
import model.AttendanceDAO;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author SMASHED TOMATOES
 */
public class AttendanceController implements ActionListener {
    private StudentModel stMod;
    private AttendanceDAO atDAO;
    private ResultPage atPage;
    private AttendanceModel atMod;
    private JTable jTableAttendance;
    private JTable jTableatDisplay;
    private JButton btnPrint;    
    private JButton jButtonatAdd;
    private JDateChooser dateChooser;

    
    
    public AttendanceController(StudentModel stMod, AttendanceModel atMod, AttendanceDAO atDAO, ResultPage atPage)
    {
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
    }
    public void atstart()
    {
        refreshTableat();
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == atPage.jButtonatAdd) {
            // Get the number of rows in the table
            int rowCount = jTableAttendance.getRowCount();

            // Get the selected date from the date chooser
            Date selectedDate = dateChooser.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(selectedDate);

            // Iterate through each row and add the attendance data
            for (int i = 0; i < rowCount; i++) {
                int studentId = (int) jTableAttendance.getValueAt(i, 0);
                String studentName = (String) jTableAttendance.getValueAt(i, 1);

                // Get the attendance checkbox state
                Boolean attendanceValue = (Boolean) jTableAttendance.getValueAt(i, 3);

                // Set the attendance value based on the checkbox state
                String attendance = attendanceValue != null && attendanceValue.booleanValue() ? "Present" : "Absent";

                // Call the DAO method to add the attendance data
                if (atDAO.addAttendanceData(studentId, studentName, formattedDate, attendance)) {
                    // Data added successfully
                    System.out.println("Attendance data added");
                } else {
                    // Failed to add data
                    System.out.println("Attendance data could not be added");
                }
            }

            // After adding data for all students, you can perform any necessary actions or display messages.
            JOptionPane.showMessageDialog(null, "Attendance data added successfully for all students.");
        }



        
//        if(e.getSource() == stupage.btnUpdate)
//        {
//            if (validateFields()) {
//                mod.setStudent_id(Integer.parseInt(stupage.txtID.getText()));
//                mod.setFirst_name(stupage.txtFirstName.getText());
//                mod.setLast_name(stupage.txtLastName.getText());
//                mod.setAge(Integer.parseInt(stupage.txtAge.getText()));
//                mod.setAddress(stupage.txtAddress.getText());
//                mod.setEmail(stupage.txtEmail.getText());
//                mod.setPhone_number(stupage.txtPhoneNumber.getText());
//                
//                
//                if(modDAO.update(mod))
//                {
//                    JOptionPane.showMessageDialog(null, "Updated Successfully");
//                    clear();
//                    refreshTable();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error in Updating");
//                    clear();
//                }   
//            }
//            
//        }
        
//        if(e.getSource() == stupage.btnDelete)
//        {
//            if (validateIDField()) {
//                mod.setStudent_id(Integer.parseInt(stupage.txtID.getText()));
//                
//                
//                if(modDAO.delete(mod))
//                {
//                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
//                    clear();
//                    refreshTable();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error in Deleting");
//                    clear();
//                    
//                }   
//            }
//            
//        }
        
            if (e.getSource() == atPage.jButtonatSearchStdID) {
            int studentId = Integer.parseInt(atPage.jTextFieldatStdIDSearch.getText());

            // Call the DAO method to search for the attendance data of the student
            List<AttendanceModel> attendanceList = atDAO.getAttendanceData(studentId);

            if (!attendanceList.isEmpty()) {
                // Attendance data found for the student, update the table with the data
                DefaultTableModel model = (DefaultTableModel) jTableatDisplay.getModel();
                model.setRowCount(0); // Clear existing table data

                // Get the selected date from the date chooser
                Date selectedDate = atPage.jDateChooserSearch.getDate();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(selectedDate);

                for (AttendanceModel attendance : attendanceList) {
                    // Check if the attendance data matches the selected date
                    if (attendance.getAtDate().toString().equals(formattedDate)) {
                        Object[] row = {
                            attendance.getAtStudentId(),
                            attendance.getAtStudentName(),
                            attendance.getAtDate(),
                            attendance.getAttendanceStatus()
                        };
                        model.addRow(row);
                    }
                }

                // Display a message or perform any necessary actions
                if (model.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Attendance data found.");
                } else {
                    JOptionPane.showMessageDialog(null, "No Attendance Data Found for the selected student ID and date.");
                }

            } else {
                // No attendance data found for the student, display an error message
                JOptionPane.showMessageDialog(null, "No Attendance Data Found");
            }
        }

        if (e.getSource() == atPage.jButtonatSearchDate) {
            // Get the selected date from the date picker
            Date selectedDate = atPage.jDateChooserSearch.getDate();

            // Format the selected date to match the database date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = dateFormat.format(selectedDate);

            // Call the DAO method to search for the attendance data based on the date
            List<AttendanceModel> attendanceList = atDAO.getAttendanceDataByDate(dateString);

            if (!attendanceList.isEmpty()) {
                // Attendance data found for the date, update the table with the data
                DefaultTableModel model = (DefaultTableModel) jTableatDisplay.getModel();
                model.setRowCount(0); // Clear existing table data

                int studentId = Integer.parseInt(atPage.jTextFieldatStdIDSearch.getText());

                for (AttendanceModel attendance : attendanceList) {
                    // Check if the attendance data matches the selected student ID
                    if (attendance.getAtStudentId() == studentId) {
                        Object[] row = {
                            attendance.getAtStudentId(),
                            attendance.getAtStudentName(),
                            attendance.getAtDate(),
                            attendance.getAttendanceStatus()
                        };
                        model.addRow(row);
                    }
                }

                // Display a message or perform any necessary actions
                if (model.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(null, "Attendance data found.");
                } else {
                    JOptionPane.showMessageDialog(null, "No Attendance Data Found for the selected date and student ID.");
                }

            } else {
                // No attendance data found for the date, display an error message
                JOptionPane.showMessageDialog(null, "No Attendance Data Found");
            }
        }

        if (e.getSource() == atPage.jButtonatClear) {
            atclear();
        }

        if (e.getSource() == atPage.jButtonatRefresh) {
            refreshTableat();
        }
    }
    
    
    public void atclear()
    {
        atPage.jDateChooserSearch.setDate(null);
        atPage.jTextFieldatStdIDSearch.setText(null);
        DefaultTableModel model = (DefaultTableModel) jTableatDisplay.getModel();
        model.setRowCount(0);

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
//    private void searchTableDsiplay() {
//        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
//        model.setRowCount(0); // Clear existing table data
//
//        if (validateIDField()) {
//            mod.setStudent_id(Integer.parseInt(stupage.txtID.getText()));
//
//            if (modDAO.search(mod)) {
//                Object[] row = { mod.getStudent_id(), mod.getFirst_name(), mod.getLast_name(),
//                        mod.getAge(), mod.getAddress(), mod.getEmail(), mod.getPhone_number()};
//                model.addRow(row);
//            } else {
//                JOptionPane.showMessageDialog(null, "No Record Found");
//                clear();
//            }
//        }
//    }    
    
//    private boolean validateFields() {
//        if (stupage.txtFirstName.getText().isEmpty() || stupage.txtLastName.getText().isEmpty()
//                || stupage.txtAge.getText().isEmpty() || stupage.txtAddress.getText().isEmpty()
//                || stupage.txtEmail.getText().isEmpty() || stupage.txtPhoneNumber.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
//            return false;
//        }
//        
//        try {
//            Integer.parseInt(stupage.txtAge.getText());
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Age must be an integer.");
//            return false;
//        }
//        
//        
//        return true;
//    }
//    
//    private boolean validateIDField() {
//        if (stupage.txtID.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
//            return false;
//        }
//        
//        return true;
//    }
//}

}
