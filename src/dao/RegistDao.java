package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Admin;

public class RegistDao {
    private Connection connection;

    public RegistDao(Connection connection) {
        this.connection = connection;
    }

    // Check if an ID already exists in the database
    public boolean isIdDuplicate(String id) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM admin WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(checkSql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // If count > 0, ID already exists
            }
        }
        return false;
    }

    // Method to register a new admin
    public boolean save(Admin admin) throws SQLException {
        if (isIdDuplicate(admin.getId())) {
            return false; // ID duplication, registration should fail
        }

        String sql = "INSERT INTO admin (id, password) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getId());
            stmt.setString(2, admin.getPassword());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }
    }
}
