package com.goodee.ex16.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goodee.ex16.service.GalleryService;

@Controller
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@GetMapping("/gallery/management")
	public String management() {
		return "gallery/manage";
	}
	
	@ResponseBody
	@PostMapping(value="/galleries", produces="application/json")
	public Map<String, Object> addGallery(MultipartHttpServletRequest multipartRequest){
		return galleryService.save(multipartRequest);
	}
	
}
