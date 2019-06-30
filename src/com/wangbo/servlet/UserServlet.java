package com.wangbo.servlet;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.deploy.LoginConfig;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wangbo.dao.UserDao;
import com.wangbo.dao.impl.UserDaoImpl;
import com.wangbo.entity.UserBean;
import com.wangbo.service.UserService;

/**
 * dalongmao
 */

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	private UserDao userDao = new UserDaoImpl();
	
	public String login(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String auth = request.getParameter("auth");
		
		UserBean userBean = userService.login(username, password,auth);
		if(userBean==null){
			request.getSession().setAttribute("msg", "用户名或密码错误");
			return "login.jsp";
		}else {
			request.getSession().setAttribute("user", userBean);
			return "index.jsp";
		}
	}
	public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
		return "login.jsp";
	}
	public String list(HttpServletRequest request,HttpServletResponse response){
		List<UserBean> userlist = new ArrayList<UserBean>();
		userlist = userService.list();
		request.getSession().setAttribute("userList", userlist);
		
		return "userList.jsp";
	}
	
	public String selectUserByName(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("u_name");
		UserBean userBean = userService.selectUserByName(name);
		request.getSession().setAttribute("userBean", userBean);
		
		return "userView.jsp";
	}
	
	public String insertUser(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String auth = request.getParameter("auth");
		
		UserBean userBean = new UserBean();
		userBean.setU_name(name);
		userBean.setU_address(address);
		userBean.setU_age(Integer.parseInt(age.trim()));
		userBean.setU_auth(auth);
		userBean.setU_phone(phone);
		userBean.setU_password(password);
		userBean.setU_gender(gender);
		
		try {
			userService.insert(userBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "userServlet?method=list";
		
	}
	public String toUpdate(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("u_id");
		String auth = request.getParameter("u_auth");
		if(auth.equals("部门经理")){
			UserBean u = userService.selectById(Integer.parseInt(id));
			
			request.getSession().setAttribute("u", u);
			
			return "userUpdate.jsp";
			
		}else{
			return "noAuth.jsp";
		}		
	}
	public String  updateUserById(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("u_id");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String auth = request.getParameter("auth");
		
		UserBean userBean = new UserBean();
		userBean.setU_id(Integer.parseInt(id));
		userBean.setU_name(name);
		userBean.setU_address(address);
		userBean.setU_age(Integer.parseInt(age.trim()));
		userBean.setU_auth(auth);
		userBean.setU_phone(phone);
		userBean.setU_password(password);
		userBean.setU_gender(gender);
		
		userService.updateUserById(userBean);
		return "userServlet?method=list";
	}
	
	public String  deleteUserById(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("u_id");
		String auth = request.getParameter("u_auth");
		if(auth.equals("部门经理")){
		userService.deleteUserById(Integer.parseInt(id.trim()));
		return "userServlet?method=list";
		}
		return "noAuth.jsp";
	}

	public String exportTable(HttpServletRequest request,HttpServletResponse response){
		
		List<UserBean> userlist = new ArrayList<UserBean>();
		userlist = userService.list();
		File file = new File("/home/soft01/user.txt");
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			for(int i = 0;i<userlist.size();i++){
				bufferedWriter.write(userlist.get(i).toString());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "userServlet?method=list";	
	}
	
	public String test(HttpServletRequest request,HttpServletResponse response){
		//String path = "/home/soft01/";
		boolean flag = ServletFileUpload.isMultipartContent(request);
		if(flag){
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
		        List<FileItem> items;
				items = upload.parseRequest(request);
				Iterator<FileItem> itr = items.iterator();
				 FileItem item;
		         while (itr.hasNext()) {
		             item = (FileItem) itr.next();
		             String fileName = item.getName();
		             if(fileName!=null){
	                     File fullFile=new File(item.getName());
	                     String realPath = fullFile.getAbsolutePath().substring(0, 13)+fullFile.getAbsolutePath().substring(24);
	                     System.out.println(fullFile);
	                     System.out.println(System.getProperty("user.txt"));
	                     System.out.println(realPath);

	             		List<UserBean> userlist = new ArrayList<UserBean>();
	             		userlist = userService.list();
	             		File file = new File(realPath);
	             		try {
	             			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
	             			for(int i = 0;i<userlist.size();i++){
	             				bufferedWriter.write(userlist.get(i).toString());
	             				bufferedWriter.newLine();
	             			}
	             			bufferedWriter.close();
	             		} catch (IOException e) {
	             			// TODO Auto-generated catch block
	             			e.printStackTrace();
	             		}	
	                     
	                 }
		         }		        
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "userServlet?method=list";
	}
}
