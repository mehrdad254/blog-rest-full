package com.mhr.blog.modules.comments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhr.blog.modules.comments.entity.Comments;
import com.mhr.blog.modules.comments.repository.CommentsRepository;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	private CommentsRepository commentsRepository;
	
	@Override
	public Comments saveOneComments(Comments comments) {
		return this.commentsRepository.save(comments);
	}
	
	@Override
	public List<Comments> findAllCommnets(){
		return this.commentsRepository.findAll();
	}
	
	@Override
	public Comments findOneComments(long id) {
		return this.commentsRepository.findById(id).orElse(null);
	}
	
	@Override
	public void deleteOneComments(long id) {
	    this.commentsRepository.deleteById(id);
	}
	
	@Override
	public void deleteAllComments() {
		this.commentsRepository.deleteAll();
	}
}
