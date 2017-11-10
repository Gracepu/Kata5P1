package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Desktop\\SQLiteDatabaseBrowserPortable\\Data\\Kata5.db");
        
        Statement statement = cn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT name FROM PEOPLE");
        
        while (rs.next()) {
            System.out.println("NAME = " + rs.getString("name"));
        }
        
        String query = "CREATE TABLE IF NOT EXISTS mail (\n"
                + "     Id INTEGER PRIMARY KEY AUTOINCREMENT, \n"
                + "     Mail TEXT NOT NULL\n"
                + ");";
        System.out.println(query);
        statement.execute(query);
        
        String nameMails = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata5P1\\src\\kata5p1\\emails.txt";
        ArrayList<String> mails = new ArrayList<>();
        BufferedReader filein = new BufferedReader(new FileReader(new File(nameMails)));
        
        String mail;
        while((mail = filein.readLine()) != null) {
            if(!mail.contains("@")) continue;
            mails.add(mail);
        }
        
        for (String m : mails) {
            query = "INSERT INTO mail (mail) VALUES ('" + m + "');";
            System.out.println(query);
            statement.executeUpdate(query);
        }
    }
}
