package com.mhr.blog.modules.categories.service;

import java.util.List;

import com.mhr.blog.modules.categories.entity.Categories;

public interface CategoriesService {

	List<Categories> findAllCategories();

	Categories saveCategories(Categories categories);

	Categories findOneCategories(long id);

	void deleteOneCategories(long id);

	void deleteAllCategories();

}
