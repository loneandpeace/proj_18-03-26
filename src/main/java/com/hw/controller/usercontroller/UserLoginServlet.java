package com.hw.controller.usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hw.entity.LoginVO;
import com.hw.entity.User;
import com.hw.service.UserAccountServiceI;
import com.hw.service.impl.UserAccountServiceImpl;
import com.hw.utils.MD5Utils;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/forpage/user/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//Session 
		HttpSession session=request.getSession();
		//System.out.println("session id---"+session.getId());
		UserAccountServiceI userAccountService=new UserAccountServiceImpl();
		User user=null;
		String _username=null;
		String _password=null;
		boolean autolog=false;
		if(request.getParameter("username")==null&&request.getParameter("password")==null) {
			Cookie[] cookies=request.getCookies();
			if(cookies!=null) {
				for(Cookie c:cookies) {
					if(c.getName().equals("token")) {
						String token=c.getValue();
						user=userAccountService.checkUserTokenService(token);
						break;
					}
				}
			}
			
		}else {
			
			_username=request.getParameter("username");
			_password=MD5Utils.GetMD5Code(request.getParameter("password"));
			user=userAccountService.loginAction(_username, _password);
			
			if(request.getParameter("autologin")!=null) {
				autolog=(request.getParameter("autologin")).equals("true");
			}
		}
		LoginVO vo=new LoginVO();
		
		if(user==null) {
			vo.setErrorno(LoginVO.LOGIN_FAIL);
			vo.setMessage("用户名不存在或密码错误");
			Gson gson=new Gson();
			String result=gson.toJson(vo);
			response.getWriter().write("loginResult("+result+");");
			//request.getRequestDispatcher("admin_login.jsp").forward(request, response);
			//response.sendRedirect("http://localhost:8080/homework_sp/forpage/user/user_login.jsp");
		} else {
			if(autolog) {
				String token_info=MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
				Cookie token_cookie=new Cookie("token", token_info);
				token_cookie.setPath(request.getContextPath());
				token_cookie.setMaxAge(60*60*24);
				response.addCookie(token_cookie);
				userAccountService.updateUserTokenService(token_info, _username);
			}
			
			vo.setUser(user);
			vo.setErrorno(LoginVO.LOGIN_SUCCESS);
			
			session.setAttribute("user", user);
			session.setAttribute("user_id", user.getId());
			session.setAttribute("username", _username);
			
			
			Gson gson=new Gson();
			String result=gson.toJson(vo);
			
			response.getWriter().write("loginResult("+result+");");
			//response.sendRedirect("http://localhost:8080/homework_sp/forpage/productview/singlegoods.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
