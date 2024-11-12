package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;
import dao.LoginDao;
import tool.Action;

public class LoginExeAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();

        String admin_id = request.getParameter("admin_id");
        String password = request.getParameter("password");

        // 入力チェック
        if (admin_id == null || password == null || admin_id.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "IDまたはパスワードが入力されていません。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // DAOのインスタンス生成
        LoginDao dao = new LoginDao();
        Admin login = dao.searchById(admin_id);

        if (login == null) {
            // IDが存在しない場合のエラー処理
            request.setAttribute("error", "IDが間違っています。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (!login.getPassword().equals(password)) {
            // パスワードが間違っている場合のエラー処理
            request.setAttribute("error", "パスワードが間違っています。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // ログイン成功時の処理
            session.setAttribute("admin", login);  // セッションにadminオブジェクトを保存
            response.sendRedirect("admin_menu.jsp");  // 成功時はリダイレクト
        }
    }
}
