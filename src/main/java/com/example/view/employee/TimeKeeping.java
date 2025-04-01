package com.example.view.employee;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TimeKeeping {
        private javax.swing.JPanel timekeepingEmployeePanel = new JPanel();
        private javax.swing.JLabel labTitleEmployeeCreate2 = new JLabel();
        private javax.swing.JLabel jLabel1 = new JLabel();
        private javax.swing.JLabel jLabel3 = new JLabel();
        private javax.swing.JCheckBox checkInUser = new JCheckBox();
        private javax.swing.JComboBox<String> jComboMonthTimeKeeping = new JComboBox<>();
        private javax.swing.JPanel panelTopEditEmployee1 = new JPanel();
        private javax.swing.JCheckBox checkOutUser = new JCheckBox();
        private javax.swing.JPanel timekeepingCenterPanel = new JPanel();
        private javax.swing.JTable jTable1 = new JTable();
        private javax.swing.JScrollPane jScrollPane7 = new JScrollPane();

        public JPanel timeKeeping() {
                timekeepingEmployeePanel.setLayout(new java.awt.BorderLayout());

                labTitleEmployeeCreate2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
                labTitleEmployeeCreate2.setForeground(new java.awt.Color(30, 60, 90));
                labTitleEmployeeCreate2.setText("Chấm công:  tên nhân viên");

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel1.setText("Check-Out:");

                jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                jLabel3.setText("Check-In:");

                // checkInUser.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // checkInUserActionPerformed(evt);
                // }
                // });

                // checkOutUser.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // checkOutUserActionPerformed(evt);
                // }
                // });

                jComboMonthTimeKeeping.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "----- Chấm công tháng 3-----", "Tháng 2", "Tháng 1", " " }));
                // jComboMonthTimeKeeping.addActionListener(new java.awt.event.ActionListener()
                // {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // jComboMonthTimeKeepingActionPerformed(evt);
                // }
                // });

                javax.swing.GroupLayout panelTopEditEmployee1Layout = new javax.swing.GroupLayout(
                                panelTopEditEmployee1);
                panelTopEditEmployee1.setLayout(panelTopEditEmployee1Layout);
                panelTopEditEmployee1Layout.setHorizontalGroup(
                                panelTopEditEmployee1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                panelTopEditEmployee1Layout
                                                                                .createSequentialGroup()
                                                                                .addGap(25, 25, 25)
                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(labTitleEmployeeCreate2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                475,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jComboMonthTimeKeeping,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                197,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                756,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                76,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(checkOutUser,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                85,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jLabel1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                76,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(checkInUser,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                85,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(113, 113, 113)));
                panelTopEditEmployee1Layout.setVerticalGroup(
                                panelTopEditEmployee1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelTopEditEmployee1Layout.createSequentialGroup()
                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(17, 17, 17)
                                                                                                .addComponent(labTitleEmployeeCreate2))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                panelTopEditEmployee1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addContainerGap(
                                                                                                                                59,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(checkOutUser,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                .addComponent(jLabel3,
                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING))))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel1,
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(checkInUser,
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING))
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(panelTopEditEmployee1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jComboMonthTimeKeeping,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                27,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGap(29, 29, 29)))));

                timekeepingEmployeePanel.add(panelTopEditEmployee1, java.awt.BorderLayout.PAGE_START);

                timekeepingCenterPanel.setLayout(new java.awt.BorderLayout());

                jTable1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null, null, null },
                                                { null, null, null, null, null },
                                                { null, null, null, null, null },
                                                { null, null, null, null, null }
                                },
                                new String[] {
                                                "STT", "Mã nhân viên", "Ngày", "Check-In", "Check-out"
                                }));
                jScrollPane7.setViewportView(jTable1);

                timekeepingCenterPanel.add(jScrollPane7, java.awt.BorderLayout.CENTER);

                timekeepingEmployeePanel.add(timekeepingCenterPanel, java.awt.BorderLayout.CENTER);
                return timekeepingEmployeePanel;
        }
}
