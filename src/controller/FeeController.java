package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.FeeDAO;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.FeeModel;
import view.StudentDataEntry;

public class FeeController implements ActionListener {
    private FeeModel mod;
    private FeeDAO modDAO;
    private StudentDataEntry feepage;
    private JTable jTable;
    private JButton jButtonPrint;

    public FeeController(FeeModel mod, FeeDAO modDAO, StudentDataEntry feepage) {
        this.mod = mod;
        this.modDAO = modDAO;
        this.feepage = feepage;
        this.jButtonPrint = feepage.btnFeePrint;

        this.jButtonPrint.addActionListener(this);

        this.feepage.btnFeeAdd.addActionListener(this);
        this.feepage.btnFeeUpdate.addActionListener(this);
        this.feepage.btnFeeDelete.addActionListener(this);
        this.feepage.btnFeeRefresh.addActionListener(this);
        this.feepage.btnFeeSearch.addActionListener(this);
        this.feepage.btnSearchTable.addActionListener(this);
        this.feepage.btnFeePrint.addActionListener(this);
        this.feepage.btnClear.addActionListener(this);

        this.jTable = feepage.feeTable;
    }

    public void startFee() {
        feepage.setTitle("Result Data Entry Page");
        feepage.setLocationRelativeTo(null);
        refreshTable();
        clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == feepage.btnFeeAdd) {
            if (validateFields()) {
                mod.setStudent_id(Integer.parseInt(feepage.txtFeeID.getText()));
                mod.setFirst_name(feepage.lableFeeFName.getText());
                mod.setLast_name(feepage.labelFeeLName.getText());
                mod.setSelectedComboBoxOption(feepage.comboBox.getSelectedItem().toString());
                mod.setTution(Float.parseFloat(feepage.txtTution.getText()));
                mod.setEca(Float.parseFloat(feepage.txtECA.getText()));
                mod.setMic(Float.parseFloat(feepage.txtMic.getText()));
                mod.setOther(Float.parseFloat(feepage.txtOthers.getText()));
                mod.setDue(Float.parseFloat(feepage.txtDue.getText()));
                float total = (float) calculateTotal(mod);
                mod.setTotal(total);

                if (modDAO.add(mod)) {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    clear();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot be Added");
                    clear();
                }
            }
        }

if (e.getSource() == feepage.btnFeeUpdate) {
    if (validateFields()) {
        mod.setStudent_id(Integer.parseInt(feepage.txtFeeID.getText()));
        mod.setFirst_name(feepage.lableFeeFName.getText());
        mod.setLast_name(feepage.labelFeeLName.getText());
        mod.setSelectedComboBoxOption(feepage.comboBox.getSelectedItem().toString()); // Updated code
        mod.setTution(Float.parseFloat(feepage.txtTution.getText()));
        mod.setEca(Float.parseFloat(feepage.txtECA.getText()));
        mod.setMic(Float.parseFloat(feepage.txtMic.getText()));
        mod.setOther(Float.parseFloat(feepage.txtOthers.getText()));
        mod.setDue(Float.parseFloat(feepage.txtDue.getText()));
        float total = (float) calculateTotal(mod);
        mod.setTotal(total);

        if (modDAO.update(mod)) {
            JOptionPane.showMessageDialog(null, "Updated Successfully");
            clear();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(null, "Error in Updating");
            clear();
        }
    }
}


        if (e.getSource() == feepage.btnFeeDelete) {
            if (validateIDField()) {
                mod.setStudent_id(Integer.parseInt(feepage.txtFeeStudentSearch.getText()));

                if (modDAO.delete(mod)) {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    clear();
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Error in Deleting");
                    clear();
                }
            }
        }

        if (e.getSource() == feepage.btnSearchTable) {
            if (validateIDField()) {
                mod.setStudent_id(Integer.parseInt(feepage.txtFeeStudentSearch.getText()));

                if (modDAO.search2(mod)) {
                    feepage.txtFeeID.setText(String.valueOf(mod.getStudent_id()));
                    feepage.lableFeeFName.setText(mod.getFirst_name());
                    feepage.labelFeeLName.setText(mod.getLast_name());
                    feepage.comboBox.setActionCommand(mod.getSelectedComboBoxOption());
                    feepage.txtTution.setText(String.valueOf(mod.getTution()));
                    feepage.txtECA.setText(String.valueOf(mod.getEca()));
                    feepage.txtMic.setText(String.valueOf(mod.getMic()));
                    feepage.txtOthers.setText(String.valueOf(mod.getOther()));
                    feepage.txtDue.setText(String.valueOf(mod.getDue()));
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Found");
                    clear();
                }
                refreshTableForStudent();
            }
        }

