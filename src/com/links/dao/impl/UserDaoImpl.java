package com.links.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.links.bean.User;
import com.links.dao.UserDao;
import com.links.util.JDBCUtil;

public class UserDaoImpl implements UserDao {
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement pstate = null;
	private ResultSet rs = null;

	/**
	 * 根据用户email检验，如果存在此email，返回true，否则返回false。 注册时查重使用
	 * 
	 * @param email
	 * @return user
	 */
	@Override
	public boolean checkEmail(String email) {
		boolean re = false;
		conn = JDBCUtil.getConnection();
		String sql = "select ID,email,username,password,roleid,state,create_date,remark from TB_CRM_USER where email=?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, email);
			rs = pstate.executeQuery();
			if (rs.next()) {
				re = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		User user = null;
		conn = JDBCUtil.getConnection();
		String sql = "select ID,email,username,password,roleid,state,create_date,remark from TB_CRM_USER where email=? and password=?";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, email);
			pstate.setString(2, password);
			rs = pstate.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("ID"), rs.getString("email"), rs.getString("username"),
						rs.getString("password"), rs.getInt("roleid"), rs.getInt("state"), rs.getDate("create_date"),
						rs.getString("remark"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return user;
	}

	@Override
	public int addUser(User user) {
		int re = 0;

		conn = JDBCUtil.getConnection();
		String sql = "insert into TB_CRM_USER(ID,email,username,password,roleid,state,remark) values(?,?,?,?,?,?,?)";
		try {
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, user.getUserId());
			pstate.setString(2, user.getEmail());
			pstate.setString(3, user.getUserName());
			pstate.setString(4, user.getPassword());
			pstate.setInt(5, user.getRoleId());
			pstate.setInt(6, user.getState());
			pstate.setString(7, user.getRemark());
			re = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, statement, pstate, rs);
		}
		return re;
	}

	//
	// /**
	// * 根据用户的levels查询用户
	// *
	// * @param level
	// * 用户的等级
	// * @return users 符合条件用户的集合
	// */
	// @Override
	// public List<User> findUsersByLevel(String level) {
	// // TODO Auto-generated method stub
	// User user = null;
	// List<User> users = new ArrayList<User>();
	// conn = JDBCUtil.getConnection();
	// String sql = "select userid,username,userpwd,levels,state,depid from
	// sc_users where levels=?";
	// try {
	// pstate = conn.prepareStatement(sql);
	// pstate.setString(1, level);
	// rs = pstate.executeQuery();
	// while (rs.next()) {
	// user = new User(rs.getString("userid"), rs.getString("username"),
	// rs.getString("userpwd"),
	// rs.getString("levels"), rs.getInt("state"), rs.getString("depid"));
	// users.add(user);
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// JDBCUtil.close(conn, statement, pstate, rs);
	// }
	// return users;
	// }
	//
	// /**
	// * 修改对应id用户的状态
	// *
	// * @param id
	// * 用户id state 用户状态 1冻结 2启用
	// * @return 修改成功返回true
	// */
	// @Override
	// public boolean updateUserStete(String id, Integer state) {
	// // TODO Auto-generated method stub
	// int re = 0;
	// conn = JDBCUtil.getConnection();
	// String sql = "update sc_users set state = ? where userid=?";
	// try {
	// pstate = conn.prepareStatement(sql);
	// pstate.setString(2, id);
	// pstate.setInt(1, state);
	// re = pstate.executeUpdate();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// JDBCUtil.close(conn, statement, pstate, rs);
	// }
	//
	// return re > 0;
	// }
	//
	// /**
	// * 根据用户ID删除用户
	// */
	// @Override
	// public boolean deleteUser(String id) {
	// // TODO Auto-generated method stub
	// int re = 0;
	// conn = JDBCUtil.getConnection();
	// String sql = "delete from sc_users where userid=?";
	// try {
	// pstate = conn.prepareStatement(sql);
	// pstate.setString(1, id);
	// re = pstate.executeUpdate();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// JDBCUtil.close(conn, statement, pstate, rs);
	// }
	// return re > 0;
	// }

}
