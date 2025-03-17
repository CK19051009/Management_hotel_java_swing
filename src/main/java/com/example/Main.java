package com.example;

import com.example.controllers.EmployeeController;
import com.example.controllers.GuestController;
import com.example.controllers.RoomsController;
import com.example.models.Employee;
import com.example.models.Guest;
import com.example.models.Room;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static Boolean loginFrom() {
        System.out.println("Login Form");
        System.out.print("Enter Email:");
        String email = sc.nextLine();
        System.out.print("Enter Password:");
        String password = sc.nextLine();
        EmployeeController controller = new EmployeeController();

        Employee employee = controller.login(email, password);
        if (employee != null) {
            System.out.println("Login success");
            return true;

        } else {
            System.out.println("Login failed");
            return false;
        }

    }

    public static void menu() {
        System.out.println("Menu");
        System.out.println("1.Manage Employees ");
        System.out.println("2.Manage Rooms ");
        System.out.println("3.Manage Services ");
        System.out.println("4.Manage Customers ");
        System.out.println("5.Manage Profits ");
        System.out.println("6.Manage Bills ");
        System.out.println("7. Exit");

    }

    public static Room inputRoom() {
        System.out.print("Input numberRoom ");
        String numberRoom = sc.nextLine();
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
        Boolean isLogin = loginFrom();
        if (isLogin) {
            menu();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            EmployeeController controller = new EmployeeController();
            RoomsController roomsController = new RoomsController();
            GuestController guestController = new GuestController();
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {

                    System.out.println("Manage Employees");
                    System.out.println("1. Create Employee");
                    System.out.println("2. Update Employee");
                    System.out.println("3. Delete Employee");
                    System.out.println("4. List Employee");
                    System.out.println("5. Detail Employee");
                    System.out.println("6. Back");
                    System.out.print("Enter your choice: ");
                    int choiEmployee = sc.nextInt();
                    switch (choiEmployee) {
                        case 1:
                            System.out.println("Create Employee"); {

                            Employee newEmployee = inputEmployee();
                            boolean isCreated = controller.createEmployee(newEmployee);

                            if (isCreated) {
                                System.out.println("Employee created successfully!");
                            } else {
                                System.out.println("Failed to create employee.");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Update Employee");
                            System.out.println("Input Id Employee, you want to update: ");
                            int id = sc.nextInt();
                            Employee employee = inputEmployee();
                            Boolean isUpdate = controller.updateEmployee(employee, id);
                            if (isUpdate) {
                                System.out.println("Update successfully!");
                            } else {
                                System.out.println("Update failed");
                            }

                            break;
                        }
                        case 3: {

                            System.out.println("Delete Employee");
                            System.out.print("Input Id employee, you want to delete.");
                            int id = sc.nextInt();
                            Boolean check = controller.deleteEmployee(id);
                            if (check) {
                                System.out.println("Delete successfully!");
                            } else {
                                System.out.println("Delete fall!");
                            }
                            break;
                        }
                        case 4: {

                            System.out.println("List Employee");
                            List<Employee> employees = controller.listEmployee();
                            if (employees != null) {
                                for (Employee employee : employees) {
                                    System.out.println(employee);
                                }
                            }
                            break;
                        }
                        case 5: {

                            System.out.println("Detail Employee");
                            System.out.print("Input Id Employee ");
                            int id = sc.nextInt();
                            Employee employee = controller.detailEmployee(id);
                            if (employee != null) {
                                System.out.println(employee);
                            } else {
                                System.out.println("Employee not exist!");
                            }
                            break;
                        }
                        case 6:
                            menu();
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }

                    break;
                case 2:
                    System.out.println("Manage Rooms");
                    System.out.println("1.List rooms.");
                    System.out.println("2.Create rooms.");
                    System.out.println("3.Update rooms.");
                    System.out.println("4.Delete rooms.");
                    System.out.println("5.Detail room.");
                    System.out.println("6.Place room.");
                    System.out.println("7.Back.");
                    System.out.print("Enter your choice: ");
                    int choiceRoom = sc.nextInt();
                    switch (choiceRoom) {
                        case 1:
                            System.out.println("List rooms"); {
                            List<Room> rooms = roomsController.listRooms();
                            if (rooms != null) {
                                for (Room room : rooms) {
                                    System.out.println(room);
                                }
                            }
                        }

                            break;
                        case 2: {

                            System.out.println("Create rooms");
                            Room roomNew = inputRoom();
                            Boolean isCreated = roomsController.createRoom(roomNew);
                            if (isCreated) {
                                System.out.println("Create room successfully!");
                            } else {
                                System.out.println("Failed room!");
                            }

                            break;
                        }
                        case 3:
                            System.out.println("Update rooms");
                            break;
                        case 4:
                            System.out.println("Delete rooms");
                            break;
                        case 5:
                            System.out.println("Detail room");
                            System.out.print("Input Id Room ");
                            int id = sc.nextInt();
                            Room room = roomsController.roomDetail(id);
                            if (room != null) {
                                System.out.println(room);
                                System.out.println("Services: " + room.getServices());
                            } else {
                                System.out.println("Room not exist!");
                            }
                            break;
                        case 7: {

                            System.out.println("Place room");
                            System.out.println("Giao diện tạo hóa đơn:");
                            System.out.println("Nhập thông tin khách hàng: ");
                            System.out.println("Nhận tên: ");
                            String fullName = sc.nextLine();
                            System.out.println("Nhận số điện thoại: ");
                            String phone = sc.nextLine();

                            System.out.println("Nhập địa chỉ: ");
                            String address = sc.nextLine();
                            System.out.println("Nhập email khách hàng: ");
                            String email = sc.nextLine();
                            // tạo khách hàng trong cở sở dữ liệu
                            Guest guest = new Guest(fullName, phone, address, email);
                            Boolean isCreated = guestController.createGuest(guest);
                            if (isCreated) {
                                System.out.println("Create guest successfully!");
                            } else {
                                System.out.println("Error!");
                            }
                            System.out.println("Nhập thông tin phòng: ");
                            System.out.println("Nhập số phòng: ");
                            String numberRoom = sc.nextLine();

                            break;
                        }
                        default:
                            System.out.println("Invalid choice");
                    }

                    break;
                case 3:
                    System.out.println("Manage Services");
                    break;
                case 4:
                    System.out.println("Manage Customers");
                    break;
                case 5:
                    System.out.println("Manage Profits");
                    break;
                case 6:
                    System.out.println("Manage Bills");

                    break;
                case 7:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}