package com.hw.dao;

import com.hw.entity.PageModel;
import com.hw.entity.UserOrder;
import com.hw.exception.OrderException;

public interface UserOrderDaoI {
	//添加订单
	int addOrder(UserOrder userOrder) throws OrderException;
	//分页查询订单
	PageModel<UserOrder> findOrderByPage(Integer user_id, Integer pageNo, Integer pageSize) throws OrderException;
	//查询单一订单
	UserOrder findOneOrderDetail(long order_no) throws OrderException;
	//订单发货
	int updateOrderStatusByOrderNo(long order_no,Integer status) throws OrderException;
	
	int findOrderStatus(long order_no);
	
	int findOrderPaymentType(long order_no);
	
	PageModel<UserOrder> findAllOrderByPage( Integer pageNo, Integer pageSize) throws OrderException;
	
	
	/*//取消订单
	int cancelOrderByOrderNo(Integer order_no) throws OrderException;*/
}
