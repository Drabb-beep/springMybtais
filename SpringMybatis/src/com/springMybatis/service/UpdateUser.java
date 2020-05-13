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
@WebServlet(urlPatterns = "/update")
//修改用户信息（先使用get方式根据num查询修改的用户，然后修改用户信息通过post方式提交）
public class UpdateUser extends HttpServlet{
	int num=0;
	String id="";
	@Override
//	查询用户信息
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		num=Integer.valueOf(req.getParameter("num"));
		resp.setContentType("text/html;charset=UTF-8");
		ApplicationContext acp = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService user= acp.getBean(UserService.class);
//		查询用户
		List<User> u=user.findone(num);
//		传递用户信息
		id=u.get(0).getId();
		req.setAttribute("num", u.get(0).getNum());
		req.setAttribute("id", id);
		req.setAttribute("name", u.get(0).getName());
		req.setAttribute("password", u.get(0).getPassword());
//		转发，并进行值传递
		req.getRequestDispatcher("update.jsp").forward(req,resp);
		

	}
	@Override
//	修改用户信息
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		User u=new User();
		u.setNum(num);
		u.setId(id);
		u.setName(name);
		u.setPassword(password);
//		System.out.println(u);
		resp.setContentType("text/html;charset=UTF-8");
		ApplicationContext acp = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService user= acp.getBean(UserService.class);
//		更新用户信息
		user.Updateuser(u);
		resp.sendRedirect("index.jsp");
	}
}
