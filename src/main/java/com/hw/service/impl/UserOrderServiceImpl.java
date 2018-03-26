package com.hw.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.hw.consts.OrderStatusEnum;
import com.hw.consts.PaymentTypeEnum;
import com.hw.dao.ProductDaoI;
import com.hw.dao.UserCartDaoI;
import com.hw.dao.UserOrderDaoI;
import com.hw.dao.UserOrderItemDaoI;
import com.hw.dao.impl.ProductDaoImpl;
import com.hw.dao.impl.UserCartDaoImpl;
import com.hw.dao.impl.UserOrderDaoImpl;
import com.hw.dao.impl.UserOrderItemDaoImpl;
import com.hw.entity.Cart;
import com.hw.entity.OrderVO;
import com.hw.entity.PageModel;
import com.hw.entity.Product;
import com.hw.entity.UserOrder;
import com.hw.entity.UserOrderItem;
import com.hw.exception.OrderException;
import com.hw.service.UserOrderServiceI;

public class UserOrderServiceImpl implements UserOrderServiceI {
	
	private UserCartDaoI userCartDao=new UserCartDaoImpl();
	private ProductDaoI productDao=new ProductDaoImpl();
	private UserOrderDaoI userOrderDao=new UserOrderDaoImpl();
	private UserOrderItemDaoI userOrderItemDao=new UserOrderItemDaoImpl();
	//private UserAddressDaoI userAddressDao=new UserAddressDaoImpl();
	
	@Override
	public int createOrder(Integer user_id, HttpServletRequest request) throws OrderException{
		
		// TODO Auto-generated method stub
		//获取地址id
		String _shipping_id=request.getParameter("shipping_id");
		Integer shipping_id=-1;
		if(_shipping_id==null||_shipping_id.equals("")) {
			//抛出异常
			throw new OrderException("地址id不存在");
		}
		try {
			shipping_id=Integer.parseInt(_shipping_id);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
			//抛出异常
			throw new OrderException("地址id转换出错");
		}
		
		//查询checked=1的商品
		List<Cart> cartList=userCartDao.findCartByUserIdAndChecked(user_id);
		
		//获取订单明细(orderItem_list)
		List<UserOrderItem> orderItemList=null;
		if(cartList.size()>0) {
			orderItemList=convertCartToUserOrderItem(cartList, user_id);
		}else {
			//抛出异常
			throw new OrderException("购物车中不存在被选中的商品");
		}
		
		//计算总价
		BigDecimal total_payment=getTotalPrice(orderItemList);
		
		//创建订单
		UserOrder userOrder=createAndAddOrder(user_id, shipping_id, total_payment);
		if(userOrder!=null) {
			
			//将订单明细插入数据库
			addOrderItemIntoDB(userOrder,orderItemList);
		}else {
			//抛出异常
			throw new OrderException("主订单生成异常");
		}
		
		//减少库存
		for(UserOrderItem oi : orderItemList) {
			productDao.reduceProductStock(oi.getProduct_id(), oi.getQuantity());
		}
		//清空对应购物车中选中的商品
		userCartDao.deleteCheckedCartByUserId(user_id);
		
		return 1;
	}
	
	/////
	private List<UserOrderItem> convertCartToUserOrderItem(List<Cart> cartList, int user_id){
		
		List<UserOrderItem> orderItemList=new ArrayList<UserOrderItem>();
		for(Cart c : cartList) {
			UserOrderItem orderItem=new UserOrderItem();
			Product product=productDao.findOneProduct(c.getProduct_id());
			
			if(product!=null) {
				orderItem.setProduct_image(product.getMain_image());
				orderItem.setProduct_id(c.getProduct_id());
				orderItem.setProduct_name(product.getName());
				orderItem.setUser_id(user_id);
				orderItem.setQuantity(c.getQuantity());
				orderItem.setCurrent_unit_price(product.getPrice());
				BigDecimal total_price=new BigDecimal("0");
				//BigDecimal a=new BigDecimal(c.getQuantity());
				total_price=product.getPrice().multiply(new BigDecimal(c.getQuantity()));
				orderItem.setTotal_price(total_price);
				orderItemList.add(orderItem);
			}else {
				throw new OrderException("添加的商品已被下架");
			}
		}
		return orderItemList;
		
	}
	
	/////
	private UserOrder createAndAddOrder(int user_id, int shipping_id, BigDecimal payment)  throws OrderException{
		
		UserOrder userOrder=new UserOrder();
		userOrder.setOrder_no(generateOrderNumber());
		userOrder.setUser_id(user_id);
		userOrder.setShipping_id(shipping_id);
		userOrder.setPayment(payment);
		userOrder.setPayment_type(1);
		userOrder.setStatus(OrderStatusEnum.PAY.getStatus());
		int res=userOrderDao.addOrder(userOrder);
		if(res>0) {
			return userOrder;
		}else {
			//抛出异常
			throw new OrderException("主订单加入DB失败");
		}
		
	}
	
	
	private long generateOrderNumber() {
		
		return System.currentTimeMillis()+(int)(Math.random()*100);
		
	}
	
