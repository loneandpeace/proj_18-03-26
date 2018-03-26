package com.hw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw.entity.PageModel;
import com.hw.entity.Product;
import com.hw.service.ProductServiceI;
import com.hw.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ResAllProductServlet
 */
@WebServlet("/mgr/product/ResAllProductServlet")
public class ResAllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResAllProductServlet() {
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
		ProductServiceI productService=new ProductServiceImpl();
		PageModel<Product> pm=null;
		int pageNo=Integer.valueOf(request.getParameter("pageNo"));
		pm=productService.findAllProductService(pageNo, 10);
		request.setAttribute("pageModel", pm);
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
