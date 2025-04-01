package com.example.controllers;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.Payroll;

public class PayrollController {

    //  Tính tổng lương cho từng nhân viên vào cuối tháng
    public boolean calculatePayroll(int month, int year) {
        String query = "INSERT INTO Payroll (EmployeeID, Month, Year, TotalSalary) " +
                       "SELECT EmployeeID, ?, ?, SUM(SalaryPerDay) " +
                       "FROM Timekeeping " +
                       "WHERE MONTH(WorkDate) = ? AND YEAR(WorkDate) = ? " +
                       "GROUP BY EmployeeID " +
                       "ON DUPLICATE KEY UPDATE TotalSalary = VALUES(TotalSalary)";
                        
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, month);
            pstmt.setInt(2, year);
            pstmt.setInt(3, month);
            pstmt.setInt(4, year);
            
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //  Lấy danh sách bảng lương theo tháng & năm
    public List<Payroll> getPayrollByMonth(int month, int year) {
        List<Payroll> payrollList = new ArrayList<>();
        String query = "SELECT * FROM Payroll WHERE Month = ? AND Year = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, month);
            pstmt.setInt(2, year);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Payroll payroll = new Payroll(
                    rs.getInt("PayrollID"),
                    rs.getInt("EmployeeID"),
                    rs.getInt("Month"),
                    rs.getInt("Year"),
                    rs.getDouble("TotalSalary")
                );
                payrollList.add(payroll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payrollList;
    }

    //  Cập nhật lương của một nhân viên
    public boolean updatePayroll(int employeeID, int month, int year, double totalSalary) {
        String query = "INSERT INTO Payroll (EmployeeID, Month, Year, TotalSalary) " +
                       "VALUES (?, ?, ?, ?) " +
                       "ON DUPLICATE KEY UPDATE TotalSalary = VALUES(TotalSalary)";
        
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, employeeID);
            pstmt.setInt(2, month);
            pstmt.setInt(3, year);
            pstmt.setDouble(4, totalSalary);
            
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // public static void main(String[] args) {
    //     PayrollController payrollController = new PayrollController();
    //     int month = 3, year = 2025;

    //     // 🏆 1. Tính tổng lương cho nhân viên trong tháng
    //     boolean payrollCalculated = payrollController.calculatePayroll(month, year);
    //     if (payrollCalculated) {
    //         System.out.println("✅ Đã tính lương tháng " + month + "/" + year);
    //     } else {
    //         System.out.println("❌ Lỗi khi tính lương!");
    //     }

    //     // 📋 2. Lấy danh sách bảng lương
    //     List<Payroll> payrollList = payrollController.getPayrollByMonth(month, year);
    //     if (payrollList.isEmpty()) {
    //         System.out.println("❌ Không có dữ liệu lương!");
    //     } else {
    //         System.out.println("📊 Danh sách bảng lương tháng " + month + "/" + year + ":");
    //         for (Payroll payroll : payrollList) {
    //             System.out.println("🆔 Payroll ID: " + payroll.getPayrollID() +
    //                                ", Employee ID: " + payroll.getEmployeeID() +
    //                                ", Tổng lương: " + payroll.getTotalSalary());
    //         }
    //     }

    //     // 🔄 3. Cập nhật lương cho nhân viên ID = 1
    //     boolean updated = payrollController.updatePayroll(1, month, year, 15000000);
    //     if (updated) {
    //         System.out.println("✅ Cập nhật lương nhân viên 1 thành công!");
    //     } else {
    //         System.out.println("❌ Lỗi khi cập nhật lương!");
    //     }
    // }
}
