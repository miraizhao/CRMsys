package com.links.service;



import com.links.bean.User;

public interface UserService {
	boolean checkEmail(String email);

	User checkLogin(String email, String password);
	
	int addUser(User user);
//	User loginWEB(String userName,String userPWD);
	

//	public void login();
//
//	List<User> findUsersByLevel(String level);
//
//	boolean updateUserStete(String id, Integer state);
//
//	boolean deleteUser(String id);
//
//	void regist();
//	

//	int registWEB(User user);
}
