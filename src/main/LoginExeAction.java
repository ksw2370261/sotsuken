//LoginExeAction.java

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

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // 入力チェック
        if (id == null || password == null || id.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "IDまたはパスワードが入力されていません。");
            return;
        }

        // DAOのインスタンス生成
        LoginDao dao = new LoginDao();
            Admin login = dao.search(id, password);

            if (login != null) {
                // ログイン成功時の処理
                session.setAttribute("login", login);
                request.getRequestDispatcher("admin_menu.jsp").forward(request, response);
            } else {
                // ログイン失敗時の処理
                request.setAttribute("error", "・  ログインに失敗しました。IDまたはパスワードが正しくありません。");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

    }
}
