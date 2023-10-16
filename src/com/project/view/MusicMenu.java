package com.project.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.controller.MusicController;
import com.project.vo.Member;
import com.project.vo.Music;

public class MusicMenu {
	private Scanner sc = new Scanner(System.in);
	private MusicController mucon = new MusicController();
	private Member m = new Member();
	private Music mu = new Music();
	
	
	public void insertMusic() {
		System.out.println("\n===노래 추가 메뉴===");
		//id ~취미까지 입력받기
		System.out.print("제목 : ");
		String songName = sc.nextLine();
		
		System.out.print("가수 : ");
		String musician = sc.nextLine();
		
		System.out.print("분위기 : ");
		String mood = sc.nextLine();
		
		mucon.insertMusic(songName, musician, mood);
		
	}
	public void allList() {
		mucon.selectList();
		
	}
	
	public void deleteMusic() {
		System.out.println("\n===노래 삭제 메뉴 ===");
		
		System.out.print("제목 : ");
		String songName = sc.nextLine();
		
		mucon.deleteMusic(songName);	
	}
	
	public void deleteMlistMusic() {
		System.out.println("\n===== 노래 삭제 메뉴 =====");
		
		System.out.print("제목 : ");
		String songName = sc.nextLine();
		
		mucon.deleteMlistMusic(songName);	
	}
	
	public void mListMenu(Member m) {
		mucon.mList(m);
	}
	
	public void mInsertMusic(Member m) {
		System.out.print("제목 : ");
		String songName = sc.nextLine();
		
		System.out.print("가수 : ");
		String musician = sc.nextLine();
		
		ArrayList<Music> list = mucon.selectList2();
		for(Music mu : list) {
			if((mu.getSongName().equals(songName))) {
				mucon.mInsertMusic(m.getUserNo(), songName, musician);
				return;
			}else {
				continue;
			}

		}
		System.out.println("죄송합니다. 저희 서비스에서는 제공하지 않는 노래입니다.");
		
		
		
//		mucon.mInsertMusic(m.getUserNo(), songName, musician);
		
	}
}
