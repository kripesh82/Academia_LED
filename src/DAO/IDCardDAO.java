/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import connection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.StudentModel;
/**
 *
 * @author SMASHED TOMATOES
 */
public class IDCardDAO extends DbConnection{
    public boolean searchID(StudentModel IDmod)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = dbConnect();
        
        String sql = "SELECT * FROM students WHERE student_id=?";
        
        
            try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, IDmod.getStudent_id());
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                IDmod.setStudent_id(Integer.parseInt(rs.getString("student_id")));
                IDmod.setFirst_name(rs.getString("first_name"));
                IDmod.setLast_name(rs.getString("last_name"));
                IDmod.setAge(Integer.parseInt(rs.getString("age")));
                IDmod.setAddress(rs.getString("address"));
                IDmod.setEmail(rs.getString("email"));
                IDmod.setPhone_number(rs.getString("phone_number"));
                
                return true;
                
            }

            return false;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return false; // Added a default return statement outside the try-catch block
    }
    }