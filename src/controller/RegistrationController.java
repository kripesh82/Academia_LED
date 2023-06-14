/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author User
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import model.*;
import view.*; 

public class RegistrationController {
    RegistrationModel model;
    RegisterPage view;
    ResultSet rs;
    PreparedStatement pst=null;
        public RegistrationController(RegisterPage view)
        {
            this.view=view;
            
             view.addLoginListner(new RegisetrListener());
        }
        
        class RegisetrListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
                model=view.getUser();
                if(checkUser(model))
                {
                    view.setMessage("Registered Successfully" );
                }
                else
                {
                    view.setMessage("Invalid registration");
                    
                }
            }
            catch(Exception e1)
            {
                
            }

        }
       
        public boolean checkUser(RegistrationModel user) throws Exception {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcprac", "root", "iphone53g@");

        
        String checkUsernameQuery = "SELECT * FROM users WHERE username = ?";
        pst = conn.prepareStatement(checkUsernameQuery);
        pst.setString(1, user.getUsername());
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            
            JOptionPane.showMessageDialog(null, "Username is already taken");
            return false;
        }
        
            if (user.getFname().isEmpty() || user.getLname().isEmpty() ||
            user.getUsername().isEmpty() || user.getStaffid().isEmpty() ||
            user.getPassword().isEmpty() || user.getConpassword().isEmpty() ||
            user.getFname().equals("Enter First Name") ||
            user.getLname().equals("Enter Last Name")  ||
            user.getUsername().equals("Enter Username") ||
            user.getStaffid().equals("Enter StaffId") ||        
            user.getPassword().equals("Enter Password") ||
            user.getConpassword().equals("Confirm PAssword")) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            return false;
        }
        try {
            int staffId = Integer.parseInt(user.getStaffid());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Staff ID must be an integer");
            return false;
        }

        
        if (!user.getPassword().equals(user.getConpassword())) {
            JOptionPane.showMessageDialog(null, "Password and Confirm password must match");
            return false;
        }

        
        String insertQuery = "INSERT INTO users(first_name, last_name, username, staff_id, password) VALUES (?, ?, ?, ?, ?)";
        pst = conn.prepareStatement(insertQuery);
        pst.setString(1, user.getFname());
        pst.setString(2, user.getLname());
        pst.setString(3, user.getUsername());
        pst.setString(4, user.getStaffid());
        pst.setString(5, user.getPassword());

        pst.executeUpdate();
        System.out.println("Data inserted");
        JOptionPane.showMessageDialog(null, "Data Registered Successfully");
        return true;
    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw e; // Rethrow the exception to be caught by the calling code
    } finally {
        if (pst != null) {
            pst.close();
        }
    }
}

    

        
}
    
}
