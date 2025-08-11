package com.curd.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.curd.model.department;
import com.curd.service.DeptImplService;
import com.curd.service.Deptinterface;

public class clientApp {

    static Scanner sc = new Scanner(System.in);
    static Deptinterface dept = new DeptImplService();

    public static void main(String[] args) {
        System.out.println(">>> Welcome to Department Management System <<<");

        while (true) {
            System.out.println("\n--- Department Menu ---");
            System.out.println("1. Add Department");
            System.out.println("2. Get Department by ID");
            System.out.println("3. Get All Departments");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Department by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            try {
                switch (choice) {
                    case 1:
                        addDepartment();
                        break;
                    case 2:
                        getDepartment();
                        break;
                    case 3:
                        allDepartments();
                        break;
                    case 4:
                        updateDepartment();
                        break;
                    case 5:
                        deleteDepartment();
                        break;
                    case 6:
                        System.out.println("Exiting... Thank you!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void addDepartment() {
        System.out.print("Enter Department ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Location: ");
        String location = sc.nextLine();

        department dep = new department(id, name, location);
        dept.addDepartment(dep);
        System.out.println("Department added successfully!");
    }

    public static void getDepartment() throws SQLException {
        System.out.print("Enter Department ID: ");
        int id = sc.nextInt();

        department d = dept.getDepartmentbyId(id);
        if (d != null) {
            System.out.println("\n--- Department Details ---");
            System.out.println("ID: " + d.getDeptId());
            System.out.println("Name: " + d.getDeptName());
            System.out.println("Location: " + d.getLocation());
        } else {
            System.out.println("No Department found with ID: " + id);
        }
    }

    public static void allDepartments() {
        List<department> list = dept.getAllDepartments();
        if (list.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            System.out.println("\n--- All Departments ---");
            for (department d : list) {
                System.out.println(d);
            }
        }
    }

    public static void updateDepartment() {
        System.out.print("Enter Department ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Department Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Location: ");
        String location = sc.nextLine();

        department d = new department(id, name, location);
        dept.updateDepartment(d);
        System.out.println("Department updated successfully!");
    }

    public static void deleteDepartment() {
        System.out.print("Enter Department ID to delete: ");
        int id = sc.nextInt();
        dept.deleteDepartment(id);
        System.out.println("Department deleted successfully!");
    }
}
