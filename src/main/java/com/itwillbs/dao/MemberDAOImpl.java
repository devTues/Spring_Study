package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public void insertMember(MemberDTO dto) {
		System.out.println("MemberDAOImpl insertMember");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
	}

	@Override
	public void userCheck(MemberDTO dto) {
		System.out.println("MemberDAOImpl userCheck");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
	}

	@Override
	public void info(MemberDTO dto) {
		System.out.println("MemberDAOImpl info");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
	}

	
	
}
