package com.account.web.contorller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.web.service.UserService;

@WebServlet("/user/add")
public class AddController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/add.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		UserService service = new UserService();
		
		String id = request.getParameter("addID");
		String pw = request.getParameter("addPW");
		String name = request.getParameter("addName");
		
		boolean flag = service.userAdd(id, pw, name);
		System.out.println("결과값 : " + flag);
		
		if(flag) {
			System.out.println("회원가입이 되었음");
			request.setAttribute("flag", flag);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/login.jsp");
			dispatcher.forward(request, response);
			
		}else if(!flag) {
			System.out.println("회원가입 실패");
			response.sendRedirect("/user/add");
		}
		
	}

}
