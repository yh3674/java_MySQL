import java.sql.*;

public class TestApplication_company {
   static final String DB_URL = "jdbc:mysql://localhost/world"; //schema를 콕 찍어줘라 world database 사용
   static final String USER = "root";
   static final String PASS = "tbrs00002b";
   static final String QUERY = "SELECT ID,NAME,AGE,ADDRESS,SALARY " 
                                 + "FROM COMPANY";             // MySQL WORKBENCH에서 복사

   public static void main(String[] args) {
      // Open a connection
      try {
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement(); //query 1, query2 edit window를 띄우기
         ResultSet rs = stmt.executeQuery(QUERY); //집합 set의 결과를 rs에서 받는다
         //ResultSet rs = stmt_02.executeQuery(QUERY); //집합 set의 결과를 rs에서 받는다
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getString("id")); //VARCHAR(200)이었기에 
            System.out.print(", NAME: " + rs.getString("NAME"));
            System.out.println(", AGE: " + rs.getInt("AGE"));
            System.out.println(", ADDRESS: " + rs.getString("ADDRESS"));
            System.out.println(", SALARY: " + rs.getInt("SALARY"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
