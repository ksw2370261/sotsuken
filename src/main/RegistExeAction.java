package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.RegistDao;
import tool.Action;

public class RegistExeAction extends Action {
    private static final Logger logger = Logger.getLogger(RegistExeAction.class.getName());

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // 入力チェック
        if (id == null || password == null || id.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "IDまたはパスワードが入力されていません。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Adminオブジェクトを生成し、入力データを設定
        Admin admin = new Admin();
        admin.setId(id);
        admin.setPassword(password);

        // データベース接続の設定
        String url = "jdbc:h2:~/teambkazuyoshi";
        String dbUser = "teambkazuyoshi";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
            RegistDao dao = new RegistDao(connection);

            // 登録処理の実行
            boolean isRegistered = dao.save(admin);

            if (isRegistered) {
                // 登録成功時の処理
                session.setAttribute("message", "登録が完了しました。");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                // 重複エラーの処理
                request.setAttribute("error", "このIDはすでに存在します。");
                request.getRequestDispatcher("regist.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Admin registration failed: " + e.getMessage(), e);
            request.setAttribute("error", "・システムエラーが発生しました。もう一度お試しください。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
        }
    }
}
