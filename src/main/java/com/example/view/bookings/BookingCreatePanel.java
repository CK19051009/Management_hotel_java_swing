package com.example.view.bookings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.GuestController;
import com.example.controllers.RoomsController;
import com.example.models.Guest;
import com.example.models.Room;

import java.awt.*;

import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class BookingCreatePanel {

        private JPanel bookingPanel = new JPanel();
        private JPanel topBookingPanel = new JPanel();
        private JLabel labTitleBooking = new JLabel("Quản lý đặt phòng");
        private JPanel centerBookingPanel = new JPanel();
        private JScrollPane scrollPane;

        // Các thành phần trong giao diện
        private JTextField inputCheckInBooking = new JTextField(15);
        private JTextField inputCustomerNameBooking = new JTextField(15);
        private JTextField inputPhoneBooking = new JTextField(15);
        private JTextField inputEmailBooking = new JTextField(15);
        private JComboBox<String> comboBoxRentalTypeBooking = new JComboBox<>(
                        new String[] { "Thuê theo ngày", "Thuê theo giờ" });

        private JButton buttonSaveBooking = new JButton("Lưu");
        private JButton buttonCancelBooking = new JButton("Hủy");
        JTextField textRoomNumber = new JTextField(15);
        JTextField textRoomType = new JTextField(15);
        JTextField textRoomStatus = new JTextField(15);
        JTextField textRoomPrice = new JTextField(15);
        JTextField inputDeposit = new JTextField(10);
        JButton buttonCreateCustomer;
        private DefaultTableModel tableModel;
        JTable tableSearchResults;
        JTable tableCustomerResults;
        DefaultTableModel customerTableModel;

        // controller
        RoomsController roomsController = new RoomsController();
        GuestController guestController = new GuestController();

        public JPanel renderPanel() {
                // Cấu hình bookingPanel
                bookingPanel.setLayout(new BorderLayout());

                // Cấu hình topBookingPanel
                configureTopPanel();
                bookingPanel.add(topBookingPanel, BorderLayout.PAGE_START);

                // Cấu hình centerBookingPanel
                configureCenterPanel();
                scrollPane = new JScrollPane(centerBookingPanel);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                bookingPanel.add(scrollPane, BorderLayout.CENTER);

                return bookingPanel;
        }

        private void configureTopPanel() {
                topBookingPanel.setPreferredSize(new Dimension(1100, 100));
                labTitleBooking.setFont(new Font("Segoe UI", Font.BOLD, 24));
                labTitleBooking.setForeground(new Color(30, 60, 90));
                topBookingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                topBookingPanel.add(labTitleBooking);
        }

        private void configureCenterPanel() {
                centerBookingPanel.setLayout(new BoxLayout(centerBookingPanel, BoxLayout.Y_AXIS));
                centerBookingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                // Thêm các thành phần vào centerBookingPanel
                centerBookingPanel.add(createSearchRoomPanel());
                centerBookingPanel.add(createCustomerInfoPanel());
                centerBookingPanel.add(createActionButtonsPanel());
        }

        private JPanel createCustomerInfoPanel() {
                JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // Chia thành 2 phần: bên trái và bên phải
                mainPanel.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

                // Panel bên trái: Nhập thông tin khách hàng mới
                JPanel leftPanel = new JPanel(new GridLayout(5, 2, 10, 10));
                leftPanel.setBorder(BorderFactory.createTitledBorder("Tạo mới khách hàng"));

                leftPanel.add(new JLabel("Tên khách hàng:"));
                leftPanel.add(inputCustomerNameBooking);

                leftPanel.add(new JLabel("Số điện thoại:"));
                leftPanel.add(inputPhoneBooking);

                leftPanel.add(new JLabel("Email:"));

                leftPanel.add(inputEmailBooking);
                leftPanel.add(new JLabel("Ngày check-in:"));
                LocalDateTime now = LocalDateTime.now().withNano(0);
                ;
                Timestamp timestamp = Timestamp.valueOf(now);
                inputCheckInBooking.setText(String.valueOf((timestamp)));
                leftPanel.add(inputCheckInBooking);

                buttonCreateCustomer = new JButton("Tạo khách hàng");
                leftPanel.add(new JLabel()); // Ô trống để căn chỉnh
                leftPanel.add(buttonCreateCustomer);

                // Panel bên phải: Tìm kiếm khách hàng đã có
                JPanel rightPanel = new JPanel(new BorderLayout());
                rightPanel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm khách hàng"));

                // Thanh tìm kiếm
                JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JTextField inputSearchCustomer = new JTextField(20);
                JButton buttonSearchCustomer = new JButton("Tìm kiếm");
                searchPanel.add(new JLabel("Nhập thông tin khách hàng:"));
                searchPanel.add(inputSearchCustomer);
                searchPanel.add(buttonSearchCustomer);

                // Bảng hiển thị danh sách khách hàng
                String[] columnNames = { "ID", "Tên khách hàng", "Số điện thoại", "Email", "Địa trỉ" };
                customerTableModel = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int col) {
                                return false;
                        }
                };
                tableCustomerResults = new JTable(customerTableModel);
                refreshTableGuest(customerTableModel);
                tableCustomerResults.setRowHeight(25);
                JScrollPane customerScrollPane = new JScrollPane(tableCustomerResults);
                customerScrollPane.setPreferredSize(new Dimension(400, 200)); // Giới hạn chiều cao bảng

                // Thêm các thành phần vào rightPanel
                rightPanel.add(searchPanel, BorderLayout.PAGE_START);
                rightPanel.add(customerScrollPane, BorderLayout.CENTER);

                // Bắt sự kiện khi chọn khách hàng từ bảng
                tableCustomerResults.getSelectionModel().addListSelectionListener(e -> {
                        if (!e.getValueIsAdjusting()) {
                                int selectedRow = tableCustomerResults.getSelectedRow();
                                if (selectedRow != -1) {
                                        // Lấy dữ liệu từ hàng được chọn
                                        String customerName = tableCustomerResults.getValueAt(selectedRow, 1)
                                                        .toString();
                                        String customerPhone = tableCustomerResults.getValueAt(selectedRow, 2)
                                                        .toString();
                                        String customerEmail = tableCustomerResults.getValueAt(selectedRow, 3)
                                                        .toString();

                                        // Hiển thị dữ liệu trong các trường bên trái
                                        inputCustomerNameBooking.setText(customerName);
                                        inputPhoneBooking.setText(customerPhone);
                                        inputEmailBooking.setText(customerEmail);
                                }
                        }
                });

                // Thêm các panel con vào mainPanel
                mainPanel.add(leftPanel);
                mainPanel.add(rightPanel);

                return mainPanel;
        }

        private JPanel createActionButtonsPanel() {
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

                panel.add(buttonSaveBooking);
                panel.add(buttonCancelBooking);

                return panel;
        }

        private JPanel createSearchRoomPanel() {
                JPanel panel = new JPanel(new BorderLayout());
                panel.setBorder(BorderFactory.createTitledBorder("Tìm kiếm phòng"));

                // Panel bên trái: Tìm kiếm phòng và danh sách kết quả
                JPanel leftPanel = new JPanel(new BorderLayout());
                leftPanel.setBorder(BorderFactory.createTitledBorder("Danh sách phòng"));

                // Thanh tìm kiếm
                JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JTextField inputSearchRoom = new JTextField(20);
                JButton buttonSearchRoom = new JButton("Tìm kiếm");
                searchPanel.add(new JLabel("Nhập thông tin phòng:"));
                searchPanel.add(inputSearchRoom);
                searchPanel.add(buttonSearchRoom);

                // Bảng hiển thị danh sách phòng
                String[] columnNames = { "STT", "Số phòng", "Loại phòng", "Gía phòng", "Trạng thái", "Tối đa" };
                tableModel = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int col) {
                                return false;
                        }
                };
                tableSearchResults = new JTable(tableModel);
                refreshTable();
                tableSearchResults.setRowHeight(25);
                JScrollPane tableScrollPane = new JScrollPane(tableSearchResults);
                tableScrollPane.setPreferredSize(new Dimension(500, 200)); // Giới hạn chiều cao bảng

                // Ô nhập tiền đặt cọc
                JPanel depositPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                depositPanel.add(new JLabel("Tiền đặt cọc:"));
                depositPanel.add(inputDeposit);

                // Thêm các thành phần vào leftPanel
                leftPanel.add(searchPanel, BorderLayout.PAGE_START);
                leftPanel.add(tableScrollPane, BorderLayout.CENTER);
                leftPanel.add(depositPanel, BorderLayout.PAGE_END);

                // Panel bên phải: Hiển thị thông tin chi tiết phòng
                JPanel rightPanel = new JPanel(new GridLayout(4, 2, 10, 10));
                rightPanel.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));

                JLabel labelRoomNumber = new JLabel("Số phòng:");
                JLabel labelRoomType = new JLabel("Loại phòng:");
                JLabel labelRoomStatus = new JLabel("Trạng thái:");
                JLabel labelRoomPrice = new JLabel("Giá phòng:");

                textRoomNumber.setEditable(false);
                textRoomType.setEditable(false);

                textRoomStatus.setEditable(false);

                textRoomPrice.setEditable(false);

                rightPanel.add(labelRoomNumber);
                rightPanel.add(textRoomNumber);
                rightPanel.add(labelRoomType);
                rightPanel.add(textRoomType);
                rightPanel.add(labelRoomStatus);
                rightPanel.add(textRoomStatus);
                rightPanel.add(labelRoomPrice);
                rightPanel.add(textRoomPrice);
                // Bắt sự kiện khi chọn phòng trong bảng
                tableSearchResults.getSelectionModel().addListSelectionListener(e -> {
                        if (!e.getValueIsAdjusting()) { // Đảm bảo sự kiện chỉ được xử lý một lần
                                int selectedRow = tableSearchResults.getSelectedRow();
                                if (selectedRow != -1) {
                                        // Lấy dữ liệu từ hàng được chọn
                                        String roomNumber = tableSearchResults.getValueAt(selectedRow, 1).toString();
                                        String roomType = tableSearchResults.getValueAt(selectedRow, 2).toString();
                                        String roomStatus = tableSearchResults.getValueAt(selectedRow, 4).toString();
                                        String roomPrice = tableSearchResults.getValueAt(selectedRow, 3).toString();

                                        // Hiển thị dữ liệu trong các trường bên phải
                                        textRoomNumber.setText(roomNumber);
                                        textRoomType.setText(roomType);
                                        textRoomStatus.setText(roomStatus);
                                        textRoomPrice.setText(roomPrice);
                                }
                        }
                });
                // Chia panel chính thành 2 phần: bên trái và bên phải
                JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
                splitPane.setDividerLocation(600); // Đặt vị trí chia giữa 2 panel
                panel.add(splitPane, BorderLayout.CENTER);

                return panel;
        }

        // sự kiên
        public void refreshTable() {
                tableModel.setRowCount(0);
                List<Room> rooms = roomsController.listStatus("available");
                for (Room room : rooms) {
                        addRoom(room, tableModel); // Thêm từng phòng vào bảng
                }
                tableSearchResults.revalidate();
                tableSearchResults.repaint();

        }

        private void addRoom(Room room, DefaultTableModel tableModel) {
                tableModel.addRow(new Object[] {
                                room.getId(),
                                room.getRoomNumber(),
                                room.getRoomType(),
                                room.getPrice(),
                                room.getStatus(),
                                room.getCapacity(),
                });
        }

        private void addCustomer(Guest guest, DefaultTableModel tableModel) {
                tableModel.addRow(new Object[] {
                                guest.getId(),
                                guest.getFullName(),
                                guest.getEmail(),
                                guest.getPhone(),
                                guest.getAddress(),
                });
        }

        public void refreshTableGuest(DefaultTableModel tableModel) {
                tableModel.setRowCount(0);
                List<Guest> guests = guestController.getAllGuests();
                for (Guest guest : guests) {
                        addCustomer(guest, tableModel); // Thêm từng phòng vào bảng
                }

        }

        // lấy ra id khách hàng và id phòng để lưu vào hóa đơn thôi

        public void actionSaveBill(ActionListener e) {
                buttonSaveBooking.addActionListener(e);
        }

        public int getIdRoomPlaced() {
                int selectedRow = tableSearchResults.getSelectedRow();
                if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn một phòng!");
                        return 0;
                }

                int id = (int) tableModel.getValueAt(selectedRow, 0);

                return id;
        }

        public int getIdGuest() {
                int selectedRow = tableCustomerResults.getSelectedRow();
                int id = 0;
                if (selectedRow == -1) {
                        String fullName = inputCustomerNameBooking.getText();
                        String phone = inputPhoneBooking.getText();
                        String email = inputEmailBooking.getText();
                        Guest guest = new Guest(fullName, phone, "", email);
                        Boolean isCreated = guestController.createGuest(guest);

                        if (isCreated) {
                                System.out.println("Create guest successfully!");
                                id = guest.getId();
                        } else {
                                System.out.println("Create guest error!");
                        }

                        return id;

                } else {

                        id = (int) customerTableModel.getValueAt(selectedRow, 0);
                        return id;
                }
        }

        public String getDeposit() {
                return inputDeposit.getText();
        }

        public String getCheckIn() {
                return inputCheckInBooking.getText();
        }

        public void setCheckIn(String time) {
                inputCheckInBooking.setText(time);
        }

        // Phương thức để xóa dữ liệu
        public void clearData() {
                // Xóa dữ liệu trong các trường nhập liệu
                inputCustomerNameBooking.setText("");
                inputPhoneBooking.setText("");
                inputEmailBooking.setText("");
                inputCheckInBooking.setText("");
                inputDeposit.setText("");

                // Đặt lại giá trị mặc định cho ComboBox
                comboBoxRentalTypeBooking.setSelectedIndex(0);

                // Xóa dữ liệu trong bảng danh sách phòng
                // tableModel.setRowCount(0);
                textRoomNumber.setText("");
                textRoomType.setText("");
                textRoomStatus.setText("");
                textRoomPrice.setText("");
                inputDeposit.setText("");
                // Xóa dữ liệu trong bảng danh sách khách hàng
                // customerTableModel.setRowCount(0);

                // Làm mới giao diện bảng
                tableSearchResults.revalidate();
                tableSearchResults.repaint();
                tableCustomerResults.revalidate();
                tableCustomerResults.repaint();
        }

        public void actionCancel(ActionListener e) {
                buttonCancelBooking.addActionListener(e);
        }

        public void actionCreateCustomer(ActionListener e) {
                buttonCreateCustomer.addActionListener(e);
        }
}