package com.example.view.revenue;

import javax.swing.*;
import java.awt.*;

public class RevenuePanel {
    private JPanel revenuePanel = new JPanel();

    public JPanel renderPanel() {
        // Cấu hình panel chính
        revenuePanel.setLayout(new BorderLayout());

        // Thêm các phần giao diện
        revenuePanel.add(createTitlePanel(), BorderLayout.NORTH);
        revenuePanel.add(createFilterPanel(), BorderLayout.CENTER);
        revenuePanel.add(createTablePanel(), BorderLayout.SOUTH);

        return revenuePanel;
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Báo Cáo Doanh Thu");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(new Color(30, 60, 90));
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    private JPanel createFilterPanel() {
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        filterPanel.setBorder(BorderFactory.createTitledBorder("Lọc doanh thu"));

        JLabel filterLabel = new JLabel("Xem doanh thu theo:");
        JComboBox<String> filterComboBox = new JComboBox<>(new String[] { "Tháng", "Năm" });
        JButton filterButton = new JButton("Xem báo cáo");

        filterPanel.add(filterLabel);
        filterPanel.add(filterComboBox);
        filterPanel.add(filterButton);

        return filterPanel;
    }

    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Chi tiết doanh thu"));

        JTable revenueTable = new JTable(new Object[][] {
                { "Tháng 1", "100.000.000" },
                { "Tháng 2", "120.000.000" },
                { "Tháng 3", "150.000.000" }
        }, new String[] { "Thời gian", "Doanh thu" });

        tablePanel.add(new JScrollPane(revenueTable), BorderLayout.CENTER);

        return tablePanel;
    }
}