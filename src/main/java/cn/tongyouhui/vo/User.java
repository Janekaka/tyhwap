package cn.tongyouhui.vo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int user_id;
	private String mobile;
	private String password;
	private String loginTime;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	
	
	
	
}
