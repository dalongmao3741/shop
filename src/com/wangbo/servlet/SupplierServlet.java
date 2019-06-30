package com.wangbo.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wangbo.dao.SupplierDao;
import com.wangbo.dao.impl.SupplierDaoImpl;
import com.wangbo.entity.SupplierBean;
import com.wangbo.entity.UserBean;
import com.wangbo.service.SupplierService;

/**
 * dalongmao
 */
public class SupplierServlet extends BaseServlet {
	private SupplierService supplierService = new SupplierService();
	private SupplierDao supplierDao = new SupplierDaoImpl();
	
	public String list(HttpServletRequest request,HttpServletResponse response){
		List<SupplierBean> supplierList = new ArrayList<SupplierBean>();
		
		supplierList = supplierService.list();
		
		request.getSession().setAttribute("supplierList", supplierList);
		
		return "providerList.jsp";
	}
	public String findByName(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("pname");
		SupplierBean supplierBean = supplierService.selectSupplierByName(name);
		request.getSession().setAttribute("supplierBean", supplierBean);
		
		return "providerView.jsp";
	}
	
	public String insert(HttpServletRequest request,HttpServletResponse response){
		SupplierBean supplierBean = new SupplierBean();
		try {
			BeanUtils.populate(supplierBean, request.getParameterMap());
			supplierService.insertSupplier(supplierBean);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "supplierServlet?method=list";
	}
	public String toUpdate(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("pid");
		String auth = request.getParameter("u_auth");
		if(auth.equals("部门经理")){
	
		SupplierBean supplierBean = supplierService.selectById(Integer.parseInt(id));
		
		request.getSession().setAttribute("supplier", supplierBean);
		
		return "providerUpdate.jsp";
		}
		return "noAuth.jsp";
		
	}
	public String updateById(HttpServletRequest request,HttpServletResponse responset){
		SupplierBean supplierBean =new SupplierBean();
		
		try {
			BeanUtils.populate(supplierBean, request.getParameterMap());
			supplierService.updateSupplierById(supplierBean);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "supplierServlet?method=list";
	}
	public String deleteById(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("pid");
		String auth = request.getParameter("u_auth");
		if(auth.equals("部门经理")){
			
		supplierService.deleteSupplierById(Integer.valueOf(id));
		return "supplierServlet?method=list";
		}
		return "noAuth.jsp";
	}
	public String exportTable(HttpServletRequest request,HttpServletResponse response){
		List<SupplierBean> list = new ArrayList<>();
		list = supplierService.list();
		File file = new File("/home/soft01/supplier.txt");
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			for(int i = 0;i<list.size();i++){
				bufferedWriter.write(list.get(i).toString());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "supplierServlet?method=list";
		
	}
	
}
