package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class EventListStartAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // イベント一覧ページ（event_list.jsp）に遷移
        req.getRequestDispatcher("event_list.jsp").forward(req, res);
    }
}


