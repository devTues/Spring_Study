package com.itwillbs.service;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	// �߻�޼��� ����
	public void insertMember(MemberDTO dto);
	public void userCheck(MemberDTO dto);
	public void info(MemberDTO dto);
}
