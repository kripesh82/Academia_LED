package connection;



import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
     public static Connection dbConnect(){
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name","root","password");
            System.out.println("connected");
            return conn;
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    
    }

}
