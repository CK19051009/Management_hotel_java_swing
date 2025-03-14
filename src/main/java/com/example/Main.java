package com.example;

import com.example.config.DBconnection;
import com.example.controllers.EmployeeController;
import com.example.models.Employee;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        Employee employee = employeeController.login("admin1@gmail.com", "123456");
        if (employee != null) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }

    }
}