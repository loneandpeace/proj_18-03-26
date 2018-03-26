package com.hw.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String question;
	private String answer;
	private String phone;
	private Date create_time;
	private Date update_time;
	private String front_create_time;
	private String front_update_time;
	private int role;
	private String ro;
	public User() {
		super();
	}
	public User(int id, String username, String password, String email, String question, String answer, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		long timestamp=	create_time.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.front_create_time= format.format(timestamp);
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		long timestamp=	update_time.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.front_update_time= format.format(timestamp);
		
		this.update_time = update_time;
	}
	
	public String getFront_create_time() {
		return front_create_time;
	}
	public void setFront_create_time(String front_create_time) {
		this.front_create_time = front_create_time;
	}
	public String getFront_update_time() {
		return front_update_time;
	}
	public void setFront_update_time(String front_update_time) {
		this.front_update_time = front_update_time;
	}
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		if(role==0) {
			this.ro="管理员";
		}else {
			this.ro="用户";
		}
		this.role = role;
	}
	public String getRo() {
		return ro;
	}
	public void setRo(String ro) {
		this.ro = ro;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", question=" + question + ", answer=" + answer + ", phone=" + phone + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", front_create_time=" + front_create_time + ", front_update_time="
				+ front_update_time + ", role=" + role + ", ro=" + ro + "]";
	}
	
	
	
	
	
}
