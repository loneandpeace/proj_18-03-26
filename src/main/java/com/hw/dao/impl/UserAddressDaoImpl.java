package com.hw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hw.common.MybatisUtils;
import com.hw.dao.UserAddressDaoI;
import com.hw.entity.Address;
import com.hw.entity.PageModel;

public class UserAddressDaoImpl implements UserAddressDaoI{

	@Override
	public int addAddress(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user_id", user_id);
		map.put("receiver_name", address.getReceiver_name());
		map.put("receiver_phone", address.getReceiver_phone());
		map.put("receiver_mobile", address.getReceiver_mobile());
		map.put("receiver_province", address.getReceiver_province());
		map.put("receiver_city", address.getReceiver_city());
		map.put("receiver_district", address.getReceiver_district());
		map.put("receiver_address", address.getReceiver_address());
		map.put("receiver_zip", address.getReceiver_zip());
		
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.insert("com.hw.entity.Address.addAddress", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int deleteAddressByUserId(Integer user_id, Integer id) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("id", id);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.delete("com.hw.entity.Address.deleteAddressByUserId", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int updateUserAddressByUserId(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		System.out.println("address------\n"+address);
		map.put("id", address.getId());
		map.put("user_id", user_id);
		map.put("receiver_name", address.getReceiver_name());
		map.put("receiver_phone", address.getReceiver_phone());
		map.put("receiver_mobile", address.getReceiver_mobile());
		map.put("receiver_province", address.getReceiver_province());
		map.put("receiver_city", address.getReceiver_city());
		map.put("receiver_district", address.getReceiver_district());
		map.put("receiver_address", address.getReceiver_address());
		map.put("receiver_zip", address.getReceiver_zip());
		
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.insert("com.hw.entity.Address.updateUserAddressByUserId", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public PageModel<Address> findUserAddress(Integer user_id, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map=new HashMap<String, Integer>();
		PageModel<Address> pageModel=new PageModel<Address>();
		int offset=(pageNo-1)*pageSize;
		map.put("user_id", user_id);
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession();
		List<Address> list=sqlSession.selectList("com.hw.entity.Address.findUserAddressByPage", map);
		pageModel.setData(list);
		int res=sqlSession.selectOne("com.hw.entity.Address.findTotalCount", map);
		int totalCount=res%pageSize==0?res/pageSize:(res/pageSize)+1;
		pageModel.setTotalCount(totalCount);
		sqlSession.close();
		return pageModel;
	}

	@Override
	public Address findOneAddress(Integer id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		Object o=sqlSession.selectOne("com.hw.entity.Address.findOneAddress", id);
		sqlSession.close();
		if(o instanceof Address) {
			Address address=(Address)o;
			return address;
		}else{
			return null;
		}
	}

	@Override
	public PageModel<Address> findAllUserAddress(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
		PageModel<Address> pageModel=new PageModel<Address>();
		int offset=(pageNo-1)*pageSize;
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		map.put("user_id", -1);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession();
		List<Address> list=sqlSession.selectList("com.hw.entity.Address.findAllAddressByPage", map);
		pageModel.setData(list);
		int res=sqlSession.selectOne("com.hw.entity.Address.findTotalCount", map);
		int totalCount=res%pageSize==0?res/pageSize:(res/pageSize)+1;
		pageModel.setTotalCount(totalCount);
		sqlSession.close();
		return pageModel;
	}

}
