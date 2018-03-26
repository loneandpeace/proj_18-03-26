package com.hw.dao;

import com.hw.entity.PageModel;
import com.hw.entity.UserOrder;
import com.hw.exception.OrderException;

public interface UserOrderDaoI {
	//��Ӷ���
	int addOrder(UserOrder userOrder) throws OrderException;
	//��ҳ��ѯ����
	PageModel<UserOrder> findOrderByPage(Integer user_id, Integer pageNo, Integer pageSize) throws OrderException;
	//��ѯ��һ����
	UserOrder findOneOrderDetail(long order_no) throws OrderException;
	//��������
	int updateOrderStatusByOrderNo(long order_no,Integer status) throws OrderException;
	
	int findOrderStatus(long order_no);
	
	int findOrderPaymentType(long order_no);
	
	PageModel<UserOrder> findAllOrderByPage( Integer pageNo, Integer pageSize) throws OrderException;
	
	
	/*//ȡ������
	int cancelOrderByOrderNo(Integer order_no) throws OrderException;*/
}
