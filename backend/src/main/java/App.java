package com.pms;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Patient Management System Backend is running!");

        PatientDAO patientDAO = new PatientDAO();

        // Create a new patient
        Patient p1 = new Patient("John Doe", 30, "Male", "1234567890", "No history");
        patientDAO.addPatient(p1);

        // List all patients
        List<Patient> patients = patientDAO.getAllPatients();
        for (Patient p : patients) {
            System.out.println(p);
        }

        // Update patient
        if (!patients.isEmpty()) {
            Patient first = patients.get(0);
            first.setAge(31);
            patientDAO.updatePatient(first);
        }

        // Delete patient
        // patientDAO.deletePatient(1);
    }
}
