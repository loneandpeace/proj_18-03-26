package com.hw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw.entity.Cate;
import com.hw.entity.PageModel;
import com.hw.service.CateServiceI;
import com.hw.service.impl.CateServiceImpl;

/**
 * Servlet implementation class ResAllCateServlet
 */
@WebServlet("/mgr/cate/ResAllCateServlet")
public class ResAllCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResAllCateServlet() {
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
		CateServiceI cateService=new CateServiceImpl();
		PageModel<Cate> pm=new PageModel<Cate>();
		int pageNo=Integer.valueOf(request.getParameter("pageNo"));
		pm=cateService.findAllCateService(pageNo, 10);
		request.setAttribute("pageModel", pm);
		request.getRequestDispatcher("cate_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
