package com.pms;

public class App {
    public static void main(String[] args) {
          try {
            Connection conn = DBConnection.getConnection();
            PatientDAO patientDAO = new PatientDAO(conn);

            // Test insert
            patientDAO.addPatient("John Doe", 30, "Male", "9876543210", "No allergies");

            System.out.println("Patient inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
