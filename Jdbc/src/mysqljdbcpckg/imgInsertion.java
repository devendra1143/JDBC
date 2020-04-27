package mysqljdbcpckg;
import java.io.*;
import java.sql.*;

 

public class imgInsertion 
{
   public static void main(String args[]) throws Exception 
   {
       Connection mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject","root","1143");               
       Statement stmt=mycon.createStatement(); 
       //Inserting values
       String s = "insert into project(empid, empname , empsal, image, file) VALUES (?, ?, ?, ?, ?)";
       PreparedStatement pstmt = mycon.prepareStatement(s);
       pstmt.setInt(1, 101);
       pstmt.setString(2, "arun");
       pstmt.setInt(3, 25000);
       FileInputStream fin = new FileInputStream("C:\\Users\\Satya Sai Ram\\javaimg.jpg");
       pstmt.setBinaryStream(4, fin);
       FileInputStream fin2 = new FileInputStream("C:\\Users\\Satya Sai Ram\\SQL.docx");
       pstmt.setBinaryStream(5, fin2);
       pstmt.execute();

 

       System.out.println("Data inserted");
       ResultSet rs = stmt.executeQuery("Select * from project");
       while(rs.next()) 
       {
         System.out.println("EmpID: "+rs.getInt("empid"));
         System.out.println("EmpNAME: "+rs.getString("empname"));
         System.out.println("EmpSal: "+rs.getInt("empsal"));
         System.out.println("IMAGE: "+rs.getBlob("image"));
         System.out.println("FILE: "+rs.getClob("file"));
       }
       try
       {
            mycon.setAutoCommit(false);
            mycon.commit();
        } 
        catch (SQLException e) 
        {
            mycon.rollback();
       }
   }
}