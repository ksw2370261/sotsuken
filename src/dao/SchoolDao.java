// SchoolDao.java
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class SchoolDao {
    private static final String URL = "jdbc:h2:~/teambtsubasa";
    private static final String USER = "teambtsubasa";
    private static final String PASSWORD = "";

    public List<School> getSchools() {
        List<School> schools = new ArrayList<>();
        String sql = "SELECT school_cd, school_name FROM school";

        try {
            Class.forName("org.h2.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    School school = new School();
                    school.setSchoolCd(rs.getInt("school_cd"));
                    school.setSchoolName(rs.getString("school_name"));
                    schools.add(school);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return schools;
    }
}
