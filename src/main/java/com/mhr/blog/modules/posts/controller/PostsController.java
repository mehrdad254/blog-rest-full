package com.mhr.blog.modules.posts.controller;

import java.security.Principal;
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

import com.mhr.blog.modules.posts.entity.Posts;
import com.mhr.blog.modules.posts.service.PostsService;
import com.mhr.blog.modules.users.service.UsersService;

@RestController
@CrossOrigin
@RequestMapping(value = "/posts")
public class PostsController {

	@Autowired
	private PostsService postsService;
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> testApiPost(){
		return new ResponseEntity<String>("Post api is ok!",HttpStatus.OK);
	}
	
	@Autowired
	private UsersService userService;
	
	@PostMapping(value = "/add", consumes={"application/json"})
	@PreAuthorize("hasAuthority('OP_NEW_POST')")
	public ResponseEntity<Posts> saveOnePosts(@RequestBody Posts posts,Principal principal){
		posts.setUsers(userService.findByEmail(principal.getName()));
		return new ResponseEntity<Posts>(this.postsService.saveOnePosts(posts),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/shows")
	@PreAuthorize("hasAuthority('OP_SHOW_ALL_POST')")
	public ResponseEntity<List<Posts>> findAllPosts(){
		return new ResponseEntity<List<Posts>>(this.postsService.findAllPosts(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/show/{idPosts}")
	@PreAuthorize("hasAuthority('OP_SHOW_ONE_POST')")
	public ResponseEntity<Posts> findOnePosts(@PathVariable("idPosts") long idPosts){
		return new ResponseEntity<Posts>(this.postsService.findOnePosts(idPosts),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{idPosts}")
	@PreAuthorize("hasAuthority('OP_DELETE_POST')")
	public ResponseEntity<Void> deleteOnePosts(@PathVariable("idPosts") long idPosts){
		this.postsService.deleteOnePosts(idPosts);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletes")
	@PreAuthorize("hasAuthority('OP_DELETE_ALL_POST')")
	public ResponseEntity<Void> deleteAllPosts(){
		this.postsService.deleteAllPosts();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	@PreAuthorize("hasAuthority('OP_EDIT_POST')")
	public ResponseEntity<Posts> updateOnePosts(@RequestBody Posts posts){
		return new ResponseEntity<Posts>(this.postsService.saveOnePosts(posts),HttpStatus.OK);
	}
}
