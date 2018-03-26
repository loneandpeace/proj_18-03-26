package com.hw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hw.common.MybatisUtils;
import com.hw.dao.UserOrderDaoI;
import com.hw.entity.PageModel;
import com.hw.entity.UserOrder;
import com.hw.exception.OrderException;

public class UserOrderDaoImpl implements UserOrderDaoI {

	@Override
	public int addOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		int res=sqlSession.insert("com.hw.entity.UserOrder.addOrder", userOrder);
		sqlSession.close();
		return res;
	}

	
	@Override
	public PageModel<UserOrder> findOrderByPage(Integer user_id, Integer pageNo, Integer pageSize) throws OrderException {
		// TODO Auto-generated method stub
		int offset=(pageNo-1)*pageSize;
		int res=0;
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		Object o=sqlSession.selectOne("com.hw.entity.UserOrder.findTotalCount", user_id);
		if(o==null) {
			throw new OrderException("用户订单条目为0");
		}else {
			res=(Integer)o;
		}
		//List<UserOrder> list=sqlSession.selectList("com.hw.entity.UserOrder.findOrderByPage", map);
		List<UserOrder> list=sqlSession.selectList("com.hw.entity.UserOrder.findOrderAddressUserByPage", map);
		PageModel<UserOrder> pageModel=new PageModel<UserOrder>();
		int totalCount=res%pageSize==0?res/pageSize:res/pageSize+1;
		pageModel.setData(list);
		pageModel.setTotalCount(totalCount);
		sqlSession.close();
		return pageModel;
		
	}
	/***
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	@Override
	public UserOrder findOneOrderDetail(long order_no) throws OrderException {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		UserOrder order=sqlSession.selectOne("com.hw.entity.UserOrder.findOneOrderDetail", order_no);
		if(order==null) {
			throw new OrderException("查询的订单为空订单，不存在商品");
		}
		sqlSession.close();
		return order;
	}
	/***
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	@Override
	public int updateOrderStatusByOrderNo(long order_no,Integer status) throws OrderException {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("order_no", order_no);
		map.put("status", status);
		int res=sqlSession.update("com.hw.entity.UserOrder.updateOrderStatusByOrderNo", map);
		sqlSession.close();
		return res;
	}


	@Override
	public int findOrderStatus(long order_no) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		Object o=sqlSession.selectOne("com.hw.entity.UserOrder.findOrderStatus", order_no);
		sqlSession.close();
		if(o!=null) {
			int status=(int)o;
			return status;
		}else {
			throw new OrderException("试图修改订单状态的订单号不存在于数据库-findOrderStatus");
		}
		
	}


	@Override
	public int findOrderPaymentType(long order_no) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		Object o=sqlSession.selectOne("com.hw.entity.UserOrder.findOrderPaymentType", order_no);
		sqlSession.close();
		if(o!=null) {
			int status=(int)o;
			return status;
		}else {
			throw new OrderException("试图修改订单状态的订单号不存在于数据库-findOrderPaymentType");
		}
	}


	@Override
	public PageModel<UserOrder> findAllOrderByPage(Integer pageNo, Integer pageSize) throws OrderException {
		// TODO Auto-generated method stub
		int offset=(pageNo-1)*pageSize;
		int res=0;
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		Object o=sqlSession.selectOne("com.hw.entity.UserOrder.findAllTotalCount");
		if(o==null) {
			throw new OrderException("数据库中的订单条目为0");
		}else {
			res=(Integer)o;
		}
		//List<UserOrder> list=sqlSession.selectList("com.hw.entity.UserOrder.findOrderByPage", map);
		List<UserOrder> list=sqlSession.selectList("com.hw.entity.UserOrder.findAllOrderAddressUserByPage", map);
		PageModel<UserOrder> pageModel=new PageModel<UserOrder>();
		int totalCount=res%pageSize==0?res/pageSize:res/pageSize+1;
		pageModel.setData(list);
		pageModel.setTotalCount(totalCount);
		sqlSession.close();
		return pageModel;
	}

	

}
