package com.project.view;
import java.util.Scanner;

import com.project.controller.MemberController;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private ManagerMenu mm = new ManagerMenu();
	private MemberController mc = new MemberController();
	
	public void mainMenu(){
		while(true) {
			System.out.println("안녕하세요! 회원이시면 로그인을, 비회원이시면 회원가입을 해주세요.");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("0. 프로그램 종료");
			System.out.print(">> 메뉴선택 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : 
//					loginMenu();
					break;
				case 2 :
					inputMember();
					break;
				case 0 :
					System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
					return;
			
					
				case 23919735 :
					mm.mainMenu();
					break;
				default : 
					System.out.println("잘못 입력하셨습니다.");
					continue;
			}
		}
	}
	
	public void inputMember() {
		System.out.println("\n===회원 추가 ===");
		//id ~취미까지 입력받기
		System.out.println("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPsw = sc.nextLine();
		
		System.out.println("이름 : ");
		String userName = sc.nextLine();
		
		System.out.println("성별(M/F) : ");
		String gender = sc.nextLine().toUpperCase();
		
		System.out.println("나이 : ");
		String age = sc.nextLine();
		
		System.out.println("이메일 : ");
		String email = sc.nextLine();
		
		System.out.println("전화번호(-빼고 입력) : ");
		String phone = sc.nextLine();
		
		System.out.println("주소 : ");
		String address = sc.nextLine();
		
		//회원 추가 요청 == Controller메소드 요청
		mc.insertMember(userId, userPsw, userName, gender, age, email,	phone,address);
	}
	
	public void loginMenu() {
		System.out.println();
	}
}
