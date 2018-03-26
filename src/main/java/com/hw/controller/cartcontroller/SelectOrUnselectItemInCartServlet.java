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
 * Servlet implementation class SelectOrUnselectItemInCartServlet
 */
@WebServlet("/forpage/SelectOrUnselectItemInCartServlet")
public class SelectOrUnselectItemInCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOrUnselectItemInCartServlet() {
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
			int checked=Integer.valueOf(request.getParameter("checked"));
			int id=Integer.valueOf(request.getParameter("id"));
			UserCartServiceI userCartService=new UserCartServiceImpl();
			if(checked==0) {
				userCartService.unselectCartItemByIdService(id);
			}else if(checked==1){
				userCartService.selectCartItemByIdService(id);
			}
			response.sendRedirect("ResAllProductInCartServlet?pageNo=1");
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
