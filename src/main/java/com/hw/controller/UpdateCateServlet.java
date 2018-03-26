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
 * Servlet implementation class UpdateCateServlet
 */
@WebServlet("/mgr/cate/UpdateCateServlet")
public class UpdateCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCateServlet() {
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
		int id=Integer.valueOf(request.getParameter("id"));
		int parent_id=Integer.valueOf(request.getParameter("parentid"));
		String name=request.getParameter("name");
		int status=Integer.valueOf(request.getParameter("status"));
		int sort_order=Integer.valueOf(request.getParameter("sortorder"));
		Cate cate=new Cate();
		cate.setId(id);
		cate.setParent_id(parent_id);
		cate.setName(name);
		cate.setStatus(status);
		cate.setSort_order(sort_order);
		cateService.updateCateService(cate);
		////
		PageModel<Cate> pm=new PageModel<Cate>();
		pm=cateService.findAllCateService(1, 10);
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
