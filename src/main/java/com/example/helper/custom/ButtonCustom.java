package com.example.helper.custom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ButtonCustom {

    // Nút có nền màu đỏ, chữ trắng
    public void customizeRedButton(JButton button) {
        button.setFocusPainted(false); // Loại bỏ viền khi nhấn
        button.setBorderPainted(false); // Tắt viền
        button.setHorizontalAlignment(SwingConstants.CENTER); // Căn chữ về bên trái
        // button.setMaximumSize(new Dimension(150, 80)); // Đặt kích thước cố định cho
        // nút
        button.setForeground(Color.WHITE); // Màu chữ trắng
        button.setBackground(Color.RED); // Màu nền đỏ
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }

    // Nút có nền màu xanh lục, chữ trắng
    public void customizeGreenButton(JButton button) {
        button.setFocusPainted(false); // Loại bỏ viền khi nhấn
        button.setBorderPainted(false); // Tắt viền
        button.setHorizontalAlignment(SwingConstants.CENTER); // Căn chữ về bên trái
        // button.setMaximumSize(new Dimension(150, 80));
        ; // Đặt kích thước cố định cho nút
        button.setForeground(Color.WHITE); // Màu chữ trắng
        button.setBackground(new Color(30, 60, 90)); // Màu nền xanh lục
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }

    // Nút có nền màu xanh lam, chữ trắng
    public void customizeBlueButton(JButton button) {
        button.setFocusPainted(false); // Loại bỏ viền khi nhấn
        button.setBorderPainted(false); // Tắt viền
        button.setHorizontalAlignment(SwingConstants.CENTER); // Căn chữ về bên trái
        // button.setMaximumSize(new Dimension(150, 80));
        ; // Đặt kích thước cố định cho nút
        button.setForeground(Color.WHITE); // Màu chữ trắng
        button.setBackground(new Color(30, 144, 255)); // Màu nền xanh lam
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }

    public void customizeText(JLabel lab) {
        lab.setFont(new Font("Arial", Font.BOLD, 16));
        lab.setForeground(new Color(30, 60, 90));
    }
}