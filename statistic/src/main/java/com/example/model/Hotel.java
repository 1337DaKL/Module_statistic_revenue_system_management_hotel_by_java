package com.example.model;

public class Hotel {
    private int id;
    private String address;
    private float startLevel;
    private String description;

    public Hotel() {}

    public Hotel(int id, String address, float startLevel, String description) {
        this.id = id;
        this.address = address;
        this.startLevel = startLevel;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public float getStartLevel() { return startLevel; }
    public void setStartLevel(float startLevel) { this.startLevel = startLevel; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
