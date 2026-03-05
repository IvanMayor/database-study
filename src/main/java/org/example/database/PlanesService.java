package org.example.database;

import org.example.database.DataBase;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanesService extends DataBase {
    public void createPlane(String brand, BigDecimal fuel_per_hr, Boolean is_available) {
        try {
            Connection con = getConnection();

            String prepareSql = "{call insertPlane(?,?,?,?)}";

            try (CallableStatement cstmt = con.prepareCall(prepareSql)) {
                cstmt.setString(2, brand);
                cstmt.setBigDecimal(3, fuel_per_hr);
                cstmt.setBoolean(4, is_available);

                cstmt.execute();

            int new_int = cstmt.getInt(1);
            System.out.println("---------------We just created new Plane with index: " + new_int);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            con.close();
            System.out.println("Did we close connection?  -----------> " + con.isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PlanesModel> getAllPlanes() {
        List<PlanesModel> allPlanes = new ArrayList<>();
        String sqlRequestAll = "SELECT * FROM planes";

        try (Connection con = getConnection()) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet resultSet = stmt.executeQuery(sqlRequestAll)) {
                    while (resultSet.next()) {

                        PlanesModel plane = new PlanesModel();

                        plane.setId(resultSet.getInt(1));
                        plane.setBrand(resultSet.getString(2));
                        plane.setFuelPerHr(resultSet.getBigDecimal(3));
                        plane.setIsAvailable(resultSet.getBoolean(4));

                        allPlanes.add(plane);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPlanes;
    }
}
