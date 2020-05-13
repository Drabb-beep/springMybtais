package com.springMybatis.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springMybatis.po.User;
@WebServlet(urlPatterns = "/insertUser")
public class InsertUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		��ȡ�û������id��name��password
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setPassword(password);
		//�����ַ�������
		resp.setContentType("text/html;charset=UTF-8");
		ApplicationContext acp = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService user= acp.getBean(UserService.class);
//		����û�
		user.Insertuser(u);
//		�ض���index.jsp
		resp.sendRedirect("index.jsp");
	}
}
