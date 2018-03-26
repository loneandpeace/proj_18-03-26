package com.hw.entity;

import java.io.Serializable;

//�û���¼��Ϣ
public class LoginVO implements Serializable{
	
	public static final int LOGIN_SUCCESS=1;
	public static final int LOGIN_FAIL=0;
	
	private int errorno;
	private String message;
	private User user;
	
	public int getErrorno() {
		return errorno;
	}
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
