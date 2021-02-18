package com.mhr.blog.modules.users.service;

import java.util.List;

import com.mhr.blog.modules.users.entity.Users;

public interface UsersService {

	List<Users> findAllUsers();

	Users findOneUsers(long theId);

	void deleteOneUSers(long theId);

	void deleteAllUsers();

	Users saveOneUsers(Users users);

	Users findByEmail(String email);

}
