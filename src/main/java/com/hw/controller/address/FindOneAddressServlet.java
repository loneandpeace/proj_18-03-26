package com.hw.controller.address;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.Address;
import com.hw.service.UserAddressServiceI;
import com.hw.service.impl.UserAddressServiceImpl;

/**
 * Servlet implementation class FindOneAddressServlet
 */
@WebServlet("/forpage/userhome/framepage/FindOneAddressServlet")
public class FindOneAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOneAddressServlet() {
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
		HttpSession session=request.getSession();
		if(session.getAttribute("user_id") != null) {
			int id=Integer.valueOf(request.getParameter("id"));
			UserAddressServiceI addressServiceI=new UserAddressServiceImpl();
			Address address=addressServiceI.findOneAddressService(id);
			if(address!=null) {
				session.setAttribute("editAddress", address);
				response.sendRedirect("http://localhost:8080/homework_sp/forpage/userhome/framepage/iframe_edit_address.jsp");
			}
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
