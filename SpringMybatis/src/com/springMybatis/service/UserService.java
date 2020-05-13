package com.springMybatis.service;



import java.util.List;

import com.springMybatis.po.User;
public interface UserService{
	public List<User> finduser(String name);
	public List<User> findAll();
	public void Deleteuser(int num);
	public void Updateuser(User u);
	public void Insertuser(User u);
	public List<User> findone(int num);
}
