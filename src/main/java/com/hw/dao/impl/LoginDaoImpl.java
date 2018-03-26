package com.hw.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hw.common.MybatisUtils;
import com.hw.dao.LoginDao;
import com.hw.entity.User;

public class LoginDaoImpl implements LoginDao{

	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		Object o=sqlSession.selectOne("com.hw.entity.User.checkUsername", username);
		int res=(Integer)o;
		sqlSession.close();
		if(res==1) {
			return true;
		}else {
			return false;
		}
		
	}



	@Override
	public User checkUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		
		User user=null;
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", username);
		map.put("password", password);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		//sqlSession=sqlMapper.openSession(false);
		//sqlSession.comit();
		Object o=sqlSession.selectOne("com.hw.entity.User.checkUsernameAndPassword", map);
		if(o instanceof User) {
			user=(User)o;
		}
		sqlSession.close();
		if(user!=null) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public boolean updateUsertoken(String token, String username) {
		// TODO Auto-generated method stub
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("token", token);
		map.put("username", username);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		//sqlSession=sqlMapper.openSession();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.update("com.hw.entity.User.updateUsertoken", map);
		sqlSession.commit();
		sqlSession.close();
		if(res>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public User checkUserToken(String token) {
		// TODO Auto-generated method stub
		
		User user=null;
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		//sqlSession=sqlMapper.openSession(false);
		//sqlSession.comit();
		Object o=sqlSession.selectOne("com.hw.entity.User.checkUserToken", token);
		if(o instanceof User) {
			user=(User)o;
		}
		sqlSession.close();
		if(user!=null) {
			return user;
		}else {
			return null;
		}
	}



	@Override
	public int removeUserToken(String username) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		//sqlSession=sqlMapper.openSession();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.update("com.hw.entity.User.removeUserToken", username);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

}
