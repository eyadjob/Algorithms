package hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDB {



    public Connection connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        try {
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/person", "root", "123123" );
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }

  public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection( "localhost", "root", "123123" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
