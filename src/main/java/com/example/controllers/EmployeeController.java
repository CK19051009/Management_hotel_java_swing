package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.example.config.DBconnection;
import com.example.models.Employee;

public class EmployeeController {

    // Đăng nhập
    public Boolean login(String email, String Inputpassword) {

        String query = "SELECT * FROM employees WHERE email = ? and  isDeleted = 0";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String passwordDatabase = rs.getString("password");
                if (BCrypt.checkpw(Inputpassword, passwordDatabase)) {
                    return true;
                } else {
                    System.out.println("Sai mật khẩu!");
                }
            } else {
                System.out.println("Người dùng không tồn tại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    // Kết thúc đăng nhập
    // Đăng ký
    public Boolean register(String userInput, String emailInput, String passInput) {
        String query = """
                INSERT INTO employees (userName,email,password) values (?, ?, ?)
                """;
        String hashedPassword = BCrypt.hashpw(passInput, BCrypt.gensalt(12));
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, userInput);
            ps.setString(2, emailInput);
            ps.setString(3, hashedPassword);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // Kiểm tra lỗi vi phạm ràng buộc UNIQUE
            if (e.getSQLState().equals("23000")) { // SQLState 23000: Vi phạm ràng buộc
                System.out.println("Email đã tồn tại trong hệ thống!");
            } else {
                e.printStackTrace(); // In lỗi khác
            }
        }
        return false;
    }

    // Kết thúc Đăng ký
    public List<Employee> listEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        String query = "SELECT * FROM employees where isDeleted = 0 ";
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
        String query = "INSERT INTO employees (userName, fullName, email, password, levelUser, status) VALUES ( ?, ?, ?, ?, ?, ?)";
        String hashedPassword = BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt(12));
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, employee.getUserName());
            pstmt.setString(2, employee.getFullName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, hashedPassword);

            pstmt.setString(5,
                    employee.getLevelUser() != null && !employee.getLevelUser().isEmpty() ? employee.getLevelUser()
                            : "staff");
            pstmt.setString(6,
                    employee.getStatus() != null && !employee.getStatus().isEmpty() ? employee.getStatus() : "active");

            int createGuest = pstmt.executeUpdate();
            if (createGuest > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    employee.setId(rs.getInt(1)); // Lấy ID tự động sinh
                }
                return true;
            }
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
                "levelUser = COALESCE(?, levelUser), " +
                "status = COALESCE(?, status) " +
                "WHERE id = ?";
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            // Lấy thông tin hiện tại của nhân viên từ cơ sở dữ liệu
            Employee currentEmployee = detailEmployee(id);
            if (currentEmployee == null) {
                return false; // Nhân viên không tồn tại
            }
            // Kiểm tra email mới
            if (employee.getEmail() != null && !employee.getEmail().isEmpty() &&
                    !employee.getEmail().equals(currentEmployee.getEmail())) {
                if (existEmail(employee.getEmail(), id)) {
                    System.out.println("Email đã tồn tại trong hệ thống!");
                    return false; // Báo lỗi nếu email đã tồn tại
                }
            }

            pstmt.setString(1,
                    employee.getUserName() != null && !employee.getUserName().isEmpty() ? employee.getUserName()
                            : currentEmployee.getUserName());
            pstmt.setString(2,
                    employee.getFullName() != null && !employee.getFullName().isEmpty() ? employee.getFullName()
                            : currentEmployee.getFullName());
            pstmt.setString(3, employee.getEmail() != null && !employee.getEmail().isEmpty() ? employee.getEmail()
                    : currentEmployee.getEmail());
            pstmt.setString(4,
                    employee.getPassword() != null && !employee.getPassword().isEmpty() ? employee.getPassword()
                            : currentEmployee.getPassword());
            pstmt.setString(5,
                    employee.getLevelUser() != null && !employee.getLevelUser().isEmpty() ? employee.getLevelUser()
                            : currentEmployee.getLevelUser());
            pstmt.setString(6, employee.getStatus() != null && !employee.getStatus().isEmpty() ? employee.getStatus()
                    : currentEmployee.getStatus());
            pstmt.setInt(7, id);
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

    // kiểm tra email tài khoản đã tôn tại trong cơ sở dữ liệu chưa
    public Boolean existEmail(String email, int id) {
        String query = """
                SELECT COUNT(*) FROM employees WHERE email = ? AND id != ? AND isDeleted = 0
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu email đã tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu không có lỗi
    }

    // Lấy thông tin theo trạng thái
    public List<Employee> getEmployeesByStatus(String status) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE LOWER(Status) = LOWER(?) AND isDeleted = 0";
    
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
    
            pstmt.setString(1, status); 
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

    public List<Employee> getEmployeesByLevelUser(boolean isAscending) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE isDeleted = 0 ORDER BY FIELD(LevelUser, 'staff', 'manager', 'admin')";
    
        
        if (!isAscending) {
            query = "SELECT * FROM employees WHERE isDeleted = 0 ORDER BY FIELD(LevelUser, 'admin', 'manager', 'staff')";
        }
    
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
    // Lấy theo têntên
    public List<Employee> getEmployeesByName(String nameKeyword) {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees WHERE isDeleted = 0 AND LOWER(FullName) LIKE LOWER(?)";
    
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
    
            pstmt.setString(1, "%" + nameKeyword + "%"); 
    
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
    
    
}
