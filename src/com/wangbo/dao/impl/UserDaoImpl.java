package com.wangbo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangbo.dao.UserDao;
import com.wangbo.entity.UserBean;
import com.wangbo.util.IObjectMap;
import com.wangbo.util.JdbcTemplate;

public class UserDaoImpl implements UserDao{

	@SuppressWarnings("all")
	@Override
	public List<UserBean> list() {
		List<UserBean> list = new ArrayList<UserBean>();
		try {
			list = JdbcTemplate.executeQuery("select * from user", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new UserBean(rs.getInt("u_id"),rs.getString("u_name"),rs.getString("u_password"),rs.getString("u_gender"),rs.getInt("u_age"),rs.getString("u_phone"),rs.getString("u_address"),rs.getString("u_auth"));
				}
			}, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public UserBean selectUserByName(String username) {
		List<UserBean> list = new ArrayList<UserBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from user where u_name = ?", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new UserBean(rs.getInt("u_id"),rs.getString("u_name"),rs.getString("u_password"),rs.getString("u_gender"),rs.getInt("u_age"),rs.getString("u_phone"),rs.getString("u_address"),rs.getString("u_auth"));
				}
			}, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list.size()>=1?list.get(0):null;
	}

	@Override
	public int insertUser(UserBean userBean) throws SQLException {
		
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("insert into user values(0,?,?,?,?,?,?,?)", userBean.getU_name(),userBean.getU_password(),userBean.getU_gender(),userBean.getU_age(),userBean.getU_phone(),userBean.getU_address(),userBean.getU_auth());
	}

	@Override
	public int updateUserById(UserBean userBean) throws SQLException {
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("update user set u_name=?,u_password=?,u_gender=?,u_age=?,u_phone=?,u_address=? ,u_auth=? where u_id = ?",  userBean.getU_name(),userBean.getU_password(),userBean.getU_gender(),userBean.getU_age(),userBean.getU_phone(),userBean.getU_address(),userBean.getU_auth(),userBean.getU_id());
	}

	@Override
	public int deleteUserById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("delete from user where u_id =?", id);
	}

	@Override
	public UserBean login(String name, String password,String auth) {
		List<UserBean> list = new ArrayList<UserBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from user where u_name =? and u_password = ? and u_auth = ?", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new UserBean(rs.getInt("u_id"),rs.getString("u_name"),rs.getString("u_password"),rs.getString("u_gender"),rs.getInt("u_age"),rs.getString("u_phone"),rs.getString("u_address"),rs.getString("u_auth"));
				}
			},name,password,auth);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list.size()>=1?list.get(0):null;
	}

	@Override
	public UserBean selectById(int id) {
		List<UserBean> list = new ArrayList<UserBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from user where u_id = ?", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new UserBean(rs.getInt("u_id"),rs.getString("u_name"),rs.getString("u_password"),rs.getString("u_gender"),rs.getInt("u_age"),rs.getString("u_phone"),rs.getString("u_address"),rs.getString("u_auth"));
				}
			}, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list.size()>=1?list.get(0):null;
	}

}
