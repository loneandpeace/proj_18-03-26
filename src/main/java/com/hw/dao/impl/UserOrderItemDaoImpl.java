package com.hw.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hw.common.MybatisUtils;
import com.hw.dao.UserOrderItemDaoI;
import com.hw.entity.UserOrderItem;
import com.hw.exception.OrderItemException;

public class UserOrderItemDaoImpl implements UserOrderItemDaoI {

	@Override
	public int addOrderItemsIntoDB(List<UserOrderItem> orderItemList) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.insert("com.hw.entity.UserOrderItem.addOrderItems",orderItemList);
		sqlSession.commit();
		sqlSession.close();
		for(UserOrderItem o : orderItemList) {
			System.out.println(o);
		}
		return res;
	}
	/***
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	@Override
	public List<UserOrderItem> findOrderItemsByOrderNo(Integer order_no) throws OrderItemException {
		// TODO Auto-generated method stub
		return null;
	}

}
