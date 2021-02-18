package com.mhr.blog.modules.comments.service;

import java.util.List;

import com.mhr.blog.modules.comments.entity.Comments;

public interface CommentsService {

	Comments saveOneComments(Comments comments);

	List<Comments> findAllCommnets();

	Comments findOneComments(long id);

	void deleteOneComments(long id);

	void deleteAllComments();

}
