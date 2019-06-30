package com.wangbo.service;

import java.sql.SQLException;
import java.util.List;

import com.wangbo.dao.SupplierDao;
import com.wangbo.dao.impl.SupplierDaoImpl;
import com.wangbo.entity.SupplierBean;
import com.wangbo.ts.TransactionImpl;

public class SupplierService {
	private TransactionImpl transactionImpl = new TransactionImpl();
	private SupplierDao supplierDao = new SupplierDaoImpl();
	
	public List<SupplierBean> list(){
		return supplierDao.list();
	}
	
	public SupplierBean selectSupplierByName(String name){
		return supplierDao.selectSupplierByName(name);
	}
	public SupplierBean selectById(int id){
		return supplierDao.selectById(id);
	}
	public int insertSupplier(SupplierBean supplierBean){
		int n = 0;
		
		try {
			transactionImpl.beginTransaction();
			n = supplierDao.insertSupplier(supplierBean);
			transactionImpl.commit();
		} catch (SQLException e) {
			transactionImpl.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
		
	}
	
	public int updateSupplierById(SupplierBean supplierBean){
		int n = 0;
		
		try {
			transactionImpl.beginTransaction();
			
			n = supplierDao.updateSupplierById(supplierBean);
			transactionImpl.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n ;
	}
	
	public int deleteSupplierById(int id){
		int n = 0;
		try {
			transactionImpl.beginTransaction();
			n = supplierDao.deleteSupplierById(id);
			transactionImpl.commit();
		} catch (SQLException e) {
			transactionImpl.rollback();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return n;
	}
}
