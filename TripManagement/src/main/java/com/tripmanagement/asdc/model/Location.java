package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="location_id")
    private int location_id;

    @Column(name="vehicle_id")
    private int vehicle_id;

    @Column(name="current_location")
    private String current_location;

    @Column(name="starting_location")
    private String starting_location;

    @Column(name="destination")
    private String destination;

    @Column(name="estimated_kms")
    private float estimated_kms;


    public CarOwner() {

    }

    public CarOwner(int location_id, int vehicle_id, String current_location, String starting_location, String destination, float estimated_kms)
    {
        this.current_location= current_location;
        this.estimated_kms= estimated_kms;
        this.vehicle_id=vehicle_id;
        this.location_id=location_id;
        this.starting_location=starting_location;
        this.destination=destination;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(String current_location) {
        this.current_location = current_location;
    }

    public String getStarting_location() {
        return starting_location;
    }

    public void setStarting_location(String starting_location) {
        this.starting_location = starting_location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getEstimated_kms() {
        return estimated_kms;
    }

    public void setEstimated_kms(float estimated_kms) {
        this.estimated_kms = estimated_kms;
    }

    @Override
    public String toString() {
        return "Location [vehicle_id=" + vehicle_id + ", location_id=" + location_id + ", current_location=" + current_location + ", starting_location=" + starting_location + ", destination=" + destination +", estimated_kms=" + estimated_kms +"]";
    }

}





