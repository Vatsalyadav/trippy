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


}





