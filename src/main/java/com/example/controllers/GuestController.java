package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.Guest;

public class GuestController {

    // tạo khách hàng
    public Boolean createGuest(Guest guest) {
        String query = "INSERT into guests (fullName, email, phone, address) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, guest.getFullName());
            pstmt.setString(2, guest.getEmail());
            pstmt.setString(3, guest.getPhone());
            pstmt.setString(4, guest.getAddress());
            int rs = pstmt.executeUpdate();
            return rs > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // kết thúc tạo khách hàng


    // Sửa thông tin khách hàng 
    public Boolean updateGuest(Guest guest, int id) {
        String query = "UPDATE guests SET fullName = COALESCE(?, fullName), " +
                       "email = COALESCE(?, email), " +
                       "phone = COALESCE(?, phone), " +
                       "address = COALESCE(?, address), " +
                       "updatedAt = CURRENT_TIMESTAMP " +
                       "WHERE id = ?";
    
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
    
         
            Guest currentGuest = getGuestById(id);
            if (currentGuest == null) {
                return false; 
            }
    
            pstmt.setString(1, guest.getFullName() != null && !guest.getFullName().isEmpty() ? guest.getFullName() : currentGuest.getFullName());
            pstmt.setString(2, guest.getEmail() != null && !guest.getEmail().isEmpty() ? guest.getEmail() : currentGuest.getEmail());
            pstmt.setString(3, guest.getPhone() != null && !guest.getPhone().isEmpty() ? guest.getPhone() : currentGuest.getPhone());
            pstmt.setString(4, guest.getAddress() != null && !guest.getAddress().isEmpty() ? guest.getAddress() : currentGuest.getAddress());
            pstmt.setInt(5, id);
    
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
     // Lấy danh sách tất cả khách hàng
    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<Guest>();
        String query = "SELECT * FROM guests";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Guest guest = new Guest();
                guest.setId(rs.getInt("id"));
                guest.setFullName(rs.getString("fullName"));
                guest.setEmail(rs.getString("email"));
                guest.setPhone(rs.getString("phone"));
                guest.setAddress(rs.getString("address"));
                guests.add(guest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guests;
    }
    // Lấy thông tin khách hàng qua id 
    public Guest getGuestById(int id) {
        String query = "SELECT * FROM guests WHERE id = ?";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Guest guest = new Guest();
                    guest.setId(rs.getInt("id"));
                    guest.setFullName(rs.getString("fullName"));
                    guest.setEmail(rs.getString("email"));
                    guest.setPhone(rs.getString("phone"));
                    guest.setAddress(rs.getString("address"));
                    return guest;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    
}
