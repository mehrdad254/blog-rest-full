package com.mhr.blog.modules.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhr.blog.modules.users.entity.Users;
import com.mhr.blog.modules.users.service.UsersService;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> testApiUser(){
		return new ResponseEntity<String>("User api is ok!",HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	@PreAuthorize("hasAuthority('OP_NEW_USER')")
	public ResponseEntity<Users> save(@RequestBody Users users){
		users.setId((long) 0);
		return new ResponseEntity<Users>(this.usersService.saveOneUsers(users) , HttpStatus.CREATED );
	}
	
	@GetMapping(value = "/shows")
	@PreAuthorize("hasAuthority('OP_SHOW_ALL_USER')")
	public ResponseEntity<List<Users>> findAllUsers(){
		return new ResponseEntity<List<Users>>(this.usersService.findAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping(value =  "/show/{userId}")
	@PreAuthorize("hasAuthority('OP_SHOW_ONE_USER')")
	public ResponseEntity<Users> findOneUsers(@PathVariable("userId") long userId){
		return new ResponseEntity<Users>(this.usersService.findOneUsers(userId),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{userID}")
	@PreAuthorize("hasAuthority('OP_DELETE_USER')")
	public ResponseEntity<?> deleteOneUsers(@PathVariable("userID") long userId){
		this.usersService.deleteOneUSers(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletes")
	@PreAuthorize("hasAuthority('OP_DELETE_ALL_USER')")
	public ResponseEntity<?> deleteAllUsers(){
		this.usersService.deleteAllUsers();
		return new ResponseEntity<Users>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	@PreAuthorize("hasAuthority('OP_EDIT_USER')")
	public ResponseEntity<Users> updateOneUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(this.usersService.saveOneUsers(users),HttpStatus.OK);
	}
}
