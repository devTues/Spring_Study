package com.itwillbs.service;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	// �߻�޼��� ����
	public void insertMember(MemberDTO dto);
	public MemberDTO userCheck(MemberDTO dto);
	public MemberDTO getMember(String id);
	public void updateMember(MemberDTO dto);
	public void deleteMember(MemberDTO dto);
	
	
}
