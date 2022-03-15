package com.tripmanagement.asdc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customer_id;

    @Column(name="customer_name")
    private String customer_name;

    @Column(name="mobile_no")
    private String mobile_no;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="owner_tag")
    private String owner_tag;

    @Column(name="trip_id")
    private int trip_id;

    @Column(name="payment_id")
    private int payment_id;

    public Customer() {

    }

    public Customer(int customer_id, String customer_name, String mobile_no, String address, String email, String owner_tag, int trip_id, int payment_id)
    {
        this.customer_id=customer_id;
        this.customer_name=customer_name;
        this.mobile_no=mobile_no;
        this.address=address;
        this.email=email;
        this.owner_tag=owner_tag;
        this.trip_id=trip_id;
        this.payment_id=payment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getOwner_tag() {
        return owner_tag;
    }

    public void setOwner_tag(String owner_tag) {
        this.owner_tag = owner_tag;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    @Override
    public String toString() {
        return "customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", mobile_no=" + mobile_no + ", address=" + address + ", email=" + email + ",owner_tag=" + owner_tag + ",trip_id=" + trip_id + ",payment_id=" + payment_id +"]";
    }

}





