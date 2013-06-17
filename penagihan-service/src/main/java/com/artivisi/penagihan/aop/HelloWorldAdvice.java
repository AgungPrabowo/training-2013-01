package com.artivisi.penagihan.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HelloWorldAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
		// ini dijalankan sebelum method asli
		System.out.println("Cek login");
		
		// Print informasi method
		System.out.println("Nama Method : "+method.getMethod().getName());
		System.out.println("Jumlah Argumen : "+method.getArguments().length);
		
		// Isi argumen
		int i = 1;
		for (Object arg : method.getArguments()) {
			System.out.println("Argumen "+i+" : "+arg);
			System.out.println("Tipe Data Argumen "+i+" : "+arg.getClass().getName());
			i++;
		}
		
		// ini pemanggilan method yang sebenarnya
		Object hasil = method.proceed();
		
		if(hasil == null){
			throw new IllegalStateException("Hasil tidak boleh null");
		}
		
		// ini dijalankan setelah method asli
		System.out.println("Setelah method asli");
		
		// return apapun hasil dari method asli
		return hasil;
	}

}
