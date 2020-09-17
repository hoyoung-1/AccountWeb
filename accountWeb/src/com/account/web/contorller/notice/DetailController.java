package com.account.web.contorller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.account.web.entity.Notice;
import com.account.web.service.NoticeService;

@WebServlet("/notice/detail")
public class DetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String noticeNo_ = request.getParameter("noticeNo");
		int noticeNo = 0;
		
		if(noticeNo_ !=null) {
			noticeNo = Integer.parseInt(noticeNo_);
		}
		
		NoticeService service = new NoticeService();
		
		Notice notice = service.detail(noticeNo);
		
		request.setAttribute("notice", notice);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp");
		dispatcher.forward(request, response);
		
	}
	
}
