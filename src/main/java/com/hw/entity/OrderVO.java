package com.hw.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hw.consts.OrderStatusEnum;
import com.hw.consts.PaymentTypeEnum;

public class OrderVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 340771368687279187L;
	
	
	private Integer id;
	private Long order_no;
	private Integer user_id;
	private Integer shipping_id;
	private String payment;
	private String payment_type;
	private Integer postage;
	private String status;
	private String payment_time;
	private String send_time;
	private String end_time;
	private String close_time;
	private String create_time;
	private String update_time;
	
	private Address address;
	private User user;
	private List<UserOrderItem> orderItems;
	
	public OrderVO() {
		super();
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public Integer getPostage() {
		return postage;
	}
	public void setPostage(Integer postage) {
		this.postage = postage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getClose_time() {
		return close_time;
	}
	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public List<UserOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<UserOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", shipping_id=" + shipping_id
				+ ", payment=" + payment + ", payment_type=" + payment_type + ", postage=" + postage + ", status="
				+ status + ", payment_time=" + payment_time + ", send_time=" + send_time + ", end_time=" + end_time
				+ ", close_time=" + close_time + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", address=" + address + ", user=" + user + ", orderItems=" + orderItems + "]";
	}

	
	
	
	
	
	
	
	
	
	public void convertOrderToOrderVo(UserOrder order) {
		
		this.id=order.getId();
		this.order_no=order.getOrder_no();
		this.payment=order.getPayment().toString();
		this.user_id=order.getUser_id();
		this.shipping_id=order.getShipping_id();
		this.address=order.getAddress();
		this.user=order.getUser();
		this.orderItems=order.getOrderItems();
		Integer pType=order.getPayment_type();
		if(pType==PaymentTypeEnum.ONLINE.getType()) {
			this.payment_type=PaymentTypeEnum.ONLINE.getMsg();
		}else if(pType==PaymentTypeEnum.OFFLINE.getType()) {
			this.payment_type=PaymentTypeEnum.OFFLINE.getMsg();
		}
		
		this.postage=order.getPostage();
		int statu=order.getStatus();
		if(statu==OrderStatusEnum.CANCEL.getStatus()) {
			this.status=OrderStatusEnum.CANCEL.getMessage();
		}else if(statu==OrderStatusEnum.UNPAY.getStatus()) {
			this.status=OrderStatusEnum.UNPAY.getMessage();
		}else if(statu==OrderStatusEnum.PAY.getStatus()) {
			this.status=OrderStatusEnum.PAY.getMessage();
		}else if(statu==OrderStatusEnum.SEND.getStatus()) {
			this.status=OrderStatusEnum.SEND.getMessage();
		}else if(statu==OrderStatusEnum.SUCCCESS.getStatus()) {
			this.status=OrderStatusEnum.SUCCCESS.getMessage();
		}else if(statu==OrderStatusEnum.CLOSE.getStatus()) {
			this.status=OrderStatusEnum.CLOSE.getMessage();
		}
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date=null;
		if((date=order.getPayment_time())!= null) {
			this.payment_time=format.format(date.getTime());
		}
		date=null;
		if((date=order.getSend_time())!= null) {
			this.send_time=format.format(date.getTime());
		}
		date=null;
		if((date=order.getEnd_time())!= null) {
			this.end_time=format.format(date.getTime());
		}
		date=null;
		if((date=order.getClose_time())!= null) {
			this.close_time=format.format(date.getTime());
		}
		date=null;
		if((date=order.getCreate_time())!= null) {
			this.create_time=format.format(date.getTime());
		}
		date=null;
		if((date=order.getUpdate_time())!= null) {
			this.update_time=format.format(date.getTime());
		}
		
	}

	
}
