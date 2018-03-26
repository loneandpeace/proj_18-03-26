package com.hw.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	private int id;
	private int category_id;
	private String name;
	private String subtitle;
	private String main_image;
	private String sub_images;
	private String detail;
	private BigDecimal price;
	private int stock;
	private int status;
	private Date create_time;
	private Date update_time;
	
	private String cate_name;
	private String  front_update_time;
	private String  front_create_time;
	
	public Product() {
		super();
	}
	public Product(int id, int category_id, String name, String subtitle, String main_image, String sub_images,
			String detail, BigDecimal price, int stock, int status, Date create_time, Date update_time, String cate_name) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.name = name;
		this.subtitle = subtitle;
		this.main_image = main_image;
		this.sub_images = sub_images;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
		this.cate_name = cate_name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getMain_image() {
		return main_image;
	}
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
	public String getSub_images() {
		return sub_images;
	}
	public void setSub_images(String sub_images) {
		this.sub_images = sub_images;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
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
		return "Product [id=" + id + ", category_id=" + category_id + ", name=" + name + ", subtitle=" + subtitle
				+ ", main_image=" + main_image + ", sub_images=" + sub_images + ", detail=" + detail + ", price="
				+ price + ", stock=" + stock + ", status=" + status + ", create_time=" + create_time + ", update_time="
				+ update_time + ", catename=" + cate_name + "]";
	}
	
	
}
