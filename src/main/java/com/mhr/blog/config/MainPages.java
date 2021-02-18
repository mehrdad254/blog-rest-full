package com.mhr.blog.config;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPages {

	@GetMapping(value = "/error")
	public ResponseEntity<String> errorPages(){
		return new ResponseEntity<String>("Access Denied",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/admin")
	public ResponseEntity<String> adminPage(){
		return new ResponseEntity<String>("Wellcome admin.",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/user")
	public ResponseEntity<String> userPage(){
		return new ResponseEntity<String>("Wellcome user.",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "/info")
	public @ResponseBody Principal userInfo(Principal principal){
		return principal;
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<String> rootPage(){
		return new ResponseEntity<String>("Wellcome to home.",HttpStatus.BAD_REQUEST);
	}
}
