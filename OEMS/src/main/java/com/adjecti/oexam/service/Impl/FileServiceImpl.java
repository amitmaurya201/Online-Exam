package com.adjecti.oexam.service.Impl;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adjecti.oexam.entity.FileUpload;
import com.adjecti.oexam.repository.FileRepository;
import com.adjecti.oexam.service.FileService;

@Service
public class FileServiceImpl  implements FileService{

	@Autowired
	private FileRepository fileRepository;
	
	
	public String addFile(String title, MultipartFile file) throws IOException {
		//System.out.println(file);
		FileUpload file1 = new FileUpload(title);
		file1.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
		file1 = fileRepository.insert(file1);
		return file1.getId();
	}


	@Override
	public List<FileUpload> getFile() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public FileUpload getFile(String id) {
		// TODO Auto-generated method stub
		return this.fileRepository.findById(id).get();
	}
	
	
	
}
