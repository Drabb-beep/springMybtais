package com.springMybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMybatis.dao.UserDao;
import com.springMybatis.po.User;
@Service
public class UserServiceImpe implements UserService {
	@Autowired
	private UserDao user;
	@Override
//	²é
	public List<User> finduser(String name) {
		return user.finduser(name);
		}
	@Override
	public List<User> findAll() {
		return user.findAll();

	}
	@Override
	public List<User> findone(int num) {
		// TODO Auto-generated method stub
		return user.findone(num);
	}
	@Override
//	É¾
	public void Deleteuser(int num) {
		// TODO Auto-generated method stub
			user.Deleteuser(num);
	}
	@Override
//	¸Ä
	public void Updateuser(User u) {
		// TODO Auto-generated method stub
		user.Updateuser(u);
	}
	@Override
//	Ìí
	public void Insertuser(User u) {
		// TODO Auto-generated method stub
		user.Insertuser(u);
	}		
}
