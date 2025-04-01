package com.example.view.bookings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BookingMain {

    private JPanel bookingMainPanel = new JPanel();
    private JButton createInvoiceButton = new JButton("Tạo hóa đơn");
    private JButton updateInvoiceButton = new JButton("Cập nhật hóa đơn");
    JButton searchButton = new JButton("Tìm kiếm");
    JTextField searchField = new JTextField(20);

    public JPanel renderPanel() {
        bookingMainPanel.setLayout(new BorderLayout());

        // Panel trên cùng: Tiêu đề
        JPanel titlePanel = createTitlePanel();
        bookingMainPanel.add(titlePanel, BorderLayout.PAGE_START);

        // Panel giữa: Tìm kiếm hóa đơn và các nút chức năng
        JPanel searchAndButtonsPanel = createSearchAndButtonsPanel();
        System.out.println(bookingMainPanel.getWidth());
        searchAndButtonsPanel.setPreferredSize(new Dimension(bookingMainPanel.getWidth(), 250)); // Cố định chiều cao
        bookingMainPanel.add(searchAndButtonsPanel, BorderLayout.CENTER);

        // Panel dưới cùng: Bảng dữ liệu hóa đơn
        JPanel tablePanel = createTablePanel();
        bookingMainPanel.add(tablePanel, BorderLayout.PAGE_END);

        return bookingMainPanel;
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Quản lý đặt phòng");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(30, 60, 90));
        panel.add(titleLabel);
        return panel;
    }

    private JPanel createSearchAndButtonsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel bên trái: Tìm kiếm hóa đơn
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm hóa đơn"));
        searchPanel.setFont(new Font("Segoe UI", Font.BOLD, 18));

        searchPanel.add(new JLabel("Nhập thông tin hóa đơn:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        panel.add(searchPanel, BorderLayout.CENTER);

        // Panel bên phải: Các nút chức năng
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createTitledBorder("Chức năng"));

        updateInvoiceButton.setPreferredSize(new Dimension(150, 80));

        createInvoiceButton.setPreferredSize(new Dimension(150, 80));

        buttonsPanel.add(updateInvoiceButton);
        buttonsPanel.add(createInvoiceButton);

        panel.add(buttonsPanel, BorderLayout.EAST);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));

        JTable invoiceTable = new JTable();
        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { 1, "Đang sử dụng", "Phòng 101", "1.000.000 VND" },
                        { 2, "Đang sử dụng", "Phòng 102", "1.200.000 VND" },
                        { 3, "Đã trả phòng", "Phòng 103", "1.500.000 VND" }
                },
                new String[] {
                        "STT", "Trạng thái", "Tên phòng", "Giá phòng"
                }));

        JScrollPane tableScrollPane = new JScrollPane(invoiceTable);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        return panel;
    }

    public void actionCreateBill(ActionListener e) {
        createInvoiceButton.addActionListener(e);
    }
}