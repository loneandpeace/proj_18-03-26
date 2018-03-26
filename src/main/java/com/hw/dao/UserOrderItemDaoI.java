package com.hw.dao;

import java.util.List;

import com.hw.entity.UserOrderItem;
import com.hw.exception.OrderItemException;

public interface UserOrderItemDaoI {
	//��Ӷ�������Ʒ��Ϣ
	int addOrderItemsIntoDB(List<UserOrderItem> orderItemList) throws OrderItemException;
	//��ѯĳ����������Ʒ����
	List<UserOrderItem> findOrderItemsByOrderNo(Integer order_no) throws OrderItemException;
	
}
