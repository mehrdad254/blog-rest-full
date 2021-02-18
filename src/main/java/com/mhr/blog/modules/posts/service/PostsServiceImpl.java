package com.mhr.blog.modules.posts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhr.blog.modules.posts.entity.Posts;
import com.mhr.blog.modules.posts.repository.PostsRepository;

@Service
public class PostsServiceImpl implements PostsService {

	@Autowired
	private PostsRepository postsRepository;

	@Override
	public Posts saveOnePosts(Posts posts) {
		return this.postsRepository.save(posts);
	}
	
	@Override
	public List<Posts> findAllPosts(){
		return this.postsRepository.findAll();
	}
	
	@Override
	public Posts findOnePosts(long idPosts) {
		return this.postsRepository.findById(idPosts).orElse(null);
	}

	@Override
	public void deleteOnePosts(long idPosts) {
	    this.postsRepository.deleteById(idPosts);
	}

	@Override
	public void deleteAllPosts() {
		this.postsRepository.deleteAll();
	}
}
