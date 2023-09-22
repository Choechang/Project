package com.project.controller;

import java.util.ArrayList;

import com.project.service.MemberService;
import com.project.view.ManagerMenu;
import com.project.vo.Member;

public class MemberController {

	
	public void insertMember(String userId, String userPwd, String userName, String gender, String age, String email,
						String phone, String address) {
		
		Member m = new Member(userId, userPwd, userName, gender, Integer.parseInt(age), 
								email, phone, address);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) {
			new ManagerMenu().displaySuccess("성공적으로 회원 추가를 완료하였습니다.");
		}else {
			new ManagerMenu().displayFail("회원 추가 실패하였습니다.");
		}			
	}
	
	//회원 전체 조회 요청
	public void selectList() {
		ArrayList<Member> list = new MemberService().selectList();
		
		if(list.isEmpty()) {
			new ManagerMenu().displayNoData("전체 조회 결과가 없습니다.");
		}else{
			new ManagerMenu().displayMemberList(list);
		}	
	}
	
	//사용자의 아이디로 회원 검색 요청	
	public void selectByUserId(String userId) {
		Member m = new MemberService().selectByUserId(userId);
		
		if(m ==null) {
			new ManagerMenu().displayNoData(userId + "에 해당하는 조회 결과가 없습니다.");
		}else{
			new ManagerMenu().displayMember(m);
		}
	}
	
	//사용자의 아이디로 회원 검색 요청
	public void selectByUserName(String keyword) {
		
		ArrayList<Member> list = new MemberService().selectByUserName(keyword);
		
		if(list.isEmpty()) {
			new ManagerMenu().displayNoData(keyword + "에 해당하는 조회결과가 없습니다."); 
		}else {
			new ManagerMenu().displayMemberList(list);	
		}
	}
	
	public void updateMember(String userId, String userPwd, String email,
							String phone, String address) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		
		int result = new MemberService().updateMember(m);
		
		if(result > 0) {
			new ManagerMenu().displaySuccess("성공적으로 수정하였습니다.");
		}else {
			new ManagerMenu().displayFail("회원 정보 변경에 실패하였습니다.");
		}
	}
	
	public void deleteMember(String userId) {
		int result = new MemberService().deleteMember(userId);
		
		if(result >0) {
			new ManagerMenu().displaySuccess(userId+"삭제 성공했습니다.");
		}else {
			new ManagerMenu().displayFail("회원 정보 변경에 실패하였습니다.");
		}
	}	
}

