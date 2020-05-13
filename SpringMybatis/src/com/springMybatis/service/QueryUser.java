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

import net.sf.json.JSONArray;
@WebServlet(urlPatterns = "/queryUser")
public class QueryUser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
//		System.out.println(name);
		resp.setContentType("text/html;charset=UTF-8");
		ApplicationContext acp = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService user= acp.getBean(UserService.class);
//		ģ����ѯ�û���Ϣ
		List<User> u=user.finduser(name);
//		��list��user��ת���json����
		JSONArray json = new JSONArray().fromObject(u);
//		String json =JSON.toJSONString(u);
		PrintWriter out =resp.getWriter();//��ȡPrintWriter����
		out.print(json.toString());
        System.out.println(u);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
