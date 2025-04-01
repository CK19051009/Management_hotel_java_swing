package com.example.view.dashboard;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel {
    private javax.swing.JPanel homePanel = new JPanel();
    private javax.swing.JLabel titleHome = new JLabel();
    private javax.swing.JPanel topPanelHome = new JPanel();
    private javax.swing.JPanel centerHomePanel = new JPanel();
    private javax.swing.JButton jButton3 = new JButton();

    public JPanel dashboardPanel() {

        homePanel.setLayout(new java.awt.BorderLayout());

        titleHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleHome.setForeground(new java.awt.Color(30, 60, 90));
        titleHome.setText("Trang Chủ");
        titleHome.setToolTipText("");

        javax.swing.GroupLayout topPanelHomeLayout = new javax.swing.GroupLayout(topPanelHome);
        topPanelHome.setLayout(topPanelHomeLayout);
        topPanelHomeLayout.setHorizontalGroup(
                topPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topPanelHomeLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(titleHome,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        131,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(1376, Short.MAX_VALUE)));
        topPanelHomeLayout.setVerticalGroup(
                topPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topPanelHomeLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(titleHome)
                                .addContainerGap(63, Short.MAX_VALUE)));

        homePanel.add(topPanelHome, java.awt.BorderLayout.PAGE_START);

        centerHomePanel.setLayout(new java.awt.GridLayout(2, 8, 12, 20));

        jButton3.setPreferredSize(new java.awt.Dimension(200, 150));
        centerHomePanel.add(jButton3);

        homePanel.add(centerHomePanel, java.awt.BorderLayout.CENTER);

        return homePanel;
    }
}
