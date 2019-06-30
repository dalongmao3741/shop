package com.wangbo.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangbo.entity.SupplierBean;

public interface SupplierDao {
	List<SupplierBean> list();
	
	SupplierBean selectSupplierByName(String name);
	
	int insertSupplier(SupplierBean supplierBean) throws SQLException;
	
	int updateSupplierById(SupplierBean supplierBean) throws SQLException;
	
	int deleteSupplierById(int id) throws SQLException;
	
	SupplierBean selectById(int id);

}
