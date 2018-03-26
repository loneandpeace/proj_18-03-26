package com.hw.service;

import com.hw.entity.User;

public interface UserAccountServiceI {
	public boolean addUserAccount(User user);
	public boolean checkIfUserAccountnUserameAndEmailExist(String username,String email);
	public User loginAction(String username, String password);
	public boolean updateUserTokenService(String token,String username);
	public User checkUserTokenService(String token);
	public int removeUserTokenService(String username);
}
