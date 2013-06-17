package com.artivisi.penagihan.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HelloWorldAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
		// ini dijalankan sebelum method asli
		System.out.println("Sebelum method asli");
		
		// ini pemanggilan method yang sebenarnya
		Object hasil = method.proceed();
		
		// ini dijalankan setelah method asli
		System.out.println("Setelah method asli");
		
		// return apapun hasil dari method asli
		return hasil;
	}

}
