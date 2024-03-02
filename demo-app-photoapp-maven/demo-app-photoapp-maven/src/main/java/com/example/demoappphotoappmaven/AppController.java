package com.example.demoappphotoappmaven;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AppController {

	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private ProfileService profileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public String saveUser(@ModelAttribute Profile profile,@RequestParam("image") MultipartFile photofile) {
		String fileName = null;
		try {
			fileName = this.profileService.uploadImage(profile,path, photofile);
		} catch (IOException e) {
			e.printStackTrace();
			return "unsuccessful";
		}
		
		return "successful";
	}
}
