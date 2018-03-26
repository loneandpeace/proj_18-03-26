package com.hw.service.impl;

import com.hw.dao.UserAccountDaoI;
import com.hw.dao.impl.UserAccountDaoImpl;
import com.hw.entity.User;
import com.hw.service.UserAccountServiceI;

public class UserAccountServiceImpl implements UserAccountServiceI {
	/*public static void main(String[] args) {
		User user=new UserAccountServiceImpl().addUserAccount(new User());
	}*/
	UserAccountDaoI userAccountDao=new UserAccountDaoImpl();
	@Override
	public boolean checkIfUserAccountnUserameAndEmailExist(String username, String email) {
		// TODO Auto-generated method stub
		//UserAccountDaoI userAccountDao=new UserAccountDaoImpl();
		boolean accountName_exist=userAccountDao.checkUserAccountName(username);
		boolean accountEmail_exist=userAccountDao.checkUserAccountEmail(email);
		if(accountName_exist&&accountEmail_exist) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean addUserAccount(User user) {
		// TODO Auto-generated method stub
		//UserAccountDaoI userAccountDao=new UserAccountDaoImpl();
		boolean addUserAccountAcction=false;
		
		
		addUserAccountAcction=userAccountDao.addUserAccount(user);
		if(addUserAccountAcction) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateUserTokenService(String token, String username) {
		// TODO Auto-generated method stub
		return userAccountDao.updateUsertoken(token, username);
	}

	@Override
	public User checkUserTokenService(String token) {
		// TODO Auto-generated method stub
		return userAccountDao.checkUserToken(token);
	}

	@Override
	public int removeUserTokenService(String username) {
		// TODO Auto-generated method stub
		return userAccountDao.removeUserToken(username);
	}

	@Override
	public User loginAction(String username, String password) {
		// TODO Auto-generated method stub
		User user=null;
		boolean username_exsit=userAccountDao.checkUserAccountName(username);
		
		if(username_exsit) {
			System.out.println("exist");
			user=userAccountDao.checkUserAccountNameAndPassword(username, password);
			return user;
		}else {
			return null;
		}
	}

}
