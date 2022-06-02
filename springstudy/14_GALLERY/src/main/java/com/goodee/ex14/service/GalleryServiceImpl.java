package com.goodee.ex14.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goodee.ex14.domain.GalleryDTO;
import com.goodee.ex14.mapper.GalleryMapper;

@Service
public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private GalleryMapper galleryMapper;
	
	@Override
	public List<GalleryDTO> findGalleries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GalleryDTO findGalleryByNo(Long galleryNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		
		// 전달된 파라미터
		String writer = multipartRequest.getParameter("writer");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		// IP
		Optional<String> opt = Optional.ofNullable(multipartRequest.getHeader("X-Forwarded-For"));
		String ip = opt.orElse(multipartRequest.getRemoteAddr());
		
		// GalleryDTO
		GalleryDTO gallery = GalleryDTO.builder()
				.writer(writer)
				.title(title)
				.content(content)
				.ip(ip)
				.build();
		
		// Gallery Insert 수행
		int galleryResult = galleryMapper.insertGallery(gallery);
		
		// FileAttachDTO에 galleryNo를 저장해서 GalleryMapper에 전달해야 한다.
		// 방금 추가된 galleryNo를 누가 알고 있는가?
		System.out.println(gallery);

	}

	@Override
	public void change(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
