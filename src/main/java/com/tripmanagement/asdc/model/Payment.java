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

    @Column(name="payment_id")
    private int payment_id;

    @Column(name="vehicleowner_id")
    private int vehicleowner_id;

    @Column(name="amount")
    private float amount;

    @Column(name="trip_id")
    private int trip_id;

    @Column(name="timestamp")
    private date timestamp;

    public Vehicle(int payment_id, int vehicleowner_id, float amount, int trip_id, date timestamp) {
        this.payment_id = payment_id;
        this.vehicleowner_id = vehicleowner_id;
        this.amount = amount;
        this.trip_id = trip_id;
        this.type = type;
        this.timestamp = timestamp;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getVehicleowner_id() {
        return vehicleowner_id;
    }

    public void setVehicleowner_id(int vehicleowner_id) {
        this.vehicleowner_id = vehicleowner_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Payment [payment_id=" + payment_id + ", vehicleowner_id=" + vehicleowner_id + ", amount=" + amount + ", trip_id=" + trip_id +", timestamp=" + timestamp +"]";
    }

}





