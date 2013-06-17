package com.artivisi.penagihan.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NasabahDaoTest {

	@Test
	public void testSimpan() throws Exception {
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/applicationContext.xml");
		
		NasabahDao n = (NasabahDao) ctx.getBean("nasabahDao");
		n.simpan(null);
	}

}
