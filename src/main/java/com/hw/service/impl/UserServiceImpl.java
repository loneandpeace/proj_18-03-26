package com.hw.service.impl;

import com.hw.dao.UserDaoI;
import com.hw.dao.impl.UserDaoImpl;
import com.hw.entity.PageModel;
import com.hw.entity.User;
import com.hw.service.UserServiceI;

public class UserServiceImpl implements UserServiceI{
	UserDaoI userDao=new UserDaoImpl();
	@Override
	public PageModel<User> findAllUserByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.findAllUserByPage(pageNo, pageSize);
	}
	@Override
	public User findOneUser(int user_id) {
		// TODO Auto-generated method stub
		return userDao.findOneUser(user_id);
	}
	@Override
	public int deleteUser(int user_id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user_id);
	}
	@Override
	public int addNewAdministrator(User user) {
		// TODO Auto-generated method stub
		return userDao.addNewAdministrator(user);
	}
	@Override
	public PageModel<User> searchUser(String username, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.searchUser(username, pageNo, pageSize);
	}

}
