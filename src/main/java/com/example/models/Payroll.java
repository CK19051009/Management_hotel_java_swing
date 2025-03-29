package com.example.models;

public class Payroll {
    private int payrollID;
    private int employeeID;
    private int month;
    private int year;
    private double totalSalary;

    // Constructor
    public Payroll(int payrollID, int employeeID, int month, int year, double totalSalary) {
        this.payrollID = payrollID;
        this.employeeID = employeeID;
        this.month = month;
        this.year = year;
        this.totalSalary = totalSalary;
    }

    // Getters and Setters
    public int getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(int payrollID) {
        this.payrollID = payrollID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    // toString() để in dữ liệu ra màn hình
    @Override
    public String toString() {
        return "Payroll{" +
                "payrollID=" + payrollID +
                ", employeeID=" + employeeID +
                ", month=" + month +
                ", year=" + year +
                ", totalSalary=" + totalSalary +
                '}';
    }
}
