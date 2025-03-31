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

import org.mindrot.jbcrypt.BCrypt;

import com.example.controllers.BookingController;
import com.example.controllers.EmployeeController;
import com.example.controllers.RoomsController;
import com.example.controllers.ServiceController;
import com.example.controllers.VoucherController;
import com.example.models.Booking;
import com.example.models.Employee;
import com.example.models.Room;
import com.example.models.Service;
import com.example.models.Voucher;
import com.example.view.bookings.BookingEditPanel;
import com.example.view.bookings.BookingMain;
import com.example.view.bookings.BookingCreatePanel;
import com.example.view.dashboard.HomePanel;
import com.example.view.default_main.menuPanel;
import com.example.view.employee.CreateEmployeePanel;
import com.example.view.employee.EditEmployeePanel;
import com.example.view.employee.EmployeeManagement;
import com.example.view.employee.TimeKeeping;
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
        // controller
        RoomsController roomsController = new RoomsController();
        ServiceController serviceController = new ServiceController();
        EmployeeController employeeController = new EmployeeController();
        VoucherController voucherController = new VoucherController();
        BookingController bookingController = new BookingController();

        public mainDefault() {
                initComponents();
        }

        // cardLayout = (CardLayout) contentPanel.getLayout();

        @SuppressWarnings("checked")

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
                contentPanel.setPreferredSize(new java.awt.Dimension(1100, 700));
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

                cardLayout.show(contentPanel, "homePanel");
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
                        // LocalDateTime now = LocalDateTime.now();
                        Timestamp timestamp = Timestamp.valueOf(checkInString);
                        Double depositAmount = Double.parseDouble(BookingsPanel.getDeposit());
                        Booking booking = new Booking(idRoom, idCustomer, timestamp,
                                        depositAmount);
                        Boolean createBooking = bookingController.createBookings(booking);
                        if (createBooking) {
                                Boolean updateStatusRoom = roomsController
                                                .updateRoomStatus(idRoom, "occupied");
                                BookingsPanel.clearData();
                                ;
                                cardLayout.show(contentPanel, "bookingMainPanel");
                                JOptionPane.showMessageDialog(null, "Tạo hóa đơn thành công!");
                        } else {
                                cardLayout.show(contentPanel, "bookingPanel");
                                JOptionPane.showMessageDialog(null, "Tạo hóa đơn thất bại thất bại!");
                        }

                });
                // hủy
                BookingsPanel.actionCancel(e -> {
                        BookingsPanel.clearData();
                        cardLayout.show(contentPanel, "bookingMainPanel");
                });
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
                // menuPanel.profitManagement(e -> {
                // // CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                // // cardLayout.show(contentPanel, ""); // Hiển thị giao diện "Quản lý doanh
                // thu
                // // });
                // });
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
