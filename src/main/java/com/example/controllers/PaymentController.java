package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.config.DBconnection;

public class PaymentController {
    public Boolean createPayment(int bookingId, double amonut, String paymentMethod) {
        String query = """
                Insert into payments (bookingId, amount, paymentMethod ) values(?, ? ,?)
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, bookingId);
            pstmt.setDouble(2, amonut);
            pstmt.setString(3, paymentMethod);
            int rs = pstmt.executeUpdate();
            return rs > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // thay đổi trạng thái hóa đơn
    public Boolean changeStatus(int idBooking, String status) {
        String query = """
                update payments set status = ? where bookingId = ?;
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, idBooking);
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // hết thay đổi trạng thái hóa đơn
}
