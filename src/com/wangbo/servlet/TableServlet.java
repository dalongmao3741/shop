package com.wangbo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangbo.dao.AccountDao;
import com.wangbo.dao.SupplierDao;
import com.wangbo.dao.impl.AccountDaoImpl;
import com.wangbo.dao.impl.ProductTableDao;
import com.wangbo.dao.impl.SupplierDaoImpl;
import com.wangbo.entity.ProductTable;
import com.wangbo.service.AccountService;
import com.wangbo.service.SupplierService;


public class TableServlet extends BaseServlet {
	private ProductTableDao productTableDao = new ProductTableDao();
	
	public String listBySupp(HttpServletRequest request,HttpServletResponse response){
		List<ProductTable> list = productTableDao.list(); 
		
		request.getSession().setAttribute("list", list);
		return "suppTable.jsp";
	}
	public String listByProduct(HttpServletRequest request,HttpServletResponse response){
		return "table.jsp";
	}
	

}
