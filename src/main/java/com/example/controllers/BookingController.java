package com.example.controllers;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.Booking;

public class BookingController {

    // tạo ra hóa đơn
    public Boolean createBookings(Booking booking) {

        String query = """
                insert into bookings (roomId, guestId, checkInDate,depositAmount) values (?,?,?,?);
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, booking.getRoomId());
            pstmt.setInt(2, booking.getGuestId());
            pstmt.setTimestamp(3, booking.getCheckIn());
            pstmt.setDouble(4, booking.getDepositAmount());
            int createBooking = pstmt.executeUpdate();
            if (createBooking > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    booking.setId(rs.getInt(1)); // Lấy ID tự động sinh
                }
                return true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;

    }
    // hết tạo ra hóa đơn

    // danh sách hóa đơn
    public List<Booking> listBooking() {
        String query = """
                Select * from bookings where status = 'pending'
                """;
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);) {
            // lấy ra các danh sách hóa đơn khách hàng đang sử dụng phòng
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Booking booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setGuestId(rs.getInt("guestId"));
                booking.setRoomId(rs.getInt("roomId"));
                booking.setCheckIn(rs.getTimestamp("checkInDate"));
                booking.setCheckOut(rs.getTimestamp("checkOutDate"));
                booking.setTotalAmount(rs.getDouble("totalAmount"));
                booking.setStatus(rs.getString("status"));
                booking.setDepositAmount(rs.getDouble("depositAmount"));
                booking.setVoucherId(rs.getInt("voucherId"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;

    }
    // hết danh sách hóa đơn

    // hóa đơn chi tiết
    public Booking detailBooking(int id, String status) {
        Booking booking = null;
        String query = """
                Select * from bookings where status = ? and id = ?;
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                booking = new Booking();
                booking.setId(rs.getInt("id"));
                booking.setGuestId(rs.getInt("guestId"));
                booking.setRoomId(rs.getInt("roomId"));
                booking.setCheckIn(rs.getTimestamp("checkInDate"));
                booking.setCheckOut(rs.getTimestamp("checkOutDate"));
                booking.setTotalAmount(rs.getDouble("totalAmount"));
                booking.setStatus(rs.getString("status"));
                booking.setDepositAmount(rs.getDouble("depositAmount"));
                booking.setVoucherId(rs.getInt("voucherId"));
                return booking;
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return booking;

    }
    // hết hóa đơn chi tiết

    // cập nhập trạng thái, check-out, tổng tiền khi thanh toán thành công
    public Boolean updateBookingPay(int bookingId, String stauts, Timestamp checkout, double totalAmount) {

        String query = """
                update bookings set status = ?, checkOutDate = ? ,totalAmount = ? where id = ?;
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, stauts);

            pstmt.setTimestamp(2, checkout);
            pstmt.setDouble(3, totalAmount);
            pstmt.setInt(4, bookingId);
            System.out.println("Executing query: " + pstmt.toString());
            int rs = pstmt.executeUpdate();
            return rs > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // hết cập nhập trạng thái, check-out, tổng tiền khi thanh toán thành công

}
