package com.example.models;

import java.util.List;

public class Room {
    private int id;
    private String roomNumber;
    private String roomType;
    private String status = "available";
    private Integer price;
    private String thumbnail;
    private String description;
    private Integer capacity;
    private Integer position;
    private List<Service> services;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Room() {
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Room(String roomNumber, String roomType, String status, int price, String description,
            int capacity, int position, String thumbnail) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
        this.capacity = capacity;
        this.position = position;
    }

    public Room(int id, String roomNumber, String roomType, String status, int price, String thumbnail,
            String description, int capacity, int position) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.description = description;
        this.capacity = capacity;
        this.position = position;
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Room { " +
                "id =" + id +
                ", roomNumber ='" + roomNumber + '\'' +
                ", roomType ='" + roomType + '\'' +
                ", status ='" + status + '\'' +
                ", price =" + price +
                ", thumbnail ='" + thumbnail + '\'' +
                ", description ='" + description + '\'' +
                ", capacity ='" + capacity + '\'' +
                ", position =" + position +
                '}';
    }

}