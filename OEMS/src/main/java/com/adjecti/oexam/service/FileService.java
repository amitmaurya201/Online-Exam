package com.adjecti.oexam.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.adjecti.oexam.entity.FileUpload;


public interface FileService {
	

	public String addFile(String title, MultipartFile file) throws IOException;
	
	
	public List<FileUpload> getFile();
	
	public FileUpload getFile(String id);
	

}
