package com.example.view.room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.RoomsController;
import com.example.helper.Item;
import com.example.models.Room;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RoomMain {

        private JPanel roomPanel = new JPanel();
        private JPanel topRoomPanel = new JPanel();
        private JLabel labTitleRoom = new JLabel("Quản lý phòng");
        private JComboBox<Item> JcStatusRoom = new JComboBox<>();
        private JTextField filedSearchRoom = new JTextField();
        private JButton btnSearchRoom = new JButton("Tìm kiếm");
        private JComboBox<String> jcSortRoom = new JComboBox<>();
        private JButton btnSortRoom = new JButton("Áp dụng");
        private JButton btnEditRoom = new JButton("Chỉnh sửa");
        private JButton btnDeleteRoom = new JButton("Xóa phòng");
        private JButton btnAddRoom = new JButton("Tạo phòng");
        private JPanel tablePanel = new JPanel();
        private JTable tableRoom = new JTable();
        private JScrollPane jScrollPane1 = new JScrollPane();
        private DefaultTableModel tableModel;
        private RoomsController roomsController = new RoomsController();

        public JPanel roomMain() {
                // Cấu hình roomPanel
                roomPanel.setPreferredSize(new Dimension(1100, 700));
                roomPanel.setLayout(new BorderLayout());

                // Cấu hình topRoomPanel
                configureTopRoomPanel();
                roomPanel.add(topRoomPanel, BorderLayout.PAGE_START);

                // Cấu hình tablePanel
                configureTablePanel();
                roomPanel.add(tablePanel, BorderLayout.CENTER);

                return roomPanel;
        }

        private void configureTopRoomPanel() {
                topRoomPanel.setPreferredSize(new Dimension(934, 100));
                topRoomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

                // Tiêu đề
                labTitleRoom.setFont(new Font("Segoe UI", Font.BOLD, 18));
                labTitleRoom.setForeground(new Color(30, 60, 90));
                topRoomPanel.add(labTitleRoom);

                // ComboBox trạng thái phòng
                JcStatusRoom.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("all", "All"),
                                new Item("available", "Available"),
                                new Item("occupied", "Occupied"),
                                new Item("reserved", "Reserved"),
                                new Item("maintenance", "Maintenance"),
                                new Item("cleaning", "Cleaning")
                }));
                JcStatusRoom.setSelectedIndex(0);
                JcStatusRoom.addActionListener(this::JcStatusRoomActionPerformed);
                topRoomPanel.add(JcStatusRoom);

                // Trường tìm kiếm
                filedSearchRoom.setPreferredSize(new Dimension(150, 25));
                topRoomPanel.add(filedSearchRoom);

                // Nút tìm kiếm
                btnSearchRoom.setBackground(new Color(30, 60, 90));
                btnSearchRoom.setForeground(Color.WHITE);
                btnSearchRoom.addActionListener(e -> searchRoom());
                btnSearchRoom.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topRoomPanel.add(btnSearchRoom);

                // ComboBox sắp xếp
                jcSortRoom.setModel(new DefaultComboBoxModel<>(new String[] {
                                "---Chọn thứ tự sắp xếp---", "Giá tăng dần", "Giá giảm dần"
                }));
                btnSortRoom.addActionListener(e -> applySort());
                topRoomPanel.add(jcSortRoom);

                // Nút áp dụng sắp xếp
                btnSortRoom.setBackground(new Color(30, 60, 90));
                btnSortRoom.setForeground(Color.WHITE);
                btnSortRoom.setFont(new Font("Segoe UI", Font.BOLD, 14));
                topRoomPanel.add(btnSortRoom);

                // Nút xóa phòng
                btnDeleteRoom.setBackground(new Color(255, 0, 51));
                btnDeleteRoom.setForeground(Color.WHITE);
                btnDeleteRoom.setFont(new Font("Segoe UI", Font.BOLD, 14));
                topRoomPanel.add(btnDeleteRoom);

                // Nút chỉnh sửa phòng
                btnEditRoom.setBackground(new Color(153, 255, 153));
                btnEditRoom.setForeground(Color.WHITE);
                btnEditRoom.setFont(new Font("Segoe UI", Font.BOLD, 14));
                topRoomPanel.add(btnEditRoom);

                // Nút tạo phòng
                btnAddRoom.setBackground(new Color(30, 60, 90));
                btnAddRoom.setForeground(Color.WHITE);
                btnAddRoom.setFont(new Font("Segoe UI", Font.BOLD, 14));
                topRoomPanel.add(btnAddRoom);
        }

        private void configureTablePanel() {
                tablePanel.setLayout(new BorderLayout());

                // Cấu hình bảng
                String[] columnNames = { "STT", "Số phòng", "Kiểu phòng", "Giá phòng (VND)", "Vị trí", "Trạng thái",
                                "Số người", "Mô tả" };
                tableModel = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int col) {
                                return false;
                        }
                };
                tableRoom.setModel(tableModel);
                tableRoom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                tableRoom.setRowHeight(25);

                // Thêm dữ liệu vào bảng
                refreshTable();

                // Thêm bảng vào JScrollPane
                jScrollPane1.setViewportView(tableRoom);
                tablePanel.add(jScrollPane1, BorderLayout.CENTER);
        }

        public void refreshTable() {
                tableModel.setRowCount(0); // Xóa dữ liệu cũ trong bảng
                List<Room> rooms = roomsController.listRooms(); // Lấy danh sách phòng mới
                for (Room room : rooms) {
                        addRoom(room, tableModel); // Thêm từng phòng vào bảng
                }
                tableRoom.revalidate();
                tableRoom.repaint();
        }

        private void addRoom(Room room, DefaultTableModel tableModel) {
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

        public void JcStatusRoomActionPerformed(ActionEvent evt) {
                Item selectedItem = (Item) JcStatusRoom.getSelectedItem();
                List<Room> roomStatus = roomsController.listStatus(selectedItem.getKey());
                tableModel.setRowCount(0);
                if (selectedItem.getKey().equals("all")) {
                        refreshTable();
                } else {
                        for (Room room : roomStatus) {
                                addRoom(room, tableModel);
                        }
                }
        }

        public Room getSelectedRoom() {
                int selectedRow = tableRoom.getSelectedRow();
                if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn một phòng!");
                        return null;
                }

                Room room = new Room();
                room.setId((int) tableModel.getValueAt(selectedRow, 0));
                room.setRoomNumber((int) tableModel.getValueAt(selectedRow, 1));
                room.setRoomType((String) tableModel.getValueAt(selectedRow, 2));
                room.setPrice((double) tableModel.getValueAt(selectedRow, 3));
                room.setPosition((int) tableModel.getValueAt(selectedRow, 4));
                room.setStatus((String) tableModel.getValueAt(selectedRow, 5));
                room.setCapacity((int) tableModel.getValueAt(selectedRow, 6));
                room.setDescription((String) tableModel.getValueAt(selectedRow, 7));

                return room;
        }

        public void actionAddRoom(ActionListener evt) {
                btnAddRoom.addActionListener(evt);
        }

        public void actionEditRoom(ActionListener e) {
                btnEditRoom.addActionListener(e);
        }

        public void actionDeleteRoom(ActionListener e) {
                btnDeleteRoom.addActionListener(e);
        }

        public void applySort() {
                boolean ascending = jcSortRoom.getSelectedIndex() == 1;
                List<Room> sortedRooms = roomsController.listRoomsSortedByPrice(ascending);
                tableModel.setRowCount(0);
                for (Room room : sortedRooms) {
                    addRoom(room, tableModel);
                }
            }

            // Tìm kiếm theo số phòng
    public void searchRoom() {
        String roomNumberStr = filedSearchRoom.getText();
        try {
            int roomNumber = Integer.parseInt(roomNumberStr);
            List<Room> room = roomsController.getRoomsByNumberPrefix(roomNumber);
            tableModel.setRowCount(0);
            if (room != null) {
                for (Room r : room) {
                addRoom(r, tableModel); }
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số phòng hợp lệ.");
        }
    }

    

        
}