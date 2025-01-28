package main;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MapViewAction extends Action {

    private static final String DB_URL = "jdbc:h2:~/teambtsubasa";
    private static final String DB_USER = "teambtsubasa";
    private static final String DB_PASSWORD = "";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String schoolCd = req.getParameter("schoolCd");

        if (schoolCd == null || schoolCd.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "学校コードが指定されていません。");
            return;
        }

        byte[] imageData = getMapImageFromDatabase(schoolCd);

        if (imageData != null) {
            res.setContentType("image/jpeg");
            try (OutputStream out = res.getOutputStream()) {
                out.write(imageData);
            }
        } else {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "マップが見つかりません。");
        }
    }

    private byte[] getMapImageFromDatabase(String schoolCd) {
        String sql = "SELECT image_data FROM map_image WHERE school_cd = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, schoolCd);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getBytes("image_data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
