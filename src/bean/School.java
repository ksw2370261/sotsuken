package bean;

public class School implements java.io.Serializable {
	private String id;
	private String school_id;
	private String school_name;


	public String getId() {
		return id;
	}

	public String getSchool_id() {
		return school_id;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
}

