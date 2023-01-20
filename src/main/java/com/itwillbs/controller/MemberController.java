package com.itwillbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	// �����ּ� http://localhost:8080/myweb/insert
	// => /WEB-INF/views/������/�����̸�.jsp
	// => /WEB-INF/views/member/insertForm.jsp
	// => member/insertForm
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insertForm"; // ������/�����̸�
	} // insert �޼���
	
	// POST ���
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro() {
		System.out.println("Membercontroller insertPro()");
		// response.sendReditrct() �̵� -> �ּҺ��� �̵�
		return "redirect:/member/login"; // ������/�����̸�
	} // insertPro �޼���
	
	
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "member/loginForm";
	} // login �޼���
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro() {
		System.out.println("Membercontroller loginPro()");
		return "redirect:/member/main";
	} // loginPro �޼���
	
	
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		return "member/main";
	} // main �޼���
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info() {
		return "member/info";
	} // info �޼���
	
	
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		return "member/updateForm";
	} // update �޼���
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro() {
		return "member/updateForm";
	} // update �޼���
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		return "member/deleteForm";
	} // delete �޼���
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list() {
		return "member/list";
	} // delete �޼���
	
	
	
	
} // MemberController Ŭ����
