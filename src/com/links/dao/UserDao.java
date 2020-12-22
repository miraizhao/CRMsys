package com.links.dao;

import com.links.bean.User;

public interface UserDao {
	boolean checkEmail(String email);

	User checkLogin(String email, String password);

	int addUser(User user);

	//
	// List<User> findUsersByLevel(String roleId);
	//
	// boolean updateUserStete(String id, Integer state);
	//
	// boolean deleteUser(String id);
}
