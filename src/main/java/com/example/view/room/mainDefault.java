/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.example.view.room;

import java.awt.CardLayout;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import org.mindrot.jbcrypt.BCrypt;

import com.example.controllers.BookingController;
import com.example.controllers.BookingServiceController;
import com.example.controllers.BookingVoucherController;
import com.example.controllers.EmployeeController;
import com.example.controllers.GuestController;
import com.example.controllers.PaymentController;
import com.example.controllers.RoomsController;
import com.example.controllers.ServiceController;
import com.example.controllers.VoucherController;
import com.example.models.Booking;
import com.example.models.BookingService;
import com.example.models.BookingVoucher;
import com.example.models.Employee;
import com.example.models.Guest;
import com.example.models.Room;
import com.example.models.Service;
import com.example.models.Voucher;
import com.example.view.bookings.BookingEditPanel;
import com.example.view.bookings.BookingMain;
import com.example.view.bookings.BookingCheckOut;
import com.example.view.bookings.BookingCreatePanel;
import com.example.view.dashboard.HomePanel;
import com.example.view.default_main.menuPanel;
import com.example.view.employee.CreateEmployeePanel;
import com.example.view.employee.EditEmployeePanel;
import com.example.view.employee.EmployeeManagement;
import com.example.view.employee.TimeKeeping;
import com.example.view.revenue.RevenuePanel;
import com.example.view.service.AddService;
import com.example.view.service.EditService;
import com.example.view.service.ServicePanel;
import com.example.view.voucher.CreareVoucherPanel;
import com.example.view.voucher.EditVoucherPanel;
import com.example.view.voucher.VoucherMainPanel;

/**
 *
 * @author Kiet
 */
public class mainDefault extends javax.swing.JFrame {

        /**
         * Creates new form test
         * // btnRoomManage.addActionListener(e -> cardLayout.show(contentPanel,
         * "roomPanel"));
         * // btnRoomPlace.addActionListener(e -> cardLayout.show(contentPanel,
         * "homePanel"));
         * // btnManageEmployee.addActionListener(e -> cardLayout.show(contentPanel,
         * "employeePanel"));
         * // cardLayout.show(contentPanel, "roomPanel");
         * cardLayout = (CardLayout) contentPanel.getLayout();
         * 
         * contentPanel.add(roomPanel, "roomPanel");
         * contentPanel.add(homePanel, "homePanel");
         * contentPanel.add(employeePanel, "employeePanel");
         */
        private CardLayout cardLayout;
        menuPanel menuPanel = new menuPanel();
        EmployeeManagement employeeManagement = new EmployeeManagement();
        CreateEmployeePanel createEmployeePanel = new CreateEmployeePanel();
        EditEmployeePanel editEmployeePanel = new EditEmployeePanel();
        TimeKeeping timeKeeping = new TimeKeeping();
        RoomMain roomMain = new RoomMain();
        AddRoomPanel createRoomPanel = new AddRoomPanel();
        HomePanel dashBoardPanel = new HomePanel();
        ServicePanel servicePanelView = new ServicePanel();
        AddService serviceAddView = new AddService();
        EditService serviceEditView = new EditService();
        VoucherMainPanel voucherMainPanel = new VoucherMainPanel();
        CreareVoucherPanel creareVoucherPanel = new CreareVoucherPanel();
        EditVoucherPanel editVoucherFun = new EditVoucherPanel();
        // bookings
        BookingMain bookingMain = new BookingMain();
        BookingCreatePanel BookingsPanel = new BookingCreatePanel();
        BookingEditPanel bookingUpdatePanel = new BookingEditPanel();
        BookingCheckOut bookingCheckOut = new BookingCheckOut();
        RevenuePanel reportRevenuePanel = new RevenuePanel();
        // controller
        RoomsController roomsController = new RoomsController();
        ServiceController serviceController = new ServiceController();
        EmployeeController employeeController = new EmployeeController();
        VoucherController voucherController = new VoucherController();
        BookingController bookingController = new BookingController();
        GuestController guestController = new GuestController();
        BookingServiceController bookingServiceController = new BookingServiceController();
        BookingVoucherController bookingVoucherController = new BookingVoucherController();
        PaymentController paymentController = new PaymentController();

        public mainDefault() {
                initComponents();
        }

        // cardLayout = (CardLayout) contentPanel.getLayout();

