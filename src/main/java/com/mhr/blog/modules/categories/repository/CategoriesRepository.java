package com.mhr.blog.modules.categories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhr.blog.modules.categories.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
