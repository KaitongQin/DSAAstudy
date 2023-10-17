import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class Data{
    private Connection con = null;
    private ResultSet resultSet;

    private String host = "10.16.210.181";
    private String dbname = "postgres";
    private String user = "postgres";
    private String pwd = "123123";
    private String port = "5432";


    private void getConnection() {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (Exception e) {
            System.err.println("Cannot find the PostgreSQL driver. Check CLASSPATH.");
            System.exit(1);
        }

        try {
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbname;
            con = DriverManager.getConnection(url, user, pwd);

        } catch (SQLException e) {
            System.err.println("Database connection failed");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }


    private void closeConnection() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private int addUser(File file) {
        String line;
        int result = 0;
        String sql = "insert into Users (Mid, Name, Sex, Birthday, Level, Sign, identity)" + "values(?,?,?,?,?,?,?)";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null) {
                String[] user = line.split(",");
                preparedStatement.setString(1,user[0]);
                preparedStatement.setString(2,user[1]);
                preparedStatement.setString(3,user[2]);
                preparedStatement.setString(4,user[3]);
                preparedStatement.setString(5,user[4]);
                preparedStatement.setString(6,user[5]);
                preparedStatement.setString(7,user[user.length - 1]);
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
