package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Kuchikomi;

public class KuchikomiDao {
    private static final String URL = "jdbc:h2:~/teambtsubasa";  // 適切なJDBC URLを指定
    private static final String USER = "teambtsubasa";           // データベースのユーザー名
    private static final String PASSWORD = "";                   // データベースのパスワード

    // 学校コードに基づいて口コミを取得するメソッド
    public List<Kuchikomi> getKuchikomiBySchoolCd(int schoolCd) {
        List<Kuchikomi> kuchikomiList = new ArrayList<>();
        String sql = "SELECT kuchikomi_cd, kuchikomi_content, kuchikomi_time, kuchikomi_name FROM kuchikomi WHERE school_cd = ? ORDER BY kuchikomi_time DESC";

        try {
            // JDBCドライバの読み込み
            Class.forName("org.h2.Driver");

            // データベース接続
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // schoolCdをクエリに設定
                pstmt.setInt(1, schoolCd);

                // クエリを実行し、結果セットを取得
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Kuchikomi kuchikomi = new Kuchikomi();
                        kuchikomi.setKuchikomiCd(rs.getInt("kuchikomi_cd"));
                        kuchikomi.setKuchikomiContent(rs.getString("kuchikomi_content"));
                        kuchikomi.setKuchikomiTime(rs.getTimestamp("kuchikomi_time"));
                        kuchikomi.setKuchikomiName(rs.getString("kuchikomi_name"));  // kuchikomi_name を追加
                        kuchikomiList.add(kuchikomi);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kuchikomiList;
    }
}
