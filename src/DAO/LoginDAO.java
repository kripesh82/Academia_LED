package DAO;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends DbConnection {

    public boolean login(String username, String password) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        } catch (SQLException e) {
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
}
