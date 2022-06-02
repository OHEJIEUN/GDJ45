package com.goodee.ex14.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goodee.ex14.domain.GalleryDTO;

public interface GalleryService {
	public void findGalleries(HttpServletRequest request, Model model);
	public ResponseEntity<byte[]> display(Long fileAttachNo, String type);
	public GalleryDTO findGalleryByNo(Long galleryNo);
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public void change(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public void remove(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
}
