package com.example.model;

import java.util.Date;

public class Bill {
    private int ID;
    private Date paymentDate;
    private float amount;
    private String paymentType;
    private String note;
    private int tblUserID;
    private int tblBookingID;

    public Bill() {}

    public Bill(int ID, Date paymentDate, float amount, String paymentType, String note, int tblUserID, int tblBookingID) {
        this.ID = ID;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentType = paymentType;
        this.note = note;
        this.tblUserID = tblUserID;
        this.tblBookingID = tblBookingID;
    }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }

    public String getPaymentType() { return paymentType; }
    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public int getTblUserID() { return tblUserID; }
    public void setTblUserID(int tblUserID) { this.tblUserID = tblUserID; }

    public int getTblBookingID() { return tblBookingID; }
    public void setTblBookingID(int tblBookingID) { this.tblBookingID = tblBookingID; }

    
}
