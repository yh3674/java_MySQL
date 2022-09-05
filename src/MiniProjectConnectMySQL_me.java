import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiniProjectConnectMySQL_me {
    public static void main(String[] args) {
        // [Process 1.] MySQL 접속 -> Connect to Database 
                            //(Host,Username 확인 - 그리고 default schema로 'world' 선택) 
                            // Referenced Libraries 첨부 (From the path below) 
                            // C:\Program Files (x86)\MySQL\Connector J 8.0
            final String USER = "root";
            final String PASS = "tbrs00002b";
            final String DB_URL = "jdbc:mysql://localhost/world"; //"jdbc:mysql: 'Connect to Database 내 Connection Method'
            String QUERY = "SELECT Code,Name, Population, Capital " + "FROM Country " // Caution! Must put space after "Population"
           
                                            + "WHERE 1 = 1 "  //Caution! Watch for + signs
                                            + "AND Name like '%an%' "; 
                                            
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                   // Red Underline -> Quick Fix로 'Import Connection' (java.sql) 'Import DriverManager' (java.sql)
                   // getConnection () Error pop-up => Quick fix with Surrounding Try and Catch
                // [Process 2.] Process 1에서 Database 'world'에 Connect 되었는지 확인 (Bold로 Highlight) (Check at MySQL)

                //[Process 3.] CITY TABLE 에서 모든 DATA를 출력
                    Statement stmt = conn.createStatement(); // == MySQL 내 Query1 
                    //QUICK FIX -> Import 'Statement'(java.sql)
                    
                    // SELECT * FROM CITY 쿼리문 입력, CTRL + ENTER로 실행
                    ResultSet rs = stmt.executeQuery(QUERY);
                    // Red Underline -> Quick Fix로 'Import ResultSet'(java.sql)
                    // Line-by-line computer-based read를 가능하게 함 
                    while (rs.next()) { // 데이터의 양을 모름--> while, 알면 for문으로 접근
                        // Retrieve by column name
                            System.out.print("CODE: " + rs.getString("CODE"));
                            System.out.print(", NAME: " + rs.getString("NAME"));
                            System.out.print(", POPULATION: " + rs.getInt("POPULATION"));
                            System.out.print(", Capital: " + rs.getInt("Capital"));
                        
                    }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
      
       
        // Process 4.  IF succeeded, 
                        // ID, NAME, CountryCode, District, Population Column 확인
        // Process 5. Column 내 dataset 확인

        return;
    }
}