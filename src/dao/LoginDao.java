package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;

public class LoginDao extends Dao {
    // IDのみで検索するメソッド
    public Admin searchById(String admin_id) throws Exception {
        Admin login = null;

        try (Connection con = getConnection()) {
            PreparedStatement st = con.prepareStatement("SELECT * FROM admin WHERE admin_id = ?");
            st.setString(1, admin_id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                login = new Admin();
                login.setAdmin_Id(rs.getString("admin_id"));
                login.setPassword(rs.getString("password"));
            }
        }
        return login;
    }
}
