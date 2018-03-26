package com.hw.service;

import com.hw.entity.User;

public interface LoginService {
	public User loginAction(String username, String password);
	public boolean updateUserTokenService(String token,String username);
	public User checkUserTokenService(String token);
	public int removeUserTokenService(String username);
}
