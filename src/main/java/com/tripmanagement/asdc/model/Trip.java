package com.tripmanagement.asdc.model;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private int trip_id;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "vehicle_id")
    private int vehicle_id;

    @Column(name = "estimated_kms")
    private float estimated_kms;

    @Column(name = "kms_travelled")
    private float kms_travelled;

    @Column(name = "available_seats")
    private int available_seats;

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "end_time")
    private String end_time;

    @Column(name = "seats_taken")
    private int seats_taken;

    @Column(name = "cost")
    private float cost;

    @Autowired
    public Trip(int trip_id, String source, String destination, int vehicle_id, float estimated_kms, float kms_travelled, String timestamp, int available_seats, String start_time, String end_time, int seats_taken, float cost) {
        this.trip_id = trip_id;
        this.source = source;
        this.destination = destination;
        this.vehicle_id = vehicle_id;
        this.estimated_kms = estimated_kms;
        this.kms_travelled = kms_travelled;
        this.available_seats = available_seats;
        this.start_time=start_time;
        this.end_time=end_time;
        this.seats_taken=seats_taken;
        this.cost=cost;
    }

    public Trip() {
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
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

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
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
    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public int getSeats_taken() {
        return seats_taken;
    }

    public void setSeats_taken(int seats_taken) {
        this.seats_taken = seats_taken;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Trip [available_seats=" + available_seats + ", cost=" + cost + ", destination=" + destination
                + ", end_time=" + end_time + ", estimated_kms=" + estimated_kms + ", kms_travelled=" + kms_travelled
                + ", seats_taken=" + seats_taken + ", source=" + source + ", start_time=" + start_time + ", trip_id="
                + trip_id + ", vehicle_id=" + vehicle_id + "]";
    }

    
   

}





