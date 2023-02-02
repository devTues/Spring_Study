package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;
import com.itwillbs.service.BoardService;

@Controller
public class BoardController {
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write() {
		return "board/writeForm"; // 폴더명/파일이름
	} // write 메서드
	
	@RequestMapping(value = "/board/writePro", method = RequestMethod.POST)
	public String writePro(BoardDTO dto) {
		System.out.println("BoardController writePro()");
		
		boardService.insertBoard(dto);
		return "redirect:/board/list"; // 폴더명/파일이름
	} // insertPro 메서드
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest requset) {
		System.out.println("BoardController list()");
		int pageSize=10;
		String pageNum=requset.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		int currentPage=Integer.parseInt(pageNum);
		
		PageDTO dto=new PageDTO();
		// set메서드 호출
		dto.setPageSize(pageSize);
		dto.setPageNum(pageNum);
		dto.setCurrentPage(currentPage);
		
		List<BoardDTO> boardList = boardService.getBoardList(dto);
		model.addAttribute("boardList", boardList);
		return "board/list"; // 폴더명/파일이름
	} // insertPro 메서드

}
