package com.example.view.bookings;

import javax.swing.*;
import java.awt.*;

public class BookingEditPanel {

    private JPanel bookingEditPanel = new JPanel();

    public JPanel renderPanel() {
        bookingEditPanel.setLayout(new BorderLayout());

        // Panel thông tin khách hàng và phòng
        JPanel customerAndRoomInfoPanel = createCustomerAndRoomInfoPanel();
        bookingEditPanel.add(customerAndRoomInfoPanel, BorderLayout.PAGE_START);

        // Panel thông tin dịch vụ
        JPanel serviceDetailsPanel = createServiceDetailsPanel();
        bookingEditPanel.add(serviceDetailsPanel, BorderLayout.CENTER);

        // Panel nút chức năng
        JPanel actionButtonsPanel = createActionButtonsPanel();
        bookingEditPanel.add(actionButtonsPanel, BorderLayout.PAGE_END);

        return bookingEditPanel;
    }

    private JPanel createCustomerAndRoomInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 20, 10)); // Chia thành 2 cột: khách hàng và phòng
        panel.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng và phòng"));

        // Panel thông tin khách hàng
        JPanel customerInfoPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        customerInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

        JLabel labelCustomerName = new JLabel("Tên khách hàng: Nguyễn Văn A");
        JLabel labelCustomerAddress = new JLabel("Địa chỉ: 123 Đường ABC, TP.HCM");
        JLabel labelCustomerEmail = new JLabel("Email: nguyenvana@example.com");
        JLabel labelCustomerPhone = new JLabel("Số điện thoại: 0123456789");

        customerInfoPanel.add(labelCustomerName);
        customerInfoPanel.add(labelCustomerAddress);
        customerInfoPanel.add(labelCustomerEmail);
        customerInfoPanel.add(labelCustomerPhone);

        // Panel thông tin phòng
        JPanel roomInfoPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        roomInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));

        JLabel labelRoomName = new JLabel("Tên phòng: Phòng VIP");
        JLabel labelRoomNumber = new JLabel("Số phòng: 101");
        JLabel labelRoomPrice = new JLabel("Giá phòng: 1.000.000 VND");
        JLabel labelDeposit = new JLabel("Tiền đặt cọc: 500.000 VND");
        JLabel labelCheckoutDate = new JLabel("Ngày check-out: 01/04/2025");

        roomInfoPanel.add(labelRoomName);
        roomInfoPanel.add(labelRoomNumber);
        roomInfoPanel.add(labelRoomPrice);
        roomInfoPanel.add(labelDeposit);
        roomInfoPanel.add(labelCheckoutDate);

        // Thêm 2 panel vào panel chính
        panel.add(customerInfoPanel);
        panel.add(roomInfoPanel);

        return panel;
    }

    private JPanel createServiceDetailsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Dịch vụ phòng sử dụng"));

        // Panel bên trái: Dịch vụ đã sử dụng
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Dịch vụ đã sử dụng"));

        JTable tableServiceDetails = new JTable();
        tableServiceDetails.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { "Dịch vụ 1", "100.000 VND" },
                        { "Dịch vụ 2", "200.000 VND" }
                },
                new String[] {
                        "Tên dịch vụ", "Giá"
                }));
        JScrollPane tableScrollPaneLeft = new JScrollPane(tableServiceDetails);
        leftPanel.add(tableScrollPaneLeft, BorderLayout.CENTER);

        // Panel bên phải: Danh sách dịch vụ có sẵn
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Danh sách dịch vụ"));

        JTable tableAvailableServices = new JTable();
        tableAvailableServices.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { "Dịch vụ 3", "300.000 VND" },
                        { "Dịch vụ 4", "400.000 VND" }
                },
                new String[] {
                        "Tên dịch vụ", "Giá"
                }));
        JScrollPane tableScrollPaneRight = new JScrollPane(tableAvailableServices);
        rightPanel.add(tableScrollPaneRight, BorderLayout.CENTER);

        // Nút thêm dịch vụ
        JPanel buttonPanelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton buttonAddService = new JButton("Thêm dịch vụ");
        buttonPanelRight.add(buttonAddService);
        rightPanel.add(buttonPanelRight, BorderLayout.PAGE_END);

        // Xử lý sự kiện thêm dịch vụ
        buttonAddService.addActionListener(e -> {
            int selectedRow = tableAvailableServices.getSelectedRow();
            if (selectedRow != -1) {
                String serviceName = (String) tableAvailableServices.getValueAt(selectedRow, 0);
                String servicePrice = (String) tableAvailableServices.getValueAt(selectedRow, 1);
                System.out.println("Dịch vụ được chọn: " + serviceName + " - Giá: " + servicePrice);
                // TODO: Thêm dịch vụ vào bảng "Dịch vụ đã sử dụng"
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dịch vụ để thêm!", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        // Chia panel chính thành 2 phần: bên trái và bên phải
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400); // Đặt vị trí chia giữa 2 panel
        panel.add(splitPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createActionButtonsPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton buttonUpdateInvoice = new JButton("Cập nhật hóa đơn");
        JButton buttonBack = new JButton("Quay lại");
        panel.add(buttonUpdateInvoice);
        panel.add(buttonBack);

        // Xử lý sự kiện nút "Cập nhật hóa đơn"
        buttonUpdateInvoice.addActionListener(e -> {
            // TODO: Thực hiện logic cập nhật hóa đơn
            JOptionPane.showMessageDialog(null, "Hóa đơn đã được cập nhật!", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Xử lý sự kiện nút "Quay lại"
        buttonBack.addActionListener(e -> {
            // TODO: Quay lại giao diện trước đó
            System.out.println("Quay lại giao diện trước đó");
        });

        return panel;
    }
}