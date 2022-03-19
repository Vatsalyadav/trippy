package com.tripmanagement.asdc.model;

public class Ride {
    private int trip_id;
    private String vehicleName;
    private float fuel_economy;
    private String vehicleOwnerName;
    private String phone;
    private float cost;

    
    public Ride(int trip_id,String vehicleName, float fuel_economy, String vehicleOwnerName, String phone, float cost) {
        this.trip_id=trip_id;
        this.vehicleName = vehicleName;
        this.fuel_economy = fuel_economy;
        this.vehicleOwnerName = vehicleOwnerName;
        this.phone = phone;
        this.cost = cost;
    }
    
    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getVehicleName() {
        return vehicleName;
    }
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    public float getFuel_economy() {
        return fuel_economy;
    }
    public void setFuel_economy(float fuel_economy) {
        this.fuel_economy = fuel_economy;
    }
    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }
    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    


    
}
