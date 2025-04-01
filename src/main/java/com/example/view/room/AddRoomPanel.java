package com.example.view.room;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.example.helper.Item;

import java.awt.event.ActionListener;

public class AddRoomPanel {
        private javax.swing.JPanel addRoomPanel = new JPanel();
        private javax.swing.JLabel labTitleAddRoom = new JLabel();
        private javax.swing.JPanel topAddRoomPanel = new JPanel();
        private javax.swing.JLabel labInputRoom = new JLabel();
        private javax.swing.JTextField inputNumberRoom = new JTextField();
        private javax.swing.JLabel labPriceAddRoom = new JLabel();
        private javax.swing.JComboBox<Item> JcomeTypeRoomAdd = new JComboBox<>();
        private javax.swing.JLabel labInputTypeRoom = new JLabel();
        private javax.swing.JTextField inputPriceAddRoom = new JTextField();
        private javax.swing.JLabel labCaptityAddRoom = new JLabel();
        private javax.swing.JLabel labStatusAddRoom = new JLabel();
        private javax.swing.JComboBox<Item> JcomeStatusAddRoom = new JComboBox<>();
        private javax.swing.JLabel labDescriptionAddRoom = new JLabel();
        private javax.swing.JTextArea textAreaAddRoom = new JTextArea();
        private javax.swing.JButton btnBackAddRoom = new JButton();
        private javax.swing.JScrollPane jScrollPane3 = new JScrollPane();
        private javax.swing.JButton btnCreateRoomAdd = new JButton();
        private javax.swing.JPanel centerAddRoomPanel = new JPanel();
        private javax.swing.JSpinner inputCaptityAddRoom = new JSpinner();

        public JPanel addRoom() {
                addRoomPanel.setLayout(new java.awt.BorderLayout());

                labTitleAddRoom.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
                labTitleAddRoom.setForeground(new java.awt.Color(30, 60, 90));
                labTitleAddRoom.setText("Thêm phòng");

                javax.swing.GroupLayout topAddRoomPanelLayout = new javax.swing.GroupLayout(topAddRoomPanel);
                topAddRoomPanel.setLayout(topAddRoomPanelLayout);
                topAddRoomPanelLayout.setHorizontalGroup(
                                topAddRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(topAddRoomPanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addComponent(labTitleAddRoom,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                218,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(1293, Short.MAX_VALUE)));
                topAddRoomPanelLayout.setVerticalGroup(
                                topAddRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(topAddRoomPanelLayout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(labTitleAddRoom)
                                                                .addContainerGap(25, Short.MAX_VALUE)));

                addRoomPanel.add(topAddRoomPanel, java.awt.BorderLayout.PAGE_START);

                labInputRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labInputRoom.setForeground(new java.awt.Color(30, 60, 90));
                labInputRoom.setText("Nhập số phòng: ");

                inputNumberRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                inputNumberRoom.setPreferredSize(new java.awt.Dimension(120, 25));

                labPriceAddRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labPriceAddRoom.setForeground(new java.awt.Color(30, 60, 90));
                labPriceAddRoom.setText("Nhập giá phòng: ");

                JcomeTypeRoomAdd.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new Item[] {
                                                                new Item("Family Room", "Family Room"),
                                                                new Item("Single Room", "Single Room"),

                                                }));
                JcomeTypeRoomAdd.setPreferredSize(new java.awt.Dimension(100, 25));
                // JcomeTypeRoomAdd.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // JcomeTypeRoomAddActionPerformed(evt);
                // }
                // });

                labInputTypeRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labInputTypeRoom.setForeground(new java.awt.Color(30, 60, 90));
                labInputTypeRoom.setText("Nhập kiểu phòng: ");

                inputPriceAddRoom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                inputPriceAddRoom.setPreferredSize(new java.awt.Dimension(100, 25));

                labCaptityAddRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labCaptityAddRoom.setForeground(new java.awt.Color(30, 60, 90));
                labCaptityAddRoom.setText("Nhập số người: ");

                labStatusAddRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labStatusAddRoom.setForeground(new java.awt.Color(30, 60, 90));
                labStatusAddRoom.setText("Chọn trạng thái: ");