        private void initComponents() {

                panelMenu = new javax.swing.JPanel();
                panelInfoEmployee = new javax.swing.JPanel();
                labWelcome = new javax.swing.JLabel();
                labImageEmployee = new javax.swing.JLabel();
                labName = new javax.swing.JLabel();
                panelListButton = new javax.swing.JPanel();
                JPanel voucherPanel = new JPanel();
                JPanel addVoucherPanel = new JPanel();
                JPanel editVoucherPanel = new JPanel();
                JPanel bookingPanel = new JPanel();
                JPanel bookingEditPanel = new JPanel();
                JPanel bookingMainPanel = new JPanel();
                contentPanel = new javax.swing.JPanel();
                homePanel = new javax.swing.JPanel();
                topPanelHome = new javax.swing.JPanel();
                titleHome = new javax.swing.JLabel();

                employeePanel = new javax.swing.JPanel();
                topRoomPanel1 = new javax.swing.JPanel();

                tableEmployee = new javax.swing.JTable();
                paginationPanel1 = new javax.swing.JPanel();
                employeeCreatePanel = new javax.swing.JPanel();
                panelTopCreateEmployee = new javax.swing.JPanel();
                labTitleEmployeeCreate = new javax.swing.JLabel();

                labInputCreateEmployee = new javax.swing.JLabel();

                textAreaCreateUser = new javax.swing.JTextArea();

                employeeEditPanel = new javax.swing.JPanel();
                panelTopEditEmployee = new javax.swing.JPanel();
                labTitleEmployeeCreate1 = new javax.swing.JLabel();

                labInputEditEmployee = new javax.swing.JLabel();

                labEmployeeUserEdit = new javax.swing.JLabel();

                labILevelUserEdit = new javax.swing.JLabel();

                labStatusUserEdit = new javax.swing.JLabel();

                textAreaCreateUser1 = new javax.swing.JTextArea();

                timekeepingEmployeePanel = new javax.swing.JPanel();
                panelTopEditEmployee1 = new javax.swing.JPanel();
                labTitleEmployeeCreate2 = new javax.swing.JLabel();

                timekeepingCenterPanel = new javax.swing.JPanel();

                roomPanel = new javax.swing.JPanel();
                topRoomPanel = new javax.swing.JPanel();
                labTitleRoom = new javax.swing.JLabel();

                tablePanel = new javax.swing.JPanel();

                tableRoom = new javax.swing.JTable();
                paginationPanel = new javax.swing.JPanel();
                addRoomPanel = new javax.swing.JPanel();
                topAddRoomPanel = new javax.swing.JPanel();
                labTitleAddRoom = new javax.swing.JLabel();

                labInputRoom = new javax.swing.JLabel();

                labPriceAddRoom = new javax.swing.JLabel();

                labInputTypeRoom = new javax.swing.JLabel();

                labStatusAddRoom = new javax.swing.JLabel();

                textAreaAddRoom = new javax.swing.JTextArea();

                editRoomPanel = new javax.swing.JPanel();
                topEditRoomPanel = new javax.swing.JPanel();
                centerEditRoomPanel = new javax.swing.JPanel();
                labInputRoomEdit = new javax.swing.JLabel();
                inputNumberRoomEdit = new javax.swing.JTextField();
                labPriceEditRoom = new javax.swing.JLabel();
                JcomeTypeRoomEdit = new javax.swing.JComboBox<>();
                labInputTypeRoomEdit = new javax.swing.JLabel();
                inputPriceEditRoom = new javax.swing.JTextField();
                labCaptityEditRoom = new javax.swing.JLabel();
                inputCaptityEditRoom = new javax.swing.JSpinner();
                labStatusEditRoom = new javax.swing.JLabel();
                JcomeStatusEditRoom = new javax.swing.JComboBox<>();
                labDescriptionEditRoom = new javax.swing.JLabel();
                jScrollPane4 = new javax.swing.JScrollPane();
                textAreaEditRoom = new javax.swing.JTextArea();
                btnEditRoomEdit = new javax.swing.JButton();
                btnBackEditRoom = new javax.swing.JButton();
                servicePanel = new javax.swing.JPanel();
                topServicePanel = new javax.swing.JPanel();
                labTitleService = new javax.swing.JLabel();

                tableRoom1 = new javax.swing.JTable();
                paginationPanel2 = new javax.swing.JPanel();
                createServicePanel = new javax.swing.JPanel();
                topCreateServicePanel = new javax.swing.JPanel();
                labTitleAddRoom1 = new javax.swing.JLabel();

                labNameSericeAdd = new javax.swing.JLabel();

                labPriceServiceAdd = new javax.swing.JLabel();

                labStatusCreateService = new javax.swing.JLabel();

                textAreaCreateService = new javax.swing.JTextArea();

                editServicePanel = new javax.swing.JPanel();
                topEditServicePanel = new javax.swing.JPanel();
                labTitleEditService = new javax.swing.JLabel();

                labInputSericeEdit = new javax.swing.JLabel();

                labPriceEditService = new javax.swing.JLabel();

                labStatusEditSerivce = new javax.swing.JLabel();

                textAreaEditService = new javax.swing.JTextArea();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setPreferredSize(new java.awt.Dimension(1500, 700));

                panelMenu = menuPanel.renderMenuPanel();
                getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

                contentPanel.setBackground(new java.awt.Color(255, 255, 255));
                contentPanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                contentPanel.setPreferredSize(new java.awt.Dimension(1100, 800));
                contentPanel.setLayout(new java.awt.CardLayout(20, 30));

                homePanel = dashBoardPanel.dashboardPanel();

                contentPanel.add(homePanel, "homePanel");

                employeePanel = employeeManagement.renderEmployeePanel();

                contentPanel.add(employeePanel, "employeePanel");

                employeeCreatePanel = createEmployeePanel.panelCreateEmployee();

                contentPanel.add(employeeCreatePanel, "employeeCreatePanel");

                employeeEditPanel = editEmployeePanel.editEmployee();
                contentPanel.add(employeeEditPanel, "employeeEditPanel");

                timekeepingEmployeePanel = timeKeeping.timeKeeping();
                contentPanel.add(timekeepingEmployeePanel, "timekeepingEmployeePanel");

                roomPanel = roomMain.roomMain();
                contentPanel.add(roomPanel, "roomPanel");
                addRoomPanel = createRoomPanel.addRoom();
                contentPanel.add(addRoomPanel, "addRoomPanel");

                // voucher
                voucherPanel = voucherMainPanel.voucherPanel();
                contentPanel.add(voucherPanel, "voucherPanel");

                addVoucherPanel = creareVoucherPanel.addVoucher();
                contentPanel.add(addVoucherPanel, "addVoucherPanel");
                editVoucherPanel = editVoucherFun.editVoucher();
                contentPanel.add(editVoucherPanel, "editVoucherPanel");
                // het vouhcer
                // hóa đơn
                bookingMainPanel = bookingMain.renderPanel();
                contentPanel.add(bookingMainPanel, "bookingMainPanel");
                bookingPanel = BookingsPanel.renderPanel();
                contentPanel.add(bookingPanel, "bookingPanel");
                bookingEditPanel = bookingUpdatePanel.renderPanel();
                contentPanel.add(bookingEditPanel, "bookingEditPanel");
                contentPanel.add(bookingCheckOut.renderPanel(), "invoicePanel");
                contentPanel.add(reportRevenuePanel.renderPanel(), "revenuePanel");
                // hết hóa đơn
                editRoomPanel.setLayout(new java.awt.BorderLayout());

                javax.swing.GroupLayout topEditRoomPanelLayout = new javax.swing.GroupLayout(topEditRoomPanel);
                topEditRoomPanel.setLayout(topEditRoomPanelLayout);
                topEditRoomPanelLayout.setHorizontalGroup(
                                topEditRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 1536, Short.MAX_VALUE));
                topEditRoomPanelLayout.setVerticalGroup(
                                topEditRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 90, Short.MAX_VALUE));

                editRoomPanel.add(topEditRoomPanel, java.awt.BorderLayout.PAGE_START);

                labInputRoomEdit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labInputRoomEdit.setForeground(new java.awt.Color(30, 60, 90));
                labInputRoomEdit.setText("Nhập số phòng: ");

                inputNumberRoomEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                inputNumberRoomEdit.setPreferredSize(new java.awt.Dimension(120, 25));

                labPriceEditRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labPriceEditRoom.setForeground(new java.awt.Color(30, 60, 90));
                labPriceEditRoom.setText("Nhập giá phòng: ");

                JcomeTypeRoomEdit.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                JcomeTypeRoomEdit.setPreferredSize(new java.awt.Dimension(100, 25));
                // JcomeTypeRoomEdit.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // JcomeTypeRoomEditActionPerformed(evt);
                // }
                // });

                labInputTypeRoomEdit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labInputTypeRoomEdit.setForeground(new java.awt.Color(30, 60, 90));
                labInputTypeRoomEdit.setText("Nhập kiểu phòng: ");

                inputPriceEditRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                inputPriceEditRoom.setPreferredSize(new java.awt.Dimension(100, 25));

                labCaptityEditRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labCaptityEditRoom.setForeground(new java.awt.Color(30, 60, 90));
                labCaptityEditRoom.setText("Nhập số người: ");

                labStatusEditRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labStatusEditRoom.setForeground(new java.awt.Color(30, 60, 90));
                labStatusEditRoom.setText("Chọn trạng thái: ");

                JcomeStatusEditRoom.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
                JcomeStatusEditRoom.setPreferredSize(new java.awt.Dimension(100, 25));
                // JcomeStatusEditRoom.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // JcomeStatusEditRoomActionPerformed(evt);
                // }
                // });

                labDescriptionEditRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labDescriptionEditRoom.setForeground(new java.awt.Color(30, 60, 90));
                labDescriptionEditRoom.setText("Nhập mô tả:");

                textAreaEditRoom.setColumns(20);
                textAreaEditRoom.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
                textAreaEditRoom.setRows(5);
                jScrollPane4.setViewportView(textAreaEditRoom);

                btnEditRoomEdit.setBackground(new java.awt.Color(30, 60, 90));
                btnEditRoomEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnEditRoomEdit.setForeground(new java.awt.Color(255, 255, 255));
                btnEditRoomEdit.setText("Chỉnh sửa");
                btnEditRoomEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnEditRoomEdit.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnEditRoomEditActionPerformed(evt);
                // }
                // });

                btnBackEditRoom.setBackground(new java.awt.Color(255, 51, 51));
                btnBackEditRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnBackEditRoom.setForeground(new java.awt.Color(255, 255, 255));
                btnBackEditRoom.setText("Quay lại");
                btnBackEditRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnBackEditRoom.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnBackEditRoomActionPerformed(evt);
                // }
                // });

                javax.swing.GroupLayout centerEditRoomPanelLayout = new javax.swing.GroupLayout(centerEditRoomPanel);
                centerEditRoomPanel.setLayout(centerEditRoomPanelLayout);
                centerEditRoomPanelLayout.setHorizontalGroup(
                                centerEditRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(centerEditRoomPanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addGroup(centerEditRoomPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(centerEditRoomPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btnBackEditRoom)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(btnEditRoomEdit))
                                                                                .addGroup(centerEditRoomPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(labDescriptionEditRoom)
                                                                                                .addGroup(centerEditRoomPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(centerEditRoomPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                centerEditRoomPanelLayout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(labInputRoomEdit)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(inputNumberRoomEdit,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                122,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addGap(69, 69, 69))
                                                                                                                                .addGroup(centerEditRoomPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labStatusEditRoom)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(JcomeStatusEditRoom,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                139,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(49, 49, 49)))
                                                                                                                .addGroup(centerEditRoomPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(centerEditRoomPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labCaptityEditRoom)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(inputCaptityEditRoom,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGroup(centerEditRoomPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labInputTypeRoomEdit)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(JcomeTypeRoomEdit,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                139,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGap(141, 141,
                                                                                                                                141)
                                                                                                                .addComponent(labPriceEditRoom)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(inputPriceEditRoom,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                134,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addComponent(jScrollPane4)))
                                                                .addContainerGap(495, Short.MAX_VALUE)));
                centerEditRoomPanelLayout.setVerticalGroup(
                                centerEditRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(centerEditRoomPanelLayout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(centerEditRoomPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labInputRoomEdit)
                                                                                .addComponent(inputNumberRoomEdit,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labPriceEditRoom)
                                                                                .addComponent(JcomeTypeRoomEdit,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labInputTypeRoomEdit)
                                                                                .addComponent(inputPriceEditRoom,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(centerEditRoomPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labStatusEditRoom)
                                                                                .addComponent(JcomeStatusEditRoom,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labCaptityEditRoom)
                                                                                .addComponent(inputCaptityEditRoom,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(labDescriptionEditRoom)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                237,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(centerEditRoomPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnEditRoomEdit)
                                                                                .addComponent(btnBackEditRoom))
                                                                .addContainerGap(125, Short.MAX_VALUE)));

                editRoomPanel.add(centerEditRoomPanel, java.awt.BorderLayout.CENTER);

                contentPanel.add(editRoomPanel, "editRoomPanel");

                servicePanel = servicePanelView.servicePanel();

                contentPanel.add(servicePanel, "servicePanel");

                // thêm giao diện thêm dịch vụ
                createServicePanel = serviceAddView.createSerivce();

                contentPanel.add(createServicePanel, "createServicePanel");

                editServicePanel = serviceEditView.editService();

                contentPanel.add(editServicePanel, "editServicePanel");
                getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);
                cardLayout = (CardLayout) contentPanel.getLayout();

                cardLayout.show(contentPanel, "bookingMainPanel");
                pack();
                setLocationRelativeTo(null);

                // Gắn sự kiện cho các nút trong menuPanel
                // bắt sự kiện thay đổi trang khi sang của giao diện quản lý phòng

                menuPanel.addRoomManageListener(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "roomPanel"); // Hiển thị giao diện "Quản lý phòng"
                });
                roomMain.actionAddRoom(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "addRoomPanel");
                });
                roomMain.actionEditRoom(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "");
                });
                createRoomPanel.actionBackRoom(e -> {
                        cardLayout.show(contentPanel, "roomPanel");
                });
                // tạo phòng
                createRoomPanel.actionAddRoom(e -> {
                        int numberRoom = Integer.parseInt(createRoomPanel.getRoomNumber());
                        String typeRoom = createRoomPanel.getTypeRoom();
                        System.out.println(typeRoom);
                        double priceRoom = Double.parseDouble(createRoomPanel.getRoomPrice());
                        int capacity = createRoomPanel.getRoomCapacity();
                        String status = createRoomPanel.getRoomStatus();
                        String desc = createRoomPanel.getDescription();
                        Room roomNew = new Room(numberRoom, typeRoom, status, priceRoom, desc, capacity);
                        Boolean isCreated = roomsController.createRoom(roomNew);
                        if (isCreated) {
                                System.out.println("Tạo phòng thành công và show về giao diện quản lý phòng");
                                cardLayout.show(contentPanel, "roomPanel");
                                createRoomPanel.clearFields();
                                roomMain.refreshTable();

                        } else {
                                JOptionPane.showMessageDialog(null, "Tạo phòng không thành công!", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                        }

                });
                // bắt sự kiện xóa phòng
                roomMain.actionDeleteRoom(e -> {
                        Room selectedRoom = roomMain.getSelectedRoom(); // Lấy thông tin phòng được chọn
                        if (selectedRoom != null) {
                                int confirm = JOptionPane.showConfirmDialog(null,
                                                "Bạn có chắc chắn muốn xóa phòng này?", "Xác nhận",
                                                JOptionPane.YES_NO_OPTION);
                                if (confirm == JOptionPane.YES_OPTION) {
                                        boolean isDeleted = roomsController.deleteRoom(selectedRoom.getId()); // Gọi
                                                                                                              // phương
                                                                                                              // thức
                                                                                                              // xóa
                                                                                                              // phòng
                                        if (isDeleted) {
                                                JOptionPane.showMessageDialog(null, "Xóa phòng thành công!");
                                                roomMain.refreshTable(); // Làm mới bảng sau khi xóa
                                        } else {
                                                JOptionPane.showMessageDialog(null, "Xóa phòng thất bại!");
                                        }
                                }
                        }
                });
                // hết bắt sự kiện xóa phòng
                // bắt sự kiện
                // hết bắt sự kiện thay đổi trang khi sang của giao diện quản lý phòng
                // booking
                menuPanel.addRoomPlaceListener(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "bookingMainPanel"); // Hiển thị giao diện "Quản lý đặt phòng"
                });
                bookingMain.actionCreateBill(e -> {
                        LocalDateTime now = LocalDateTime.now().withNano(0);
                        String time = String.valueOf(now);

                        BookingsPanel.setCheckIn(time);

                        cardLayout.show(contentPanel, "bookingPanel");
                });
                BookingsPanel.actionSaveBill(e -> {
                        int idCustomer = BookingsPanel.getIdGuest();
                        int idRoom = BookingsPanel.getIdRoomPlaced();
                        String checkInString = BookingsPanel.getCheckIn();
                        checkInString = checkInString.replace("T", " ");
                        Timestamp timestamp = Timestamp.valueOf(checkInString);
                        Double depositAmount;
                        System.out.println(BookingsPanel.getDeposit());
                        if (BookingsPanel.getDeposit() == null || BookingsPanel.getDeposit().isEmpty()) {
                                depositAmount = 0.0;
                        } else {

                                depositAmount = Double.parseDouble(BookingsPanel.getDeposit());
                        }
                        Booking booking = new Booking(idRoom, idCustomer, timestamp,
                                        depositAmount);
                        Boolean createBooking = bookingController.createBookings(booking);
                        if (createBooking) {
                                Boolean updateStatusRoom = roomsController
                                                .updateRoomStatus(idRoom, "occupied");
                                BookingsPanel.clearData();
                                ;
                                BookingsPanel.refreshTable();
                                bookingMain.refreshTable();
                                cardLayout.show(contentPanel, "bookingMainPanel");
                                JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!");
                        } else {
                                cardLayout.show(contentPanel, "bookingPanel");
                                JOptionPane.showMessageDialog(null, "Tạo hóa đơn thất bại thất bại!");
                        }

                });
                // sang sự kiện cập nhập hóa đơn
                bookingMain.actionUpdateBill(e -> {
                        Booking bookingSeleted = bookingMain.getSelectedBooking();
                        if (bookingSeleted == null) {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 hóa đơn!");
                                return;
                        } else {
                                Guest guest = guestController.getGuestById(bookingSeleted.getGuestId());
                                Room room = roomsController.roomDetail(bookingSeleted.getRoomId());
                                bookingUpdatePanel.setData(bookingSeleted, guest, room);
                                bookingUpdatePanel.setBookingId(bookingSeleted.getId());
                                int idBooking = bookingUpdatePanel.getBookingId();
                                List<BookingService> bookings = bookingServiceController
                                                .listServiceUseOfBooking(idBooking);

                                Double totalPrice = 0.0;
                                for (BookingService item : bookings) {
                                        totalPrice += item.getTotalPrice();
                                }

                                bookingUpdatePanel.setTotalPrice(totalPrice);
                                bookingUpdatePanel.refreshTableServiceUsage();
                                cardLayout.show(contentPanel, "bookingEditPanel");
                        }
                });
                // hủy
                BookingsPanel.actionCancel(e -> {
                        BookingsPanel.clearData();
                        cardLayout.show(contentPanel, "bookingMainPanel");
                });
                bookingUpdatePanel.actionBack(e -> {
                        cardLayout.show(contentPanel, "bookingMainPanel");
                        bookingUpdatePanel.clearData();
                        bookingUpdatePanel.clearTableSelection();
                });
                // Xóa dịch vụ
                bookingUpdatePanel.deleteService(e -> {
                        int idDelete = bookingUpdatePanel.getSeletedDelete();
                        System.out.println("iD dịch vụ phòng muốn xóa: " + idDelete);
                        if (idDelete == -1) {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dịch vụ để xóa!", "Thông báo",
                                                JOptionPane.WARNING_MESSAGE);
                                return;

                        } else {
                                Booking bookingSeleted = bookingMain.getSelectedBooking();
                                bookingUpdatePanel.setBookingId(bookingSeleted.getId());

                                Boolean isDelete = bookingServiceController.deleteServiceOfBooking(idDelete,
                                                bookingSeleted.getId());
                                if (isDelete) {
                                        JOptionPane.showMessageDialog(null, "Xóa dịch vụ thành công!", "Thông báo",
                                                        JOptionPane.WARNING_MESSAGE);

                                        List<BookingService> bookings = bookingServiceController
                                                        .listServiceUseOfBooking(bookingSeleted.getId());

                                        Double totalPrice = 0.0;
                                        for (BookingService item : bookings) {
                                                totalPrice += item.getTotalPrice();
                                        }

                                        bookingUpdatePanel.setTotalPrice(totalPrice);
                                        bookingUpdatePanel.refreshTableServiceUsage();
                                } else {
                                        JOptionPane.showMessageDialog(null, "Xóa dịch vụ lỗi!", "Thông báo",
                                                        JOptionPane.WARNING_MESSAGE);
                                }
                        }
                });
                // thêm dịch vụ trong quá trình sử dụng phòng
                bookingUpdatePanel.actionAddService(e -> {
                        Booking bookingSeleted = bookingMain.getSelectedBooking();
                        if (bookingSeleted == null) {
                                JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn được chọn!");
                                return;
                        }

                        BookingService serviceUsage = bookingUpdatePanel.getServiceSelected();
                        if (serviceUsage == null) {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dịch vụ!");
                                return;
                        }

                        BookingService isCheckedService = bookingServiceController.checkSerivced(
                                        serviceUsage.getServiceId(),
                                        bookingSeleted.getId());

                        if (isCheckedService == null) {
                                System.out.println("Dịch vụ chưa tồn tại trong hóa đơn, thêm mới.");
                                Boolean isCreated = bookingServiceController.useService(serviceUsage);
                                if (isCreated) {
                                        bookingUpdatePanel.setBookingId(bookingSeleted.getId());
                                        bookingUpdatePanel.refreshTable();
                                        bookingUpdatePanel.refreshTableServiceUsage();

                                        int idBooking = bookingUpdatePanel.getBookingId();
                                        List<BookingService> bookings = bookingServiceController
                                                        .listServiceUseOfBooking(idBooking);
                                        if (bookings == null || bookings.isEmpty()) {
                                                System.out.println("Không có dịch vụ nào trong hóa đơn.");
                                                return;
                                        }

                                        Double totalPrice = 0.0;
                                        for (BookingService item : bookings) {
                                                totalPrice += item.getTotalPrice();
                                        }
                                        System.out.println("Tổng tiền: " + totalPrice);
                                        bookingUpdatePanel.setTotalPrice(totalPrice);

                                        JOptionPane.showMessageDialog(null, "Thêm dịch vụ thành công!");
                                        bookingUpdatePanel.clearData();
                                } else {
                                        JOptionPane.showMessageDialog(null, "Thêm dịch vụ thất bại!");
                                }
                        } else {
                                System.out.println("Dịch vụ đã tồn tại, cập nhật số lượng.");
                                int serviceCurrent = isCheckedService.getQuantity();
                                int quantityNew = serviceCurrent + bookingUpdatePanel.getUsageService();
                                System.out.println("Số lượng mới: " + quantityNew);

                                Boolean updateQuantity = bookingServiceController.updateQuantity(
                                                quantityNew,
                                                serviceUsage.getServiceId(),
                                                bookingSeleted.getId());

                                if (updateQuantity) {
                                        JOptionPane.showMessageDialog(null, "Cập nhật số lượng thành công!");
                                        int idBooking = bookingUpdatePanel.getBookingId();
                                        List<BookingService> bookings = bookingServiceController
                                                        .listServiceUseOfBooking(idBooking);
                                        if (bookings == null || bookings.isEmpty()) {
                                                System.out.println("Không có dịch vụ nào trong hóa đơn.");
                                                return;
                                        }

                                        Double totalPrice = 0.0;
                                        for (BookingService item : bookings) {
                                                totalPrice += item.getTotalPrice();
                                        }
                                        // System.out.println("Tổng tiền: " + totalPrice);
                                        bookingUpdatePanel.setTotalPrice(totalPrice);
                                        bookingUpdatePanel.refreshTableServiceUsage();
                                        bookingUpdatePanel.clearData();
                                } else {
                                        JOptionPane.showMessageDialog(null, "Cập nhật số lượng thất bại!");
                                }
                        }
                });

                bookingUpdatePanel.updateBill(e -> {
                        cardLayout.show(contentPanel, "bookingMainPanel");
                });
                // sự kiện check-out
                bookingMain.actionCheckOut(e -> {
                        DefaultTableModel tableModelVoucherApp = bookingCheckOut.getTableModelVoucherApp();
                        tableModelVoucherApp.setRowCount(0);

                        Booking bookingSeleted = bookingMain.getSelectedBooking();
                        bookingCheckOut.setIdBooking(bookingSeleted.getId());
                        bookingCheckOut.setIdCustomer(bookingSeleted.getGuestId());
                        bookingCheckOut.setIdRoom(bookingSeleted.getRoomId());
                        int idBooking = bookingCheckOut.getIdBooking();
                        int idCustomer = bookingCheckOut.getIdCustomer();
                        int idRoom = bookingCheckOut.getIdRoom();
                        // System.out.println(idRoom);
                        // truy vấn lây thông tin trả ra giao diện
                        Guest guest = guestController.getGuestById(idCustomer);
                        System.out.println(guest);
                        Room room = roomsController.foundRoomUse(idRoom);

                        // System.out.println(room);
                        bookingCheckOut.setInforCustomer(guest);
                        // tính toán tổng số tiền phải trả
                        double totalPriceService = 0; // tổng tiền sử dụng dịch vụ phải trả
                        List<BookingService> bookingServices = bookingServiceController
                                        .listServiceUseOfBooking(bookingSeleted.getId());
                        if (bookingServices.size() > 0) {
                                for (BookingService item : bookingServices) {
                                        totalPriceService += item.getTotalPrice();
                                }
                        }
                        LocalDateTime now = LocalDateTime.now().withNano(0);
                        ;
                        Timestamp timeCheckOut = Timestamp.valueOf(now);

                        Timestamp checkIn = bookingSeleted.getCheckIn();
                        long milliseconds = timeCheckOut.getTime() - checkIn.getTime();
                        double days = Math.ceil(milliseconds / (1000.0 * 60 * 60 * 24));
                        double totalRoomPrice = room.getPrice() * days;
                        double totalAmount = totalRoomPrice + totalPriceService;
                        // // Hiển thị thông tin thanh toán
                        Double totalPriceDicount = 0.0;
                        bookingCheckOut.setTotalDicount(totalPriceDicount);
                        System.out.println("Thông tin thanh toán:");
                        System.out.println("Số ngày thuê: " + (int) days);
                        System.out.println("Tiền thuê phòng: " + totalRoomPrice);
                        System.out.println("Tiền dịch vụ: " + totalPriceService);
                        System.out.println("Tổng tiền phải trả: " + totalAmount);
                        bookingCheckOut.setCheckOut(String.valueOf(timeCheckOut));
                        bookingCheckOut.setTimeStay(String.valueOf(days));
                        bookingCheckOut.setTotalRoomPrice(totalRoomPrice);
                        bookingCheckOut.setTotalPriceService(totalPriceService);
                        bookingCheckOut.setTotalAmount(totalAmount);
                        bookingCheckOut.setBookingUsage(bookingSeleted);
                        bookingCheckOut.setRoomUsage(room);
                        bookingCheckOut.setPricePay(totalRoomPrice, totalPriceService, totalPriceDicount, totalAmount);
                        DefaultTableModel tableModelRoom = bookingCheckOut.getTableModelRoom();
                        tableModelRoom.setRowCount(0);
                        bookingCheckOut.addRoom(room, bookingSeleted, tableModelRoom);
                        // trả ra dịch vụ khách hàng sử dụng
                        List<BookingService> serviceUsageOfGuest = bookingServiceController
                                        .listServiceUseOfBooking(idBooking);
                        DefaultTableModel tableModelServiceUsage = bookingCheckOut.getTableModelServiceUsage();
                        tableModelServiceUsage.setRowCount(0);
                        for (BookingService item : serviceUsageOfGuest) {
                                Service serviceOfBill = serviceController.getServiceById(item.getServiceId());
                                bookingCheckOut.addRoom(serviceOfBill, item, tableModelServiceUsage);
                        }
                        // trả ra danh sách voucher có sẵn
                        DefaultTableModel tableModelVoucherAvailable = bookingCheckOut.getTableModelVoucherAvailable();
                        tableModelVoucherAvailable.setRowCount(0);
                        List<Voucher> vouchers = voucherController.listVouchersStatus("active");
                        for (Voucher voucher : vouchers) {
                                bookingCheckOut.addRoom(voucher, tableModelVoucherAvailable);
                        }
                        cardLayout.show(contentPanel, "invoicePanel");
                });
                // thêm voucher cho hóa đơn
                bookingCheckOut.actionAddVoucher(e -> {
                        int bookingId = bookingCheckOut.getIdBooking();
                        Voucher voucherSelected = bookingCheckOut.getVoucherSelected();
                        if (voucherSelected == null) {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dịch vụ để thêm!", "Thông báo",
                                                JOptionPane.WARNING_MESSAGE);
                                return;
                        }
                        Voucher voucherApp = voucherController.detailVoucher(voucherSelected.getId(), "active");
                        System.out.println(voucherApp);
                        double minOrderValue = voucherApp.getMinOrderValue();
                        double maxDiscountValue = voucherApp.getMaxDiscountValue();
                        System.out.println(bookingId);
                        double totalAmount = bookingCheckOut.getTotalAmount();
                        double totalPriceRoom = bookingCheckOut.getTotalRoomPrice();
                        double totalPriceService = bookingCheckOut.getTotalPriceService();
                        double amount = totalAmount; // ti xet
                        System.out.println("Tien phong = " + totalPriceRoom);
                        System.out.println("Tien dv " + totalPriceService);
                        System.out.println("Tong tien chua tru giam gia " + totalAmount);
                        System.out.println(totalAmount);
                        double discountValue = 0;
                        String dicountType = voucherApp.getDiscountType();
                        Boolean useVocher = true;
                        if (dicountType.equals("FIXED") && totalAmount >= minOrderValue) {
                                discountValue = voucherApp.getDiscountValue();

                                amount = totalAmount - discountValue;
                                // useVocher = bookingVoucherController.createBookingVoucher(
                                // bookingId, voucherApp.getId(), discountValue);
                                System.out.println("trong 1 " + useVocher);

                        }
                        if (dicountType.equals("PERCENTAGE") && totalAmount >= minOrderValue) {
                                if (((discountValue / 100) * totalAmount) > maxDiscountValue) {
                                        discountValue = maxDiscountValue;
                                        amount = totalAmount - maxDiscountValue;
                                        // useVocher = bookingVoucherController.createBookingVoucher(
                                        // bookingId, voucherApp.getId(), discountValue);
                                        System.out.println("trong 2 " + useVocher);

                                } else {
                                        discountValue = ((voucherApp.getDiscountValue() / 100) * totalAmount);
                                        amount = totalAmount - discountValue;
                                        // useVocher = bookingVoucherController.createBookingVoucher(
                                        // bookingId, voucherApp.getId(), discountValue);
                                        System.out.println("trong 3 " + useVocher);

                                }
                        }
                        bookingCheckOut.setTotalDicount(discountValue);
                        System.out.println(discountValue);
                        System.out.println(amount);
                        System.out.println(useVocher);
                        if (!useVocher) {
                                JOptionPane.showMessageDialog(null, "Thêm mã giảm giá thất bại!", "Thông báo",
                                                JOptionPane.WARNING_MESSAGE);
                                System.out.println("Gia sau khi khong them ma giam " + amount);
                                bookingCheckOut.setPricePay(totalPriceRoom, totalPriceService, discountValue, amount);
                        } else {

                                // thêm sau trả ra giao diện sử dụng dịch vụ
                                DefaultTableModel tableModelVoucherApp = bookingCheckOut.getTableModelVoucherApp();
                                tableModelVoucherApp.setRowCount(0);
                                bookingCheckOut.addRoom(bookingId, voucherApp.getId(), discountValue,
                                                tableModelVoucherApp);
                                amount = totalAmount - discountValue;
                                bookingCheckOut.setTotalAmount(amount);
                                bookingCheckOut.setTotalDicount(discountValue);

                                System.out.println("Gia khi ap ma giam gia " + amount);
                                bookingCheckOut.setPricePay(totalPriceRoom, totalPriceService, discountValue, amount);
                        }
                        // bookingCheckOut.clearSelectedTable();

                });

                // sử kiện tạo hóa đơn khi nhấn trả phòng
                bookingCheckOut.actionSuccessBill(e -> {
                        Voucher voucherSelected = bookingCheckOut.getVoucherSelected();
                        int bookingId = bookingCheckOut.getIdBooking();
                        int idRoom = bookingCheckOut.getIdRoom();
                        System.out.println(bookingCheckOut.getTimeStay());
                        Timestamp timeCheckout = Timestamp.valueOf(bookingCheckOut.getCheckOut());
                        if (voucherSelected != null) {

                                Double amount = bookingCheckOut.getTotalAmount();

                                Double discountPrice = bookingCheckOut.getTotalDicount();
                                System.out.println("Tong tien giam gia" + discountPrice);
                                System.out.println("Tong tien cuoi cung" + amount);

                                Voucher voucherApp = voucherController.detailVoucher(voucherSelected.getId(), "active");
                                // lưu dịch vụ voucher
                                Double discountValue = bookingCheckOut.getTotalDicount();
                                Boolean useVocher = bookingVoucherController.createBookingVoucher(
                                                bookingId, voucherApp.getId(), discountValue);
                                if (!useVocher) {
                                        JOptionPane.showMessageDialog(null, "Thêm mã giảm giá thất bại!", "Thông báo",
                                                        JOptionPane.WARNING_MESSAGE);

                                } else {
                                        Boolean checkedPayment = paymentController.createPayment(bookingId,
                                                        amount, "Cash");
                                        if (!checkedPayment) {
                                                System.out.println("Tạo hóa đơn thất bại!");
                                                Boolean changeStatus = paymentController.changeStatus(
                                                                bookingId,
                                                                "Failed");
                                                return;
                                        }
                                        Boolean updateStatusRoom = roomsController
                                                        .updateRoomStatus(idRoom, "available");
                                        Boolean updateBookingPay = bookingController.updateBookingPay(
                                                        bookingId, "checked-out", timeCheckout, amount);
                                        if (updateBookingPay && updateStatusRoom) {
                                                JOptionPane.showMessageDialog(null,
                                                                "Thanh toán thành công! Chào thân ái",
                                                                "Thông báo",
                                                                JOptionPane.WARNING_MESSAGE);
                                                bookingMain.refreshTable();
                                                cardLayout.show(contentPanel, "bookingMainPanel");
                                        }

                                }

                        } else {

                                Double amount = bookingCheckOut.getTotalAmount();
                                Double discountPrice = bookingCheckOut.getTotalDicount();

                                Boolean checkedPayment = paymentController.createPayment(bookingId,
                                                amount, "Cash");
                                if (!checkedPayment) {
                                        System.out.println("Tạo hóa đơn thất bại!");
                                        Boolean changeStatus = paymentController.changeStatus(
                                                        bookingId,
                                                        "Failed");
                                        return;
                                } else {

                                        Boolean updateStatusRoom = roomsController
                                                        .updateRoomStatus(idRoom, "available");
                                        Boolean updateBookingPay = bookingController.updateBookingPay(
                                                        bookingId, "checked-out", timeCheckout, amount);
                                        if (updateBookingPay && updateStatusRoom) {
                                                JOptionPane.showMessageDialog(null,
                                                                "Thanh toán thành công! Chào thân ái",
                                                                "Thông báo",
                                                                JOptionPane.WARNING_MESSAGE);
                                                bookingMain.refreshTable();
                                                cardLayout.show(contentPanel, "bookingMainPanel");

                                        }
                                }

                        }

                });
                // hết sự kiện tạo hóa đơn khi nhấn trả phòng
                // hết thêm voucher cho hóa đơn
                // ra khỏi trang hóa đơn
                bookingCheckOut.actionCancelBill(e -> {
                        bookingCheckOut.clearAppVoucher();
                        bookingCheckOut.clearSelectedTable();
                        cardLayout.show(contentPanel, "bookingMainPanel");
                });
                // hếtsự kiện check-out
                // hết booking
                menuPanel.addManageEmployeeListener(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "employeePanel"); // Hiển thị giao diện "Quản lý nhân viên"
                });

                // dịch vụ
                menuPanel.addManageServiceListener(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "servicePanel"); // Hiển thị giao diện "Quản lý dịch vụ
                });
                servicePanelView.actionCreateService(e -> {
                        cardLayout.show(contentPanel, "createServicePanel");
                });

                serviceAddView.actionBack(e -> {
                        cardLayout.show(contentPanel, "servicePanel");
                });
                servicePanelView.actionDeleteService(e -> {
                        Service selectedService = servicePanelView.getSelectedService();
                        if (selectedService != null) {
                                int confirm = JOptionPane.showConfirmDialog(null,
                                                "Bạn có chắc chắn muốn dịch vụ này không?", "Xác nhận",
                                                JOptionPane.YES_NO_OPTION);
                                if (confirm == JOptionPane.YES_OPTION) {
                                        boolean isDeleted = serviceController.deleteService(selectedService.getId());
                                        if (isDeleted) {
                                                JOptionPane.showMessageDialog(null, "Xóa phòng thành công!");
                                                // Làm mới bảng sau khi xóa
                                                servicePanelView.refreshTable();
                                        } else {
                                                JOptionPane.showMessageDialog(null, "Xóa phòng thất bại!");
                                        }
                                }
                        }
                });

                // sang giao diện edit
                servicePanelView.actionEditService(e -> {
                        cardLayout.show(contentPanel, "editServicePanel");
                        Service selectedService = servicePanelView.getSelectedService();
                        if (selectedService == null) {
                                cardLayout.show(contentPanel, "servicePanel");
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn một dịch vụ!");
                        }
                        serviceEditView.setDataService(selectedService);

                });
                serviceEditView.actionEditService(e -> {
                        Service selectedService = servicePanelView.getSelectedService();
                        String name = serviceEditView.getNameService();
                        Double price = Double.parseDouble(serviceEditView.getPriceService());
                        String status = serviceEditView.getStatusService();
                        System.out.println(status);
                        String desc = serviceEditView.getDesc();
                        Service serviceNew = new Service(name, price, desc, status);
                        Boolean isCreated = serviceController.updateService(serviceNew, selectedService.getId());
                        if (isCreated) {
                                cardLayout.show(contentPanel, "servicePanel");
                                servicePanelView.refreshTable();
                        } else {
                                JOptionPane.showMessageDialog(null, "Tạo dịch vụ thất bại!", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                });
                serviceEditView.actionbtnBackEditSerivce(e -> {
                        cardLayout.show(contentPanel, "servicePanel");
                });
                // hết dịch vụ

                // Sự kiện xử lí nhân viên
                employeeManagement.actionAddEmployee(e -> {
                        cardLayout.show(contentPanel, "employeeCreatePanel");
                }

                );
                employeeManagement.actionEditEmployee(e -> {

                        cardLayout.show(contentPanel, "employeeEditPanel");
                        Employee employee = employeeManagement.getSelectedEmployee();
                        editEmployeePanel.setEmployee(employee);

                });
                editEmployeePanel.actionbtnBackEditUser(e -> {
                        cardLayout.show(contentPanel, "employeePanel");
                });
                editEmployeePanel.actionbtnEditUser(e -> {
                        Employee employee = employeeManagement.getSelectedEmployee();
                        String userName = editEmployeePanel.getUserNameEmployee();
                        String fullName = editEmployeePanel.getNameEmployee();
                        String email = editEmployeePanel.getEmailEmployee();
                        String password = editEmployeePanel.getPasswordEmployee();
                        String levelUser = editEmployeePanel.getLevelEmployee();
                        String status = editEmployeePanel.getStatusEmployee();
                        // Kiểm tra nếu mật khẩu trống, giữ nguyên mật khẩu cũ
                        String hashedPassword;
                        if (password == null || password.isEmpty()) {
                                hashedPassword = employee.getPassword(); // Giữ nguyên mật khẩu cũ
                        } else {
                                hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12)); // Mã hóa mật khẩu mới
                        }
                        System.out.println(employee.getPassword());

                        int idEmployeeEdit = employee.getId();
                        Employee newEmployee = new Employee(userName, fullName, email, hashedPassword, levelUser,
                                        status);
                        Boolean existEmail = employeeController.existEmail(newEmployee.getEmail(), idEmployeeEdit);
                        if (existEmail) {
                                JOptionPane.showMessageDialog(null, "Email đã tồn tại!", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                return;
                        }
                        Boolean isUpdate = employeeController.updateEmployee(newEmployee, idEmployeeEdit);
                        if (isUpdate) {
                                cardLayout.show(contentPanel, "employeePanel");
                                employeeManagement.refreshTable();

                        } else {
                                JOptionPane.showMessageDialog(null, "Chỉnh sửa không thành công!", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                return;
                        }

                });
                // quay lại
                createEmployeePanel.actionbtnBackCreateUser(e -> {
                        cardLayout.show(contentPanel, "employeePanel");
                        createEmployeePanel.clearData();
                });
                // tạo mới
                createEmployeePanel.actionbtnCreateUser(e -> {
                        String fullName = createEmployeePanel.getNameEmployee();
                        String userName = createEmployeePanel.getUserNameEmployee();
                        String email = createEmployeePanel.getEmailEmployee();
                        String password = createEmployeePanel.getPasswordEmployee();
                        String levelEmployee = createEmployeePanel.getLevelEmployee();
                        String status = createEmployeePanel.getStatusEmployee();
                        Employee newEmployee = new Employee(userName, fullName, email, password, levelEmployee, status);
                        Boolean isCreateEmployee = employeeController.createEmployee(newEmployee);
                        if (!isCreateEmployee) {
                                JOptionPane.showMessageDialog(null, "Tạo nhân viên không thành công!", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                return;
                        }
                        cardLayout.show(contentPanel, "employeePanel");
                        createEmployeePanel.clearData();
                        employeeManagement.refreshTable();
                });

                // menuPanel.addManageBillListener(e -> {
                // CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                // cardLayout.show(contentPanel, ""); // Hiển thị giao diện "Quản lý hóa đơn

                // });
                // bắt sự kiên của tính năng voucher
                menuPanel.voucherManagement(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "voucherPanel"); // Hiển thị giao diện "Quản lý nhân vocher
                });

                // sang trang thêm voucher
                voucherMainPanel.actionAddVoucher(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "addVoucherPanel");
                });
                // bắt sự kiên của tính năng voucher
                creareVoucherPanel.actionCreateVoucher(e -> {
                        String desc = creareVoucherPanel.getDescription();
                        String type = creareVoucherPanel.getTypeDiscount();
                        Double valueDiscount = Double.parseDouble(creareVoucherPanel.getDiscountValue());
                        Date startDate = Date.valueOf(creareVoucherPanel.getStartDate());
                        Date endDate = Date.valueOf(creareVoucherPanel.getEndDate());
                        Double minOrder = Double.parseDouble(creareVoucherPanel.getMinOrderValue());
                        Double maxOrder = Double.parseDouble(creareVoucherPanel.getMaxDiscountValue());
                        Integer limitUsage = Integer.parseInt(creareVoucherPanel.getUsageLimit());
                        String status = creareVoucherPanel.getStatus();
                        Voucher newVoucher = new Voucher(desc, type, valueDiscount, minOrder, maxOrder, startDate,
                                        endDate, limitUsage, status);
                        Boolean isCreateVoucher = voucherController.createVoucher(newVoucher);
                        if (!isCreateVoucher) {
                                JOptionPane.showMessageDialog(null, "Tạo voucher thất bại!", "Lỗi",
                                                JOptionPane.ERROR_MESSAGE);
                                return;
                        }
                        cardLayout.show(contentPanel, "voucherPanel");
                        creareVoucherPanel.clearData();
                        voucherMainPanel.refreshTable();

                });
                creareVoucherPanel.actionBack(e -> {
                        cardLayout.show(contentPanel, "voucherPanel");
                        creareVoucherPanel.clearData();
                });
                voucherMainPanel.actionEditVoucher(e -> {
                        Voucher voucherSelected = voucherMainPanel.getSelectedVoucher();
                        if (voucherSelected == null) {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn một voucher!");
                                cardLayout.show(contentPanel, "voucherPanel");
                        } else {
                                editVoucherFun.data(voucherSelected);
                                cardLayout.show(contentPanel, "editVoucherPanel");
                        }
                });
                editVoucherFun.actionBack(e -> {

                        cardLayout.show(contentPanel, "voucherPanel");
                });
                editVoucherFun.actionEditVoucher(e -> {
                        Voucher voucherSelected = voucherMainPanel.getSelectedVoucher();
                        String desc = editVoucherFun.getDescription();
                        String type = editVoucherFun.getTypeDiscount();
                        Double discountValue = Double.parseDouble(editVoucherFun.getDiscountValue());
                        Double minVoucher = Double.parseDouble(editVoucherFun.getMinOrderValue());
                        Double maxVoucher = Double.parseDouble(editVoucherFun.getMaxDiscountValue());
                        Date start = Date.valueOf(editVoucherFun.getStartDate());
                        Date end = Date.valueOf(editVoucherFun.getEndDate());
                        Integer limitUsage = Integer.parseInt(editVoucherFun.getUsageLimit());
                        String status = editVoucherFun.getStatus();
                        Voucher newVoucher = new Voucher(desc, type, discountValue, minVoucher, maxVoucher, start, end,
                                        limitUsage, status);
                        Boolean isEdit = voucherController.updateVoucher(newVoucher, voucherSelected.getId());
                        if (!isEdit) {
                                JOptionPane.showMessageDialog(null, "Chỉnh sửa thất bại");
                                cardLayout.show(contentPanel, "editVoucherPanel");
                        } else {
                                JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công");
                                cardLayout.show(contentPanel, "voucherPanel");
                                voucherMainPanel.refreshTable();
                        }

                });
                voucherMainPanel.actionDeleteVoucher(e -> {
                        Voucher voucherSelected = voucherMainPanel.getSelectedVoucher();
                        if (voucherSelected == null) {
                                JOptionPane.showMessageDialog(null, "Vui lòng chọn một voucher!");
                                cardLayout.show(contentPanel, "voucherPanel");
                        }
                        if (voucherSelected != null) {
                                int confirm = JOptionPane.showConfirmDialog(null,
                                                "Bạn có chắc chắn muốn xóa?", "Xác nhận",
                                                JOptionPane.YES_NO_OPTION);
                                if (confirm == JOptionPane.YES_OPTION) {
                                        boolean isDeleted = voucherController.deleteVoucher(voucherSelected.getId()); // Gọi
                                        // phương
                                        // thức
                                        // xóa
                                        // phòng
                                        if (isDeleted) {
                                                JOptionPane.showMessageDialog(null, "Xóa voucher thành công!");
                                                voucherMainPanel.refreshTable(); // Làm mới bảng sau khi xóa
                                        } else {
                                                JOptionPane.showMessageDialog(null, "Xóa voucher thất bại!");
                                        }
                                }
                        }
                });
                // hết tính năng voucher
                menuPanel.profitManagement(e -> {
                        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                        cardLayout.show(contentPanel, "revenuePanel"); // Hiển thị giao diện "Quản lý doanh thu

                });
                menuPanel.addExitListener(e -> {
                        System.exit(0); // Thoát ứng dụng
                });
        }// </editor-fold>//GEN-END:initComponents

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(mainDefault.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(mainDefault.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(mainDefault.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(mainDefault.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new mainDefault().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables

        private javax.swing.JComboBox<String> JcomeStatusEditRoom;

        private javax.swing.JComboBox<String> JcomeTypeRoomEdit;
        private javax.swing.JPanel addRoomPanel;

        private javax.swing.JButton btnBackEditRoom;

        private javax.swing.JButton btnEditRoomEdit;

        private javax.swing.JPanel centerEditRoomPanel;

        private javax.swing.JPanel contentPanel;
        private javax.swing.JPanel createServicePanel;
        private javax.swing.JPanel editRoomPanel;
        private javax.swing.JPanel editServicePanel;
        private javax.swing.JPanel employeeCreatePanel;
        private javax.swing.JPanel employeeEditPanel;
        private javax.swing.JPanel employeePanel;

        private javax.swing.JPanel homePanel;
        private javax.swing.JSpinner inputCaptityEditRoom;

        private javax.swing.JTextField inputNumberRoomEdit;

        private javax.swing.JTextField inputPriceEditRoom;

        private javax.swing.JScrollPane jScrollPane4;

        private javax.swing.JLabel labCaptityEditRoom;

        private javax.swing.JLabel labDescriptionEditRoom;

        private javax.swing.JLabel labEmployeeUserEdit;
        private javax.swing.JLabel labILevelUser;
        private javax.swing.JLabel labILevelUserEdit;
        private javax.swing.JLabel labImageEmployee;
        private javax.swing.JLabel labInputCreateEmployee;
        private javax.swing.JLabel labInputEditEmployee;
        private javax.swing.JLabel labInputRoom;
        private javax.swing.JLabel labInputRoomEdit;
        private javax.swing.JLabel labInputSericeEdit;
        private javax.swing.JLabel labInputTypeRoom;
        private javax.swing.JLabel labInputTypeRoomEdit;
        private javax.swing.JLabel labName;
        private javax.swing.JLabel labNameSericeAdd;
        private javax.swing.JLabel labPasswordCreateUser;
        private javax.swing.JLabel labPasswordEditUser;
        private javax.swing.JLabel labPriceAddRoom;
        private javax.swing.JLabel labPriceEditRoom;
        private javax.swing.JLabel labPriceEditService;
        private javax.swing.JLabel labPriceServiceAdd;
        private javax.swing.JLabel labStatusAddRoom;
        private javax.swing.JLabel labStatusCreateService;
        private javax.swing.JLabel labStatusEditRoom;
        private javax.swing.JLabel labStatusEditSerivce;
        private javax.swing.JLabel labStatusUserCreate;
        private javax.swing.JLabel labStatusUserEdit;
        private javax.swing.JLabel labTitleAddRoom;
        private javax.swing.JLabel labTitleAddRoom1;
        private javax.swing.JLabel labTitleEditService;
        private javax.swing.JLabel labTitleEmployeeCreate;
        private javax.swing.JLabel labTitleEmployeeCreate1;
        private javax.swing.JLabel labTitleEmployeeCreate2;
        private javax.swing.JLabel labTitleRoom;
        private javax.swing.JLabel labTitleService;
        private javax.swing.JLabel labWelcome;
        private javax.swing.JPanel paginationPanel;
        private javax.swing.JPanel paginationPanel1;
        private javax.swing.JPanel paginationPanel2;
        private javax.swing.JPanel panelInfoEmployee;
        private javax.swing.JPanel panelListButton;
        private javax.swing.JPanel panelMenu;
        private javax.swing.JPanel panelTopCreateEmployee;
        private javax.swing.JPanel panelTopEditEmployee;
        private javax.swing.JPanel panelTopEditEmployee1;
        private javax.swing.JPanel roomPanel;
        private javax.swing.JPanel servicePanel;
        private javax.swing.JTable tableEmployee;
        private javax.swing.JPanel tablePanel;
        private javax.swing.JTable tableRoom;
        private javax.swing.JTable tableRoom1;
        private javax.swing.JPanel tableServicePanel;
        private javax.swing.JTextArea textAreaAddRoom;
        private javax.swing.JTextArea textAreaCreateService;
        private javax.swing.JTextArea textAreaCreateUser;
        private javax.swing.JTextArea textAreaCreateUser1;
        private javax.swing.JTextArea textAreaEditRoom;
        private javax.swing.JTextArea textAreaEditService;
        private javax.swing.JPanel timekeepingCenterPanel;
        private javax.swing.JPanel timekeepingEmployeePanel;
        private javax.swing.JLabel titleHome;
        private javax.swing.JPanel topAddRoomPanel;
        private javax.swing.JPanel topCreateServicePanel;
        private javax.swing.JPanel topEditRoomPanel;
        private javax.swing.JPanel topEditServicePanel;
        private javax.swing.JPanel topPanelHome;
        private javax.swing.JPanel topRoomPanel;
        private javax.swing.JPanel topRoomPanel1;
        private javax.swing.JPanel topServicePanel;
        // End of variables declaration//GEN-END:variables
}
