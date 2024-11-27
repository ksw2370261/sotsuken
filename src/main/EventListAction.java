package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Event;
import dao.EventDao;
import tool.Action;

public class EventListAction extends Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        if (admin == null) {
            request.setAttribute("error", "ログインしてください。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String url = "jdbc:h2:~/teambkazuyoshi";
        String dbUser = "teambkazuyoshi";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
            EventDao eventDao = new EventDao(connection);
            Integer schoolCd = eventDao.getSchoolCdByAdminId(admin.getAdmin_Id());

            if (schoolCd != null) {
                List<Event> events = eventDao.getEventsBySchoolCd(schoolCd);
                request.setAttribute("events", events);
                request.getRequestDispatcher("event_list.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "管理者に紐づく学校が見つかりませんでした。");
                request.getRequestDispatcher("admin_menu.jsp").forward(request, response);
            }
        }
    }
}

