package com.hw.service;

import com.hw.entity.Product;
import com.hw.entity.PageModel;

public interface ProductServiceI {
	public PageModel<Product> findAllProductService(int pageNo,int pageSize);
	public int addProductService(Product product);
	public int deleteProductService(int productid);
	public Product findOneProductService(int productid);
	public int updateProductService(Product product);
	public PageModel<Product> findSomeProductByInfoService(int pageNo,int pageSize,String info);
}
