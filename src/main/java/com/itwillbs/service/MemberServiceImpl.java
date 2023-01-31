package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
//  부모=자식 객체생성
//	중복되는것은 제일 위에 객체생성 선언하기
//	MemberDAO memberDAO=new MemberDAOImpl();
	@Inject
	private MemberDAO memberDAO;
	
//	@Inject
//	public MemberServiceImpl(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}

//	@Inject
//	방법2: set메서드 전달 => root-context.xml
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}

	@Override
	public void insertMember(MemberDTO dto) {
		System.out.println("MemberServiceImpl insertMember()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
//		MemberController => MemberService(Pro에 대한 메서드 내용 모으기) => MemberDAO
//		객체생성 => 메서드 호출
//		MemberDAO memberDAO=new MemberDAOImpl(); // 중복됨
		memberDAO.insertMember(dto);
	}

	@Override
	public MemberDTO userCheck(MemberDTO dto) {
		System.out.println("MemberServiceImpl userCheck()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
//		객체생성 => 메서드 호출
//		MemberDAO memberDAO=new MemberDAOImpl(); // 중복됨
		return memberDAO.userCheck(dto);
	}

	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberServiceImpl info()");
		System.out.println(id);
//		MemberDAO memberDAO=new MemberDAOImpl(); // 중복됨
		return memberDAO.getMember(id);
		
	}

	@Override
	public void updateMember(MemberDTO dto) {
		System.out.println("MemberServiceImpl updateMember()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
		memberDAO.updateMember(dto);
	}

	@Override
	public void deleteMember(MemberDTO dto) {
		System.out.println("MemberServiceImpl deleteMember()");
		memberDAO.deleteMember(dto);
		
	}
	
	
	
}
