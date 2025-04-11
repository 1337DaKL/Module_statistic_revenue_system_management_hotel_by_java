package com.example.model;

public class UsedService {
    private int ID;
    private int quantity;
    private float price;
    private float sellOff;
    private int tblServiceID;
    private int tblBookedRoomID;

    public UsedService() {}

    public UsedService(int ID, int quantity, float price, float sellOff, int tblServiceID, int tblBookedRoomID) {
        this.ID = ID;
        this.quantity = quantity;
        this.price = price;
        this.sellOff = sellOff;
        this.tblServiceID = tblServiceID;
        this.tblBookedRoomID = tblBookedRoomID;
    }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public float getSellOff() { return sellOff; }
    public void setSellOff(float sellOff) { this.sellOff = sellOff; }

    public int getTblServiceID() { return tblServiceID; }
    public void setTblServiceID(int tblServiceID) { this.tblServiceID = tblServiceID; }

    public int getTblBookedRoomID() { return tblBookedRoomID; }
    public void setTblBookedRoomID(int tblBookedRoomID) { this.tblBookedRoomID = tblBookedRoomID; }

}
