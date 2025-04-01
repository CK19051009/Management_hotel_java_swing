package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.BookingVoucher;

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

    public List<BookingVoucher> listVoucherApp(int bookingId) {
        String query = """
                select * from booking_voucher where bookingId = ?
                """;
        List<BookingVoucher> items = new ArrayList<>();
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookingId);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                BookingVoucher item = new BookingVoucher();
                item.setId(result.getInt("id"));
                item.setBookingId(result.getInt("bookingId"));
                item.setVoucherId(result.getInt("voucherId"));
                item.setTotalDiscount(result.getDouble("totalDiscount"));
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
