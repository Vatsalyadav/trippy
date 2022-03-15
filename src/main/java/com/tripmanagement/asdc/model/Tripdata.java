package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Tripdata")
public class Tripdata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "trip_id")
    private int trip_id;

    @Column(name = "destination")
    private String destination;

    @Column(name = "location_id")
    private int location_id;

    @Column(name = "vehicle_id")
    private int vehicle_id;

    @Column(name = "vehicleowner_id")
    private int vehicleowner_id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "estimated_kms")
    private float estimated_kms;

    @Column(name = "kms_travelled")
    private float kms_travelled;

    @Column(name = "timestamp")
    private Date timestamp;

    public Tripdata(int trip_id, String destination, int location_id, int vehicle_id, int vehicleowner_id, int customer_id, float estimated_kms, float kms_travelled, Date timestamp) {
        this.trip_id = trip_id;
        this.destination = destination;
        this.location_id = location_id;
        this.vehicle_id = vehicle_id;
        this.vehicleowner_id = vehicleowner_id;
        this.customer_id = customer_id;
        this.estimated_kms = estimated_kms;
        this.kms_travelled = kms_travelled;
        this.timestamp= timestamp;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public int getVehicleowner_id() {
        return vehicleowner_id;
    }

    public void setVehicleowner_id(int vehicleowner_id) {
        this.vehicleowner_id = vehicleowner_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public float getEstimated_kms() {
        return estimated_kms;
    }

    public void setEstimated_kms(float estimated_kms) {
        this.estimated_kms = estimated_kms;
    }

    public float getKms_travelled() {
        return kms_travelled;
    }

    public void setKms_travelled(float kms_travelled) {
        this.kms_travelled = kms_travelled;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Tripdata [trip_id=" + trip_id + ", destination=" + destination + ", estimated_kms=" + estimated_kms + ", location_id=" + location_id +", vehicle_id=" + vehicle_id +", customer_id=" + customer_id +", kms_travelled=" + kms_travelled + ", timestamp=" + timestamp + "]";
    }

}





