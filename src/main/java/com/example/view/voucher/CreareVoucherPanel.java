package com.example.view.voucher;

import javax.swing.*;

import com.example.helper.Item;

import java.awt.*;
import java.awt.event.ActionListener;

public class CreareVoucherPanel {

        private JPanel addVoucherPanel = new JPanel();
        private JPanel topAddVoucherPanel = new JPanel();
        private JPanel centerAddVoucherPanel = new JPanel();

        private JLabel labTitleAddVoucher = new JLabel("Thêm Voucher");
        private JLabel labDiscountValue = new JLabel("Nhập giá trị giảm giá:");
        private JLabel labTypeDiscount = new JLabel("Nhập loại giảm giá:");
        private JLabel labStartDate = new JLabel("Nhập ngày bắt đầu:");
        private JLabel labEndDate = new JLabel("Nhập ngày kết thúc:");
        private JLabel labMinOrderValue = new JLabel("Nhập đơn hàng tối thiểu:");
        private JLabel labMaxDiscountValue = new JLabel("Nhập giảm giá tối đa:");
        private JLabel labUsageLimit = new JLabel("Số lần sử dụng:");
        private JLabel labStatus = new JLabel("Trạng thái:");
        private JLabel labDescription = new JLabel("Nhập mô tả:");

        private JTextField inputDiscountValue = new JTextField();
        private JComboBox<Item> comboTypeDiscount = new JComboBox<>();
        private JTextField inputStartDate = new JTextField();
        private JTextField inputEndDate = new JTextField();
        private JTextField inputMinOrderValue = new JTextField();
        private JTextField inputMaxDiscountValue = new JTextField();
        private JTextField inputUsageLimit = new JTextField();
        private JComboBox<Item> comboStatus = new JComboBox<>();
        private JTextArea textAreaDescription = new JTextArea();
        private JScrollPane scrollPaneDescription = new JScrollPane(textAreaDescription);

        private JButton btnCreateVoucher = new JButton("Thêm Voucher");
        private JButton btnBack = new JButton("Quay lại");

        public JPanel addVoucher() {
                // Cấu hình panel chính
                addVoucherPanel.setLayout(new BorderLayout());

                // Cấu hình panel tiêu đề
                configureTopPanel();
                addVoucherPanel.add(topAddVoucherPanel, BorderLayout.PAGE_START);

                // Cấu hình panel trung tâm
                configureCenterPanel();
                addVoucherPanel.add(centerAddVoucherPanel, BorderLayout.CENTER);

                return addVoucherPanel;
        }

        private void configureTopPanel() {
                topAddVoucherPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                labTitleAddVoucher.setFont(new Font("Segoe UI", Font.BOLD, 36));
                labTitleAddVoucher.setForeground(new Color(30, 60, 90));
                topAddVoucherPanel.add(labTitleAddVoucher);
        }

