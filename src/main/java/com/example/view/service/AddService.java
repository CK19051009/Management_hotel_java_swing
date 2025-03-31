package com.example.view.service;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.example.helper.Item;

import java.awt.event.ActionListener;

public class AddService {
        private javax.swing.JPanel createServicePanel = new JPanel();
        private javax.swing.JLabel labTitleAddRoom1 = new JLabel();
        private javax.swing.JPanel topCreateServicePanel = new JPanel();
        private javax.swing.JLabel labNameSericeAdd = new JLabel();
        private javax.swing.JTextField inputNameServiceAdd = new JTextField();
        private javax.swing.JLabel labPriceServiceAdd = new JLabel();
        private javax.swing.JLabel labStatusCreateService = new JLabel();
        private javax.swing.JTextField inputPriceAddSerice = new JTextField();
        private javax.swing.JComboBox<Item> JcomeStatusCreateService = new JComboBox<>();
        private javax.swing.JLabel labDescriptionServiceCreate = new JLabel();
        private javax.swing.JTextArea textAreaCreateService = new JTextArea();
        private javax.swing.JScrollPane jScrollPane8 = new JScrollPane();
        private javax.swing.JButton btnCreateCreateService = new JButton();
        private javax.swing.JButton btnBackCreateSerivce = new JButton();
        private javax.swing.JPanel centerCreateServicePanel = new JPanel();

        public JPanel createSerivce() {
                createServicePanel.setLayout(new java.awt.BorderLayout());

                labTitleAddRoom1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
                labTitleAddRoom1.setForeground(new java.awt.Color(30, 60, 90));
                labTitleAddRoom1.setText("Thêm dịch vụ");

                javax.swing.GroupLayout topCreateServicePanelLayout = new javax.swing.GroupLayout(
                                topCreateServicePanel);
                topCreateServicePanel.setLayout(topCreateServicePanelLayout);
                topCreateServicePanelLayout.setHorizontalGroup(
                                topCreateServicePanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(topCreateServicePanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addComponent(labTitleAddRoom1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                253,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(1258, Short.MAX_VALUE)));
                topCreateServicePanelLayout.setVerticalGroup(
                                topCreateServicePanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(topCreateServicePanelLayout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(labTitleAddRoom1)
                                                                .addContainerGap(25, Short.MAX_VALUE)));

                createServicePanel.add(topCreateServicePanel, java.awt.BorderLayout.PAGE_START);

                labNameSericeAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labNameSericeAdd.setForeground(new java.awt.Color(30, 60, 90));
                labNameSericeAdd.setText("Nhập tên: ");

                inputNameServiceAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                inputNameServiceAdd.setPreferredSize(new java.awt.Dimension(120, 25));

                labPriceServiceAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labPriceServiceAdd.setForeground(new java.awt.Color(30, 60, 90));
                labPriceServiceAdd.setText("Nhập giá: ");

                inputPriceAddSerice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                inputPriceAddSerice.setPreferredSize(new java.awt.Dimension(100, 25));

                labStatusCreateService.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labStatusCreateService.setForeground(new java.awt.Color(30, 60, 90));
                labStatusCreateService.setText("Chọn trạng thái: ");

                JcomeStatusCreateService.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new Item[] {
                                                                new Item("available", "available"),
                                                                new Item("unavailable", "unavailable")
                                                }));
                JcomeStatusCreateService.setPreferredSize(new java.awt.Dimension(100, 25));
                // JcomeStatusCreateService.addActionListener(new
                // java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // JcomeStatusCreateServiceActionPerformed(evt);
                // }
                // });

                labDescriptionServiceCreate.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
                labDescriptionServiceCreate.setForeground(new java.awt.Color(30, 60, 90));
                labDescriptionServiceCreate.setText("Nhập mô tả:");

                textAreaCreateService.setColumns(20);
                textAreaCreateService.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
                textAreaCreateService.setRows(5);
                jScrollPane8.setViewportView(textAreaCreateService);

                btnCreateCreateService.setBackground(new java.awt.Color(30, 60, 90));
                btnCreateCreateService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnCreateCreateService.setForeground(new java.awt.Color(255, 255, 255));
                btnCreateCreateService.setText("Thêm ");
                btnCreateCreateService.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnCreateCreateService.addActionListener(new java.awt.event.ActionListener()
                // {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnCreateCreateServiceActionPerformed(evt);
                // }
                // });

                btnBackCreateSerivce.setBackground(new java.awt.Color(255, 51, 51));
                btnBackCreateSerivce.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnBackCreateSerivce.setForeground(new java.awt.Color(255, 255, 255));
                btnBackCreateSerivce.setText("Quay lại");
                btnBackCreateSerivce.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                // btnBackCreateSerivce.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // btnBackCreateSerivceActionPerformed(evt);
                // }
                // });

                javax.swing.GroupLayout centerCreateServicePanelLayout = new javax.swing.GroupLayout(
                                centerCreateServicePanel);
                centerCreateServicePanel.setLayout(centerCreateServicePanelLayout);
                centerCreateServicePanelLayout.setHorizontalGroup(
                                centerCreateServicePanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(centerCreateServicePanelLayout.createSequentialGroup()
                                                                .addGap(25, 25, 25)
                                                                .addGroup(centerCreateServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(centerCreateServicePanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btnBackCreateSerivce)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(btnCreateCreateService))
                                                                                .addGroup(centerCreateServicePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(labDescriptionServiceCreate)
                                                                                                .addGroup(centerCreateServicePanelLayout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(centerCreateServicePanelLayout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addGroup(centerCreateServicePanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labNameSericeAdd)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(inputNameServiceAdd,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                .addGroup(centerCreateServicePanelLayout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(labStatusCreateService)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(JcomeStatusCreateService,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                139,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGap(49, 49, 49)
                                                                                                                .addComponent(labPriceServiceAdd)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(inputPriceAddSerice,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addComponent(jScrollPane8,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                1016,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(495, Short.MAX_VALUE)));
                centerCreateServicePanelLayout.setVerticalGroup(
                                centerCreateServicePanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(centerCreateServicePanelLayout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(centerCreateServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labNameSericeAdd)
                                                                                .addComponent(inputNameServiceAdd,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(labPriceServiceAdd)
                                                                                .addComponent(inputPriceAddSerice,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(centerCreateServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labStatusCreateService)
                                                                                .addComponent(JcomeStatusCreateService,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(labDescriptionServiceCreate)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jScrollPane8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                237,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(centerCreateServicePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(btnCreateCreateService)
                                                                                .addComponent(btnBackCreateSerivce))
                                                                .addContainerGap(127, Short.MAX_VALUE)));

                createServicePanel.add(centerCreateServicePanel, java.awt.BorderLayout.CENTER);

                return createServicePanel;
        }

        // sự kiện
        public void actionBack(ActionListener e) {
                btnBackCreateSerivce.addActionListener(e);
        }
}
