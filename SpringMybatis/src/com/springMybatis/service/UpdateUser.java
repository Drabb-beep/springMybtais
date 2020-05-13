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
//�޸��û���Ϣ����ʹ��get��ʽ����num��ѯ�޸ĵ��û���Ȼ���޸��û���Ϣͨ��post��ʽ�ύ��
public class UpdateUser extends HttpServlet{
	int num=0;
	String id="";
	@Override
//	��ѯ�û���Ϣ
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		num=Integer.valueOf(req.getParameter("num"));
		resp.setContentType("text/html;charset=UTF-8");
		ApplicationContext acp = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService user= acp.getBean(UserService.class);
//		��ѯ�û�
		List<User> u=user.findone(num);
//		�����û���Ϣ
		id=u.get(0).getId();
		req.setAttribute("num", u.get(0).getNum());
		req.setAttribute("id", id);
		req.setAttribute("name", u.get(0).getName());
		req.setAttribute("password", u.get(0).getPassword());
//		ת����������ֵ����
		req.getRequestDispatcher("update.jsp").forward(req,resp);
		

	}
	@Override
//	�޸��û���Ϣ
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
//		�����û���Ϣ
		user.Updateuser(u);
		resp.sendRedirect("index.jsp");
	}
}
