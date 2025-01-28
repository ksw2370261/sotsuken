package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MapDeleteAction extends Action {

    private static final String DB_URL = "jdbc:h2:~/teambtsubasa";
    private static final String DB_USER = "teambtsubasa";
    private static final String DB_PASSWORD = "";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int imageId = Integer.parseInt(req.getParameter("imageId"));

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM map_image WHERE image_id = ?")) {

            stmt.setInt(1, imageId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("MapList.action");
    }
}
