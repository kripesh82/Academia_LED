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
import model.ForgotPasswordModel;

/**
 *
 * @author User
 */
public class ForgotPasswordDAO extends DbConnection {
        public boolean update(ForgotPasswordModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "UPDATE users Set password=? WHERE username=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mod.getNew_password());
            ps.setString(2, mod.getUsername());
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
    
        
    public boolean checkSecurity(String username, String security) {
    PreparedStatement ps = null;
    Connection conn = dbConnect();
    ResultSet rs = null;

    String sql = "SELECT * FROM users WHERE username = ? AND security = ?";

    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, security);
        rs = ps.executeQuery();

        if (rs.next()) {
            // If the query returns a row, the secuity is correct
            return true;
        }
    } catch (SQLException e) {
        System.err.println(e);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    return false; // Default return statement outside the try-catch block
}
    
    
        public boolean checkUsernameExists(String username) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();
        ResultSet rs = null;

        String sql = "SELECT * FROM users WHERE username = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                // If the query returns a row, the username exists
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return false;
    }

}
