package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BranchDetailView extends JFrame {
    public BranchDetailView() {
        setTitle("BranchDetailView");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("BranchDetailView:");
        label.setBounds(20, 10, 200, 30);
        add(label);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(20, 50, 80, 30);
        add(btnBack);
        btnBack.addActionListener(e -> {
            new BranchStatisticView();
            dispose();
        });

        String[] columns = {
            "Number", "Full name", "Payment date",
            "Room Revenue", "Service Revenue", "Total revenue"
        };

        JTable table = new JTable(new DefaultTableModel(columns, 5));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 100, 850, 400);
        add(scrollPane);

        JLabel lblTotal = new JLabel("TOTAL");
        lblTotal.setBounds(20, 520, 100, 30);
        add(lblTotal);

        setVisible(true);
    }
}
