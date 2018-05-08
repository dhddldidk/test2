package com.dgit.ex2;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

	@Autowired
	MemberDao dao;
	
	public void changePassword(Member member, String pass){//입려받은 회원과 새로운 비번
		Member existedMember = dao.selectByName(member.getName());
		//DB에 있는 회원                                                       //입력받은 회원
		
		
		if(existedMember != null && existedMember.getPassword().equals(member.getPassword())){
			System.out.println("비밀번호를 변경하였습니다.");
			existedMember.setPassword(pass);
			dao.updatePassword(existedMember);
			return;
		}else{
			System.out.println("비밀번호 변경에 실패하였습니다.");
		}
		
	}
}
