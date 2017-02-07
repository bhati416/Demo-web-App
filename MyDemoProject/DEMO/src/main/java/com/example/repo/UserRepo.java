package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
	public User findByEmail(String email);
}
