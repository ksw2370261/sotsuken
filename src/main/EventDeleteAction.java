// EventDeleteAction.java
package main;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventDao;
import tool.Action;

public class EventDeleteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String eventCdStr = request.getParameter("eventCd");
        if (eventCdStr != null) {
            int eventCd = Integer.parseInt(eventCdStr);

            String url = "jdbc:h2:~/teambtsubasa";
            String dbUser = "teambtsubasa";
            String dbPassword = "";

            try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
                EventDao eventDao = new EventDao(connection);
                boolean success = eventDao.deleteEvent(eventCd);
                if (success) {
                    response.sendRedirect("EventList.action");
                } else {
                    request.setAttribute("error", "イベントの削除に失敗しました。");
                    request.getRequestDispatcher("event_list.jsp").forward(request, response);
                }
            }
        } else {
            request.setAttribute("error", "無効なイベントIDです。");
            request.getRequestDispatcher("event_list.jsp").forward(request, response);
        }
    }
}