package com.mhr.blog.modules.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mhr.blog.modules.users.entity.Users;
import com.mhr.blog.modules.users.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UserDetailsService,UsersService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Users saveOneUsers(Users users) {
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		 return this.usersRepository.save(users);
	}
	
	
	@Override
	public Users findOneUsers(long theId) {
		Optional<Users> result = this.usersRepository.findById(theId);
		Users theUsers = null;
		
		if(result.isPresent()) {
			theUsers = result.get();
		}else {
			throw new RuntimeException("Did Not found Users with bye id : " + theId);
		}
		
		return theUsers;
	}
	
	
	
	@Override
	public List<Users> findAllUsers(){
		return this.usersRepository.findAll();
	}
	
	
	@Override
	public void deleteOneUSers(long theId) {
		this.usersRepository.deleteById(theId);
	}
	
	@Override
	public void deleteAllUsers() {
		this.usersRepository.deleteAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usersRepository.findByEmail(username);
	}

	@Override
	public Users findByEmail(String email) {
		return usersRepository.findByEmail(email);
	}

	
}
