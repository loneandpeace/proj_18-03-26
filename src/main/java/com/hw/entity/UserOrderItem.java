package com.hw.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserOrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2193473061943589941L;
	
	private Integer id;
	private Long order_no;
	private int user_id;
	private int product_id;
	private String product_name;
	private String product_image;
	private BigDecimal current_unit_price;
	private int quantity;
	private int payment;
	private BigDecimal total_price;
	private Date create_time;
	private Date update_time;
	
	
	private String  front_update_time;
	private String  front_create_time;
	
	public UserOrderItem() {
		super();
	}
	

	public UserOrderItem(Integer id, Long order_no, int user_id, int product_id, String product_name,
			String product_image, BigDecimal current_unit_price, int quantity, int payment, BigDecimal total_price,
			Date create_time, Date update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.current_unit_price = current_unit_price;
		this.quantity = quantity;
		this.payment = payment;
		this.total_price = total_price;
		this.create_time = create_time;
		this.update_time = update_time;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public BigDecimal getCurrent_unit_price() {
		return current_unit_price;
	}
	public void setCurrent_unit_price(BigDecimal current_unit_price) {
		this.current_unit_price = current_unit_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	public Date getCreate_time() {
		return create_time;
	}
	/*public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}*/
	public void setCreate_time(Date create_time) {
		long timestamp=	create_time.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.front_create_time= format.format(timestamp);
		
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	/*public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}*/
	public void setUpdate_time(Date update_time) {
		long timestamp=	update_time.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.front_update_time= format.format(timestamp);
		
		this.update_time = update_time;
	}
	
	public int getPayment() {
		return payment;
	}


	public void setPayment(int payment) {
		this.payment = payment;
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
		return "UserOrderItem [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", product_id="
				+ product_id + ", product_name=" + product_name + ", product_image=" + product_image
				+ ", current_unit_price=" + current_unit_price + ", quantity=" + quantity + ", total_price="
				+ total_price + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	
}
