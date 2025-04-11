package com.example.model;

import java.util.Date;

public class Booking {
    private int ID;
    private Date bookingDate;
    private float sellOff;
    private String note;
    private int tblClientID;
    private int tblUserID;

    public Booking() {}

    public Booking(int ID, Date bookingDate, float sellOff, String note, int tblClientID, int tblUserID) {
        this.ID = ID;
        this.bookingDate = bookingDate;
        this.sellOff = sellOff;
        this.note = note;
        this.tblClientID = tblClientID;
        this.tblUserID = tblUserID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public float getSellOff() {
        return sellOff;
    }

    public void setSellOff(float sellOff) {
        this.sellOff = sellOff;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTblClientID() {
        return tblClientID;
    }

    public void setTblClientID(int tblClientID) {
        this.tblClientID = tblClientID;
    }

    public int getTblUserID() {
        return tblUserID;
    }

    public void setTblUserID(int tblUserID) {
        this.tblUserID = tblUserID;
    }


}
