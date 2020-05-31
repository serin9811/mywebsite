package com.mywebsite;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idValue= request.getParameter("id");
		String pwdValue= request.getParameter("pwd");
		String url=request.getParameter("url");
		HttpSession session = request.getSession();
	
		//id �� pwd�� ��ġ�ϸ� ���ǿ� ����id �����ϰ� ���� �������� ����.
		if(checkIdPwd(idValue, pwdValue)) {
			session.setAttribute("id", idValue);
			response.sendRedirect(url);
		}
		
		//id pwd����ġ �� loginForm���� �ǵ��ư���.
		else {
			RequestDispatcher reqDis= request.getRequestDispatcher("/loginForm.jsp");
			reqDis.forward(request, response);
		}
	}
	
	//id �� pwd�� ��ġ�ϴ� �� Ȯ���ϴ� �޼���
	boolean checkIdPwd(String id, String pwd) {
		return id.equals("s") && pwd.equals("123");
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
