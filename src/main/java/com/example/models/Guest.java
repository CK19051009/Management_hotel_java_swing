package com.example.models;

public class Guest {
    private int id;
    private String fullName;

    private String phone;
    private String address;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Guest() {
    }

    public Guest(String fullName, String phone, String address, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Guest(int id, String fullName, String phone, String address, String email) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Guest [id =" + id + ", fullName =" + fullName + ", phone =" + phone + ", address =" + address
                + ", email ="
                + email + "]";
    }

}