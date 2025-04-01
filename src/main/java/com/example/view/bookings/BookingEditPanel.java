package com.example.view.bookings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.BookingServiceController;
import com.example.controllers.ServiceController;
import com.example.models.Booking;
import com.example.models.BookingService;
import com.example.models.Guest;
import com.example.models.Room;
import com.example.models.Service;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

public class BookingEditPanel {
    private int bookingId;
    JButton buttonBack;
    JButton buttonDeleteService;
    JButton buttonUpdateInvoice;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    private JPanel bookingEditPanel = new JPanel();
    JLabel labelCustomerName;
    JTextField inputTotalPriceLeft;
    JLabel labelCustomerAddress;
    JLabel labelCustomerEmail;
    JLabel labelCustomerPhone;
    JLabel labelRoomName;
    JLabel labelRoomNumber;
    JLabel labelRoomPrice;
    JLabel labelDeposit;
    JLabel labelCheckoutDate;
    JTable tableAvailableServices;
    JTextField inputUsageCount;
    JButton buttonAddService;
    JTable tableServiceDetails;
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModelUsage;
    ServiceController serviceController = new ServiceController();
    BookingServiceController bookingServiceController = new BookingServiceController();
    BookingMain bookingMain = new BookingMain();

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

        labelCustomerName = new JLabel("Tên khách hàng: Nguyễn Văn A");
        labelCustomerAddress = new JLabel("Địa chỉ: 123 Đường ABC, TP.HCM");
        labelCustomerEmail = new JLabel("Email: nguyenvana@example.com");
        labelCustomerPhone = new JLabel("Số điện thoại: 0123456789");

        customerInfoPanel.add(labelCustomerName);
        customerInfoPanel.add(labelCustomerAddress);
        customerInfoPanel.add(labelCustomerEmail);
        customerInfoPanel.add(labelCustomerPhone);

