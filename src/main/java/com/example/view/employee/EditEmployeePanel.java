package com.example.view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import com.example.controllers.EmployeeController;
import com.example.helper.Item;
import com.example.models.Employee;

public class EditEmployeePanel {

        private JPanel employeeEditPanel = new JPanel();
        private JLabel labTitleEmployeeEdit = new JLabel("Chỉnh sửa nhân viên");
        private JPanel panelTopEditEmployee = new JPanel();
        private JPanel centerEditEmployeePanel = new JPanel();

        // Các thành phần giao diện
        private JLabel labInputEditEmployee = new JLabel("Nhập tên:");
        private JTextField inputNameEmployeeEdit = new JTextField();

        private JLabel labEmployeeUserEdit = new JLabel("Nhập UserName:");
        private JTextField inputUserNameEdit = new JTextField();

        private JLabel labEmailEditUser = new JLabel("Nhập Email:");
        private JTextField inputEmailUserEdit = new JTextField();

        private JLabel labPasswordEditUser = new JLabel("Nhập password:");
        private JPasswordField inputPasswordEditUser = new JPasswordField();

        private JLabel labILevelUserEdit = new JLabel("Nhập chức vụ:");
        private JComboBox<Item> JcomeLevelUserEdit = new JComboBox<>();

        private JLabel labStatusUserEdit = new JLabel("Chọn trạng thái:");
        private JComboBox<Item> JcomeStatusEditUser = new JComboBox<>();

        private JLabel labDescriptionEditUser = new JLabel("Nhập mô tả:");
        private JTextArea textAreaDescriptionEditUser = new JTextArea();
        private JScrollPane scrollPaneDescription = new JScrollPane();

        private JButton btnEditUser = new JButton("Lưu");
        private JButton btnBackEditUser = new JButton("Quay lại");

        private EmployeeController employeeController = new EmployeeController();

        public JPanel editEmployee() {
                // Cấu hình panel chính
                employeeEditPanel.setLayout(new BorderLayout());

                // Cấu hình panel tiêu đề
                configureTopPanel();
                employeeEditPanel.add(panelTopEditEmployee, BorderLayout.PAGE_START);

                // Cấu hình panel trung tâm
                configureCenterPanel();
                employeeEditPanel.add(centerEditEmployeePanel, BorderLayout.CENTER);

                return employeeEditPanel;
        }

        private void configureTopPanel() {
                panelTopEditEmployee.setLayout(new FlowLayout(FlowLayout.CENTER));
                labTitleEmployeeEdit.setFont(new Font("Segoe UI", Font.BOLD, 36));
                labTitleEmployeeEdit.setForeground(new Color(30, 60, 90));
                panelTopEditEmployee.add(labTitleEmployeeEdit);
        }

        private void configureCenterPanel() {
                centerEditEmployeePanel.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                Font labelFont = new Font("Segoe UI", Font.BOLD, 14);

                // Nhập tên
                labInputEditEmployee.setFont(labelFont);
                labInputEditEmployee.setForeground(new Color(30, 60, 90));
                gbc.gridx = 0;
                gbc.gridy = 0;
                centerEditEmployeePanel.add(labInputEditEmployee, gbc);

                gbc.gridx = 1;
                gbc.gridy = 0;
                inputNameEmployeeEdit.setPreferredSize(new Dimension(200, 30));
                centerEditEmployeePanel.add(inputNameEmployeeEdit, gbc);

                // Nhập UserName
                labEmployeeUserEdit.setFont(labelFont);
                labEmployeeUserEdit.setForeground(new Color(30, 60, 90));
                gbc.gridx = 0;
                gbc.gridy = 1;
                centerEditEmployeePanel.add(labEmployeeUserEdit, gbc);

                gbc.gridx = 1;
                gbc.gridy = 1;
                inputUserNameEdit.setPreferredSize(new Dimension(200, 30));
                centerEditEmployeePanel.add(inputUserNameEdit, gbc);

                // Nhập Email
                labEmailEditUser.setForeground(new Color(30, 60, 90));
                labEmailEditUser.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 2;
                centerEditEmployeePanel.add(labEmailEditUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 2;
                inputEmailUserEdit.setPreferredSize(new Dimension(200, 30));
                centerEditEmployeePanel.add(inputEmailUserEdit, gbc);

                // Nhập Password
                labPasswordEditUser.setForeground(new Color(30, 60, 90));
                labPasswordEditUser.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 3;
                centerEditEmployeePanel.add(labPasswordEditUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 3;
                inputPasswordEditUser.setPreferredSize(new Dimension(200, 30));
                centerEditEmployeePanel.add(inputPasswordEditUser, gbc);

                // Nhập chức vụ
                labILevelUserEdit.setForeground(new Color(30, 60, 90));
                labILevelUserEdit.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 4;
                centerEditEmployeePanel.add(labILevelUserEdit, gbc);

                gbc.gridx = 1;
                gbc.gridy = 4;
                JcomeLevelUserEdit.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("admin", "Admin"),
                                new Item("manager", "Manager"),
                                new Item("staff", "Staff")
                }));
                JcomeLevelUserEdit.setPreferredSize(new Dimension(200, 30));
                centerEditEmployeePanel.add(JcomeLevelUserEdit, gbc);

