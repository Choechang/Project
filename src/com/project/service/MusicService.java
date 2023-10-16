package com.project.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.project.common.JDBCTemplate;
import com.project.dao.MemberDao;
import com.project.dao.MusicDao;
import com.project.vo.Member;
import com.project.vo.Music;

public class MusicService {
	
	public int insertMusic(Music m) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new MusicDao().insertMusic(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int mInsertMusic(Music m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MusicDao().mInsertMusic(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public ArrayList<Music> selectList(){
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Music> list = new MusicDao().selectList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public ArrayList<Music> selectmList(Member m){
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Music> mList = new MusicDao().selectmList(conn, m.getUserNo());
		JDBCTemplate.close(conn);
		
		return mList;
	}
	
	public Music selectBySongName(String songName) {
		Connection conn = JDBCTemplate.getConnection();
		Music m = new MusicDao().selectBySongName(conn, songName);
		JDBCTemplate.close(conn);
		
		return m;
	}
	
	
	
	public int deleteMusic(String songName) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMusic(conn, songName);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int deleteMlistMusic(String songName) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMlistMusic(conn, songName);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
}
