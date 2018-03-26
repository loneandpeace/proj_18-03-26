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
 * Servlet implementation class SearchCateServlet
 */
@WebServlet("/mgr/cate/SearchCateServlet")
public class SearchCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCateServlet() {
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
		String info=request.getParameter("info");
		int pageNo=Integer.valueOf(request.getParameter("pageNo"));
		CateServiceI cateService=new CateServiceImpl();
		PageModel<Cate> pm=new PageModel<Cate>();
		pm=cateService.findSomeCateByInfoService(pageNo,10,info);
		request.setAttribute("info", info);
		request.setAttribute("pageModel", pm);
		request.getRequestDispatcher("cate_search_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