                JcomeStatusAddRoom.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new Item[] {
                                                                new Item("available", "Available"),
                                                                new Item("occupied", "Occupied"),
                                                                new Item("reserved", "Reserved"),
                                                                new Item("maintenance", "Maintenance"),
                                                                new Item("cleaning", "Cleaning")
                                                }));
                JcomeStatusAddRoom.setPreferredSize(new java.awt.Dimension(100, 25));
                // JcomeStatusAddRoom.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // JcomeStatusAddRoomActionPerformed(evt);
                // }
                // });

                labDescriptionAddRoom.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labDescriptionAddRoom.setForeground(new java.awt.Color(30, 60, 90));
                labDescriptionAddRoom.setText("Nhập mô tả:");

                textAreaAddRoom.setColumns(20);
                textAreaAddRoom.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
                textAreaAddRoom.setRows(5);
                jScrollPane3.setViewportView(textAreaAddRoom);

                btnCreateRoomAdd.setBackground(new java.awt.Color(30, 60, 90));
                btnCreateRoomAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnCreateRoomAdd.setForeground(new java.awt.Color(255, 255, 255));
                btnCreateRoomAdd.setText("Thêm phòng");
                btnCreateRoomAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnCreateRoomAdd.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnCreateRoomAddActionPerformed(evt);
                // }
                // });

                btnBackAddRoom.setBackground(new java.awt.Color(255, 51, 51));
                btnBackAddRoom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnBackAddRoom.setForeground(new java.awt.Color(255, 255, 255));
                btnBackAddRoom.setText("Quay lại");
                btnBackAddRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnBackAddRoom.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnBackAddRoomActionPerformed(evt);
                // }
                // });

                javax.swing.GroupLayout centerAddRoomPanelLayout = new javax.swing.GroupLayout(centerAddRoomPanel);
                centerAddRoomPanel.setLayout(centerAddRoomPanelLayout);
                centerAddRoomPanelLayout.setHorizontalGroup(
                                centerAddRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(centerAddRoomPanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addGroup(centerAddRoomPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(centerAddRoomPanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btnBackAddRoom)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(btnCreateRoomAdd))
                                                                                .addGroup(centerAddRoomPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(labDescriptionAddRoom)
                                                                                                .addGroup(centerAddRoomPanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(centerAddRoomPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                centerAddRoomPanelLayout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(labInputRoom)
                                                                                                                                                                .addPreferredGap(
                                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                                .addComponent(inputNumberRoom,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                122,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addGap(69, 69, 69))
                                                                                                                                .addGroup(centerAddRoomPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labStatusAddRoom)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(JcomeStatusAddRoom,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                139,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(49, 49, 49)))
                                                                                                                .addGroup(centerAddRoomPanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(centerAddRoomPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labCaptityAddRoom)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(inputCaptityAddRoom,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGroup(centerAddRoomPanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labInputTypeRoom)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(JcomeTypeRoomAdd,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                139,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGap(141, 141,
                                                                                                                                141)
                                                                                                                .addComponent(labPriceAddRoom)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(inputPriceAddRoom,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                134,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addComponent(jScrollPane3)))
                                                                .addContainerGap(495, Short.MAX_VALUE)));
                centerAddRoomPanelLayout.setVerticalGroup(
                                centerAddRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(centerAddRoomPanelLayout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(centerAddRoomPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labInputRoom)
                                                                                .addComponent(inputNumberRoom,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labPriceAddRoom)
                                                                                .addComponent(JcomeTypeRoomAdd,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labInputTypeRoom)
                                                                                .addComponent(inputPriceAddRoom,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(centerAddRoomPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labStatusAddRoom)
                                                                                .addComponent(JcomeStatusAddRoom,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labCaptityAddRoom)
                                                                                .addComponent(inputCaptityAddRoom,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(labDescriptionAddRoom)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                237,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(centerAddRoomPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnCreateRoomAdd)
                                                                                .addComponent(btnBackAddRoom))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                addRoomPanel.add(centerAddRoomPanel, java.awt.BorderLayout.CENTER);

                return addRoomPanel;
        }

        public void actionBackRoom(ActionListener e) {
                btnBackAddRoom.addActionListener(e);
        }

        public void actionAddRoom(ActionListener e) {

                btnCreateRoomAdd.addActionListener(e);
        }

        public String getRoomNumber() {
                return inputNumberRoom.getText();
        }

        public String getTypeRoom() {
                Item selectedItem = (Item) JcomeTypeRoomAdd.getSelectedItem();
                return selectedItem.getKey();
        }

        public String getRoomPrice() {
                return inputPriceAddRoom.getText();
        }

        public String getRoomStatus() {

                Item selectedItem = (Item) JcomeStatusAddRoom.getSelectedItem();
                return selectedItem.getKey();
        }

        public int getRoomCapacity() {
                return (int) inputCaptityAddRoom.getValue();
        }

        public String getDescription() {
                return textAreaAddRoom.getText();
        }

        public void clearFields() {
                inputNumberRoom.setText("");
                inputPriceAddRoom.setText("");
                JcomeTypeRoomAdd.setSelectedIndex(0);
                JcomeStatusAddRoom.setSelectedIndex(0);
                inputCaptityAddRoom.setValue(0);
                textAreaAddRoom.setText("");
        }

}
