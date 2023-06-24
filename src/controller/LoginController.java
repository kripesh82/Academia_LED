/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Connection;
import model.*;
import view.*;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class LoginController {
    Login logview;
    LoginModel logmod;
    ResultSet rs;
    Statement stmt;

    
    public LoginController(Login logview){
        this.logview=logview;
        logview.addLoginListener(new LoginListener());
    }
    class LoginListener implements ActionListener{
        
       
        @Override
        public void actionPerformed(ActionEvent e){
            
            try{
                logmod=logview.getUser();   
                if(checkUser(logmod)){       
                    logview.setMessage("login successfully");
                    Dashboard db = new Dashboard();
                    db.setVisible(true);
                    logview.dispose();
                    
                }
                else{
                    logview.setMessage("invalid credentials");
                    
                }
                           
        
            }
            catch(Exception e1){
                System.out.println(e1.getMessage());
                
            }
        }
         public boolean checkUser(LoginModel user) throws Exception{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcprac","root","nirkr~");
            String query="select * from users where username='"+user.getUsername()+"' AND password='"+user.getPassword()+"'";
            try{
                stmt=conn.createStatement();
                rs=stmt.executeQuery(query);
                if (rs.next()){
                    return true;
                }
                conn.close();
                
            }
            catch(Exception e2){
                System.out.println(e2.getMessage());
                
            }
           return false;
         }


    }
    
}
