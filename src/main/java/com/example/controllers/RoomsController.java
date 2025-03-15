package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.Employee;
import com.example.models.Room;

public class RoomsController {
    public List<Room> listRooms() {
        List<Room> rooms = new ArrayList<Room>();
        String query = "SELECT * FROM rooms where isDeleted = 0";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getString("roomNumber"));
                room.setRoomType(rs.getString("type"));
                room.setStatus(rs.getString("status"));
                room.setPrice(rs.getInt("price"));
                room.setThumbnail(rs.getString("thumbnail"));
                room.setDescription(rs.getString("description"));
                room.setCapacity(rs.getString("capacity"));
                room.setPosition(rs.getInt("position"));
                rooms.add(room);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Boolean createRoom(Room room) {
        String query = "INSERT INTO employees (roomNumber, type, status, price, description, capacity, position, thumbnail) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setString(3, room.getStatus());
            pstmt.setInt(4, room.getPrice());
            pstmt.setString(5, room.getDescription());
            pstmt.setString(6, room.getCapacity());
            pstmt.setInt(7, room.getPosition());
            pstmt.setString(8, room.getThumbnail());
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
