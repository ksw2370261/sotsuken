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
import tool.Action;

public class EventDetailAction extends Action {

    private static final String DB_URL = "jdbc:h2:~/teambtsubasa";
    private static final String DB_USER = "teambtsubasa";
    private static final String DB_PASSWORD = "";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String schoolCd = req.getParameter("schoolCd");

        // 学校コードが指定されていない場合はエラーメッセージを送信
        if (schoolCd == null || schoolCd.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "学校のIDが指定されていません。");
            return;
        }

        // 学校コードに基づいてイベント情報を取得
        List<Event> events = getEventInfoFromDatabase(schoolCd);

        // リクエスト属性に学校コードとイベントリストを設定
        req.setAttribute("schoolCd", schoolCd);
        req.setAttribute("events", events);

        // イベント詳細画面へフォワード
        req.getRequestDispatcher("event_detail.jsp").forward(req, res);
    }

    /**
     * データベースからイベント情報を取得するメソッド
     *
     * @param schoolCd 学校コード
     * @return イベントリスト
     */
    private List<Event> getEventInfoFromDatabase(String schoolCd) {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT event_cd, event_name, event_date, event_time, event_location, event_content FROM event WHERE school_cd = ?";

        try (
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // 学校コードをパラメータに設定
            stmt.setString(1, schoolCd);
            ResultSet rs = stmt.executeQuery();

            // 結果セットからイベント情報を取得し、リストに追加
            while (rs.next()) {
                Event event = new Event();
                event.setEventCd(rs.getInt("event_cd"));
                event.setEventName(rs.getString("event_name"));
                event.setEventDate(rs.getString("event_date"));
                event.setEventTime(rs.getString("event_time"));
                event.setEventLocation(rs.getString("event_location"));
                event.setEventContent(rs.getString("event_content"));

                // コンテンツの短縮バージョンを設定（必要に応じて）
                if (event.getEventContent().length() > 50) {
                    event.setShortContent(event.getEventContent().substring(0, 50) + "...");
                } else {
                    event.setShortContent(event.getEventContent());
                }

                eventList.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventList;
    }
}
