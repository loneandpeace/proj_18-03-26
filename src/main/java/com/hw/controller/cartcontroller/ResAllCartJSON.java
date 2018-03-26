package com.hw.controller.cartcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hw.entity.Cart;
import com.hw.entity.CartPageVO;
import com.hw.entity.PageModel;
import com.hw.exception.CartException;
import com.hw.service.UserCartServiceI;
import com.hw.service.impl.UserCartServiceImpl;

/**
 * Servlet implementation class ResAllCartJSON
 */
@WebServlet("/forpage/ResAllCartJSON")
public class ResAllCartJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResAllCartJSON() {
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
		
		CartPageVO vo=new CartPageVO();
		
		if(session.getAttribute("user")!=null){
			//int operationType=-1;
			int user_id=(Integer)session.getAttribute("user_id");
			UserCartServiceI userCartService=new UserCartServiceImpl();
			String opType=request.getParameter("opType");
			if(opType==null||opType.equals("")) {//显示
				int pageNo=0;
				System.out.println("type==null");
				String pageno=request.getParameter("pageNo");
				if(pageno==null||pageno.equals("")) {
					throw new CartException("js查询cart时传递页码错误");
				}else {
					pageNo=Integer.parseInt(pageno);
				}
				PageModel<Cart> pageModel=userCartService.selectCartByUserIdService(user_id, pageNo, 1);
				int count=userCartService.countProductInCartService(user_id);
				Gson json=new Gson();
				//String result=json.toJson(pageModel);
				vo.setPageModel(pageModel);
				vo.setErrorno(CartPageVO.CART_SUCCESS);
				String result=json.toJson(vo);
				BigDecimal price=userCartService.getTotalPriceService(user_id);
				PrintWriter pw=response.getWriter();
				
				pw.write("removeTable();");
				pw.write("_show("+result+");");
				pw.write("getCount("+count+");");
				pw.write("setPrice("+price+");");
				
				
			}else if(opType.equals("1")) {//选择一个
				
				System.out.println("type=="+request.getParameter("opType"));
				int id=Integer.valueOf(request.getParameter("id"));
				int res=userCartService.selectOptionService(user_id, 1, id);
				
				
				PrintWriter pw=response.getWriter();
				if(res>0) {
					int count=userCartService.countProductInCartService(user_id);
					BigDecimal price=userCartService.getTotalPriceService(user_id);
					pw.write("changeItemselectAction("+1+","+1+","+id+","+count+")");
					pw.write("setPrice("+price+");");
					//pw.write("getCount("+count+");");
				}else {
					pw.write("changeItemselectAction("+0+","+1+","+id+")");
				}
				
			}else if(opType.equals("2")) {//取消选择一个
				
				int id=-1;
				System.out.println("type=="+request.getParameter("opType"));
				String cid=request.getParameter("id");
				if(cid==null||cid.equals("")) {
					
				}else {
					id=Integer.valueOf(request.getParameter("id"));
				}
				
				int res=userCartService.selectOptionService(2, 0, id);
				PrintWriter pw=response.getWriter();
				
				if(res>0) {
					int count=userCartService.countProductInCartService(user_id);
					BigDecimal price=userCartService.getTotalPriceService(user_id);
					pw.write("changeItemselectAction("+1+","+0+","+id+","+count+")");
					pw.write("setPrice("+price+");");
					//pw.write("getCount("+count+");");
				}else {
					pw.write("changeItemselectAction("+0+","+0+","+id+")");
				}
				
			}else if(opType.equals("3")) {//全选
				
				System.out.println("type=="+request.getParameter("opType"));
				int res=userCartService.selectOptionService(user_id, 1, -1);
				
				PrintWriter pw=response.getWriter();
				
				if(res>0) {
					int count=userCartService.countProductInCartService(user_id);
					BigDecimal price=userCartService.getTotalPriceService(user_id);
					pw.write("selectAction("+1+","+1+");");
					pw.write("setPrice("+price+");");
					pw.write("getCount("+count+");");
				}else {
					pw.write("selectAction("+0+","+1+");");
				}
				
				
			}else if(opType.equals("4")) {//全不选
				
				System.out.println("type=="+request.getParameter("opType"));
				int res=userCartService.selectOptionService(user_id, 0, -1);
				PrintWriter pw=response.getWriter();
				
				if(res>0) {
					int count=userCartService.countProductInCartService(user_id);
					BigDecimal price=userCartService.getTotalPriceService(user_id);
					pw.write("selectAction("+1+","+0+");");
					pw.write("setPrice("+price+");");
					pw.write("getCount("+count+");");
				}else {
					pw.write("selectAction("+1+","+0+");");
				}
				
			}else if(opType.equals("0")) {//删除
				
				System.out.println("type=="+request.getParameter("opType"));
				int id=Integer.valueOf(request.getParameter("id"));
				userCartService.deleteProductInCartService(id);				

				PageModel<Cart> pageModel=userCartService.selectCartByUserIdService(user_id, 1, 2);
				Gson json=new Gson();
				String result=json.toJson(pageModel);
				PrintWriter pw=response.getWriter();
				BigDecimal price=userCartService.getTotalPriceService(user_id);
				int count=userCartService.countProductInCartService(user_id);
				pw.write("removeTable();");
				pw.write("_show("+result+");");
				pw.write("getCount("+count+");");
				pw.write("setPrice("+price+");");
				
			}else if(opType.equals("6")) {//修改数量
				
				System.out.println("type=="+opType);
				int id=Integer.parseInt(request.getParameter("id"));
				int quantity=Integer.parseInt(request.getParameter("quantity"));
				int res=userCartService.updateCartProductInfoServlce(id, quantity);		

				int count=userCartService.countProductInCartService(user_id);
				
				PrintWriter pw=response.getWriter();
				
				if(res>0) {
					BigDecimal price=userCartService.getTotalPriceService(user_id);
					pw.write("setQuantityAction("+1+","+quantity+","+id+","+count+");");
					pw.write("setPrice("+price+");");
				}else {
					
					//回滚页面数据？？？？
					pw.write("setQuantityAction("+0+","+quantity+","+id+","+count+");");
					pw.write("alert('修改失败');");
				}
				
			}
			
			
		}else {
			PrintWriter pw=response.getWriter();
			pw.write("window.location.href=\"http://localhost:8080/homework_sp/forpage/user/user_login.jsp\"");
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
