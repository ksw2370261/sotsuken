package main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/mapImage")
public class MapImageServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:h2:~/teambtsubasa";
    private static final String DB_USER = "teambtsubasa";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String schoolCd = request.getParameter("schoolCd");
        String mapName = request.getParameter("mapName");

        if (schoolCd == null || mapName == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "学校のIDまたはマップ名が指定されていません。");
            return;
        }

        String sql = "SELECT image_data FROM map_image WHERE school_cd = ? AND map_name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, schoolCd);
            stmt.setString(2, mapName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Blob imageBlob = rs.getBlob("image_data");
                InputStream imageStream = imageBlob.getBinaryStream();
                response.setContentType("image/jpeg");
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = imageStream.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "指定されたマップが見つかりません。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "データベースエラーが発生しました。");
        }
    }
}