        if (e.getSource() == feepage.btnFeeSearch) {
            if (validateIDField2()) {
                mod.setStudent_id(Integer.parseInt(feepage.txtFeeID.getText()));

                if (modDAO.search(mod)) {
                    feepage.txtFeeID.setText(String.valueOf(mod.getStudent_id()));
                    feepage.lableFeeFName.setText(mod.getFirst_name());
                    feepage.labelFeeLName.setText(mod.getLast_name());
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Found");
                    clear();
                }
            }
        }

        if (e.getSource() == jButtonPrint) {
            MessageFormat header = new MessageFormat("Fee");
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");

            try {
                jTable.print(JTable.PrintMode.NORMAL, header, footer);
            } catch (PrinterException ex) {
                System.out.println(ex.getMessage());
            }
        }

        if (e.getSource() == feepage.btnClear) {
            clear();
        }

        if (e.getSource() == feepage.btnFeeRefresh) {
            refreshTable();
        }
    }

    public void clear() {
        feepage.txtFeeID.setText(null);
        feepage.lableFeeFName.setText("");
        feepage.labelFeeLName.setText("");
        feepage.comboBox.setSelectedIndex(0);
        feepage.txtTution.setText(null);
        feepage.txtECA.setText(null);
        feepage.txtMic.setText(null);
        feepage.txtOthers.setText(null);
        feepage.txtDue.setText(null);
        feepage.txtFeeStudentSearch.setText(null);

    }

private void refreshTable() {
    DefaultTableModel model = (DefaultTableModel) jTable.getModel();
    int selectedRowIndex = jTable.getSelectedRow(); // Remember the selected row index

    // Retrieve all students from the database
    List<FeeModel> result = modDAO.getAllStudents();

    model.setRowCount(0); // Clear existing table data

    // Iterate through the students and add them to the table
    for (FeeModel resultdata : result) {
        Object[] row = {
            resultdata.getStudent_id(),
            resultdata.getFirst_name(),
            resultdata.getLast_name(),
            resultdata.getSelectedComboBoxOption(),
            resultdata.getTution(),
            resultdata.getEca(),
            resultdata.getMic(),
            resultdata.getOther(),
            resultdata.getDue(),
            resultdata.getTotal()
        };
        model.addRow(row);
    }

    if (selectedRowIndex >= 0) {
        // Restore the selection to the previously selected row
        jTable.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
    }
}


    private void refreshTableForStudent() {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0); // Clear existing table data

        if (validateIDField2()) {
            mod.setStudent_id(Integer.parseInt(feepage.txtFeeID.getText()));

            if (modDAO.search(mod)) {
                Object[] row = {
                    mod.getStudent_id(),
                    mod.getFirst_name(),
                    mod.getLast_name(),
                    mod.getSelectedComboBoxOption(), // Add selected month to the table
                    mod.getTution(),
                    mod.getEca(),
                    mod.getMic(),
                    mod.getOther(),
                    mod.getDue(),
                    mod.getTotal()
                };
                model.addRow(row);
            } else {
                JOptionPane.showMessageDialog(null, "No Record Found");
                clear();
            }
        }
    }

    private boolean validateFields() {
        if (feepage.lableFeeFName.getText().isEmpty() || feepage.labelFeeLName.getText().isEmpty()
                || feepage.txtTution.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }

        try {
            Float.parseFloat(feepage.txtTution.getText());
            Float.parseFloat(feepage.txtECA.getText());
            Float.parseFloat(feepage.txtDue.getText());
            Float.parseFloat(feepage.txtMic.getText());
            Float.parseFloat(feepage.txtOthers.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Courses must be floating-point numbers.");
            return false;
        }

        return true;
    }

    private boolean validateIDField() {
        if (feepage.txtFeeStudentSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            return false;
        }

        return true;
    }

    private boolean validateIDField2() {
        if (feepage.txtFeeID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            return false;
        }

        return true;
    }

    private double calculateTotal(FeeModel mod) {
        float total = mod.getTution() + mod.getEca() + mod.getMic() + mod.getOther() + mod.getDue();
        return total;
    }
}
