package com.account.web.contorller.tip;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.account.web.entity.Tip;
import com.account.web.service.TipService;

@WebServlet("/tip/board")
public class BoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TipService service = new TipService();
		
		List<Tip> tip = service.getList();
		
		request.setAttribute("tip", tip);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/tip/board.jsp");
		dispatcher.forward(request, response);
	}
}
