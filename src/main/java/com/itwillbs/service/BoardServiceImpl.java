package com.itwillbs.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.BoardDAO;
import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardDTO dto) {
		// num, readcount, date �� ���� ����
		// num = max(num) + 1
		if(boardDAO.getMaxNum()==null) {
			// ���� ���� ���
			dto.setNum(1);
		} else {
			dto.setNum(boardDAO.getMaxNum()+1);
		}
		dto.setReadcount(0);
		dto.setDate(new Timestamp(System.currentTimeMillis()));
		
		
		boardDAO.insertBoard(dto);
	}

	@Override
	public List<BoardDTO> getBoardList(PageDTO dto) {
		int startRow=(dto.getCurrentPage()-1)*dto.getPageSize()+1;
		int endRow=startRow+dto.getPageSize()-1;
		 
		 // startRow-1
		 dto.setStartRow(startRow-1);
		 dto.setEndRow(endRow);
		
		return boardDAO.getBoardList(dto);
	}

}
