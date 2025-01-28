package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MapImage;

public class MapDao {

    private Connection connection;

    // コンストラクタでデータベース接続を受け取る
    public MapDao(Connection connection) {
        this.connection = connection;
    }

    // school_cdに基づいてマップ画像の情報を取得するメソッド
    public List<MapImage> getMapImagesBySchoolCd(Integer schoolCd) {
        List<MapImage> mapImages = new ArrayList<>();
        String sql = "SELECT image_id, map_name FROM map_image WHERE school_cd = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, schoolCd);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MapImage mapImage = new MapImage(rs.getString("map_name"), null); // imageDataは使用しません
                mapImage.setImageId(rs.getInt("image_id"));
                mapImages.add(mapImage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapImages;
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
}
