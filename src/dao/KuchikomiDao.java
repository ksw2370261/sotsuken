package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import bean.Kuchikomi;

public class KuchikomiDao {

    private Connection connection;

    // コンストラクタでデータベース接続を受け取る
    public KuchikomiDao(Connection connection) {
        this.connection = connection;
    }

    // 口コミをデータベースに追加するメソッド
    public boolean addKuchikomi(Kuchikomi kuchikomi) {
        String sql = "INSERT INTO kuchikomi (kuchikomi_id, kuchikomi_content, kuchikomi_time) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, kuchikomi.getKuchikomi_id());
            pstmt.setString(2, kuchikomi.getKuchikomi_content());

            // kuchikomi_timeをTimestamp型で設定
            Timestamp kuchikomiTime = kuchikomi.getKuchikomi_time();  // kuchikomi_timeはTimestamp型として取得
            pstmt.setTimestamp(3, kuchikomiTime);  // setTimestampを使用

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // ロギングを追加してエラーメッセージを記録
            e.printStackTrace();
            return false;
        }
    }
}
