package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Event;
import dao.EventDao;
import tool.Action;

public class EventPostExeAction extends Action {
    // ロガーの設定：システムエラーなどの記録に使用
    private static final Logger logger = Logger.getLogger(EventPostExeAction.class.getName());

    // executeメソッド：フォームからのデータを使ってイベントを登録する処理
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        // フォームから送信されたイベント情報を取得
        String eventDate = request.getParameter("event_date");
        String eventTime = request.getParameter("event_time");
        String eventLocation = request.getParameter("event_location");
        String eventName = request.getParameter("event_name");
        String eventDescription = request.getParameter("event_description");

        // 入力チェック：必須項目が未入力の場合、エラーメッセージを設定しイベント登録ページに戻す
        if (eventDate == null || eventTime == null || eventLocation == null ||
            eventDate.isEmpty() || eventTime.isEmpty() || eventLocation.isEmpty()) {
            request.setAttribute("error", "日付、時間、または場所が入力されていません。");
            request.getRequestDispatcher("event_register.jsp").forward(request, response);
            return;
        }

        // Eventオブジェクトを生成し、入力データを設定
        Event event = new Event();
        event.setEvent_date(eventDate);
        event.setEvent_time(eventTime);
        event.setEvent_location(eventLocation);
        event.setEvent_name(eventName);
        event.setEvent_description(eventDescription);

        // データベース接続の設定
        String url = "jdbc:h2:~/shusato";
        String dbUser = "shusato";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
            // EventDaoオブジェクトを生成し、データベース接続を渡す
            EventDao eventDao = new EventDao(connection);

            // イベント登録処理の実行
            boolean isRegistered = eventDao.addEvent(event);

            if (isRegistered) {
                // 登録成功時：成功メッセージをセッションに設定し、管理者メニューにリダイレクト
                session.setAttribute("message", "イベントが正常に登録されました。");
                request.getRequestDispatcher("admin_menu.jsp").forward(request, response);
            } else {
                // 登録失敗時：エラーメッセージを設定し、イベント登録ページに戻す
                request.setAttribute("error", "イベントの登録に失敗しました。");
                request.getRequestDispatcher("event_register.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // SQLエラー発生時：ロガーにエラーメッセージを出力し、ユーザーにシステムエラーを通知
            logger.log(Level.SEVERE, "Event registration failed: " + e.getMessage(), e);
            request.setAttribute("error", "システムエラーが発生しました。もう一度お試しください。");
            request.getRequestDispatcher("event_register.jsp").forward(request, response);
        }
    }
}
