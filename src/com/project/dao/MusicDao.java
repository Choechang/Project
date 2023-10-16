package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.common.JDBCTemplate;
import com.project.vo.Member;
import com.project.vo.Music;


public class MusicDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rset;
	
	public int insertMusic(Connection conn, Music m) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = "INSERT INTO LIST VALUES(SEQ_TABLE1.NEXTVAL, ?, ?, ?)";
			System.out.println(m.toString());
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getSongName());
				pstmt.setString(2, m.getMusician());
				pstmt.setString(3, m.getMood());
				
				result = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return result;
	}
	
	public int mInsertMusic(Connection conn, Music m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MLIST VALUES(?, ?, ?)";
		
		System.out.println(m.print());
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getuserNo());
			pstmt.setString(2, m.getSongName());
			pstmt.setString(3, m.getMusician());
			
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Music> selectList(Connection conn){
		
		ArrayList<Music> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM LIST ORDER BY SONG_NAME";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Music m = new Music();
				m.setSongName(rset.getString("song_name"));
				m.setMusician(rset.getString("musician"));
				m.setMood(rset.getString("mood"));
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Music> selectmList(Connection conn, int UserNo){
		
		ArrayList<Music> mList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MLIST WHERE USERNO = ?";
//		ORDER BY SONG_NAME
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, UserNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Music m1 = new Music();
				m1.setuserNo(rset.getInt("userno"));
				m1.setSongName(rset.getString("song_name"));
				m1.setMusician(rset.getString("musician"));
				
				mList.add(m1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mList;
	}
	
//		public ArrayList<Music> selectmList(Connection conn){
//		
//		ArrayList<Music> mList = new ArrayList<>();
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
////		String sql = "SELECT * FROM LIST WHERE USERNO = ? ORDER BY SONG_NAME";
//		String sql = "SELECT * FROM MLIST ORDER BY SONG_NAME";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rset = pstmt.executeQuery();
////			pstmt.setString(1, us);
//			
//			while(rset.next()) {
//				Music m = new Music();
//				m.setuserNo(rset.getInt("userno"));
//				m.setSongName(rset.getString("song_name"));
//				m.setMusician(rset.getString("musician"));
//				
//				mList.add(m);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
//		}
//		return mList;
//	}
	
	public Music selectBySongName(Connection conn, String songName) {
		
		Music m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM LIST WHERE SONG_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, songName);
			rset = pstmt.executeQuery();	
			if(rset.next()) {
				m = new Music();
				
				m.setSongName(rset.getString("song_name"));
				m.setMusician(rset.getString("musician"));
				m.setMood(rset.getString("mood"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public int deleteMember(Connection conn, String songName) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM LIST WHERE SONG_NAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, songName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
