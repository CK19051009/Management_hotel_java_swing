package com.example.view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import com.example.helper.Item;

public class CreateEmployeePanel {

        private JPanel employeeCreatePanel = new JPanel();
        private JLabel labTitleEmployeeCreate = new JLabel("Tạo nhân viên");
        private JPanel panelTopCreateEmployee = new JPanel();
        private JPanel centerCreateEmployeePanel = new JPanel();

        // Các thành phần giao diện
        private JLabel labInputCreateEmployee = new JLabel("Nhập tên:");
        private JTextField inputNameEmployee = new JTextField();

        private JLabel labEmployeeUser = new JLabel("Nhập UserName:");
        private JTextField inputUserNameCreate = new JTextField();

        private JLabel labEmailCreateUser = new JLabel("Nhập Email:");
        private JTextField inputEmailUserCreate = new JTextField();

        private JLabel labPasswordCreateUser = new JLabel("Nhập password:");
        private JPasswordField inputPasswordCreateUser = new JPasswordField();

        private JLabel labILevelUser = new JLabel("Nhập chức vụ:");
        private JComboBox<Item> JcomeLevelUser = new JComboBox<>();

        private JLabel labStatusUserCreate = new JLabel("Chọn trạng thái:");
        private JComboBox<Item> JcomeStatusCreateUser = new JComboBox<>();

        private JLabel labDescriptionCreateUser = new JLabel("Nhập mô tả:");
        private JTextArea textAreaCreateUser = new JTextArea();
        private JScrollPane scrollPaneDescription = new JScrollPane();

        private JButton btnCreateUser = new JButton("Tạo");
        private JButton btnBackCreateUser = new JButton("Quay lại");

        public JPanel panelCreateEmployee() {
                // Cấu hình panel chính
                employeeCreatePanel.setLayout(new BorderLayout());

                // Cấu hình panel tiêu đề
                configureTopPanel();
                employeeCreatePanel.add(panelTopCreateEmployee, BorderLayout.PAGE_START);

                // Cấu hình panel trung tâm
                configureCenterPanel();
                employeeCreatePanel.add(centerCreateEmployeePanel, BorderLayout.CENTER);

                return employeeCreatePanel;
        }

        private void configureTopPanel() {
                panelTopCreateEmployee.setLayout(new FlowLayout(FlowLayout.CENTER));
                labTitleEmployeeCreate.setFont(new Font("Segoe UI", Font.BOLD, 36));
                labTitleEmployeeCreate.setForeground(new Color(30, 60, 90));
                panelTopCreateEmployee.add(labTitleEmployeeCreate);
        }

        private void configureCenterPanel() {
                centerCreateEmployeePanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.fill = GridBagConstraints.HORIZONTAL;

                Font labelFont = new Font("Segoe UI", Font.BOLD, 14); // Font chữ đậm và to hơn

                // Nhập tên
                labInputCreateEmployee.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 0;
                centerCreateEmployeePanel.add(labInputCreateEmployee, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                inputNameEmployee.setPreferredSize(new Dimension(200, 30));
                centerCreateEmployeePanel.add(inputNameEmployee, gbc);

                // Nhập UserName
                labEmployeeUser.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 1;
                centerCreateEmployeePanel.add(labEmployeeUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 1;
                inputUserNameCreate.setPreferredSize(new Dimension(200, 30));
                centerCreateEmployeePanel.add(inputUserNameCreate, gbc);

                // Nhập Email
                labEmailCreateUser.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerCreateEmployeePanel.add(labEmailCreateUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 2;
                inputEmailUserCreate.setPreferredSize(new Dimension(200, 30));
                centerCreateEmployeePanel.add(inputEmailUserCreate, gbc);

                // Nhập Password
                labPasswordCreateUser.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerCreateEmployeePanel.add(labPasswordCreateUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 3;
                inputPasswordCreateUser.setPreferredSize(new Dimension(200, 30));
                centerCreateEmployeePanel.add(inputPasswordCreateUser, gbc);

                // Nhập chức vụ
                labILevelUser.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerCreateEmployeePanel.add(labILevelUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                JcomeLevelUser.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("admin", "Admin"),
                                new Item("manager", "Manager"),
                                new Item("staff", "Staff")
                }));
                JcomeLevelUser.setPreferredSize(new Dimension(200, 30));
                centerCreateEmployeePanel.add(JcomeLevelUser, gbc);

                // Chọn trạng thái
                labStatusUserCreate.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerCreateEmployeePanel.add(labStatusUserCreate, gbc);

                gbc.gridx = 1;
                gbc.gridy = 5;
                JcomeStatusCreateUser.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("active", "Active"),
                                new Item("inactive", "Inactive"),
                                new Item("suspended", "Suspended")
                }));
                JcomeStatusCreateUser.setPreferredSize(new Dimension(200, 30));
                centerCreateEmployeePanel.add(JcomeStatusCreateUser, gbc);

                // Nhập mô tả
                labDescriptionCreateUser.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerCreateEmployeePanel.add(labDescriptionCreateUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 6;
                textAreaCreateUser.setRows(5);
                textAreaCreateUser.setColumns(20);
                scrollPaneDescription.setViewportView(textAreaCreateUser);
                centerCreateEmployeePanel.add(scrollPaneDescription, gbc);

                // Nút Tạo và Quay lại
                gbc.gridx = 0;
                gbc.gridy = 7;
                btnBackCreateUser.setBackground(Color.RED);
                btnBackCreateUser.setFont(labelFont);
                btnBackCreateUser.setForeground(Color.white);
                centerCreateEmployeePanel.add(btnBackCreateUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 7;
                btnCreateUser.setBackground(new Color(30, 60, 90));
                btnCreateUser.setFont(labelFont);
                btnCreateUser.setForeground(Color.WHITE);
                centerCreateEmployeePanel.add(btnCreateUser, gbc);
        }

        public String getNameEmployee() {
                return inputNameEmployee.getText();
        }

        public String getUserNameEmployee() {
                return inputUserNameCreate.getText();
        }

        public String getEmailEmployee() {
                return inputEmailUserCreate.getText();
        }

        public String getPasswordEmployee() {
                return new String(inputPasswordCreateUser.getPassword());
        }

        public String getLevelEmployee() {
                Item selectedItem = (Item) JcomeLevelUser.getSelectedItem();
                return selectedItem.getKey();
        }

        public String getStatusEmployee() {
                Item selectedItem = (Item) JcomeStatusCreateUser.getSelectedItem();
                return selectedItem.getKey();
        }

        public String getDescriptionEmployee() {
                return textAreaCreateUser.getText();
        }

        public void actionbtnBackCreateUser(ActionListener e) {
                btnBackCreateUser.addActionListener(e);
        }

        public void actionbtnCreateUser(ActionListener e) {
                btnCreateUser.addActionListener(e);
        }

        public void clearData() {
                inputNameEmployee.setText("");
                inputUserNameCreate.setText("");
                inputEmailUserCreate.setText("");
                inputPasswordCreateUser.setText("");
                JcomeLevelUser.setSelectedItem(0);
                JcomeStatusCreateUser.setSelectedItem(0);
                textAreaCreateUser.setText("");

        }
}