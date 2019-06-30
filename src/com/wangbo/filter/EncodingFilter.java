package com.wangbo.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	private String charset= null ; 
	
	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter("charset");
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req ;
		HttpServletResponse response = (HttpServletResponse) resp;
		String method = request.getMethod();
		if("POST".equals(method)) {
			request.setCharacterEncoding("utf-8");
		}else{
			//
			request = new MyRequest(request);
		}
		chain.doFilter(request, response);
	}
	
	
	public class MyRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}
		@Override
		public String getParameter(String name) {
			String value =  request.getParameter(name);
			try {
				if(value!=null) {
					value = new String(value.getBytes("iso-8859-1"),"utf-8");
					return value ; 
				}else{
					return null ; 
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null ;
			}
			
		}
		@Override
		public String[] getParameterValues(String name) {
			String[] values=  request.getParameterValues(name) ; 
			try {
				if(values!=null) {
					for(int i = 0 ;i<values.length;i++) {
						values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
					}
					return values ; 
				}else{
					return null ; 
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}	
	}
	public void destroy() {}

}
