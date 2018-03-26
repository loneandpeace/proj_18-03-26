package com.hw.controller.cartcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.service.UserCartServiceI;
import com.hw.service.impl.UserCartServiceImpl;

/**
 * Servlet implementation class addProductToCartServlet
 */
@WebServlet("/forpage/productview/addProductToCartServlet")
public class addProductToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProductToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Integer user_id=-1;
		int res=0;
		if(session.getAttribute("user_id")!=null){
			user_id=(Integer)session.getAttribute("user_id");
			Integer product_id=0;
			Integer quantity=0;
			if(request.getParameter("product_id")!=null) {
				product_id=Integer.parseInt(request.getParameter("product_id"));
				quantity=Integer.parseInt(request.getParameter("quantity"));
			}
			UserCartServiceI cartService=new UserCartServiceImpl();
			res=cartService.addToCartService(user_id, product_id, quantity);
			response.sendRedirect("http://localhost:8080/homework_sp/forpage/carttestpage.jsp");
		}else {
			response.sendRedirect("http://localhost:8080/homework_sp/forpage/user/user_login.jsp");
		}
		if(res<=0) {
			//response.sendRedirect("");
		}else {
			//response.sendRedirect("");
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
