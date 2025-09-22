package com.pms;

public class App {
    public static void main(String[] args) {
        System.out.println("Patient Management System Backend is running!");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.authenticate("superadmin", "root123");

        if (user != null) {
            System.out.println("Login successful! Role: " + user.getRole());
        } else {
            System.out.println("Login failed!");
        }
    }
}
