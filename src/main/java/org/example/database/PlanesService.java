package org.example.database;

import org.example.database.DataBase;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanesService extends DataBase {
    public void createPlane(String brand, BigDecimal fuel_per_hr, Boolean is_available) {
        try (Connection con = getConnection()) {

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

    public void updatePlane(Integer id) {
        try (Connection con = getConnection()) {

//            String requestByIdStatement = "SELECT * FROM planes WHERE plane_id=" + id;
            String requestByIdStatement = "SELECT * FROM planes WHERE plane_id=" + id;

            try (Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

                try (ResultSet updatableResultSet = stmt.executeQuery(requestByIdStatement)) {

                    updatableResultSet.next();
                    updatableResultSet.updateString("brand", "Airbus A350-9001");
                    updatableResultSet.updateBigDecimal("fuel_per_hr", BigDecimal.valueOf(6100.00));
                    updatableResultSet.updateBoolean("is_available", false);

                    updatableResultSet.updateRow();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
