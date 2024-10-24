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

	    // ログ出力で入力値を確認
	    System.out.println("Received ID: " + id);
	    System.out.println("Received Password: " + password);

	    // 入力チェック
	    if (id == null || password == null || id.isEmpty() || password.isEmpty()) {
	        request.setAttribute("error", "IDまたはパスワードが入力されていません。");
	        return;
	    }

	    // DAOのインスタンス生成
	    LoginDao dao = new LoginDao();
	    try {
	        Admin login = dao.search(id, password);

	        // ログ出力で結果を確認
	        System.out.println("Login result: " + (login != null ? "Success" : "Failure"));

	        if (login != null) {
	            // ログイン成功時の処理
	            session.setAttribute("login", login);
	            request.getRequestDispatcher("admin_menu.jsp").forward(request, response);
	        } else {
	            // ログイン失敗時の処理
	            request.setAttribute("error", "・  ログインに失敗しました。IDまたはパスワードが正しくありません。");
	            request.setAttribute("contentPage", "login.jsp");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        // データベース接続エラーなどの処理
	        e.printStackTrace();  // エラーの詳細をコンソールに出力
	        request.setAttribute("error", "データベース接続エラーが発生しました。");
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }
	}

}
