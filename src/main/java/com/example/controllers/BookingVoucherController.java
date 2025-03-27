package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.config.DBconnection;

public class BookingVoucherController {
    // tạo hóa đơn sử dụng dịch vụ
    public Boolean createBookingVoucher(int bookingId, int voucherId, double totalDiscount) {
        String query = """
                Insert into Booking_voucher (bookingId, voucherId, totalDiscount) values(?, ? ,?)
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookingId);
            pstmt.setInt(2, voucherId);
            pstmt.setDouble(3, totalDiscount);
            int rs = pstmt.executeUpdate();
            return rs > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // hết tạo hóa đơn sử dụng dịch vụ
}
