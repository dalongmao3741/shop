package com.wangbo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;






import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
public class DbUtil {
	public static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	public static DataSource ds;
	static{
		Properties prop = new Properties();
		InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			prop.load(is);
			ds=BasicDataSourceFactory.createDataSource(prop);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn=threadLocal.get();
		if(conn==null) {
			conn = ds.getConnection();
			threadLocal.set(conn);
		}
		return conn ; 
	}
	
	public static void closeConnection() throws SQLException{
		Connection conn=threadLocal.get();
		if(conn!=null) {
			conn.close();
		}
		threadLocal.set(null);
	}
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn){
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null ){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
