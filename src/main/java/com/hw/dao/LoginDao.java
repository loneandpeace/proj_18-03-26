package com.hw.dao;

import com.hw.entity.User;

public interface LoginDao {
	public boolean checkUsername(String username);
	public User checkUsernameAndPassword(String username,String password);
	
	public boolean updateUsertoken(String token,String username);
	public User checkUserToken(String token);
	public int removeUserToken(String username);
}
