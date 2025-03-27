package com.example.view.room;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.table.DefaultTableModel;
import com.example.models.Room;
import com.example.controllers.RoomsController;
import com.example.helper.Item;
import com.example.helper.custom.ButtonCustom;
import com.example.view.default_main.MainDefault;

public class Index extends JPanel {
    private DefaultTableModel tableModel;
    ButtonCustom buttonCustom = new ButtonCustom();
    RoomsController roomsController = new RoomsController();

    public Index(MainDefault mainDefault) {
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Item> cbStatus = new JComboBox<>(
                new Item[] {
                        new Item("", "Chọn trạng thái"),
                        new Item("all", "All"),
                        new Item("available", "Available"),
                        new Item("occupied", "Occupied"),
                        new Item("reserved", "Reserved"),
                        new Item("maintenance", "Maintenance"),

                        new Item("cleaning", "Cleaning")
                });
        JButton btnApplySatus = new JButton("Áp dụng");
        cbStatus.setSelectedIndex(1);
        cbStatus.setPreferredSize(new Dimension(150, 30)); // Set chiều rộng cho comboBox
        btnApplySatus.setPreferredSize(new Dimension(80, 30)); // Set chiều rộng cho
        // nút

        // Thêm khoảng cách 50px giữa ComboBox và nút "Áp dụng"
        // cbStatus.setMargin(new Insets(0, 50, 0, 0));
        cbStatus.addActionListener(e -> {
            Item selectedItem = (Item) cbStatus.getSelectedItem();
            List<Room> roomStatus = roomsController.listStatus(selectedItem.getKey());
            System.out.println(selectedItem.getKey());
            tableModel.setRowCount(0);
            if (selectedItem.getKey().equals("all")) {
                List<Room> rooms = roomsController.listRooms();
                // if
                for (Room room : rooms) {
                    addRoom(room);
                }
            }
            for (Room room : roomStatus) {
                addRoom(room);
            }

        });
        // Ô tìm kiếm
        JTextField txtSearch = new JTextField(15);
        JButton btnSearch = new JButton("🔍");

        // Dropdown chọn hành động
        JComboBox<String> cbAction = new JComboBox<>(new String[] { "---Chọn hoạt động---", "Xóa", "Cập nhật" });
        JButton btnApplyAction = new JButton("Áp dụng");

        // Dropdown chọn thứ tự
        JComboBox<String> cbSort = new JComboBox<>(
                new String[] { "---Chọn thứ tự sắp xếp---", "Giá tăng dần", "Giá giảm dần" });
        JButton btnApplySort = new JButton("Áp dụng");

        // Nút "Thêm mới"
        JButton btnAdd = new JButton("Thêm mới+");
        btnAdd.setBackground(new Color(30, 60, 90));
        buttonCustom.customizeButton(btnAdd);
        // Chuyển sang giao diện "Thêm phòng"
        btnAdd.addActionListener(e -> {
            mainDefault.showContent(new AddRoomPanel(mainDefault));
        });
        // Thêm các thành phần vào topPanel
        topPanel.add(cbStatus);
        topPanel.add(btnApplySatus);
        topPanel.add(txtSearch);
        topPanel.add(btnSearch);
        topPanel.add(cbAction);
        topPanel.add(btnApplyAction);
        topPanel.add(cbSort);
        topPanel.add(btnApplySort);
        topPanel.add(btnAdd);

        // Tạo bảng dữ liệu
        String[] columnNames = { "STT", "Số phòng", "Kiểu phòng", "Gía phòng (VND)", "Vị trí", "Trạng thái", "Số người",
                "Mô tả" };

        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        List<Room> rooms = roomsController.listRooms();
        // if
        for (Room room : rooms) {
            addRoom(room);
        }
        // Tạo khoảng cách 150px
        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(900, 150));
        // Thêm vào panel chính
        add(spacer, BorderLayout.NORTH); // Thêm khoảng cách giữa topPanel và bảng
        add(topPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

    }

    private void addRoom(Room room) {
        tableModel.addRow(new Object[] {
                room.getId(),
                room.getRoomNumber(),
                room.getRoomType(),
                room.getPrice(),
                room.getPosition(),
                room.getStatus(),
                room.getCapacity(),
                room.getDescription()
        });
    }

}
