package com.example.view.bookings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.VoucherController;
import com.example.helper.custom.ButtonCustom;
import com.example.models.Booking;
import com.example.models.BookingService;
import com.example.models.BookingVoucher;
import com.example.models.Guest;
import com.example.models.Room;
import com.example.models.Service;
import com.example.models.Voucher;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionListener;

public class BookingCheckOut {
    private JPanel invoicePanel = new JPanel();
    private int idBooking;
    private int idCustomer;
    private int idRoom;
    private String timeStay;
    private String checkOut;
    private Double totalRoomPrice;
    private Double totalPriceService;
    private Double totalAmount;

    private Double totalDicount;
    private Room roomUsage;
    private Booking bookingUsage;
    private JTable availableVoucherTable;
    private JButton addVoucherButton;
    private JButton deleteVoucherButton;
    VoucherController voucherController = new VoucherController();
    ButtonCustom customize = new ButtonCustom();

    public Double getTotalDicount() {
        return totalDicount;
    }

    public void setTotalDicount(Double totalDicount) {
        this.totalDicount = totalDicount;
    }

    public Room getRoomUsage() {
        return roomUsage;
    }

    public void setRoomUsage(Room roomUsage) {
        this.roomUsage = roomUsage;
    }

    public Booking getBookingUsage() {
        return bookingUsage;
    }

    public void setBookingUsage(Booking bookingUsage) {
        this.bookingUsage = bookingUsage;
    }

    public Double getTotalRoomPrice() {
        return totalRoomPrice;
    }

    public void setTotalRoomPrice(Double totalRoomPrice) {
        this.totalRoomPrice = totalRoomPrice;
    }

    public Double getTotalPriceService() {
        return totalPriceService;
    }

    public void setTotalPriceService(Double totalPriceService) {
        this.totalPriceService = totalPriceService;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public DefaultTableModel tableModelRoom;
    public DefaultTableModel tableModelServiceUsage;
    public DefaultTableModel tableModelVoucherApp;
    public DefaultTableModel tableModelVoucherAvailable;

    public DefaultTableModel getTableModelServiceUsage() {
        return tableModelServiceUsage;
    }

    public void setTableModelServiceUsage(DefaultTableModel tableModelServiceUsage) {
        this.tableModelServiceUsage = tableModelServiceUsage;
    }

    JTable roomTable;

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getTimeStay() {
        return timeStay;
    }

    public void setTimeStay(String timeStay) {
        this.timeStay = timeStay;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    JLabel labFullname = new JLabel();
    JLabel labEmail = new JLabel();
    JLabel labPhone = new JLabel();
    JLabel labAddress = new JLabel();
    private JTextField inputTotalPriceRoom = new JTextField();
    private JTextField inputTotalPriceService = new JTextField();
    private JTextField inputTotalAmount = new JTextField();
    private JTextField inputTotalDicount = new JTextField();
    JButton checkOutButton = new JButton("Trả phòng");
    JButton printInvoiceButton = new JButton("In hóa đơn");
    JButton cancelButton = new JButton("Hủy");
    private JTable appliedVoucherTable;

    public JPanel renderPanel() {
        // Cấu hình panel chính
        invoicePanel.setLayout(new BorderLayout());

        // Thêm các phần giao diện
        invoicePanel.add(createTitlePanel(), BorderLayout.NORTH);
        invoicePanel.add(createMainContentPanel(), BorderLayout.CENTER);
        invoicePanel.add(createButtonPanel(), BorderLayout.SOUTH);

        return invoicePanel;
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Hóa Đơn");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(new Color(30, 60, 90));
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    private JPanel createMainContentPanel() {
        JPanel mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new BoxLayout(mainContentPanel, BoxLayout.Y_AXIS));

        // Thêm các phần giao diện vào mainContentPanel
        mainContentPanel.add(createCustomerInfoPanel());
        mainContentPanel.add(createRoomAndServicePanel());
        mainContentPanel.add(createVoucherPanel());
        mainContentPanel.add(createPaymentPanel());

        return mainContentPanel;
    }

    private JPanel createCustomerInfoPanel() {
        JPanel customerInfoPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        customerInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));

        customerInfoPanel.add(new JLabel("Họ tên: "));
        customerInfoPanel.add(labFullname);
        customerInfoPanel.add(new JLabel("Số điện thoại: "));
        customerInfoPanel.add(labPhone);
        customerInfoPanel.add(new JLabel("Địa trỉ: "));
        customerInfoPanel.add(labAddress);
        customerInfoPanel.add(new JLabel("Email: "));
        customerInfoPanel.add(labEmail);

        return customerInfoPanel;
    }

