package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.config.DBconnection;
import com.example.models.BookingService;

public class BookingServiceController {
    // tạo dịch vụ muốn sử dụng
    public Boolean useService(BookingService serviced) {

        String query = """
                insert into booking_services (bookingId,serviceId,quantity) values (?,?,?);
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, serviced.getBookingId());
            pstmt.setInt(2, serviced.getServiceId());
            pstmt.setInt(3, serviced.getQuantity());
            int createBooking = pstmt.executeUpdate();
            return createBooking > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // hết tạo dịch vụ muốn sử dụng

    // kiểm tra dịch vụ đã tồn tại trong hóa đơn chưa
    public BookingService checkSerivced(int serviceId, int bookingId) {
        String query = """
                Select * from booking_services where serviceId = ?  and bookingId =  ?
                """;
        BookingService bookingService = null;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, serviceId);
            pstmt.setInt(2, bookingId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Nếu COUNT > 0, trả về true
                bookingService = new BookingService();
                bookingService.setBookingId(rs.getInt("bookingId"));
                bookingService.setServiceId(rs.getInt("serviceId"));
                bookingService.setQuantity(rs.getInt("quantity"));
                return bookingService;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingService;
    }
    // hết kiểm tra dịch vụ đã tồn tại trong hóa đơn chưa

    // cập nhập số lần sử dụng dịch vụ
    public Boolean updateQuantity(int quantityNew, int serviceId, int bookingId) {
        String query = """
                UPDATE booking_services SET quantity = ? where bookingId  = ? and serviceId = ? ;
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, quantityNew);
            pstmt.setInt(2, bookingId);
            pstmt.setInt(3, serviceId);
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // hết cập nhập số lần sử dụng dịch vụ

    // lấy ra danh sách dịch vụ khách hàng sử dụng trong quá trình đặt phòng
    public List<BookingService> listServiceUseOfBooking(int bookingId) {
        String query = """
                Select * from booking_services where bookingId = ?
                """;
        List<BookingService> list = new ArrayList<>();
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, bookingId);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                BookingService bookingService = new BookingService();
                bookingService.setBookingId(result.getInt("bookingId"));
                bookingService.setId(result.getInt("id"));
                bookingService.setServiceId(result.getInt("serviceId"));
                bookingService.setQuantity(result.getInt("quantity"));
                bookingService.setTotalPrice(result.getInt("totalPrice"));
                list.add(bookingService);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // hết lấy ra danh sách dịch vụ khách hàng sử dụng trong quá trình đặt phòng
    // xóa dịch vụ khỏi hóa đơn
    public Boolean deleteServiceOfBooking(int id, int bookingId) {
        String query = "DELETE FROM booking_services WHERE id = ? and bookingId = ? ";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, bookingId);
            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
