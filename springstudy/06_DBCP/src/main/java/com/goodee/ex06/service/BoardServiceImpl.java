package com.goodee.ex06.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goodee.ex06.domain.BoardDTO;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<BoardDTO> findBoards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO findBoardByNo(Long board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(BoardDTO board, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Long board_no, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
