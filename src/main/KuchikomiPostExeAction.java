package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Kuchikomi;
import dao.KuchikomiDao;
import tool.Action;

public class KuchikomiPostExeAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        // kuchikomi_id はデータベースで自動生成されるため、受け取る必要はありません
        String kuchikomiContent = request.getParameter("kuchikomi_content");

        if (kuchikomiContent == null || kuchikomiContent.isEmpty()) {
            request.setAttribute("error", "口コミが入力されていません。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
            return;
        }

        // kuchikomi_id はデータベースで自動生成されるので、設定しません
        Kuchikomi kuchikomi = new Kuchikomi();
        kuchikomi.setKuchikomi_content(kuchikomiContent);
        kuchikomi.setKuchikomi_time(new Timestamp(System.currentTimeMillis()));

        String url = "jdbc:h2:~/teambkazuyoshi";
        String dbUser = "teambkazuyoshi";
        String dbPassword = "";

        try {
            Class.forName("org.h2.Driver");
            try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
                KuchikomiDao kuchikomiDao = new KuchikomiDao(connection);
                boolean isRegistered = kuchikomiDao.addKuchikomi(kuchikomi);

                // 登録後に口コミ一覧を取得してJSPに渡す
                List<Kuchikomi> kuchikomiList = kuchikomiDao.getAllKuchikomi();
                request.setAttribute("kuchikomiList", kuchikomiList);

                if (isRegistered) {
                    session.setAttribute("message", "口コミが正常に登録されました。");
                    request.getRequestDispatcher("kuchikomi_list.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "口コミの登録に失敗しました。");
                    request.getRequestDispatcher("admin_error.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("error", "システムエラーが発生しました。もう一度お試しください。");
                request.getRequestDispatcher("admin_error.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("error", "データベース接続エラーが発生しました。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
        }
    }
}
