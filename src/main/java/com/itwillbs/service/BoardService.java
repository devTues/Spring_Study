package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

public interface BoardService {

	public void insertBoard(BoardDTO dto);
	public List<BoardDTO> getBoardList(PageDTO dto);
}
