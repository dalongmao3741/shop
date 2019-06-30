package com.wangbo.service;

import java.sql.SQLException;
import java.util.List;

import com.wangbo.dao.UserDao;
import com.wangbo.dao.impl.UserDaoImpl;
import com.wangbo.entity.UserBean;
import com.wangbo.ts.TransactionImpl;

public class UserService {
	private TransactionImpl transactionImpl = new TransactionImpl();
	private UserDao userDao = new UserDaoImpl();
	
	public UserBean login(String name,String password,String auth){
		return userDao.login(name, password,auth);
	}
	public int insert(UserBean userBean) throws SQLException{
		return userDao.insertUser(userBean);
		
	}
	public List<UserBean> list(){
		return userDao.list();
	}
	
	public UserBean selectUserByName(String username){
		return userDao.selectUserByName(username);
	}
	public UserBean selectById(int id ){
		return userDao.selectById(id);
	}
	public int insertUser(UserBean userBean){
		int n = 0;
		try {
			transactionImpl.beginTransaction();
			n = userDao.insertUser(userBean);
			transactionImpl.commit();
		} catch (SQLException e) {
			transactionImpl.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return n;
	}
	
	public int updateUserById(UserBean userBean){
		int n = 0;
		try {
			transactionImpl.beginTransaction();
			n = userDao.updateUserById(userBean);
			transactionImpl.commit();
		} catch (SQLException e) {
			transactionImpl.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return n;
	}
	
	public int deleteUserById(int id){
		int n = 0;
		try {
			transactionImpl.beginTransaction();
			n = userDao.deleteUserById(id);
			transactionImpl.commit();
		} catch (SQLException e) {
			transactionImpl.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return n;
	}

}
