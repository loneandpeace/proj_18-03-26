package com.hw.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hw.common.MybatisUtils;
import com.hw.dao.UserAccountDaoI;
import com.hw.entity.User;

public class UserAccountDaoImpl implements UserAccountDaoI {

	@Override
	public boolean checkUserAccountName(String username) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		Object o=sqlSession.selectOne("com.hw.entity.UserCustomer.checkUsername", username);
		int res=(Integer)o;
		sqlSession.close();
		if(res==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean checkUserAccountEmail(String email) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		Object o=sqlSession.selectOne("com.hw.entity.UserCustomer.checkUserAccountEmail", email);
		if(o instanceof User) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User checkUserAccountNameAndPassword(String username, String password) {
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
		Object o=sqlSession.selectOne("com.hw.entity.UserCustomer.checkUsernameAndPassword", map);
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
	public boolean addUserAccount(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.insert("com.hw.entity.UserCustomer.addUserAccount", user);
		sqlSession.commit();
		sqlSession.close();
		if(res>0) {
			return true;
		}else {
			return false;
		}
		/*
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="insert into user(username,password,email,phone,question,answer,role,create_time,update_time) values(?,?,?,?,?,?,1,now(),now())";
			ps=conn.prepareStatement(sql);
			//ps.setInt(1, cate.getId());
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getQuestion());
			ps.setString(6, user.getAnswer());
			int res=ps.executeUpdate();
			if(res>0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}

	@Override
	public boolean deleteUserAccount(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserAccount(User user) {
		// TODO Auto-generated method stub
		return false;
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
		int res=sqlSession.update("com.hw.entity.UserCustomer.updateUsertoken", map);
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
		Object o=sqlSession.selectOne("com.hw.entity.UserCustomer.checkUserToken", token);
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
		int res=sqlSession.update("com.hw.entity.UserCustomer.removeUserToken", username);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}	
	
}
