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
 * Servlet implementation class checkedOrUncheckedServlet
 */
@WebServlet("/forpage/checkedOrUncheckedServlet")
public class checkedOrUncheckedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkedOrUncheckedServlet() {
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
		Integer user_id=-1;
		if((Integer)session.getAttribute("user_id")!=null){
			int checked=Integer.valueOf(request.getParameter("checked"));
			user_id=(Integer)session.getAttribute("user_id");
			UserCartServiceI userCartService=new UserCartServiceImpl();
			userCartService.checkedOrUncheckedAllProductInCartService(user_id, checked);
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
