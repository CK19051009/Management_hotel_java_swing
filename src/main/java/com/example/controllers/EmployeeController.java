package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.config.DBconnection;
import com.example.models.Employee;

public class EmployeeController {
    public Employee login(String email, String password) {
        Employee employee = null;
        String query = "SELECT * FROM employees WHERE email = ?";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = new Employee(email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;

    }
}
