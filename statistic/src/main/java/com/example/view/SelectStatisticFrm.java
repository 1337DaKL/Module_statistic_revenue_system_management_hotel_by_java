package com.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectStatisticFrm extends JFrame {
    public SelectStatisticFrm() {
        setTitle("SelectStatisticView");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("SelectStatisticView:");
        label.setBounds(30, 10, 200, 30);
        add(label);

        String[] buttonLabels = {
            "Branch Statistic",
            "Client Statistic",
            "Room Statistic",
            "Service Statistic"
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBounds(300, 100 + i * 70, 200, 50);
            add(button);

            int finalI = i;
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (finalI == 0) {
                        new BranchStatisticFrm();
                        dispose();
                    }
                }
            });
        }

        setVisible(true);
    }
}

