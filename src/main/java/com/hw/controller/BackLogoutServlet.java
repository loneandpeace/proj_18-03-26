package com.hw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.service.LoginService;
import com.hw.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class BackLogoutServlet
 */	
@WebServlet("/BackLogoutServlet")
public class BackLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackLogoutServlet() {
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
		
		HttpSession session=request.getSession();
		Object o=session.getAttribute("username");
		String username=(String)o;
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.removeAttribute("user");
		session.invalidate();
		
		LoginService loginService=new LoginServiceImpl();
		loginService.removeUserTokenService(username);
		
		
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("token")) {
					Cookie c1=new Cookie(c.getName(), "");
					c1.setMaxAge(0);
					//getPath() Îª¿Õ
					c1.setPath(request.getContextPath());
					response.addCookie(c1);
				}
			}
		}
		/**@ È«¾Ö
		ServletContext application=this.getServletContext();
		application.setAttribute("ahh", "ahh");
		*/
		
		response.getWriter().print("<script>top.location.href=\"http://localhost:8080/homework_sp/admin_login.jsp\"</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
