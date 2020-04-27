package mysqljdbcpckg;

import java.sql.*;

public class Employee 
{
    public static void main(String args[]) throws SQLException
    {
        PreparedStatement mystmnt= null;
        ResultSet myRes= null;
        
            try 
            {
                Connection mycon= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1143");
                //create a statement
                Statement mystmt= mycon.createStatement();
                //prepare statement
                mystmnt = mycon.prepareStatement("select * from employees where salary >? or  department=? or email=?");
                //Set the parameters 
                mystmnt.setDouble(1,75000);
                mystmnt.setString(2,"Legal");
                mystmnt.setString(3,"...");
                //Execute the SQL query 
                myRes = mystmnt.executeQuery();
                while(myRes.next())
                {
                    System.out.println(myRes.getString("last_name")+" "+myRes.getDouble("salary"));
                }
            } 
            catch (SQLException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
    
    }
}