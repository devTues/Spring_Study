package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
//	�θ� = �ڽ� ��ü����
//	�ߺ��Ǵ°��� ���� ���� ��ü���� �����ϱ�
//	MemberService memberService=new MemberServiceImpl();
//	�������
	@Inject
	private MemberService memberService;
	
//	���1: �����ڸ� ���ؼ� ���� => root-context.xml
//	public MemberController(���޹��� ����) {
//	}
//	@Inject
//	public MemberController(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
//	@Inject
//	���2: set�޼��� ���� => root-context.xml
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
	
	
	
	
//	�����ּ� http://localhost:8080/myweb/member/insert
//	=> /WEB-INF/views/������/�����̸�.jsp
//	=> /WEB-INF/views/member/insertForm.jsp
//	=> member/insertForm
	
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insertForm"; // ������/�����̸�
	} // insert �޼���
	

	// POST ���
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
//	public String insertPro(HttpServletRequest request) { 
//		���� ���(HttpServletRequest request) -> �ڵ� ���(MemberDTO dto)
//		MemberDTO dto=new MemberDTO();
//		dto.setId(request.getParameter("id"));
//		dto.setPass(request.getParameter("pass"));
//		dto.setName(request.getParameter("name"));
	public String insertPro(MemberDTO dto) {
		System.out.println("Membercontroller insertPro()");
//		=> �ڵ����� �Ǵ� ���� : insertForm.jsp �±��̸�, MemberDTO ������� �̸��� ����
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
//		�������: MemberFrontController => MemberInsertPro => MemberDAO
//		���ο���: MemberController => MemberService(Pro�� ���� �޼��� ���� ������) => MemberDAO
//		MemberService �θ�=�ڽ� ��ü����
//		MemberService memberService=new MemberServiceImpl(); // �ߺ���
		memberService.insertMember(dto);
		
		// response.sendReditrct() �̵� -> �ּҺ��� �̵�
		return "redirect:/member/login"; // ������/�����̸�
	} // insertPro �޼���
	
	
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		return "member/loginForm";
	} // login �޼���
	
	@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)
	public String loginPro(MemberDTO dto, HttpSession session) {
		System.out.println("Membercontroller loginPro()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
//		MemberService �θ�=�ڽ� ��ü����
//		MemberService memberService=new MemberServiceImpl(); // �ߺ���
		
		MemberDTO memberDTO=memberService.userCheck(dto);
//		���̵� ��ġ => memberDTO �ּ� ��Ƽ� �� => ���ǰ� ����, main �̵�
//		���̵� ����ġ => memberDTO null �Ѿ�� => ����Ʋ�� �ڷ��̵�
		if(memberDTO!=null) {
//			���̵� ��ġ => memberDTO �ּ� ��Ƽ� �� => ���ǰ� ����, main �̵�
			session.setAttribute("id", dto.getId());
			return "redirect:/member/main";
		} else {
//			���̵� ����ġ => memberDTO null �Ѿ�� => ����Ʋ�� �ڷ��̵�
//			member/msg.jsp �̵�
			return "member/msg";
		}
		
	} // loginPro �޼���
	
	
	
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		return "member/main";
	} // main �޼���
	
	// �����ּ� http://localhost:8080/myweb/member/logout
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("Membercontroller logout()");
		session.invalidate();
		return "redirect:/member/login";
	} // logout �޼���
	
	
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info(HttpSession session, Model model) {
		System.out.println("Membercontroller info()");
//		MemberService memberService=new MemberServiceImpl(); // �ߺ���
		String id=(String)session.getAttribute("id");
		MemberDTO dto=memberService.getMember(id);
		
//		dto Model model(request) ���
		model.addAttribute("dto", dto);
		
		return "member/info";
	} // info �޼���
	
	
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		System.out.println("Membercontroller update()");
		String id=(String)session.getAttribute("id");
		MemberDTO dto=memberService.getMember(id);
		
//		dto Model model(request) ���
		model.addAttribute("dto", dto);
		
		return "member/updateForm";
	} // update �޼���
	
	@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)
	public String updatePro(MemberDTO dto) {
		System.out.println("Membercontroller updatePro()");
		
		MemberDTO memberDTO=memberService.userCheck(dto);
		if(memberDTO!=null) {
			memberService.updateMember(dto);
			return "redirect:/member/main";
		} else {
			return "member/msg";
		}
			
	} // updatePro �޼���
	
	
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete(HttpSession session, Model model) {
		String id=(String)session.getAttribute("id");
		MemberDTO dto=memberService.getMember(id);
		
//		dto Model model(request) ���
		model.addAttribute("dto", dto);
		
		return "member/deleteForm";
	} // delete �޼���
	
	@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)
	public String deletePro(MemberDTO dto) {
		System.out.println("Membercontroller deletePro()");
		
		MemberDTO memberDTO=memberService.userCheck(dto);
		if(memberDTO!=null) {
			memberService.deleteMember(dto);
			return "redirect:/member/login";
		} else {
			return "member/msg";
		}
		
	} // deletePro �޼���
	
	
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String getMemberList() {
		System.out.println("Membercontroller getMemberList()");
		
		return "member/list";
	} // getMemberList �޼���
	
	
	
	
} // MemberController Ŭ����
