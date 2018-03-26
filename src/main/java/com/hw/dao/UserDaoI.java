package com.hw.dao;

import java.util.List;

import com.hw.entity.PageModel;
import com.hw.entity.User;

public interface UserDaoI {
	PageModel<User> findAllUserByPage(int pageNo, int pageSize);
	User findOneUser(int user_id);
	int deleteUser(int user_id);
	int addNewAdministrator(User user);
	PageModel<User> searchUser(String username, int pageNo, int pageSize);
}
