package com.artivisi.penagihan.dao;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.artivisi.penagihan.domain.Nasabah;
import com.artivisi.penagihan.domain.PenagihanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:com/artivisi/**/applicationContext.xml")
public class NasabahDaoTest {
	
	@Autowired
	private PenagihanService penagihanService;
	
	@Test
	public void encryptJasypt(){
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword("test123");
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");
		String encryptedText = encryptor.encrypt("admin");
		System.out.println("Encrypted Password : ["+encryptedText+"]");
		
		String decrypted = encryptor.decrypt(encryptedText);
		System.out.println("Decrypted Password : ["+decrypted+"]");
	}
	
	@Test
	public void testInsertNasabah(){
		System.out.println("Tes Konfigurasi Spring Hibernate");
		
		Nasabah n = new Nasabah();
                n.setNomer("N-001");
		n.setNama("Endy Muhardin");
		penagihanService.simpan(n);
	}
}
