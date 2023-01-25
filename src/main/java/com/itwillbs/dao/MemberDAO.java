package com.itwillbs.dao;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {
	// 추상메서드 정의
	public void insertMember(MemberDTO dto);
	public void userCheck(MemberDTO dto);
	public void info(MemberDTO dto);
	
}
