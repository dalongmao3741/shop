package com.wangbo;

import java.sql.SQLException;

import com.wangbo.dao.SupplierDao;
import com.wangbo.dao.impl.SupplierDaoImpl;
import com.wangbo.dao.impl.UserDaoImpl;
import com.wangbo.entity.SupplierBean;
import com.wangbo.entity.UserBean;

public class test {
	public static void main(String[] args) {
		System.out.println(123);
		SupplierDao supplierDao = new SupplierDaoImpl();
		try {
			int n = supplierDao.insertSupplier(new SupplierBean(0, "das", "das", "das", null, null, null));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
