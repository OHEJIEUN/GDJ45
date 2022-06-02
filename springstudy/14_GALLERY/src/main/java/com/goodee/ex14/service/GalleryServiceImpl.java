package com.goodee.ex14.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goodee.ex14.domain.GalleryDTO;
import com.goodee.ex14.mapper.GalleryMapper;
import com.goodee.ex14.util.MyFileUtils;

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
		System.out.println(gallery);  // INSERT 수행 전에는 gallery에 galleryNo값이 없다.
		int galleryResult = galleryMapper.insertGallery(gallery);  // INSERT 수행
		System.out.println(gallery);  // INSERT 수행 후에는 selectKey에 의해서 gallery에 galleryNo값이 저장된다.

		// 결론. FILE_ATTACH 테이블에 INSERT할 galleryNo 정보는 gallery에 저장되어 있다.
		
		// 파일 첨부
		List<MultipartFile> files = multipartRequest.getFiles("files");  // 파라미터 files
		
		for (MultipartFile file : files) {
			
			// 예외 처리는 기본으로 필요함.
			try {
				
				// 첨부가 없을 수 있으므로 점검해야 함.
				if(file != null && file.isEmpty() == false) {  // 첨부가 있다.(둘 다 필요함)
					
					// 첨부파일의 본래 이름(origin)
					String origin = file.getOriginalFilename();
					origin = origin.substring(origin.lastIndexOf("\\") + 1);  // IE는 본래 이름에 전체 경로가 붙어서 파일명만 빼야 함.
					
					// 첨부파일의 저장된 이름(saved)
					String saved = MyFileUtils.getUuidName(origin);
					
					// 첨부파일의 저장 경로(디렉터리)
					String path = MyFileUtils.getTodayPath();
					
					// 저장 경로(디렉터리) 없으면 만들기
					File dir = new File(path);
					if(dir.exists() == false) {
						dir.mkdirs();
					}
					
					// 첨부파일
					File uploadFile = new File(dir, saved);
					
					System.out.println(origin);
					System.out.println(saved);
					System.out.println(path);
					
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
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
