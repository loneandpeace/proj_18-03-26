package com.hw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hw.common.MybatisUtils;
import com.hw.dao.UserDaoI;
import com.hw.entity.Cate;
import com.hw.entity.PageModel;
import com.hw.entity.User;

public class UserDaoImpl implements UserDaoI {

	@Override
	public PageModel<User> findAllUserByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		int offset=(pageNo-1)*pageSize;
		PageModel<User> pageModel=new PageModel<User>();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		List<User> list=sqlSession.selectList("com.hw.entity.User.findAllUserByPage", map);
		int totalCount=sqlSession.selectOne("com.hw.entity.User.findTotalCount", pageSize);
		pageModel.setData(list);
		
		int tp=(totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize+1);
		pageModel.setTotalCount(tp);
		
		sqlSession.close();
		return pageModel;
	}

	@Override
	public User findOneUser(int user_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		User user=sqlSession.selectOne("com.hw.entity.User.findOneUser",user_id);
		sqlSession.close();
		return user;
	}

	@Override
	public int deleteUser(int user_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		int res=sqlSession.delete("com.hw.entity.User.deleteUser",user_id);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int addNewAdministrator(User user) {
		// TODO Auto-generated method stub
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		map.put("phone", user.getPhone());
		map.put("email", user.getEmail());
		map.put("question", user.getQuestion());
		map.put("answer", user.getAnswer());
		
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		int res=sqlSession.delete("com.hw.entity.User.addNewAdministrator",map);
		sqlSession.commit();
		return res;
	}

	@Override
	public PageModel<User> searchUser(String username, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<User> pageModel=new PageModel<User>();
		Map<String,Object> map=new HashMap<String,Object>();
		int offset=(pageNo-1)*pageSize;
		map.put("offset", offset);
		map.put("info", username);
		map.put("pageSize", pageSize);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		List<User> list=sqlSession.selectList("com.hw.entity.User.searchUser",map);
		int count=sqlSession.selectOne("com.hw.entity.User.countSearchUser","%"+username+"%");
		pageModel.setData(list);
		pageModel.setTotalCount(count);
		return pageModel;
	}

}
