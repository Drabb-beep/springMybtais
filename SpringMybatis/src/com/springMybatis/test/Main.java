package com.springMybatis.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.springMybatis.po.User;
import com.springMybatis.service.UserService;

public class Main {
	public static void main(String[] args) throws SQLException {
		ApplicationContext acp = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService user= acp.getBean(UserService.class);
		List<User> u=user.findAll();
		for(int i=0;i<u.size();i++) {
			System.out.println(u.get(i));
		}
	}
}
