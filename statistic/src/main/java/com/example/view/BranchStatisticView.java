package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
public class BranchStatisticView extends JFrame {
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
    public BranchStatisticView() {
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

        String[] columns = {"Number", "Branch name", "Room Revenue", "Service Revenue", "Total Revenue"};
        JTable table = new JTable(new DefaultTableModel(columns, 5));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 100, 850, 400);
        add(scrollPane);

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
                        new BranchDetailView();
                        dispose();
                    }

                }
            }
        });

        setVisible(true);
    }
}
