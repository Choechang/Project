package com.project.view;

import java.util.Scanner;

import com.project.controller.MemberController;
import com.project.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private ManagerMenu mm = new ManagerMenu();
	private MemberController mc = new MemberController();
	private MusicMenu mume = new MusicMenu();
	
	public void mainMenu(){
		while(true) {
			System.out.println("안녕하세요! \n\n회원이시면 로그인을, 비회원이시면 회원가입을 해주세요.\n");
			System.out.println("====== 메뉴 ======");
			System.out.println("[1] 로그인");
			System.out.println("[2] 회원가입");
			System.out.println("[0] 프로그램 종료");
			System.out.println("=================\n");
			System.out.print(">> 메뉴선택 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : 
					loginMenu();
					break;
				case 2 :
					inputMember();
					break;
				case 0 :
					System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.\n");
					return;	
				case 23919735 :
					mm.mainMenu();
					break;
				default : 
					System.out.println("잘못 입력하셨습니다.\n");
					continue;
			}
		}
	}
	
	public void inputMember() {
		System.out.println("\n===회원 가입 ===");
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
		mc.insertMember(userId, userPsw, userName, gender, age, email,	phone,address);
	}
	
	public void loginMenu() {
//		while(true) {
			
			System.out.println("====== 로그인화면 =====");
			System.out.print("아이디 : ");
			String userId = sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String userPwd = sc.nextLine();
			
			mc.loginMember(userId, userPwd);
			
//		}
	}
	
	public void memberMenu(Member m) {
//		String userName = name;
		System.out.println("\n=======================================");
		System.out.println("환영합니다! [" + m.getUserName() +"]님! 원하시는 메뉴를 선택해 주세요.");
		
		while(true) {
			System.out.println("================= 메뉴 =================");
			System.out.println("1. 목록 노래 추가");
			System.out.println("2. 목록 노래 삭제");
			System.out.println("3. 내 노래 목록");
			System.out.println("4. 전체 차트 목록");
			System.out.println("0. 로그아웃");
			System.out.println("======================================");
			System.out.print("\n>> 메뉴선택 : ");
			
			int menuNum = sc.nextInt();

			
			switch(menuNum) {
			case 1 :
				mume.mInsertMusic(m);
				break;
			case 2 : 
				mume.deleteMlistMusic();
				break;
			case 3 : 
				mume.mListMenu(m);
				break;
			case 4 : 
				mume.allList();
				break;
			case 0 : 
				System.out.println("이용해주셔서 감사합니다. 다음에 다시 찾아 주세요.");
				System.out.println("=====================================\n");
				return;
			}
		}
	}

}
