package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Trip_analysis")
public class Trip_analysis {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="analysis_id")
    private int analysis_id;

    @Column(name="trip_id")
    private int trip_id;

    @Column(name="vehicle_id")
    private int vehicle_id;

    @Column(name="vehicleowner_id")
    private int vehicleowner_id;

    public  Trip_analysis(int analysis_id, int trip_id, int vehicle_id, int vehicleowner_id){
        this.analysis_id=analysis_id;
        this.trip_id=trip_id;
        this.vehicle_id=vehicle_id;
        this.vehicleowner_id=vehicleowner_id;
    }

    public int getAnalysis_id() {
        return analysis_id;
    }

    public void setAnalysis_id(int analysis_id) {
        this.analysis_id = analysis_id;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Trip_analysis{" +
                "analysis_id=" + analysis_id +
                ", trip_id=" + trip_id +
                ", vehicle_id=" + vehicle_id +
                ", vehicleowner_id=" + vehicleowner_id +
                '}';
    }
}





