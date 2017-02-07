package com.example.Entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;

	public User(long id) {
		//super();
		this.id = id;
	}
	@Column(name="name")
	private String name;
	@Column(name="email" , nullable=false , unique =true)
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="mobile")
	private String phoneNo;
	
	
	private transient String confirmpassword;

	public User(long id, String name, String email, String password, String phoneNo) {
		//super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}
	public User()
	{}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	

}
