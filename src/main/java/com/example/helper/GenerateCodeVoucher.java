package com.example.helper;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.config.DBconnection;

public class GenerateCodeVoucher {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 10; // Độ dài mã voucher

    public String generateVoucherCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder voucherCode = new StringBuilder(CODE_LENGTH);

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            voucherCode.append(CHARACTERS.charAt(index));
        }
        return voucherCode.toString();

    }

    public Boolean checkCodeVoucher(String codeVoucher) {
        String query = """
                select count(*) from vouchers where code = ?;
                """;
        try (Connection conn = DBconnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, codeVoucher);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Nếu COUNT > 0, nghĩa là mã đã tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String renderCodeVoucher() {
        String codeVoucher;
        do {
            codeVoucher = generateVoucherCode();
        } while (checkCodeVoucher(codeVoucher));
        return codeVoucher;
    }
}
