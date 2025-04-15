package com.example.model;

public class User {
    private int ID;
    private String username;
    private String password;
    private String fullName;
    private String position;
    private String address;
    private String telephone;

    public User() {}

    public User(int ID, String username, String password, String fullName, String position, String address, String telephone) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.position = position;
        this.address = address;
        this.telephone = telephone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    @Override
    public String toString() {
        return this.fullName;
    }
}
