//LoginDao.java

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;

public class LoginDao extends Dao{
	public Admin search(String admin_id, String password)
	throws Exception{
		Admin Login=null;

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement("select * from admin where admin_id=? and password=?");
		st.setString(1, admin_id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Login=new Admin();
			Login.setId(rs.getString("admin_id"));
			Login.setPassword(rs.getString("password"));
		}
		st.close();
		con.close();
		return Login;
	}
}