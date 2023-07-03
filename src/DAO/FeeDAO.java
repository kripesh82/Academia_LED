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
import model.FeeModel;

/**
 *
 * @author User
 */
public class FeeDAO extends DbConnection {

    public boolean add(FeeModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "INSERT INTO fee(student_id,first_name,last_name,months,tution,eca,mic,other,due,total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,mod.getStudent_id());
            ps.setString(2, mod.getFirst_name());
            ps.setString(3, mod.getLast_name());
            ps.setString(4, mod.getSelectedComboBoxOption());
            ps.setFloat(5, mod.getTution());
            ps.setFloat(6, mod.getEca());
            ps.setFloat(7, mod.getMic());
            ps.setFloat(8, mod.getOther());
            ps.setFloat(9, mod.getDue());
            ps.setDouble(10,mod.getTotal());
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

    }
    
public boolean update(FeeModel mod) {
    PreparedStatement ps = null;
    Connection conn = dbConnect();

    String sql = "UPDATE fee SET first_name=?, last_name=?, months=?, tution=?, eca=?, mic=?, other=?, due=?, total=? WHERE student_id=?";

    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, mod.getFirst_name());
        ps.setString(2, mod.getLast_name());
        ps.setString(3, mod.getSelectedComboBoxOption());
        ps.setFloat(4, mod.getTution());
        ps.setFloat(5, mod.getEca());
        ps.setFloat(6, mod.getMic());
        ps.setFloat(7, mod.getOther());
        ps.setFloat(8, mod.getDue());
        ps.setDouble(9, mod.getTotal());
        ps.setInt(10, mod.getStudent_id());
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
}

        
    public boolean delete(FeeModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "DELETE FROM fee WHERE student_id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,mod.getStudent_id());
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
        
        return false;
    }
    
    
    public boolean search(FeeModel mod) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = dbConnect();

    String sql = "SELECT student_id, first_name, last_name FROM students WHERE student_id=?";

    try {
        ps = conn.prepareStatement(sql);
        ps.setInt(1, mod.getStudent_id());
        rs = ps.executeQuery();
        
        if (rs.next()) {
            mod.setStudent_id(rs.getInt("student_id"));
            mod.setFirst_name(rs.getString("first_name"));
            mod.setLast_name(rs.getString("last_name"));
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
    
    return false; 
}
    
    
    
    
        public boolean search2(FeeModel mod) {
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
        
        return false;
    }
        
        
    public List<FeeModel> getAllStudents() {
    List<FeeModel> fee = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = dbConnect();

    String sql = "SELECT * FROM fee";

    try {
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            FeeModel feedata = new FeeModel();
            feedata.setStudent_id(rs.getInt("student_id"));
            feedata.setFirst_name(rs.getString("first_name"));
            feedata.setLast_name(rs.getString("last_name"));
            feedata.setSelectedComboBoxOption(rs.getString("months"));
            feedata.setTution(rs.getFloat("tution"));
            feedata.setEca(rs.getFloat("eca"));
            feedata.setMic(rs.getFloat("mic"));
            feedata.setOther(rs.getFloat("other"));
            feedata.setDue(rs.getFloat("due"));
            feedata.setTotal(rs.getFloat("total"));
            fee.add(feedata);
        }
    } catch (Exception e) {
        System.err.println(e);
    } finally {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    return fee;
}
    
}
