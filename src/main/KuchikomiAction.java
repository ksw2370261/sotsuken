package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kuchikomi;
import dao.KuchikomiDao;
import tool.Action;

public class KuchikomiAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        // データベース接続情報
        String url = "jdbc:h2:~/teambkazuyoshi";
        String dbUser = "teambkazuyoshi";
        String dbPassword = "";

        try {
            // ドライバーの読み込み
            Class.forName("org.h2.Driver");

            try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
                KuchikomiDao kuchikomiDao = new KuchikomiDao(connection);

                // 口コミを全件取得
                List<Kuchikomi> kuchikomiList = kuchikomiDao.getAllKuchikomi();
                request.setAttribute("kuchikomiList", kuchikomiList);

                // 口コミリストを表示するJSPページに転送
                request.getRequestDispatcher("kuchikomi_list.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "システムエラーが発生しました。");
                request.getRequestDispatcher("admin_error.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "データベース接続エラーが発生しました。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
        }
    }
}
