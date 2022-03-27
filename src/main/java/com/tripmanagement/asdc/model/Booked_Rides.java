package com.tripmanagement.asdc.model;


import javax.persistence.*;


@Entity
@Table(name="Booked_rides")
public class Booked_Rides {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "booked_ride_id")
    private int booked_ride_id;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "distance")
    private float distance;

    @Column(name = "vehicle_id")
    private int vehicle_id;

    @Column(name = "vehicleowner_id")
    private int vehicleowner_id;

    @Column(name = "customer_id")
    private int customer_id;

    
    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "cost")
    private float cost;

    @Column(name = "fuel_economy")
    private float fuel_economy;
    public Booked_Rides(int booked_ride_id, String source, String destination, float distance, int vehicle_id,
                        int vehicleowner_id, int customer_id, String timestamp, float cost, float fuel_economy) {
        this.booked_ride_id = booked_ride_id;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.vehicle_id = vehicle_id;
        this.vehicleowner_id = vehicleowner_id;
        this.customer_id = customer_id;
        this.timestamp = timestamp;
        this.cost = cost;
        this.fuel_economy = fuel_economy;
    }

    public Booked_Rides() {
    }

    public int getBooked_ride_id() {
        return booked_ride_id;
    }

    public void setBooked_ride_id(int booked_ride_id) {
        this.booked_ride_id = booked_ride_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getFuel_economy() {
        return fuel_economy;
    }

    public void setFuel_economy(float fuel_economy) {
        this.fuel_economy = fuel_economy;
    }
    @Override
    public String toString() {
        return "Booked_Rides [booked_ride_id=" + booked_ride_id + ", cost=" + cost + ", customer_id=" + customer_id
                + ", destination=" + destination + ", distance=" + distance + ", fuel_economy=" + fuel_economy
                + ", source=" + source + ", timestamp=" + timestamp + ", vehicle_id=" + vehicle_id
                + ", vehicleowner_id=" + vehicleowner_id + "]";
    }

}





