package com.hw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw.entity.Cate;
import com.hw.entity.Product;
import com.hw.service.CateServiceI;
import com.hw.service.ProductServiceI;
import com.hw.service.impl.CateServiceImpl;
import com.hw.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProductInfoServlet
 */
@WebServlet("/mgr/product/UpdateProductInfoServlet")
public class UpdateProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int productid=Integer.valueOf(request.getParameter("productid"));
		ProductServiceI productService=new ProductServiceImpl();
		Product product=productService.findOneProductService(productid);
		///
		CateServiceI cateService=new CateServiceImpl();
		List<Cate> list=new ArrayList<Cate>();
		list=cateService.findAllCateIdService();
		request.setAttribute("cateidlist", list);
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("product_update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