	/////
	private BigDecimal getTotalPrice(List<UserOrderItem> orderItemList) {
		
		BigDecimal totalPrice=new BigDecimal("0");
		for(UserOrderItem oi : orderItemList) {
			totalPrice=totalPrice.add(oi.getTotal_price());
		}
		return totalPrice;
		
	}
	
	/////
	private int addOrderItemIntoDB(UserOrder userOrder, List<UserOrderItem> orderItemList)  throws OrderException{
		
		long order_no=userOrder.getOrder_no();
		for(UserOrderItem oi : orderItemList) {
			oi.setOrder_no(order_no);
			long stock=productDao.getProductStock(oi.getProduct_id());
			if(stock<=oi.getQuantity()) {
				//抛出异常
				throw new OrderException("商品库存不足");
			}
		}
		int res=userOrderItemDao.addOrderItemsIntoDB(orderItemList);
		return res;
		
	}

	@Override
	public PageModel<OrderVO> findOrderByPage(Integer user_id, HttpServletRequest request) throws OrderException {
		// TODO Auto-generated method stub
		
		String no=request.getParameter("pageNo");
		String size=request.getParameter("pageSize");
		int pageNo=0;
		int pageSize=0;
		if (no==null||size==null) {
			throw new OrderException("查询订单列需传递pageNo&pageSize");
		}
		try {
			pageNo=Integer.parseInt(no);
			pageSize=Integer.parseInt(size);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			throw new OrderException("订单列 pageNo/pageSize转换出错-NumberFormatException");
		}
		
		PageModel<UserOrder> pageModel=userOrderDao.findOrderByPage(user_id, pageNo, pageSize);
		PageModel<OrderVO> pageModelVo=convertUserOrderToOrderVo(pageModel);
		return pageModelVo;
	}
	private PageModel<OrderVO> convertUserOrderToOrderVo(PageModel<UserOrder> pageModel){
		PageModel<OrderVO> pm=new PageModel<OrderVO>();
		List<OrderVO> list=new ArrayList<OrderVO>();
		for(UserOrder uo : pageModel.getData()) {
			OrderVO ovo=new OrderVO();
			ovo.convertOrderToOrderVo(uo);
			/*Address address=userAddressDao.findOneAddress(uo.getShipping_id());
			ovo.setAddress(address);*/
			list.add(ovo);
		}
		pm.setData(list);
		pm.setTotalCount(pageModel.getTotalCount());
		return pm;
	}

	@Override
	public OrderVO findOneOrderDetailServlce(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//long order_no
		String no=request.getParameter("order_no").trim();
		if(no==null||no.equals("")) {
			throw new OrderException("查询订单详情时没有订单编号order_no");
		}
		long order_no=0;
		try {
			order_no=Long.parseLong(no);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			throw new OrderException("查询订单详情时传递的order_no不合法");
		}
		UserOrder order=userOrderDao.findOneOrderDetail(order_no);
		OrderVO ovo=new OrderVO();
		if(order!=null) {
			ovo.convertOrderToOrderVo(order);
		}
		return ovo;
	}

	@Override
	public int updateOrderStatusByOrderNoService(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String opType=request.getParameter("opType");
		long order_no=0L;
		
		try {
			order_no=Long.parseLong(request.getParameter("order_no"));
		}catch (NumberFormatException e) {
			// TODO: handle exception
			throw new OrderException("更新订单状态  order_no 转换异常");
		}
		
		if(opType.equals("1")) {//订单发货
			System.out.println("修改发货状态1");
			int status=userOrderDao.findOrderStatus(order_no);
			//int type=userOrderDao.findOrderPaymentType(order_no);
			if(status==OrderStatusEnum.PAY.getStatus()||(userOrderDao.findOrderPaymentType(order_no)==PaymentTypeEnum.OFFLINE.getType()&&status==OrderStatusEnum.UNPAY.getStatus())) {
				
				int res=userOrderDao.updateOrderStatusByOrderNo(order_no, OrderStatusEnum.SEND.getStatus());
				return res;
			}
		}else if(opType.equals("2")){//取消未付款的订单
			System.out.println("修改发货状态2");
			int status=userOrderDao.findOrderStatus(order_no);
			if(status==OrderStatusEnum.UNPAY.getStatus()) {
				int res=userOrderDao.updateOrderStatusByOrderNo(order_no, OrderStatusEnum.CANCEL.getStatus());
				return res;
			}
		}
		System.out.println("修改发货000");
		return 0;
	}

	@Override
	public PageModel<OrderVO> findAllOrderByPage(HttpServletRequest request) throws OrderException {
		// TODO Auto-generated method stub
		String no=request.getParameter("pageNo");
		String size=request.getParameter("pageSize");
		int pageNo=0;
		int pageSize=0;
		if (no==null||size==null) {
			throw new OrderException("查询订单列需传递pageNo&pageSize");
		}
		try {
			pageNo=Integer.parseInt(no);
			pageSize=Integer.parseInt(size);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			throw new OrderException("订单列 pageNo/pageSize转换出错-NumberFormatException");
		}
		
		PageModel<UserOrder> pageModel=userOrderDao.findAllOrderByPage(pageNo, pageSize);
		PageModel<OrderVO> pageModelVo=convertUserOrderToOrderVo(pageModel);
		return pageModelVo;
	}
	
	
}
