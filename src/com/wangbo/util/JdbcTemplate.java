package com.wangbo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
	public static int executeUpdate(String sql,Object...params) throws SQLException {
		int result = -1 ; 
		Connection conn = DbUtil.getConnection();
		PreparedStatement pstmt=null;
		pstmt = conn.prepareStatement(sql);
		if(params!=null) {
			for(int i = 0 ;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		result= pstmt.executeUpdate();
		DbUtil.close(null, pstmt, null);
		return result ;
	}
	public static List executeQuery(String sql,IObjectMap objectMap ,Object ...params) throws SQLException {
		List list = new ArrayList();
		ResultSet rs = null ; 
		Connection conn = DbUtil.getConnection();
		PreparedStatement pstmt=null;
		pstmt = conn.prepareStatement(sql);
		if(params!=null) {
			for(int i = 0 ;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		rs= pstmt.executeQuery();
		while(rs.next()) {
			list.add(objectMap.getObjectFromResult(rs));
		}
		DbUtil.close(rs, pstmt, null);
		return list ; 
	}
	
	
}
