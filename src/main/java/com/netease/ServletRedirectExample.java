package com.netease;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRedirectExample extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 与转发不同，两次请求和响应，第二次的user参数应该为空
		String user = req.getParameter("user");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head><title>转发实例</title></head>");
		pw.println("<body>username is"+user+"</body></html>");
		resp.setContentType("text/html;charset=utf-8");
		pw.close();
	}
	
}
