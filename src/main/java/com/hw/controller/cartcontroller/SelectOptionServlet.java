package com.hw.controller.cartcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.User;
import com.hw.service.UserCartServiceI;
import com.hw.service.impl.UserCartServiceImpl;

/**
 * Servlet implementation class SelectOptionServlet
 */
@WebServlet("/forpage/SelectOptionServlet")
public class SelectOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOptionServlet() {
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
			String _opType=request.getParameter("opType");
			if(_opType==null||_opType.equals("")) {
				response.sendRedirect("ResAllProductInCartServlet?pageNo=1");
			}
			User user=(User)session.getAttribute("user");
			int userid=user.getId();
			int opType=Integer.parseInt(request.getParameter("opType"));
			
			if(opType==1) {//选择一个
				
				//int checked=Integer.valueOf(request.getParameter("checked"));
				int id=Integer.valueOf(request.getParameter("id"));
				UserCartServiceI userCartService=new UserCartServiceImpl();
				
				userCartService.selectOptionService(userid, 1, id);
				
				response.sendRedirect("ResAllProductInCartServlet?pageNo=1");
				return;
				
			}else if(opType==2) {//取消选择一个
				
				//int checked=Integer.valueOf(request.getParameter("checked"));
				int id=Integer.valueOf(request.getParameter("id"));
				UserCartServiceI userCartService=new UserCartServiceImpl();
				
				userCartService.selectOptionService(userid, 0, id);
				
				response.sendRedirect("ResAllProductInCartServlet?pageNo=1");
				return;
				
			}else if(opType==3) {//选择全部
				
				//int checked=Integer.valueOf(request.getParameter("checked"));
				int user_id=(Integer)session.getAttribute("user_id");
				UserCartServiceI userCartService=new UserCartServiceImpl();
				userCartService.selectOptionService(user_id, 1, -1);
				response.sendRedirect("ResAllProductInCartServlet?pageNo=1");
				return;
				
			}else if(opType==4) {//取消选择全部
				
				//int checked=Integer.valueOf(request.getParameter("checked"));
				int user_id=(Integer)session.getAttribute("user_id");
				UserCartServiceI userCartService=new UserCartServiceImpl();
				userCartService.selectOptionService(user_id, 0, -1);
				response.sendRedirect("ResAllProductInCartServlet?pageNo=1");
				return;
				
			}
		}else {
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
