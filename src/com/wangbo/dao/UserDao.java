package com.wangbo.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangbo.entity.UserBean;

public interface UserDao {
	List<UserBean> list();
	
	UserBean selectUserByName(String username);
	
	int insertUser(UserBean userBean) throws SQLException;
	
	int updateUserById(UserBean userBean) throws SQLException;
	
	int deleteUserById(int id) throws SQLException;
	
	UserBean selectById(int id);
	
	UserBean login(String name,String password,String auth);

}
