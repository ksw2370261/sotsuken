// LoginDao.java

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;

public class LoginDao extends Dao {
    // IDのみで検索するメソッドを追加
    public Admin searchById(String admin_id) throws Exception {
        Admin login = null;

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM admin WHERE admin_id = ?");
        st.setString(1, admin_id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            login = new Admin();
            login.setAdmin_Id(rs.getString("admin_id"));
            login.setPassword(rs.getString("password"));
        }

        st.close();
        con.close();
        return login;
    }
}
