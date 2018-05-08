package com.dgit.ex2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	private static long netxId = 0;// member 안에 id autoincrement를 위한 변수

	private Map<String, Member> map = new HashMap<String, Member>();

	public void insert(Member member) {
		// auto increment

		member.setId(++netxId);
		map.put(member.getName(), member);
	}

	// map에 들어있는 거를 모두 넘겨주기위해
	public Collection<Member> selectAll() {
		return map.values();
	}

	// 이미 가입한 회원인지 찾기위해
	public Member selectByName(String name) {
		return map.get(name);
	}
	
	//비밀번호 변경
	public void updatePassword(Member existedMember){//바뀐 정보를 받은 멤버를 넣어줌
		map.put(existedMember.getName(), existedMember);
		
	}
	
	//회원삭제
	public void deleteMemberByName(Member existedMember){
		map.remove(existedMember.getName());
	}
}
