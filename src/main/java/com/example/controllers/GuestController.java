package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.config.DBconnection;
import com.example.models.Guest;

public class GuestController {

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
}
