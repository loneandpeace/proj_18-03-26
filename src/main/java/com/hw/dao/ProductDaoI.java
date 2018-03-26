package com.hw.dao;

import com.hw.entity.PageModel;
import com.hw.entity.Product;

public interface ProductDaoI {
	public PageModel<Product> findAllProductByPage(int pageNo,int pageSize);
	public int addProduct(Product product);
	public int deleteProduct(int productid);
	public Product findOneProduct(int productid);
	public int updateProduct(Product product);
	public PageModel<Product> findSomeProductByInfo(int pageNo,int pageSize,String info);
	long getProductStock(int product_id);
	int reduceProductStock(int product_id, int quantity);
}
