package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class EventPostExeAction extends Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String place = request.getParameter("place");
		String event = request.getParameter("event");
		String detail = request.getParameter("detail");


	}
}