package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.Room;

public class RoomsController {
    public static List<Room> listRooms() {
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
}
