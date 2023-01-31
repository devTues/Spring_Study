package com.itwillbs.dao;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
//	���̹�Ƽ�� ��ü���� => ������� �ڵ� ����
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.memberMapper";
	
	
//	private DataSource dataSource;
//	private SimpleJdbcTemplate jdbcTemplate;
	
	// set�޼���
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
		// ��¥
		Timestamp date=new Timestamp(System.currentTimeMillis());
		dto.setDate(date);
		
//		jdbcTemplate.update(sql����, ?��);
//		jdbcTemplate.update(insertSql, dto.getId(),dto.getPass(),dto.getName(),date);
//		sqlSession.insert(sql����, ?��);
		sqlSession.insert(namespace+".insertMember", dto);
//		sqlSession.update(null);
//		sqlSession.delete(null);
		// select ���ϰ� �ϳ� => sqlSession.selectOne(null);
		// select List(�迭) ������ �� => sqlSession.selectList(null);
		
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
