package com.mywebsite;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="LoginFilter",  urlPatterns= {"/board.jsp", "/lecture.jsp"})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		  HttpServletRequest httpRequest = (HttpServletRequest)request;
		  HttpSession session = httpRequest.getSession(true);
        // 1. �α����� �Ǿ� ������, chain.doFilter(request, response)�� ȣ���ؼ� ������ service()�� ȣ��.
        if(session != null && session.getAttribute("id") !=null) {
        	  chain.doFilter(request, response);
        }
        
        // 2. �α����� �Ǿ� ���� ������, loginForm.jsp�� forward�Ͻÿ�. (RequestDispatcher���)
        else{
        	//�α��� �ϰ� ���� ������ �������ΰ��� �ϰ������...
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/loginForm.jsp?");
        	dispatcher.forward(request, response);
        }
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void destroy() {}

}
