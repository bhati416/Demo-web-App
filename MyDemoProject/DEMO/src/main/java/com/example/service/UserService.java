package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.User;
import com.example.repo.UserRepo;



@Service
public class UserService {
	
	@Autowired
	private UserRepo userrepo; 

	
	public Object findAll()
	{
		return userrepo.findAll();
	}
	public User findById(Long id)
	{
		return userrepo.findOne(id);
	}
	public User save(User user)
	{
		return userrepo.save(user);
	}
	public void delete(User user)
	{
		userrepo.delete(user);
		return;
	}
	public User findByemail(String email)
	{
		return null;
	}
}
