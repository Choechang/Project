package com.project.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.service.MemberService;
import com.project.service.MusicService;
import com.project.view.ManagerMenu;
import com.project.vo.Member;
import com.project.vo.Music;

public class MusicController {
	
	Scanner sc = new Scanner(System.in);
	
	
	//음악 추가
	public void insertMusic(String songName, String musician, String mood) {
		
		Music m = new Music(songName, musician, mood);
		
		int result = new MusicService().insertMusic(m);
		
		if(result > 0) {
			new ManagerMenu().displaySuccess("성공적으로 노래 추가를 완료하였습니다.");
		}else {
			new ManagerMenu().displayFail("노래 추가 실패하였습니다.");
		}
	}
	
	public void mInsertMusic(int userNo, String songName, String musician) {
		
		
		Music m = new Music(userNo, songName, musician);
		
		
		int result = new MusicService().mInsertMusic(m);
		
		if(result > 0) {
			new ManagerMenu().displaySuccess("성공적으로 노래 추가를 완료하였습니다.");
		}else {
			new ManagerMenu().displayFail("노래 추가 실패하였습니다.");
		}
	}
	
	
	//전체 음악 조회
	public void selectList() {
		ArrayList<Music> list = new MusicService().selectList();
		
		if(list.isEmpty()) {
			new ManagerMenu().displayNoData("전체 조회 결과가 없습니다.");
		}else{
			new ManagerMenu().displayMusicList(list);
		}	
	}
	
	public ArrayList<Music> selectList2() {
		ArrayList<Music> list = new MusicService().selectList();
		
		return list;
	}
	
	//회원 음악 조회
	public void mList(Member m) {
		ArrayList<Music> mList = new MusicService().selectmList(m);
		
		if(mList.isEmpty()) {
			new ManagerMenu().displayNoData("전체 조회 결과가 없습니다.");
		}else{
			new ManagerMenu().displayMList(mList);
		}
	}
	
	public void selectBySongName(String songName) {
		Music m = new MusicService().selectBySongName(songName);
		
		if(m ==null) {
			new ManagerMenu().displayNoData(songName + "에 해당하는 조회 결과가 없습니다.");
		}else{
			new ManagerMenu().displayMusic(m);
		}
	}
	
	public void deleteMusic(String songName) {
		int result = new MusicService().deleteMusic(songName);
		
		if(result >0) {
			new ManagerMenu().displaySuccess("[" + songName + "] "+"삭제 성공했습니다.");
		}else {
			new ManagerMenu().displayFail("노래 삭제에 실패하였습니다.");
		}
	}	
	
	public void deleteMlistMusic(String songName) {
		int result = new MusicService().deleteMlistMusic(songName);
		
		if(result >0) {
			new ManagerMenu().displaySuccess("[ " + songName+" ] 삭제 성공했습니다.");
		}else {
			new ManagerMenu().displayFail("재생목록에 없는 노래입니다.");
		}
	}


}
