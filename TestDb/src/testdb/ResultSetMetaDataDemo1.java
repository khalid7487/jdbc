
package testdb;

import java.sql.*;
import java.io.*;

public class ResultSetMetaDataDemo1 {
    Connection con;

    public ResultSetMetaDataDemo1() {
     try{
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "root","7487");
     }catch(Exception e){
         System.out.println("Error in connection"+e);
     }
    }
    public void displyRecords(String tableName){
        String columnHeading="";
        try{
            Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery("select * from "+
                    tableName.trim());
            if(res.next()){
                ResultSetMetaData rsmd=res.getMetaData();
                int colunmCount=rsmd.getColumnCount();
                for (int i = 1; i <= colunmCount; i++) {
                    columnHeading=columnHeading+"\t"+rsmd.getColumnName(i);
                    
                }
                System.out.println(columnHeading);
                //for first row
                for (int i = 1; i <=colunmCount; i++) {
                    System.out.println("\t"+res.getString(i)+
                            "\t"+rsmd.getColumnTypeName(i));   
                }
                System.out.println("\n");
                while(res.next()){
                    for (int i = 1; i <= colunmCount; i++) {
                        System.out.println("\t"+res.getString(i)+"\t"
                        +rsmd.getColumnTypeName(i));
                        
                    }
                    System.out.println("\n");
                }
            }else{
                System.out.println("There is no records in table");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ResultSetMetaDataDemo1 obj=new ResultSetMetaDataDemo1();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String choice="";
        try {
            do {                
                System.out.println("Enter table name to display records using "
                        + "ResultSetMetaData interface");
                String name=br.readLine();
                obj.displyRecords(name);
                System.out.println("Do you want to continue(yes)");
                choice=br.readLine();
            } while (choice.trim().equals("yes"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
