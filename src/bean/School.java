//School.java
package bean;

public class School implements java.io.Serializable {
	private int schoolCd;         // `school_cd` に対応
	private String schoolName;    // `school_name` に対応

	// Getter メソッド
	public int getSchoolCd() {
		return schoolCd;
	}

	public String getSchoolName() {
		return schoolName;
	}

	// Setter メソッド
	public void setSchoolCd(int schoolCd) {
		this.schoolCd = schoolCd;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
