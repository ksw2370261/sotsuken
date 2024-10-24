package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Admin;

public class LoginDao extends Dao{
	public Admin search(String id, String password)
	throws Exception{
		Admin Login=null;

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement("select * from admin where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		while (rs.next()){
			Login=new Admin();
			Login.setId(rs.getString("id"));
			Login.setPassword(rs.getString("password"));
		}
		st.close();
		con.close();
		return Login;
	}
}