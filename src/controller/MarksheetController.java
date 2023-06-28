/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.MarksheetDAO;
import java.sql.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ResultModel;
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
 * @author SMASHED TOMATOES
 */
public class MarksheetController implements ActionListener{
    private ResultModel markMod;
    private MarksheetDAO markDAO;
    private StudentDataEntry markpage;
//    private JPanel jPanel3;
    private JButton jButtonmarkPrint;
    private JPanel jPanelMarksheet;
    private int marksheetWidth = 990;
    private int marksheetHeight = 600;
    
    public MarksheetController(ResultModel markMod, MarksheetDAO markDAO, StudentDataEntry markpage)
    {
        this.markMod = markMod;
        this.markDAO = markDAO;
        this.markpage = markpage;
        this.jButtonmarkPrint = markpage.jButtonmarkPrint;
        this.jPanelMarksheet = markpage.jPanelMarksheet;
       
        this.jButtonmarkPrint.addActionListener(this);
        this.markpage.jButtonmarkSearch.addActionListener(this);

    }
    public void start1()
    {
        markpage.setTitle("Marksheet Page");
        markpage.setLocationRelativeTo(null);
        markpage.jTextFieldStudentID.setVisible(true);
        clear();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            if(e.getSource() == markpage.jButtonmarkSearch)
            {
                if (validateIDField()) {
                    markMod.setStudent_id(Integer.parseInt(markpage.jTextFieldmarkStdID.getText())); 

                    if(markDAO.searchMark(markMod))
                    {
                        markpage.jLabelmarkStdID.setText(String.valueOf(markMod.getStudent_id()));
                        markpage.jLabelmarkStdName.setText(markMod.getFirst_name() +" "+ markMod.getLast_name());
                        markpage.jLabelmarkRank.setText(String.valueOf(markMod.getRank()));
                        markpage.jLabelmarkCourse1.setText(String.valueOf(markMod.getCourse1()));
                        markpage.jLabelmarkCourse2.setText(String.valueOf(markMod.getCourse2()));
                        markpage.jLabelmarkCourse3.setText(String.valueOf(markMod.getCourse3()));
                        markpage.jLabelmarkCourse4.setText(String.valueOf(markMod.getCourse4()));
                        markpage.jLabelmarkCourse5.setText(String.valueOf(markMod.getCourse5()));
                        markpage.jLabelmarkPercentage.setText(String.valueOf(markMod.getPercent())+ "%");

                    } else {
                        JOptionPane.showMessageDialog(null, "No Record Found");
                        clear();
                    }   

                }

            }
            
        if (e.getSource() == markpage.jButtonmarkPrint) {
//            PrinterJob job = PrinterJob.getPrinterJob();
//            job.setJobName("Print Data");
//
//            job.setPrintable(new Printable() {
//                @Override
//                public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//                    if (pageIndex > 0) {
//                        return Printable.NO_SUCH_PAGE;
//                    }
//
//                    Graphics2D g2 = (Graphics2D) graphics;
//                    g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//
//                    double scaleX = pageFormat.getImageableWidth() / jLabelMarksheet.getWidth();
//                    double scaleY = pageFormat.getImageableHeight() / jLabelMarksheet.getHeight();
//                    g2.scale(scaleX, scaleY);
//
//                    jLabelMarksheet.printAll(g2);
//
//                    return Printable.PAGE_EXISTS;
//                }
//            });
//
//            boolean ok = job.printDialog();
//            if (ok) {
//                try {
//                    job.print();
//                } catch (PrinterException ex) {
//                    ex.printStackTrace();
//                }
//            }
                printMarksheet();
        }
    }
    public void clear()
    {
        markpage.jLabelmarkStdID.setText(null);
        markpage.jTextFieldmarkStdID.setText(null);
        markpage.jLabelmarkStdName.setText(null);
        markpage.jLabelmarkRank.setText(null);
        markpage.jLabelmarkCourse1.setText(null);
        markpage.jLabelmarkCourse2.setText(null);
        markpage.jLabelmarkCourse3.setText(null);
        markpage.jLabelmarkCourse4.setText(null);
        markpage.jLabelmarkCourse5.setText(null);
        markpage.jLabelmarkPercentage.setText(null);
    }
    private boolean validateIDField() {
        if (markpage.jButtonmarkSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            return false;
        }
        
        return true;
    }
    public void printMarksheet() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");

        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2 = (Graphics2D) graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                double scaleX = pageFormat.getImageableWidth() / marksheetWidth;
                double scaleY = pageFormat.getImageableHeight() / marksheetHeight;
                double scale = Math.min(scaleX, scaleY);
                g2.scale(scale, scale);

                jPanelMarksheet.printAll(g2);

                return Printable.PAGE_EXISTS;
            }
        });

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}