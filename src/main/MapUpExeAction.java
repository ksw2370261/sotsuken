//MapUpExeAction.java
package main;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Admin;
import tool.Action;

//@MultipartConfigアノテーションを追加
@MultipartConfig(
 fileSizeThreshold = 1024 * 1024,  // メモリ上に保持する最大サイズ（1MB）
 maxFileSize = 1024 * 1024 * 10,  // 1ファイルの最大サイズ（10MB）
 maxRequestSize = 1024 * 1024 * 50 // 全体リクエストの最大サイズ（50MB）
)

public class MapUpExeAction extends Action {

    // JDBCの接続情報
    private static final String DB_URL = "jdbc:h2:~/teambtsubasa";
    private static final String DB_USER = "teambtsubasa";
    private static final String DB_PASSWORD = "";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	request.setCharacterEncoding("UTF-8");
        // セッションからAdminオブジェクトを取得
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");

        if (admin == null) {
            request.setAttribute("error", "ログインしてください。");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Adminオブジェクトからadmin_idを取得
        String adminId = admin.getAdmin_Id();

        // admin_idに基づいてschool_cdを取得
        int schoolCd = getSchoolCdByAdminId(adminId);

        if (schoolCd == -1) {
            request.setAttribute("message", "管理者に紐づく学校が見つかりません。");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // フォームデータの取得
        String mapName = request.getParameter("mapName");  // マップ名
        Part filePart = request.getPart("mapImage");  // ファイルのパート

        // ファイルのバイナリデータを取得
        InputStream fileContent = filePart.getInputStream();

        // データベースに保存する処理
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO map_image (school_cd, map_name, image_data) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, schoolCd);        // school_cd
                stmt.setString(2, mapName);      // map_name
                stmt.setBlob(3, fileContent);    // image_data

                int rows = stmt.executeUpdate();
                if (rows > 0) {
                    request.setAttribute("message", "画像、マップ名が正常にアップロードされました。");
                    request.getRequestDispatcher("map_up_success.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "アップロードに失敗しました。");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "データベース接続に失敗しました。");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }


    // admin_idからschool_cdを取得するメソッド
    private int getSchoolCdByAdminId(String adminId) {
        int schoolCd = -1;

        // admin_idに基づいてschool_cdを取得するためのSQL
        String sql = "SELECT school_cd FROM school WHERE admin_id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, adminId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    schoolCd = rs.getInt("school_cd");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schoolCd;
    }
}
