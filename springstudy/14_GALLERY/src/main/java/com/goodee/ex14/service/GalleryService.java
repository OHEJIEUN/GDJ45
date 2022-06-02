package com.goodee.ex14.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goodee.ex14.domain.GalleryDTO;

public interface GalleryService {
	public List<GalleryDTO> findGalleries();
	public GalleryDTO findGalleryByNo(Long galleryNo);
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public void change(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
	public void remove(MultipartHttpServletRequest multipartRequest, HttpServletResponse response);
}
