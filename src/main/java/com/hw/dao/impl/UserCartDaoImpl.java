package com.hw.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hw.common.MybatisUtils;
import com.hw.dao.UserCartDaoI;
import com.hw.entity.Cart;
import com.hw.entity.PageModel;
import com.hw.entity.Product;

public class UserCartDaoImpl implements UserCartDaoI {

	@Override
	public Cart findCartByUserIdAndProductId(Integer user_id, Integer product_id){
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);
		Cart cart=null;
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession();
		Object o=sqlSession.selectOne("com.hw.entity.Cart.findCartByUserIdAndProductId", map);
		sqlSession.close();
		if(o instanceof Cart) {
			cart=(Cart)o;
		}
		return cart;
	}

	@Override
	public int updateCartByUserIdAndProductId(Integer user_id, Integer product_id, int quantity) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);
		map.put("quantity", quantity);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.update("com.hw.entity.Cart.updateCartByUserIdAndProductId", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int addProductIntoCartByUserIdAndProductId(Integer user_id, Integer product_id, int quantity) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("product_id", product_id);
		map.put("quantity", quantity);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.insert("com.hw.entity.Cart.addProductIntoCartByUserIdAndProductId", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	

	@Override
	public int selectCartItemById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		int res=sqlSession.update("com.hw.entity.Cart.selectCartItemById", id);
		sqlSession.close();
		return res;
	}

	@Override
	public int unselectCartItemById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		int res=sqlSession.update("com.hw.entity.Cart.unselectCartItemById", id);
		sqlSession.close();
		return res;
	}

	@Override
	public int deleteProductInCart(Integer id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		int res=sqlSession.delete("com.hw.entity.Cart.deleteProductInCart", id);
		sqlSession.close();
		return res;
	}
	
	@Override
	public int deleteSomeProductInCart(Integer user_id, List<Integer> list) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		//map.put("list", list);
		map.put("user_id", user_id);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.delete("com.hw.entity.Cart.deleteSomeProductInCart",map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public PageModel<Cart> selectCartByUserId(Integer user_id,Integer  pageNo,Integer pageSize) {
		// TODO Auto-generated method stub
		PageModel<Cart> pageModel=new PageModel<Cart>();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("user_id", user_id);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		//List<Cart> list=sqlSession.selectList("com.hw.entity.Cart.selectCartByUserId", map);
		List<Cart> list=sqlSession.selectList("com.hw.entity.Cart.selectWholeCartByPage", map);
		/*for(Cart c: list) {
			int pid=c.getProduct_id();
			Product p=sqlSession.selectOne("com.hw.entity.Product.findOneProduct",pid);
			c.setProduct(p);
		}*/
		int res=sqlSession.selectOne("com.hw.entity.Cart.countProductInCart", user_id);
		int totalCount=res%pageSize==0?res/pageSize:(res/pageSize)+1;
		pageModel.setData(list);
		pageModel.setTotalCount(totalCount);
		////////////
		sqlSession.close();
		return pageModel;
	}

	@Override
	public int countProductInCart(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		int res=0;
		Object o=sqlSession.selectOne("com.hw.entity.Cart.sumProductInCart",user_id);
		sqlSession.close();
		if(o!=null) {
			res=(Integer)o;
		}
		return res;
	}

	@Override
	public int checkedOrUncheckedAllProductInCart(Integer user_id, Integer checked) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("user_id", user_id);
		map.put("checked", checked);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.update("com.hw.entity.Cart.checkedOrUncheckedAllProductInCart", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int selectOption(Integer user_id, Integer checked, Integer id) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("id", id);
		map.put("user_id", user_id);
		map.put("checked", checked);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.update("com.hw.entity.Cart.selectOption", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int updateCartProductInfo(Integer id, Integer quantity) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("id", id);
		map.put("quantity", quantity);
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.update("com.hw.entity.Cart.updateCartProductQuantity", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public Cart selectOneCart(Integer id) {
		// TODO Auto-generated method stub
		Cart cart=null;
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		cart=sqlSession.selectOne("com.hw.entity.Cart.selectOneCart", id);
		sqlSession.commit();
		sqlSession.close();
		return cart;
	}

	@Override
	public List<Cart> findCartByUserIdAndChecked(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(true);
		List<Cart> list=sqlSession.selectList("com.hw.entity.Cart.findCartByUserIdAndChecked", user_id);
		sqlSession.close();
		return list;
	}

	@Override
	public int deleteCheckedCartByUserId(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		int res=sqlSession.delete("com.hw.entity.Cart.deleteCheckedCartByUserId", user_id);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public BigDecimal getTotalPrice(Integer user_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlSessionFactory=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlSessionFactory.openSession(false);
		BigDecimal res=sqlSession.selectOne("com.hw.entity.Cart.getTotalPrice", user_id);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}
	
	
	
}
