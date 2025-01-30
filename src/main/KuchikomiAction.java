package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kuchikomi;
import dao.KuchikomiDao;
import tool.Action;

public class KuchikomiAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String schoolCdStr = request.getParameter("schoolCd");

            if (schoolCdStr != null && !schoolCdStr.isEmpty()) {
                int schoolCd = Integer.parseInt(schoolCdStr);

                KuchikomiDao kuchikomiDao = new KuchikomiDao();
                List<Kuchikomi> kuchikomiList = kuchikomiDao.getKuchikomiBySchoolCd(schoolCd);

                // 学校名を取得
                String schoolName = kuchikomiDao.getSchoolNameBySchoolCd(schoolCd);

                request.setAttribute("kuchikomiList", kuchikomiList);
                request.setAttribute("schoolName", schoolName); // JSP で使用するためセット

                request.getRequestDispatcher("kuchikomi_list.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "学校コードが無効です");
                request.getRequestDispatcher("error_user.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "エラーが発生しました。もう一度試してください。");
            request.getRequestDispatcher("error_user.jsp").forward(request, response);
        }
    }
}
