package com.example.view.voucher;

import javax.swing.*;

import com.example.helper.Item;
import com.example.models.Voucher;

import java.awt.*;
import java.awt.event.ActionListener;

public class EditVoucherPanel {

        private JPanel editVoucherPanel = new JPanel();
        private JPanel topEditVoucherPanel = new JPanel();
        private JPanel centerEditVoucherPanel = new JPanel();

        private JLabel labTitleEditVoucher = new JLabel("Chỉnh sửa Voucher");
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

        private JButton btnEditVoucher = new JButton("Sửa Voucher");
        private JButton btnBack = new JButton("Quay lại");

        public JPanel editVoucher() {
                // Cấu hình panel chính
                editVoucherPanel.setLayout(new BorderLayout());

                // Cấu hình panel tiêu đề
                configureTopPanel();
                editVoucherPanel.add(topEditVoucherPanel, BorderLayout.PAGE_START);

                // Cấu hình panel trung tâm
                configureCenterPanel();
                editVoucherPanel.add(centerEditVoucherPanel, BorderLayout.CENTER);

                return editVoucherPanel;
        }

        private void configureTopPanel() {
                topEditVoucherPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                labTitleEditVoucher.setFont(new Font("Segoe UI", Font.BOLD, 36));
                labTitleEditVoucher.setForeground(new Color(30, 60, 90));
                topEditVoucherPanel.add(labTitleEditVoucher);
        }

        private void configureCenterPanel() {
                centerEditVoucherPanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.fill = GridBagConstraints.HORIZONTAL;

                Font labelFont = new Font("Segoe UI", Font.BOLD, 14); // Font chữ đậm và to hơn
                labDiscountValue.setFont(labelFont);
                labTypeDiscount.setFont(labelFont);
                labStartDate.setFont(labelFont);
                labEndDate.setFont(labelFont);
                labMinOrderValue.setFont(labelFont);
                labMaxDiscountValue.setFont(labelFont);
                labUsageLimit.setFont(labelFont);
                labStatus.setFont(labelFont);
                labDescription.setFont(labelFont);

                // Nhập giá trị giảm giá
                gbc.gridx = 0;
                gbc.gridy = 0;
                centerEditVoucherPanel.add(labDiscountValue, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                inputDiscountValue.setPreferredSize(new Dimension(300, 30));
                centerEditVoucherPanel.add(inputDiscountValue, gbc);

                // Nhập loại giảm giá
                gbc.gridx = 0;
                gbc.gridy = 1;
                centerEditVoucherPanel.add(labTypeDiscount, gbc);

                gbc.gridx = 1;
                gbc.gridy = 1;
                comboTypeDiscount.setPreferredSize(new Dimension(300, 30));
                comboTypeDiscount.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("PERCENTAGE", "PERCENTAGE"),
                                new Item("FIXED", "FIXED")
                }));
                centerEditVoucherPanel.add(comboTypeDiscount, gbc);

                // Nhập ngày bắt đầu
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerEditVoucherPanel.add(labStartDate, gbc);

                gbc.gridx = 1;
                gbc.gridy = 2;
                inputStartDate.setPreferredSize(new Dimension(300, 30));
                centerEditVoucherPanel.add(inputStartDate, gbc);

                // Nhập ngày kết thúc
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerEditVoucherPanel.add(labEndDate, gbc);

                gbc.gridx = 1;
                gbc.gridy = 3;
                inputEndDate.setPreferredSize(new Dimension(300, 30));
                centerEditVoucherPanel.add(inputEndDate, gbc);

                // Nhập đơn hàng tối thiểu
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerEditVoucherPanel.add(labMinOrderValue, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                inputMinOrderValue.setPreferredSize(new Dimension(300, 30));
                centerEditVoucherPanel.add(inputMinOrderValue, gbc);

                // Nhập giảm giá tối đa
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerEditVoucherPanel.add(labMaxDiscountValue, gbc);

                gbc.gridx = 1;
                gbc.gridy = 5;
                inputMaxDiscountValue.setPreferredSize(new Dimension(300, 30));
                centerEditVoucherPanel.add(inputMaxDiscountValue, gbc);

                // Số lần sử dụng
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerEditVoucherPanel.add(labUsageLimit, gbc);

                gbc.gridx = 1;
                gbc.gridy = 6;
                inputUsageLimit.setPreferredSize(new Dimension(300, 30));
                centerEditVoucherPanel.add(inputUsageLimit, gbc);

                // Trạng thái
                gbc.gridx = 0;
                gbc.gridy = 7;
                centerEditVoucherPanel.add(labStatus, gbc);

                gbc.gridx = 1;
                gbc.gridy = 7;
                comboStatus.setPreferredSize(new Dimension(300, 30));
                comboStatus.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("active", "active"),
                                new Item("inactive", "inactive")
                }));
                centerEditVoucherPanel.add(comboStatus, gbc);

                // Nhập mô tả
                gbc.gridx = 0;
                gbc.gridy = 8;
                centerEditVoucherPanel.add(labDescription, gbc);

                gbc.gridx = 1;
                gbc.gridy = 8;
                textAreaDescription.setRows(5);
                textAreaDescription.setColumns(20);
                scrollPaneDescription.setPreferredSize(new Dimension(300, 100));
                centerEditVoucherPanel.add(scrollPaneDescription, gbc);

                // Nút Sửa và Quay lại
                gbc.gridx = 0;
                gbc.gridy = 9;
                centerEditVoucherPanel.add(btnBack, gbc);

                gbc.gridx = 1;
                gbc.gridy = 9;
                centerEditVoucherPanel.add(btnEditVoucher, gbc);
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

        public void actionEditVoucher(ActionListener e) {
                btnEditVoucher.addActionListener(e);
        }

        public void actionBack(ActionListener e) {
                btnBack.addActionListener(e);
        }

        public void data(Voucher voucher) {
                inputDiscountValue.setText(String.valueOf(voucher.getDiscountValue()));
                for (int i = 0; i < comboTypeDiscount.getItemCount(); i++) {
                        Item item = (Item) comboTypeDiscount.getItemAt(i);
                        if (item.getKey().equals(voucher.getStatus())) {
                                comboTypeDiscount.setSelectedItem(item);
                                break;
                        }
                }
                inputStartDate.setText(String.valueOf(voucher.getStartDate()));
                inputEndDate.setText(String.valueOf(voucher.getEndDate()));
                inputMinOrderValue.setText(String.valueOf(voucher.getMinOrderValue()));
                inputMaxDiscountValue.setText(String.valueOf(voucher.getMaxDiscountValue()));
                inputUsageLimit.setText(String.valueOf(voucher.getUsageLimit()));

                // Đặt giá trị cho JComboBox levelUser
                for (int i = 0; i < comboStatus.getItemCount(); i++) {
                        Item item = (Item) comboStatus.getItemAt(i);
                        if (item.getKey().equals(voucher.getStatus())) {
                                comboStatus.setSelectedItem(item);
                                break;
                        }
                }
                textAreaDescription.setText(voucher.getDescription());
        }
}