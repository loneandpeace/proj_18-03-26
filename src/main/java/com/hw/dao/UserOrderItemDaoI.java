package com.hw.dao;

import java.util.List;

import com.hw.entity.UserOrderItem;
import com.hw.exception.OrderItemException;

public interface UserOrderItemDaoI {
	//添加订单的商品信息
	int addOrderItemsIntoDB(List<UserOrderItem> orderItemList) throws OrderItemException;
	//查询某个订单的商品详情
	List<UserOrderItem> findOrderItemsByOrderNo(Integer order_no) throws OrderItemException;
	
}
