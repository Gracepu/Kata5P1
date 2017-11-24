package kata5p1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","system","orcl");
        
        Statement statement = cn.createStatement();
        
        String query = "SELECT * FROM HISTORICO_CAMBIOS WHERE DIVISA_DESDE = 'EUR' AND DIVISA_A = 'USD'";
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            System.out.println(rs.getString(1) + " ==> " + rs.getString(2) + " = " + rs.getDouble(3) + " #" +
                    rs.getTimestamp(6, Calendar.getInstance()) + " --- " + 
                    rs.getDate(6,Calendar.getInstance()) + " --- " +
                    rs.getTime(6, Calendar.getInstance()));
        }
    }
}
