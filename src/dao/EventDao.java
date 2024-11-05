// EventDao
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Event;

public class EventDao {

    private Connection connection;

    // コンストラクタでデータベース接続を受け取る
    public EventDao(Connection connection) {
        this.connection = connection;
    }

    // イベントをデータベースに追加するメソッド
    public boolean addEvent(Event event) {
        String sql = "INSERT INTO event (event_date, event_time, event_location, event_name, event_description) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, event.getEvent_date());
            pstmt.setString(2, event.getEvent_time());
            pstmt.setString(3, event.getEvent_location());
            pstmt.setString(4, event.getEvent_name());
            pstmt.setString(5, event.getEvent_description());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}