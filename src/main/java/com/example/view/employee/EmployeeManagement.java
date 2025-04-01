package com.example.view.employee;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import com.example.controllers.EmployeeController;
import com.example.models.Employee;

public class EmployeeManagement {

        private JPanel employeePanel = new JPanel();
        private JPanel topPanel = new JPanel();
        private JPanel centerPanel = new JPanel();
        private JPanel paginationPanel = new JPanel();
        private JLabel titleLabel = new JLabel("Quản lý nhân viên");
        private JComboBox<String> statusComboBox = new JComboBox<>();
        private JTextField searchField = new JTextField();
        private JButton searchButton = new JButton("Tìm kiếm");
        private JComboBox<String> sortComboBox = new JComboBox<>();
        private JButton sortButton = new JButton("Áp dụng");
        private JButton addButton = new JButton("Thêm");
        private JButton editButton = new JButton("Chỉnh sửa");
        private JButton deleteButton = new JButton("Xóa");
        private JButton salaryButton = new JButton("Tính lương");
        private JTable employeeTable = new JTable();
        private JScrollPane tableScrollPane = new JScrollPane();
        private DefaultTableModel tableModel;
        private EmployeeController employeeController = new EmployeeController();

        public JPanel renderEmployeePanel() {
                // Cấu hình employeePanel
                employeePanel.setPreferredSize(new Dimension(1100, 700));
                employeePanel.setLayout(new BorderLayout());

                // Cấu hình topPanel
                configureTopPanel();
                employeePanel.add(topPanel, BorderLayout.PAGE_START);

                // Cấu hình centerPanel
                configureCenterPanel();
                employeePanel.add(centerPanel, BorderLayout.CENTER);

                return employeePanel;
        }

        private void configureTopPanel() {
                topPanel.setPreferredSize(new Dimension(1100, 100));
                topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

                // Tiêu đề
                titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
                titleLabel.setForeground(new Color(30, 60, 90));
                topPanel.add(titleLabel);

                // ComboBox trạng thái
                statusComboBox.setModel(
                                new DefaultComboBoxModel<>(new String[] { "Tất cả", "Hoạt động", "Nghỉ việc" }));
                statusComboBox.setPreferredSize(new Dimension(150, 25));
                topPanel.add(statusComboBox);

                // Trường tìm kiếm
                searchField.setPreferredSize(new Dimension(150, 25));
                topPanel.add(searchField);

                // Nút tìm kiếm
                searchButton.setBackground(new Color(30, 60, 90));
                searchButton.setForeground(Color.WHITE);
                searchButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topPanel.add(searchButton);

                // ComboBox sắp xếp
                sortComboBox.setModel(new DefaultComboBoxModel<>(
                                new String[] { "Tên A-Z", "Tên Z-A", "Cấp bậc tăng dần", "Cấp bậc giảm dần" }));
                sortComboBox.setPreferredSize(new Dimension(150, 25));
                topPanel.add(sortComboBox);

                // Nút áp dụng sắp xếp
                sortButton.setBackground(new Color(30, 60, 90));
                sortButton.setForeground(Color.WHITE);
                sortButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topPanel.add(sortButton);

                // Nút thêm nhân viên
                addButton.setBackground(new Color(30, 60, 90));
                addButton.setForeground(Color.WHITE);
                addButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topPanel.add(addButton);

                // Nút chỉnh sửa nhân viên
                editButton.setBackground(new Color(153, 255, 153));
                editButton.setForeground(Color.WHITE);
                editButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topPanel.add(editButton);

                // Nút xóa nhân viên
                deleteButton.setBackground(new Color(255, 0, 51));
                deleteButton.setForeground(Color.WHITE);
                deleteButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topPanel.add(deleteButton);

                // Nút tính lương
                salaryButton.setBackground(new Color(255, 51, 51));
                salaryButton.setForeground(Color.WHITE);
                salaryButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topPanel.add(salaryButton);
        }

        private void configureCenterPanel() {
                centerPanel.setLayout(new BorderLayout());

                // Cấu hình bảng
                String[] columnNames = { "STT", "Họ và tên", "User Name", "Email", "Cấp bậc", "Trạng thái" };
                tableModel = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int col) {
                                return false;
                        }
                };
                employeeTable.setModel(tableModel);
                employeeTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                employeeTable.setRowHeight(25);

                // Thêm dữ liệu vào bảng
                refreshTable();

                // Thêm bảng vào JScrollPane
                tableScrollPane.setViewportView(employeeTable);
                centerPanel.add(tableScrollPane, BorderLayout.CENTER);

                // Cấu hình paginationPanel
                configurePaginationPanel();
                centerPanel.add(paginationPanel, BorderLayout.PAGE_END);
        }

        private void configurePaginationPanel() {
                paginationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

                // Tạo các nút phân trang
                for (int i = 1; i <= 5; i++) {
                        JButton pageButton = new JButton(String.valueOf(i));
                        pageButton.setPreferredSize(new Dimension(40, 30));
                        paginationPanel.add(pageButton);

                        // Xử lý sự kiện khi nhấn nút phân trang
                        pageButton.addActionListener(e -> {
                                System.out.println("Chuyển đến trang: " + pageButton.getText());
                                // TODO: Thực hiện logic phân trang
                        });
                }
        }

        public void refreshTable() {
                tableModel.setRowCount(0); // Xóa dữ liệu cũ trong bảng
                List<Employee> employees = employeeController.listEmployee(); // Lấy danh sách nhân viên mới
                for (Employee employee : employees) {
                        addEmployeeToTable(employee);
                }
                employeeTable.revalidate();
                employeeTable.repaint();
        }

        private void addEmployeeToTable(Employee employee) {
                tableModel.addRow(new Object[] {
                                employee.getId(),
                                employee.getFullName(),
                                employee.getUserName(),
                                employee.getEmail(),
                                employee.getLevelUser(),
                                employee.getStatus()
                });
        }

        public Employee getSelectedEmployee() {
                int selectedRow = employeeTable.getSelectedRow(); // Lấy chỉ số dòng được chọn
                if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn một nhân viên!");
                        return null;
                }

                // Lấy thông tin từ các cột trong dòng được chọn
                Employee employee = new Employee();
                employee.setId((int) tableModel.getValueAt(selectedRow, 0));
                employee.setFullName((String) tableModel.getValueAt(selectedRow, 1));
                employee.setUserName((String) tableModel.getValueAt(selectedRow, 2));
                employee.setEmail((String) tableModel.getValueAt(selectedRow, 3));
                employee.setLevelUser((String) tableModel.getValueAt(selectedRow, 4));
                employee.setStatus((String) tableModel.getValueAt(selectedRow, 5));
                return employee;
        }

        // Sự kiện
        public void actionAddEmployee(ActionListener e) {
                addButton.addActionListener(e);
        }

        public void actionEditEmployee(ActionListener e) {
                editButton.addActionListener(e);
        }

        public void actionDeleteEmployee(ActionListener e) {
                deleteButton.addActionListener(e);
        }
}