package com.example.view.default_main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.example.view.room.Index;

import java.awt.*;

public class MainDefault extends JFrame {

    private JPanel contentPanel; // Panel hiển thị nội dung động

    public MainDefault() {
        // Thiết lập JFrame
        setTitle("Quản lý khách sạn");
        setSize(1600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel menu bên trái
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setPreferredSize(new Dimension(200, 700)); // Đặt chiều rộng cố định
        menuPanel.setBackground(new Color(30, 60, 90));

        // Panel thông tin nhân viên (inforPanel)
        JPanel inforPanel = new JPanel();
        inforPanel.setPreferredSize(new Dimension(200, 200)); // Đặt chiều cao cố định
        inforPanel.setBackground(new Color(30, 60, 90));
        inforPanel.setLayout(new BorderLayout());

        JLabel welcome = new JLabel("Welcome");
        welcome.setForeground(Color.WHITE);
        welcome.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa

        // Chèn ảnh vào JLabel
        JLabel imageEmployee = new JLabel();
        imageEmployee.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa
        ImageIcon icon = new ImageIcon(
                "D:\\java\\project_javaswing\\src\\main\\java\\com\\example\\images\\employee.jpg"); // Đường dẫn đến
                                                                                                     // ảnh
        Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Thay đổi kích thước ảnh
        imageEmployee.setIcon(new ImageIcon(scaledImage)); // Đặt ảnh vào JLabel

        JLabel labName = new JLabel("Nguyễn Đức Hiệu");
        labName.setForeground(Color.WHITE);
        labName.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa
        welcome.setBorder(new EmptyBorder(10, 0, 0, 0));
        labName.setBorder(new EmptyBorder(10, 0, 20, 0));

        inforPanel.add(welcome, BorderLayout.NORTH);
        inforPanel.add(imageEmployee, BorderLayout.CENTER);
        inforPanel.add(labName, BorderLayout.SOUTH);

        menuPanel.add(inforPanel, BorderLayout.NORTH);

        // Panel chứa các nút chức năng (listButtonPanel)
        JPanel listButtonPanel = new JPanel();
        listButtonPanel.setPreferredSize(new Dimension(200, 400)); // Đặt chiều cao cố định
        listButtonPanel.setLayout(new BoxLayout(listButtonPanel, BoxLayout.Y_AXIS)); // Sắp xếp theo chiều dọc
        listButtonPanel.setBackground(new Color(30, 60, 90));

        // Thêm các nút vào listButtonPanel
        JButton btnManageRooms = new JButton("Quản lý phòng");
        JButton btnManageGuests = new JButton("Quản lý khách hàng");
        JButton btnManageServices = new JButton("Quản lý dịch vụ");
        JButton btnManageBookings = new JButton("Quản lý hóa đơn");

        // Tùy chỉnh các nút
        customizeButton(btnManageRooms);
        customizeButton(btnManageGuests);
        customizeButton(btnManageServices);
        customizeButton(btnManageBookings);

        // Thêm sự kiện cho các nút
        btnManageRooms.addActionListener(e -> showContent(new Index(this)));
        // btnManageGuests.addActionListener(e -> showContent("Quản lý khách hàng"));
        // btnManageServices.addActionListener(e -> showContent("Quản lý dịch vụ"));
        // btnManageBookings.addActionListener(e -> showContent("Quản lý hóa đơn"));

        // Thêm khoảng cách giữa các nút
        listButtonPanel.add(Box.createVerticalStrut(10));
        listButtonPanel.add(btnManageRooms);
        listButtonPanel.add(Box.createVerticalStrut(10));
        listButtonPanel.add(btnManageGuests);
        listButtonPanel.add(Box.createVerticalStrut(10));
        listButtonPanel.add(btnManageServices);
        listButtonPanel.add(Box.createVerticalStrut(10));
        listButtonPanel.add(btnManageBookings);

        // Thêm inforPanel và listButtonPanel vào menuPanel
        menuPanel.add(inforPanel, BorderLayout.NORTH);
        menuPanel.add(listButtonPanel, BorderLayout.CENTER);

        // Panel nội dung bên phải (contentPanel)
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        contentPanel.setLayout(new BorderLayout());

        // Hiển thị giao diện mặc định
        showContent(new Index(this));

        // Thêm menuPanel và contentPanel vào JFrame
        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    // Phương thức để tùy chỉnh nút
    private void customizeButton(JButton button) {
        button.setFocusPainted(false); // Loại bỏ viền khi nhấn
        button.setContentAreaFilled(false); // Tắt màu nền
        button.setOpaque(false); // Làm trong suốt
        button.setBorderPainted(false); // Tắt viền
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Căn giữa nút
        button.setHorizontalAlignment(SwingConstants.LEFT); // Căn chữ về bên trái
        button.setMaximumSize(new Dimension(250, 40)); // Đặt kích thước cố định cho nút
        button.setForeground(Color.white);
        button.setFont(new Font("Arial", Font.BOLD, 16));
    }

    // Phương thức để hiển thị nội dung động trong contentPanel
    public void showContent(JPanel panel) {
        contentPanel.removeAll(); // Xóa nội dung cũ

        // JLabel labString = new JLabel(str, SwingConstants.CENTER);
        // labString.setFont(new Font("Arial", Font.BOLD, 16));
        contentPanel.add(panel, BorderLayout.CENTER); // Thêm nội dung mới
        contentPanel.revalidate(); // Cập nhật giao diện
        contentPanel.repaint(); // Vẽ lại giao diện
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainDefault mainDefault = new MainDefault();
            mainDefault.setVisible(true);
        });
    }
}