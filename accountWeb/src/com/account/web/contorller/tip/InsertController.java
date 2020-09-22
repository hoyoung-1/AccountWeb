package com.account.web.contorller.tip;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tip/insert")
public class InsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tip/Insert.jsp");
		
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userNo_ = request.getParameter("userNo");
		int userNo = 0;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		if(userNo_ != null ) {
			userNo = Integer.parseInt(userNo_);
		}
		System.out.println("user 고유 번호 : " + userNo);
		
		
		
	}
}
