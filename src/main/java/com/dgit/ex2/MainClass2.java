package com.dgit.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass2 {
	static MemberInsertService insertSvc;
	static MemberInfoPrinter printSvc;
	static ChangePasswordService changePw;
	static MemberRemoveService removeSvc;
	
	public static void main(String[] args) throws IOException {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCtx2.xml");
		
		insertSvc = ctx.getBean(MemberInsertService.class);
		printSvc = ctx.getBean(MemberInfoPrinter.class);
		changePw = ctx.getBean(ChangePasswordService.class);
		removeSvc = ctx.getBean(MemberRemoveService.class);
		
		//한 줄씩 읽어들이기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){//끝날때 까지 무한루프
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();//한 줄 통으로 읽어들임
			
			if(command.equalsIgnoreCase("exit")){//콘솔에서 exit입력하면 종료
				System.out.println("종료합니다.");
				break;
			}else if(command.startsWith("new")){//회원가입처리 ex)new 정영화 1234
				processNewCommand(command.split(" "));
			}else if(command.startsWith("list")){//ex)list : 모든회원 보기
				processListCommand(command.split(" "));
			}else if(command.startsWith("change")){//ex)change(명령어) abc(name) 111(현재비번) 1212(바뀐비번)
				processChangePasswordCommand(command.split(" "));
			}else if(command.startsWith("remove")){//ex)remove abc(name)
				processRemoveMemberCommand(command.split(" "));
			}
		}
		
		/*Member member = new Member();
		member.setName("test");
		member.setPassword("123");
		
		insertSvc.insert(member);//회원가입
		
		insertSvc.insert(member);//이미 가입된 회원
		
		Member member2 = new Member();
		member2.setName("apple");
		member2.setPassword("12345");
		
		insertSvc.insert(member2);
		
		
		printSvc.printAll();*/
		
		ctx.close();
		

	}
	
	private static void processNewCommand(String[] arg){
		if(arg.length !=3){
			System.out.println("형식에 맞게 다시 입력하세요.");
			return;
		}
		
		Member member = new Member();
		member.setName(arg[1]);
		member.setPassword(arg[2]);
		insertSvc.insert(member);
	}

	private static void processListCommand(String[] arg){
		if(arg.length != 1){//list는 하나만 넘어오기 때문에 만약 하나가 아니라면
			System.out.println("명령어를 다시 입력하세요.");
			return;
		}
		printSvc.printAll();
	}
	
	private static void processChangePasswordCommand(String[] arg){
		if(arg.length !=4){
			System.out.println("형식에 맞게 다시 입력하세요.");
			return;
		}
		
		Member member = new Member();
		member.setName(arg[1]);
		member.setPassword(arg[2]);//기존의 비번
		changePw.changePassword(member, arg[3]);//회원과 바꿀 비번
	}
	
	private static void processRemoveMemberCommand(String[] arg){
		if(arg.length != 2){
			System.out.println("명령어를 다시 입력하세요.");
			return;
		}
		
		removeSvc.removeMember(arg[1]);
	}
}
