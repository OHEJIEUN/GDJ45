package com.goodee.ex05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.goodee.ex05.domain.ReservationDTO;
import com.goodee.ex05.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping(value="/reservation/detail1")
	public ResponseEntity<ReservationDTO> detail1(HttpServletRequest request) {
		return reservationService.detail1(request);
	}
	
}
