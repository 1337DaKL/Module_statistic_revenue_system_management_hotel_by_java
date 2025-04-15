    package com.example.dao;

    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;

    import com.example.model.Bill;
    import com.example.model.Client;

    public class BillDAO extends DAO {
        public BillDAO() {
            super();
        }

        public ArrayList<Bill> getBillByBranch(int idBranch, Date startDate, Date endDate) {
            ArrayList<Bill> list = new ArrayList<>();

            String query = "SELECT b.ID AS BillID, b.paymentDate AS BillDate, c.fullname AS ClientName, c.telephone AS ClientPhone, c.email AS ClientEmail, h.address AS HotelAddress,SUM( COALESCE(( SELECT SUM(br.price) FROM BookedRoom br JOIN Room r2 ON br.RoomID = r2.ID WHERE br.BookingID = b.BookingID AND r2.HotelID = h.ID), 0)) AS roomRevenue,SUM(b.amount) - SUM( COALESCE(( SELECT SUM(br.price) FROM BookedRoom br JOIN Room r2 ON br.RoomID = r2.ID WHERE br.BookingID = b.BookingID AND r2.HotelID = h.ID), 0)) AS serviceRevenue, b.amount AS BillTotal FROM Bill b  JOIN BookedRoom br ON br.ID = b.BookingID  JOIN Booking bk ON bk.ID = br.BookingID JOIN Client c ON c.ID = bk.ClientID JOIN Room r ON r.ID = br.roomID JOIN Hotel h ON h.ID = r.hotelID WHERE h.ID = ? AND b.paymentDate BETWEEN ? AND ? ORDER BY b.paymentDate;";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, Integer.toString(idBranch));
                ps.setString(2, sdf.format(startDate));
                ps.setString(3, sdf.format(endDate));

                ResultSet rs = ps.executeQuery();
                System.err.println(rs);
                while (rs.next()) {
                    Bill bill = new Bill();
                    bill.setID(rs.getInt("BillID"));
                    bill.setPaymentDate(rs.getDate("BillDate"));
                    bill.setAmount(rs.getFloat("BillTotal"));
                    bill.setRevenueRoom(rs.getFloat("roomRevenue"));
                    bill.setRevenueService(rs.getFloat("serviceRevenue"));
                    Client client = new Client();
                    client.setFullName(rs.getString("ClientName"));
                    bill.setClient(client);
                    list.add(bill);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return list;
        }
    }
