package com.tripmanagement.asdc.model;

public class Ride {
    private int trip_id;
    private String vehicleName;
    private String numberPlate;
    private float fuel_economy;
    private String vehicleOwnerName;
    private int vehicleOwnerId;
    private String phone;
    private float cost;
    private int availableSeats;

    public Ride(int trip_id, String vehicleName, String numberPlate, float fuel_economy,
                String vehicleOwnerName, int vehicleOwnerId, String phone, float cost, int availableSeats) {
        this.trip_id = trip_id;
        this.vehicleName = vehicleName;
        this.numberPlate = numberPlate;
        this.fuel_economy = fuel_economy;
        this.vehicleOwnerName = vehicleOwnerName;
        this.vehicleOwnerId = vehicleOwnerId;
        this.phone = phone;
        this.cost = cost;
        this.availableSeats = availableSeats;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getVehicleOwnerId() {
        return vehicleOwnerId;
    }

    public void setVehicleOwnerId(int vehicleOwnerId) {
        this.vehicleOwnerId = vehicleOwnerId;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
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
