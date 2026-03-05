package org.example.database;

import java.sql.*;


public class DataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "java";
    private static final String PASS = "password";



    // We don't need to close connection because try with resources (so its closes automatically)
    public static Connection getConnection() {

//        String tableSql = "CREATE TABLE IF NOT EXISTS planes"
//                + "(plane_id int PRIMARY KEY AUTO_INCREMENT, brand varchar(100),"
//                + "fuel_per_hr DECIMAL(8,2), in_available BOOLEAN NOT NULL DEFAULT TRUE)"; -------Created Table Plane-----------

//        String insertSql = "ALTER TABLE planes RENAME COLUMN in_available TO is_available"; ----Renamed field in_available to is_avail...----------
//        String insertSql = "INSERT INTO planes(brand, fuel_per_hr, is_available)"
//                + " VALUES('Boeing 747-400', 11000.00, TRUE)";                    -----------
//        String selectSql = "SELECT * FROM planes";
//        try (Connection con = DriverManager
//                .getConnection(URL, USERNAME, PASS)) {
//
//            try (Statement stmt = con.createStatement()) {
////                stmt.execute(insertSql);  ------Can execute both SELECT and INSERT
////                stmt.executeUpdate(insertSql); -----------Can Insert something only
//                String updatePlaneSql = "UPDATE planes SET is_available=? WHERE plane_id=?";
//
//                String preparedSql = "{call insertPlanes(?,?,?,?)}"
//                try (CallableStatement cstmt = con.prepareCall(preparedSql)) {
//
//                    try (PreparedStatement pstmt = con.prepareStatement(updatePlaneSql)) {
//                        pstmt.setBoolean(1, false);
//                        pstmt.setInt(2, 1);
//                        int rowsAffected = pstmt.executeUpdate();
//                        System.out.println(rowsAffected);
//
//                        try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
//                            resultSet.next();
//                            System.out.println(resultSet.getInt("plane_id"));
//                            System.out.println(resultSet.getString("brand"));
//                            System.out.println(resultSet.getBigDecimal("fuel_per_hr"));
//                            System.out.println(resultSet.getBoolean("is_available"));
//
//                        }
//                    }
//                }
//            }

//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // finally { con.close() } --- otherwise
        try {

            Connection con = DriverManager.getConnection(URL, USERNAME, PASS);

            return con;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }
}
