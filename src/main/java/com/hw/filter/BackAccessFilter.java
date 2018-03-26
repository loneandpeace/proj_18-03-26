package com.hw.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.User;
import com.hw.service.LoginService;
import com.hw.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class BackAccessFilter
 */
@WebFilter("/mgr/*")
//  
public class BackAccessFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BackAccessFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//Session 
		HttpServletRequest request=(HttpServletRequest)_request;
		HttpServletResponse response=(HttpServletResponse)_response;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		//System.out.println("session id---"+session.getId());
		
		LoginService loginservice=new LoginServiceImpl();
		
		User user=null;
		
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
		
		if(user==null) {
			String _username=null;
			String _password=null;
			_username=(String) session.getAttribute("username");
			_password=(String) session.getAttribute("password");
			//user=loginservice.loginAction(_username, _password);
			if(_username!=null) {
				chain.doFilter(request, response);
				return;
			}
			if(session.getAttribute("user")!=null) {
				chain.doFilter(request, response);
				return;
			}
		}
		
		
		if(user!=null) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("password", user.getPassword());
			// pass the request along the filter chain
			chain.doFilter(request, response);
			//response.sendRedirect("http://localhost:8080/homework_sp/mgr/home/admin_login.jsp");
		} else {
			response.sendRedirect("http://localhost:8080/homework_sp/admin_login.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
