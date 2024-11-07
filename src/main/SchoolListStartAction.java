package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SchoolDao;

@WebServlet(urlPatterns={"/main/SchoolListStartAction"})
public class SchoolListStartAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            // SchoolDaoを使用してschool_nameのリストを取得
            SchoolDao schoolDao = new SchoolDao();
            List<String> schoolNames = schoolDao.getSchoolNames();

            // リクエストオブジェクトにschool_nameリストをセット
            request.setAttribute("schoolNames", schoolNames);

            // school_list.jspにフォワード
            request.getRequestDispatcher("school_list.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e); // 例外が発生した場合はServletExceptionとしてスロー
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response); // POSTリクエストもdoGetと同じ処理にする
    }
}
