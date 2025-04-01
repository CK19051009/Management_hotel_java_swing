package com.example.controllers;
<<<<<<< HEAD
import com.example.config.DBconnection;
import com.example.models.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentController {
    
    // Lấy tất cả các hóa đơn
    public List<Payment> getPaymentByBooking() {
        List<Payment> paymentList = new ArrayList<>();
        String query = "SELECT * FROM payments";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setBookingId(rs.getInt("bookingId"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentMethod(rs.getString("paymentMethod"));
                payment.setPaymentStatus(rs.getString("paymentStatus"));
                payment.setCreatedAt(rs.getString("createdAt"));
                paymentList.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentList;
    }
    
    // Lấy ra hóa đơn theo id Booking
    public List<Payment> getPaymentByBookingId(int id) {
        List<Payment> paymentList = new ArrayList<>();
        String query = "SELECT * FROM payments WHERE bookingId = ?";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
           if (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setBookingId(rs.getInt("bookingId"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentMethod(rs.getString("paymentMethod"));
                payment.setPaymentStatus(rs.getString("paymentStatus"));
                payment.setCreatedAt(rs.getString("createdAt"));
                paymentList.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentList;
    }


    // Lấy danh sách hóa đơn trong 1 tuần
    // Lấy danh sách hóa đơn trong theo tháng trong năm
    public List<Payment> getPaymentListByDate(int year, int month) {
        List<Payment> paymentList = new ArrayList<>();
        String query = "SELECT * FROM payments WHERE YEAR(createdAt) = ? AND MONTH(createdAt) = ?";
        try (Connection conn = DBconnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) {
       pstmt.setInt(1, year);
       pstmt.setInt(2, month);
       ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
           Payment payment = new Payment();
           payment.setId(rs.getInt("id"));
           payment.setBookingId(rs.getInt("bookingId"));
           payment.setAmount(rs.getDouble("amount"));
           payment.setPaymentMethod(rs.getString("paymentMethod"));
           payment.setPaymentStatus(rs.getString("paymentStatus"));
           payment.setCreatedAt(rs.getString("createdAt"));
           paymentList.add(payment);
       }
   } catch (Exception e) {
       e.printStackTrace();
   }
   return paymentList;
    }

}
=======

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
>>>>>>> 75e75844812896365c94ef564d30ceb4e9e5345a
