package com.example.models;

public class Service {
    private int id;
    private String name;
    private Double price;
    private String description;
    private String status = "available";
    private int quantity;

    public Service() {
    }

    public Service(String name, Double price, String description, String status) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
    }

    public Service(int id, String name, double price, String description, String status, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service " + "id = " + id + " name = " + name + " price = " + price + " description = " + description
                + " status = " + status + ", quantity = " + quantity + "\n";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}