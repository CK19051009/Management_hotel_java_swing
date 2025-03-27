package com.example.view.default_main;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class menuPanel {
    private JPanel panelMenu = new JPanel();
    private javax.swing.JPanel panelInfoEmployee = new JPanel();
    private javax.swing.JPanel panelListButton = new JPanel();
    private javax.swing.JLabel labWelcome = new JLabel();
    private javax.swing.JLabel labImageEmployee = new JLabel();
    private javax.swing.JLabel labName = new JLabel();
    private javax.swing.JButton btnRoomManage = new JButton();
    private javax.swing.JButton btnManageService = new JButton();
    private javax.swing.JButton btnExit = new JButton();
    private javax.swing.JButton btnManageBill = new JButton();
    private javax.swing.JButton btnManageEmployee = new JButton();
    private javax.swing.JButton btnManageProfit = new JButton();
    private javax.swing.JButton btnManageVoucher = new JButton();

    private javax.swing.JButton btnRoomPlace = new JButton();

    public JPanel renderMenuPanel() {

        panelMenu.setBackground(new java.awt.Color(30, 60, 90));
        panelMenu.setPreferredSize(new java.awt.Dimension(200, 700));
        panelMenu.setLayout(new java.awt.BorderLayout());

        panelInfoEmployee.setBackground(new java.awt.Color(30, 60, 90));
        panelInfoEmployee.setPreferredSize(new java.awt.Dimension(200, 300));
        panelInfoEmployee.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 30, 50));

        labWelcome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labWelcome.setForeground(new java.awt.Color(255, 255, 255));
        labWelcome.setText("Chào mừng bạn");
        labWelcome.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        panelInfoEmployee.add(labWelcome);

        labImageEmployee.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labImageEmployee.setForeground(new java.awt.Color(255, 255, 255));
        labImageEmployee.setText("Ảnh nhân viên");
        panelInfoEmployee.add(labImageEmployee);

        labName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labName.setForeground(new java.awt.Color(255, 255, 255));
        labName.setText("Họ và tên nhân viên");
        labName.setAlignmentX(30.0F);
        labName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelInfoEmployee.add(labName);

        panelMenu.add(panelInfoEmployee, java.awt.BorderLayout.PAGE_START);

        panelListButton.setBackground(new java.awt.Color(30, 60, 90));
        panelListButton.setPreferredSize(new java.awt.Dimension(200, 400));

        btnRoomManage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRoomManage.setForeground(new java.awt.Color(255, 255, 255));
        btnRoomManage.setText("Quản lý phòng");
        btnRoomManage.setToolTipText("");
        btnRoomManage.setBorder(null);
        btnRoomManage.setContentAreaFilled(false);
        btnRoomManage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnRoomPlace.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRoomPlace.setForeground(new java.awt.Color(255, 255, 255));
        btnRoomPlace.setText("Quản lý đặt phòng");
        btnRoomPlace.setToolTipText("");
        btnRoomPlace.setBorder(null);
        btnRoomPlace.setContentAreaFilled(false);
        btnRoomPlace.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnManageService.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageService.setForeground(new java.awt.Color(255, 255, 255));
        btnManageService.setText("Quản dịch vụ");
        btnManageService.setToolTipText("");
        btnManageService.setBorder(null);
        btnManageService.setContentAreaFilled(false);
        btnManageService.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnManageBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageBill.setForeground(new java.awt.Color(255, 255, 255));
        btnManageBill.setText("Quản lý hóa đơn");
        btnManageBill.setToolTipText("");
        btnManageBill.setBorder(null);
        btnManageBill.setContentAreaFilled(false);
        btnManageBill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnManageVoucher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnManageVoucher.setText("Quản lý voucher");
        btnManageVoucher.setToolTipText("");
        btnManageVoucher.setBorder(null);
        btnManageVoucher.setContentAreaFilled(false);
        btnManageVoucher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnManageProfit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageProfit.setForeground(new java.awt.Color(255, 255, 255));
        btnManageProfit.setText("Quản lý doanh thu");
        btnManageProfit.setToolTipText("");
        btnManageProfit.setBorder(null);
        btnManageProfit.setContentAreaFilled(false);
        btnManageProfit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnManageEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageEmployee.setForeground(new java.awt.Color(255, 255, 255));
        btnManageEmployee.setText("Quản lý nhân viên");
        btnManageEmployee.setToolTipText("");
        btnManageEmployee.setBorder(null);
        btnManageEmployee.setContentAreaFilled(false);
        btnManageEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Thoát");
        btnExit.setToolTipText("");
        btnExit.setBorder(null);
        btnExit.setContentAreaFilled(false);
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panelListButtonLayout = new javax.swing.GroupLayout(panelListButton);
        panelListButton.setLayout(panelListButtonLayout);
        panelListButtonLayout.setHorizontalGroup(
                panelListButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelListButtonLayout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addGroup(panelListButtonLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnRoomManage, javax.swing.GroupLayout.PREFERRED_SIZE, 126,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnManageService, javax.swing.GroupLayout.PREFERRED_SIZE, 126,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnManageBill, javax.swing.GroupLayout.PREFERRED_SIZE, 126,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnManageVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 126,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnManageEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 126,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnManageProfit, javax.swing.GroupLayout.DEFAULT_SIZE, 137,
                                                Short.MAX_VALUE)
                                        .addComponent(btnRoomPlace, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 126,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(26, Short.MAX_VALUE)));
        panelListButtonLayout.setVerticalGroup(
                panelListButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelListButtonLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnRoomManage)
                                .addGap(18, 18, 18)
                                .addComponent(btnRoomPlace)
                                .addGap(18, 18, 18)
                                .addComponent(btnManageBill)
                                .addGap(18, 18, 18)
                                .addComponent(btnManageService)
                                .addGap(18, 18, 18)
                                .addComponent(btnManageVoucher)
                                .addGap(18, 18, 18)
                                .addComponent(btnManageEmployee)
                                .addGap(18, 18, 18)
                                .addComponent(btnManageProfit)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit)
                                .addContainerGap()));

        panelMenu.add(panelListButton, java.awt.BorderLayout.CENTER);
        return panelMenu;
    }

    // getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

}
