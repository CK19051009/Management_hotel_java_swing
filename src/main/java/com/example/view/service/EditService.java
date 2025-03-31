package com.example.view.service;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.example.helper.Item;
import com.example.models.Service;
import java.awt.event.ActionListener;

public class EditService {
        private javax.swing.JPanel editServicePanel = new JPanel();
        private javax.swing.JLabel labTitleEditService = new JLabel();
        private javax.swing.JPanel topEditServicePanel = new JPanel();
        private javax.swing.JLabel labInputSericeEdit = new JLabel();
        private javax.swing.JTextField inputNameServiceEdit = new JTextField();
        private javax.swing.JLabel labStatusEditSerivce = new JLabel();
        private javax.swing.JLabel labPriceEditService = new JLabel();
        private javax.swing.JTextField inputPriceEditSerivce = new JTextField();
        private javax.swing.JComboBox<Item> JcomeStatusEditService = new JComboBox<>();
        private javax.swing.JLabel labDescriptionServiceEdit = new JLabel();
        private javax.swing.JTextArea textAreaEditService = new JTextArea();
        private javax.swing.JScrollPane jScrollPane9 = new JScrollPane();
        private javax.swing.JButton btnEditServicePanel = new JButton();
        private javax.swing.JButton btnBackEditSerivce = new JButton();
        private javax.swing.JPanel centerEditServicePanel = new JPanel();

        public JPanel editService() {
                editServicePanel.setLayout(new java.awt.BorderLayout());

                labTitleEditService.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
                labTitleEditService.setForeground(new java.awt.Color(30, 60, 90));
                labTitleEditService.setText("Chỉnh sửa dịch vụ");

                javax.swing.GroupLayout topEditServicePanelLayout = new javax.swing.GroupLayout(topEditServicePanel);
                topEditServicePanel.setLayout(topEditServicePanelLayout);
                topEditServicePanelLayout.setHorizontalGroup(
                                topEditServicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(topEditServicePanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addComponent(labTitleEditService,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                327,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(1184, Short.MAX_VALUE)));
                topEditServicePanelLayout.setVerticalGroup(
                                topEditServicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(topEditServicePanelLayout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(labTitleEditService)
                                                                .addContainerGap(25, Short.MAX_VALUE)));

                editServicePanel.add(topEditServicePanel, java.awt.BorderLayout.PAGE_START);

                labInputSericeEdit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labInputSericeEdit.setForeground(new java.awt.Color(30, 60, 90));
                labInputSericeEdit.setText("Nhập tên: ");

                inputNameServiceEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                inputNameServiceEdit.setPreferredSize(new java.awt.Dimension(120, 25));

                labPriceEditService.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labPriceEditService.setForeground(new java.awt.Color(30, 60, 90));
                labPriceEditService.setText("Nhập giá: ");

                inputPriceEditSerivce.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                inputPriceEditSerivce.setPreferredSize(new java.awt.Dimension(100, 25));

                labStatusEditSerivce.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labStatusEditSerivce.setForeground(new java.awt.Color(30, 60, 90));
                labStatusEditSerivce.setText("Chọn trạng thái: ");

                JcomeStatusEditService.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new Item[] {
                                                                new Item("available", "available"),
                                                                new Item("unavailable", "unavailable")
                                                }));
                JcomeStatusEditService.setPreferredSize(new java.awt.Dimension(100, 25));
                // JcomeStatusEditService.addActionListener(new java.awt.event.ActionListener()
                // {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // JcomeStatusEditServiceActionPerformed(evt);
                // }
                // });

                labDescriptionServiceEdit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labDescriptionServiceEdit.setForeground(new java.awt.Color(30, 60, 90));
                labDescriptionServiceEdit.setText("Nhập mô tả:");

                textAreaEditService.setColumns(20);
                textAreaEditService.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
                textAreaEditService.setRows(5);
                jScrollPane9.setViewportView(textAreaEditService);

                btnEditServicePanel.setBackground(new java.awt.Color(30, 60, 90));
                btnEditServicePanel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnEditServicePanel.setForeground(new java.awt.Color(255, 255, 255));
                btnEditServicePanel.setText("Chỉnh sửa");
                btnEditServicePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnEditServicePanel.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnEditServicePanelActionPerformed(evt);
                // }
                // });

                btnBackEditSerivce.setBackground(new java.awt.Color(255, 51, 51));
                btnBackEditSerivce.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnBackEditSerivce.setForeground(new java.awt.Color(255, 255, 255));
                btnBackEditSerivce.setText("Quay lại");
                btnBackEditSerivce.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnBackEditSerivce.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnBackEditSerivceActionPerformed(evt);
                // }
                // });

                javax.swing.GroupLayout centerEditServicePanelLayout = new javax.swing.GroupLayout(
                                centerEditServicePanel);
                centerEditServicePanel.setLayout(centerEditServicePanelLayout);
                centerEditServicePanelLayout.setHorizontalGroup(
                                centerEditServicePanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(centerEditServicePanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addGroup(centerEditServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(centerEditServicePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btnBackEditSerivce)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(btnEditServicePanel))
                                                                                .addGroup(centerEditServicePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(labDescriptionServiceEdit)
                                                                                                .addGroup(centerEditServicePanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(centerEditServicePanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addGroup(centerEditServicePanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labInputSericeEdit)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(inputNameServiceEdit,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                .addGroup(centerEditServicePanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labStatusEditSerivce)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(JcomeStatusEditService,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                139,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGap(49, 49, 49)
                                                                                                                .addComponent(labPriceEditService)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(inputPriceEditSerivce,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addComponent(jScrollPane9,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                1016,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(495, Short.MAX_VALUE)));
                centerEditServicePanelLayout.setVerticalGroup(
                                centerEditServicePanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(centerEditServicePanelLayout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(centerEditServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labInputSericeEdit)
                                                                                .addComponent(inputNameServiceEdit,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labPriceEditService)
                                                                                .addComponent(inputPriceEditSerivce,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(centerEditServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labStatusEditSerivce)
                                                                                .addComponent(JcomeStatusEditService,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(labDescriptionServiceEdit)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane9,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                237,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(centerEditServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnEditServicePanel)
                                                                                .addComponent(btnBackEditSerivce))
                                                                .addContainerGap(127, Short.MAX_VALUE)));

                editServicePanel.add(centerEditServicePanel, java.awt.BorderLayout.CENTER);
                return editServicePanel;
        }

        // sự kiện
        public void setDataService(Service service) {
                inputNameServiceEdit.setText(service.getName());
                inputPriceEditSerivce.setText(String.valueOf(service.getPrice()));
                JcomeStatusEditService.setSelectedItem(service.getStatus());
                textAreaEditService.setText(service.getDescription());
        }

        public void actionbtnBackEditSerivce(ActionListener e) {
                btnBackEditSerivce.addActionListener(e);
        }

        public void actionEditService(ActionListener e) {
                btnEditServicePanel.addActionListener(e);
        }

        public String getNameService() {
                return inputNameServiceEdit.getText();
        }

        public String getPriceService() {
                return inputPriceEditSerivce.getText();
        }

        public String getStatusService() {
                Item selectedItem = (Item) JcomeStatusEditService.getSelectedItem();
                return selectedItem.getKey();
        }

        public String getDesc() {
                return textAreaEditService.getText();
        }
}
