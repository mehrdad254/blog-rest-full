package com.mhr.blog.modules.categories.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhr.blog.modules.categories.entity.Categories;
import com.mhr.blog.modules.categories.repository.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService{

	@Autowired
	private CategoriesRepository categoriesRepository;
	
	@Override
	public Categories saveCategories(Categories categories) {
		return this.categoriesRepository.save(categories);
	}
	
	@Override
	public List<Categories> findAllCategories(){
		return this.categoriesRepository.findAll();
	}
	
	@Override
	public Categories findOneCategories(long id) {
		return this.categoriesRepository.findById(id).orElse(null);
	}
	
	@Override
	public void deleteOneCategories(long id) {
		this.categoriesRepository.deleteById(id);
	}

	@Override
	public void deleteAllCategories() {
		this.categoriesRepository.deleteAll();
	}
	
}
