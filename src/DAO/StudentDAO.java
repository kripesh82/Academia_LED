package DAO;

import connection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import model.StudentModel;

public class StudentDAO extends DbConnection {

    public boolean add(StudentModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "INSERT INTO students(first_name,last_name,age,address,email,phone_number) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mod.getFirst_name());
            ps.setString(2, mod.getLast_name());
            ps.setInt(3, mod.getAge());
            ps.setString(4, mod.getAddress());
            ps.setString(5, mod.getEmail());
            ps.setString(6, mod.getPhone_number());
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
    
    
    
    public boolean update(StudentModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "UPDATE students Set first_name=? , last_name= ? , age = ?, address=?, email=?, phone_number=? WHERE student_id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mod.getFirst_name());
            ps.setString(2, mod.getLast_name());
            ps.setInt(3, mod.getAge());
            ps.setString(4, mod.getAddress());
            ps.setString(5, mod.getEmail());
            ps.setString(6, mod.getPhone_number());
            ps.setInt(7, mod.getStudent_id());
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
    
    public boolean delete(StudentModel mod) {
        PreparedStatement ps = null;
        Connection conn = dbConnect();

        String sql = "DELETE FROM students WHERE student_id=?";

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
        
        return false; // Added a default return statement outside the try-catch block
    }
    
    public boolean search(StudentModel mod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = dbConnect();

        String sql = "SELECT * FROM students WHERE student_id=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, mod.getStudent_id());
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                mod.setStudent_id(Integer.parseInt(rs.getString("student_id")));
                mod.setFirst_name(rs.getString("first_name"));
                mod.setLast_name(rs.getString("last_name"));
                mod.setAge(Integer.parseInt(rs.getString("age")));
                mod.setAddress(rs.getString("address"));
                mod.setEmail(rs.getString("email"));
                mod.setPhone_number(rs.getString("phone_number"));
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

    
    public List<StudentModel> getAllStudents() {
    List<StudentModel> students = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = dbConnect();

    String sql = "SELECT * FROM students";

    try {
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            StudentModel student = new StudentModel();
            student.setStudent_id(rs.getInt("student_id"));
            student.setFirst_name(rs.getString("first_name"));
            student.setLast_name(rs.getString("last_name"));
            student.setAge(rs.getInt("age"));
            student.setAddress(rs.getString("address"));
            student.setEmail(rs.getString("email"));
            student.setPhone_number(rs.getString("phone_number"));
            students.add(student);
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

    return students;
}

}
