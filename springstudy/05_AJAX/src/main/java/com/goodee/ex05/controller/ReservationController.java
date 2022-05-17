package com.goodee.ex05.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goodee.ex05.domain.ReservationDTO;
import com.goodee.ex05.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	// produces는 ResponseEntity 내부에 포함된다. (application/json; charset=UTF-8)
	// @ResponseBody는 작성하지 않아도 된다.
	@GetMapping(value="/reservation/detail1")
	public ResponseEntity<ReservationDTO> detail1(HttpServletRequest request) {
		return reservationService.detail1(request);
	}
	
	@GetMapping(value="/reservation/detail2")
	public ResponseEntity<ReservationDTO> detail2(@RequestParam Long no) {
		return reservationService.detail2(no);
	}
	
	
	@GetMapping(value="/reservation/image")
	public ResponseEntity<byte[]> image(){
		File file = new File("D:", "eagle.jpg");  // new File("D:\\eagle.jpg")
		ResponseEntity<byte[]> result = null;
		try {
			// D:\\eagle.jpg 파일을 복사해서 byte[] 배열에 저장하고 해당 byte[] 배열을 반환
			byte[] b = FileCopyUtils.copyToByteArray(file);  // 이걸 반환하면 된다.
			// HttpHeaders : 반환할 데이터의 Content-Type
			// jpg 이미지의 Content-Type은 image/jpg 이다.
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "image/jpeg");  // image/jpg
			// 반환할 ResponseEntity
			result = new ResponseEntity<>(b, header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
}
