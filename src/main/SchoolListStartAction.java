// SchoolListStartAction.java
package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.School;
import dao.SchoolDao;

@WebServlet(urlPatterns = { "/main/SchoolListStartAction" })
public class SchoolListStartAction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // SchoolDaoのインスタンスを作成し、学校リストを取得
            SchoolDao schoolDao = new SchoolDao();
            List<School> schools = schoolDao.getSchools();

            // リクエスト属性に学校リストを設定し、JSPページに転送
            request.setAttribute("schools", schools);
            request.getRequestDispatcher("/main/school_list.jsp").forward(request, response);
        } catch (Exception e) {
            // 例外発生時はServletExceptionとして再スロー
            throw new ServletException("学校リストの取得に失敗しました", e);
        }
    }
}
