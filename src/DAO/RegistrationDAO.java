package DAO;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.RegistrationModel;

public class RegistrationDAO extends DbConnection {

public boolean register(RegistrationModel mod) {
    PreparedStatement ps = null;
    Connection conn = dbConnect();

    String sql = "INSERT INTO users (first_name, last_name, username, staff_id, password) VALUES (?, ?,?, ?, ?)";

    try {
        if (checkUsernameExists(mod.getUsername(), conn)) {
            JOptionPane.showMessageDialog(null, "Username already exists");
        }

        ps = conn.prepareStatement(sql);
        ps.setString(1, mod.getFname());
        ps.setString(2, mod.getLname());
        ps.setString(3, mod.getUsername());
        ps.setString(4, mod.getStaffid());
        ps.setString(5, mod.getPassword());

        ps.execute();
        return true;
    } catch (Exception e) {
        System.err.println(e);
        return false;
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

    private boolean checkUsernameExists(String username, Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        return count > 0;
    }
}
