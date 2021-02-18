package com.mhr.blog.modules.categories.controller;

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

import com.mhr.blog.modules.categories.entity.Categories;
import com.mhr.blog.modules.categories.service.CategoriesService;

@RestController
@CrossOrigin
@RequestMapping(value = "/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> testApiCategories(){
		return new ResponseEntity<String>("Categories api is ok!",HttpStatus.OK);
	}
	
	@PostMapping(value = "/add")
	@PreAuthorize("hasAuthority('OP_NEW_CATEGORIES')")
	public ResponseEntity<?> saveCategories(@RequestBody Categories categories){
		return new ResponseEntity<Categories>(this.categoriesService.saveCategories(categories),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/shows")
	@PreAuthorize("hasAuthority('OP_SHOW_ALL_CATEGORIES')")
	public ResponseEntity<List<Categories>> findAllCategories(){
		return new ResponseEntity<List<Categories>>(this.categoriesService.findAllCategories(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/show/{idCategories}")
	@PreAuthorize("hasAuthority('OP_SHOW_ONE_CATEGORIES')")
	public ResponseEntity<Categories> findOneCategories(@PathVariable("idCategories") long idCategories){
		return new ResponseEntity<Categories>(this.categoriesService.findOneCategories(idCategories),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{idCategories}")
	@PreAuthorize("hasAuthority('OP_DELETE_CATEGORIES')")
	public ResponseEntity<Void> deleteOneCategories(@PathVariable("idCategories") long idCategories){
		this.categoriesService.deleteOneCategories(idCategories);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletes")
	@PreAuthorize("hasAuthority('OP_DELETE_ALL_CATEGORIES')")
	public ResponseEntity<Void> deleteAllCategories(){
		this.categoriesService.deleteAllCategories();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	@PreAuthorize("hasAuthority('OP_EDIT_CATEGORIES')")
	public ResponseEntity<Categories> updateOneCategories(@RequestBody Categories categories){
		return new ResponseEntity<Categories>(this.categoriesService.saveCategories(categories),HttpStatus.OK);
	}
}
