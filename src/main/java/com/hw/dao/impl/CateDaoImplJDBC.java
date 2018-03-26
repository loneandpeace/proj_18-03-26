package com.hw.dao.impl;

import com.hw.entity.Cart;
import com.hw.entity.Cate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hw.common.DBUtils;
import com.hw.dao.CateDaoI;
import com.hw.entity.PageModel;

public class CateDaoImplJDBC implements CateDaoI {
	private static CateDaoI cateDaoImpl=new CateDaoImplJDBC();
	public static CateDaoI getInstance() {
		return cateDaoImpl;
	}
	@Override
	public PageModel<Cate> findAllCateByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Cate> list=new ArrayList<Cate>();
		PageModel<Cate> pm=new PageModel<Cate>();
		int tp=0;
		try {
			conn=DBUtils.getConnection();
			String sql="select * from category limit ?,?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cate cate=new Cate(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
				list.add(cate);
			}
			ps=conn.prepareStatement("select count(id) from category");
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
	public int addCate(Cate cate) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="insert into category(parent_id,name,status,sort_order,create_time,update_time) values(?,?,?,?,now(),now())";
			ps=conn.prepareStatement(sql);
			//ps.setInt(1, cate.getId());
			ps.setInt(1, cate.getParent_id());
			ps.setString(2, cate.getName());
			ps.setInt(3, cate.getStatus());
			ps.setInt(4, cate.getSort_order());
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
	public int deleteCate(int cateid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		int res=0;
		try {
			conn=DBUtils.getConnection();
			String sql="Delete from category where id=? or parent_id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cateid);
			ps.setInt(2, cateid);
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
	public Cate findOneCate(int cateid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cate cate=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select * from category where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cateid);
			rs=ps.executeQuery();
			if(rs.next()) {
				cate=new Cate(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
			}
			return cate;
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
	public int updateCate(Cate cate) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update category set parent_id=?,name=?,status=?,sort_order=?,update_time=now() where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cate.getParent_id());
			ps.setString(2, cate.getName());
			ps.setInt(3, cate.getStatus());
			ps.setInt(4, cate.getSort_order());
			ps.setInt(5, cate.getId());
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
	public List<Cate> findAllCateId() {
		// TODO Auto-generated method stub
		List<Cate> list=new ArrayList<Cate>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select * from category";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cate cate=new Cate(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
				list.add(cate);
			}
			return list;
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
	public PageModel<Cate> findSomeCateByInfo(int pageNo, int pageSize, String info) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Cate> list=new ArrayList<Cate>();
		PageModel<Cate> pm=new PageModel<Cate>();
		int tp=0;
		try {
			conn=DBUtils.getConnection();
			String sql=" select * from category where name like ? limit ?,? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+info+"%");
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs=ps.executeQuery();
			while(rs.next()) {
				Cate cate=new Cate(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getDate(6), rs.getDate(7));
				list.add(cate);
			}
			ps=conn.prepareStatement("select count(id) from category where id in(select id from category where name like ?)");
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
	
	
	public List<Cart> findCartByUserIdAndChecked(Integer user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
