package com.artivisi.penagihan.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.artivisi.penagihan.domain.Nasabah;

public class NasabahDaoAopTest {

	@Test
	public void testSimpan() throws Exception {
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/belajar-aop.xml");
		
		NasabahDao n = (NasabahDao) ctx.getBean("nasabahDao");
		n.simpan(new Nasabah());
	}
	
	@Test
	public void testCariNasabahById() throws Exception {
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/belajar-aop.xml");
		
		NasabahDao n = (NasabahDao) ctx.getBean("nasabahDao");
		n.findNasabahById("abc");
	}

}
