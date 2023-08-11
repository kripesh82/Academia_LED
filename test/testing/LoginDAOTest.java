///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package testing;
//
//import connection.DbConnection;
//import DAO.LoginDAO;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import model.LoginModel;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author SMASHED TOMATOES
// */
//public class LoginDAOTest {
//    
//    private LoginDAO loginDAO;
//    private Connection connection;
//    
//    public LoginDAOTest(){
//        
//    }
//    
//    @Before
//    public void setUp(){
//        loginDAO = new LoginDAO();
//        connection = DbConnection.dbConnect();
//    }
//    
//    @Test
//    public void testLogin(){
//        System.out.println("testLogin");
//        
//        LoginModel loginModel = new LoginModel();
//        loginModel.setUsername("admin");
//        loginModel.setPassword("admin");
//        
//        boolean result = loginDAO.login(loginModel.getUsername(),loginModel.getPassword());
//        assertTrue(result);
//        
//    }    
//}
