package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Event;

public class EventPostDao {

    private Connection connection;

    // コンストラクタでデータベース接続を受け取る
    public EventPostDao(Connection connection) {
        this.connection = connection;
    }

    // admin_idに基づいてschool_cdを取得するメソッド
    public Integer getSchoolCdByAdminId(String adminId) {
        String sql = "SELECT school_cd FROM school WHERE admin_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, adminId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("school_cd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // 見つからない場合はnullを返す
    }

    // イベントをデータベースに追加するメソッド
    public boolean addEvent(Event event, Integer schoolCd) {
        String sql = "INSERT INTO event (school_cd, event_date, event_time, event_location, event_name, event_content) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, schoolCd);
            pstmt.setString(2, event.getEventDate());
            pstmt.setString(3, event.getEventTime());
            pstmt.setString(4, event.getEventLocation());
            pstmt.setString(5, event.getEventName());
            pstmt.setString(6, event.getEventContent());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
