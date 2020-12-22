package com.links.service.impl;



import com.links.bean.User;
import com.links.dao.UserDao;
import com.links.dao.impl.UserDaoImpl;
import com.links.service.UserService;
import com.links.util.UUIDUtil;



public class UserServiceImpl implements UserService {
	UserDao userdao = new UserDaoImpl();

	/**
	 * 根据用户email检验，如果存在此email，返回true，否则返回false。
	 * 注册时查重使用
	 * @param email
	 * @return user
	 */
	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		boolean re = userdao.checkEmail(email);
		return re;
	}
	/**
	 * 根据用户名，密码检查登录，如果用户名和密码两个条件查询到用户，则返回用户对象，登录成功，否则返回null，登录失败
	 * 
	 * @param username
	 *            userPWD
	 * @return user对象
	 */
	@Override
	public User checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		User user = userdao.checkLogin(email, password);
		return user;
	}
	
	@Override
	public int addUser(User user) {
		user.setUserId(UUIDUtil.getUUID());
		int re=userdao.addUser(user);
		// TODO Auto-generated method stub
		return re;
	}
	
	
//	@Override
//	public User loginWEB(String userName,String userPWD) {
//		// TODO Auto-generated method stub
//		User user=userdao.checkLogin(userName, userPWD);
//		return user;
//	}

//	/**
//	 * 登录方法，根据用户输入的用户名，密码判断登录,并显示对应的菜单
//	 */
//	@Override
//	public void login() {
//		// TODO Auto-generated method stub
//		String uname = null;
//		String pass = null;
//		User user = null;
//		System.out.println("请输入您的用户名");
//		for (int i = 0; i <= 10; i++) {
//			uname = KeyboardIn.InPut();
//			if (!checkUsername(uname)) {
//				System.out.println("用户名不存在，请重新输入。");
//				if (i == 10) {
//					System.out.println("尝试次数过多，已自动退出！");
//					System.out.println("欢迎使用营销与客户管理系统");
//					System.out.println("1.注册    2.登录    3.退出系统");
//					return;
//				}
//			} else {
//				break;
//			}
//
//		}
//		System.out.println("请输入您的密码：");
//		for (int i = 0; i < 6; i++) {
//			pass = KeyboardIn.InPut();
//			user = checkLogin(uname, pass);
//			if (user == null) {
//				System.out.println("密码输入错误，请重新输入。");
//				if (i == 5) {
//					System.out.println("密码输入错误次数过多，已自动退出！");
//					System.out.println("欢迎使用营销与客户管理系统");
//					System.out.println("1.注册    2.登录    3.退出系统");
//					return;
//				}
//			} else {
//				break;
//			}
//
//		}
//		if (user.getState() == 1) {
//			System.out.println("您的账户已被冻结。");
//			return;
//		}
//		switch (user.getLevels()) {
//		case "0":
//			System.out.println("欢迎" + user.getUserName() + "系统管理员登录！！！");
//	//		AdminSYS.adminSYS();
//			break;
//		case "1":
//			System.out.println("欢迎" + user.getUserName() + "用户登录！！！");
//		//	UserSYS.userSYS();
//			break;
//		case "2":
//			System.out.println("欢迎" + user.getUserName() + "商品销售员登录！！！");
//		//	SaleSYS.saleSYS();
//			break;
//		default:
//			break;
//		}
//	}
//
//	/**
//	 * 根据用户的levels查询用户
//	 * 
//	 * @param level
//	 *            用户的等级
//	 * @return users 符合条件用户的集合
//	 */
//	@Override
//	public List<User> findUsersByLevel(String level) {
//		// TODO Auto-generated method stub
//		return userdao.findUsersByLevel(level);
//	}
//
//	/**
//	 * 修改对应id用户的状态
//	 * 
//	 * @param id
//	 *            用户id state 用户状态 1冻结 2启用阿
//	 * @return 修改成功返回true
//	 */
//	@Override
//	public boolean updateUserStete(String id, Integer state) {
//		// TODO Auto-generated method stub
//		return userdao.updateUserStete(id, state);
//	}
//
//	/**
//	 * 根据用户ID删除用户
//	 */
//	@Override
//	public boolean deleteUser(String id) {
//		// TODO Auto-generated method stub
//		return userdao.deleteUser(id);
//	}
//
//	/**
//	 * 注册方法
//	 * 
//	 * @param user
//	 * @return
//	 */
//	@Override
//	public void regist() {
//		// TODO Auto-generated method stub
//		User tempuser = new User();
//		// 校验用户类型
//		System.out.println("请输入注册用户类型");
//		System.out.println("1.普通用户   2.销售管理员");
//		String teplevel = KeyboardIn.InPut();
//		while (true) {
//			if (teplevel.equals("1") || teplevel.equals("2")) {
//				tempuser.setLevels(teplevel);
//				break;
//			} else {
//				System.out.println("用户类型不存在，请重新输入");
//				teplevel = KeyboardIn.InPut();
//			}
//		}
//		// 校验用户名
//		System.out.println("请输入注册用户名");
//		String tempuname = KeyboardIn.InPut();
//		while (true) {
//			if (!checkUsername(tempuname)) {
//				tempuser.setUserName(tempuname);
//				break;
//			} else {
//				System.out.println("您输入的用户名重复，请重新输入");
//				tempuname = KeyboardIn.InPut();
//			}
//		}
//		// 校验密码
//		System.out.println("请输入密码");
//		String temppass = KeyboardIn.InPut();
//		while (true) {
//			if (temppass.length() > 6) {
//				tempuser.setUserPWD(temppass);
//				break;
//			} else {
//				System.out.println("您输入的密码不满足要求，请输入大于6位数密码");
//				temppass = KeyboardIn.InPut();
//			}
//		}
//		tempuser.setDepid("0000");
//		tempuser.setState(0);
//		tempuser.setUserID(UUIDUtil.getUUID());
//		if (userdao.addUser(tempuser)>0) {
//			System.out.println("註冊成功");
//		}else {
//			System.out.println("註冊失敗");
//		}
//	}
//

//
//	@Override
//	public int registWEB(User user) {
//		// TODO Auto-generated method stub
//		int re=userdao.addUser(user);
//		return re;
//	}
	

}
