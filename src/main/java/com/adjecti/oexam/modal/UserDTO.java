package com.adjecti.oexam.modal;

import java.util.Set;

import com.adjecti.oexam.entity.Role;

import lombok.Data;
@Data
public class UserDTO {
	private String userId;
	private String userName;
	private String password;
	private boolean enable = true;
	private Set<Role> roles;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
