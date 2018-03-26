package com.hw.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cate {
	private int id;
	private int parent_id;
	private String name;
	private int status;
	private int sort_order;
	private Date create_time;
	private Date update_time;
	
	private String  front_update_time;
	private String  front_create_time;
	
	public Cate(int id, int parent_id, String name, int status, int sort_order, Date createtime, Date updatetime) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.status = status;
		this.sort_order = sort_order;
		this.create_time = createtime;
		this.update_time = updatetime;
	}
	public Cate() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date createtime) {
		long timestamp=	createtime.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.front_create_time= format.format(timestamp);
		
		this.create_time = createtime;
	}
	public Date getUpdate_time() {
	
		return update_time;
	}
	public void setUpdate_time(Date updatetime) {
		long timestamp=	updatetime.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.front_update_time= format.format(timestamp);
		
		this.update_time = updatetime;
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
	@Override
	public String toString() {
		return "Cate [id=" + id + ", parent_id=" + parent_id + ", name=" + name + ", status=" + status + ", sort_order="
				+ sort_order + ", createtime=" + create_time + ", updatetime=" + update_time + "]";
	}
	
	
}
