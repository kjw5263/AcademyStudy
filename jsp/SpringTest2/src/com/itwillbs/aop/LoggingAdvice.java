package com.itwillbs.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
// 보조 기능 : 메소드 호출 전, 후에 메시지 출력 기능
public class LoggingAdvice implements MethodInterceptor{

	// 메소드 실행 하기 전에 잠깐 가로채서
	// invoke 메소드에 arg0 로 인터셉트
	// 즉 메소드 실행하기 전에 이걸 먼저 실행하도록 하는 기능~
	// 메인 기능에는 아무런 영향 가지 않는다.
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("[메소드 실행 전 : LoggingAdvice]");
		System.out.println(arg0.getMethod() + "<< 해당 메소드 호출 전");
		
		// 메소드 실행
		Object object = arg0.proceed();		
		
		System.out.println("[메소드 실행 후 : LoggingAdvice]");
		System.out.println(arg0.getMethod() + "<< 해당 메소드 호출 후");
		
		return object;
	}
	
	
}
