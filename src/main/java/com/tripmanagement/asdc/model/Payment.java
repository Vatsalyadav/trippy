package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Payment")
public class Payment {

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

    @Column(name="type")
    private String type;

    @Column(name="timestamp")
    private Date timestamp;

    public Payment(int payment_id, int vehicleowner_id, float amount, int trip_id, String type, Date timestamp) {
        this.payment_id = payment_id;
        this.vehicleowner_id = vehicleowner_id;
        this.amount = amount;
        this.trip_id = trip_id;
        this.type = type;
        this.timestamp = timestamp;
    }

    public Payment() {

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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Payment [payment_id=" + payment_id + ", vehicleowner_id=" + vehicleowner_id + ", amount=" + amount + ", trip_id=" + trip_id +", timestamp=" + timestamp +"]";
    }

}





