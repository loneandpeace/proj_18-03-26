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
 * Servlet implementation class UpdateAddressServlet
 */
@WebServlet("/forpage/userhome/framepage/UpdateAddressServlet")
public class UpdateAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAddressServlet() {
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
			int user_id=(int)session.getAttribute("user_id");
			Address address=new Address();
			address.setUser_id(user_id);
			address.setId(Integer.valueOf(request.getParameter("id")));
			address.setReceiver_name(request.getParameter("receiver_name"));
			address.setReceiver_phone(request.getParameter("receiver_phone"));
			address.setReceiver_mobile(request.getParameter("receiver_mobile"));
			address.setReceiver_province(request.getParameter("receiver_province"));
			address.setReceiver_district(request.getParameter("receiver_district"));
			address.setReceiver_city(request.getParameter("receiver_city"));
			address.setReceiver_address(request.getParameter("receiver_address"));
			address.setReceiver_zip(request.getParameter("receiver_zip"));
			UserAddressServiceI addressServiceI=new UserAddressServiceImpl();
			System.out.println("address---"+address);
			addressServiceI.updateUserAddressByUserIdService(user_id, address);
			response.sendRedirect("http://localhost:8080/homework_sp/forpage/userhome/framepage/ResAllAddressServlet?pageNo=1");
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
