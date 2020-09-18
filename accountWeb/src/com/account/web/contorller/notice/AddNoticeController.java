package com.account.web.contorller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.account.web.service.NoticeService;

@WebServlet("/notice/add")
public class AddNoticeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/add.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService service = new NoticeService();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean flag = service.insert(title,content);
		
		request.setAttribute("flag", flag);
		
		if(flag) { //성공한 경우
			System.out.println("입력성공");
			response.sendRedirect("/notice/list");
		}else { // 입력실패
			System.out.println("입력실패");
			response.sendRedirect("/notice/add");
		}
	}
}
