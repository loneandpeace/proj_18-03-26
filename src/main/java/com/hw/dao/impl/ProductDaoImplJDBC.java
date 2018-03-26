package com.hw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hw.common.DBUtils;
import com.hw.dao.ProductDaoI;
import com.hw.entity.PageModel;
import com.hw.entity.Product;

public class ProductDaoImplJDBC implements ProductDaoI {
	private static ProductDaoI productDaoImpl=new ProductDaoImplJDBC();
	public static ProductDaoI getInstance() {
		return productDaoImpl;
	}
	@Override
	public PageModel<Product> findAllProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		PageModel<Product> pm=new PageModel<Product>();
		int tp=0;
		try {
			conn=DBUtils.getConnection();
			String sql="select * from product limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()) {
				/*
				 * public Product(int id, int category_id, String name, String subtitle, String main_image, 
				 * String sub_image,
					String detail, BigDecimal price, int stock, int status, Date create_time, Date update_time)
				 * */
				Product product=new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getBigDecimal(8),rs.getInt(9),rs.getInt(10),rs.getDate(11),rs.getDate(12),"");
				list.add(product);
			}
			ps=conn.prepareStatement("select count(id) from product");
			rs=ps.executeQuery();
			if(rs.next()) {
				int count=rs.getInt(1);
				tp=(count%pageSize)==0?(count/pageSize):(count/pageSize+1);
			}
			pm.setData(list);
			pm.setTotalCount(tp);
			return pm;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="insert into product(category_id,name,subtitle,main_image,sub_images,detail,price,stock,status,create_time,update_time) values(?,?,?,?,?,?,?,?,?,now(),now())";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, product.getCategory_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getSubtitle());
			ps.setString(4, product.getMain_image());
			ps.setString(5, product.getSub_images());
			ps.setString(6, product.getDetail());
			ps.setBigDecimal(7, product.getPrice());
			ps.setInt(8, product.getStock());
			ps.setInt(9, product.getStatus());
			int res=ps.executeUpdate();
			return res;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteProduct(int productid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		int res=0;
		try {
			conn=DBUtils.getConnection();
			String sql="Delete from product where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, productid);
			res=ps.executeUpdate();
			return res;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Product findOneProduct(int productid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product product=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select * from product where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, productid);
			rs=ps.executeQuery();
			if(rs.next()) {
				product=new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getBigDecimal(8),rs.getInt(9),rs.getInt(10),rs.getDate(11),rs.getDate(12),"");
			}
			return product;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update product set category_id=?,name=?,subtitle=?,main_image=?,sub_images=?,detail=?,price=?,stock=?,status=?,update_time=now() where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, product.getCategory_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getSubtitle());
			ps.setString(4, product.getMain_image());
			ps.setString(5, product.getSub_images());
			ps.setString(6, product.getDetail());
			ps.setBigDecimal(7, product.getPrice());
			ps.setInt(8, product.getStock());
			ps.setInt(9, product.getStatus());
			ps.setInt(10, product.getId());
			int res=ps.executeUpdate();
			return res;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtils.close(conn, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public PageModel<Product> findSomeProductByInfo(int pageNo, int pageSize, String info) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList<Product>();
		PageModel<Product> pm=new PageModel<Product>();
		int tp=0;
		try {
			conn=DBUtils.getConnection();
			String sql=" select * from product where name like ? limit ?,? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+info+"%");
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product(rs.getInt(1),rs.getInt(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getBigDecimal(8),rs.getInt(9),rs.getInt(10),rs.getDate(11),rs.getDate(12),"");
				list.add(product);
			}
			ps=conn.prepareStatement("select count(id) from product where id in(select id from product where name like ?)");
			ps.setString(1, "%"+info+"%");
			rs=ps.executeQuery();
			if(rs.next()) {
				int count=rs.getInt(1);
				tp=(count%pageSize)==0?(count/pageSize):(count/pageSize)+1;
			}
			pm.setData(list);
			pm.setTotalCount(tp);
			return pm;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) {
					DBUtils.close(conn, ps, rs);
				} else {
					DBUtils.close(conn, ps);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public long getProductStock(int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int reduceProductStock(int product_id, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}
}
