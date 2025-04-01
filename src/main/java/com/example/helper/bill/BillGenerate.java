package com.example.helper.bill;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

// import com.itextpdf.kernel.pdf.PdfWriter;
// import com.itextpdf.kernel.pdf.PdfDocument;
// import com.itextpdf.layout.Document;
// import com.itextpdf.layout.element.Paragraph;
import com.example.models.Booking;
import com.example.models.Guest;
import com.example.models.Room;

public class BillGenerate {
    public void generateInvoiceFile(Booking booking, Room room, Guest guest, double totalRoomPrice,
            double totalServicePrice, double totalDiscount, double totalAmount, double days, Timestamp timeCheckOut) {
        String directory = "D:/java/project_javaswing/src/main/java/com/example/bill/"; // Thay đổi đường dẫn theo nhu
                                                                                        // cầu

        String fileName = directory + "invoice_" + booking.getId() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("========== HÓA ĐƠN THANH TOÁN ==========\n");
            writer.write("Mã hóa đơn: " + booking.getId() + "\n");
            writer.write("Tên khách hàng: " + guest.getFullName() + "\n");
            writer.write("Số điện thoại: " + guest.getPhone() + "\n");
            writer.write("Email: " + guest.getEmail() + "\n");
            writer.write("Số phòng: " + room.getRoomNumber() + "\n");
            writer.write("Loại phòng: " + room.getRoomType() + "\n");
            writer.write("Ngày check-in: " + booking.getCheckIn() + "\n");
            writer.write("Ngày check-out: " + timeCheckOut + "\n");
            writer.write("Số ngày thuê: " + days + "\n");
            writer.write("Tiền thuê phòng: " + totalRoomPrice + " VND\n");
            writer.write("Tiền dịch vụ: " + totalServicePrice + " VND\n");
            writer.write("Tổng tiền giảm giá: " + totalDiscount + " VND\n");
            writer.write("Tổng tiền phải trả: " + totalAmount + " VND\n");
            writer.write("=========================================\n");
            System.out.println("Hóa đơn đã được xuất ra file: " + fileName);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file hóa đơn: " + e.getMessage());
        }
    }

    // public void generateInvoicePDF(Booking booking, Room room, Guest guest,
    // double totalRoomPrice,
    // double totalServicePrice, double totalAmount, int days) {
    // String directory =
    // "D:/java/project_javaswing/src/main/java/com/example/bill/"; // Thay đổi
    // đường dẫn theo nhu
    // // cầu

    // String fileName = directory + "invoice_" + booking.getId() + ".pdf"; // Tên
    // file hóa đơn
    // try {
    // PdfWriter writer = new PdfWriter(fileName);
    // PdfDocument pdf = new PdfDocument(writer);
    // Document document = new Document(pdf);

    // document.add(new Paragraph("========== HÓA ĐƠN THANH TOÁN =========="));
    // document.add(new Paragraph("Mã hóa đơn: " + booking.getId()));
    // document.add(new Paragraph("Tên khách hàng: " + guest.getFullName()));
    // document.add(new Paragraph("Số điện thoại: " + guest.getPhone()));
    // document.add(new Paragraph("Email: " + guest.getEmail()));
    // document.add(new Paragraph("Số phòng: " + room.getRoomNumber()));
    // document.add(new Paragraph("Loại phòng: " + room.getRoomType()));
    // document.add(new Paragraph("Ngày check-in: " + booking.getCheckIn()));
    // document.add(new Paragraph("Ngày check-out: " + booking.getCheckOut()));
    // document.add(new Paragraph("Số ngày thuê: " + days));
    // document.add(new Paragraph("Tiền thuê phòng: " + totalRoomPrice + " VND"));
    // document.add(new Paragraph("Tiền dịch vụ: " + totalServicePrice + " VND"));
    // document.add(new Paragraph("Tổng tiền phải trả: " + totalAmount + " VND"));
    // document.add(new Paragraph("========================================="));

    // document.close();
    // System.out.println("Hóa đơn đã được xuất ra file PDF: " + fileName);
    // } catch (Exception e) {
    // System.out.println("Lỗi khi ghi file PDF: " + e.getMessage());
    // }
    // }
}