                // Chọn trạng thái
                labStatusUserEdit.setForeground(new Color(30, 60, 90));
                labStatusUserEdit.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 5;
                centerEditEmployeePanel.add(labStatusUserEdit, gbc);

                gbc.gridx = 1;
                gbc.gridy = 5;
                JcomeStatusEditUser.setModel(new DefaultComboBoxModel<>(new Item[] {
                                new Item("active", "Active"),
                                new Item("inactive", "Inactive"),
                                new Item("suspended", "Suspended")
                }));
                JcomeStatusEditUser.setPreferredSize(new Dimension(200, 30));
                centerEditEmployeePanel.add(JcomeStatusEditUser, gbc);

                // Nhập mô tả
                labDescriptionEditUser.setForeground(new Color(30, 60, 90));
                labDescriptionEditUser.setFont(labelFont);
                gbc.gridx = 0;
                gbc.gridy = 6;
                centerEditEmployeePanel.add(labDescriptionEditUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 6;
                textAreaDescriptionEditUser.setRows(5);
                textAreaDescriptionEditUser.setColumns(20);
                scrollPaneDescription.setViewportView(textAreaDescriptionEditUser);
                centerEditEmployeePanel.add(scrollPaneDescription, gbc);

                // Nút Lưu và Quay lại
                gbc.gridx = 0;
                gbc.gridy = 7;
                btnBackEditUser.setFont(labelFont);
                btnBackEditUser.setForeground(Color.WHITE);
                btnBackEditUser.setBackground(Color.RED);
                centerEditEmployeePanel.add(btnBackEditUser, gbc);

                gbc.gridx = 1;
                gbc.gridy = 7;
                btnEditUser.setFont(labelFont);
                btnEditUser.setForeground(Color.WHITE);
                btnEditUser.setBackground(new Color(30, 60, 90));
                centerEditEmployeePanel.add(btnEditUser, gbc);
        }

        public void setEmployee(Employee employee) {
                inputNameEmployeeEdit.setText(employee.getFullName());
                inputUserNameEdit.setText(employee.getUserName());
                inputEmailUserEdit.setText(employee.getEmail());

                // Đặt giá trị cho JComboBox levelUser
                for (int i = 0; i < JcomeLevelUserEdit.getItemCount(); i++) {
                        Item item = (Item) JcomeLevelUserEdit.getItemAt(i);
                        if (item.getKey().equals(employee.getLevelUser())) {
                                JcomeLevelUserEdit.setSelectedItem(item);
                                break;
                        }
                }

                // Đặt giá trị cho JComboBox status
                for (int i = 0; i < JcomeStatusEditUser.getItemCount(); i++) {
                        Item item = (Item) JcomeStatusEditUser.getItemAt(i);
                        if (item.getKey().equals(employee.getStatus())) {
                                JcomeStatusEditUser.setSelectedItem(item);
                                break;
                        }
                }
        }

        public void actionbtnBackEditUser(ActionListener e) {
                btnBackEditUser.addActionListener(e);
        }

        public void actionbtnEditUser(ActionListener e) {
                btnEditUser.addActionListener(e);
        }

        public String getNameEmployee() {
                return inputNameEmployeeEdit.getText();
        }

        public String getUserNameEmployee() {
                return inputUserNameEdit.getText();
        }

        public String getEmailEmployee() {
                return inputEmailUserEdit.getText();
        }

        public String getLevelEmployee() {
                Item selectedItem = (Item) JcomeLevelUserEdit.getSelectedItem();
                return selectedItem.getKey();
        }

        public String getStatusEmployee() {
                Item selectedItem = (Item) JcomeStatusEditUser.getSelectedItem();
                return selectedItem.getKey();
        }

        public String getPasswordEmployee() {
                char[] passArray = inputPasswordEditUser.getPassword();
                String passString = new String(passArray);
                return passString;
        }
}