package com.links.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.links.bean.User;
import com.links.service.UserService;
import com.links.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	UserService userService = new UserServiceImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("UserServlet被请求成功");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		User user = null;
		String method = request.getParameter("method");
		String email ;
		String username;
		String password;
		Integer roleId;
		Integer state;
		String remark;
		HttpSession session=request.getSession();
		switch (method) {
		case "login":
			email = request.getParameter("email");
			 password = request.getParameter("password");
			user = userService.checkLogin(email, password);
			if (user != null) {
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(10);
				response.sendRedirect("index.jsp");
			} else {
				response.getWriter().print("<script>alert('登录失败，用户名密码不匹配');window.location.href='Login.jsp';</script>");
			}
			break;
		case "adduser":
			user = new User();
			email = request.getParameter("email");
			username = request.getParameter("userName");
			roleId = Integer.parseInt(request.getParameter("roleId"));
			state=Integer.parseInt(request.getParameter("state"));
			remark=request.getParameter("remark");
			user=new User(null, email, username, "123456", roleId, state, remark);
			int re = userService.addUser(user);
			if (re > 0) {
				System.out.println("添加成功");
				request.setAttribute("info", "添加成功！！！");
				request.getRequestDispatcher("info.jsp").forward(request, response);
			} else {
				System.out.println("添加不成功");
				request.setAttribute("info", "内部错误，添加失败。");
				request.getRequestDispatcher("info.jsp").forward(request, response);
			}
			break;
			case "quit":
				session.invalidate();
				response.sendRedirect("Login.jsp");
				break;
		default:
			request.setAttribute("info", "内部错误，方法获取失败，请联系相关开发人员。");
			request.getRequestDispatcher("info.jsp").forward(request, response);
		
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
