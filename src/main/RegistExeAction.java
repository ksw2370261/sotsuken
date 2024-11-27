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
import bean.School;
import dao.RegistDao;
import tool.Action;

public class RegistExeAction extends Action {
    private static final Logger logger = Logger.getLogger(RegistExeAction.class.getName());

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String admin_id = request.getParameter("admin_id");
        String password = request.getParameter("password");
        String schoolName = request.getParameter("school_name"); // 追加: school_name の入力を受け取る

        // 入力チェック
        if (admin_id == null || password == null || schoolName == null || admin_id.isEmpty() || password.isEmpty() || schoolName.isEmpty()) {
            request.setAttribute("error", "ID、パスワード、または学校名が入力されていません。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
            return;
        }

        // Admin オブジェクトを生成し、入力データを設定
        Admin admin = new Admin();
        admin.setAdmin_Id(admin_id);
        admin.setPassword(password);

        // School オブジェクトを生成し、学校名を設定
        School school = new School();
        school.setSchoolName(schoolName);

        // データベース接続の設定
        String url = "jdbc:h2:~/teambkazuyoshi";
        String dbUser = "teambkazuyoshi";
        String dbPassword = "";

        try {
            // H2ドライバのロード
            Class.forName("org.h2.Driver"); // 追加: ドライバのロード

            try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
                RegistDao dao = new RegistDao(connection);

                // 登録処理の実行
                boolean isRegistered = dao.save(admin, school);

                if (isRegistered) {
                    // 登録成功時の処理
                    session.setAttribute("message", "登録が完了しました。");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    // 重複エラーの処理
                    request.setAttribute("error", "このIDはすでに存在します。");
                    request.getRequestDispatcher("regist.jsp").forward(request, response);
                }
            }
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "JDBC Driver not found: " + e.getMessage(), e);
            request.setAttribute("error", "・システムエラーが発生しました。もう一度お試しください。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Admin registration failed: " + e.getMessage(), e);
            request.setAttribute("error", "・システムエラーが発生しました。もう一度お試しください。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
        }
    }
}

