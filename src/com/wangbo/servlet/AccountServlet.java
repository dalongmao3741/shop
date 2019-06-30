package com.wangbo.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wangbo.dao.AccountDao;
import com.wangbo.dao.impl.AccountDaoImpl;
import com.wangbo.entity.AccountBean;
import com.wangbo.entity.UserBean;
import com.wangbo.service.AccountService;

/**
 * dalongmao
 */
public class AccountServlet extends BaseServlet {
	private AccountDao accountDao = new AccountDaoImpl();
	private AccountService accountService = new AccountService();
	
	public String list(HttpServletRequest request,HttpServletResponse response){
		List<AccountBean> accountList = new ArrayList<AccountBean>();
		accountList = accountService.list();
		request.getSession().setAttribute("accountList", accountList);
		return "billList.jsp";
	}
	public String findByName(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("a_name");
		String pay = request.getParameter("a_ispayed");

		AccountBean accountBean = accountService.selectAccountByName(name,Integer.valueOf(pay));
		request.getSession().setAttribute("accountBean", accountBean);
		
		return "billView.jsp";
	}
	public String insertAccount(HttpServletRequest request,HttpServletResponse response){

		String name = request.getParameter("a_name");
		String nums = request.getParameter("a_nums");
		String amount = request.getParameter("a_amount");
		String unit = request.getParameter("a_unit");
		String pay = request.getParameter("a_ispayed");
		String sname = request.getParameter("s_name");
		String info = request.getParameter("a_info");

		AccountBean accountBean = new AccountBean();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		accountBean.setA_name(name);
		accountBean.setA_nums(Integer.parseInt(nums));
		accountBean.setA_amount(Double.parseDouble(amount));
		accountBean.setA_unit(unit);
		accountBean.setA_ispayed(Integer.parseInt(pay));
		accountBean.setS_name(sname);
		accountBean.setA_Info(info);
		
		accountBean.setA_Date(simpleDateFormat.format(date));
		accountService.insertAccount(accountBean);
		return "accountServlet?method=list";
	}
	public String toUpdate(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("a_id");
		String auth = request.getParameter("u_auth");
		if(auth.equals("部门经理")){
			AccountBean accountBean = accountService.selectById(Integer.parseInt(id));
			
			request.getSession().setAttribute("accountBean", accountBean);
			return "billUpdate.jsp";
		}
		return "noAuth.jsp";
	}
	
	public String updateById(HttpServletRequest request,HttpServletResponse response){
	
		String id = request.getParameter("a_id");
		String name = request.getParameter("a_name");
		String nums = request.getParameter("a_nums");
		String amount = request.getParameter("a_amount");
		String unit = request.getParameter("a_unit");
		String pay = request.getParameter("a_ispayed");
		String sname = request.getParameter("s_name");
		String info = request.getParameter("a_info");
		

		AccountBean accountBean = new AccountBean();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		accountBean.setA_id(Integer.parseInt(id));
		accountBean.setA_name(name);
		accountBean.setA_nums(Integer.parseInt(nums));
		accountBean.setA_amount(Double.parseDouble(amount));
		accountBean.setA_unit(unit);
		accountBean.setA_ispayed(Integer.parseInt(pay));
		accountBean.setS_name(sname);
		accountBean.setA_Info(info);		
		accountBean.setA_Date(simpleDateFormat.format(date));
		
		accountService.updateAccountById(accountBean);
		
		return "accountServlet?method=list";
	}
	public String deleteById(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("a_id");
		String auth = request.getParameter("u_auth");
		if(auth.equals("部门经理")){
		accountService.deleteAccountById(Integer.valueOf(id));
		
		return "accountServlet?method=list";
		}
		return "noAuth.jsp";
	}
	public String exportTable(HttpServletRequest request,HttpServletResponse response){
		List<AccountBean> list = new ArrayList<>();
		list = accountService.list();
		File file = new File("/home/soft01/account.txt");
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

		
		return "accountServlet?method=list";
		
	}
	
}
