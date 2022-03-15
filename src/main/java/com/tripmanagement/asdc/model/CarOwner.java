package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="car_owner")
public class CarOwner {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first_Name;
	
	@Column(name="last_name")
	private String last_Name;
	
	@Column(name="email")
	private String email;


	
	public CarOwner() {
		
	}

 public CarOwner(int id, String first_Name, String last_Name, String email)
 {
this.id=id;
this.first_Name=first_Name;
this.last_Name=last_Name;
this.email=email;

 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_Name;
	}

	public void setFirstName(String firstName) {
		this.first_Name = firstName;
	}

	public String getLastName() {
		return last_Name;
	}

	public void setLastName(String lastName) {
		this.last_Name = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CarOwner [id=" + id + ", firstName=" + first_Name + ", lastName=" + last_Name + ", email=" + email + "]";
	}
		
}





