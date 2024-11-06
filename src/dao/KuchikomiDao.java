package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Kuchikomi;

public class KuchikomiDao {

    private Connection connection;

    // コンストラクタでデータベース接続を受け取る
    public KuchikomiDao(Connection connection) {
        this.connection = connection;
    }

    // イベントをデータベースに追加するメソッド
    public boolean addKuchikomi(Kuchikomi kuchikomi) {
        String sql = "INSERT INTO kuchikomi (kuchikomi_id, kuchikomi_content,kuchikomi_time) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, kuchikomi.getKuchikomi_id());
            pstmt.setString(2, kuchikomi.getKuchikomi_content());
            pstmt.setString(3, kuchikomi.getKuchikomi_time());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}