package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.Employee;

public class EmployeeController {

    // Đăng nhập
    public Employee login(String email, String password) {
        Employee employee = null;
        String query = "SELECT * FROM employees WHERE email = ? and password = ? and  isDeleted = 0";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = new Employee(email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;

    }

    // Kết thúc đăng nhập
    public List<Employee> listEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        String query = "SELECT * FROM employees where isDeleted = 0";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("ID"));
                employee.setUserName(rs.getString("UserName"));
                employee.setFullName(rs.getString("FullName"));
                employee.setEmail(rs.getString("Email"));
                employee.setPassword(rs.getString("Password"));
                employee.setThumbnail(rs.getString("Thumbnail"));
                employee.setLevelUser(rs.getString("LevelUser"));
                employee.setStatus(rs.getString("Status"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Boolean deleteEmployee(int id) {
        String query = "Update Employees set isDeleted = 1 where id = ?";

        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean createEmployee(Employee employee) {
        String query = "INSERT INTO employees (userName, fullName, email, password, thumbnail, levelUser, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, employee.getUserName());
            pstmt.setString(2, employee.getFullName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPassword());
            pstmt.setString(5, employee.getThumbnail() != null ? employee.getThumbnail() : null);
            pstmt.setString(6, employee.getLevelUser() != null ? employee.getLevelUser() : "staff");
            pstmt.setString(7, employee.getStatus() != null ? employee.getStatus() : "active");
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updateEmployee(Employee employee, int id) {
        String query = "UPDATE employees SET userName = COALESCE(?, userName), " +
                "fullName = COALESCE(?, fullName), " +
                "email = COALESCE(?, email), " +
                "password = COALESCE(?, password), " +
                "thumbnail = COALESCE(?, thumbnail), " +
                "levelUser = COALESCE(?, levelUser), " +
                "status = COALESCE(?, status) " +
                "WHERE id = ?";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            List<Employee> employees = listEmployee();
            for (Employee e : employees) {
                if (e.getId() != id && (e.getEmail().equals(employee.getEmail())
                        || e.getUserName().equals(employee.getUserName()))) {
                    return false;
                }
            }
            // Lấy thông tin hiện tại của nhân viên từ cơ sở dữ liệu
            Employee currentEmployee = detailEmployee(id);
            if (currentEmployee == null) {
                return false; // Nhân viên không tồn tại
            }
            pstmt.setString(1, employee.getUserName() != "" ? employee.getUserName() : currentEmployee.getUserName());
            pstmt.setString(2, employee.getFullName() != "" ? employee.getFullName() : currentEmployee.getFullName());
            pstmt.setString(3, employee.getEmail() != "" ? employee.getEmail() : currentEmployee.getEmail());
            pstmt.setString(4, employee.getPassword() != "" ? employee.getPassword() : currentEmployee.getPassword());
            pstmt.setString(5,
                    employee.getThumbnail() != "" ? employee.getThumbnail() : currentEmployee.getThumbnail());
            pstmt.setString(6,
                    employee.getLevelUser() != "" ? employee.getLevelUser() : currentEmployee.getLevelUser());
            pstmt.setString(7, employee.getStatus() != "" ? employee.getStatus() : currentEmployee.getStatus());
            pstmt.setInt(8, id);
            int rs = pstmt.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Employee detailEmployee(int id) {
        Employee employee = null;
        String query = "Select * from employees where isDeleted = 0 and id = ?";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String userName = rs.getString("userName");
                String fullName = rs.getString("fullName");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String thumbnail = rs.getString("thumbnail");
                String levelUser = rs.getString("levelUser");
                String status = rs.getString("status");

                employee = new Employee(id, userName, fullName, email, password, thumbnail, levelUser, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
