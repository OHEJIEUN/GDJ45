package com.goodee.ex12.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.ex12.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public Map<String, Object> findReplies(Long boardNo) {
		Map<String, Object> map = new HashMap<>();
		map.put("replyCount", replyMapper.selectReplyCount(boardNo));
		map.put("replies", replyMapper.selectReplyList(boardNo));
		return map;
	}
	
}