        // Panel thông tin phòng
        JPanel roomInfoPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        roomInfoPanel.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));

        labelRoomName = new JLabel("Tên phòng: Phòng VIP");
        labelRoomNumber = new JLabel("Số phòng: 101");
        labelRoomPrice = new JLabel("Giá phòng: 1.000.000 VND");
        labelDeposit = new JLabel("Tiền đặt cọc: 500.000 VND");
        labelCheckoutDate = new JLabel("Ngày check-out: 01/04/2025");

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

        // Panel bên trái: Dịch vụ khách hàng sử dụng
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Dịch vụ đã sử dụng"));
        String[] columnNames = { "STT", "Tên dịch vụ", "Giá", "Số lượng" };
        tableModelUsage = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tableServiceDetails = new JTable(tableModelUsage);
        refreshTableServiceUsage();
        JScrollPane tableScrollPaneLeft = new JScrollPane(tableServiceDetails);
        leftPanel.add(tableScrollPaneLeft, BorderLayout.CENTER);

        // Panel chứa tổng tiền dịch vụ và nút xóa dịch vụ
        JPanel bottomPanelLeft = new JPanel(new BorderLayout());

        // Tổng tiền dịch vụ
        JPanel totalPricePanelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel totalPriceLabelLeft = new JLabel("Tổng tiền dịch vụ: ");
        inputTotalPriceLeft = new JTextField(10); // Ô nhập liệu cho tổng tiền

        // int idBooking = getBookingId();
        // System.out.println("ID hóa đơn sử dụng dịch vụ " + idBooking);
        // List<BookingService> items =
        // bookingServiceController.listServiceUseOfBooking(idBooking);
        // System.out.println("Kích thức của items " + items.size());
        // Double totalSerive = 0.0;
        // for (BookingService item : items) {
        // totalSerive += item.getTotalPrice();
        // }
        // String stringTotalPrice = String.valueOf(totalSerive) + " VND";
        // System.out.println(stringTotalPrice);
        // inputTotalPriceLeft.setText(stringTotalPrice);
        totalPricePanelLeft.add(totalPriceLabelLeft);
        totalPricePanelLeft.add(inputTotalPriceLeft);

        // Nút xóa dịch vụ
        buttonDeleteService = new JButton("Xóa dịch vụ");
        JPanel buttonPanelLeft = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanelLeft.add(buttonDeleteService);

        // Thêm tổng tiền và nút xóa vào bottomPanelLeft
        bottomPanelLeft.add(totalPricePanelLeft, BorderLayout.NORTH);
        bottomPanelLeft.add(buttonPanelLeft, BorderLayout.PAGE_END);

        leftPanel.add(bottomPanelLeft, BorderLayout.PAGE_END);

        // Panel bên phải: Danh sách dịch vụ có sẵn
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Danh sách dịch vụ"));

        // Cấu hình bảng
        String[] columnNamesService = { "STT", "Tên dịch vụ", "Giá" };
        tableModel = new DefaultTableModel(columnNamesService, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tableAvailableServices = new JTable(tableModel);
        refreshTable();
        JScrollPane tableScrollPaneRight = new JScrollPane(tableAvailableServices);
        rightPanel.add(tableScrollPaneRight, BorderLayout.CENTER);

        // Nút thêm dịch vụ và số lượng dịch vụ
        JPanel buttonPanelRight = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel usageLabel = new JLabel("Số lượng: ");
        inputUsageCount = new JTextField(5); // Ô nhập liệu cho số lượng dịch vụ
        buttonAddService = new JButton("Thêm dịch vụ");

        // Thêm các thành phần vào buttonPanelRight
        buttonPanelRight.add(usageLabel);
        buttonPanelRight.add(inputUsageCount);
        buttonPanelRight.add(buttonAddService);

        // Thêm buttonPanelRight vào bottomPanelRight
        rightPanel.add(buttonPanelRight, BorderLayout.PAGE_END);

        // Chia panel chính thành 2 phần: bên trái và bên phải
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400); // Đặt vị trí chia giữa 2 panel
        panel.add(splitPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createActionButtonsPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonUpdateInvoice = new JButton("Cập nhật hóa đơn");
        buttonBack = new JButton("Quay lại");
        panel.add(buttonUpdateInvoice);
        panel.add(buttonBack);

        return panel;
    }

    // sự kiện
    public void setData(Booking booking, Guest guest, Room room) {
        labelCustomerName.setText("Tên khách hàng: " + guest.getFullName());
        labelCustomerAddress.setText("Địa chỉ: " + guest.getAddress());
        labelCustomerEmail.setText("Email: " + guest.getEmail());
        labelCustomerPhone.setText("Số điện thoại: " + guest.getPhone());

        labelRoomName.setText((String.valueOf("Kiểu phòng: " + room.getRoomType())));
        labelRoomNumber.setText(String.valueOf("Số phòng: " + room.getRoomNumber()));
        ;
        labelRoomPrice.setText(String.valueOf("Giá phòng:" + room.getPrice()) + " VND");
        ;
        labelDeposit.setText(String.valueOf("Tiền đặt cọc: " + booking.getDepositAmount() + " VND"));
        ;
        labelCheckoutDate.setText(String.valueOf("Ngày check-in: " + booking.getCheckIn()));

    }

    // thêm dịch vụ cho các bảng
    public void refreshTable() {
        tableModel.setRowCount(0);
        List<Service> services = serviceController.getAllService();
        for (Service service : services) {

            addRoom(service, tableModel);
        }
        tableAvailableServices.revalidate();
        tableAvailableServices.repaint();
    }

    public void refreshTableServiceUsage() {
        tableModelUsage.setRowCount(0);
        int idBooking = getBookingId();
        // System.out.println("ID hóa đơn sử dụng dịch vụ " + idBooking);
        List<BookingService> items = bookingServiceController.listServiceUseOfBooking(idBooking);
        // System.out.println(items);
        for (BookingService item : items) {
            System.out.println(item.getServiceId());
            Service service = serviceController.getServiceById(item.getServiceId());
            addRoom(item, service.getName(), service.getPrice(), tableModelUsage);
        }
        tableServiceDetails.revalidate();
        tableServiceDetails.repaint();

    }

    private void addRoom(Service service, DefaultTableModel tableModel) {
        tableModel.addRow(new Object[] {
                service.getId(),
                service.getName(),
                service.getPrice()

        });
    }

    private void addRoom(BookingService service, String name, Double price, DefaultTableModel tableModel) {
        tableModel.addRow(new Object[] {
                service.getId(),
                name,
                price,
                service.getQuantity()

        });
    }

    public BookingService getServiceSelected() {

        int idBooking = getBookingId();
        // System.out.println("ID hóa đơn thêm dịch vụ " + idBooking);
        int selectedRow = tableAvailableServices.getSelectedRow();
        if (selectedRow != -1) {
            int idSerivce = (int) tableAvailableServices.getValueAt(selectedRow, 0);
            // System.out.println("Id dich vu chọn: " + idSerivce);
            int quantity = getUsageService();
            BookingService bookingService = new BookingService(idBooking, idSerivce, quantity);
            return bookingService;
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dịch vụ để thêm!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    public int getUsageService() {
        return Integer.parseInt(inputUsageCount.getText());
    }

    public void setTotalPrice(Double price) {
        inputTotalPriceLeft.setText(String.valueOf(price + " VND"));
    }

    public void actionAddService(ActionListener e) {
        buttonAddService.addActionListener(e);
    }

    public void clearData() {
        inputUsageCount.setText("");
    }

    public void clearTableSelection() {
        tableServiceDetails.clearSelection(); // Xóa lựa chọn trong bảng
        tableAvailableServices.clearSelection(); // Xóa lựa chọn trong bảng
    }

    // sự kiện
    public void actionBack(ActionListener e) {
        buttonBack.addActionListener(e);
    }

    public void deleteService(ActionListener e) {
        buttonDeleteService.addActionListener(e);
    }

    public int getSeletedDelete() {
        int selectedRow = tableServiceDetails.getSelectedRow();
        if (selectedRow != -1) {
            int idSerivce = (int) tableServiceDetails.getValueAt(selectedRow, 0);
            return idSerivce;
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một dịch vụ để xóa!", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return -1;
        }
    }

    // sư kiện
    public void updateBill(ActionListener e) {
        buttonUpdateInvoice.addActionListener(e);
    }
}