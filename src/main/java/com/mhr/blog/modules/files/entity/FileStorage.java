package com.mhr.blog.modules.files.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "file_storage")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class FileStorage {

	@Id
	@GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	@Column(name = "id")
	private String fileId;
	
	@Column(name = "name")
	private String fileName;
	
	@Column(name = "file")
	@Lob
	private byte[] fileData;
	
	@Column(name = "type")
	private String fileType;
	
	@Column(name = "size")
	private long fileSize;
	
	@Column(name = "url")
	private String downloadUrl;
	
	@CreationTimestamp
	@Column(name = "create_at",updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createAt;
	
	@UpdateTimestamp()
	@Column(name = "update_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateAt;

	public FileStorage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileStorage(String fileId, String fileName, byte[] fileData, String fileType, long fileSize,
			String downloadUrl, LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileData = fileData;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.downloadUrl = downloadUrl;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}



	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
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

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	

}
