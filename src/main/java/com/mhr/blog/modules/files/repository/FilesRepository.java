package com.mhr.blog.modules.files.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhr.blog.modules.files.entity.FileStorage;

@Repository
public interface FilesRepository extends JpaRepository<FileStorage,String>{

}
