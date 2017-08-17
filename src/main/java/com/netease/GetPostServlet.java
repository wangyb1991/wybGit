package com.netease;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String name1 = req.getParameter("name1");
		String pw1 = req.getParameter("pw1");
		
//		HttpSession session = req.getSession();
//		String name = (String) session.getAttribute("userName");
//		session.setMaxInactiveInterval(2*60);
//		
//		// session失效
//		session.invalidate();
//		if (name != null) {
//			System.out.println("second login:"+name);
//		}
//		
//		session.setAttribute("userName", name1);
//		
//		Cookie userNameCookie = new Cookie("userName",name1);
//		Cookie pwdCookie = new Cookie("pwd",pw1);
//		
//		userNameCookie.setMaxAge(2*60);
//		pwdCookie.setMaxAge(2*60);
//		
//		resp.addCookie(userNameCookie);
//		resp.addCookie(pwdCookie);
//		
//		Cookie[] cookies = req.getCookies();
//		if (cookies != null) {
//			for (Cookie item : cookies) {
//				if (item.getName().equals("userName")) {
//					name1 = item.getValue();
//				}
//				if (item.getName().equals("pwd")) {
//					pw1 = item.getValue();
//				}
//			}
//		}
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>a servlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("调用doGet方法");
		out.println("<br/><br/>");
		out.println("用户名："+name1);
		out.println("<br/><br/>");
		out.println("密码："+pw1);
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String name2 = req.getParameter("name2");
		String pw2 = req.getParameter("pw2");
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>a servlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("调用doPost方法");
		out.println("<br/><br/>");
		out.println("用户名："+name2);
		out.println("<br/><br/>");
		out.println("密码："+pw2);
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
}
