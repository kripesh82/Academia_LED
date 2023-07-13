/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.ResultDAO;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ResultModel;
import view.StudentDataEntry;
import java.util.Comparator;

/**
 *
 * author User
 */
public class ResultController implements ActionListener {
    private ResultModel mod2;
    private ResultDAO modDAO2;
    private StudentDataEntry stupage2;
    private JTable jTable1;
    private JButton jButtonPrint;

    
    public ResultController(ResultModel mod2, ResultDAO modDAO2, StudentDataEntry stupage2)
    {
        this.mod2 = mod2;
        this.modDAO2 = modDAO2;
        this.stupage2 = stupage2;
        this.jButtonPrint = stupage2.jButtonPrint;
        
        this.jButtonPrint.addActionListener(this);
        
        
        this.stupage2.jButtonAdd.addActionListener(this);
        this.stupage2.jButtonUpdate.addActionListener(this);
        this.stupage2.jButtonDelete2.addActionListener(this);
        this.stupage2.jButtonClear.addActionListener(this);
        this.stupage2.jButtonSearch.addActionListener(this);
        this.stupage2.jButtonSearch2.addActionListener(this);
        this.stupage2.jButtonRefresh.addActionListener(this);

        this.jTable1 = stupage2.jTable1;

    }
    
    public void start2()
    {
        stupage2.setTitle("Result Data Entry Page");
        stupage2.setLocationRelativeTo(null);
        stupage2.jTextFieldStudentID.setVisible(true);
        refreshTable1(); // Refresh the table initially
        clear1();
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == stupage2.jButtonAdd)
        {
            if (validateFields()) {
                mod2.setStudent_id(Integer.parseInt(stupage2.jTextFieldStudentID.getText()));
                mod2.setFirst_name(stupage2.jLabelFName.getText());
                mod2.setLast_name(stupage2.jLabelLName.getText());
                mod2.setCourse1(Float.parseFloat(stupage2.jTextFieldCourse1.getText()));
                mod2.setCourse2(Float.parseFloat(stupage2.jTextFieldCourse2.getText()));
                mod2.setCourse3(Float.parseFloat(stupage2.jTextFieldCourse3.getText()));
                mod2.setCourse4(Float.parseFloat(stupage2.jTextFieldCourse4.getText()));
                mod2.setCourse5(Float.parseFloat(stupage2.jTextFieldCourse4.getText()));
                double percentage = calculatePercentage(mod2);
                mod2.setPercent(percentage);             

                if(modDAO2.add(mod2))
                {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    clear1();
                    refreshTable1();
                    refreshTable1();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot be Added");
                    clear1();
                }
            }
            
        }
        
        
        if(e.getSource() == stupage2.jButtonUpdate)
        {
            if (validateFields()) {
                mod2.setStudent_id(Integer.parseInt(stupage2.jTextFieldStudentID.getText()));
                mod2.setFirst_name(stupage2.jLabelFName.getText());
                mod2.setLast_name(stupage2.jLabelLName.getText());
                mod2.setCourse1(Float.parseFloat(stupage2.jTextFieldCourse1.getText()));
                mod2.setCourse2(Float.parseFloat(stupage2.jTextFieldCourse2.getText()));
                mod2.setCourse3(Float.parseFloat(stupage2.jTextFieldCourse3.getText()));
                mod2.setCourse4(Float.parseFloat(stupage2.jTextFieldCourse4.getText()));
                mod2.setCourse5(Float.parseFloat(stupage2.jTextFieldCourse4.getText()));
                double percentage = calculatePercentage(mod2);
                mod2.setPercent(percentage);
                
                
                if(modDAO2.update(mod2))
                {
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    clear1();
                    refreshTable1();
                    refreshTable1();
                } else {
                    JOptionPane.showMessageDialog(null, "Error in Updating");
                    clear1();
                }   
            }
            
        }
        
        if(e.getSource() == stupage2.jButtonDelete2)
        {
            if (validateIDField()) {
                mod2.setStudent_id(Integer.parseInt(stupage2.jTextFieldSearch2.getText()));
                
                
                if(modDAO2.delete(mod2))
                {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    clear1();
                    refreshTable1();
                    refreshTable1();
                } else {
                    JOptionPane.showMessageDialog(null, "Error in Deleting");
                    clear1();
                    
                }           
            }

        }
        
        if(e.getSource() == stupage2.jButtonSearch2)
        {
            if (validateIDField()) {
                mod2.setStudent_id(Integer.parseInt(stupage2.jTextFieldSearch2.getText())); 
                
                if(modDAO2.search2(mod2))
                {
                    stupage2.jTextFieldStudentID.setText(String.valueOf(mod2.getStudent_id()));
                    stupage2.jLabelFName.setText(mod2.getFirst_name());
                    stupage2.jLabelLName.setText(mod2.getLast_name());
                    stupage2.jTextFieldCourse1.setText(String.valueOf(mod2.getCourse1()));
                    stupage2.jTextFieldCourse2.setText(String.valueOf(mod2.getCourse2()));
                    stupage2.jTextFieldCourse3.setText(String.valueOf(mod2.getCourse3()));
                    stupage2.jTextFieldCourse4.setText(String.valueOf(mod2.getCourse4()));
                    stupage2.jTextFieldCourse5.setText(String.valueOf(mod2.getCourse5()));
                   
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Found");
                    clear1();
                }   
                refreshTableForStudent();
                
            }
            
        }
        
