package com.example.models;

public class Payment {
<<<<<<< HEAD

    private int id;
    private int bookingId;
    private Double amount;
    private String paymentMethod;
    private String paymentStatus;
    private String createdAt;
    public Payment (){

    }
    // Constructor
    public Payment(int id, int bookingId, Double amount, String paymentMethod, String paymentStatus, String createdAt) {
=======
    private int id;
    private int bookingId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus = "Completed";

    public Payment() {
    }

    public Payment(int bookingId, double amount, String paymentMethod, String paymentStatus) {
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Payment(int id, int bookingId, double amount, String paymentMethod, String paymentStatus) {
>>>>>>> 75e75844812896365c94ef564d30ceb4e9e5345a
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
<<<<<<< HEAD
        this.createdAt = createdAt;
    }

    // Getters
=======
    }

>>>>>>> 75e75844812896365c94ef564d30ceb4e9e5345a
    public int getId() {
        return id;
    }

<<<<<<< HEAD
=======
    public void setId(int id) {
        this.id = id;
    }

>>>>>>> 75e75844812896365c94ef564d30ceb4e9e5345a
    public int getBookingId() {
        return bookingId;
    }

<<<<<<< HEAD
    public Double getAmount() {
        return amount;
    }

=======
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

>>>>>>> 75e75844812896365c94ef564d30ceb4e9e5345a
    public String getPaymentMethod() {
        return paymentMethod;
    }

<<<<<<< HEAD
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

=======
>>>>>>> 75e75844812896365c94ef564d30ceb4e9e5345a
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

<<<<<<< HEAD
=======
    public String getPaymentStatus() {
        return paymentStatus;
    }

>>>>>>> 75e75844812896365c94ef564d30ceb4e9e5345a
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

<<<<<<< HEAD
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    // toString method
    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", bookingId=" + bookingId +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
=======
    @Override
    public String toString() {
        return "Payment [id=" + id + ", bookingId=" + bookingId + ", amount=" + amount + ", paymentMethod="
                + paymentMethod + ", paymentStatus=" + paymentStatus + "]";
    }

>>>>>>> 75e75844812896365c94ef564d30ceb4e9e5345a
}
