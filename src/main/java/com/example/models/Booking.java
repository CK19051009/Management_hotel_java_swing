package com.example.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Booking {
    private int id;
    private int roomId;
    private int employeeId;
    private int voucherId;
    private int guestId;
    private Date checkIn;
    private Date checkOut;
    private double totalAmount = 0.0;
    private double depositAmount = 0.0;
    private String paymentStatus;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Booking() {
    }

    // Getters và Setters

    public Booking(int roomId, int employeeId, int voucherId, int guestId, Date checkIn, Date checkOut,
            double totalAmount, double depositAmount, String paymentStatus, String status, Timestamp createdAt,
            Timestamp updatedAt) {
        this.roomId = roomId;
        this.employeeId = employeeId;
        this.voucherId = voucherId;
        this.guestId = guestId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalAmount = totalAmount;
        this.depositAmount = depositAmount;
        this.paymentStatus = paymentStatus;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Booking(int id, int roomId, int employeeId, int voucherId, int guestId, Date checkIn, Date checkOut,
            double totalAmount, double depositAmount, String paymentStatus, String status, Timestamp createdAt,
            Timestamp updatedAt) {
        this.id = id;
        this.roomId = roomId;
        this.employeeId = employeeId;
        this.voucherId = voucherId;
        this.guestId = guestId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalAmount = totalAmount;
        this.depositAmount = depositAmount;
        this.paymentStatus = paymentStatus;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Booking [id=" + id + ", roomId=" + roomId + ", employeeId=" + employeeId + ", voucherId=" + voucherId
                + ", guestId=" + guestId + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", totalAmount="
                + totalAmount + ", depositAmount=" + depositAmount + ", paymentStatus=" + paymentStatus + ", status="
                + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

}