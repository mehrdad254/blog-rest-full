package com.mhr.blog.modules.comments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhr.blog.modules.comments.entity.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {

}
