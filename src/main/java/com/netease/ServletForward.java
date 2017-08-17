package com.netease;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForward extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 获取转发对象
		RequestDispatcher rd = req.getRequestDispatcher("/servletForwardExample");
		rd.forward(req, resp);
		
		// context获取转发对象的两种方式
//		rd = this.getServletContext().getNamedDispatcher("servletForwardExample");
//		rd = this.getServletContext().getRequestDispatcher("/servletForwardExample");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init method!");
	}
	
}
