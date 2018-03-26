package com.hw.service.impl;

import com.hw.dao.LoginDao;
import com.hw.dao.impl.LoginDaoImpl;
import com.hw.entity.User;
import com.hw.service.LoginService;

public class LoginServiceImpl implements LoginService {
	//LoginDao logindao=new LoginDaoImpl();
	LoginDao logindao=new LoginDaoImpl();
	
	public User loginAction(String username, String password) {
		
		User user=null;
		boolean username_exsit=logindao.checkUsername(username);
		
		if(username_exsit) {
			user=logindao.checkUsernameAndPassword(username, password);
			return user;
		}else {
			return null;
		}
		
	}

	@Override
	public boolean updateUserTokenService(String token, String username) {
		// TODO Auto-generated method stub
		return logindao.updateUsertoken(token, username);
	}

	@Override
	public User checkUserTokenService(String token) {
		// TODO Auto-generated method stub
		User user=logindao.checkUserToken(token);
		if(user!=null) {
			return user;
		}else {
			return null;
		}
	}

	@Override
	public int removeUserTokenService(String username) {
		// TODO Auto-generated method stub
		return logindao.removeUserToken(username);
	}

}
