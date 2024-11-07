package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SchoolDao;
import tool.Action;

public class SchoolListAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // SchoolDaoからschool_nameのリストを取得
        SchoolDao schoolDao = new SchoolDao();
        List<String> schoolNames = schoolDao.getSchoolNames();

        // リクエストオブジェクトにschool_nameリストをセット
        req.setAttribute("schoolNames", schoolNames);

        // school_list.jspにフォワード
        req.getRequestDispatcher("school_list.jsp").forward(req, res);
    }
}
