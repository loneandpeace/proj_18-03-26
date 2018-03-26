package com.hw.dao;

import com.hw.entity.User;

public interface UserAccountDaoI {
	
	public boolean checkUserAccountName(String username);
	public boolean checkUserAccountEmail(String email);
	
	public User checkUserAccountNameAndPassword(String username,String password);
	
	public boolean addUserAccount(User user);
	public boolean deleteUserAccount(User user);
	public boolean updateUserAccount(User user);
	
	public boolean updateUsertoken(String token,String username);
	public User checkUserToken(String token);
	public int removeUserToken(String username);
	
}
