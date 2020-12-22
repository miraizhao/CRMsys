package com.links.bean;

import java.util.Date;

public class User {
	private String userId;
	private String email;
	private String userName;
	private String password;
	private Integer roleId;
	private Integer state;
	private Date create_date;
	private String remark;

	public User() {

	}

	public User(String userId, String email, String userName, String password, Integer roleId, Integer state,
			String remark) {
		super();
		this.userId = userId;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.state = state;
		this.remark = remark;
	}

	public User(String userId, String email, String userName, String password, Integer roleId, Integer state,
			Date create_date, String remark) {

		this.userId = userId;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.state = state;
		this.create_date = create_date;
		this.remark = remark;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", roleId=" + roleId + ", state=" + state + ", create_date=" + create_date + ", remark=" + remark
				+ "]";
	}

}
