package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.model.HotelStat;

public class HotelStatDAO extends DAO {
    public HotelStatDAO(){
        super();
    }
    public ArrayList<HotelStat> getBranchStat(Date startDate, Date endDate){
        ArrayList<HotelStat> ket_qua = new ArrayList<HotelStat>();
            String querySql = "SELECT h.ID AS hotelID, h.address, h.startLevel, COALESCE((SELECT SUM(br.price) FROM BookedRoom br JOIN Room r2 ON br.RoomID = r2.ID WHERE br.BookingID = b.BookingID AND r2.HotelID = h.ID), 0) AS roomRevenue, SUM(b.amount) - COALESCE((SELECT SUM(br.price) FROM BookedRoom br JOIN Room r2 ON br.RoomID = r2.ID WHERE br.BookingID = b.BookingID AND r2.HotelID = h.ID), 0) AS serviceRevenue, SUM(b.amount) AS totalRevenue FROM Bill b JOIN Booking bk ON b.BookingID = bk.ID JOIN BookedRoom br_all ON bk.ID = br_all.BookingID JOIN Room r ON br_all.RoomID = r.ID JOIN Hotel h ON r.HotelID = h.ID WHERE b.paymentDate BETWEEN '2025-03-01' AND '2025-03-31' GROUP BY h.ID, h.address, h.startLevel ORDER BY totalRevenue DESC;";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                PreparedStatement ps = conn.prepareStatement(querySql);
                System.err.println(ps.executeQuery());
            } catch (Exception e) {
                e.printStackTrace();
            }
        return  ket_qua;
    }
}
