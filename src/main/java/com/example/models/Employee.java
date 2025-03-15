package com.example.models;

public class Employee {
    private int id;
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String thumbnail;
    private String levelUser;
    private String status;

    public Employee() {

    }

    public Employee(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Employee(String userName, String fullName, String email, String password, String thumbnail,
            String levelUser, String status) {

        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.thumbnail = thumbnail;
        this.levelUser = levelUser;
        this.status = status;
    }

    public Employee(int id, String userName, String fullName, String email, String password, String thumbnail,
            String levelUser, String status) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.thumbnail = thumbnail;
        this.levelUser = levelUser;
        this.status = status;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLevelUser() {
        return levelUser;
    }

    public void setLevelUser(String levelUser) {
        this.levelUser = levelUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return """
                Employee [id= %s, userName= %s, fullName= %s, email= %s, password= %s, thumbnail= %s, levelUser= %s, status= %s]
                """
                .formatted(id, userName, fullName, email, password, thumbnail, levelUser, status);

    }
}