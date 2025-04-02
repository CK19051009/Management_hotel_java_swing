package com.example.view.voucher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.VoucherController;
import com.example.models.Room;
import com.example.models.Voucher;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;

public class VoucherMainPanel {
        private DefaultTableModel tableModel;
        private JPanel voucherPanel = new JPanel();
        private JPanel topVoucherPanel = new JPanel();
        private JLabel labTitleVoucher = new JLabel("Quản lý voucher");
        private JComboBox<String> JcStatusVoucher = new JComboBox<>();
        private JTextField filedVoucher = new JTextField();
        private JButton btnSearchVoucher = new JButton("Tìm kiếm");
        private JComboBox<String> jcSortVoucher = new JComboBox<>();
        private JButton btnSortVoucher = new JButton("Áp dụng");
        private JButton btnEditVoucher = new JButton("Sửa voucher");
        private JButton btnAddVoucher = new JButton("Tạo voucher");
        private JButton btnDeleteVoucher = new JButton("Xóa voucher");
        private JPanel tableVoucherPanel = new JPanel();
        private JTable tableVoucher = new JTable();
        private JScrollPane jScrollPaneVoucher = new JScrollPane();
        private JPanel paginationPanel = new JPanel();
        VoucherController voucherController = new VoucherController();

        public JPanel voucherPanel() {
                // Cấu hình panel chính
                voucherPanel.setPreferredSize(new Dimension(1100, 700));
                voucherPanel.setLayout(new BorderLayout());

                // Cấu hình panel trên cùng
                configureTopPanel();
                voucherPanel.add(topVoucherPanel, BorderLayout.PAGE_START);

                // Cấu hình panel bảng
                configureTablePanel();
                voucherPanel.add(tableVoucherPanel, BorderLayout.CENTER);

                // Cấu hình panel phân trang
                configurePaginationPanel();
                voucherPanel.add(paginationPanel, BorderLayout.PAGE_END);

                return voucherPanel;
        }

        private void configureTopPanel() {
                topVoucherPanel.setPreferredSize(new Dimension(1100, 100));
                topVoucherPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

                labTitleVoucher.setFont(new Font("Segoe UI", Font.BOLD, 24));
                labTitleVoucher.setForeground(new Color(30, 60, 90));
                topVoucherPanel.add(labTitleVoucher);

                JcStatusVoucher.setModel(new DefaultComboBoxModel<>(new String[] { "Tất cả", "Hoạt động", "Hết hạn" }));
                JcStatusVoucher.setPreferredSize(new Dimension(150, 30));
                topVoucherPanel.add(JcStatusVoucher);
                JcStatusVoucher.addActionListener(e -> {
                        String selectedStatus = (String) JcStatusVoucher.getSelectedItem();
                        
                        // Chuyển trạng thái từ tiếng Việt sang giá trị trong database
                        String dbStatus = null;
                        if ("Hoạt động".equals(selectedStatus)) {
                            dbStatus = "active";
                        } else if ("Hết hạn".equals(selectedStatus)) {
                            dbStatus = "inactive";
                        }
                    
                        if (dbStatus == null) {
                            refreshTable(); 
                        } else {
                            filterVouchersByStatus(dbStatus); 
                        }
                    });
                    
                    


                filedVoucher.setPreferredSize(new Dimension(200, 30));
                topVoucherPanel.add(filedVoucher);

                btnSearchVoucher.setBackground(new Color(30, 60, 90));
                btnSearchVoucher.setForeground(Color.WHITE);
                btnSearchVoucher.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topVoucherPanel.add(btnSearchVoucher);
               
                btnSearchVoucher.addActionListener(e -> {      
        String searchText = filedVoucher.getText().toLowerCase();

        
        if (searchText.length() != 00) {
            List<Voucher> vouchers = voucherController.searchVouchersByCode(searchText);
            tableModel.setRowCount(0);  
            for (Voucher voucher : vouchers) {
                    addRoom(voucher, tableModel);
            } 
        } else {
            refreshTable();  
        }
    });
    

                jcSortVoucher.setModel(
                                new DefaultComboBoxModel<>(new String[] { "Mới nhất", "Cũ nhất", "Giá trị cao nhất" }));
                jcSortVoucher.setPreferredSize(new Dimension(150, 30));
                topVoucherPanel.add(jcSortVoucher);
               

                btnSortVoucher.setBackground(new Color(30, 60, 90));
                btnSortVoucher.setForeground(Color.WHITE);
                btnSortVoucher.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topVoucherPanel.add(btnSortVoucher);
                btnSortVoucher.addActionListener(e -> {
                       
                      
                        String selectedSortOption = (String) jcSortVoucher.getSelectedItem();
                        switch (selectedSortOption) {
                            case "Mới nhất":
                                sortVouchersByNewest();
                                break;
                            case "Cũ nhất":
                                sortVouchersByOldest();
                                break;
                            case "Giá trị cao nhất":
                                sortVouchersByHighestValue();
                                break;
                            default:
                                refreshTable(); 
                                break;
                        }
                    });
                btnDeleteVoucher.setBackground(new Color(255, 0, 51));
                btnDeleteVoucher.setForeground(Color.WHITE);
                btnDeleteVoucher.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topVoucherPanel.add(btnDeleteVoucher);

                btnEditVoucher.setBackground(new Color(153, 255, 153));
                btnEditVoucher.setForeground(Color.WHITE);
                btnEditVoucher.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topVoucherPanel.add(btnEditVoucher);

                btnAddVoucher.setBackground(new Color(30, 60, 90));
                btnAddVoucher.setForeground(Color.WHITE);
                btnAddVoucher.setFont(new Font("Segoe UI", Font.BOLD, 12));
                topVoucherPanel.add(btnAddVoucher);
        }

