package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Event;
import bean.MapImage;
import tool.Action;

public class MapEventViewAction extends Action {

    private static final String DB_URL = "jdbc:h2:~/teambtsubasa";
    private static final String DB_USER = "teambtsubasa";
    private static final String DB_PASSWORD = "";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // schoolCd をリクエストから取得
        String schoolCd = req.getParameter("schoolCd");

        if (schoolCd == null || schoolCd.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "学校のIDが指定されていません。");
            return;  // 学校IDが不正な場合、処理を中断
        }

        // マップ情報を取得（学校CDに基づく）
        MapImage map = getMapFromDatabase(schoolCd);

        if (map == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "指定された学校のマップが見つかりません。");
            return;  // マップ情報が見つからない場合、処理を中断
        }

        // イベント情報を取得
        List<Event> events = getEventInfoFromDatabase(schoolCd);

        // データをリクエストに設定
        req.setAttribute("map", map);
        req.setAttribute("events", events);

        // JSPにフォワード
        req.getRequestDispatcher("map_event_view.jsp").forward(req, res);
    }

    // 学校CDに基づいてマップ情報を取得
    private MapImage getMapFromDatabase(String schoolCd) {
        MapImage map = null;
        String sql = "SELECT map_name, image_data FROM map_image WHERE school_cd = ? LIMIT 1";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schoolCd);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String mapName = rs.getString("map_name");
                map = new MapImage(mapName, null);  // 画像データはここでは省略
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    // 学校CDに基づいてイベント情報を取得
    private List<Event> getEventInfoFromDatabase(String schoolCd) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT event_cd, event_name, event_date, event_time, event_location, event_content FROM event WHERE school_cd = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schoolCd);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Event event = new Event();
                event.setEventCd(rs.getInt("event_cd"));
                event.setEventName(rs.getString("event_name"));
                event.setEventDate(rs.getString("event_date"));
                event.setEventTime(rs.getString("event_time"));
                event.setEventLocation(rs.getString("event_location"));
                event.setEventContent(rs.getString("event_content"));
                eventList.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventList;
    }
}
