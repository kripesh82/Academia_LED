/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import connection.DbConnection;
import static connection.DbConnection.dbConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.FeeModel;

/**
 *
 * @author User
 */
public class FeeBillDAO extends DbConnection{
        public boolean searchBill(FeeModel mod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = dbConnect();

        String sql = "SELECT * FROM fee WHERE student_id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mod.getStudent_id());
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                mod.setStudent_id(Integer.parseInt(rs.getString("student_id")));
                mod.setFirst_name(rs.getString("first_name"));
                mod.setLast_name(rs.getString("last_name"));
                mod.setSelectedComboBoxOption(rs.getString("months"));
                mod.setTution(Float.parseFloat(rs.getString("tution")));
                mod.setEca(Float.parseFloat(rs.getString("eca")));
                mod.setMic(Float.parseFloat(rs.getString("mic")));
                mod.setOther(Float.parseFloat(rs.getString("other")));
                mod.setDue(Float.parseFloat(rs.getString("due")));
                mod.setTotal(Float.parseFloat(rs.getString("total")));
                
                
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