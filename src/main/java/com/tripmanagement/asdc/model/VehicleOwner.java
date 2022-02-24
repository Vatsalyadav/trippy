package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="vehicleowner")
public class VehicleOwner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicleowner_id")
	private int vehicleowner_id;
	
	@Column(name="vehicleowner_name")
	private String vehicleowner_name;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="vehicle_id")
	private int vehicle_id;

	

	public VehicleOwner() {
		
	}

	public VehicleOwner(int vehicleowner_id, String vehicleowner_name, String email, String address, String phone, int vehicle_id) {
		this.vehicleowner_id = vehicleowner_id;
		this.vehicleowner_name = vehicleowner_name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.vehicle_id=vehicle_id;
	}

	public int getVehicleowner_id() {
		return vehicleowner_id;
	}

	public void setVehicleowner_id(int vehicleowner_id) {
		this.vehicleowner_id = vehicleowner_id;
	}

	public String getVehicleowner_name() {
		return vehicleowner_name;
	}

	public void setVehicleowner_name(String vehicleowner_name) {
		this.vehicleowner_name = vehicleowner_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
		
}





