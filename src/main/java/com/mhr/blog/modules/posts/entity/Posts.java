package com.mhr.blog.modules.posts.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mhr.blog.modules.categories.entity.Categories;
import com.mhr.blog.modules.comments.entity.Comments;
import com.mhr.blog.modules.users.entity.Users;

@Entity
@Table(name = "posts")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "body",columnDefinition = "text")
	private String body;
	
	@CreationTimestamp
	@Column(name = "create_at",updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createAt;
	
	@UpdateTimestamp()
	@Column(name = "update_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateAt;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users users;
	
	@ManyToMany
	private List<Categories> categories;
	
	@OneToMany
	private List<Comments> comments;

	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Posts(Long id, String title, String body, LocalDateTime createAt, LocalDateTime updateAt, Users users,
			List<Categories> categories, List<Comments> comments) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.users = users;
		this.categories = categories;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	public List<Categories> getCategories() {
		return categories;
	}


	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}


	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", title=" + title + ", body=" + body + ", createAt=" + createAt + ", updateAt="
				+ updateAt + ", users=" + users + ", categories=" + categories + ", comments=" + comments + "]";
	}
	
}

