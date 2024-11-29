package main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mapImage")
public class MapImageServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:h2:~/teambtsubasa";
    private static final String DB_USER = "teambtsubasa";
    private static final String DB_PASSWORD = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mapName = request.getParameter("mapName");

        if (mapName != null) {
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String sql = "SELECT image_data FROM map_image WHERE map_name = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, mapName);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        InputStream imageData = rs.getBinaryStream("image_data");
                        response.setContentType("image/png");  // 画像の種類に応じて変更
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = imageData.read(buffer)) != -1) {
                            response.getOutputStream().write(buffer, 0, bytesRead);
                        }
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND);  // 画像が見つからない場合
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);  // パラメータが不足している場合
        }
    }
}
