package com.hw.dao;

import java.math.BigDecimal;
import java.util.List;

import com.hw.entity.Cart;
import com.hw.entity.PageModel;

public interface UserCartDaoI {
	public Cart findCartByUserIdAndProductId(Integer user_id, Integer product_id);
	public int updateCartByUserIdAndProductId(Integer user_id, Integer product_id, int quantity);
	public int addProductIntoCartByUserIdAndProductId(Integer user_id, Integer product_id, int quantity);
	public int updateCartProductInfo(Integer id, Integer quantity);
	public int deleteProductInCart(Integer id);
	public int deleteSomeProductInCart(Integer user_id, List<Integer> list);
	public int selectCartItemById(Integer id);
	public int unselectCartItemById(Integer id);
	public PageModel<Cart> selectCartByUserId(Integer user_id,Integer  pageNo,Integer pageSize);
	public int countProductInCart(Integer user_id);
	public int checkedOrUncheckedAllProductInCart(Integer user_id, Integer checked);
	public int selectOption(Integer user_id, Integer checked, Integer id);
	public Cart selectOneCart(Integer id);
	
	List<Cart> findCartByUserIdAndChecked(Integer user_id);
	
	int deleteCheckedCartByUserId(Integer user_id);
	
	public BigDecimal getTotalPrice(Integer user_id);
	
	
	/*
	public List<Cart> selectCartByUserId(Integer user_id);
	public Cart selectCartItemById(Integer id);
	public Cart unselectCartItemById(Integer id);
	public int countProductInCart();
	public int checkedOrUncheckedAllProductInCart(Integer user_id);
	public List<Cart> findAllProductInCart(Integer user_id);
	*/
	
}
