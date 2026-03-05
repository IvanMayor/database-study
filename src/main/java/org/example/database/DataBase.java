package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "java";
    private static final String PASS = "password";



    // We don't need to close connection because try with resources (so its closes automatically)
    public static void getConnection() {

//        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection con = DriverManager
                .getConnection(URL, USERNAME, PASS)) {
            con.isValid(1000);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // finally { con.close() } --- otherwise

    }
}
