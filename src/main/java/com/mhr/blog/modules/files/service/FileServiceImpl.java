package com.mhr.blog.modules.files.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mhr.blog.modules.files.entity.FileStorage;
import com.mhr.blog.modules.files.repository.FilesRepository;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FilesRepository filesRepository;

	@Override
	public void save(MultipartFile multipartFile) {
		
		FileStorage fileStorage = new FileStorage();
		

		try {
			
			fileStorage.setFileName(multipartFile.getOriginalFilename());
			fileStorage.setFileType(multipartFile.getContentType());
			fileStorage.setFileSize(multipartFile.getSize());
			fileStorage.setFileData(multipartFile.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	   this.filesRepository.save(fileStorage);
	}
	
	
	@Override
	public FileStorage getOneFile(String fileId) {
		FileStorage fileStorage = this.filesRepository.getOne(fileId);
		return fileStorage;
	}
}
