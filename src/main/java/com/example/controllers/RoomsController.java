package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.Room;
import com.example.models.Service;

public class RoomsController {
    // Lấy danh sách phòng
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
                room.setCapacity((rs.getInt("capacity")));
                ;
                room.setPosition(rs.getInt("position"));
                rooms.add(room);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
    // end lấy ra danh sách phòng

    // Tạo phòng
    public Boolean createRoom(Room room) {
        String query = "INSERT INTO rooms (roomNumber, type, status, price, description, capacity, position, thumbnail) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setString(3, room.getStatus());
            pstmt.setInt(4, room.getPrice());
            pstmt.setString(5, room.getDescription());
            pstmt.setInt(6, room.getCapacity());
            pstmt.setInt(7, room.getPosition());
            pstmt.setString(8, room.getThumbnail());
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // end Tạo phòng
    // Lấy ra phòng theo id
    public Room roomDetail(int id) {
        Room room = new Room();
        String query = "SELECT * FROM rooms where id = ? and isDeleted = 0";

        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getString("roomNumber"));
                room.setRoomType(rs.getString("type"));
                room.setStatus(rs.getString("status"));
                room.setPrice(rs.getInt("price"));
                room.setThumbnail(rs.getString("thumbnail"));
                room.setDescription(rs.getString("description"));
                room.setCapacity((rs.getInt("capacity")));
                ;
                room.setPosition(rs.getInt("position"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String queryServiceRoom = """
                select s.* , rs.quantity from services s join room_services rs on s.id = rs.serviceId where rs.roomId = ?;
                """;

        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(queryServiceRoom)) {
            pstmt.setInt(1, id);
            List<Service> services = new ArrayList<>();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setPrice(rs.getDouble("price"));
                service.setDescription(rs.getString("description"));
                service.setStatus(rs.getString("status"));
                service.setQuantity(rs.getInt("quantity"));
                services.add(service);
            }

            room.setServices(services);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return room;
    }
    // kết thức lấy ra phòng theo id
}
