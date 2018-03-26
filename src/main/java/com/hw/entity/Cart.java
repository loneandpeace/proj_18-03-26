package com.hw.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5000281090961579867L;
	
	
	private int id;
	private int user_id;
	private int product_id;
	private int quantity;
	private int checked;
	private Date create_time;
	private Date update_time;
	private Product product;
	private User user;
	
	private String  front_update_time;
	private String  front_create_time;
	
	public Cart() {
		super();
	}
	public Cart(int id, int user_id, int product_id, int quantity, int checked, Date create_time, Date update_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.checked = checked;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFront_update_time() {
		return front_update_time;
	}
	public void setFront_update_time(String front_update_time) {
		this.front_update_time = front_update_time;
	}
	public String getFront_create_time() {
		return front_create_time;
	}
	public void setFront_create_time(String front_create_time) {
		this.front_create_time = front_create_time;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", quantity=" + quantity
				+ ", checked=" + checked + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", product=" + product + ", user=" + user + ", front_update_time=" + front_update_time
				+ ", front_create_time=" + front_create_time + "]";
	}
	
}
