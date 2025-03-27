package com.example.view.room;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.view.default_main.MainDefault;

public class AddRoomPanel extends JPanel {
    public AddRoomPanel(MainDefault mainDefault) {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Tiêu đề
        JPanel section_1 = new JPanel(new BorderLayout());
        section_1.setPreferredSize(new Dimension(200, 100));
        JLabel labelTitle = new JLabel("Thêm phòng", JLabel.CENTER);
        section_1.add(labelTitle);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 20));
        // add(labelTitle, BorderLayout.NORTH);
        add(section_1, BorderLayout.NORTH);

        // Nút "Quay lại"
        JPanel section_2 = new JPanel(new BorderLayout());
        section_2.setPreferredSize(new Dimension(200, 200));
        JButton btnBack = new JButton("Quay lại");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(e -> {
            mainDefault.showContent(new Index(mainDefault));
        });

        // Thêm nút vào giao diện
        section_2.add(btnBack);
        add(section_2, BorderLayout.CENTER);
    }
}
