package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
//	부모 = 자식 객체생성
//	중복되는것은 제일 위에 객체생성 선언하기
//	MemberService memberService=new MemberServiceImpl();
//	멤버변수
	private MemberService memberService;
	
//	방법1: 생성자를 통해서 전달 => root-context.xml
//	public MemberController(전달받을 변수) {
//	}
	@Inject
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Inject
//	방법2: set메서드 전달 => root-context.xml
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	
	
//	가상주소 http://localhost:8080/myweb/member/insert
//	=> /WEB-INF/views/폴더명/파일이름.jsp
//	=> /WEB-INF/views/member/insertForm.jsp
//	=> member/insertForm
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insertForm"; // 폴더명/파일이름
	} // insert 메서드
	

	// POST 방식
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
//	public String insertPro(HttpServletRequest request) { 
//		수동 방식(HttpServletRequest request) -> 자동 방식(MemberDTO dto)
//		MemberDTO dto=new MemberDTO();
//		dto.setId(request.getParameter("id"));
//		dto.setPass(request.getParameter("pass"));
//		dto.setName(request.getParameter("name"));
	public String insertPro(MemberDTO dto) {
		System.out.println("Membercontroller insertPro()");
//		=> 자동으로 되는 조건 : insertForm.jsp 태그이름, MemberDTO 멤버변수 이름이 동일
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
//		이전방식: MemberFrontController => MemberInsertPro => MemberDAO
//		새로운방식: MemberController => MemberService(Pro에 대한 메서드 내용 모으기) => MemberDAO
//		MemberService 부모=자식 객체생성
//		MemberService memberService=new MemberServiceImpl(); // 중복됨
		memberService.insertMember(dto);
		
		// response.sendReditrct() 이동 -> 주소변경 이동
		return "redirect:/member/login"; // 폴더명/파일이름
	} // insertPro 메서드
	
	
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "member/loginForm";
	} // login 메서드
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO dto) {
		System.out.println("Membercontroller loginPro()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
//		MemberService 부모=자식 객체생성
//		MemberService memberService=new MemberServiceImpl(); // 중복됨
		memberService.userCheck(dto);
		
		return "redirect:/member/main";
	} // loginPro 메서드
	
	
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		return "member/main";
	} // main 메서드
	
	// 가상주소 http://localhost:8080/myweb/member/logout
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/member/login";
	} // main 메서드
	
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(MemberDTO dto) {
		System.out.println("Membercontroller info()");
//		MemberService memberService=new MemberServiceImpl(); // 중복됨
		System.out.println(dto.getId());
		memberService.info(dto);
		return "member/info";
	} // info 메서드
	
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		return "member/updateForm";
	} // update 메서드
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro() {
		
		return "redirect:/member/main";
	} // updatePro 메서드
	
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		return "member/deleteForm";
	} // delete 메서드
	
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro() {
		return "redirect:/member/login";
		
	} // deletePro 메서드
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list() {
		return "member/list";
	} // delete 메서드
	
	
	
	
} // MemberController 클래스
