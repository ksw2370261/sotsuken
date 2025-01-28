package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Event;

public class EventDao {

    private Connection connection;

    // コンストラクタでデータベース接続を受け取る
    public EventDao(Connection connection) {
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

    public List<Event> getEventsBySchoolCd(Integer schoolCd) {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM event WHERE school_cd = ? ORDER BY event_date, event_time";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, schoolCd);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Event event = new Event();
                event.setEventCd(rs.getInt("event_cd"));
                event.setEventDate(rs.getString("event_date"));
                event.setEventTime(rs.getString("event_time"));
                event.setEventLocation(rs.getString("event_location"));
                event.setEventName(rs.getString("event_name"));
                event.setEventContent(rs.getString("event_content"));
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    public boolean deleteEvent(int eventCd) {
        String sql = "DELETE FROM event WHERE event_cd = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, eventCd);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
