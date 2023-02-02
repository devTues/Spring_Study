package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

public interface BoardDAO {
	
	public void insertBoard(BoardDTO dto);
	// �۹�ȣ
	public Integer getMaxNum();
	public List<BoardDTO> getBoardList(PageDTO dto);

}
