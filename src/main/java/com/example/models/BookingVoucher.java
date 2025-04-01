package com.example.models;

public class BookingVoucher {
    private int id;
    private int bookingId;
    private int voucherId;
    private double totalDiscount;

    public BookingVoucher() {
    }

    public BookingVoucher(int bookingId, int voucherId, double totalDiscount) {
        this.bookingId = bookingId;
        this.voucherId = voucherId;
        this.totalDiscount = totalDiscount;
    }

    public BookingVoucher(int id, int bookingId, int voucherId, double totalDiscount) {
        this.id = id;
        this.bookingId = bookingId;
        this.voucherId = voucherId;
        this.totalDiscount = totalDiscount;
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

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

}
