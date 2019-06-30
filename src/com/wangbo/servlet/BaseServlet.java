package com.wangbo.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * dalongmao
 */

@SuppressWarnings("all")
public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		
		Class<? extends BaseServlet> clazz = this.getClass();
		
		try {
			Method m = clazz.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			//System.out.println(method);
			String result = (String) m.invoke(this,request,response);
			response.sendRedirect(result);
			//request.getRequestDispatcher(result).forward(request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
}
