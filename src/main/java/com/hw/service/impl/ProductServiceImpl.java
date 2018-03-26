package com.hw.service.impl;

import com.hw.dao.ProductDaoI;
import com.hw.dao.impl.ProductDaoImpl;
import com.hw.entity.PageModel;
import com.hw.entity.Product;
import com.hw.service.ProductServiceI;

public class ProductServiceImpl implements ProductServiceI {
	//ProductDaoI productDaoImpl=ProductDaoImpl.getInstance();
	ProductDaoI productDao=new ProductDaoImpl();
	@Override
	public PageModel<Product> findAllProductService(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return productDao.findAllProductByPage(pageNo, pageSize);
	}

	@Override
	public int addProductService(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}

	@Override
	public int deleteProductService(int productid) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(productid);
	}

	@Override
	public Product findOneProductService(int productid) {
		// TODO Auto-generated method stub
		return productDao.findOneProduct(productid);
	}

	@Override
	public int updateProductService(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public PageModel<Product> findSomeProductByInfoService(int pageNo, int pageSize, String info) {
		// TODO Auto-generated method stub
		return productDao.findSomeProductByInfo(pageNo, pageSize, info);
	}

}
