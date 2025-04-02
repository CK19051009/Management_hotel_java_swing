package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.Service;

public class ServiceController {
    public Boolean createService(Service service) {
        String query = "INSERT INTO services (name, description, price, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, service.getName());
            pstmt.setString(2, service.getDescription());
            pstmt.setDouble(3, service.getPrice());
            pstmt.setString(4, service.getStatus());

            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Lấy tất cả dịch vụ
    public List<Service> getAllService() {
        List<Service> services = new ArrayList<Service>();
        String query = "SELECT * FROM services where isDeleted = 0 and status ='available'";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setPrice(rs.getDouble("price"));
                service.setDescription(rs.getString("description"));
                service.setStatus(rs.getString("status"));
                services.add(service);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    // Cập nhật dịch vụ
    public Boolean updateService(Service service, int id) {

        Service currentService = getServiceById(id);
        if (currentService == null) {
            return false;
        }

        String query = """
                update services set name = COALESCE(?, name), description = COALESCE(?, description),
                price = COALESCE(?, price),
                status = COALESCE(?, status) where id = ? AND isDeleted = 0
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, (service.getName() != null && !service.getName().isEmpty()) ? service.getName()
                    : currentService.getName());
            pstmt.setString(2,
                    (service.getDescription() != null && !service.getDescription().isEmpty()) ? service.getDescription()
                            : currentService.getDescription());
            pstmt.setObject(3, (service.getPrice() != null) ? service.getPrice() : currentService.getPrice(),
                    java.sql.Types.DOUBLE);
            pstmt.setString(4, (service.getStatus() != null && !service.getStatus().isEmpty()) ? service.getStatus()
                    : currentService.getStatus());
            pstmt.setInt(5, id);

            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Tìm dịch vụ qua id
    public Service getServiceById(int id) {
        String query = "SELECT * FROM services WHERE id = ? AND isDeleted = 0 ";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            // pstmt.setString(2, status);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setPrice(rs.getDouble("price"));
                service.setDescription(rs.getString("description"));
                service.setStatus(rs.getString("status"));
                return service;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Xóa dịch vụ, thêm biến isDeleted để ẩn đi dịch vụ hay dùng status để ẩn

    public Boolean deleteService(int id) {
        String query = "UPDATE services SET isDeleted = 1 WHERE id = ? AND isDeleted = 0";

        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Service> getServiceByPrice(boolean ascending) {
        List<Service> services = new ArrayList<Service>();
        String order = ascending ? "ASC" : "DESC";
        String query = "SELECT * FROM services where isDeleted = 0 ORDER BY price " + order;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setPrice(rs.getDouble("price"));
                service.setDescription(rs.getString("description"));
                service.setStatus(rs.getString("status"));
                services.add(service);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public List<Service> getServicesByStatus(String status) {
        List<Service> services = new ArrayList<Service>();
        String query = "SELECT * FROM services WHERE isDeleted = 0 AND status = ?";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, status); 
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Service service = new Service();
                    service.setId(rs.getInt("id"));
                    service.setName(rs.getString("name"));
                    service.setPrice(rs.getDouble("price"));
                    service.setDescription(rs.getString("description"));
                    service.setStatus(rs.getString("status"));
                    services.add(service);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return services;
    }
    public List<Service> getServiceByKeyword(String keyword) {
        String query = "SELECT * FROM services WHERE LOWER(name) LIKE LOWER(?) AND isDeleted = 0 ORDER BY name ASC";  
        List<Service> serviceList = new ArrayList<>();
    
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, "%" + keyword.toLowerCase() + "%");  
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setPrice(rs.getDouble("price"));
                service.setDescription(rs.getString("description"));
                service.setStatus(rs.getString("status"));
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }
    
    

public static void main(String[] args) {
    ServiceController c = new ServiceController();
    List<Service> a = c.getServiceByPrice(false) ;
    for (Service service : a) {
        System.out.println(service.getPrice());
    }
    
}
}
