package mysqljdbcpckg;
import java.sql.*;
public class jdbcDriver {
public static void main (String []args)
{
	
	  try {
          //get connection to the database
          Connection myCon= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","1143");
          //create a statement
          Statement stmt= myCon.createStatement( );
          //execute sql query
          String sql="insert into books(bno,bookname,authorname)values(20,'the way','strange')";
          String sql1="insert into books(bno,bookname,authorname)values(21,'we went','person')";
         
         // String sqlup="update books"+ " set name='ram'" + "where bno=21";
          
         stmt.executeUpdate(sql);
              
          //process the resultset
          ResultSet rs= stmt.executeQuery("select * from books");
        
          while(rs.next())
        	
          {
              System.out.println(rs.getString("bno")+" "+rs.getString("bookname")+" "+rs.getString("authorname"));
        
          }
         
              } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
  }

}		



