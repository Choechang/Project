package com.project.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.controller.MemberController;
import com.project.controller.MusicController;
import com.project.vo.Member;
import com.project.vo.Music;

public class ManagerMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private MemberController mc = new MemberController();
	
	private MusicController mucon = new MusicController();
	
	private MusicMenu mume = new MusicMenu();
	
	
	
	public void mainMenu() {		
		while(true) {
			System.out.println("\n[   관리자 모드입니다.   ]");
			System.out.println("======================");
			System.out.println("[  회원 관리 메뉴  ]");
			System.out.println("[1] 회원추가");
			System.out.println("[2] 회원 전체 조회");
			System.out.println("[3] 회원 아이디 검색");
			System.out.println("[4] 회원 이름으로 키워드 검색");
			System.out.println("[5] 회원 정보 변경");
			System.out.println("[6] 회원 삭제");
			System.out.print("======================");
			System.out.println("\n[  노래 관리 메뉴  ]");
			System.out.println("[7] 노래 추가");
			System.out.println("[8] 노래 삭제");
			System.out.println("[9] 노래 목록");
			System.out.println("======================");
			
			System.out.println("[0] 프로그램 종료\n");
			System.out.print(">> 메뉴선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : 
				inputMember();
				break;
			case 2 : 
				mc.selectList();
				break;
			case 3 :
//				String userId = inputMemberId();
//				mc.selectByUserId(userId);		
				mc.selectByUserId(inputMemberId());
				break;
			case 4 : 
//				String keyword = inputMemberName();
//				mc.selectByUserName();
				mc.selectByUserName(inputMemberName());
				break;
			case 5 : 
				//userid
				//패스워드, 이메일, 전화번호, 주소
				updateMember();
				break;
			case 6 : 
				// DELETE FROM MEMBER WHERE USERID = '사용자가입력하나 아이디'
//				String userId = inputMemberId();
//				mc.deleteMember(userId);
				mc.deleteMember(inputMemberId());
				break;
				
			case 7 : 
				mume.insertMusic();
				break;
			case 8 : 
				mume.deleteMusic();
				break;
			case 9 : 
				mume.allList();
				break;
			case 0 : 
				System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.\n");
				System.out.println("=====================================\n\n");
				return;
			default : 
				System.out.println("");
			}
		}	
	}
	
	/**
	 * 회원 추가 창(서브화면) 즉, 추가하고자 하는 회원의 정보를 입력받아 회원을 추가요청하는 창
	 */
	public void inputMember() {
		System.out.println("\n=====회원 추가=====");
		//id ~취미까지 입력받기
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPsw = sc.nextLine();
		
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("전화번호(-빼고 입력) : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
			
		//회원 추가 요청 == Controller메소드 요청
		mc.insertMember(userId, userPsw, userName, gender, age, email, phone, address);	
	}
	
	public void inputSong() {
		System.out.println("\n===== 곡 추가 =====");
		//id ~취미까지 입력받기
		System.out.print("제목 : ");
		String songName = sc.nextLine();
		
		System.out.print("가수 : ");
		String musician = sc.nextLine();
		
		System.out.print("분위기 : ");
		String mood = sc.nextLine();
		
		mucon.insertMusic(songName, musician, mood);
		
	}		
		//회원 추가 요청 == Controller메소드 요청
	
	
	public String inputMemberId() {
		System.out.print("\n회원 아이디 입력 : ");
		return sc.nextLine();
	}
	
	public String inputMemberName() {
		System.out.print("\n키워드 입력 : ");
		return sc.nextLine();
	}
	
	public void updateMember() {
		System.out.println("\n===== 회원 정보 변경 =====");
		
		//(찾으려고)아이디, 비밀번호, 이메일, 전화번호, 주소
		String userId = inputMemberId();
		
		System.out.print("변경할 비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("변경할 이메일  : ");
		String email = sc.nextLine();
		
		System.out.print("변경할 전화번호  : ");
		String phone = sc.nextLine();
		
		System.out.print("변경할 주소 : ");
		String address = sc.nextLine();
		
		mc.updateMember(userId, userPwd, email, phone, address);
		
	}
	
	
	//-------------------응답화면-----------------
	
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : "+ message);
	}
	
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : "+ message);
	}
	
	/**
	 * 조회 서비스 요청시 조회결과가 없을 떄 사용자가 보게 될 응답화면
	 * 
	 * @param message : 조회결과에 대한 응답 메시지
	 */
	public void displayNoData(String message) {
		System.out.println("\n서비스 요청 실패 : "+ message);
	}
	
	/**
	 * ㅈ회 서비스 요청시 조회 결과가 여러 행일 경우 사용자가 보게될 응답화면
	 * @param list : 출력할 member들이 담겨있는 list
	 */
	public void displayMemberList(ArrayList<Member> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다. \n");
		
		//for loop
//		for(int i = 0; i < list.size(); i++) {
////			Member m - list.get(i);
////			System.out.println(m); == 둘이 합쳐서 아래
//			
//			System.out.println(list.get(i));
		
		for(Member m : list) {
			System.out.println(m);
		}
	}
	
	public void displayMusicList(ArrayList<Music> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다. \n");
		
		for(Music m : list) {
			System.out.println(m.toString());
		}
	}
	
	public void displayMList(ArrayList<Music> mList) {
		System.out.println("\n[고객님의 재생목록입니다. ]");
		System.out.println("=======================================\n");
		
		for(Music m : mList) {
			System.out.println(m.print());
		}
	}
	
	public void displayMember(Member m) {
		System.out.println("\n 조회된 데이터는 다음과 같습니다.");
		System.out.println(m);
	}
	
	public void displayMusic(Music m) {
		System.out.println("\n 조회된 데이터는 다음과 같습니다.");
		System.out.println(m);
	}
	
}


