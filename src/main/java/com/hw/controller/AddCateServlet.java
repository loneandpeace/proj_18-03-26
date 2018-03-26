package com.hw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw.entity.Cate;
import com.hw.service.CateServiceI;
import com.hw.service.impl.CateServiceImpl;

/**
 * Servlet implementation class AddCateServlet
 */
@WebServlet("/mgr/cate/AddCateServlet")
public class AddCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCateServlet() {
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
		Cate cate=new Cate();
		cate.setParent_id(Integer.valueOf(request.getParameter("parentid")));
		cate.setName(request.getParameter("name"));
		cate.setStatus(Integer.valueOf(request.getParameter("status")));
		cate.setSort_order(Integer.valueOf(request.getParameter("sortorder")));
		CateServiceI cateService=new CateServiceImpl();   
		request.setAttribute("pageNo", request.getParameter("pageNo"));
		int res=cateService.addCateService(cate);
		if(res>0) {
			request.getRequestDispatcher("ResAllCateServlet").forward(request, response);
		} else {
			//request.getRequestDispatcher("cate_add.jsp").forward(request, response);
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
