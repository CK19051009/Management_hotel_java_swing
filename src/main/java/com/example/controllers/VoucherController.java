package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.helper.GenerateCodeVoucher;
import com.example.models.Room;
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

    public List<Voucher> listVouchers() {
        List<Voucher> vouchers = new ArrayList<Voucher>();
        String query = "SELECT * FROM vouchers where isDeleted = 0";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setId(rs.getInt("id"));
                voucher.setCode(rs.getString("code"));
                voucher.setDescription(rs.getString("description"));
                voucher.setDiscountType(rs.getString("discountType"));
                voucher.setDiscountValue(rs.getDouble("discountValue"));
                voucher.setMinOrderValue(rs.getDouble("minOrderValue"));
                voucher.setMaxDiscountValue(rs.getDouble("maxDiscountValue"));
                voucher.setStatus(rs.getString("status"));
                voucher.setStartDate(rs.getDate("startDate"));
                voucher.setEndDate(rs.getDate("endDate"));
                voucher.setUsageLimit(rs.getInt("usageLimit"));
                vouchers.add(voucher);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }

    // chỉnh sửa voucher
    public Boolean updateVoucher(Voucher voucher, int id) {
        String query = """
                update vouchers set
                description = COALESCE(?, description),
                discountType = COALESCE(?, discountType),
                discountValue = COALESCE(?, discountValue),
                minOrderValue = COALESCE(?, minOrderValue),
                maxDiscountValue = COALESCE(?, maxDiscountValue),
                startDate = COALESCE(?, startDate),
                endDate = COALESCE(?, endDate),
                status = COALESCE(?, status),
                usageLimit = COALESCE(?, usageLimit)
                where id = ?
                """;
        Voucher currentVoucher = detailVoucher(id, "active");
        if (currentVoucher == null) {
            return false;
        }
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1,
                    (voucher.getDescription() != null && !voucher.getDescription().isEmpty()) ? voucher.getDescription()
                            : currentVoucher.getDescription());

            pstmt.setString(2,
                    (voucher.getDiscountType() != null && !voucher.getDiscountType().isEmpty())
                            ? voucher.getDiscountType()
                            : currentVoucher.getDiscountType());
            pstmt.setDouble(3, (voucher.getDiscountValue() != 0) ? voucher.getDiscountValue()
                    : currentVoucher.getDiscountValue());
            pstmt.setDouble(4, (voucher.getMinOrderValue() != 0) ? voucher.getMinOrderValue()
                    : currentVoucher.getMinOrderValue());
            pstmt.setDouble(5, (voucher.getMaxDiscountValue() != 0) ? voucher.getMaxDiscountValue()
                    : currentVoucher.getMaxDiscountValue());
            pstmt.setDate(6, (voucher.getStartDate() != null) ? voucher.getStartDate()
                    : currentVoucher.getStartDate());
            pstmt.setDate(7, (voucher.getEndDate() != null) ? voucher.getEndDate()
                    : currentVoucher.getEndDate());
            pstmt.setString(8, (voucher.getStatus() != null) ? voucher.getStatus()
                    : currentVoucher.getStatus());
            pstmt.setInt(9, (voucher.getUsageLimit() != 0) ? voucher.getUsageLimit()
                    : currentVoucher.getUsageLimit());
            pstmt.setInt(10, id);
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteVoucher(int id) {
        String query = "UPDATE vouchers SET isDeleted = 1, updatedAt = CURRENT_TIMESTAMP WHERE id = ? AND isDeleted = 0";

        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Voucher> getVouchersByStatus(String status) {
        List<Voucher> vouchers = new ArrayList<>();
        String query = "SELECT * FROM vouchers WHERE LOWER(status) = LOWER(?) AND isDeleted = 0";
    
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, status);
            ResultSet result = pstmt.executeQuery();
    
            while (result.next()) {
                Voucher voucher = new Voucher();
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
                vouchers.add(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }
    
    // Lấy ra voucher cũ nhất
    public List<Voucher> getVouchersSortedByOldest() {
        String query = "SELECT * FROM vouchers WHERE isDeleted = 0 ORDER BY startDate ASC";
        List<Voucher> vouchers = new ArrayList<>();
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setId(rs.getInt("id"));
                voucher.setCode(rs.getString("code"));
                voucher.setDescription(rs.getString("description"));
                voucher.setDiscountType(rs.getString("discountType"));
                voucher.setDiscountValue(rs.getDouble("discountValue"));
                voucher.setMinOrderValue(rs.getDouble("minOrderValue"));
                voucher.setMaxDiscountValue(rs.getDouble("maxDiscountValue"));
                voucher.setStatus(rs.getString("status"));
                voucher.setStartDate(rs.getDate("startDate"));
                voucher.setEndDate(rs.getDate("endDate"));
                voucher.setUsageLimit(rs.getInt("usageLimit"));
                vouchers.add(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }
    
    // Lấy voucher ngày mới nhất
    public List<Voucher> getVouchersSortedByNewest() {
        String query = "SELECT * FROM vouchers WHERE isDeleted = 0 ORDER BY startDate DESC";
        List<Voucher> vouchers = new ArrayList<>();
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setId(rs.getInt("id"));
                voucher.setCode(rs.getString("code"));
                voucher.setDescription(rs.getString("description"));
                voucher.setDiscountType(rs.getString("discountType"));
                voucher.setDiscountValue(rs.getDouble("discountValue"));
                voucher.setMinOrderValue(rs.getDouble("minOrderValue"));
                voucher.setMaxDiscountValue(rs.getDouble("maxDiscountValue"));
                voucher.setStatus(rs.getString("status"));
                voucher.setStartDate(rs.getDate("startDate"));
                voucher.setEndDate(rs.getDate("endDate"));
                voucher.setUsageLimit(rs.getInt("usageLimit"));
                vouchers.add(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }

    
    // lấy ra giá trị vouchẻ cao nhấtnhất
    public Voucher getHighestDiscountVoucher() {
        String query = "SELECT * FROM vouchers WHERE isDeleted = 0 ORDER BY discountValue DESC LIMIT 1";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setId(rs.getInt("id"));
                voucher.setCode(rs.getString("code"));
                voucher.setDescription(rs.getString("description"));
                voucher.setDiscountType(rs.getString("discountType"));
                voucher.setDiscountValue(rs.getDouble("discountValue"));
                voucher.setMinOrderValue(rs.getDouble("minOrderValue"));
                voucher.setMaxDiscountValue(rs.getDouble("maxDiscountValue"));
                voucher.setStatus(rs.getString("status"));
                voucher.setStartDate(rs.getDate("startDate"));
                voucher.setEndDate(rs.getDate("endDate"));
                voucher.setUsageLimit(rs.getInt("usageLimit"));
                return voucher; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    // tìm kiếm theo mãmã
    public List<Voucher> searchVouchersByCode(String voucherCode) {
        List<Voucher> vouchers = new ArrayList<>();
        String query = "SELECT * FROM vouchers WHERE LOWER(code) LIKE LOWER(?) AND isDeleted = 0";
    
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, "%" + voucherCode + "%"); 
            ResultSet result = pstmt.executeQuery();
    
            while (result.next()) {
                Voucher voucher = new Voucher();
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
                vouchers.add(voucher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }
    
}
// hết chỉnh sửa voucher
