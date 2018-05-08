package com.dgit.ex2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	@Autowired
	MemberDao dao;
	
	public void printAll(){
		Collection<Member> list = dao.selectAll();
		
		for(Member m : list){
			System.out.println("==============================");
			System.out.println("id : "+ m.getId());
			System.out.println("name : "+m.getName());
			System.out.println("password : "+m.getPassword());
			System.out.println("==============================");
		}
	}
	
	
}
