package com.hw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.Cate;
import com.hw.entity.OrderVO;
import com.hw.entity.PageModel;
import com.hw.entity.User;
import com.hw.entity.UserOrder;
import com.hw.exception.OrderException;
import com.hw.service.CateServiceI;
import com.hw.service.UserOrderServiceI;
import com.hw.service.impl.CateServiceImpl;
import com.hw.service.impl.UserOrderServiceImpl;

/**
 * Servlet implementation class ResAllCateServlet
 */
@WebServlet("/mgr/order/ResAllOrderServlet")
public class ResAllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResAllOrderServlet() {
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
		UserOrderServiceI userOrderServiceI=new UserOrderServiceImpl();
		
		
		String optype=request.getParameter("optype");
		if(optype==null||optype.equals("")) {
			throw new OrderException("订单查询sevlet没有optype");
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
			int user_id=user.getId();
			UserOrderServiceI userOrderService=new UserOrderServiceImpl();
			if(optype.equals("1")) {//全部订单
				PageModel<OrderVO> pm=new PageModel<OrderVO>();
				pm=userOrderServiceI.findAllOrderByPage(request);
				request.setAttribute("pageModel", pm);
				request.getRequestDispatcher("order_list.jsp").forward(request, response);
				return;
			}else if(optype.equals("2")){//单一订单+详细商品
				//
				OrderVO orderVo=userOrderService.findOneOrderDetailServlce(request);
				request.setAttribute("orderVo", orderVo);
				request.getRequestDispatcher("orderitem.jsp").forward(request, response);
				return;
			}else if(optype.equals("3")) {//修改状态
				//UserOrderServiceI userOrderService=new UserOrderServiceImpl();
				userOrderService.updateOrderStatusByOrderNoService(request);
				long no=Long.parseLong(request.getParameter("order_no"));
				System.out.println(no+"");
				response.sendRedirect("ResAllOrderServlet?pageNo=1&pageSize=10&optype=2&order_no="+no);
			}else if(optype.equals("4")) {//查看订单
				OrderVO orderVo=userOrderService.findOneOrderDetailServlce(request);
				request.setAttribute("orderVo", orderVo);
				request.getRequestDispatcher("orderitem.jsp").forward(request, response);
				return;
			}
			else if(optype.equals("5")) {//搜索订单
				OrderVO orderVo=userOrderService.findOneOrderDetailServlce(request);
				request.setAttribute("orderVo", orderVo);
				request.getRequestDispatcher("orderitem.jsp").forward(request, response);
				return;
			}
			
		}else {
			response.getWriter().print("<script>top.location.href=\"http://localhost:8080/homework_sp/admin_login.jsp\"</script>");
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
