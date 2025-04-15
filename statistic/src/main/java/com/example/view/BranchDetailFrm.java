package com.example.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.dao.BillDAO;
import com.example.model.Bill;

public class BranchDetailFrm extends JFrame {
    public BranchDetailFrm(int idBranch, Date startDate, Date endDate) {
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
            new SelectStatisticFrm();
            dispose();
        });
        BillDAO billDao = new BillDAO();
        ArrayList<Bill> listBill = billDao.getBillByBranch(idBranch, startDate, endDate);
        String[] columns = {
            "Number", "Full name", "Payment date",
            "Room Revenue", "Service Revenue", "Total revenue"
        };
        DefaultTableModel model = new DefaultTableModel(columns, listBill.size());
        JTable table = new JTable(model);
        float totalBill = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(int i = 0 ; i < listBill.size() ; i++){
            model.setValueAt(i + 1, i , 0); 
            model.setValueAt(listBill.get(i).getClient().getFullName(), i, 1);
            model.setValueAt(sdf.format(listBill.get(i).getPaymentDate()), i, 2);
            model.setValueAt(listBill.get(i).getRevenueRoom(), i, 3);
            model.setValueAt(listBill.get(i).getRevenueService(), i, 4);
            model.setValueAt(listBill.get(i).getAmount(), i, 5);
            totalBill += listBill.get(i).getAmount();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 100, 850, 400);
        add(scrollPane);

        JLabel lblTotal = new JLabel("TOTAL: " + totalBill);
        lblTotal.setBounds(20, 520, 100, 30);
        add(lblTotal);

        setVisible(true);
    }
}
