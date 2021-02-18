package com.mhr.blog.modules.files.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mhr.blog.modules.files.entity.FileStorage;
import com.mhr.blog.modules.files.response.FileUploadResponse;
import com.mhr.blog.modules.files.service.FileService;

@RestController
@RequestMapping(value = "/files")
public class FileController {

	@Autowired
	private FileService fileService;
	
	@PostMapping(value = "/add")
	public void save(@RequestParam("file") MultipartFile file) {

		  fileService.save(file);

		
	}
	
	@GetMapping(value = "/show/{fileId}")
	public ResponseEntity<Resource> getOneFile(@PathVariable("fileId") String fileId) {
		FileStorage fileStorage = this.fileService.getOneFile(fileId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(fileStorage.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= "+fileStorage.getFileName())
				.body(new ByteArrayResource(fileStorage.getFileData()));
	}
	
	
}
