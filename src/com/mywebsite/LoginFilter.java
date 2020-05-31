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
        // 1. 로그인이 되어 있으면, chain.doFilter(request, response)를 호출해서 서블릿의 service()를 호출.
        if(session != null && session.getAttribute("id") !=null) {
        	  chain.doFilter(request, response);
        }
        
        // 2. 로그인이 되어 있지 않으면, loginForm.jsp로 forward하시오. (RequestDispatcher사용)
        else{
        	//로그인 하고 나서 눌렀던 페이지로가게 하고싶은데...
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/loginForm.jsp?");
        	dispatcher.forward(request, response);
        }
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void destroy() {}

}
