package com.example.view.service;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import com.example.controllers.ServiceController;
import com.example.helper.Item;
import com.example.models.Room;
import com.example.models.Service;

public class ServicePanel {

        ServiceController serviceController = new ServiceController();
        private DefaultTableModel tableModel;
        private javax.swing.JPanel servicePanel = new JPanel();
        private javax.swing.JPanel topServicePanel = new JPanel();
        private javax.swing.JLabel labTitleService = new JLabel();
        private javax.swing.JComboBox<Item> JcStatusService = new JComboBox<>();
        private javax.swing.JTextField filedService = new JTextField();
        private javax.swing.JButton btnSearchService = new JButton();
        private javax.swing.JComboBox<String> jcSortService = new JComboBox<>();
        private javax.swing.JButton btnSortService = new JButton();
        private javax.swing.JButton btnEditSerivce = new JButton();
        private javax.swing.JButton btnDeleteSerivce = new JButton();
        private javax.swing.JButton btnAddService = new JButton();
        private javax.swing.JPanel tableServicePanel = new JPanel();
        private javax.swing.JTable tableRoom1 = new JTable();
        private javax.swing.JScrollPane jScrollPaneService = new JScrollPane();
        private javax.swing.JPanel paginationPanel2 = new JPanel();

        private void addRoom(Service service, DefaultTableModel tableModel) {
                tableModel.addRow(new Object[] {
                                service.getId(),
                                service.getName(),
                                service.getDescription(),
                                service.getPrice(),
                                service.getStatus()
                });
        }

