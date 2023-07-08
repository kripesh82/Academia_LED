package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.StudentDAO;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.StudentModel;
import view.StudentDataEntry;
import view.Login;
import view.ResetPassword;

/**
 *
 * author User
 */
public class StudentController implements ActionListener {
    private StudentModel mod;
    private StudentDAO modDAO;
    private StudentDataEntry stupage;
    private JTable jTable;
    private JButton btnPrint;

    
    public StudentController(StudentModel mod, StudentDAO modDAO, StudentDataEntry stupage)
    {
        this.mod = mod;
        this.modDAO = modDAO;
        this.stupage = stupage;
        this.btnPrint = stupage.btnPrint;
        
        this.btnPrint.addActionListener(this);
        this.stupage.settingsCombobox.addActionListener(this);
        this.stupage.btnAdd.addActionListener(this);
        this.stupage.btnUpdate.addActionListener(this);
        this.stupage.jButtonDelete.addActionListener(this);
        this.stupage.btnClear.addActionListener(this);
        this.stupage.btnSearch.addActionListener(this);
        this.stupage.btnRefresh.addActionListener(this);

        this.jTable = stupage.jTable;

    }
    
    public void start()
    {
        stupage.setTitle("Student Registration Page");
        stupage.setLocationRelativeTo(null);
        stupage.txtID.setVisible(true);
        refreshTable();
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == stupage.btnAdd)
        {
            if (validateFields()) {
                mod.setFirst_name(stupage.txtFirstName.getText());
                mod.setLast_name(stupage.txtLastName.getText());
                mod.setAge(Integer.parseInt(stupage.txtAge.getText()));
                mod.setAddress(stupage.txtAddress.getText());
                mod.setEmail(stupage.txtEmail.getText());
                mod.setPhone_number(stupage.txtPhoneNumber.getText());
                
                
                if(modDAO.add(mod))
                {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    clear();
                    refreshTable();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot be Added");
                    clear();
                }   
            }
            
        }
        
        if(e.getSource() == stupage.btnUpdate)
        {
            if (validateFields()) {
                mod.setStudent_id(Integer.parseInt(stupage.txtID.getText()));
                mod.setFirst_name(stupage.txtFirstName.getText());
                mod.setLast_name(stupage.txtLastName.getText());
                mod.setAge(Integer.parseInt(stupage.txtAge.getText()));
                mod.setAddress(stupage.txtAddress.getText());
                mod.setEmail(stupage.txtEmail.getText());
                mod.setPhone_number(stupage.txtPhoneNumber.getText());
                
                
                if(modDAO.update(mod))
                {
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    clear();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error in Updating");
                    clear();
                }   
            }
            
        }
        
        if(e.getSource() == stupage.jButtonDelete)
        {
            if (validateIDField()) {
                mod.setStudent_id(Integer.parseInt(stupage.txtID.getText()));
                
                
                if(modDAO.delete(mod))
                {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    clear();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error in Deleting");
                    clear();
                    
                }   
            }
            
        }
        
        if(e.getSource() == stupage.btnSearch)
        {
            if (validateIDField()) {
                mod.setStudent_id(Integer.parseInt(stupage.txtID.getText())); 
                
                if(modDAO.search(mod))
                {
                    stupage.txtID.setText(String.valueOf(mod.getStudent_id()));
                    stupage.txtAddress.setText(mod.getAddress());
                    stupage.txtAge.setText(String.valueOf(mod.getAge()));
                    stupage.txtEmail.setText(mod.getEmail());
                    stupage.txtFirstName.setText(mod.getFirst_name());
                    stupage.txtLastName.setText(mod.getLast_name());
                    stupage.txtPhoneNumber.setText(mod.getPhone_number());
                   
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Found");
                    clear();
                }   
            }
            
        }

        if (e.getSource() == btnPrint) {
            MessageFormat header = new MessageFormat("Students Information");
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");

            try {
                jTable.print(JTable.PrintMode.NORMAL, header, footer);
            } catch (PrinterException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (e.getSource() == stupage.settingsCombobox) {
            String selectedOption = (String) stupage.settingsCombobox.getSelectedItem();
            
            if (selectedOption.equals("Log Out")) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
    
                if (option == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Logout successfully");
                    Login lp = new Login();
                    lp.setVisible(true);
                            stupage.dispose(); 
                } else if (option == JOptionPane.NO_OPTION) {
                        JOptionPane.getRootFrame().dispose();
    
    }
            } else if (selectedOption.equals("Reset Password")) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset password?", "Reset Password", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                    ResetPassword reset = new ResetPassword();
                    reset.setVisible(true);
                    
                } else if (option == JOptionPane.NO_OPTION) {
                        JOptionPane.getRootFrame().dispose();
                
                    
            }
        }
        }
        
            if(e.getSource() == stupage.btnClear){
            clear();
        }
        
        if (e.getSource() == stupage.btnRefresh) {
            refreshTable();
        }
    }
    
    public void clear()
    {
        stupage.txtID.setText(null);
        stupage.txtAddress.setText(null);
        stupage.txtAge.setText(null);
        stupage.txtEmail.setText(null);
        stupage.txtFirstName.setText(null);
        stupage.txtPhoneNumber.setText(null);
        stupage.txtLastName.setText(null);
        stupage.txtPhoneNumber.setText(null);
    }        
    
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0); // Clear existing table data

        // Retrieve all students from the database
        StudentDAO studentDAO = new StudentDAO();
        List<StudentModel> students = studentDAO.getAllStudents(); 

        // Iterate through the students and add them to the table
        for (StudentModel student : students) {
            Object[] row = {student.getStudent_id(), student.getFirst_name(), student.getLast_name(),
                    student.getAge(), student.getAddress(), student.getEmail(), student.getPhone_number()};
            model.addRow(row);
        }
    }    
    
    private boolean validateFields() {
        if (stupage.txtFirstName.getText().isEmpty() || stupage.txtLastName.getText().isEmpty()
                || stupage.txtAge.getText().isEmpty() || stupage.txtAddress.getText().isEmpty()
                || stupage.txtEmail.getText().isEmpty() || stupage.txtPhoneNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }
        
        try {
            Integer.parseInt(stupage.txtAge.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Age must be an integer.");
            return false;
        }
        
        
        return true;
    }
    
    private boolean validateIDField() {
        if (stupage.txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            return false;
        }
        
        return true;
    }
}
