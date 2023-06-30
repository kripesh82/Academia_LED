/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.ResultModel;
/**
 *
 * @author SMASHED TOMATOES
 */
public class MarksheetDAO extends DbConnection{
        public boolean searchMark(ResultModel markMod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = dbConnect();

        String sql = "SELECT * FROM result WHERE student_id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, markMod.getStudent_id());
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                markMod.setStudent_id(Integer.parseInt(rs.getString("student_id")));
                markMod.setFirst_name(rs.getString("first_name"));
                markMod.setLast_name(rs.getString("last_name"));
                markMod.setCourse1(Float.parseFloat(rs.getString("course1")));
                markMod.setCourse2(Float.parseFloat(rs.getString("course2")));
                markMod.setCourse3(Float.parseFloat(rs.getString("course3")));
                markMod.setCourse4(Float.parseFloat(rs.getString("course4")));
                markMod.setCourse5(Float.parseFloat(rs.getString("course5")));
                markMod.setPercent(Double.parseDouble(rs.getString("percentage")));
                markMod.setRank(Integer.parseInt(rs.getString("ranks")));
                
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
