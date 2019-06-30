package com.wangbo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangbo.dao.SupplierDao;
import com.wangbo.entity.SupplierBean;
import com.wangbo.entity.SupplierBean;
import com.wangbo.util.IObjectMap;
import com.wangbo.util.JdbcTemplate;

@SuppressWarnings("all")
public class SupplierDaoImpl implements SupplierDao{

	@Override
	public List<SupplierBean> list() {
	List<SupplierBean> list = new ArrayList<SupplierBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from supplier", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new SupplierBean(rs.getInt("s_id"),rs.getString("s_name"),rs.getString("s_info"),rs.getString("s_linkman"),rs.getString("s_phone"),rs.getString("s_address"),rs.getString("s_faxes"));
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
	public SupplierBean selectSupplierByName(String name) {
		List<SupplierBean> list = new ArrayList<SupplierBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from supplier where s_name = ?", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new SupplierBean(rs.getInt("s_id"),rs.getString("s_name"),rs.getString("s_info"),rs.getString("s_linkman"),rs.getString("s_phone"),rs.getString("s_address"),rs.getString("s_faxes"));
				}
			},name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list.size()>=1?list.get(0):null;
	}

	@Override
	public int insertSupplier(SupplierBean supplierBean) throws SQLException {
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("insert into supplier values(null,?,?,?,?,?,?)",supplierBean.getS_name(),supplierBean.getS_info(),supplierBean.getS_linkman(),supplierBean.getS_phone(),supplierBean.getS_address(),supplierBean.getS_faxes());

	}

	@Override
	public int updateSupplierById(SupplierBean supplierBean)
			throws SQLException {
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("update supplier set s_name=?,s_info=?,s_linkman=?,s_phone = ?,s_address=?,s_faxes = ? where s_id = ?",supplierBean.getS_name(),supplierBean.getS_info(),supplierBean.getS_linkman(),supplierBean.getS_phone(),supplierBean.getS_address(),supplierBean.getS_faxes(),supplierBean.getS_id());

	}

	@Override
	public int deleteSupplierById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return JdbcTemplate.executeUpdate("delete from supplier where s_id = ?", id);

	}

	@Override
	public SupplierBean selectById(int id) {
		List<SupplierBean> list = new ArrayList<SupplierBean>();
		
		try {
			list = JdbcTemplate.executeQuery("select * from supplier where s_id = ?", new IObjectMap() {
				
				@Override
				public Object getObjectFromResult(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					return new SupplierBean(rs.getInt("s_id"),rs.getString("s_name"),rs.getString("s_info"),rs.getString("s_linkman"),rs.getString("s_phone"),rs.getString("s_address"),rs.getString("s_faxes"));
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
