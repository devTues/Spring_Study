package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {
	// �߻�޼��� ����
	public void insertMember(MemberDTO dto);
	public MemberDTO userCheck(MemberDTO dto);
	public MemberDTO getMember(String id);
	public void updateMember(MemberDTO dto);
	public void deleteMember(MemberDTO dto);
	public void getMemberList(MemberDTO dto);
	
}
