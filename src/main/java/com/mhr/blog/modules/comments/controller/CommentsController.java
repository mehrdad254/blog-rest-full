package com.mhr.blog.modules.comments.controller;

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

import com.mhr.blog.modules.comments.entity.Comments;
import com.mhr.blog.modules.comments.service.CommentsService;

@RestController
@CrossOrigin
@RequestMapping(value = "/comments")
public class CommentsController {

	@Autowired
	private CommentsService commentsService;
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> testApiComments(){
		return new ResponseEntity<String>("Comments api is ok!",HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	@PreAuthorize("hasAuthority('OP_NEW_COMMENT')")
	public ResponseEntity<Comments> saveOneComments(@RequestBody Comments comments){
		return new ResponseEntity<Comments>(this.commentsService.saveOneComments(comments),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/shows")
	@PreAuthorize("hasAuthority('OP_SHOW_ALL_COMMENT')")
	public ResponseEntity<List<Comments>> findAllComments(){
		return new ResponseEntity<List<Comments>>(this.commentsService.findAllCommnets(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/show/{idComments}")
	@PreAuthorize("hasAuthority('OP_SHOW_ONE_COMMENT')")
	public ResponseEntity<Comments> findOneComments(@PathVariable("idComments") long idComments){
		return new ResponseEntity<Comments>(this.commentsService.findOneComments(idComments),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{idComments}")
	@PreAuthorize("hasAuthority('OP_DELETE_ONE_COMMENT')")
	public ResponseEntity<Void> deleteOneComments(@PathVariable("idComments") long idComments){
		this.commentsService.deleteOneComments(idComments);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletes")
	@PreAuthorize("hasAuthority('OP_DELETE_ALL_COMMENT')")
	public ResponseEntity<Void> deleteAllComments(){
		this.commentsService.deleteAllComments();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	@PreAuthorize("hasAuthority('OP_EDIT_COMMENT')")
	public ResponseEntity<Comments> updateOneComments(@RequestBody Comments comments){
		return new ResponseEntity<Comments>(this.commentsService.saveOneComments(comments),HttpStatus.OK);
	}
	
}