        private void configureTablePanel() {
                tableVoucherPanel.setLayout(new BorderLayout());

                // Cấu hình bảng
                String[] columnNames = { "STT", "Mã voucher", "Mô tả", "Loại giảm giá", "Giá trị", "Đơn hàng tối thiểu",
                                "Giảm tối đa", "Ngày bắt đầu", "Ngày kết thúc", "Số lần dùng", "Trạng thái" };
                tableModel = new DefaultTableModel(columnNames, 0) {
                        @Override
                        public boolean isCellEditable(int row, int col) {
                                return false;
                        }
                };

                tableVoucher.setModel(tableModel);
                tableVoucher.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                tableVoucher.setRowHeight(25);
                refreshTable();
                // Thêm bảng vào JScrollPane
                jScrollPaneVoucher.setViewportView(tableVoucher);
                tableVoucherPanel.add(jScrollPaneVoucher, BorderLayout.CENTER);
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

        // Các phương thức xử lý sự kiện
        public void actionAddVoucher(ActionListener e) {
                btnAddVoucher.addActionListener(e);
        }

        public void actionEditVoucher(ActionListener e) {
                btnEditVoucher.addActionListener(e);
        }

        public void actionDeleteVoucher(ActionListener e) {
                btnDeleteVoucher.addActionListener(e);
        }

        public void actionSearchVoucher(ActionListener e) {
                btnSearchVoucher.addActionListener(e);
        }

        public void actionSortVoucher(ActionListener e) {
                btnSortVoucher.addActionListener(e);
        }

        public String getSearchText() {
                return filedVoucher.getText();
        }

        public String getSelectedStatus() {
                return (String) JcStatusVoucher.getSelectedItem();
        }

        public String getSelectedSortOption() {
                return (String) jcSortVoucher.getSelectedItem();
        }

        private void addRoom(Voucher voucher, DefaultTableModel tableModel) {
                tableModel.addRow(new Object[] {
                                voucher.getId(),
                                voucher.getCode(),
                                voucher.getDescription(),
                                voucher.getDiscountType(),
                                voucher.getDiscountValue(),
                                voucher.getMinOrderValue(),
                                voucher.getMaxDiscountValue(),
                                voucher.getStartDate(), voucher.getEndDate(), voucher.getUsageLimit(),
                                voucher.getStatus()
                });
        }

        public void refreshTable() {
                tableModel.setRowCount(0); 
                List<Voucher> vouchers = voucherController.listVouchers();
                for (Voucher voucher : vouchers) {
                        addRoom(voucher, tableModel); // Thêm từng phòng vào bảng
                }
                tableVoucher.revalidate();
                tableVoucher.repaint();
        }

        public Voucher getSelectedVoucher() {
                int selectedRow = tableVoucher.getSelectedRow();
                Voucher voucher = new Voucher();
                if (selectedRow == -1) {

                        return voucher = null;
                }

                voucher.setId((int) tableModel.getValueAt(selectedRow, 0));
                voucher.setCode((String) tableModel.getValueAt(selectedRow, 1));
                voucher.setDescription((String) tableModel.getValueAt(selectedRow, 2));
                voucher.setDiscountType((String) tableModel.getValueAt(selectedRow, 3));
                voucher.setDiscountValue((Double) tableModel.getValueAt(selectedRow, 4));
                voucher.setMinOrderValue((Double) tableModel.getValueAt(selectedRow, 5));
                voucher.setMaxDiscountValue((Double) tableModel.getValueAt(selectedRow, 6));
                voucher.setStartDate((Date) tableModel.getValueAt(selectedRow, 7));
                voucher.setEndDate((Date) tableModel.getValueAt(selectedRow, 8));
                voucher.setUsageLimit((int) tableModel.getValueAt(selectedRow, 9));
                voucher.setStatus((String) tableModel.getValueAt(selectedRow, 10));

                return voucher;
        }

        private void filterVouchersByStatus(String status) {
                tableModel.setRowCount(0); 
            
                List<Voucher> vouchers = voucherController.getVouchersByStatus(status);
                for (Voucher voucher : vouchers) {
                    addRoom(voucher, tableModel);
                }
                
                tableVoucher.revalidate();
                tableVoucher.repaint();
            }

            private void sortVouchersByNewest() {
                tableModel.setRowCount(0); 
                List<Voucher> vouchers = voucherController.getVouchersSortedByNewest();
                for (Voucher voucher : vouchers) {
                    addRoom(voucher, tableModel); 
                }
                
            }
            
            private void sortVouchersByOldest() {
                tableModel.setRowCount(0); 
                List<Voucher> vouchers = voucherController.getVouchersSortedByOldest();
                for (Voucher voucher : vouchers) {
                    addRoom(voucher, tableModel); 
                }
              
            }
            
            private void sortVouchersByHighestValue() {
                tableModel.setRowCount(0); 
                Voucher vouchers = voucherController.getHighestDiscountVoucher();
                
                    addRoom(vouchers, tableModel);
                
            }
            
           
            
}