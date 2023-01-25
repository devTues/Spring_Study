package com.itwillbs.service;

import javax.inject.Inject;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
//  �θ�=�ڽ� ��ü����
//	�ߺ��Ǵ°��� ���� ���� ��ü���� �����ϱ�
//	MemberDAO memberDAO=new MemberDAOImpl();
	private MemberDAO memberDAO;
	
	@Inject
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Inject
//	���2: set�޼��� ���� => root-context.xml
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

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
	public void userCheck(MemberDTO dto) {
		System.out.println("MemberServiceImpl userCheck()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
//		��ü���� => �޼��� ȣ��
//		MemberDAO memberDAO=new MemberDAOImpl(); // �ߺ���
		memberDAO.userCheck(dto);
	}

	@Override
	public void info(MemberDTO dto) {
		System.out.println("MemberServiceImpl info()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
//		MemberDAO memberDAO=new MemberDAOImpl(); // �ߺ���
		memberDAO.info(dto);
		
	}
	
	
	
}
