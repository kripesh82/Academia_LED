/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.swing.JOptionPane;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import model.StudentModel;
import view.StudentDataEntry;
import DAO.IDCardDAO;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.ImageIcon;
import java.awt.Image;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.text.SimpleDateFormat;




/**
 *
 * @author SMASHED TOMATOES
 */
public class IDCardController implements ActionListener{
    private StudentModel IDmod;
    private IDCardDAO idDAO;
    private StudentDataEntry IDpage;
    private JButton jButtonPicture;
    private JPanel jPanelIDCard;
    private int IDCardWidth = 990;
    private int IDCardHeight = 600;    
    private JDateChooser validityDate;
    private boolean studentIdSearched = false;
    
    public IDCardController(StudentModel IDmod, IDCardDAO idDAO, StudentDataEntry IDpage)
    {
        this.IDmod = IDmod;
        this.idDAO = idDAO;
        this.IDpage = IDpage;
        this.IDpage.jButtonIDPrint.addActionListener(this);
        this.IDpage.jButtonIDClear.addActionListener(this);
        this.IDpage.jButtonIDSearch.addActionListener(this);        
        this.jPanelIDCard = IDpage.jPanelIDCard;
        this.jButtonPicture = IDpage.jButtonPicture;
        this.jButtonPicture.addActionListener(this);
        this.IDpage.addDateToID.addActionListener(this);
        this.IDpage.jButtonIDClear.addActionListener(this);
        this.validityDate = IDpage.validityDate;

    }
    
    public void startID()
    {
        IDpage.setTitle("Student Management");
        IDpage.setLocationRelativeTo(null);
        clearID();
    }

    @Override
    
    public void actionPerformed(ActionEvent e)
    {   
        if(e.getSource() == IDpage.jButtonIDSearch)
        {
            if (validateStdIDField()) {
                IDmod.setStudent_id(Integer.parseInt(IDpage.jTextFieldIDStdSearch.getText())); 
                
                if(idDAO.searchID(IDmod))
                {
                    IDpage.jLabelIDStdID.setText(String.valueOf(IDmod.getStudent_id()));
                    IDpage.jLabelIDStdName.setText((IDmod.getFirst_name()+" "+IDmod.getLast_name()));
                    IDpage.jLabelIDAge.setText(String.valueOf(IDmod.getAge()));
                    IDpage.jLabelIDEmail.setText(IDmod.getEmail());
                    IDpage.jLabelIDAddress.setText(IDmod.getAddress());
                    studentIdSearched = true;
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Found");
                    clearID();
                    studentIdSearched = false;
                }   
            }
            
        }
        
        if(e.getSource() == IDpage.jButtonIDPrint)
        {
           if (validateStdIDField()) {
                if (validatePrintConditions()) { // Check validity date and picture
                    printIDCard();
                } else {
                    JOptionPane.showMessageDialog(null, "Please add validity date and select a picture.");
                }
            }
        }

            if (e.getSource() == jButtonPicture) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(IDpage);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    IDmod.setFilename(selectedFile.getAbsolutePath());

                    // Load the original image
                    ImageIcon originalIcon = new ImageIcon(IDmod.getFilename());
                    Image originalImage = originalIcon.getImage();

                    // Scale the image to fit within the JLabel size
                    int labelWidth = IDpage.jLabelPicture.getWidth();
                    int labelHeight = IDpage.jLabelPicture.getHeight();
                    Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

                    // Create a new ImageIcon with the scaled image
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    // Set the scaled icon on the JLabel
                    IDpage.jLabelPicture.setIcon(scaledIcon);

                    // Refresh the panel to display the image
                    IDpage.jPanelIDCard.revalidate();
                    IDpage.jPanelIDCard.repaint();
                }
            }
                if (e.getSource() == IDpage.addDateToID) {
                    if (studentIdSearched) {
                        if (validateStdIDField()) {
                            // Get the selected date from the JDateChooser
                            var selectedDate = IDpage.validityDate.getDate();

                            // Format the date as needed (e.g., "yyyy-MM-dd")
                            var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            var formattedDate = dateFormat.format(selectedDate);

                            // Set the formatted date as text in inputDate1
                            IDpage.inputDate1.setText(formattedDate);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please search a student ID first.");
                    }
                }
                
            
            if (e.getSource() == IDpage.jButtonIDClear){
                clearID();
            }



    }
    private boolean validatePrintConditions() {
        if (IDpage.validityDate.getDate() == null) {
            return false;
        }

        ImageIcon icon = (ImageIcon) IDpage.jLabelPicture.getIcon();
        return icon != null && icon.getImage() != null;
    }
    public void clearID()
    {
        IDpage.jLabelIDStdID.setText("");
        IDpage.jLabelIDStdName.setText("");
        IDpage.jLabelIDAge.setText("");
        IDpage.jLabelIDAddress.setText("");
        IDpage.jLabelIDEmail.setText("");
        IDpage.jTextFieldIDStdSearch.setText("");
        IDpage.inputDate1.setText("");
        IDpage.validityDate.setDate(null);
    }
    private boolean validateStdIDField() {
        if (IDpage.jTextFieldIDStdSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a student ID.");
            return false;
        }
        
        return true;
    } 
    public void printIDCard() {
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

                double scaleX = pageFormat.getImageableWidth() / IDCardWidth;
                double scaleY = pageFormat.getImageableHeight() / IDCardHeight;
                double scale = Math.min(scaleX, scaleY);
                g2.scale(scale, scale);

                jPanelIDCard.printAll(g2);

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
