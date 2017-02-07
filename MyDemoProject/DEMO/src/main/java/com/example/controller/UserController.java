package com.example.controller;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Entity.User;
import com.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	@ResponseBody
	public Object index()
	{
		return userservice.findAll();
	}

	@RequestMapping(value="/create", method = RequestMethod.PUT )
	@ResponseBody
	public String create(@RequestBody User user)
	{
			String userId="";
			try
			{
				userservice.save(user);
				userId=String.valueOf(user.getId());
			}
			catch(Exception ex)
			{
				return "Error while creating the user"+ex.toString();
			}
			return "User succesfully creates with id"+ userId;
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable long id)
	{
		try
		{
			User user=	userservice.findById(id);
			userservice.delete(user);
		}
		catch(Exception ex)
		{
			return "Error while deleting the use" + ex.toString();
		}
		return "User successfuly deleted";
	}
	
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email)
	{
		String userId="";
		try
		{
			User user=userservice.findByemail(email);
			
			userId=String.valueOf(user.getId());
			
		}
		catch(Exception ex)
		{
			return "User not found";
		}
		return "The use Id is" + userId;
		
	}
	
	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateuser(@RequestBody User user,@PathVariable long id)
	{
		try
		{
			user.setId(id);
			userservice.save(user);
		}
		catch(Exception ex)
		{
			return "Error while updating the user" + ex.toString();
		}
		return "User successfully updated";
	}
	
}
