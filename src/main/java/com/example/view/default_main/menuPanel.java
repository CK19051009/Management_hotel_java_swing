package com.example.view.default_main;

import javax.swing.*;

import com.example.models.Employee;
import com.example.view.login.Login_Form;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class menuPanel {
        private JPanel panelMenu = new JPanel();
        private JPanel panelInfoEmployee = new JPanel();
        private JPanel panelListButton = new JPanel();
        private JLabel labWelcome = new JLabel();
        private JLabel labImageEmployee = new JLabel();
        private JLabel labName = new JLabel();
        private JButton btnRoomManage = new JButton();
        private JButton btnManageService = new JButton();
        private JButton btnExit = new JButton();
        private JButton btnManageBill = new JButton();
        private JButton btnManageEmployee = new JButton();
        private JButton btnManageProfit = new JButton();
        private JButton btnManageVoucher = new JButton();
        private JButton btnRoomPlace = new JButton();
        Login_Form loginFormData = new Login_Form();

        public JPanel renderMenuPanel() {
                panelMenu.setBackground(new Color(30, 60, 90));
                panelMenu.setPreferredSize(new Dimension(200, 700));
                panelMenu.setLayout(new BorderLayout());

                // Panel thông tin nhân viên
                panelInfoEmployee.setBackground(new Color(30, 60, 90));
                panelInfoEmployee.setPreferredSize(new Dimension(200, 300));
                panelInfoEmployee.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 50));

                labWelcome.setFont(new Font("Segoe UI", Font.BOLD, 16));
                labWelcome.setForeground(Color.WHITE);
                labWelcome.setText("Chào mừng bạn");
                panelInfoEmployee.add(labWelcome);

                // Hiển thị ảnh nhân viên
                String imagePath = "D:\\java\\project_javaswing\\src\\main\\java\\com\\example\\images\\avatar_java.png"; // Đường
                                                                                                                          // dẫn
                                                                                                                          // đến
                                                                                                                          // file
                                                                                                                          // ảnh
                File imageFile = new File(imagePath);
                if (imageFile.exists()) {
                        ImageIcon imageIcon = new ImageIcon(imagePath);
                        Image scaledImage = imageIcon.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH); // Kích
                                                                                                                 // thước
                                                                                                                 // ảnh
                        labImageEmployee.setIcon(new ImageIcon(scaledImage));
                } else {
                        labImageEmployee.setText("Không có ảnh");
                        labImageEmployee.setForeground(Color.WHITE);
                }
                // panelInfoEmployee.add(labImageEmployee);
                panelInfoEmployee.add(labImageEmployee);

                labName.setFont(new Font("Segoe UI", Font.BOLD, 16));
                labName.setForeground(Color.WHITE);
                // Employee employee = loginFormData.getEmployee();
                labName.setText("Nhóm 8");
                panelInfoEmployee.add(labName);

                panelMenu.add(panelInfoEmployee, BorderLayout.PAGE_START);

                // Panel danh sách nút
                panelListButton.setBackground(new Color(30, 60, 90));
                panelListButton.setPreferredSize(new Dimension(200, 400));
                panelListButton.setLayout(new GridLayout(9, 1, 10, 10));

                // Cấu hình các nút
                configureButton(btnRoomManage, "Quản lý phòng");
                configureButton(btnRoomPlace, "Quản lý đặt phòng");
                configureButton(btnManageBill, "Quản lý hóa đơn");
                configureButton(btnManageService, "Quản lý dịch vụ");
                configureButton(btnManageVoucher, "Quản lý voucher");
                configureButton(btnManageEmployee, "Quản lý nhân viên");
                configureButton(btnManageProfit, "Quản lý doanh thu");
                configureButton(btnExit, "Thoát");

                // Thêm các nút vào panel
                panelListButton.add(btnRoomManage);
                panelListButton.add(btnRoomPlace);
                panelListButton.add(btnManageBill);
                panelListButton.add(btnManageService);
                panelListButton.add(btnManageVoucher);
                panelListButton.add(btnManageEmployee);
                panelListButton.add(btnManageProfit);
                panelListButton.add(btnExit);

                panelMenu.add(panelListButton, BorderLayout.CENTER);

                return panelMenu;
        }

        private void configureButton(JButton button, String text) {
                button.setText(text);
                button.setFont(new Font("Segoe UI", Font.BOLD, 14));
                button.setForeground(Color.WHITE);
                button.setBorder(null);
                button.setContentAreaFilled(false);
                button.setHorizontalAlignment(SwingConstants.LEFT);
                button.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // Thêm khoảng cách 20px bên trái

                // Thêm sự kiện di chuột
                button.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                                button.setForeground(Color.RED); // Chuyển màu chữ sang đỏ khi di chuột
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                                button.setForeground(Color.WHITE); // Trở lại màu trắng khi chuột rời đi
                        }
                });
        }

        // Chuyển đến giao diện quản lý phòng
        public void addRoomManageListener(java.awt.event.ActionListener listener) {
                btnRoomManage.addActionListener(listener);
        }

        // Chuyển đến giao diện quản lý đặt phòng
        public void addRoomPlaceListener(java.awt.event.ActionListener listener) {
                btnRoomPlace.addActionListener(listener);
        }

        // Chuyển đến giao diện quản lý dịch vụ
        public void addManageServiceListener(java.awt.event.ActionListener listener) {
                btnManageService.addActionListener(listener);
        }

        // Chuyển đến giao diện quản lý hóa đơn
        public void addManageBillListener(java.awt.event.ActionListener listener) {
                btnManageBill.addActionListener(listener);
        }

        // Chuyển đến giao diện quản lý nhân viên
        public void addManageEmployeeListener(java.awt.event.ActionListener listener) {
                btnManageEmployee.addActionListener(listener);
        }

        // Chuyển đến giao diện quản lý voucher
        public void voucherManagement(java.awt.event.ActionListener evt) {
                btnManageVoucher.addActionListener(evt);
        }

        // Chuyển đến giao diện quản lý doanh thu
        public void profitManagement(java.awt.event.ActionListener evt) {
                btnManageProfit.addActionListener(evt);
        }

        // Thoát
        public void addExitListener(java.awt.event.ActionListener listener) {
                btnExit.addActionListener(listener);
        }
}