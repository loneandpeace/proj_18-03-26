package com.hw.controller.orderservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.User;
import com.hw.service.UserOrderServiceI;
import com.hw.service.impl.UserOrderServiceImpl;

/**
 * Servlet implementation class GenerateOrderServlet
 */
@WebServlet("/forpage/GenerateOrderServlet")
public class GenerateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null){
			Object o=session.getAttribute("user");
			User user=null;
			if(o instanceof User) {
				user=(User)o;
			}else {
				response.sendRedirect("user/user_login.jsp");
			}
			UserOrderServiceI userOrderService=new UserOrderServiceImpl();
			userOrderService.createOrder(user.getId(), request);
			response.sendRedirect("ResAllOrderServlet?pageNo=1&pageSize=1&opType=1");//http://localhost:8080/homework_sp/forpage/
		}else {
			response.sendRedirect("ResAllOrderServlet?pageNo=1&pageSize=1&opType=1"); 
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
