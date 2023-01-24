package sec01.ex01;

import java.sql.Date;

public class MemberBean {
	
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String user_phone;
	private Date user_date;

	public MemberBean() {}

	public MemberBean(String user_id, String user_pwd, String user_name, String user_phone) {
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_phone = user_phone;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	
	public Date getUser_date() {
		return user_date;
	}
	
	public void setUser_date(Date user_date) {
		this.user_date = user_date;
	}


}
