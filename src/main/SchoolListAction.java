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
        // SchoolDaoのインスタンスを作成
        SchoolDao schoolDao = new SchoolDao();

        // 検索キーワードを取得（もしあれば）
        String schoolName = request.getParameter("schoolName");

        List<School> schools;
        if (schoolName != null && !schoolName.trim().isEmpty()) {
            // キーワードがあれば、学校名でフィルタリング
            schools = schoolDao.getSchoolsByName(schoolName);
        } else {
            // キーワードがなければ、全ての学校を取得
            schools = schoolDao.getSchools();
        }

        // リクエスト属性に学校リストを設定
        request.setAttribute("schools", schools);

        // JSPページに転送
        request.getRequestDispatcher("/main/school_list.jsp").forward(request, response);
    }
}
