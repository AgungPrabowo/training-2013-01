package com.artivisi.penagihan.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HelloTransactionAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("Transaction Begin");
		try {
			Object hasil = method.proceed();
			System.out.println("Transaction Commit");
			return hasil;
		} catch (Exception err){
			System.out.println("Transaction Rollback");
			throw err;
		}
	}

}
