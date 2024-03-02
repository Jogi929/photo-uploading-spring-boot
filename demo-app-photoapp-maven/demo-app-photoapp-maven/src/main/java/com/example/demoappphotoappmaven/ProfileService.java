package com.example.demoappphotoappmaven;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {

	String uploadImage(Profile profile,String path, MultipartFile file) throws IOException;
	
}
