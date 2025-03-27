package com.example.helper.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ButtonCustom {
    public void customizeButton(JButton button) {
        button.setFocusPainted(false); // Loại bỏ viền khi nhấn
        // button.setContentAreaFilled(false); // Tắt màu nền
        // button.setOpaque(false); // Làm trong suốt
        button.setBorderPainted(false); // Tắt viền
        // button.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa nút
        button.setHorizontalAlignment(SwingConstants.LEFT); // Căn chữ về bên trái
        button.setMaximumSize(new Dimension(120, 40)); // Đặt kích thước cố định cho nút
        button.setForeground(Color.white);
        button.setBackground(new Color(30, 60, 90));
        button.setFont(new Font("Arial", Font.BOLD, 16));
    }
}
