package com.example.models;

public class TimeKeeping {
    private int timekeepingID;
    private int employeeID;
    private String workDate;
    private String checkIn;
    private String checkOut;
    private String status;
    private double salaryPerDay;

    // Constructor
    public TimeKeeping(int timekeepingID, int employeeID, String workDate, String checkIn, String checkOut, String status, double salaryPerDay) {
        this.timekeepingID = timekeepingID;
        this.employeeID = employeeID;
        this.workDate = workDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.salaryPerDay = salaryPerDay;
    }

    // Getters and Setters
    public int getTimekeepingID() {
        return timekeepingID;
    }

    public void setTimekeepingID(int timekeepingID) {
        this.timekeepingID = timekeepingID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    // toString() để in dữ liệu ra màn hình
    @Override
    public String toString() {
        return "Timekeeping{" +
                "timekeepingID=" + timekeepingID +
                ", employeeID=" + employeeID +
                ", workDate='" + workDate + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", status='" + status + '\'' +
                ", salaryPerDay=" + salaryPerDay +
                '}';
    }
}
