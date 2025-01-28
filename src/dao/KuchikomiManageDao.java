package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Kuchikomi;

public class KuchikomiManageDao {

    private Connection connection;

    public KuchikomiManageDao(Connection connection) {
        this.connection = connection;
    }

    // 管理者IDから学校コードを取得するメソッド
    public Integer getSchoolCdByAdminId(String adminId) {
        String sql = "SELECT school_cd FROM school WHERE admin_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, adminId);  // String型に合わせて変更
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("school_cd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // school_cdに基づいて口コミを取得するメソッド
    public List<Kuchikomi> getKuchikomiBySchoolCd(int schoolCd) {
        String sql = "SELECT kuchikomi_cd, kuchikomi_content, kuchikomi_time, kuchikomi_name FROM kuchikomi WHERE school_cd = ?";
        List<Kuchikomi> kuchikomiList = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, schoolCd);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Kuchikomi kuchikomi = new Kuchikomi();
                kuchikomi.setKuchikomiCd(rs.getInt("kuchikomi_cd"));
                kuchikomi.setKuchikomiContent(rs.getString("kuchikomi_content"));
                kuchikomi.setKuchikomiTime(rs.getTimestamp("kuchikomi_time"));
                kuchikomi.setKuchikomiName(rs.getString("kuchikomi_name"));  // 新しい列を取得
                kuchikomiList.add(kuchikomi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kuchikomiList;
    }
}
