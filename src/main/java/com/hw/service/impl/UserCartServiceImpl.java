package com.hw.service.impl;

import com.hw.dao.UserCartDaoI;

import java.math.BigDecimal;
import java.util.List;

import com.hw.dao.ProductDaoI;
import com.hw.dao.impl.UserCartDaoImpl;
import com.hw.dao.impl.ProductDaoImpl;
import com.hw.entity.Cart;
import com.hw.entity.PageModel;
import com.hw.exception.CartException;
import com.hw.service.UserCartServiceI;

public class UserCartServiceImpl implements UserCartServiceI {
	UserCartDaoI cartDao=new UserCartDaoImpl();
	ProductDaoI productDao=new ProductDaoImpl();
	@Override
	public int addToCartService(Integer user_id, Integer product_id, int quantity) throws CartException {
		// TODO Auto-generated method stub
		Cart cart=null;
		int res=0;
		if(productDao.findOneProduct(product_id)==null) {
			throw new CartException("用户想要加入购物车的商品不存在");
		}else {
			cart=cartDao.findCartByUserIdAndProductId(user_id, product_id);
			if(cart!=null) {
				res=cartDao.updateCartByUserIdAndProductId(user_id, product_id, quantity);
				return res;
			}else {
				res=cartDao.addProductIntoCartByUserIdAndProductId(user_id, product_id, quantity);
				return res;
			}
		}
		
	}
	@Override
	public int deleteProductInCartService(Integer id) {
		// TODO Auto-generated method stub
		return cartDao.deleteProductInCart(id);
	}
	@Override
	public int deleteSomeProductInCartService(Integer user_id, List<Integer> list) {
		// TODO Auto-generated method stub
		return cartDao.deleteSomeProductInCart(user_id, list);
	}
	@Override
	public int selectCartItemByIdService(Integer id) {
		// TODO Auto-generated method stub
		return cartDao.selectCartItemById(id);
	}
	@Override
	public int unselectCartItemByIdService(Integer id) {
		// TODO Auto-generated method stub
		return cartDao.unselectCartItemById(id);
	}
	@Override
	public PageModel<Cart> selectCartByUserIdService(Integer user_id,Integer  pageNo,Integer pageSize) {
		// TODO Auto-generated method stub
		return cartDao.selectCartByUserId(user_id, pageNo, pageSize);
	}
	@Override
	public int countProductInCartService(Integer user_id) {
		// TODO Auto-generated method stub
		return cartDao.countProductInCart(user_id);
	}
	@Override
	public int checkedOrUncheckedAllProductInCartService(Integer user_id, Integer checked) {
		// TODO Auto-generated method stub
		return cartDao.checkedOrUncheckedAllProductInCart(user_id, checked);
	}
	@Override
	public int selectOptionService(Integer user_id, Integer checked, Integer id) {
		// TODO Auto-generated method stub
		return cartDao.selectOption(user_id, checked, id);
	}
	@Override
	public int updateCartProductInfoServlce(Integer id, Integer quantity) {
		// TODO Auto-generated method stub
		return cartDao.updateCartProductInfo(id, quantity);
	}
	@Override
	public Cart selectOneCartService(Integer id) {
		// TODO Auto-generated method stub
		return cartDao.selectOneCart(id);
	}
	@Override
	public BigDecimal getTotalPriceService(Integer user_id) {
		// TODO Auto-generated method stub
		return cartDao.getTotalPrice(user_id);
	}
	
}
