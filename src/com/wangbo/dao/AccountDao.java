package com.wangbo.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangbo.entity.AccountBean;
import com.wangbo.entity.UserBean;

public interface AccountDao {
	List<AccountBean> list();
	
	AccountBean selectAccountByName(String name,int isPayed);
	
	int insertAccount(AccountBean accountBean) throws SQLException;
	
	int updateAccountById(AccountBean accountBean) throws SQLException;
	
	int deleteAccountById(int id) throws SQLException;
	
	AccountBean selectById(int id);

}
