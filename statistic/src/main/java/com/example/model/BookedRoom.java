package com.example.model;


import java.util.Date;

public class BookedRoom {
    private int ID;
    private Date checkIn;
    private Date checkOut;
    private float price;
    private int sCheckin;
    private float sellOff;
    private int tblRoomID;
    private int tblBookingID;

    public BookedRoom() {}

    public BookedRoom(int ID, Date checkIn, Date checkOut, float price, int sCheckin, float sellOff, int tblRoomID, int tblBookingID) {
        this.ID = ID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
        this.sCheckin = sCheckin;
        this.sellOff = sellOff;
        this.tblRoomID = tblRoomID;
        this.tblBookingID = tblBookingID;
    }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public Date getCheckIn() { return checkIn; }
    public void setCheckIn(Date checkIn) { this.checkIn = checkIn; }

    public Date getCheckOut() { return checkOut; }
    public void setCheckOut(Date checkOut) { this.checkOut = checkOut; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public int getSCheckin() { return sCheckin; }
    public void setSCheckin(int sCheckin) { this.sCheckin = sCheckin; }

    public float getSellOff() { return sellOff; }
    public void setSellOff(float sellOff) { this.sellOff = sellOff; }

    public int getTblRoomID() { return tblRoomID; }
    public void setTblRoomID(int tblRoomID) { this.tblRoomID = tblRoomID; }

    public int getTblBookingID() { return tblBookingID; }
    public void setTblBookingID(int tblBookingID) { this.tblBookingID = tblBookingID; }
}
