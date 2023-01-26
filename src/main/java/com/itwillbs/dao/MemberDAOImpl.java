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
		
//		jdbcTemplate.update(sql����, ?��);
//		jdbcTemplate.update(insertSql, dto.getId(),dto.getPass(),dto.getName(),date);
//		sqlSession.insert(sql����, ?��);
		sqlSession.insert("com.itwillbs.mappers.memberMapper.insertMember", dto);
		
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
