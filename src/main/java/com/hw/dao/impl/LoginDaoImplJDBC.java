package com.hw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hw.common.DBUtils;
import com.hw.dao.LoginDao;
import com.hw.entity.User;



public class LoginDaoImplJDBC implements LoginDao {
	
	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			connection=DBUtils.getConnection();
			ps=connection.prepareStatement("select username from user where username=? and role=0");
			ps.setString(1, username);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					DBUtils.close(connection,ps,rs);
				}
				if(rs==null) {
					DBUtils.close(connection,ps);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
	}

	@Override
	public User checkUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			connection=DBUtils.getConnection();
			
			st=connection.prepareStatement("select id,username,password from user where username=? and password=? and role=0");
			st.setString(1, username);
			st.setString(2, password);
			
			rs=st.executeQuery();
			
			if(rs.next()) {
				User user=new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				return user;
			}
			else{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					DBUtils.close(connection,st,rs);
				}
				if(rs==null) {
					DBUtils.close(connection,st);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

	@Override
	public boolean updateUsertoken(String token,String username) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtils.getConnection();
			String sql="update user set token=? where username=? and role=0";
			ps=conn.prepareStatement(sql);
			ps.setString(1, token);
			ps.setString(2, username); 
			int res=ps.executeUpdate();
			if(res>0) {
				return true;
			}else {
				return false;
			}
			
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
		return false;
	}

	@Override
	public User checkUserToken(String token) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try {
			conn=DBUtils.getConnection();
			String sql="select * from user where token=? and role=0";
			ps=conn.prepareStatement(sql);
			ps.setString(1, token);
			rs=ps.executeQuery();
			if(rs.next()) {
				user=new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(5));
				return user;
			}else {
				return null;
			}
			
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
	public int removeUserToken(String token) {
		// TODO Auto-generated method stub
		return 0;
	}
}
