package com.example.model;

public class HotelStat extends Hotel {
    private float revenueRoom;
    private float revenueService;
    private float totalRevenue;

    public HotelStat() {
        super();
    }

    public HotelStat(int id, String address, float startLevel, String description,float revenueRoom, float revenueService, float totalRevenue) {
        super(id, address, startLevel, description);
        this.revenueRoom = revenueRoom;
        this.revenueService = revenueService;
        this.totalRevenue = totalRevenue;
    }
    @Override
    public int getId(){
        return super.getId();
    }
    public void setId(int id){
        super.setId(id);
    }
    public String getBranch(){
        return super.getAddress();
    }
    public float getRevenueRoom() {
        return revenueRoom;
    }

    public void setRevenueRoom(float revenueRoom) {
        this.revenueRoom = revenueRoom;
    }

    public float getRevenueService() {
        return revenueService;
    }

    public void setRevenueService(float revenueService) {
        this.revenueService = revenueService;
    }

    public float getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(float totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    @Override
    public String toString() {
        return "HotelStat{" +
                "id=" + this.getId() +
                ", revenueRoom=" + revenueRoom +
                ", revenueService=" + revenueService +
                ", totalRevenue=" + totalRevenue +
                '}';
    }

}
