package com.hw.controller.address;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.Address;
import com.hw.entity.PageModel;
import com.hw.service.UserAddressServiceI;
import com.hw.service.impl.UserAddressServiceImpl;

/**
 * Servlet implementation class ResAllAddressServlet
 */
@WebServlet("/forpage/userhome/framepage/ResAllAddressServlet")
public class ResAllAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResAllAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession();
		if((Integer)session.getAttribute("user_id")!=null) {
			int user_id=(Integer)session.getAttribute("user_id");
			int pageNo=Integer.valueOf(request.getParameter("pageNo"));
			UserAddressServiceI userAddressService=new UserAddressServiceImpl();
			PageModel<Address> pageModel=userAddressService.findUserAddressService(user_id, pageNo, 1);
			session.setAttribute("pageModel", pageModel);
			response.sendRedirect("http://localhost:8080/homework_sp/forpage/userhome/framepage/iframe_address.jsp");
		}else {
			response.getWriter().print("<script>top.location.href=\"http://localhost:8080/homework_sp/forpage/user/user_login.jsp\"</script>");
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
