package com.goodee.ex09.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.ex09.domain.NoticeDTO;
import com.goodee.ex09.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;
	
	@Override
	public List<NoticeDTO> findNotices() {
		return noticeRepository.selectNoticeList();
	}

	@Override
	public NoticeDTO findNoticeByNo(HttpServletRequest request) {

		String requestURI = request.getRequestURI();  // "/ex09/notice/detail"
		String[] arr = requestURI.split("/");         // { "", "ex09", "notice", "detail"}
		
		Long noticeNo = Long.parseLong(request.getParameter("noticeNo"));
		
		if(arr[arr.length - 1].equals("detail")) {            // 상세보기 요청이면,
			noticeRepository.updateHit(noticeNo);             // 조회수를 늘리고,
		}
		return noticeRepository.selectNoticeByNo(noticeNo);   // 정보를 조회한다.
		
	}

	@Override
	public int save(HttpServletRequest request) {
		NoticeDTO notice = new NoticeDTO();
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		return noticeRepository.insertNotice(notice);
	}

	@Override
	public int change(HttpServletRequest request) {
		NoticeDTO notice = new NoticeDTO();
		notice.setNoticeNo(Long.parseLong(request.getParameter("noticeNo")));
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		return noticeRepository.updateNotice(notice);
	}

	@Override
	public int remove(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return 0;
	}

}
