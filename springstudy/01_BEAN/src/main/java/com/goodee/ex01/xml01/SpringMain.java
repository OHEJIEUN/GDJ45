package com.goodee.ex01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		// GenericXmlApplicationContext 클래스
		// 1. spring bean configuration file에 등록된 <bean>을 가져오는 스프링 클래스
		// 2. AbstractApplicationContext 클래스의 자식 클래스
		
		// <bean>을 가지고 올 context(xml) 지정하기
		String resourceLocations = "classpath:xml/context01.xml";  // src/main/resources 아래 xml 폴더에 저장된 context01.xml을 의미한다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		// <bean> 가지고 오기
		Calculator calc1 = ctx.getBean("calculator1", Calculator.class);
		calc1.add(1, 1);
		calc1.sub(2, 1);
		calc1.add(3, 2);
		calc1.div(5, 2);
		calc1.mod(7, 3);
		
		// <bean> 가지고 오기
		EngineerCalculator eCalc1 = ctx.getBean("eCalculator1", EngineerCalculator.class);
		eCalc1.add();
		eCalc1.sub();
		eCalc1.mul();
		eCalc1.div();
		eCalc1.mod();
		
		// <bean> 가지고 오기
		EngineerCalculator eCalc2 = ctx.getBean("eCalculator2", EngineerCalculator.class);
		eCalc2.add();
		eCalc2.sub();
		eCalc2.mul();
		eCalc2.div();
		eCalc2.mod();
		
		// <bean> 가지고 오기
		EngineerCalculator eCalc3 = ctx.getBean("eCalculator3", EngineerCalculator.class);
		eCalc3.add();
		eCalc3.sub();
		eCalc3.mul();
		eCalc3.div();
		eCalc3.mod();
		
		
		
		ctx.close();

	}

}
