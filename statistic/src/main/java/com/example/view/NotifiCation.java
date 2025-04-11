package com.example.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class NotifiCation extends JFrame {
    public NotifiCation(String message) {
        setTitle("Notification");
        setSize(500, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // giữa màn hình

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(label, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Arial", Font.BOLD, 14));
        JPanel panel = new JPanel();
        panel.add(okButton);
        add(panel, BorderLayout.SOUTH);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // đóng cửa sổ
            }
        });

        setVisible(true);
    }

}
