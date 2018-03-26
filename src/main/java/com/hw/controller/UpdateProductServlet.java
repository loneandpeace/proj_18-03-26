package com.hw.controller;

import java.io.IOException;
import java.math.BigDecimal;

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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/mgr/product/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ProductServiceI productService=new ProductServiceImpl();
		
		int id=Integer.valueOf(request.getParameter("id"));
		int category_id=Integer.valueOf(request.getParameter("category_id"));
		String name=request.getParameter("name");
		String subtitle=request.getParameter("subtitle");
		String main_image=request.getParameter("main_image");
		String sub_images=request.getParameter("sub_images");
		String detail=request.getParameter("detail");
		BigDecimal price=BigDecimal.valueOf(Double.valueOf(request.getParameter("price")));
		int stock=Integer.valueOf(request.getParameter("stock"));
		int status=Integer.valueOf(request.getParameter("status"));
		
		Product product=new Product();
		product.setId(id);
		product.setCategory_id(category_id);
		product.setName(name);
		product.setSubtitle(subtitle);
		product.setMain_image(main_image);
		product.setSub_images(sub_images);
		product.setDetail(detail);
		product.setPrice(price);
		product.setStock(stock);
		product.setStatus(status);
		
		productService.updateProductService(product);
		
		PageModel<Product> pm=new PageModel<Product>();
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
