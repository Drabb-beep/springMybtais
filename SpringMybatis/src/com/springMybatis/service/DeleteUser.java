package com.springMybatis.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@WebServlet(urlPatterns = "/deleteUser")
public class DeleteUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		获取num变量
		int num=Integer.valueOf(req.getParameter("num"));
		resp.setContentType("text/html;charset=UTF-8");
		ApplicationContext acp = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService user= acp.getBean(UserService.class);
//		根据用户num删除用户
		user.Deleteuser(num);
//		重定向到index.jsp
		resp.sendRedirect("index.jsp");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
