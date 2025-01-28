package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import bean.Kuchikomi;
import dao.KuchikomiManageDao;
import tool.Action;

public class KuchikomiManageAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        if (admin == null) {
            request.setAttribute("error", "ログインしてください。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String url = "jdbc:h2:~/teambtsubasa";
        String dbUser = "teambtsubasa";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
            KuchikomiManageDao kuchikomiDao = new KuchikomiManageDao(connection);

            // 管理者IDから学校コードを取得する
            Integer schoolCd = kuchikomiDao.getSchoolCdByAdminId(admin.getAdmin_Id());

            if (schoolCd != null) {
                // 学校コードに基づいて口コミを取得
                List<Kuchikomi> kuchikomiList = kuchikomiDao.getKuchikomiBySchoolCd(schoolCd);
                request.setAttribute("kuchikomiList", kuchikomiList);
                request.getRequestDispatcher("kuchikomi_manage.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "学校コードが見つかりませんでした。");
                request.getRequestDispatcher("admin_menu.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "エラーが発生しました。");
            request.getRequestDispatcher("admin_menu.jsp").forward(request, response);
        }
    }
}
