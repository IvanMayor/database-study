package org.example;

import org.example.database.DataBase;
import org.example.database.PlanesModel;
import org.example.database.PlanesService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        PlanesService planesService = new PlanesService();
//        planesService.createPlane("Airbus A350-900", BigDecimal.valueOf(6100.00), true);

        List<PlanesModel> planes = planesService.getAllPlanes();
        planesService.updatePlane(6);

        for (PlanesModel plane : planes) {
            int id = plane.getId();
            String brand = plane.getBrand();
            BigDecimal fuel = plane.getFuelPerHr();
            Boolean available = plane.getIsAvailable();

            System.out.println(id + " - " + brand + " - " + fuel + " - " + available + ".");
        }
    }
}
