package com.account.web.contorller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.web.entity.Users;
import com.account.web.service.UserService;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/login.jsp");
		dispatcher.forward(request, response);
				
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		UserService service = new UserService();
		RequestDispatcher dispatcher = null;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Users user = service.login(id, pw);
		
		session.setAttribute("user", user);
		
		
		if(user != null) {
			response.sendRedirect("/home");
		} else {
			boolean error = true;
			request.setAttribute("error", error);
			dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/login.jsp");
			dispatcher.forward(request, response);
		}
	
	}
}
