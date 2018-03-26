package com.hw.controller;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw.entity.Product;
import com.hw.service.ProductServiceI;
import com.hw.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/mgr/product/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		Product product=new Product();
		product.setCategory_id(Integer.valueOf(request.getParameter("category_id")));
		product.setName(request.getParameter("name"));
		product.setSubtitle(request.getParameter("subtitle"));
		product.setMain_image(request.getParameter("main_image"));
		product.setSub_images(request.getParameter("sub_images"));
		product.setDetail(request.getParameter("detail"));
		product.setPrice(BigDecimal.valueOf(Double.valueOf(request.getParameter("price"))));
		product.setStock(Integer.valueOf(request.getParameter("stock")));
		product.setStatus(Integer.valueOf(Integer.valueOf(request.getParameter("status"))));
		int res=productService.addProductService(product);
		request.setAttribute("pageNo", request.getParameter("pageNo"));
		if(res>0) {
			request.getRequestDispatcher("ResAllProductServlet").forward(request, response);
		} else {
			//request.getRequestDispatcher("product_add.jsp").forward(request, response);
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