        private void configureCenterPanel() {
                centerAddVoucherPanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                Font labelFont = new Font("Segoe UI", Font.BOLD, 14); // Font chữ đậm và to hơn
                labDiscountValue.setFont(labelFont);
                labDiscountValue.setForeground(new Color(30, 60, 90));
                labTypeDiscount.setFont(labelFont);
                labTypeDiscount.setForeground(new Color(30, 60, 90));
                labStartDate.setFont(labelFont);
                labStartDate.setForeground(new Color(30, 60, 90));
                labEndDate.setFont(labelFont);
                labEndDate.setForeground(new Color(30, 60, 90));
                labMinOrderValue.setFont(labelFont);
                labMinOrderValue.setForeground(new Color(30, 60, 90));
                labMaxDiscountValue.setFont(labelFont);
                labMaxDiscountValue.setForeground(new Color(30, 60, 90));
                labUsageLimit.setFont(labelFont);
                labUsageLimit.setForeground(new Color(30, 60, 90));
                labStatus.setFont(labelFont);
                labStatus.setForeground(new Color(30, 60, 90));
                labDescription.setFont(labelFont);
                labDescription.setForeground(new Color(30, 60, 90));

                // Nhập giá trị giảm giá
                gbc.gridx = 0;
                gbc.gridy = 0;
                centerAddVoucherPanel.add(labDiscountValue, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                inputDiscountValue.setPreferredSize(new Dimension(300, 30));
                centerAddVoucherPanel.add(inputDiscountValue, gbc);

                // Nhập loại giảm giá
                gbc.gridx = 0;
                gbc.gridy = 1;
                centerAddVoucherPanel.add(labTypeDiscount, gbc);

                gbc.gridx = 1;
                gbc.gridy = 1;
                comboTypeDiscount.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("PERCENTAGE", "PERCENTAGE"),
                                new Item("FIXED", "FIXED")
                }));
                comboTypeDiscount.setPreferredSize(new Dimension(300, 30));
                centerAddVoucherPanel.add(comboTypeDiscount, gbc);

                // Nhập ngày bắt đầu
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerAddVoucherPanel.add(labStartDate, gbc);

                gbc.gridx = 1;
                gbc.gridy = 2;
                inputStartDate.setPreferredSize(new Dimension(300, 30));
                centerAddVoucherPanel.add(inputStartDate, gbc);

                // Nhập ngày kết thúc
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerAddVoucherPanel.add(labEndDate, gbc);

                gbc.gridx = 1;
                gbc.gridy = 3;
                inputEndDate.setPreferredSize(new Dimension(300, 30));
                centerAddVoucherPanel.add(inputEndDate, gbc);

                // Nhập đơn hàng tối thiểu
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerAddVoucherPanel.add(labMinOrderValue, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                inputMinOrderValue.setPreferredSize(new Dimension(300, 30));
                centerAddVoucherPanel.add(inputMinOrderValue, gbc);

                // Nhập giảm giá tối đa
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerAddVoucherPanel.add(labMaxDiscountValue, gbc);

                gbc.gridx = 1;
                gbc.gridy = 5;
                inputMaxDiscountValue.setPreferredSize(new Dimension(300, 30));
                centerAddVoucherPanel.add(inputMaxDiscountValue, gbc);

                // Số lần sử dụng
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerAddVoucherPanel.add(labUsageLimit, gbc);

                gbc.gridx = 1;
                gbc.gridy = 6;
                inputUsageLimit.setPreferredSize(new Dimension(300, 30));
                centerAddVoucherPanel.add(inputUsageLimit, gbc);

                // Trạng thái
                gbc.gridx = 0;
                gbc.gridy = 7;
                centerAddVoucherPanel.add(labStatus, gbc);

                gbc.gridx = 1;
                gbc.gridy = 7;
                comboStatus.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("active", "active"),
                                new Item("inactive", "inactive")
                }));
                comboStatus.setPreferredSize(new Dimension(300, 30));
                centerAddVoucherPanel.add(comboStatus, gbc);

                // Nhập mô tả
                gbc.gridx = 0;
                gbc.gridy = 8;
                centerAddVoucherPanel.add(labDescription, gbc);

                gbc.gridx = 1;
                gbc.gridy = 8;
                textAreaDescription.setRows(5);
                textAreaDescription.setColumns(20);
                scrollPaneDescription.setPreferredSize(new Dimension(300, 100));
                centerAddVoucherPanel.add(scrollPaneDescription, gbc);

                // Nút Tạo và Quay lại
                gbc.gridx = 0;
                gbc.gridy = 9;
                btnBack.setFont(labelFont);
                btnBack.setForeground(Color.WHITE);
                btnBack.setBackground(Color.RED);
                centerAddVoucherPanel.add(btnBack, gbc);

                gbc.gridx = 1;
                gbc.gridy = 9;
                btnCreateVoucher.setFont(labelFont);
                btnCreateVoucher.setForeground(Color.WHITE);
                btnCreateVoucher.setBackground(new Color(30, 60, 90));
                centerAddVoucherPanel.add(btnCreateVoucher, gbc);
        }

        public String getDiscountValue() {
                return inputDiscountValue.getText();
        }

        public String getTypeDiscount() {
                Item selectedItem = (Item) comboTypeDiscount.getSelectedItem();
                return selectedItem.getKey();

        }

        public String getStartDate() {
                return inputStartDate.getText();
        }

        public String getEndDate() {
                return inputEndDate.getText();
        }

        public String getMinOrderValue() {
                return inputMinOrderValue.getText();
        }

        public String getMaxDiscountValue() {
                return inputMaxDiscountValue.getText();
        }

        public String getUsageLimit() {
                return inputUsageLimit.getText();
        }

        public String getStatus() {
                Item selectedItem = (Item) comboStatus.getSelectedItem();
                return selectedItem.getKey();
        }

        public String getDescription() {
                return textAreaDescription.getText();
        }

        public void actionCreateVoucher(ActionListener e) {
                btnCreateVoucher.addActionListener(e);
        }

        public void actionBack(ActionListener e) {
                btnBack.addActionListener(e);
        }

        public void clearData() {
                inputDiscountValue.setText("");
                comboTypeDiscount.setSelectedItem(0);
                inputStartDate.setText("");
                inputEndDate.setText("");
                inputMinOrderValue.setText("");
                inputMaxDiscountValue.setText("");
                inputUsageLimit.setText("");
                comboStatus.setSelectedItem(0);
                textAreaDescription.setText("");
        }
}