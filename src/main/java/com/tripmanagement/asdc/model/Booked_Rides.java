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

}





