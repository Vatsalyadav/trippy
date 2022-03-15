package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="vehicle_id")
    private int vehicle_id;

    @Column(name="vehicleowner_id")
    private int vehicleowner_id;

    @Column(name="number_plate")
    private String number_plate;

    @Column(name="vehicle_name")
    private String vehicle_name;

    @Column(name="type")
    private String type;

    @Column(name="kms_driven")
    private float kms_driven;

    @Column(name="available_seats")
    private int available_seats;

    @Column(name="fuel_consumed")
    private float fuel_consumed;

    public Vehicle() {
    }

    public Vehicle(int vehicle_id, vehicleowner_id, String number_plate, String vehicle_name, String type, float kms_driven, float fuel_consumed, int available_seats)
    {
        this.vehicle_id= vehicle_id;
        this.vehicleowner_id= vehicleowner_id;
        this.number_plate= number_plate;
        this.vehicle_name= vehicle_name;
        this.type= type;
        this.kms_driven= kms_driven;
        this.fuel_consumed= fuel_consumed;
        this.available_seats= available_seats;


    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getVehicleowner_id() {
        return vehicleowner_id;
    }

    public void setVehicleowner_id(int vehicleowner_id) {
        this.vehicleowner_id = vehicleowner_id;
    }

    public String getNumber_plate() {
        return number_plate;
    }

    public void setNumber_plate(String number_plate) {
        this.number_plate = number_plate;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getKms_driven() {
        return kms_driven;
    }

    public void setKms_driven(float kms_driven) {
        this.kms_driven = kms_driven;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public float getFuel_consumed() {
        return fuel_consumed;
    }

    public void setFuel_consumed(float fuel_consumed) {
        this.fuel_consumed = fuel_consumed;
    }

    @Override
    public String toString() {
        return "Vehicle [vehicle_id=" + vehicle_id + ", vehicleowner_id=" + vehicleowner_id + ", number_plate=" + number_plate + ", vehicle_name=" + vehicle_name +", kms_driven=" + kms_driven +", fuel_consumed=" + fuel_consumed +", available_seats=" + available_seats + "]";
    }

}





