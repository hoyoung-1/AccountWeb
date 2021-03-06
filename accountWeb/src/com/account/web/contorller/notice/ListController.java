package com.account.web.contorller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.account.web.entity.Notice;
import com.account.web.service.NoticeService;

@WebServlet("/notice/list")
public class ListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService service = new NoticeService();
		
		String page_ = request.getParameter("p");
		int page = 1;
		
		if(page_ != null ) {
			page = Integer.parseInt(page_);
		}
		
		List<Notice> list = service.getList(page);
		request.setAttribute("list", list);
		
		int count = service.listCount();
		request.setAttribute("count", count);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp");
		dispatcher.forward(request, response);
		
	}

}
