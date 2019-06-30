package com.wangbo.service;

import java.sql.SQLException;
import java.util.List;

import com.wangbo.dao.AccountDao;
import com.wangbo.dao.impl.AccountDaoImpl;
import com.wangbo.entity.AccountBean;
import com.wangbo.ts.TransactionImpl;

public class AccountService {
	private TransactionImpl transactionImpl = new TransactionImpl();
	private AccountDao accountDao = new AccountDaoImpl();
	
	public List<AccountBean> list(){
		return accountDao.list();
	}
	
	public AccountBean selectAccountByName(String name,int isPayed){
		return accountDao.selectAccountByName(name,isPayed);
	}
	public AccountBean selectById(int id){
		return accountDao.selectById(id);
	}
	public int insertAccount(AccountBean accountBean){
		int n = 0;
		try {
			transactionImpl.beginTransaction();
			n = accountDao.insertAccount(accountBean);
			transactionImpl.commit();
		} catch (SQLException e) {
			transactionImpl.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	public int updateAccountById(AccountBean accountBean){
		int n = 0;
		
		try {
			transactionImpl.beginTransaction();
			n = accountDao.updateAccountById(accountBean);
			transactionImpl.commit();
		} catch (SQLException e) {
			transactionImpl.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n ;
	}
	
	public int deleteAccountById(int id){
		int n = 0;
		
		try {
			transactionImpl.beginTransaction();
			n = accountDao.deleteAccountById(id);
			transactionImpl.commit();
		} catch (SQLException e) {
			transactionImpl.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
}
