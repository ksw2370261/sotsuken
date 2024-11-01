// AdminDao.java

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Admin;

public class RegistDao {
    private Connection connection;

    public RegistDao(Connection connection) {
        this.connection = connection;
    }

    // Method to register a new admin
    public boolean save(Admin admin) {
        String sql = "INSERT INTO admin (id, password) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getId());
            stmt.setString(2, admin.getPassword());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
