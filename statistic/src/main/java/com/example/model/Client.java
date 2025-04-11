package com.example.model;

public class Client {
    private int ID;
    private String fullName;
    private String idCard;
    private String address;
    private String telephone;
    private String email;
    private String note;

    public Client() {}

    public Client(int ID, String fullName, String idCard, String address, String telephone, String email, String note) {
        this.ID = ID;
        this.fullName = fullName;
        this.idCard = idCard;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.note = note;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
