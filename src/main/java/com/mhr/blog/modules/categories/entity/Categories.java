package com.mhr.blog.modules.categories.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mhr.blog.modules.posts.entity.Posts;

@Entity
@Table(name = "categories")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;

	@ManyToMany(mappedBy = "categories")
	private List<Posts> posts;
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categories(Long id, String title, List<Posts> posts) {
		super();
		this.id = id;
		this.title = title;
		this.posts = posts;
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


	public List<Posts> getPosts() {
		return posts;
	}


	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}


	@Override
	public String toString() {
		return "Categories [id=" + id + ", title=" + title + ", posts=" + posts + "]";
	}	

}
