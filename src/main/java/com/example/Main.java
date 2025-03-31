package com.example;

import com.example.controllers.BookingController;
import com.example.controllers.BookingServiceController;
import com.example.controllers.BookingVoucherController;
import com.example.controllers.EmployeeController;
import com.example.controllers.GuestController;
import com.example.controllers.PaymentController;
import com.example.controllers.RoomsController;
import com.example.controllers.ServiceController;
import com.example.controllers.VoucherController;
import com.example.helper.bill.BillGenerate;
import com.example.models.Booking;
import com.example.models.BookingService;
import com.example.models.Employee;
import com.example.models.Guest;
import com.example.models.Payment;
import com.example.models.Room;

import com.example.models.Service;
import com.example.models.Voucher;
import com.example.view.login.Login_Form;

import java.net.Socket;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static Boolean loginFrom() {
        System.out.println("Login Form");
        System.out.print("Enter Email:");
        String email = sc.nextLine();
        System.out.print("Enter Password:");
        String password = sc.nextLine();
        EmployeeController controller = new EmployeeController();

        Boolean employeeExist = controller.login(email, password);
        if (employeeExist) {
            System.out.println("Login success");
            return true;

        } else {
            System.out.println("Login failed");
            return false;
        }

    }

    public static Boolean registerForm() {
        System.out.println("Register Form");
        System.out.print("Enter UserName:");
        String user = sc.nextLine();
        System.out.print("Enter Email:");
        String email = sc.nextLine();
        System.out.print("Enter Password:");
        String password = sc.nextLine();
        EmployeeController controller = new EmployeeController();
        Boolean created = controller.register(user, email, password);
        if (created) {
            System.out.println("Register success!");
            return true;
        } else {
            System.out.println("Register failed!");
            return false;
        }

    }

    public static Guest inputCustomer() {

        System.out.print("Nhập Họ và Tên: ");
        String fullName = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phone = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập địa trỉ: ");
        String address = sc.nextLine();
        Guest guest = new Guest(fullName, phone, address, email);

        return guest;

    }

    public static Service inputService() {

        System.out.print("Nhập tên dịch vụ: ");
        String fullName = sc.nextLine();
        System.out.println("Nhập mô tả: ");
        String description = sc.nextLine();
        System.out.println("Nhập giá: ");
        Double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nhập trạng thái: ");
        String status = sc.nextLine();
        if (!status.equals("available") && !status.equals("unavailable")) {
            System.out.println("Invalid Status. Defaulting to 'available'.");
            status = "available"; // Gán giá trị mặc định nếu không hợp lệ
        }

        Service service = new Service(fullName, price, description, status);

        return service;

    }

    // Statement.RETURN_GENERATED_KEYS
    public static void menu() {
        System.out.println("Menu");
        System.out.println("1.Manage Employees ");
        System.out.println("2.Manage Rooms ");
        System.out.println("3.Manage Services ");
        System.out.println("4.Manage Customers ");
        System.out.println("5.Manage Profits");
        System.out.println("6.Manage Bills");
        System.out.println("7.Manage place room");
        System.out.println("8.Manage Voucher");
        System.out.println("9. Exit");

    }

    public static Room inputRoom() {
        System.out.print("Input numberRoom ");
        int numberRoom = sc.nextInt();
        System.out.print("Input typeRoom ");
        String typeRoom = sc.nextLine();
        System.out.print("Input status ");
        String status = sc.nextLine();
        if (!status.equals("available") && !status.equals("occupied") &&
                !status.equals("reserved") && !status.equals("maintenance") && !status.equals("cleaning")) {
            System.out.println("Invalid Status. Defaulting to 'available'.");
            status = "available"; // Gán giá trị mặc định nếu không hợp lệ
        }

        System.out.print("Input price ");
        int price = sc.nextInt();
        System.out.print("Input description ");
        sc.nextLine();
        String text = sc.nextLine();
        System.out.print("Input capacity ");
        int capacity = sc.nextInt();
        System.out.print("Input positon ");
        int position = sc.nextInt();
        System.out.print("Input thumbnail ");
        String thumbnail = sc.nextLine();
        if (thumbnail.isEmpty()) {
            thumbnail = null; // Nếu không nhập, để giá trị null
        }

        Room roomNew = new Room(numberRoom, typeRoom, status, price, text, capacity, position, thumbnail);
        System.out.println(roomNew.getId());
        return roomNew;

    }

    public static Employee inputEmployee() {
        System.out.println("Enter UserName:");
        String userName = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc.nextLine();

        System.out.println("Enter FullName:");
        String fullName = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();

        System.out.println("Enter Thumbnail (optional, press Enter to skip):");
        String thumbnail = sc.nextLine();
        if (thumbnail.isEmpty()) {
            thumbnail = null; // Nếu không nhập, để giá trị null
        }

        System.out.println("Enter LevelUser (admin, manager, staff):");
        String levelUser = sc.nextLine();
        if (!levelUser.equals("admin") && !levelUser.equals("manager") &&
                !levelUser.equals("staff")) {
            System.out.println("Invalid LevelUser. Defaulting to 'staff'.");
            levelUser = "staff"; // Gán giá trị mặc định nếu không hợp lệ
        }

        System.out.println("Enter Status (active, inactive, suspended):");
        String status = sc.nextLine();
        if (!status.equals("active") && !status.equals("inactive") &&
                !status.equals("suspended")) {
            System.out.println("Invalid Status. Defaulting to 'active'.");
            status = "active"; // Gán giá trị mặc định nếu không hợp lệ
        }

        // Tạo đối tượng Employee
        Employee newEmployee = new Employee(userName, fullName, email, password,
                thumbnail, levelUser, status);
        return newEmployee;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE,
                    null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login_Form().setVisible(true);
        });
        // Scanner sc = new Scanner(System.in);

        // System.out.println("-----Giao dien-----");
        // System.out.println("1.Login");
        // System.out.println("2.Regiter");
        // System.out.println("3.Exit");
        // System.out.print("input choose of you: ");
        // int choose = sc.nextInt();
        // sc.nextLine();
        // switch (choose) {
        // case 1: {

        // Boolean isLogin = loginFrom();
        // if (isLogin) {
        // menu();
        // System.out.print("Enter your choice: ");
        // EmployeeController controller = new EmployeeController();
        // RoomsController roomsController = new RoomsController();
        // GuestController guestController = new GuestController();
        // ServiceController serviceController = new ServiceController();
        // BookingController bookingController = new BookingController();
        // BookingServiceController useSerivceController = new
        // BookingServiceController();
        // VoucherController voucherController = new VoucherController();
        // PaymentController paymentController = new PaymentController();
        // BookingVoucherController bookingVoucherController = new
        // BookingVoucherController();
        // // 25 id room 4
        // int choice = sc.nextInt();
        // switch (choice) {
        // case 1: {

        // System.out.println("Manage Employees");
        // System.out.println("1. Create Employee");
        // System.out.println("2. Update Employee");
        // System.out.println("3. Delete Employee");
        // System.out.println("4. List Employee");
        // System.out.println("5. Detail Employee");
        // System.out.println("6. Back");
        // System.out.print("Enter your choice: ");
        // int choiEmployee = sc.nextInt();
        // switch (choiEmployee) {
        // case 1:
        // System.out.println("Create Employee"); {

        // Employee newEmployee = inputEmployee();
        // boolean isCreated = controller.createEmployee(newEmployee);
        // System.out.println(newEmployee.getId());

        // if (isCreated) {
        // System.out.println("Employee created successfully!");
        // } else {
        // System.out.println("Failed to create employee.");
        // }
        // break;
        // }
        // case 2: {
        // System.out.println("Update Employee");
        // System.out.println("Input Id Employee, you want to update: ");
        // int id = sc.nextInt();
        // Employee employee = inputEmployee();
        // Boolean isUpdate = controller.updateEmployee(employee, id);
        // if (isUpdate) {
        // System.out.println("Update successfully!");
        // } else {
        // System.out.println("Update failed");
        // }

        // break;
        // }
        // case 3: {

        // System.out.println("Delete Employee");
        // System.out.print("Input Id employee, you want to delete.");
        // int id = sc.nextInt();
        // Boolean check = controller.deleteEmployee(id);
        // if (check) {
        // System.out.println("Delete successfully!");
        // } else {
        // System.out.println("Delete fall!");
        // }
        // break;
        // }
        // case 4: {

        // System.out.println("List Employee");
        // List<Employee> employees = controller.listEmployee();
        // if (employees != null) {
        // for (Employee employee : employees) {
        // System.out.println(employee);
        // }
        // }
        // break;
        // }
        // case 5: {

        // System.out.println("Detail Employee");
        // System.out.print("Input Id Employee ");
        // int id = sc.nextInt();
        // Employee employee = controller.detailEmployee(id);
        // if (employee != null) {
        // System.out.println(employee);
        // } else {
        // System.out.println("Employee not exist!");
        // }
        // break;
        // }
        // case 6:
        // menu();
        // break;
        // default:
        // System.out.println("Invalid choice");
        // break;
        // }
        // break;
        // }

        // case 2: {

        // System.out.println("Manage Rooms");
        // System.out.println("1.List rooms.");
        // System.out.println("2.Create rooms.");
        // System.out.println("3.Update rooms.");
        // System.out.println("4.Delete rooms.");
        // System.out.println("5.Detail room.");
        // System.out.println("6.Place room.");

        // System.out.println("7.Back.");
        // System.out.print("Enter your choice: ");
        // int choiceRoom = sc.nextInt();
        // sc.nextLine();
        // switch (choiceRoom) {
        // case 1:
        // System.out.println("List rooms"); {
        // List<Room> rooms = roomsController.listRooms();
        // if (rooms != null) {
        // for (Room room : rooms) {
        // System.out.println(room);
        // }
        // }
        // }

        // break;
        // case 2: {

        // System.out.println("Create rooms");
        // Room roomNew = inputRoom();
        // Boolean isCreated = roomsController.createRoom(roomNew);
        // if (isCreated) {
        // System.out.println("Create room successfully!");
        // } else {
        // System.out.println("Failed room!");
        // }

        // break;
        // }
        // case 3:
        // System.out.println("Update rooms");
        // break;
        // case 4:
        // System.out.println("Delete rooms");
        // break;
        // case 5:
        // System.out.println("Detail room");
        // System.out.print("Input Id Room ");
        // int id = sc.nextInt();
        // Room room = roomsController.roomDetail(id);
        // if (room != null) {
        // System.out.println(room);
        // System.out.println("-----------------");
        // System.out.println("Services: " + room.getServices());
        // } else {
        // System.out.println("Room not exist!");
        // }
        // break;
        // case 6: {

        // System.out.println("Place room");
        // System.out.println("Giao diện tạo hóa đơn:");
        // System.out.println("Nhập thông tin khách hàng: ");
        // System.out.print("Nhận tên: ");
        // String fullName = sc.nextLine();
        // System.out.print("Nhận số điện thoại: ");
        // String phone = sc.nextLine();

        // System.out.print("Nhập địa chỉ: ");
        // String address = sc.nextLine();
        // System.out.print("Nhập email khách hàng: ");
        // String email = sc.nextLine();
        // // tạo khách hàng trong cở sở dữ liệu
        // Guest guest = new Guest(fullName, phone, address, email);
        // Boolean isCreated = guestController.createGuest(guest);
        // int idCustomerNew = 0;
        // if (isCreated) {
        // System.out.println("Create guest successfully!");
        // idCustomerNew = guest.getId();
        // } else {
        // System.out.println("Create guest error!");
        // }
        // System.out.println("Mã của khách hàng vừa tạo là: " + idCustomerNew);
        // System.out.println("Nhập id phòng muốn đặt");
        // int idRoom = sc.nextInt();
        // Room roomPlaced = roomsController.roomDetail(idRoom);

        // if (roomPlaced != null) {
        // String statusRoom = roomPlaced.getStatus();
        // if (statusRoom.equals("occupied") || statusRoom.equals("maintenance")
        // || statusRoom.equals("reserved") || statusRoom.equals("cleaning")) {
        // System.out.println("Phòng hiện tại không còn trống mời đặt phòng khác!");
        // } else {
        // System.out.println("Phòng còn trống bạn có thể đặt");
        // System.out.println("Nhập ngày tiền đặt cọc: ");
        // double depositAmount = sc.nextDouble();
        // LocalDateTime now = LocalDateTime.now();
        // Timestamp timestamp = Timestamp.valueOf(now);

        // Booking booking = new Booking(roomPlaced.getId(), idCustomerNew, timestamp,
        // depositAmount);
        // Boolean createBooking = bookingController.createBookings(booking);
        // if (createBooking) {
        // System.out.println("Hóa đơn được tạo thành công bạn có thể nhận phòng");
        // System.out.println(booking);
        // }

        // }
        // }

        // break;
        // }
        // case 7:
        // return;
        // default:
        // System.out.println("Invalid choice");
        // break;
        // }

        // break;
        // }
        // case 3: {
        // System.out.println("Manage Services");
        // System.out.println("1.List Service");
        // System.out.println("2.Create Service");
        // System.out.println("3.Edit Service");
        // System.out.println("4.Search Service");
        // System.out.println("5.Detail Service");
        // System.out.println("6.Exit");
        // System.out.println("Input choose of you: ");
        // int chooseSer = sc.nextInt();
        // switch (chooseSer) {
        // case 1: {
        // List<Service> listService = serviceController.getAllService();
        // for (Service service : listService) {
        // System.out.println(service);
        // }
        // break;
        // }
        // case 2: {
        // Service newService = inputService();
        // Boolean created = serviceController.createService(newService);
        // if (created) {
        // System.out.println("Tạo dịch vụ thành công!");
        // } else {
        // System.out.println("Tạo thất bại");
        // }
        // break;
        // }
        // case 3: {
        // System.out.print("Nhập mã dịch vụ muốn sửa: ");
        // int codeService = sc.nextInt();
        // sc.nextLine();
        // Service newService = inputService();
        // Boolean updateService = serviceController.updateService(newService,
        // codeService);
        // if (updateService) {
        // System.out.println("Sửa dịch vụ thành công!");
        // } else {
        // System.out.println("Sửa thất bại");
        // }
        // break;
        // }
        // case 4: {
        // System.out.print("Nhập mã dịch vụ muốn tìm: ");
        // int codeService = sc.nextInt();
        // sc.nextLine();
        // Service searchService = serviceController.getServiceById(codeService);
        // if (searchService == null) {
        // System.out.println("Không tìm thấy!");
        // } else {
        // System.out.println(searchService);
        // }
        // break;
        // }
        // case 5: {
        // System.out.print("Nhập mã dịch vụ muốn xem: ");
        // int codeService = sc.nextInt();
        // sc.nextLine();
        // Service searchService = serviceController.getServiceById(codeService);
        // if (searchService == null) {
        // System.out.println("Không tìm thấy!");
        // } else {
        // System.out.println(searchService);
        // }

        // break;
        // }
        // case 6: {

        // return;
        // }

        // default:
        // break;
        // }
        // break;
        // }

        // case 4: {

        // System.out.println("Manage Customers");
        // System.out.println("1.List customer");
        // System.out.println("2.Create customer");
        // System.out.println("3.Edit customer");
        // System.out.println("4.Search customer");
        // System.out.println("5.Detail customer");
        // System.out.println("6.Exit");
        // System.out.println("Input choose of you: ");

        // int chooseCus = sc.nextInt();
        // switch (chooseCus) {
        // case 1: {
        // System.out.println("---------------");
        // List<Guest> listCustomer = guestController.getAllGuests();
        // for (Guest guest : listCustomer) {
        // System.out.println(guest);
        // }
        // break;
        // }
        // case 2:

        // {
        // System.out.println("--------------");
        // Guest newCustomer = inputCustomer();
        // Boolean createdCus = guestController.createGuest(newCustomer);
        // if (createdCus) {
        // System.out.println("Tạo khách hàng thành công!");
        // System.out.println("Mã số của khách hàng là " + newCustomer.getId());
        // } else {
        // System.out.println("Tạo khách hàng thất bại!");
        // }
        // break;
        // }
        // case 3: {
        // System.out.println("----------------");
        // System.out.print("Nhập mã số khách hàng: ");
        // int codeCustomer = sc.nextInt();
        // sc.nextLine();

        // Guest newCustomer = inputCustomer();
        // Boolean updatedCus = guestController.updateGuest(newCustomer, codeCustomer);
        // if (updatedCus) {
        // System.out.println("Chỉnh sửa khách hàng mã " + codeCustomer + " thành
        // công");
        // } else {
        // System.out.println("Chỉnh sửa thất bại!");
        // }

        // break;
        // }
        // case 4: {
        // System.out.println("-----------");
        // System.out.print("Nhập mã số khách hàng muốn tìm: ");
        // int codeCustomer = sc.nextInt();
        // sc.nextLine();
        // Guest searchCustomer = guestController.getGuestById(codeCustomer);
        // if (searchCustomer == null) {
        // System.out.println("Không tìm thầy khách hàng hãy thử gửi lại mã khách
        // hàng");
        // } else {
        // System.out.println(searchCustomer);
        // }
        // break;

        // }
        // case 5: {

        // System.out.println("-----------");
        // System.out.print("Nhập mã số khách hàng: ");
        // int codeCustomer = sc.nextInt();
        // sc.nextLine();
        // Guest searchCustomer = guestController.getGuestById(codeCustomer);
        // if (searchCustomer == null) {
        // System.out.println("Không tìm thầy khách hàng hãy thử gửi lại mã khách
        // hàng");
        // } else {
        // System.out.println(searchCustomer);
        // }
        // break;
        // }
        // case 6:
        // return;

        // default:
        // break;
        // }
        // break;
        // }
        // case 5:
        // System.out.println("Manage Profits");
        // break;
        // case 6:
        // System.out.println("Manage Bills");

        // break;
        // case 7: {

        // System.out.println("Manage place room:");
        // System.out.println("1. Danh sách hóa đơn phòng đang sử dung.");
        // System.out.println("2. Tạo hóa đơn.");
        // System.out.println("3. Cập nhập hóa đơn.");
        // System.out.println("4. Check-out.");
        // System.out.println("5. Exit.");
        // System.out.print("Nhập lựa chọn của bạn: ");
        // int choosePlaceRoom = sc.nextInt();
        // sc.nextLine();
        // switch (choosePlaceRoom) {
        // case 1: {
        // System.out.println("Danh sách hóa đơn phòng đang sử dung.");
        // List<Booking> bookings = bookingController.listBooking();
        // for (Booking booking : bookings) {
        // System.out.println(booking);
        // }
        // break;
        // }
        // case 2: {

        // System.out.println("Giao diện tạo hóa đơn:");
        // System.out.println("Nhập thông tin khách hàng: ");
        // System.out.print("Nhận tên: ");
        // String fullName = sc.nextLine();
        // System.out.print("Nhận số điện thoại: ");
        // String phone = sc.nextLine();

        // System.out.print("Nhập địa chỉ: ");
        // String address = sc.nextLine();
        // System.out.print("Nhập email khách hàng: ");
        // String email = sc.nextLine();
        // // tạo khách hàng trong cở sở dữ liệu
        // Guest guest = new Guest(fullName, phone, address, email);
        // Boolean isCreated = guestController.createGuest(guest);
        // int idCustomerNew = 0;
        // if (isCreated) {
        // System.out.println("Create guest successfully!");
        // idCustomerNew = guest.getId();
        // } else {
        // System.out.println("Create guest error!");
        // }
        // System.out.println("Mã của khách hàng vừa tạo là: " + idCustomerNew);
        // System.out.println("Nhập id phòng muốn đặt");
        // int idRoom = sc.nextInt();
        // Room roomPlaced = roomsController.roomDetail(idRoom);

        // if (roomPlaced != null) {
        // String statusRoom = roomPlaced.getStatus();
        // if (statusRoom.equals("occupied") || statusRoom.equals("maintenance")
        // || statusRoom.equals("reserved") || statusRoom.equals("cleaning")) {
        // System.out.println("Phòng hiện tại không còn trống mời đặt phòng khác!");
        // } else {
        // System.out.println("Phòng còn trống bạn có thể đặt");
        // System.out.println("Nhập ngày tiền đặt cọc: ");
        // double depositAmount = sc.nextDouble();
        // LocalDateTime now = LocalDateTime.now();
        // Timestamp timestamp = Timestamp.valueOf(now);

        // Booking booking = new Booking(roomPlaced.getId(), idCustomerNew, timestamp,
        // depositAmount);
        // Boolean createBooking = bookingController.createBookings(booking);
        // if (createBooking) {
        // Boolean updateStatusRoom = roomsController
        // .updateRoomStatus(roomPlaced.getId(), "occupied");
        // System.out.println("Chuyển trạng thái phòng "
        // + roomPlaced.getRoomNumber() + " thành công!");
        // System.out.println("Hóa đơn được tạo thành công bạn có thể nhận phòng");

        // System.out.println(booking);
        // }

        // }
        // }

        // break;

        // }
        // case 3: {
        // List<Booking> bookings = bookingController.listBooking();
        // for (Booking booking : bookings) {
        // System.out.println(booking);
        // System.out.print("\n");
        // }
        // System.out.print("Chọn hóa đơn bạn muốn cập nhập: ");
        // int codeBooking = sc.nextInt();
        // sc.nextLine();
        // Booking bookingSelect = bookingController.detailBooking(codeBooking,
        // "pending");
        // if (bookingSelect != null) {
        // System.out.println(bookingSelect);
        // // thêm dịch vụ sử dụng trong qua trình sử dụng phòng của khách hàng
        // // tạo 1 giao diện nhỏ thêm dịch vụ
        // System.out.print("Nhập mã dịch vụ khách hàng muốn đặt: ");
        // int codeService = sc.nextInt();
        // // viết hàm check xem dịch vụ có tồn tại trong csdl hay không
        // sc.nextLine();
        // BookingService isCheckedService = useSerivceController.checkSerivced(
        // codeService,
        // bookingSelect.getId());
        // // trường hợp 1 dịch vụ chưa tồn tại thì sẽ tạo mới
        // if (isCheckedService == null) {

        // System.out.println("Nhập số lượng khách hàng muốn sử dụng: ");
        // int quantity = sc.nextInt();
        // sc.nextLine();
        // BookingService serviceOrder = new BookingService(bookingSelect.getId(),
        // codeService, quantity);

        // Boolean isServicedOrder = useSerivceController.useService(serviceOrder);
        // if (isServicedOrder) {
        // System.out.println("Dịnh vụ đã được thêm vào hóa đơn.");
        // } else {
        // System.out.println("Dịnh vụ không tồn tại.");
        // }
        // }
        // // trường hợp 2 dịch vụ đã được sử dụng và khách hàng muốn sử dụng thêm thì
        // // sẽ
        // // truy vấn cơ sở dữ liệu
        // // đến quantity và cộng thêm số lượng khách hàng muốn sử dụng

        // else {
        // System.out.print("Dịch vụ đã có bạn chỉ cần cập nhập số lượng: ");
        // System.out.print("Nhập số lượng khách hàng muốn sử dụng thêm: ");
        // int serviceAdd = sc.nextInt();
        // sc.nextLine();
        // int serviceCurrent = isCheckedService.getQuantity();
        // int quantityNew = serviceAdd + serviceCurrent;
        // // viết hàm update số lượng
        // Boolean updateQuantity = useSerivceController.updateQuantity(quantityNew,
        // codeService, bookingSelect.getId());
        // if (updateQuantity) {
        // System.out.println("Cập nhập số lượng thành công!");
        // } else {
        // System.out.println("Cập nhập thất bại!");
        // }
        // }

        // }

        // break;
        // }
        // case 4: {
        // System.out.println("Chức năng check-out!");
        // Boolean checkout = true;
        // System.out.println("Bạn có muốn thanh toán");
        // if (checkout) {
        // LocalDateTime now = LocalDateTime.now().withNano(0);
        // ;
        // Timestamp timeCheckOut = Timestamp.valueOf(now);
        // System.out.println(timeCheckOut);
        // // lễ tân xin id của khách hàng để tìm phòng đang được sử dụng sẽ có trạng
        // // thái
        // // occupied
        // System.out.println("Bạn có thể cho tôi xin số phòng được không: ");
        // int roomNumber = sc.nextInt();
        // sc.nextLine();
        // Room room = roomsController.foundRoomUse(roomNumber);
        // if (room == null) {
        // System.out.println("Không tìm thấy phòng");
        // return;

        // }
        // System.out.print("Chọn hóa đơn bạn muốn cập nhập: ");
        // int codeBooking = sc.nextInt();
        // sc.nextLine();
        // Booking bookingSelect = bookingController.detailBooking(codeBooking,
        // "pending");
        // if (bookingSelect == null) {
        // System.out.println("Không tìm thấy hóa đơn với mã đã nhập.");
        // return;

        // }
        // // tính toán tổng số tiền phải trả
        // double totalPriceService = 0; // tổng tiền sử dụng dịch vụ phải trả
        // List<BookingService> bookingServices = useSerivceController
        // .listServiceUseOfBooking(bookingSelect.getId());
        // if (bookingServices.size() > 0) {
        // for (BookingService item : bookingServices) {
        // totalPriceService += item.getTotalPrice();
        // }
        // }
        // Timestamp checkIn = bookingSelect.getCheckIn();
        // long milliseconds = timeCheckOut.getTime() - checkIn.getTime();
        // double days = Math.ceil(milliseconds / (1000.0 * 60 * 60 * 24));
        // double totalRoomPrice = room.getPrice() * days;
        // double totalAmount = totalRoomPrice + totalPriceService;
        // // Hiển thị thông tin thanh toán
        // System.out.println("Thông tin thanh toán:");
        // System.out.println("Số ngày thuê: " + (int) days);
        // System.out.println("Tiền thuê phòng: " + totalRoomPrice);
        // System.out.println("Tiền dịch vụ: " + totalPriceService);
        // System.out.println("Tổng tiền phải trả: " + totalAmount);
        // Boolean updateBookingPay = bookingController.updateBookingPay(
        // codeBooking, "checked-out", timeCheckOut, totalAmount);
        // // cập nhập lại trạng thái phòng
        // Boolean updateStatusRoom = roomsController
        // .updateRoomStatus(room.getId(), "available");

        // if (!updateBookingPay) {
        // System.out.println("Cập nhật hóa đơn thất bại.");
        // return;
        // }
        // if (!updateStatusRoom) {
        // System.out.println("Cập nhật trạng thái phòng thất bại.");
        // return;
        // }
        // // Lễ tân nhận thấy đủ điều kiện để áp dụng mã giảm giá vào đơn hàng có thể
        // hỏi
        // //
        // System.out.print("Nhập mã voucher muốn áp dụng: ");
        // int codeVoucher = sc.nextInt();
        // Voucher voucherApp = voucherController.detailVoucher(codeVoucher, "active");
        // double amount = 0;
        // double discountValue = 0;
        // double minOrderValue = voucherApp.getMinOrderValue();
        // double maxDiscountValue = voucherApp.getMaxDiscountValue();
        // String dicountType = voucherApp.getDiscountType();
        // Boolean useVocher = false;
        // if (dicountType.equals("FIXED") && totalAmount > minOrderValue) {
        // discountValue = voucherApp.getDiscountValue();
        // amount = totalAmount - discountValue;
        // useVocher = bookingVoucherController.createBookingVoucher(
        // bookingSelect.getId(), voucherApp.getId(), discountValue);

        // }
        // if (dicountType.equals("PERCENTAGE") && totalAmount > minOrderValue) {
        // if (((discountValue / 100) * totalAmount) > maxDiscountValue) {
        // discountValue = maxDiscountValue;
        // amount = totalAmount - maxDiscountValue;
        // useVocher = bookingVoucherController.createBookingVoucher(
        // bookingSelect.getId(), voucherApp.getId(), discountValue);
        // } else {
        // discountValue = ((voucherApp.getDiscountValue() / 100) * totalAmount);
        // amount = totalAmount - discountValue;
        // useVocher = bookingVoucherController.createBookingVoucher(
        // bookingSelect.getId(), voucherApp.getId(), discountValue);
        // }
        // }

        // if (!useVocher) {
        // System.out.println("Sử dụng dịch vụ thất bại!");
        // }
        // System.out.println("Tồng tiền sau khi dùng mã giảm giá là: " + amount);
        // Boolean checkedPayment =
        // paymentController.createPayment(bookingSelect.getId(),
        // amount, "Cash");
        // if (!checkedPayment) {
        // System.out.println("Tạo hóa đơn thất bại!");
        // Boolean changeStatus = paymentController.changeStatus(bookingSelect.getId(),
        // "Failed");
        // break;
        // }
        // System.out.println(amount);
        // System.out.println("Xuất hóa đơn" + bookingSelect);
        // BillGenerate bill = new BillGenerate();
        // Guest guest = guestController.getGuestById(bookingSelect.getGuestId());
        // bill.generateInvoiceFile(bookingSelect, room, guest, totalRoomPrice,
        // totalPriceService, discountValue,
        // amount, days, timeCheckOut);

        // // th1 nếu người dùng đủ điều kiện sử dụng vocher

        // System.out.println(bookingSelect);
        // // bill.generateInvoicePDF(bookingSelect, room, guest, totalRoomPrice,
        // // totalRoomPrice, totalAmount, codeBooking);
        // // th2 người dùng đủ điều kiện sử dụng voucher

        // }
        // break;
        // }
        // case 5: {

        // break;
        // }

        // default:
        // break;
        // }
        // break;
        // }
        // case 8: {

        // System.out.println("8.Manage Voucher");
        // System.out.println("1.Danh sách voucher.");
        // System.out.println("2.Tạo mới voucher.");
        // System.out.println("3.Chỉnh sửa voucher.");
        // System.out.println("4.Chi tiết voucher.");
        // System.out.println("5.Thoát.");
        // System.out.print("Chọn tính năng: ");
        // int chooseVoucher = sc.nextInt();
        // sc.nextLine();
        // switch (chooseVoucher) {
        // case 1: {
        // System.out.println("Danh sách voucher:");
        // break;
        // }
        // case 2: {
        // System.out.println("Tạo mới voucher: ");
        // System.out.print("Nhập mô tả: ");

        // String description = sc.nextLine();
        // System.out.print("Nhập kiểu giảm giá (PERCENTAGE or FIXED): ");
        // String typeVoucher = sc.nextLine();
        // System.out.print("Nhập giá trị giảm giá: ");
        // double discountValue = sc.nextDouble();
        // System.out.print("Nhập giá trị tối thiểu của hóa đơn có thể áp dụng: ");
        // double minOrderValue = sc.nextDouble();
        // System.out.print("Nhập giá trị tối đa giảm giá của voucher: ");
        // double maxDiscountValue = sc.nextDouble();
        // sc.nextLine();
        // System.out.print("Nhập ngày bắt đầu (yyyy-mm-dd): ");
        // String startString = sc.nextLine();
        // Date startDate = Date.valueOf(startString);
        // System.out.println(startDate);
        // System.out.print("Nhập ngày kết thúc (yyyy-mm-dd): ");
        // String endString = sc.nextLine();
        // Date endDate = Date.valueOf(endString);
        // System.out.println(endDate);
        // System.out.print("Nhập số lần có thể sủ dụng mã: ");
        // int usageLimit = sc.nextInt();
        // sc.nextLine();
        // System.out.print("Nhập trang thái (active or inactive): ");
        // String status = sc.nextLine();
        // Voucher voucher = new Voucher(description, typeVoucher, discountValue,
        // minOrderValue, maxDiscountValue, startDate, endDate, usageLimit, status);
        // Boolean createVoucher = voucherController.createVoucher(voucher);
        // if (!createVoucher) {
        // System.out.println("Tạo mã giảm giá không thành công!");
        // break;
        // }
        // System.out.println("Tạo mã giảm giá thành công!");
        // break;
        // }
        // case 3: {

        // break;
        // }

        // case 4: {

        // break;
        // }
        // case 5: {

        // return;
        // }

        // default:
        // break;
        // }
        // break;
        // }
        // default:
        // System.out.println("Invalid choice");
        // break;
        // }

        // }
        // break;
        // }
        // case 2: {

        // registerForm();
        // break;
        // }
        // case 3: {

        // return;
        // }

        // default:
        // break;
        // }

    }
}