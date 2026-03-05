package org.example.database;

import java.math.BigDecimal;

public class PlanesModel {
    private Integer id;
    private String brand;
    private BigDecimal fuelPerHr;
    private Boolean isAvailable;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}

    public BigDecimal getFuelPerHr() {return fuelPerHr;}
    public void setFuelPerHr(BigDecimal fuelPerHr) {this.fuelPerHr = fuelPerHr;}

    public Boolean getIsAvailable() {return isAvailable;}
    public void setIsAvailable(Boolean isAvailable) {this.isAvailable = isAvailable;}
}
