package com.account.web.contorller.tip;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.account.web.service.TipService;

@WebServlet("/tip/insert")
public class InsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tip/insert.jsp");
		
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TipService service = new TipService();
		
		String userNo_ = request.getParameter("userNo");
		int userNo = 0;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		
		if(userNo_ != null ) {
			userNo = Integer.parseInt(userNo_);
		}
		
		System.out.println("user 고유 번호 : " + userNo);
		
		boolean flag = service.insert(userNo, title, content,writer);
		
		if(flag) {
			String answer = "입력되었습니다 !";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tip/board.jsp");
			dispatcher.forward(request, response);
			
		}else {
			String answer = "입력에 실패하였습니다. 빈 칸이 있는지 확인해주세요!";
			
			response.sendRedirect("/tip/insert");
		}
		
		
		
		
		
	}
}
