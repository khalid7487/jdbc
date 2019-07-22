
package testdb;
import java.sql.*;

public class Test {


    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        Connection con=null;
        Statement stmt=null;
        try{
            //Register the Dirver class
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "root","7487");
            //Create the statement object
            stmt=con.createStatement();
            int count=0;
            count=stmt.executeUpdate("insert into employee(name,city,salary)"
                    + "values('salam','Dhaka','50000')");
            if(count>0){
                System.out.println("Inserted sucessfully");
            }else{
                System.out.println("Insertion failed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            con.close();
        }
    }
    
}
