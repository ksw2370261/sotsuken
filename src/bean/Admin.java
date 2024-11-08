// Admin.java

package bean;

public class Admin {
	private String admin_Id;  // データベースのカラム名に合わせて変更
	private String password;

	public String getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(String admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
