package com.tripmanagement.asdc.model;


import javax.persistence.*;
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customer_id;

    @Column(name="customer_fname")
    private String customer_fname;

    @Column(name="customer_lname")
    private String customer_lname;

    @Column(name="mobile_no")
    private String mobile_no;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="owner_tag")
    private String owner_tag;

    @Column(name="password")
    private String password;

    public Customer() {

    }

    public Customer(int customer_id, String customer_fname, String customer_lname,String mobile_no, String address, String email, String owner_tag, String password)
    {
       this.customer_id=customer_id;
       this.customer_fname=customer_fname;
       this.customer_lname=customer_lname;
       this.mobile_no=mobile_no;
       this.address=address;
       this.email=email;
       this.owner_tag=owner_tag;
       this.password=password;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_lname() {
        return customer_lname;
    }

    public void setCustomer_lname(String customer_lname) {
        this.customer_lname = customer_lname;
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

    public String getCustomer_fname() {
        return customer_fname;
    }

    public void setCustomer_fname(String customer_fname) {
        this.customer_fname = customer_fname;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_fname='" + customer_fname + '\'' +
                ", customer_lname='" + customer_lname + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", owner_tag='" + owner_tag + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}





