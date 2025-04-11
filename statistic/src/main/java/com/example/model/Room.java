package com.example.model;

public class Room {
    private int id;
    private int hotelId;
    private String name;
    private String type;
    private float price;
    private String description;

    public Room() {}

    public Room(int id, int hotelId, String name, String type, float price, String description) {
        this.id = id;
        this.hotelId = hotelId;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getHotelId() { return hotelId; }
    public void setHotelId(int hotelId) { this.hotelId = hotelId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}


