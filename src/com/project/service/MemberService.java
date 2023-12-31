package com.project.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.project.common.JDBCTemplate;
import com.project.dao.MemberDao;
import com.project.vo.Member;

public class MemberService {
	
	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Member> selectList(){
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberDao().selectList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public Member selectByUserId(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectByUserId(conn, userId);
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	public Member selectByIdPwd(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
	
		return m;	
	}
	
	public ArrayList<Member> selectByUserName(String keyword){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new MemberDao().selectByUserName(conn, keyword);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int updateMember(Member m){
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int deleteMember(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn, userId);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
}
