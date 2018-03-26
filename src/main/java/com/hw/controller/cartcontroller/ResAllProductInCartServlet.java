package com.hw.controller.cartcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.dao.UserAddressDaoI;
import com.hw.dao.impl.UserAddressDaoImpl;
import com.hw.entity.Cart;
import com.hw.entity.PageModel;
import com.hw.service.UserCartServiceI;
import com.hw.service.impl.UserCartServiceImpl;

/**
 * Servlet implementation class ResAllProductInCartServlet
 */
@WebServlet("/forpage/ResAllProductInCartServlet")
public class ResAllProductInCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResAllProductInCartServlet() {
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
		if((Integer)session.getAttribute("user_id")!=null){
			int pageNo=Integer.parseInt(request.getParameter("pageNo"));
			UserCartServiceI userCartService=new UserCartServiceImpl();
			UserAddressDaoI userAddressDao=new UserAddressDaoImpl();
			
			int user_id=(Integer)session.getAttribute("user_id");
			
			PageModel<Cart> pageModel=userCartService.selectCartByUserIdService(user_id, pageNo, 2);
			int count=userCartService.countProductInCartService(user_id);
			session.setAttribute("pageModel", pageModel);
			session.setAttribute("cartCount", count);
			
			session.setAttribute("userAddress", userAddressDao.findUserAddress(user_id, 1, 10));
			
			response.sendRedirect("carttestpage.jsp");
		} else {
			response.sendRedirect("user/user_login.jsp");
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
