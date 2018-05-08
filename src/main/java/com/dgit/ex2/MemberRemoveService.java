package com.dgit.ex2;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRemoveService {

	@Autowired
	MemberDao dao;
	
	public void removeMember(String name){
		Member existedMember = dao.selectByName(name);
		
		if(existedMember !=null){//회원의 존재유무 판단
			
			//실제로는 회원의 비번을 비교해야 하지만 오늘은 이름만 비교함
			if(existedMember.getName().equals(name)){
				System.out.println("회원을 삭제하겠습니다.");
				dao.deleteMemberByName(existedMember);
				return;
			}
		}else{
			System.out.println("찾는 회원이 없습니다.");
		}
	}
}
