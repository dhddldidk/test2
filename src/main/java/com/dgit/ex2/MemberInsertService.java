package com.dgit.ex2;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInsertService {
	
	@Autowired
	MemberDao dao;
	
	public void insert(Member member){
		
		//이미 회원가입이 되어 있는지 확인
		Member oldMember = dao.selectByName(member.getName());
		
		if(oldMember != null){//이미 가입된 회원
			System.out.println("이미 가입되어 있는 회원입니다.");
			return;
		}
		dao.insert(member);
		System.out.println("회원가입이 되었습니다.");
	}
}
