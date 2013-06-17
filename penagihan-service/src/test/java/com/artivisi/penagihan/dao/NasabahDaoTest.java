package com.artivisi.penagihan.dao;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NasabahDaoTest {

	@Test
	public void testSimpan() throws Exception {
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("classpath*:com/artivisi/**/applicationContext.xml");
		
		DataSource ds = (DataSource) ctx.getBean("dataSource");
		
		NasabahDao n = new NasabahDao(ds);
		n.simpan(null);
	}

}
