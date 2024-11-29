package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class KuchikomiPostDao {
    private static final String URL = "jdbc:h2:~/teambtsubasa";  // 適切なJDBC URLを指定
    private static final String USER = "teambtsubasa";           // データベースのユーザー名
    private static final String PASSWORD = "";                   // データベースのパスワード

    // 口コミ投稿メソッド
    public boolean insertKuchikomi(int schoolCd, String content) {
        String sql = "INSERT INTO kuchikomi (school_cd, kuchikomi_content, kuchikomi_time) VALUES (?, ?, CURRENT_TIMESTAMP)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, schoolCd);
            pstmt.setString(2, content);

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
