package com.hw.service;

import javax.servlet.http.HttpServletRequest;
import com.hw.entity.OrderVO;
import com.hw.entity.PageModel;
import com.hw.exception.OrderException;

public interface UserOrderServiceI {
	int createOrder(Integer user_id, HttpServletRequest request) throws OrderException;
	//PageModel<UserOrder> findOrderByPage(Integer user_id, HttpServletRequest request) throws OrderException;
	PageModel<OrderVO> findOrderByPage(Integer user_id, HttpServletRequest request) throws OrderException;
	//List<UserOrderItem> convertCartToUserOrderItem(List<Cart> cartList);
	OrderVO findOneOrderDetailServlce(HttpServletRequest request);
	
	int updateOrderStatusByOrderNoService(HttpServletRequest request);
	
	PageModel<OrderVO> findAllOrderByPage(HttpServletRequest request) throws OrderException;
}
