package com.tripmanagement.asdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="fuel_economy")
public class Fuel_economy {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="vehicle_id")
    private int vehicle_id;

    @Column(name="kms_initial")
    private float kms_initial;

    @Column(name="kms_travelled")
    private float kms_travelled;

    @Column(name="average_speed")
    private int average_speed;

    @Column(name="final_economy")
    private float final_economy;

    @Column(name="total_cost")
    private float total_cost;


    public Fuel_economy(int vehicle_id, float kms_initial, float kms_travelled, int average_speed, float final_economy, float total_cost) {
     this.vehicle_id=vehicle_id;
     this.kms_initial=kms_initial;
     this.kms_travelled=kms_travelled;
     this.average_speed=average_speed;
     this.final_economy=final_economy;
     this.total_cost=total_cost;
    }

    public Fuel_economy() {

    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public float getKms_initial() {
        return kms_initial;
    }

    public void setKms_initial(float kms_initial) {
        this.kms_initial = kms_initial;
    }

    public float getKms_travelled() {
        return kms_travelled;
    }

    public void setKms_travelled(float kms_travelled) {
        this.kms_travelled = kms_travelled;
    }

    public int getAverage_speed() {
        return average_speed;
    }

    public void setAverage_speed(int average_speed) {
        this.average_speed = average_speed;
    }

    public float getFinal_economy() {
        return final_economy;
    }

    public void setFinal_economy(float final_economy) {
        this.final_economy = final_economy;
    }

    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float total_cost) {
        this.total_cost = total_cost;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Fuel_economy{" +
                "vehicle_id=" + vehicle_id +
                ", kms_initial=" + kms_initial +
                ", kms_travelled=" + kms_travelled +
                ", average_speed=" + average_speed +
                ", final_economy=" + final_economy +
                ", total_cost=" + total_cost +
                '}';
    }

}





