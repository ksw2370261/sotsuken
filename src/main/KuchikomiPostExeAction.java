package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Kuchikomi;
import dao.KuchikomiDao;
import tool.Action;

public class KuchikomiPostExeAction extends Action {
    // ロガーの設定：システムエラーなどの記録に使用
    private static final Logger logger = Logger.getLogger(KuchikomiPostExeAction.class.getName());

    // executeメソッド：フォームからのデータを使って口コミを登録する処理
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        // フォームから送信された口コミ情報を取得
        String kuchikomiId = request.getParameter("kuchikomi_id");
        String kuchikomiContent = request.getParameter("kuchikomi_content");
        String kuchikomiTime = request.getParameter("kuchikomi_time");

        // 入力チェック：必須項目が未入力の場合、エラーメッセージを設定し口コミ登録ページに戻す
        if (kuchikomiId == null || kuchikomiContent == null || kuchikomiTime == null ||
            kuchikomiId.isEmpty() || kuchikomiContent.isEmpty() || kuchikomiTime.isEmpty()) {
            request.setAttribute("error", "口コミが入力されていません。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
            return;
        }

        // Kuchikomiオブジェクトを生成し、入力データを設定
        Kuchikomi kuchikomi = new Kuchikomi();
        kuchikomi.setKuchikomi_id(kuchikomiId);
        kuchikomi.setKuchikomi_content(kuchikomiContent);
        kuchikomi.setKuchikomi_time(kuchikomiTime);

        // データベース接続の設定
        String url = "jdbc:h2:~/teambkazuyoshi";
        String dbUser = "teambkazuyoshi";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
            // KuchikomiDaoオブジェクトを生成し、データベース接続を渡す
            KuchikomiDao kuchikomiDao = new KuchikomiDao(connection);

            // 口コミ登録処理の実行
            boolean isRegistered = kuchikomiDao.addKuchikomi(kuchikomi);

            if (isRegistered) {
                // 登録成功時：成功メッセージをセッションに設定し、口コミ一覧ページにリダイレクト
                session.setAttribute("message", "口コミが正常に登録されました。");
                request.getRequestDispatcher("kuchikomi_list.jsp").forward(request, response);
            } else {
                // 登録失敗時：エラーメッセージを設定し、口コミ登録ページに戻す
                request.setAttribute("error", "口コミの登録に失敗しました。");
                request.getRequestDispatcher("admin_error.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            // SQLエラー発生時：ロガーにエラーメッセージを出力し、ユーザーにシステムエラーを通知
            logger.log(Level.SEVERE, "口コミの登録に失敗しました: " + e.getMessage(), e);
            request.setAttribute("error", "システムエラーが発生しました。もう一度お試しください。");
            request.getRequestDispatcher("admin_error.jsp").forward(request, response);
        }
    }
}
