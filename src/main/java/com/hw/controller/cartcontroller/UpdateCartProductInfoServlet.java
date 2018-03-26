package com.hw.controller.cartcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.Cart;
import com.hw.service.UserCartServiceI;
import com.hw.service.impl.UserCartServiceImpl;

/**
 * Servlet implementation class UpdateCartProductInfoServlet
 */
@WebServlet("/forpage/UpdateCartProductInfoServlet")
public class UpdateCartProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartProductInfoServlet() {
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
		if(session.getAttribute("user_id")!=null){
			
			UserCartServiceI userCartService=new UserCartServiceImpl();
			if(request.getParameter("opType")==null) {
				
			}else if(request.getParameter("opType").equals("1")) {//返回一个Cart
				
				int id=Integer.parseInt(request.getParameter("id"));
				Cart cart=userCartService.selectOneCartService(id);
				
				session.setAttribute("cartforedit", cart);
				response.sendRedirect("editcart.jsp");
				return;
				
			}else if(request.getParameter("opType").equals("2")){//修改cart表中对应id的cart
				
				int id=Integer.parseInt(request.getParameter("id"));
				int quantity=Integer.parseInt(request.getParameter("quantity"));
				userCartService.updateCartProductInfoServlce(id, quantity);
				response.sendRedirect("ResAllProductInCartServlet?pageNo=1");
				return;
			}
		}else {
			response.sendRedirect("http://localhost:8080/homework_sp/forpage/user/user_login.jsp");
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
