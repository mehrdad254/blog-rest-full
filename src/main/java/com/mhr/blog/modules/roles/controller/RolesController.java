package com.mhr.blog.modules.roles.controller;

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

import com.mhr.blog.modules.roles.entity.Roles;
import com.mhr.blog.modules.roles.service.RolesService;

@RestController
@CrossOrigin
@RequestMapping(value = "/roles")
public class RolesController {

	@Autowired
	private RolesService rolesService;
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> testApiRole(){
		return new ResponseEntity<String>("Roles api is ok!",HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	@PreAuthorize("hasAuthority('OP_NEW_ROLE')")
	public ResponseEntity<Roles> Save(@RequestBody Roles roles){
		return new ResponseEntity<Roles>(this.rolesService.Save(roles),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/shows")
	@PreAuthorize("hasAuthority('OP_SHOW_ALL_ROLE')")
	public ResponseEntity<List<Roles>> findAll(){
		return new ResponseEntity<List<Roles>>(this.rolesService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/show/{rolesId}")
	@PreAuthorize("hasAuthority('OP_SHOW_ONE_ROLE')")
	public ResponseEntity<Roles> findById(@PathVariable("rolesId") long rolesId){
		return new ResponseEntity<Roles>(this.rolesService.findById(rolesId),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{rolesId}")
	@PreAuthorize("hasAuthority('OP_DELETE_ROLE')")
	public ResponseEntity<?> deleteById(@PathVariable("rolesId") long rolesId){
		this.rolesService.deleteOne(rolesId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletes")
	@PreAuthorize("hasAuthority('OP_DELETE_ALL_ROLE')")
	public ResponseEntity<?> deleteAll(){
		this.rolesService.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	@PreAuthorize("hasAuthority('OP_EDIT_ROLE')")
	public ResponseEntity<Roles> updateOneRoles(@RequestBody Roles roles){
		return new ResponseEntity<Roles>(this.rolesService.Save(roles),HttpStatus.OK);
	}
}
