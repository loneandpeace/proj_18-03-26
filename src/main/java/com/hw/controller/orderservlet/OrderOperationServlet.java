package com.hw.controller.orderservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.User;
import com.hw.exception.OrderException;
import com.hw.service.UserOrderServiceI;
import com.hw.service.impl.UserOrderServiceImpl;

/**
 * Servlet implementation class OrderOperationServlet
 */
@WebServlet("/forpage/OrderOperationServlet")
public class OrderOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderOperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//订单状态相关
		
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String optype=request.getParameter("opType");
		if(optype==null||optype.equals("")) {
			throw new OrderException("修改订单状态sevlet没有传递opType");
		}
		String order_no=request.getParameter("order_no");
		if(order_no==null||order_no.equals("")) {
			throw new OrderException("修改订单状态sevlet没有传递order_no");
		}
		
		HttpSession session=request.getSession();
		Object o=session.getAttribute("user");
		User user=null;
		if(o!=null) {
			if(o instanceof User) {
				user=(User)o;
			}
		}
		
		if(user!=null) {
			//int user_id=user.getId();
			UserOrderServiceI userOrderService=new UserOrderServiceImpl();
			userOrderService.updateOrderStatusByOrderNoService(request);
			response.sendRedirect("ResAllOrderServlet?pageNo=1&pageSize=10&opType=1");
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
