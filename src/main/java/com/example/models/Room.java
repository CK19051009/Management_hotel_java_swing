package com.example.models;

public class Room {
    private int id;
    private String roomNumber;
    private String roomType;
    private String status;
    private int price;
    private String thumbnail;
    private String description;
    private String capacity;
    private int position;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Room() {
    }

    public Room(int id, String roomNumber, String roomType, String status, int price, String thumbnail,
            String description, String capacity, int position) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
        this.capacity = capacity;
        this.position = position;
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