    private JPanel createRoomAndServicePanel() {
        JPanel roomAndServicePanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // Thông tin phòng
        JPanel roomInfoPanel = new JPanel(new BorderLayout());
        roomInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));

        String[] columnNames = { "Số phòng", "Check-In", "Check-Out", "Giá", "Thời gian ở", "Loại phòng" };
        tableModelRoom = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        roomTable = new JTable(tableModelRoom);
        // addRoom(roomUsage, bookingUsage, tableModelRoom);
        roomInfoPanel.add(new JScrollPane(roomTable), BorderLayout.CENTER);

        // Dịch vụ khách hàng sử dụng
        JPanel serviceInfoPanel = new JPanel(new BorderLayout());
        serviceInfoPanel.setBorder(BorderFactory.createTitledBorder("Dịch vụ khách hàng sử dụng"));
        String[] columnNameServices = { "Tên dịch vụ", "Gía", "Số lần sử dụng", "Tổng tiền" };
        tableModelServiceUsage = new DefaultTableModel(columnNameServices, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        JTable serviceTable = new JTable(tableModelServiceUsage);

        serviceInfoPanel.add(new JScrollPane(serviceTable), BorderLayout.CENTER);

        roomAndServicePanel.add(roomInfoPanel);
        roomAndServicePanel.add(serviceInfoPanel);

        return roomAndServicePanel;
    }

    private JPanel createVoucherPanel() {
        JPanel voucherPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        voucherPanel.setBorder(BorderFactory.createTitledBorder("Voucher"));

        // Panel bên trái: Voucher áp dụng
        JPanel appliedVoucherPanel = new JPanel(new BorderLayout());
        appliedVoucherPanel.setBorder(BorderFactory.createTitledBorder("Voucher áp dụng"));
        String[] columnNameVoucher = { "Mã hóa đơn", "Mã voucher", "Tổng giảm" };
        tableModelVoucherApp = new DefaultTableModel(columnNameVoucher, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        appliedVoucherTable = new JTable(tableModelVoucherApp);

        appliedVoucherPanel.add(new JScrollPane(appliedVoucherTable), BorderLayout.CENTER);

        deleteVoucherButton = new JButton("Xóa voucher");
        customize.customizeRedButton(deleteVoucherButton);
        appliedVoucherPanel.add(deleteVoucherButton, BorderLayout.SOUTH);
        deleteVoucherButton.addActionListener(e -> {
            int selectedRow = appliedVoucherTable.getSelectedRow(); // Lấy hàng được chọn
            if (selectedRow != -1) {
                // Xóa hàng được chọn khỏi DefaultTableModel
                tableModelVoucherApp.removeRow(selectedRow);
                System.out.println(getTotalAmount());
                System.out.println(getTotalDicount());
                Double amountBefore = getTotalAmount() + getTotalDicount();
                inputTotalAmount.setText(String.valueOf(amountBefore));
                Double totalDiscountBefore = getTotalDicount() - getTotalDicount();// chưa tối ưu
                inputTotalDicount.setText(String.valueOf(totalDiscountBefore));
                setTotalAmount(amountBefore);
                setTotalDicount(totalDiscountBefore);
            } else {
                // Hiển thị thông báo nếu không có hàng nào được chọn
                JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xóa!", "Thông báo",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        // Panel bên phải: Voucher hiện có
        JPanel availableVoucherPanel = new JPanel(new BorderLayout());
        availableVoucherPanel.setBorder(BorderFactory.createTitledBorder("Voucher hiện có"));
        String[] columnNameVoucherAvailable = { "STT", "Loại voucher", "Gía trị", "Limit" };
        tableModelVoucherAvailable = new DefaultTableModel(columnNameVoucherAvailable, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        availableVoucherTable = new JTable(tableModelVoucherAvailable);

        availableVoucherPanel.add(new JScrollPane(availableVoucherTable), BorderLayout.CENTER);

        JPanel addVoucherPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addVoucherPanel.add(new JLabel("Số lượng:"));
        addVoucherPanel.add(new JTextField(5));
        addVoucherButton = new JButton("Thêm voucher");
        customize.customizeGreenButton(addVoucherButton);
        addVoucherPanel.add(addVoucherButton);

        availableVoucherPanel.add(addVoucherPanel, BorderLayout.SOUTH);

        voucherPanel.add(appliedVoucherPanel);
        voucherPanel.add(availableVoucherPanel);

        return voucherPanel;
    }

    private JPanel createPaymentPanel() {
        JPanel paymentPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Thanh toán"));
        Double totalPriceRoom = getTotalRoomPrice();
        paymentPanel.add(new JLabel("Tổng tiền phòng:"));
        // System.out.println(getTotalRoomPrice());
        paymentPanel.add(inputTotalPriceRoom);
        paymentPanel.add(new JLabel("Tổng tiền dịch vụ:"));
        paymentPanel.add(inputTotalPriceService);
        paymentPanel.add(new JLabel("Loại thanh toán:"));
        JComboBox<String> paymentMethodComboBox = new JComboBox<>(new String[] { "Tiền mặt", "Chuyển khoản" });
        paymentPanel.add(paymentMethodComboBox);
        paymentPanel.add(new JLabel("Tổng tiền giảm giá: "));
        paymentPanel.add(inputTotalDicount);
        paymentPanel.add(new JLabel("Tổng tiền trả khách:"));
        paymentPanel.add(inputTotalAmount);

        return paymentPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        customize.customizeBlueButton(checkOutButton);
        buttonPanel.add(checkOutButton);
        customize.customizeGreenButton(printInvoiceButton);
        buttonPanel.add(printInvoiceButton);
        customize.customizeRedButton(cancelButton);
        buttonPanel.add(cancelButton);

        return buttonPanel;
    }

    public void setInforCustomer(Guest guest) {
        labFullname.setText(guest.getFullName());
        labEmail.setText(guest.getEmail());
        labAddress.setText(guest.getAddress());
        labPhone.setText(guest.getPhone());
    }

    public void setPricePay(double totalPriceRoom, double totalPriceService, double totalDicount, double totalAmount) {
        inputTotalPriceRoom.setText(String.valueOf(totalPriceRoom) + " VND");
        inputTotalPriceService.setText(String.valueOf(totalPriceService) + " VND");
        inputTotalDicount.setText(String.valueOf(totalDicount) + " VND");
        inputTotalAmount.setText(String.valueOf(totalAmount) + " VND");

    }

    // sự kiện
    public void addRoom(Room room, Booking booking, DefaultTableModel tableModel) {
        tableModel.addRow(new Object[] {
                room.getRoomNumber(),
                booking.getCheckIn(),
                checkOut,
                room.getPrice(),
                timeStay,
                room.getRoomType()
        });
    }

    public void addRoom(Service service, BookingService bookingService, DefaultTableModel tableModel) {
        tableModel.addRow(new Object[] {
                service.getName(),
                service.getPrice(),
                bookingService.getQuantity(),
                bookingService.getTotalPrice()
        });
    }

    public void addRoom(Voucher voucher, DefaultTableModel tableModel) {
        tableModel.addRow(new Object[] {
                voucher.getId(),
                voucher.getDiscountType(),
                voucher.getDiscountValue(),
                voucher.getUsageLimit(),
                voucher.getUsedCount(),
        });
    }

    public void addRoom(int maHoaDon, int id, Double price, DefaultTableModel tableModel) {
        tableModel.addRow(new Object[] {
                maHoaDon,
                id,
                price

        });
    }

    public DefaultTableModel getTableModelVoucherApp() {
        return tableModelVoucherApp;
    }

    public void setTableModelVoucherApp(DefaultTableModel tableModelVoucherApp) {
        this.tableModelVoucherApp = tableModelVoucherApp;
    }

    public DefaultTableModel getTableModelRoom() {
        return tableModelRoom;
    }

    public void setTableModelRoom(DefaultTableModel tableModelRoom) {
        this.tableModelRoom = tableModelRoom;
    }

    public DefaultTableModel getTableModelVoucherAvailable() {
        return tableModelVoucherAvailable;
    }

    public void setTableModelVoucherAvailable(DefaultTableModel tableModelVoucherAvailable) {
        this.tableModelVoucherAvailable = tableModelVoucherAvailable;
    }

    public Voucher getVoucherSelected() {

        // int idBooking = getBookingId();
        // System.out.println("ID hóa đơn thêm dịch vụ " + idBooking);
        int selectedRow = availableVoucherTable.getSelectedRow();
        if (selectedRow != -1) {
            int idVoucher = (int) availableVoucherTable.getValueAt(selectedRow, 0);
            String type = (String) availableVoucherTable.getValueAt(selectedRow, 1);
            Double valueVoucher = (Double) availableVoucherTable.getValueAt(selectedRow, 2);
            int limit = (int) availableVoucherTable.getValueAt(selectedRow, 3);
            Voucher newVoucher = new Voucher(idVoucher, type, valueVoucher, limit);
            return newVoucher;
        } else {
            // JOptionPane.showMessageDialog(null, "Vui lòng chọn một dịch vụ để thêm!",
            // "Thông báo",
            // JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public void clearSelectedTable() {
        availableVoucherTable.clearSelection();
    }

    public void clearAppVoucher() {
        appliedVoucherTable.clearSelection();
    }

    // sự kiện thêm voucher
    public void actionAddVoucher(ActionListener e) {
        addVoucherButton.addActionListener(e);
    }

    public void actionSuccessBill(ActionListener e) {
        checkOutButton.addActionListener(e);
    }

    public void actionCancelBill(ActionListener e) {
        cancelButton.addActionListener(e);
    }
}