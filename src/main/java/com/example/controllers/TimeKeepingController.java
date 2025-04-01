package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.TimeKeeping;

public class TimeKeepingController {
        
      // Check In
      public Boolean checkIn(int employeeID) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedWorkDate = now.format(formatter);
        
        String checkQuery = "SELECT COUNT(*) FROM Timekeeping WHERE EmployeeID = ? AND WorkDate = ?";
        
        String insertQuery = "INSERT INTO Timekeeping (EmployeeID, WorkDate, CheckIn, SalaryPerDay, Status) " +
                             "VALUES (?, ?,CURRENT_TIMESTAMP, 0 , " +
                             "(CASE WHEN TIME(NOW()) > '08:00:00' THEN 'late' ELSE 'on-time' END))";
        
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
             PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
    
            // Kiểm tra nhân viên đã check-in chưa
            checkStmt.setInt(1, employeeID);
            checkStmt.setString(2, formattedWorkDate);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Nhân viên đã check-in hôm nay rồi!");
                return false;
            }
    
            // Nếu chưa check-in thì tiến hành chấm công
            insertStmt.setInt(1, employeeID);
            insertStmt.setString(2, formattedWorkDate);
           
            
            int insertedRows = insertStmt.executeUpdate();
            return insertedRows > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    

    // Check Out
   // Check Out
public Boolean checkOut(int employeeID) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedWorkDate = now.format(formatter);

    String updateQuery = "UPDATE Timekeeping " +
    "SET CheckOut = CURRENT_TIMESTAMP, " +
    "    SalaryPerDay = TIMESTAMPDIFF(HOUR, CheckIn, CURRENT_TIMESTAMP) * 30000, " +
    "    Status = CASE " +
    "                WHEN TIMESTAMPDIFF(HOUR, CheckIn, CURRENT_TIMESTAMP) < 1 THEN 'absent' " +
    "                ELSE Status " +
    "             END " +
    "WHERE EmployeeID = ? AND WorkDate = ? AND CheckOut IS NULL";

    try (Connection conn = DBconnection.getConnection();
    
         PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
        updateStmt.setInt(1, employeeID);
        updateStmt.setString(2, formattedWorkDate);
        int rowsUpdated = updateStmt.executeUpdate();
        
        return rowsUpdated > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}




    // Lấy thông tin chấm công của nhân viên/nhóm nhân viên theo ngày
    public List<TimeKeeping> getTimekeepingByDate(String workDate, Integer employeeID) {
    List<TimeKeeping> timekeepingList = new ArrayList<>();
    
    String query = "SELECT * FROM timekeeping WHERE WorkDate = ?";
    if (employeeID != null) {
        query += " AND EmployeeID = ?";
    }

    try (Connection conn = DBconnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, workDate);
        if (employeeID != null) {
            pstmt.setInt(2, employeeID);
        }

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            TimeKeeping tk = new TimeKeeping(
                rs.getInt("TimekeepingID"),
                rs.getInt("EmployeeID"),
                rs.getString("WorkDate"),
                rs.getString("CheckIn"),
                rs.getString("CheckOut"),
                rs.getString("Status"),
                rs.getDouble("SalaryPerDay")
            );
            timekeepingList.add(tk);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return timekeepingList;
}

public static void main(String[] args) {
    TimeKeepingController controller = new TimeKeepingController();

    // ✅ Cập nhật chấm công cho nhân viên có ID = 1
    // Chấm công vào
        System.out.println("Check In: " + controller.checkIn(1));
        System.out.println("Check In: " + controller.checkIn(2));
        // Đợi 5 giây
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

        // Chấm công ra
        System.out.println("Check Out: " + controller.checkOut(1));
        System.out.println("Check Out: " + controller.checkOut(2));

    // ✅ Lấy dữ liệu chấm công của nhân viên ID = 1 hôm nay
    String today = java.time.LocalDate.now().toString();
    List<TimeKeeping> records = controller.getTimekeepingByDate(today, 1);
   
    // ✅ In danh sách chấm công
    for (TimeKeeping record : records) {
        System.out.println(record);
    }




}

}
