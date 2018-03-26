package com.hw.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	public static Properties ps=new Properties();
	static {
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			ps.load(is);
			Class.forName(ps.getProperty("driver"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//Class.forName(ps.getProperty("driver"));
		Connection conn=null;
		conn=DriverManager.getConnection(ps.getProperty("url"),ps.getProperty("username"),ps.getProperty("password"));
		return conn;
	}
	public static void close(Connection conn) throws SQLException{
		conn.close();
	}
	public static void close(Connection conn,Statement st) throws SQLException{
		st.close();
		conn.close();
	}
	public static void close(Connection conn,PreparedStatement st) throws SQLException{
		st.close();
		conn.close();
	}
	public static void close(Connection conn,PreparedStatement st,ResultSet rest) throws SQLException{
		rest.close();
		st.close();
		conn.close();
	}
}
