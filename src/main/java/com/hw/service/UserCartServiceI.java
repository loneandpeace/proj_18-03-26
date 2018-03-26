package com.hw.service;

import java.math.BigDecimal;
import java.util.List;

import com.hw.entity.Cart;
import com.hw.entity.PageModel;
import com.hw.exception.CartException;

public interface UserCartServiceI {
	public int addToCartService(Integer user_id, Integer product_id, int quantity) throws CartException;
	
	public int selectCartItemByIdService(Integer id);
	public int unselectCartItemByIdService(Integer id);
	public int deleteProductInCartService(Integer id);
	public int deleteSomeProductInCartService(Integer user_id, List<Integer> list);
	public PageModel<Cart> selectCartByUserIdService(Integer user_id,Integer  pageNo,Integer pageSize);
	public int countProductInCartService(Integer user_id);
	public int checkedOrUncheckedAllProductInCartService(Integer user_id, Integer checked);
	public int selectOptionService(Integer user_id, Integer checked, Integer id);
	
	public int updateCartProductInfoServlce(Integer id, Integer quantity);
	
	public Cart selectOneCartService(Integer id);
	
	public BigDecimal getTotalPriceService(Integer user_id);
	
}
