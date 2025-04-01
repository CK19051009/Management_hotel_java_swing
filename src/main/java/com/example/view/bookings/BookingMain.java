package com.example.view.bookings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.BookingController;
import com.example.controllers.RoomsController;
import com.example.helper.custom.ButtonCustom;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import com.example.models.Booking;
import com.example.models.Room;

public class BookingMain {

    private JPanel bookingMainPanel = new JPanel();
    private JButton createInvoiceButton = new JButton("Tạo hóa đơn");
    private JButton updateInvoiceButton = new JButton("Cập nhật hóa đơn");
    private JButton checkOutButton = new JButton("Check-Out");
    JButton searchButton = new JButton("Tìm kiếm");
    JTextField searchField = new JTextField(20);
    JTable invoiceTable;
    ButtonCustom buttonCustom = new ButtonCustom();
    private DefaultTableModel tableModel;

    BookingController bookingController = new BookingController();
    RoomsController roomsController = new RoomsController();

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
        JLabel inputInforSearch = new JLabel("Nhập thông tin hóa đơn:");
        buttonCustom.customizeText(inputInforSearch);
        searchPanel.add(inputInforSearch);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        panel.add(searchPanel, BorderLayout.CENTER);

        // Panel bên phải: Các nút chức năng
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // 2 hàng cho các nút
        buttonsPanel.setBorder(BorderFactory.createTitledBorder("Chức năng"));

        updateInvoiceButton.setPreferredSize(new Dimension(150, 80));
        buttonCustom.customizeBlueButton(updateInvoiceButton);
        createInvoiceButton.setPreferredSize(new Dimension(150, 80));
        buttonCustom.customizeGreenButton(createInvoiceButton);
        checkOutButton.setPreferredSize(new Dimension(150, 80));
        buttonCustom.customizeRedButton(checkOutButton);

        buttonsPanel.add(updateInvoiceButton);
        buttonsPanel.add(createInvoiceButton);
        buttonsPanel.add(checkOutButton);

        panel.add(buttonsPanel, BorderLayout.EAST);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));

        // Cấu hình bảng
        String[] columnNames = { "STT", "Mã khách hàng", "Mã phòng", "Số phòng", "Giá phòng", "Check-In", "Check-Out",
                "Trạng thái" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        invoiceTable = new JTable(tableModel);
        refreshTable();
        // invoiceTable.revalidate();
        // invoiceTable.repaint();
        JScrollPane tableScrollPane = new JScrollPane(invoiceTable);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        return panel;
    }

    public void actionCreateBill(ActionListener e) {
        createInvoiceButton.addActionListener(e);
    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        List<Booking> bookings = bookingController.listBooking();
        for (Booking booking : bookings) {
            // System.out.println(booking);
            // System.out.println(booking.getRoomId() + " hihi");
            Room room = roomsController.roomDetail(booking.getRoomId());
            addRoom(booking, room.getRoomNumber(), room.getPrice(), tableModel);
        }
        // tableRoom.revalidate();
        // tableRoom.repaint();
    }

    private void addRoom(Booking booking, int numberRoom, double price, DefaultTableModel tableModel) {
        tableModel.addRow(new Object[] {
                booking.getId(),
                booking.getGuestId(),
                booking.getRoomId(),
                numberRoom,
                price,
                booking.getCheckIn(),
                booking.getCheckOut(),
                booking.getStatus(),

        });
    }

    public void actionUpdateBill(ActionListener e) {
        updateInvoiceButton.addActionListener(e);
    }

    public Booking getSelectedBooking() {
        int selectedRow = invoiceTable.getSelectedRow();
        System.out.println(selectedRow);
        if (selectedRow == -1) {

            return null;
        }

        Booking booking = new Booking();
        booking.setId((int) tableModel.getValueAt(selectedRow, 0));
        booking.setGuestId((int) tableModel.getValueAt(selectedRow, 1));
        booking.setRoomId((int) tableModel.getValueAt(selectedRow, 2));
        booking.setCheckIn((Timestamp) tableModel.getValueAt(selectedRow, 5));
        booking.setStatus((String) tableModel.getValueAt(selectedRow, 7)); //

        return booking;
    }

    // sự kiện check-out
    public void actionCheckOut(ActionListener e) {
        checkOutButton.addActionListener(e);
    }

}