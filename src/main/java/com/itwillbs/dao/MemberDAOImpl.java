package com.itwillbs.dao;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
//	마이바티스 객체생성 => 멤버변수 자동 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.memberMapper";
	
	
//	private DataSource dataSource;
//	private SimpleJdbcTemplate jdbcTemplate;
	
	// set메서드
//	@Inject
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//		jdbcTemplate=new SimpleJdbcTemplate(dataSource);
//	}

	
//	String insertSql="insert into members(id,pass,name,date) values(?,?,?,?)";
	
	@Override
	public void insertMember(MemberDTO dto) {
		System.out.println("MemberDAOImpl insertMember");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
		// 날짜
		Timestamp date=new Timestamp(System.currentTimeMillis());
		dto.setDate(date);
		
//		jdbcTemplate.update(sql구문, ?값);
//		jdbcTemplate.update(insertSql, dto.getId(),dto.getPass(),dto.getName(),date);
//		sqlSession.insert(sql구문, ?값);
		sqlSession.insert(namespace+".insertMember", dto);
//		sqlSession.update(null);
//		sqlSession.delete(null);
		// select 리턴값 하나 => sqlSession.selectOne(null);
		// select List(배열) 리턴할 때 => sqlSession.selectList(null);
		
	}


	@Override
	public MemberDTO userCheck(MemberDTO dto) {
		System.out.println("MemberDAOImpl userCheck");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		return sqlSession.selectOne(namespace+".userCheck", dto);
		
	}

	@Override
	public MemberDTO getMember(String id) {
		System.out.println("MemberDAOImpl info");
		System.out.println(id);
		return sqlSession.selectOne(namespace+".getMember", id);
	}


	@Override
	public void updateMember(MemberDTO dto) {
		System.out.println("MemberDAOImpl updateMember");
		System.out.println(dto.getName());
		sqlSession.update(namespace+".updateMember", dto);
		
	}


	@Override
	public void deleteMember(MemberDTO dto) {
		System.out.println("MemberDAOImpl deleteMember");
		sqlSession.delete(namespace+".deleteMember", dto);
		
	}

	
	
}
