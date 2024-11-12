package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Event;
import dao.EventDao;
import tool.Action;

public class EventPostExeAction extends Action {
    private static final Logger logger = Logger.getLogger(EventPostExeAction.class.getName());

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        // セッションから管理者情報を取得
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            request.setAttribute("error", "管理者情報が取得できませんでした。ログインしてください。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String eventDate = request.getParameter("event_date");
        String eventTime = request.getParameter("event_time");
        String eventLocation = request.getParameter("event_location");
        String eventName = request.getParameter("event_name");
        String eventContent = request.getParameter("event_content");

        if (eventDate == null || eventTime == null || eventLocation == null ||
            eventDate.isEmpty() || eventTime.isEmpty() || eventLocation.isEmpty()) {
            request.setAttribute("error", "日付、時間、または場所が入力されていません。");
            request.getRequestDispatcher("event_register.jsp").forward(request, response);
            return;
        }

        Event event = new Event();
        event.setEventDate(eventDate);
        event.setEventTime(eventTime);
        event.setEventLocation(eventLocation);
        event.setEventName(eventName);
        event.setEventContent(eventContent);

        String url = "jdbc:h2:~/teambkazuyoshi";
        String dbUser = "teambkazuyoshi";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
            EventDao eventDao = new EventDao(connection);

            // admin_id に基づいて school_cd を取得
            Integer schoolCd = eventDao.getSchoolCdByAdminId(admin.getAdmin_Id());
            if (schoolCd == null) {
                request.setAttribute("error", "管理者に関連付けられた学校情報が見つかりませんでした。");
                request.getRequestDispatcher("event_register.jsp").forward(request, response);
                return;
            }

            // イベントを登録
            boolean isRegistered = eventDao.addEvent(event, schoolCd);

            if (isRegistered) {
                session.setAttribute("message", "イベントが正常に登録されました。");
                request.getRequestDispatcher("admin_menu.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "イベントの登録に失敗しました。");
                request.getRequestDispatcher("event_register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "イベント登録失敗: " + e.getMessage(), e);
            request.setAttribute("error", "システムエラーが発生しました。もう一度お試しください。");
            request.getRequestDispatcher("event_register.jsp").forward(request, response);
        }
    }
}
