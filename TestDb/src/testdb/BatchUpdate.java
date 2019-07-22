
package testdb;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BatchUpdate {
    
    public static void main(String[] args) throws SQLException {
        Connection con=null;
        Statement st=null;
        
        String url="jdbc:mysql://localhost:3306/test";
        String user="root";
        String password="7487";
        try{
            con=DriverManager.getConnection(url,user,password);
            con.setAutoCommit(false);
            st=con.createStatement();
            st.addBatch("Delete From authors");
            st.addBatch("INSERT INTO authors(name) VALUES('Khalid')");
            st.addBatch("INSERT INTO authors(name) VALUES('Rakib')");
            st.addBatch("INSERT INTO authors(name) VALUES('sabab')");
            st.addBatch("INSERT INTO authors(name) VALUES('shuvo')");
            int counts[]=st.executeBatch();
            con.commit();
            System.out.println("Commited "+counts.length+"Updates");
            
        }catch(Exception e){
            if(con !=null){
                try{
                    con.rollback();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
        finally{
            con.close();
        }
    }
    
}
