package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class KuchikomiDeleteAction extends Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 口コミのIDを取得
        int kuchikomiCd = Integer.parseInt(request.getParameter("kuchikomiCd"));

        // データベースに接続
        String url = "jdbc:h2:~/teambtsubasa";
        String dbUser = "teambtsubasa";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {
            // 口コミを削除するSQL文
            String sql = "DELETE FROM kuchikomi WHERE kuchikomi_cd = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, kuchikomiCd);
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 削除後、口コミ一覧画面にリダイレクト
        response.sendRedirect("KuchikomiManage.action");
    }
}
