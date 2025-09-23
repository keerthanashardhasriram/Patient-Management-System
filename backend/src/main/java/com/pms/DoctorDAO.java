package com.pms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    private Connection conn;

    public DoctorDAO(Connection conn) {
        this.conn = conn;
    }

    public void addDoctor(String name, String specialization, String availability, String department) throws SQLException {
        String sql = "INSERT INTO doctors (name, specialization, availability, department) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, specialization);
            stmt.setString(3, availability);
            stmt.setString(4, department);
            stmt.executeUpdate();
        }
    }

    public List<String> getAllDoctors() throws SQLException {
        List<String> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                doctors.add(rs.getString("name") + " (" + rs.getString("specialization") + ")");
            }
        }
        return doctors;
    }
}
