package com.hw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw.entity.Cate;
import com.hw.entity.OrderVO;
import com.hw.entity.PageModel;
import com.hw.entity.User;
import com.hw.entity.UserOrder;
import com.hw.exception.OrderException;
import com.hw.service.CateServiceI;
import com.hw.service.UserOrderServiceI;
import com.hw.service.UserServiceI;
import com.hw.service.impl.CateServiceImpl;
import com.hw.service.impl.UserOrderServiceImpl;
import com.hw.service.impl.UserServiceImpl;
import com.hw.utils.MD5Utils;

/**
 * Servlet implementation class ResAllCateServlet
 */
@WebServlet("/mgr/user/ResAllUserServlet")
public class ResAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResAllUserServlet() {
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
		UserOrderServiceI userOrderServiceI=new UserOrderServiceImpl();
		
		
		String optype=request.getParameter("opType");
		if(optype==null||optype.equals("")) {
			throw new OrderException("订单用户sevlet没有opType");
		}
		
		HttpSession session=request.getSession();
		Object o=session.getAttribute("user");
		User user=null;
		if(o!=null) {
			if(o instanceof User) {
				user=(User)o;
			}
		}
		
		if(user!=null) {
			int user_id=user.getId();
			UserServiceI userService=new UserServiceImpl();
			if(optype.equals("1")) {//全部用户
				int pageSize=Integer.valueOf(request.getParameter("pageSize"));
				int pageNo=Integer.valueOf(request.getParameter("pageNo"));
				PageModel<User> pm=new PageModel<User>();
				pm=userService.findAllUserByPage(pageNo, pageSize);
				request.setAttribute("pageModel", pm);
				request.getRequestDispatcher("user_list.jsp").forward(request, response);
				return;
			}else if(optype.equals("2")){//单一用户
				User u=userService.findOneUser(user_id);
				request.setAttribute("user", u);
				request.getRequestDispatcher("user_detail.jsp").forward(request, response);
			}else if(optype.equals("3")) {//删除用户 
				int uid=Integer.parseInt(request.getParameter("user_id"));
				int res=userService.deleteUser(uid);
				PageModel<User> pm=new PageModel<User>();
				pm=userService.findAllUserByPage(1, 10);
				request.setAttribute("pageModel", pm);
				request.getRequestDispatcher("user_list.jsp").forward(request, response);
			}else if(optype.equals("4")) {//添加管理员
				String username=request.getParameter("username");
				String password=MD5Utils.GetMD5Code(request.getParameter("password"));
				User newUser=new User();
				newUser.setUsername(username);
				newUser.setPassword(password);
				newUser.setEmail(request.getParameter("email"));
				newUser.setPhone(request.getParameter("phone"));
				newUser.setQuestion(request.getParameter("question"));
				newUser.setAnswer(request.getParameter("answer"));
				System.out.println(newUser);
				int res=userService.addNewAdministrator(newUser);
				PageModel<User> pm=new PageModel<User>();
				pm=userService.findAllUserByPage(1, 10);
				request.setAttribute("pageModel", pm);
				request.getRequestDispatcher("user_list.jsp").forward(request, response);
			}else if(optype.equals("6")) {//模糊搜索用户
				//int pageSize=Integer.valueOf(request.getParameter("pageSize"));
				//int pageNo=Integer.valueOf(request.getParameter("pageNo"));
				String username=request.getParameter("info");
				PageModel<User> pm=new PageModel<User>();
				pm=userService.searchUser(username, 1, 10);
				request.setAttribute("pageModel", pm);
				request.getRequestDispatcher("user_list.jsp").forward(request, response);
			}
			
		}else {
			response.getWriter().print("<script>top.location.href=\"http://localhost:8080/homework_sp/admin_login.jsp\"</script>");
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
