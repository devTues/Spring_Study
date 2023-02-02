package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.MemberDTO;

public interface MemberDAO {
	// 추상메서드 정의
	public void insertMember(MemberDTO dto);
	public MemberDTO userCheck(MemberDTO dto);
	public MemberDTO getMember(String id);
	public void updateMember(MemberDTO dto);
	public void deleteMember(MemberDTO dto);
	public List<MemberDTO> getMemberList();
	
}
