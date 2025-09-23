package com.pms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    private Connection conn;

    public AppointmentDAO(Connection conn) {
        this.conn = conn;
    }

    public void bookAppointment(int patientId, int doctorId, Timestamp appointmentDate) throws SQLException {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, patientId);
            stmt.setInt(2, doctorId);
            stmt.setTimestamp(3, appointmentDate);
            stmt.executeUpdate();
        }
    }

    public List<String> getAllAppointments() throws SQLException {
        List<String> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                appointments.add("Patient ID: " + rs.getInt("patient_id") +
                                 ", Doctor ID: " + rs.getInt("doctor_id") +
                                 ", Date: " + rs.getTimestamp("appointment_date"));
            }
        }
        return appointments;
    }
}
