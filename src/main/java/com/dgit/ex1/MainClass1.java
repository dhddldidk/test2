package com.dgit.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass1 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCtx1.xml");
		
		StudentInfo s = ctx.getBean(StudentInfo.class);
		s.getInfo();
		
		ctx.close();
		

	}

}
