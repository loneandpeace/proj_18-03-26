package com.hw.controller.usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.User;
import com.hw.service.UserAccountServiceI;
import com.hw.service.impl.UserAccountServiceImpl;
import com.hw.utils.MD5Utils;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/forpage/user/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
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
		
		UserAccountServiceI userAccountService=new UserAccountServiceImpl();
		String username=request.getParameter("username");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		String autologin=null;
		if(request.getParameter("autologin")!=null) {
			autologin=request.getParameter("autologin");
		}
			
		boolean exist=false;
		boolean addAccount=false;
		exist=userAccountService.checkIfUserAccountnUserameAndEmailExist(username, email);
		
		if((password1.equals(password2))&&!exist) {
			User user=new User(0,username, MD5Utils.GetMD5Code(password1), email, question, answer, phone);
			addAccount=userAccountService.addUserAccount(user);
			if(addAccount) {
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				if (autologin!=null&&autologin.equals("true")) {
					Cookie username_cookie=new Cookie("username", username);
					Cookie password_cookie=new Cookie("password", password1);
					response.addCookie(username_cookie);
					response.addCookie(password_cookie);
				}
				response.sendRedirect("http://localhost:8080/homework_sp/forpage/user/homepage.jsp");
			}else {
				response.sendRedirect("http://localhost:8080/homework_sp/forpage/user/user_reg.jsp");
			}
			
		}else {
			response.sendRedirect("http://localhost:8080/homework_sp/forpage/user/user_reg.jsp");
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
