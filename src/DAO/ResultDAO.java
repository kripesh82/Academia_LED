/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.*;
import static connection.DbConnection.dbConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.ResultModel;

public class ResultDAO extends DbConnection {

    public boolean add(ResultModel mod2) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "INSERT INTO result(student_id,first_name,last_name,course1,course2,course3,course4,course5,percentage,ranks) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,mod2.getStudent_id());
            ps.setString(2, mod2.getFirst_name());
            ps.setString(3, mod2.getLast_name());
            ps.setFloat(4, mod2.getCourse1());
            ps.setFloat(5, mod2.getCourse2());
            ps.setFloat(6, mod2.getCourse3());
            ps.setFloat(7, mod2.getCourse4());
            ps.setFloat(8, mod2.getCourse5());
            ps.setDouble(9,mod2.getPercent());
            ps.setInt(10,mod2.getRank());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
         // Added a default return statement outside the try-catch block
    }
    
    
    
    public boolean update(ResultModel mod2) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "UPDATE result Set first_name=?, last_name=?, course1=?, course2=?, course3=?, course4=?, course5=?, percentage=?, ranks=? WHERE student_id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mod2.getFirst_name());
            ps.setString(2, mod2.getLast_name());
            ps.setFloat(3, mod2.getCourse1());
            ps.setFloat(4, mod2.getCourse2());
            ps.setFloat(5, mod2.getCourse3());
            ps.setFloat(6, mod2.getCourse4());
            ps.setFloat(7, mod2.getCourse5());
            ps.setDouble(8,mod2.getPercent());
            ps.setInt(9,mod2.getRank());
            ps.setInt(10,mod2.getStudent_id());            
            ps.execute();
            return true;

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
    public void updateRank(ResultModel result) {
        PreparedStatement pst = null;
        Connection con = dbConnect();        
        try {
            String sql = "UPDATE result SET ranks = ? WHERE student_id = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, result.getRank());
            pst.setInt(2, result.getStudent_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        
    }    
    
    public boolean delete(ResultModel mod2) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "DELETE FROM result WHERE student_id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,mod2.getStudent_id());
            ps.execute();
            return true;

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
    
public boolean search(ResultModel mod2) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = dbConnect();

    String sql = "SELECT student_id, first_name, last_name FROM students WHERE student_id=?";

    try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, mod2.getStudent_id());
        rs = ps.executeQuery();
        
        if (rs.next()) {
            mod2.setStudent_id(rs.getInt("student_id"));
            mod2.setFirst_name(rs.getString("first_name"));
            mod2.setLast_name(rs.getString("last_name"));
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

        public boolean search2(ResultModel mod2) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = dbConnect();

        String sql = "SELECT * FROM result WHERE student_id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mod2.getStudent_id());
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                mod2.setRank(Integer.parseInt(rs.getString("ranks")));
                mod2.setStudent_id(Integer.parseInt(rs.getString("student_id")));
                mod2.setFirst_name(rs.getString("first_name"));
                mod2.setLast_name(rs.getString("last_name"));
                mod2.setCourse1(Float.parseFloat(rs.getString("course1")));
                mod2.setCourse2(Float.parseFloat(rs.getString("course2")));
                mod2.setCourse3(Float.parseFloat(rs.getString("course3")));
                mod2.setCourse4(Float.parseFloat(rs.getString("course4")));
                mod2.setCourse5(Float.parseFloat(rs.getString("course5")));
                mod2.setPercent(Double.parseDouble(rs.getString("percentage")));
                
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

    
    public List<ResultModel> getAllStudents1() {
    List<ResultModel> result = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = dbConnect();

    String sql = "SELECT * FROM result";

    try {
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            ResultModel resultdata = new ResultModel();
            resultdata.setStudent_id(rs.getInt("student_id"));
            resultdata.setFirst_name(rs.getString("first_name"));
            resultdata.setLast_name(rs.getString("last_name"));
            resultdata.setCourse1(rs.getFloat("course1"));
            resultdata.setCourse2(rs.getFloat("course2"));
            resultdata.setCourse3(rs.getFloat("course3"));
            resultdata.setCourse4(rs.getFloat("course4"));
            resultdata.setCourse5(rs.getFloat("course5"));
            resultdata.setPercent(rs.getDouble("percentage"));
            resultdata.setRank(rs.getInt("ranks"));
            result.add(resultdata);        }
    } catch (Exception e) {
        System.err.println(e);
    } finally {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    return result;
}
}