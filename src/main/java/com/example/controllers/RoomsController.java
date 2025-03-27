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
                room.setRoomNumber(rs.getInt("roomNumber"));
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
            pstmt.setInt(1, room.getRoomNumber());
            pstmt.setString(2, room.getRoomType());
            pstmt.setString(3, room.getStatus());
            pstmt.setDouble(4, room.getPrice());
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
        Room room = null;
        String query = "SELECT * FROM rooms where id = ? and isDeleted = 0";

        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getInt("roomNumber"));
                room.setRoomType(rs.getString("type"));
                room.setStatus(rs.getString("status"));
                room.setPrice(rs.getInt("price"));
                room.setThumbnail(rs.getString("thumbnail"));
                room.setDescription(rs.getString("description"));
                room.setCapacity((rs.getInt("capacity")));
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

    public Boolean updateRoom(Room room, int id) {
        String query = "UPDATE rooms SET "
                + "roomNumber = COALESCE(?, roomNumber), "
                + "type = COALESCE(?, type), "
                + "status = COALESCE(?, status), "
                + "price = COALESCE(?, price), "
                + "description = COALESCE(?, description), "
                + "capacity = COALESCE(?, capacity), "
                + "position = COALESCE(?, position), "
                + "thumbnail = COALESCE(?, thumbnail), "
                + "updatedAt = CURRENT_TIMESTAMP "
                + "WHERE id = ? AND isDeleted = 0";

        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            Room currentRoom = roomDetail(id);
            System.out.println(currentRoom);
            if (currentRoom == null) {
                return false;
            }
            // note chỗ đổi kiểu roomNumber
//            pstmt.setObject(1, (room.getRoomNumber() != null) ? room.getRoomNumber()
//                    : currentRoom.getRoomNumber(), java.sql.Types.INTEGER);
            pstmt.setString(2, (room.getRoomType() != null && !room.getRoomType().isEmpty()) ? room.getRoomType()
                    : currentRoom.getRoomType());
            pstmt.setString(3, (room.getStatus() != null && !room.getStatus().isEmpty()) ? room.getStatus()
                    : currentRoom.getStatus());
//            pstmt.setObject(4, (room.getPrice() != null) ? room.getPrice() : currentRoom.getPrice(),
//                    java.sql.Types.DOUBLE);
            pstmt.setString(5,
                    (room.getDescription() != null && !room.getDescription().isEmpty()) ? room.getDescription()
                            : currentRoom.getDescription());
            pstmt.setObject(6, (room.getCapacity() != null) ? room.getCapacity() : currentRoom.getCapacity(),
                    java.sql.Types.INTEGER);
            pstmt.setObject(7, (room.getPosition() != null) ? room.getPosition() : currentRoom.getPosition(),
                    java.sql.Types.INTEGER);
            pstmt.setString(8, (room.getThumbnail() != null && !room.getThumbnail().isEmpty()) ? room.getThumbnail()
                    : currentRoom.getThumbnail());
            pstmt.setInt(9, id);

            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa phòng
    public Boolean deleteRoom(int roomId) {
        String query = "UPDATE rooms SET isDeleted = 1, updatedAt = CURRENT_TIMESTAMP WHERE id = ? AND isDeleted = 0";

        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, roomId);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    // hết xóa phòng

    // tìm phòng đang được sử dụng
    public Room foundRoomUse(int roomNumber) {
        String query = """
                Select * from rooms where status = 'occupied' and roomNumber = ? and isDeleted = 0
                """;
        Room room = null;
        try (Connection conn = DBconnection.getConnection();

                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, roomNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                room = new Room();
                room.setId(rs.getInt("id"));
                room.setRoomNumber(rs.getInt("roomNumber"));
                room.setRoomType(rs.getString("type"));
                room.setStatus(rs.getString("status"));
                room.setPrice(rs.getInt("price"));
                room.setThumbnail(rs.getString("thumbnail"));
                room.setDescription(rs.getString("description"));
                room.setCapacity((rs.getInt("capacity")));
                room.setPosition(rs.getInt("position"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }
    // tìm phòng đang được sử dụng

    // cập nhập lại trạng thái phòng
    public Boolean updateRoomStatus(int roomId, String status) {
        String query = "UPDATE rooms SET status = ? WHERE id = ?";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, roomId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // hết cập nhập lại trạng thái phòng
    // Lấy ra danh sách phòng dựa trên trạng thái
    public List<Room> listStatus(String status) {
        String query = """
                Select * from rooms where status = ?
                """;
        List<Room> rooms = new ArrayList<>();
        try (Connection conn = DBconnection.getConnection();) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, status);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                Room room = new Room();
                room.setId(result.getInt("id"));
                room.setRoomNumber(result.getInt("roomNumber"));
                room.setRoomType(result.getString("type"));
                room.setStatus(result.getString("status"));
                room.setPrice(result.getDouble("price"));
                room.setThumbnail(result.getString("thumbnail"));
                room.setDescription(result.getString("description"));
                room.setCapacity((result.getInt("capacity")));
                ;
                room.setPosition(result.getInt("position"));
                rooms.add(room);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
    // hết lấy ra danh sách phòng dựa trên trạng thái
}
