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
        String schoolCd = req.getParameter("schoolCd");

        if (schoolCd == null || schoolCd.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "学校のIDが指定されていません。");
            return;
        }

        MapImage map = getMapFromDatabase(schoolCd);
        List<MapImage> maps = getAllMapsBySchoolCd(schoolCd);
        List<Event> events = getEventInfoFromDatabase(schoolCd);

        req.setAttribute("schoolCd", schoolCd);
        req.setAttribute("map", map);
        req.setAttribute("maps", maps);
        req.setAttribute("events", events);

        req.getRequestDispatcher("map_event_view.jsp").forward(req, res);
    }

    private MapImage getMapFromDatabase(String schoolCd) {
        MapImage map = null;
        String sql = "SELECT map_name FROM map_image WHERE school_cd = ? LIMIT 1";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schoolCd);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String mapName = rs.getString("map_name");
                map = new MapImage(mapName, null); // 画像データは省略
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private List<MapImage> getAllMapsBySchoolCd(String schoolCd) {
        List<MapImage> maps = new ArrayList<>();
        String sql = "SELECT map_name FROM map_image WHERE school_cd = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schoolCd);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String mapName = rs.getString("map_name");
                maps.add(new MapImage(mapName, null)); // 画像データは省略
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maps;
    }

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
