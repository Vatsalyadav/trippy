package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Parking")
public class Parking {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="parking_id")
    private int parking_id;

    @Column(name="vehicle_id")
    private int vehicle_id;

    @Column(name="address")
    private String address;

    @Column(name="capacity")
    private int capacity;

    @Column(name="occupation")
    private int occupation;

    @Column(name="availability")
    private int availability;

    public Parking(int parking_id, int vehicle_id, String address, int capacity, int occupation, int availability){
        this.parking_id=parking_id;
        this.vehicle_id=vehicle_id;
        this.address=address;
        this.capacity=capacity;
        this.occupation=occupation;
        this.availability=availability;
    }

    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Parking{" +
                "parking_id=" + parking_id +
                ", vehicle_id=" + vehicle_id +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", occupation=" + occupation +
                ", availability=" + availability +
                '}';
    }
}





