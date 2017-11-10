package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Desktop\\SQLiteDatabaseBrowserPortable\\Data\\Kata5.db");
        
        Statement statement = cn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT name FROM PEOPLE");
        
        while (rs.next()) {
            System.out.println("NAME = " + rs.getString("name"));
        }
    }
}
