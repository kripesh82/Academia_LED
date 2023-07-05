package DAO;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import model.AttendanceModel;

public class AttendanceDAO extends DbConnection {
    public boolean addAttendanceData(int studentId, String studentName, String date, String attendance) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();
        String query = "INSERT INTO attendance (atStudent_id, atStudent_Name, atdate, attendance) VALUES (?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.setString(2, studentName);
            ps.setString(3, date);
            ps.setString(4, attendance);

            int rowsAffected = ps.executeUpdate();

            // If rowsAffected is greater than 0, it means the data was inserted successfully
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            closeResources(ps, conn);
        }
    }

    public List<AttendanceModel> getAttendanceData(int studentId) {
        List<AttendanceModel> attendanceList = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = dbConnect();
        ResultSet rs = null;

        String query = "SELECT * FROM attendance WHERE atStudent_id = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, studentId);

            rs = ps.executeQuery();

            while (rs.next()) {
                AttendanceModel attendance = new AttendanceModel();
                attendance.setAtStudentId(rs.getInt("atStudent_id"));
                attendance.setAtStudentName(rs.getString("atStudent_Name"));
                // Convert the string date to a Date object
                String dateString = rs.getString("atdate");
                Date date = Date.valueOf(dateString);
                attendance.setAtDate(date);
                attendance.setAttendanceStatus(rs.getString("attendance"));

                attendanceList.add(attendance);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            closeResources(rs, ps, conn);
        }

        return attendanceList;
    }
    
    public List<AttendanceModel> getAttendanceDataByDate(String date) {
        List<AttendanceModel> attendanceList = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = dbConnect();
        ResultSet rs = null;

        String query = "SELECT * FROM attendance WHERE atdate = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, date);

            rs = ps.executeQuery();

            while (rs.next()) {
                AttendanceModel attendance = new AttendanceModel();
                attendance.setAtStudentId(rs.getInt("atStudent_id"));
                attendance.setAtStudentName(rs.getString("atStudent_Name"));
                attendance.setAtDate(rs.getDate("atdate"));
                attendance.setAttendanceStatus(rs.getString("attendance"));

                attendanceList.add(attendance);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            closeResources(rs, ps, conn);
        }

        return attendanceList;
    }
    
    public List<AttendanceModel> getAttendanceDataByStudentAndDate(int studentId, String date) {
        List<AttendanceModel> attendanceList = new ArrayList<>();
        PreparedStatement ps = null;
        Connection conn = dbConnect();
        ResultSet rs = null;

        String query = "SELECT * FROM attendance WHERE atStudent_id = ? AND atdate = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.setString(2, date);

            rs = ps.executeQuery();

            while (rs.next()) {
                AttendanceModel attendance = new AttendanceModel();
                attendance.setAtStudentId(rs.getInt("atStudent_id"));
                attendance.setAtStudentName(rs.getString("atStudent_Name"));
                attendance.setAtDate(rs.getDate("atdate"));
                attendance.setAttendanceStatus(rs.getString("attendance"));

                attendanceList.add(attendance);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            closeResources(rs, ps, conn);
        }

        return attendanceList;
    }
    
    public boolean deleteAttendanceData(int studentId, String date) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();
        String query = "DELETE FROM attendance WHERE atStudent_id = ? AND atdate = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.setString(2, date);

            int rowsAffected = ps.executeUpdate();

            // If rowsAffected is greater than 0, it means data was deleted successfully
            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            closeResources(ps, conn);
        }
    }

    private void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            closeResources(ps, conn);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void closeResources(PreparedStatement ps, Connection conn) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
