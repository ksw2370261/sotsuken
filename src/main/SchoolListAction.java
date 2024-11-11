package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import dao.SchoolDao;
import tool.Action;

public class SchoolListAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // SchoolDaoのインスタンスを作成し、学校リストを取得
        SchoolDao schoolDao = new SchoolDao();
        List<School> schools = schoolDao.getSchools();

        // リクエスト属性に学校リストを設定し、JSPページに転送
        request.setAttribute("schools", schools);
        request.getRequestDispatcher("/main/school_list.jsp").forward(request, response);
    }
}
