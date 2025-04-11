package com.example.model;

public class Service {
    private int id;
    private String name;
    private int unity;
    private int price;
    private String description;

    public Service() {}

    public Service(int id, String name, int unity, int price, String description) {
        this.id = id;
        this.name = name;
        this.unity = unity;
        this.price = price;
        this.description = description;
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

    public int getUnity() {
        return unity;
    }

    public void setUnity(int unity) {
        this.unity = unity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
