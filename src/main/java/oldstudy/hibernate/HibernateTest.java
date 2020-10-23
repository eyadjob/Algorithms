package oldstudy.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HibernateTest {


    public static void main(String[] args) {

        ConnectDB connectDB = new ConnectDB();
        Connection con = connectDB.connect();
        try {
            Statement sql = con.createStatement();
            String query = "SELECT * FROM person ";

          ResultSet re  =  sql.executeQuery(query);
            System.out.println(re);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Configuration conf = new Configuration().configure().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = conf.buildSessionFactory();
        Person person = new Person();



    }

}
