
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    
    public class MiniProjectConnectMySQL_me_backup {
        public static void main(String[] args) {
            // [Process 1.] MySQL 접속 -> Connect to Database
            // (Host,Username 확인 - 그리고 default schema로 'world' 선택)
            // Referenced Libraries 첨부 (From the path below)
            // C:\Program Files (x86)\MySQL\Connector J 8.0
            final String USER = "root";
            final String PASS = "tbrs00002b";
            final String DB_URL = "jdbc:mysql://localhost/data_biz_polls"; // "jdbc:mysql: 'Connect to Database 내 Connection Method'
            String QUERY = "SELECT ID_CODE,QUESTION_CODE,ANSWER_CODE " + 
                                "FROM survey_result "; // Caution! Must put space after
                                                                                      // "Population"
    
    
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                // Red Underline -> Quick Fix로 'Import Connection' (java.sql) 'Import
                // DriverManager' (java.sql)
                // getConnection () Error pop-up => Quick fix with Surrounding Try and Catch
                // [Process 2.] Process 1에서 Database 'world'에 Connect 되었는지 확인 (Bold로 Highlight)
                // (Check at MySQL)
                Statement stmt = conn.createStatement();

                int ID_CODE = 12;
                //INSERT
                QUERY =  "insert into survey_results(ID_CODE, QUESTION_CODE, ANSWER_CODE) " +
                                " values (ID_CODE,2,3)";
                int val = stmt.executeUpdate(QUERY);

                ResultSet rs = stmt.executeQuery(QUERY);
                // Red Underline -> Quick Fix로 'Import ResultSet'(java.sql)
                // Line-by-line computer-based read를 가능하게 함
                
                while (rs.next()) { // 데이터의 양을 모름--> while, 알면 for문으로 접근
                    // Retrieve by column name
                    System.out.print(" ID_CODE: " + rs.getInt("ID_CODE"));
                    System.out.print(", QUESTION_CODE: " + rs.getInt("QUESTION_CODE"));
                    System.out.print(", POPULATION: " + rs.getInt("ANSWER_CODE"));

                //UPDATE

                QUERY =  "UPDATE INTO survey_results " +
                            "SET ID_CODE, QUESTION_CODE, ANSWER_CODE " +
                                " values (ID_CODE,2,3)";
                val = stmt.executeUpdate(QUERY);

                
                //DELETE
                QUERY =  "DELETE FROM survey_results " +
                         "WHERE ID_CODE = 12 ";
                val = stmt.executeUpdate(QUERY);

                //SELECT [Brake 겸 - 단계별 확인 ]
                System.out.println();
    
            }
    
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Process 4. IF succeeded,
        // ID, NAME, CountryCode, District, Population Column 확인
        // Process 5. Column 내 dataset 확인

        return;
    }
}   

    
    
    
    
    
    
    
    
               
    

