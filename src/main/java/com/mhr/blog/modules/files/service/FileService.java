package com.mhr.blog.modules.files.service;

import org.springframework.web.multipart.MultipartFile;

import com.mhr.blog.modules.files.entity.FileStorage;

public interface FileService {

	FileStorage getOneFile(String fileId);

	void save(MultipartFile multipartFile);

}
