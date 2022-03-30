package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "booked_ride_id")
    private int booked_ride_id;

    @Column(name = "customer_id")
    private int customer_id;

    
    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "cost")
    private float cost;

    @Column(name = "seats_booked")
    private int seats_booked;

    @Column(name = "trip_id")
    private int trip_id;

    @Column(name = "isPaid")
    private int isPaid;

    
    public Booking(int booked_ride_id, int customer_id, String timestamp, float cost, float fuel_economy, int seats_booked, int trip_id, int isPaid) {
        this.booked_ride_id = booked_ride_id;
        this.customer_id = customer_id;
        this.timestamp = timestamp;
        this.cost = cost;
        this.seats_booked=seats_booked;
        this.trip_id=trip_id;
        this.isPaid=isPaid;
        
    }

    public Booking() {
    }

    public int getBooked_ride_id() {
        return booked_ride_id;
    }

    public void setBooked_ride_id(int booked_ride_id) {
        this.booked_ride_id = booked_ride_id;
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


    public int getSeats_booked() {
        return seats_booked;
    }

    public void setSeats_booked(int seats_booked) {
        this.seats_booked = seats_booked;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "Booking [booked_ride_id=" + booked_ride_id + ", cost=" + cost + ", customer_id=" + customer_id
                + ", timestamp=" + timestamp + ", seats_booked=" + seats_booked
                + ", trip_id=" + trip_id + ", isPaid=" + isPaid + "]";
    }

    

   

}





