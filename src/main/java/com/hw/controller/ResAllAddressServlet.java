package com.hw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.Address;
import com.hw.entity.Cate;
import com.hw.entity.OrderVO;
import com.hw.entity.PageModel;
import com.hw.entity.User;
import com.hw.entity.UserOrder;
import com.hw.exception.OrderException;
import com.hw.service.CateServiceI;
import com.hw.service.UserAddressServiceI;
import com.hw.service.UserOrderServiceI;
import com.hw.service.UserServiceI;
import com.hw.service.impl.CateServiceImpl;
import com.hw.service.impl.UserAddressServiceImpl;
import com.hw.service.impl.UserOrderServiceImpl;
import com.hw.service.impl.UserServiceImpl;
import com.hw.utils.MD5Utils;

/**
 * Servlet implementation class ResAllCateServlet
 */
@WebServlet("/mgr/address/ResAllAddressServlet")
public class ResAllAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResAllAddressServlet() {
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
		
		
		String optype=request.getParameter("opType");
		if(optype==null||optype.equals("")) {
			throw new OrderException("订单地址sevlet没有opType");
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
			UserAddressServiceI userAddressService =new UserAddressServiceImpl();
			if(optype.equals("1")) {//全部地址
				int pageSize=Integer.valueOf(request.getParameter("pageSize"));
				int pageNo=Integer.valueOf(request.getParameter("pageNo"));
				PageModel<Address> pm=new PageModel<Address>();
				pm=userAddressService.findAllUserAddressService(pageNo, pageSize);
				request.setAttribute("pageModel", pm);
				request.getRequestDispatcher("address_list.jsp").forward(request, response);
				return;
			}else if(optype.equals("2")){//单一地址
				int id=Integer.valueOf(request.getParameter("id"));
				Address address=userAddressService.findOneAddressService(id);
				request.setAttribute("Address", address);
				request.getRequestDispatcher("address_detail.jsp").forward(request, response);
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
