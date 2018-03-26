package com.hw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.User;
import com.hw.service.LoginService;
import com.hw.service.impl.LoginServiceImpl;
import com.hw.utils.MD5Utils;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginactive")
public class BackLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//Session 
		HttpSession session=request.getSession();
		//System.out.println("session id---"+session.getId());
		LoginService loginservice=new LoginServiceImpl();
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
						user=loginservice.checkUserTokenService(token);
						break;
					}
				}
			}
			
		}else {
			_username=request.getParameter("username");
			_password=MD5Utils.GetMD5Code(request.getParameter("password"));
			user=loginservice.loginAction(_username, _password);
			if(request.getParameter("autologin")!=null) {
				autolog=(request.getParameter("autologin")).equals("true");
			}
		}
		
		
		
		if(user==null) {
			//request.getRequestDispatcher("admin_login.jsp").forward(request, response);
			response.sendRedirect("http://localhost:8080/homework_sp/admin_login.jsp");
		} else {
			if(autolog) {
				String token_info=MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
				Cookie token_cookie=new Cookie("token", token_info);
				token_cookie.setPath(request.getContextPath());
				token_cookie.setMaxAge(60*60*24);
				response.addCookie(token_cookie);
				loginservice.updateUserTokenService(token_info, _username);
			}
			session.setAttribute("user", user);
			session.setAttribute("username", _username);
			session.setAttribute("password", _password);
			/*if(request.getParameter("shortcut")!=null&&user!=null) {
				System.out.println("shortcut");
				//response.getWriter().write("window.location.href='http://localhost:8080/homework_sp/mgr/home/back_end.jsp'");
				//response.getWriter().print("<script>window.location.href=\"http://localhost:8080/homework_sp/mgr/home/back_end.jsp\"</script>");
				response.sendRedirect("http://localhost:8080/homework_sp/mgr/home/back_end.jsp");
			}*/
			response.sendRedirect("http://localhost:8080/homework_sp/mgr/home/back_end.jsp");
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
