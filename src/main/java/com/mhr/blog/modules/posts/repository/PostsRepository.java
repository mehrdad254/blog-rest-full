package com.mhr.blog.modules.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhr.blog.modules.posts.entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long>{

}