        public JPanel servicePanel() {
                servicePanel.setPreferredSize(new java.awt.Dimension(1100, 700));
                servicePanel.setLayout(new java.awt.BorderLayout());

                topServicePanel.setPreferredSize(new java.awt.Dimension(934, 100));

                labTitleService.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                labTitleService.setForeground(new java.awt.Color(30, 60, 90));
                labTitleService.setText("Quản lý dịch vụ");

                JcStatusService.setBackground(new java.awt.Color(30, 60, 90));
                JcStatusService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                JcStatusService.setForeground(new java.awt.Color(255, 255, 255));
                JcStatusService.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new Item[] {
                                                                new Item("available", "available"),
                                                                new Item("unavailable", "unavailable")
                                                }));

                filedService.setHorizontalAlignment(javax.swing.JTextField.LEFT);

                btnSearchService.setBackground(new java.awt.Color(30, 60, 90));
                btnSearchService.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                btnSearchService.setForeground(new java.awt.Color(255, 255, 255));
                btnSearchService.setText("Tìm kiếm");

                jcSortService.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                btnSortService.setBackground(new java.awt.Color(30, 60, 90));
                btnSortService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnSortService.setForeground(new java.awt.Color(255, 255, 255));
                btnSortService.setText("Áp dụng");

                btnEditSerivce.setBackground(new java.awt.Color(153, 255, 153));
                btnEditSerivce.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnEditSerivce.setForeground(new java.awt.Color(255, 255, 255));
                btnEditSerivce.setText("Chỉnh sửa");
                btnEditSerivce.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnEditSerivce.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnEditSerivceActionPerformed(evt);
                // }
                // });

                btnDeleteSerivce.setBackground(new java.awt.Color(255, 0, 51));
                btnDeleteSerivce.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnDeleteSerivce.setForeground(new java.awt.Color(255, 255, 255));
                btnDeleteSerivce.setText("Xóa");
                btnDeleteSerivce.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnDeleteSerivce.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnDeleteSerivceActionPerformed(evt);
                // }
                // });

                btnAddService.setBackground(new java.awt.Color(30, 60, 90));
                btnAddService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnAddService.setForeground(new java.awt.Color(255, 255, 255));
                btnAddService.setText("Tạo ");
                btnAddService.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnAddService.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnAddServiceActionPerformed(evt);
                // }
                // });

                javax.swing.GroupLayout topServicePanelLayout = new javax.swing.GroupLayout(topServicePanel);
                topServicePanel.setLayout(topServicePanelLayout);
                topServicePanelLayout.setHorizontalGroup(
                                topServicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(topServicePanelLayout.createSequentialGroup()
                                                                .addGap(27, 27, 27)
                                                                .addGroup(topServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(topServicePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(JcStatusService,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                159,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(68, 68, 68)
                                                                                                .addComponent(filedService,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                181,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(btnSearchService)
                                                                                                .addGap(50, 50, 50)
                                                                                                .addComponent(jcSortService,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                190,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(btnSortService)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnDeleteSerivce)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(btnEditSerivce)
                                                                                                .addGap(16, 16, 16)
                                                                                                .addComponent(btnAddService)
                                                                                                .addGap(27, 27, 27))
                                                                                .addGroup(topServicePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(labTitleService,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                218,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))));
                topServicePanelLayout.setVerticalGroup(
                                topServicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(topServicePanelLayout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(labTitleService)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(topServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(topServicePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(filedService,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                28,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(btnSearchService,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                27,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jcSortService,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                28,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(btnSortService)
                                                                                                .addComponent(btnEditSerivce)
                                                                                                .addComponent(btnDeleteSerivce)
                                                                                                .addComponent(btnAddService))
                                                                                .addGroup(topServicePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(JcStatusService,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                27,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(2, 2, 2)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                servicePanel.add(topServicePanel, java.awt.BorderLayout.PAGE_START);

                tableServicePanel.setPreferredSize(new java.awt.Dimension(1838, 1838));
                tableServicePanel.setLayout(new java.awt.BorderLayout());
                String[] columnNames = { "STT", "Tên dịch vụ", "Mô tả", "Gía (VND)", "Trạng thái" };
                tableModel = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int col) {
                                return false;
                        }
                };
                tableRoom1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                tableRoom1 = new JTable(tableModel);
                tableRoom1.setPreferredSize(new java.awt.Dimension(80, 80));
                jScrollPaneService.setViewportView(tableRoom1);
                List<Service> services = serviceController.getAllService();
                // if
                // System.out.println(rooms.size());
                for (Service service : services) {
                        addRoom(service, tableModel);
                }
                System.out.println("Số dòng trong tableModel sau khi thêm: " + tableModel.getRowCount());
                // tableRoom.revalidate();
                // tableRoom.repaint();

                tableServicePanel.add(jScrollPaneService, java.awt.BorderLayout.CENTER);

                javax.swing.GroupLayout paginationPanel2Layout = new javax.swing.GroupLayout(paginationPanel2);
                paginationPanel2.setLayout(paginationPanel2Layout);
                paginationPanel2Layout.setHorizontalGroup(
                                paginationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 1536, Short.MAX_VALUE));
                paginationPanel2Layout.setVerticalGroup(
                                paginationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));

                tableServicePanel.add(paginationPanel2, java.awt.BorderLayout.PAGE_END);

                servicePanel.add(tableServicePanel, java.awt.BorderLayout.CENTER);

                return servicePanel;
        }

        // sử kiện
        public void actionCreateService(ActionListener e) {
                btnAddService.addActionListener(e);
        }

        public void actionEditService(ActionListener e) {
                btnEditSerivce.addActionListener(e);
        }

        public Service getSelectedService() {
                int selectedRow = tableRoom1.getSelectedRow(); // Lấy chỉ số dòng được chọn
                if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn một phòng!");
                        return null;
                }

                // Lấy thông tin từ các cột trong dòng được chọn
                Service service = new Service();
                service.setId((int) tableModel.getValueAt(selectedRow, 0));
                service.setName((String) tableModel.getValueAt(selectedRow, 1));
                service.setDescription((String) tableModel.getValueAt(selectedRow, 2));
                service.setPrice((Double) tableModel.getValueAt(selectedRow, 3));
                service.setStatus((String) tableModel.getValueAt(selectedRow, 4));
                return service;
        }

        public void actionDeleteService(ActionListener e) {
                btnDeleteSerivce.addActionListener(e);
        }

        public void refreshTable() {
                tableModel.setRowCount(0); // Xóa dữ liệu cũ trong bảng
                List<Service> services = serviceController.getAllService();
                for (Service service : services) {
                        addRoom(service, tableModel);
                }
                tableRoom1.revalidate();
                tableRoom1.repaint();
        }
        // public
}