        if(e.getSource() == stupage2.jButtonSearch)
        {
            if (validateIDField2()) {
                mod2.setStudent_id(Integer.parseInt(stupage2.jTextFieldStudentID.getText())); 
                
                if(modDAO2.search(mod2))
                {
                    stupage2.jTextFieldStudentID.setText(String.valueOf(mod2.getStudent_id()));
                    stupage2.jLabelFName.setText(mod2.getFirst_name());
                    stupage2.jLabelLName.setText(mod2.getLast_name());
                   
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Found");
                    clear1();
                }   
            }
            
        }


        if (e.getSource() == jButtonPrint) {
            MessageFormat header = new MessageFormat("Students Information");
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");

            try {
                jTable1.print(JTable.PrintMode.NORMAL, header, footer);
            } catch (PrinterException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        if(e.getSource() == stupage2.jButtonClear){
            clear1();
        }
        
        if (e.getSource() == stupage2.jButtonRefresh) {
            refreshTable1();
        }
    }
    
    public void clear1()
    {
        stupage2.jTextFieldStudentID.setText(null);
        stupage2.jTextFieldSearch2.setText(null);
        stupage2.jLabelFName.setText(null);
        stupage2.jLabelLName.setText(null);
        stupage2.jTextFieldCourse1.setText(null);
        stupage2.jTextFieldCourse2.setText(null);
        stupage2.jTextFieldCourse3.setText(null);
        stupage2.jTextFieldCourse4.setText(null);
        stupage2.jTextFieldCourse5.setText(null);
    }        
    
    private void refreshTable1() {
        DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
        model2.setRowCount(0); // Clear existing table data

        // Retrieve all students from the database
        ResultDAO resultDAO = new ResultDAO();
        List<ResultModel> result = resultDAO.getAllStudents1(); 
        
        // Sort the resultList based on the percentage in descending order
        result.sort(Comparator.comparingDouble(ResultModel::getPercent).reversed());
        
        int ranks=1;

        // Iterate through the students and add them to the table
        for (ResultModel resultdata : result) {
            Object[] row = {resultdata.getRank(),resultdata.getStudent_id(), resultdata.getFirst_name(), resultdata.getLast_name(),
                    resultdata.getCourse1(), resultdata.getCourse2(), resultdata.getCourse3(), resultdata.getCourse4(),resultdata.getCourse5(),(resultdata.getPercent()+"%")};
            model2.addRow(row);
        // Update the rank
        resultdata.setRank(ranks++);
        modDAO2.updateRank(resultdata);
        }
    }    
    

    private void refreshTableForStudent() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing table data

        if (validateIDField2()) {
            mod2.setStudent_id(Integer.parseInt(stupage2.jTextFieldStudentID.getText()));

            if (modDAO2.search(mod2)) {
                Object[] row = {mod2.getRank() , mod2.getStudent_id(), mod2.getFirst_name(), mod2.getLast_name(),
                        mod2.getCourse1(), mod2.getCourse2(), mod2.getCourse3(), mod2.getCourse4(), mod2.getCourse5(),
                        (mod2.getPercent()+"%")};
                model.addRow(row);
            } else {
                JOptionPane.showMessageDialog(null, "No Record Found");
                clear1();
            }
        }
    }
    
    private boolean validateFields() {
        if (stupage2.jLabelFName.getText().isEmpty() || stupage2.jLabelLName.getText().isEmpty()
                || stupage2.jTextFieldCourse1.getText().isEmpty() || stupage2.jTextFieldCourse2.getText().isEmpty()
                || stupage2.jTextFieldCourse3.getText().isEmpty() || stupage2.jTextFieldCourse4.getText().isEmpty() || stupage2.jTextFieldCourse5.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }
        try {
            float course1 = Float.parseFloat(stupage2.jTextFieldCourse1.getText());
            float course2 = Float.parseFloat(stupage2.jTextFieldCourse2.getText());
            float course3 = Float.parseFloat(stupage2.jTextFieldCourse3.getText());
            float course4 = Float.parseFloat(stupage2.jTextFieldCourse4.getText());
            float course5 = Float.parseFloat(stupage2.jTextFieldCourse5.getText());
            
            if (course1 < 0 || course1 > 100 || course2 < 0 || course2 > 100 || course3 < 0 || course3 > 100
                    || course4 < 0 || course4 > 100 || course5 < 0 || course5 > 100) {
                JOptionPane.showMessageDialog(null, "Please enter marks between 0-100");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Marks must be floating-point numbers.");
            return false;
        }

        return true;        
    }
    
    private boolean validateIDField() {
        if (stupage2.jTextFieldSearch2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            return false;
        }
        
        return true;
    }

    private boolean validateIDField2() {
        if (stupage2.jTextFieldStudentID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            return false;
        }
        
        return true;
    }
    private double calculatePercentage(ResultModel mod){
        double totalMarks = mod.getCourse1() + mod.getCourse2()+ mod.getCourse3() + mod.getCourse4() + mod.getCourse5();
        double percentage = (totalMarks / 500) * 100;
        return percentage;
    }
}
