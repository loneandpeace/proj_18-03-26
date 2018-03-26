package com.hw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hw.common.MybatisUtils;
import com.hw.dao.ProductDaoI;
import com.hw.entity.PageModel;
import com.hw.entity.Product;

public class ProductDaoImpl implements ProductDaoI {

	@Override
	public PageModel<Product> findAllProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		int offset=(pageNo-1)*pageSize;
		PageModel<Product> pageModel=new PageModel<Product>();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		List<Product> list=sqlSession.selectList("com.hw.entity.Product.findAllProductByPage", map);
		int totalCount=sqlSession.selectOne("com.hw.entity.Product.findTotalCount", pageSize);
		pageModel.setData(list);
		
		int tp=(totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize+1);
		pageModel.setTotalCount(tp);
		sqlSession.close();
		return pageModel;
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("category_id", product.getCategory_id());
		map.put("name", product.getName());
		map.put("subtitle", product.getSubtitle());
		map.put("main_image", product.getMain_image());
		map.put("sub_images", product.getSub_images());
		map.put("detail", product.getDetail());
		map.put("price", product.getPrice());
		map.put("stock", product.getStock());
		map.put("status", product.getStatus());
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		//sqlSession=sqlMapper.openSession();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.update("com.hw.entity.Product.addProduct", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public int deleteProduct(int productid) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		//sqlSession=sqlMapper.openSession();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.delete("com.hw.entity.Product.deleteProduct", productid);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public Product findOneProduct(int productid) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		Product product=sqlSession.selectOne("com.hw.entity.Product.findOneProduct", productid);
		sqlSession.close();
		if(product!=null) {
			return product;
		}else {
			return null;
		}
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("category_id", product.getCategory_id());
		map.put("name", product.getName());
		map.put("subtitle", product.getSubtitle());
		map.put("main_image", product.getMain_image());
		map.put("sub_images", product.getSub_images());
		map.put("detail", product.getDetail());
		map.put("price", product.getPrice());
		map.put("stock", product.getStock());
		map.put("status", product.getStatus());
		map.put("id", product.getId());
		
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		//sqlSession=sqlMapper.openSession();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.update("com.hw.entity.Product.updateProduct", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public PageModel<Product> findSomeProductByInfo(int pageNo, int pageSize, String info) {
		// TODO Auto-generated method stub
		int offset=(pageNo-1)*pageSize;
		PageModel<Product> pageModel=new PageModel<Product>();
		Map<String,Object> map=new HashMap<String,Object>();
		String infor="%"+info+"%";
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		map.put("infor", infor);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		List<Product> list=sqlSession.selectList("com.hw.entity.Product.findSomeProductByInfo", map);
		int totalCount=sqlSession.selectOne("com.hw.entity.Product.countSomeProductByInfo", infor);
		pageModel.setData(list);
		
		int tp=(totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize+1);
		pageModel.setTotalCount(tp);
		sqlSession.close();
		return pageModel;
	}

	@Override
	public long getProductStock(int product_id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		long res=sqlSession.selectOne("com.hw.entity.Product.getProductStock",product_id);
		sqlSession.close();
		return res;
	}

	@Override
	public int reduceProductStock(int product_id, int quantity) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("product_id", product_id);
		map.put("quantity", quantity);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.update("com.hw.entity.Product.reduceProductStock",map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

}
