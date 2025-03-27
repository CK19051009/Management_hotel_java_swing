package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.config.DBconnection;
import com.example.helper.GenerateCodeVoucher;
import com.example.models.Voucher;

public class VoucherController {
    // tạo mới voucher
    public Boolean createVoucher(Voucher voucher) {
        String query = """
                INSERT INTO vouchers (code, description, discountType, discountValue, minOrderValue, maxDiscountValue, startDate, endDate, usageLimit)
                VALUES(?,?,?,?,?,?,?,?,?);
                                """;
        GenerateCodeVoucher voucherHelper = new GenerateCodeVoucher();
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, voucherHelper.renderCodeVoucher());
            pstmt.setString(2, voucher.getDescription());
            pstmt.setString(3, voucher.getDiscountType());
            pstmt.setDouble(4, voucher.getDiscountValue());
            pstmt.setDouble(5, voucher.getMinOrderValue());
            pstmt.setDouble(6, voucher.getMaxDiscountValue());
            pstmt.setDate(7, voucher.getStartDate());
            pstmt.setDate(8, voucher.getEndDate());
            pstmt.setInt(9, voucher.getUsageLimit());
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // hết tạo mới voucher

    // lấy ra chi tiết 1 vouher có trạng thái là active
    public Voucher detailVoucher(int codeVoucher, String status) {
        Voucher voucher = null;
        String query = """
                Select * from vouchers where id = ? and status = ?
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, codeVoucher);
            pstmt.setString(2, status);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                voucher = new Voucher();
                voucher.setId(result.getInt("id"));
                voucher.setCode(result.getString("code"));
                voucher.setDescription(result.getString("description"));
                voucher.setDiscountType(result.getString("discountType"));
                voucher.setDiscountValue(result.getDouble("discountValue"));
                voucher.setMinOrderValue(result.getDouble("minOrderValue"));
                voucher.setMaxDiscountValue(result.getDouble("maxDiscountValue"));
                voucher.setStartDate(result.getDate("startDate"));
                voucher.setEndDate(result.getDate("endDate"));
                voucher.setStatus(result.getString("status"));
                voucher.setUsageLimit(result.getInt("usageLimit"));
                voucher.setUsedCount(result.getInt("usedCount"));
                return voucher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voucher;

    }
    // hết lấy ra chi tiết 1 vouher
}
