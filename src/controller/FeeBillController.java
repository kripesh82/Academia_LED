/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.FeeBillDAO;
import java.sql.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.FeeModel;
import view.StudentDataEntry;
import javax.swing.JPanel;
import java.util.Comparator;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author User
 */
public class FeeBillController implements ActionListener {
    private FeeModel feeMod;
    private FeeBillDAO feeDAO;
    private StudentDataEntry feepage;
    private JButton jButtonFeePrint;
    
    
        public FeeBillController(FeeModel feeMod, FeeBillDAO feeDAO, StudentDataEntry feepage)
    {
        this.feeMod = feeMod;
        this.feeDAO = feeDAO;
        this.feepage = feepage;
        this.jButtonFeePrint = feepage.btnPrintBill;
        
        this.jButtonFeePrint.addActionListener(this);
        this.feepage.btnSearchBill.addActionListener(this);

    }
        
    public void startBill()
    {
        feepage.setTitle("Academia");
        feepage.setLocationRelativeTo(null);
        feepage.txtBillStudentID.setVisible(true);
        clear();
    }
        @Override
    public void actionPerformed(ActionEvent e)
    {
            if(e.getSource() == feepage.btnSearchBill)
            {
                if (validateIDField()) {
                    feeMod.setStudent_id(Integer.parseInt(feepage.txtBillStudentID.getText())); 

                    if(feeDAO.searchBill(feeMod))
                    {
                        feepage.jLabelBillStudentID.setText(String.valueOf(feeMod.getStudent_id()));
                        feepage.jLabelBillFirstName.setText(String.valueOf(feeMod.getFirst_name()+" "+feeMod.getLast_name()));
                        feepage.jLabelBillMonth.setText(String.valueOf(feeMod.getSelectedComboBoxOption()));
                        feepage.jLabelBillTution.setText(String.valueOf(feeMod.getTution()));
                        feepage.jLabelBillECA.setText(String.valueOf(feeMod.getEca()));
                        feepage.jLabelBillMic.setText(String.valueOf(feeMod.getMic()));
                        feepage.jLabelBillOthers.setText(String.valueOf(feeMod.getOther()));
                        feepage.jLabelBillPastDues.setText(String.valueOf(feeMod.getDue()));
                        feepage.jLabelBillTotal.setText(String.valueOf(feeMod.getTotal()));
                        

                    } else {
                        JOptionPane.showMessageDialog(null, "No Record Found");
                        clear();
                    }   

                }

            }
            
            if(e.getSource() == feepage.btnPrintBill)
            {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setJobName("Print Data");
            
                job.setPrintable(new Printable(){
                public int print(Graphics pg,PageFormat pf, int pageNum){
                        pf.setOrientation(PageFormat.LANDSCAPE);
                     if(pageNum > 0){
                        return Printable.NO_SUCH_PAGE;
                    }

                    Graphics2D g2 = (Graphics2D)pg;
                    // Set the full width of the page as the printable area
                    g2.translate(pf.getImageableX(), pf.getImageableY());
                    double desiredWidth = pf.getImageableWidth()-100;
                    double desiredHeight = pf.getImageableHeight() - 100; // Adjust the height here
                    double scaleX = desiredWidth / feepage.jpanelBill.getWidth();
                    double scaleY = desiredHeight / feepage.jpanelBill.getHeight();
                    g2.scale(scaleX, scaleY);

                    feepage.jpanelBill.print(g2);


                    return Printable.PAGE_EXISTS;


                }
        });
                boolean ok = job.printDialog();
            if(ok){
            try{

            job.print();
            }
            catch (PrinterException ex){
            ex.printStackTrace();
    }
            }
                }
        }
    public void clear()
    {
        feepage.txtBillStudentID.setText(null);
        feepage.jLabelBillStudentID.setText(null);
        feepage.jLabelBillFirstName.setText(null);
        feepage.jLabelBillMonth.setText(null);
        feepage.jLabelBillTution.setText(null);
        feepage.jLabelBillECA.setText(null);
        feepage.jLabelBillMic.setText(null);
        feepage.jLabelBillOthers.setText(null);
        feepage.jLabelBillPastDues.setText(null);
        feepage.jLabelBillTotal.setText(null);
    }
    private boolean validateIDField() {
        if (feepage.btnSearchBill.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            return false;
        }
        
        return true;
    }
}
    

