package com.itwillbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	// 가상주소 http://localhost:8080/myweb/insert
	// => /WEB-INF/views/폴더명/파일이름.jsp
	// => /WEB-INF/views/member/insertForm.jsp
	// => member/insertForm
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insertForm"; // 폴더명/파일이름
	} // insert 메서드
	
	// POST 방식
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro() {
		System.out.println("Membercontroller insertPro()");
		// response.sendReditrct() 이동 -> 주소변경 이동
		return "redirect:/member/login"; // 폴더명/파일이름
	} // insertPro 메서드
	
	
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "member/loginForm";
	} // login 메서드
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("Membercontroller loginPro()");
		return "redirect:/member/main";
	} // loginPro 메서드
	
	
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		return "member/main";
	} // main 메서드
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info() {
		return "member/info";
	} // info 메서드
	
	
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		return "member/updateForm";
	} // update 메서드
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro() {
		return "member/updateForm";
	} // update 메서드
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		return "member/deleteForm";
	} // delete 메서드
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list() {
		return "member/list";
	} // delete 메서드
	
	
	
	
} // MemberController 클래스
