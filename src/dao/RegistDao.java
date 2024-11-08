package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Admin;
import bean.School;

public class RegistDao {
    private Connection connection;

    public RegistDao(Connection connection) {
        this.connection = connection;
    }

    // Check if an ID already exists in the admin table
    public boolean isIdDuplicate(String admin_id) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM admin WHERE admin_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(checkSql)) {
            stmt.setString(1, admin_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // If count > 0, ID already exists
            }
        }
        return false;
    }

    // Save Admin and corresponding School
    public boolean save(Admin admin, School school) throws SQLException {
        if (isIdDuplicate(admin.getAdmin_Id())) {
            return false; // ID duplication, registration should fail
        }

        // Insert Admin into the database
        String insertAdminSql = "INSERT INTO admin (admin_id, password) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(insertAdminSql)) {
            stmt.setString(1, admin.getAdmin_Id());
            stmt.setString(2, admin.getPassword());
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                // Get the last inserted ID to use in School table
                String insertSchoolSql = "INSERT INTO school (school_name, admin_id) VALUES (?, ?)";
                try (PreparedStatement stmt2 = connection.prepareStatement(insertSchoolSql)) {
                    stmt2.setString(1, school.getSchoolName());
                    stmt2.setString(2, admin.getAdmin_Id()); // Use the same admin ID
                    stmt2.executeUpdate();
                    return true; // Registration successful
                }
            }
        }
        return false;
    }
}
