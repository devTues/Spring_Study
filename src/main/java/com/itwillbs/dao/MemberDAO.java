package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {
	// �߻�޼��� ����
	public void insertMember(MemberDTO dto);
	public void userCheck(MemberDTO dto);
	public void info(MemberDTO dto);
	
}
