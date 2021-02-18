package com.mhr.blog.modules.posts.service;

import java.util.List;

import com.mhr.blog.modules.posts.entity.Posts;

public interface PostsService {

	Posts saveOnePosts(Posts posts);

	List<Posts> findAllPosts();

	Posts findOnePosts(long idPosts);

	void deleteOnePosts(long idPosts);

	void deleteAllPosts();

}
