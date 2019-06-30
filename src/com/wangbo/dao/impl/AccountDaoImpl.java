package com.wangbo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangbo.dao.AccountDao;
import com.wangbo.entity.AccountBean;
import com.wangbo.entity.UserBean;
import com.wangbo.util.IObjectMap;
import com.wangbo.util.JdbcTemplate;

@SuppressWarnings("all")
public class AccountDaoImpl implements AccountDao{

	@Override
	public List<AccountBean> list() {
		List<AccountBean> list = new ArrayList<AccountBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from account", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new AccountBean(rs.getInt("a_id"),rs.getString("a_name"),rs.getInt("a_nums"),rs.getDouble("a_amount"),rs.getString("a_unit"),rs.getInt("a_ispayed"),rs.getString("s_name"),rs.getString("a_info"),rs.getString("a_date"));
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
	public AccountBean selectAccountByName(String name,int isPayed) {
		List<AccountBean> list = new ArrayList<AccountBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from account where a_name = ? and a_ispayed=?", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new AccountBean(rs.getInt("a_id"),rs.getString("a_name"),rs.getInt("a_nums"),rs.getDouble("a_amount"),rs.getString("a_unit"),rs.getInt("a_ispayed"),rs.getString("s_name"),rs.getString("a_info"),rs.getString("a_date"));
				}
			},name,isPayed);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list.size()>=1?list.get(0):null;
	}

	@Override
	public int insertAccount(AccountBean accountBean) throws SQLException {
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("insert into account values(0,?,?,?,?,?,?,?,?)", accountBean.getA_name(),accountBean.getA_nums(),accountBean.getA_amount(),accountBean.getA_unit(),accountBean.getA_ispayed(),accountBean.getS_name(),accountBean.getA_Info(),accountBean.getA_Date());
	}

	@Override
	public int updateAccountById(AccountBean accountBean) throws SQLException {
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("update account set a_name=?,a_nums=?,a_amount=? ,a_unit=?,a_ispayed=?,s_name=?,a_info=?,a_date=? where a_id = ?", accountBean.getA_name(),accountBean.getA_nums(),accountBean.getA_amount(),accountBean.getA_unit(),accountBean.getA_ispayed(),accountBean.getS_name(),accountBean.getA_Info(),accountBean.getA_Date(),accountBean.getA_id());
	}

	@Override
	public int deleteAccountById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("delete from account where a_id = ?", id);
	}

	@Override
	public AccountBean selectById(int id) {
		List<AccountBean> list = new ArrayList<AccountBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from account where a_id = ?", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new AccountBean(rs.getInt("a_id"),rs.getString("a_name"),rs.getInt("a_nums"),rs.getDouble("a_amount"),rs.getString("a_unit"),rs.getInt("a_ispayed"),rs.getString("s_name"),rs.getString("a_info"),rs.getString("a_date"));
				}
			},id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list.size()>=1?list.get(0):null;
	}

}
