package com.example.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.config.DBconnection;
import com.example.models.TimeKeeping;

public class TimeKeepingController {
    
      // Check In
      public Boolean checkIn(int employeeID) {
        String checkQuery = "SELECT COUNT(*) FROM Timekeeping WHERE EmployeeID = ? AND WorkDate = CURDATE()";
        String insertQuery = "INSERT INTO Timekeeping (EmployeeID, WorkDate, CheckIn, SalaryPerDay, Status) " +
                             "SELECT ?, CURDATE(), CURRENT_TIMESTAMP, " +
                             "CASE " +
                             "  WHEN CURRENT_TIME() > '11:00:00' THEN 0 " +  // Absent: Không lương
                             "  WHEN CURRENT_TIME() > '08:00:00' THEN (BaseSalary / 26) * (1 - (HOUR(TIMEDIFF(CURRENT_TIME(), '08:00:00')) * 0.1)) " +  // Late: Giảm 10% mỗi giờ
                             "  ELSE (BaseSalary / 26) " +  // On-time: Đủ lương
                             "END, " +
                             "CASE " +
                             "  WHEN CURRENT_TIME() > '11:00:00' THEN 'absent' " +
                             "  WHEN CURRENT_TIME() > '08:00:00' THEN 'late' " +
                             "  ELSE 'on-time' " +
                             "END " +
                             "FROM Employees WHERE ID = ?";
    
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
             PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
    
            // Kiểm tra nhân viên đã check-in chưa
            checkStmt.setInt(1, employeeID);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("❌ Nhân viên đã check-in hôm nay rồi!");
                return false;
            }
    
            // Nếu chưa check-in thì tiến hành chấm công
            insertStmt.setInt(1, employeeID);
            insertStmt.setInt(2, employeeID);
    
            int insertedRows = insertStmt.executeUpdate();
            return insertedRows > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    

    // Check Out
    public Boolean checkOut(int employeeID) {
        String query = "UPDATE Timekeeping " +
                       "SET CheckOut = CURRENT_TIMESTAMP " +
                       "WHERE EmployeeID = ? AND WorkDate = CURDATE() AND CheckOut IS NULL";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employeeID);

            int rs = pstmt.executeUpdate();
            return rs > 0;
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
        // System.out.println("Check Out: " + controller.checkOut(1));
        // System.out.println("Check Out: " + controller.checkOut(2));

    // ✅ Lấy dữ liệu chấm công của nhân viên ID = 1 hôm nay
    String today = java.time.LocalDate.now().toString();
    List<TimeKeeping> records = controller.getTimekeepingByDate(today, 1);
   
    // ✅ In danh sách chấm công
    for (TimeKeeping record : records) {
        System.out.println(record);
    }




}

}
