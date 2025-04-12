package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;
import com.example.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import com.example.dao.*;
import com.example.model.HotelStat;
public class BranchStatisticFrm extends JFrame {
    public static boolean isValidDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(dateStr, formatter);
            return true; 
        } catch (DateTimeParseException e) {
            return false; 
        }
    }
    public static boolean isBeforeDate(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date startDatec = sdf.parse(startDate);
            Date endDatec = sdf.parse(endDate);

            return startDatec.after(endDatec); 
        } catch (Exception e) {
            return true;
        }
    }
    public BranchStatisticFrm() {
        setTitle("BranchStatisticView");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("BranchStatisticView:");
        label.setBounds(20, 10, 200, 30);
        add(label);

        JTextField txtStart = new JTextField();
        txtStart.setBounds(70, 50, 100, 30);
        JLabel lblStart = new JLabel("Start:");
        lblStart.setBounds(20, 50, 50, 30);
        add(lblStart);
        add(txtStart);

        JTextField txtEnd = new JTextField();
        txtEnd.setBounds(250, 50, 100, 30);
        JLabel lblEnd = new JLabel("End:");
        lblEnd.setBounds(200, 50, 50, 30);
        add(lblEnd);
        add(txtEnd);

        JButton btnStatistic = new JButton("Statistic");
        btnStatistic.setBounds(400, 50, 100, 30);
        add(btnStatistic);

        JLabel lblNotificationEmpty = new JLabel("Chưa nhập ngày bắt đầu và kết thúc để thống kê!!");
        lblNotificationEmpty.setSize(300 , 30);
        int centerX = (getWidth() - lblNotificationEmpty.getWidth()) / 2;
        int centerY = (getHeight() - lblNotificationEmpty.getHeight()) / 2;
        lblNotificationEmpty.setLocation(centerX , centerY);
        add(lblNotificationEmpty);
        btnStatistic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String startDate = txtStart.getText().trim();
                String endDate = txtEnd.getText().trim();

                if (startDate.isEmpty() || endDate.isEmpty()) {
                    new NotifiCation("Ngày bắt đầu và kết thúc không được để trống!");
                } else {
                    if(!isValidDate(startDate)){
                        new NotifiCation("Ngày bắt đầu không hợp lệ vui lòng nhập theo định dạng dd/MM/YYYY");
                    }
                    else if(!isValidDate(endDate)){
                        new NotifiCation("Ngày kết thúc không hợp lệ vui lòng nhập theo định dạng dd/MM/YYYY");
                    }
                    else if(isBeforeDate(startDate , endDate)){
                        new NotifiCation("Ngày bắt đầu phải nhỏ hơn ngày kết thúc vui lòng nhập lại giùm!!");
                    }
                    else{
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Date startDateQuery = sdf.parse(startDate);
                            Date endDateQuery = sdf.parse(endDate);
        
                            HotelStatDAO hotelStatDao = new HotelStatDAO();
                            ArrayList<HotelStat> ket_qua_query = hotelStatDao.getBranchStat(startDateQuery, endDateQuery);
                            new BranchStatisticFrm(ket_qua_query , startDate , endDate);
                            dispose();
                        } catch (Exception ex) {
                            new NotifiCation("Lỗi xử lý ngày hoặc truy vấn dữ liệu!");
                            ex.printStackTrace();
                        }
                    }

                }
            }
        });

        setVisible(true);
        
    }
    public BranchStatisticFrm(ArrayList<HotelStat> hotelStat , String startDateInput , String endDateInput){
        setTitle("BranchStatisticView");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("BranchStatisticView:");
        label.setBounds(20, 10, 200, 30);
        add(label);

        JTextField txtStart = new JTextField();
        txtStart.setBounds(70, 50, 100, 30);
        txtStart.setText(startDateInput);
        JLabel lblStart = new JLabel("Start:");
        lblStart.setBounds(20, 50, 50, 30);
        add(lblStart);
        add(txtStart);

        JTextField txtEnd = new JTextField();
        txtEnd.setBounds(250, 50, 100, 30);
        txtEnd.setText(endDateInput);
        JLabel lblEnd = new JLabel("End:");
        lblEnd.setBounds(200, 50, 50, 30);
        add(lblEnd);
        add(txtEnd);

        JButton btnStatistic = new JButton("Statistic");
        btnStatistic.setBounds(400, 50, 100, 30);
        add(btnStatistic);


        if(hotelStat.size() > 0){
            String[] columns = {"ID" ,"Number", "Branch name", "Room Revenue", "Service Revenue", "Total Revenue"};
            DefaultTableModel model = new DefaultTableModel(columns, hotelStat.size());
            JTable table = new JTable(model);
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(0);
            for(int i = 0 ; i < hotelStat.size() ; i++){
                model.setValueAt(hotelStat.get(i).getId(), i, 0);
                model.setValueAt(i + 1, i , 1); 
                model.setValueAt(hotelStat.get(i).getBranch(), i, 2);
                model.setValueAt(hotelStat.get(i).getRevenueRoom(), i, 3);
                model.setValueAt(hotelStat.get(i).getRevenueService(), i, 4);
                model.setValueAt(hotelStat.get(i).getTotalRevenue(), i, 5);
            }
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(20, 100, 850, 400);
            add(scrollPane);
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    int selectedRow = table.getSelectedRow(); 

                    if (selectedRow != -1) {
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date startDate = sdf.parse(startDateInput);
                            Date endDate = sdf.parse(endDateInput);
                            String idBranch = table.getValueAt(selectedRow, 0).toString();
                            int id = Integer.parseInt(idBranch);
                            
                            new BranchDetailFrm(id, startDate, endDate);
                            dispose();
                        } catch (Exception ex) {
                            ex.printStackTrace(); 
                        }
                    }
                }
            });
        }
        else{
            JLabel lblNotificationEmpty = new JLabel("Trong khoảng thời gian bạn chọn không có doanh thu");
            lblNotificationEmpty.setSize(300 , 30);
            int centerX = (getWidth() - lblNotificationEmpty.getWidth()) / 2;
            int centerY = (getHeight() - lblNotificationEmpty.getHeight()) / 2;
            lblNotificationEmpty.setLocation(centerX , centerY);
            add(lblNotificationEmpty);
        }

        btnStatistic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String startDate = txtStart.getText().trim();
                String endDate = txtEnd.getText().trim();

                if (startDate.isEmpty() || endDate.isEmpty()) {
                    new NotifiCation("Ngày bắt đầu và kết thúc không được để trống!");
                } else {
                    if(!isValidDate(startDate)){
                        new NotifiCation("Ngày bắt đầu không hợp lệ vui lòng nhập theo định dạng dd/MM/YYYY");
                    }
                    else if(!isValidDate(endDate)){
                        new NotifiCation("Ngày kết thúc không hợp lệ vui lòng nhập theo định dạng dd/MM/YYYY");
                    }
                    else if(isBeforeDate(startDate , endDate)){
                        new NotifiCation("Ngày bắt đầu phải nhỏ hơn ngày kết thúc vui lòng nhập lại giùm!!");
                    }
                    else{
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Date startDateQuery = sdf.parse(startDate);
                            Date endDateQuery = sdf.parse(endDate);
        
                            HotelStatDAO hotelStatDao = new HotelStatDAO();
                            ArrayList<HotelStat> ket_qua_query = hotelStatDao.getBranchStat(startDateQuery, endDateQuery);
                            new BranchStatisticFrm(ket_qua_query , startDate , endDate);
                            dispose();
                        } catch (Exception ex) {
                            new NotifiCation("Lỗi xử lý ngày hoặc truy vấn dữ liệu!");
                            ex.printStackTrace();
                        }
                    }

                }
            }
        });

        setVisible(true);
    }
}
