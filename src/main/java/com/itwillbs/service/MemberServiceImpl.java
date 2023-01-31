package com.itwillbs.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
//  �θ�=�ڽ� ��ü����
//	�ߺ��Ǵ°��� ���� ���� ��ü���� �����ϱ�
//	MemberDAO memberDAO=new MemberDAOImpl();
	@Inject
	private MemberDAO memberDAO;
	
//	@Inject
//	public MemberServiceImpl(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}

//	@Inject
//	���2: set�޼��� ���� => root-context.xml
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}

	@Override
	public void insertMember(MemberDTO dto) {
		System.out.println("MemberServiceImpl insertMember()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
//		MemberController => MemberService(Pro�� ���� �޼��� ���� ������) => MemberDAO
//		��ü���� => �޼��� ȣ��
//		MemberDAO memberDAO=new MemberDAOImpl(); // �ߺ���
		memberDAO.insertMember(dto);
	}

	@Override
	public MemberDTO userCheck(MemberDTO dto) {
		System.out.println("MemberServiceImpl userCheck()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
//		��ü���� => �޼��� ȣ��
//		MemberDAO memberDAO=new MemberDAOImpl(); // �ߺ���
		return memberDAO.userCheck(dto);
	}

	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberServiceImpl info()");
		System.out.println(id);
//		MemberDAO memberDAO=new MemberDAOImpl(); // �ߺ���
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
