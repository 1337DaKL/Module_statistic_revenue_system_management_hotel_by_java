package com.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerHomeFrm extends JFrame {
    public ManagerHomeFrm() {
        setTitle("Statistic Revenue");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnNext = new JButton("Statistic Revenue");
        btnNext.setBounds(300, 200, 200, 50);
        add(btnNext);

        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelectStatisticView(); 
                dispose(); 
            }
        });

        setVisible(true);
    }
}
