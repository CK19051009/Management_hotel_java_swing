package com.example.models;

public class BookingService {
    private int id;
    private int bookingId;
    private int serviceId;
    private int quantity; // số lần sử dụng dịch vụ
    private double totalPrice;

    public BookingService() {
    }

    public BookingService(int bookingId, int serviceId, int quantity) {
        this.bookingId = bookingId;
        this.serviceId = serviceId;
        this.quantity = quantity;
    }

    public BookingService(int id, int bookingId, int serviceId, int quantity, double totalPrice) {
        this.id = id;
        this.bookingId = bookingId;
        this.serviceId = serviceId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
