package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Kuchikomi;

public class KuchikomiDao {
    private Connection connection;

    // Connectionを受け取るコンストラクタ
    public KuchikomiDao(Connection connection) {
        this.connection = connection;
    }

    // 口コミを全件取得するメソッド
    public List<Kuchikomi> getAllKuchikomi() throws Exception {
        List<Kuchikomi> kuchikomiList = new ArrayList<>();
        String sql = "SELECT * FROM kuchikomi ORDER BY kuchikomi_time DESC"; // SQL文

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Kuchikomi kuchikomi = new Kuchikomi();
                kuchikomi.setKuchikomi_id(rs.getString("kuchikomi_id"));
                kuchikomi.setKuchikomi_content(rs.getString("kuchikomi_content"));
                kuchikomi.setKuchikomi_time(rs.getTimestamp("kuchikomi_time"));
                kuchikomiList.add(kuchikomi);
            }
        }

        return kuchikomiList;
    }

    // 口コミを追加するメソッド
    public boolean addKuchikomi(Kuchikomi kuchikomi) throws Exception {
        String sql = "INSERT INTO kuchikomi (kuchikomi_content, kuchikomi_time) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, kuchikomi.getKuchikomi_content());
            ps.setTimestamp(2, kuchikomi.getKuchikomi_time());

            int result = ps.executeUpdate();
            if (result > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        // 自動生成された kuchikomi_id を取得
                        kuchikomi.setKuchikomi_id(rs.getString(1));  // 自動生成されたIDをセット
                    }
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
