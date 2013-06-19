package com.artivisi.penagihan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Assert;
import org.junit.Before;
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
	
	@Autowired 
	private DataSource dataSource;
	
	@Before
	public void hapusDataTest() throws Exception {
		String sql = "delete from m_nasabah where nomer = ?";
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "N-001");
		ps.executeUpdate();
		conn.close();
	}
	
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
	public void testInsertNasabah() throws Exception {
		System.out.println("Tes Konfigurasi Spring Hibernate");
		
		Nasabah n = new Nasabah();
        n.setNomer("N-001");
		n.setNama("Endy Muhardin");
		penagihanService.simpan(n);
		
		String sqlCheck = "select * from m_nasabah where nomer = ?";
		Connection conn = dataSource.getConnection();
		PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
		psCheck.setString(1, "N-001");
		ResultSet rs = psCheck.executeQuery();
		
		Assert.assertTrue(rs.next()); // pastikan query menghasilkan data
		Assert.assertNotNull(rs.getString("id"));
		Assert.assertEquals("Endy Muhardin", rs.getString("nama"));
		
		conn.close();
	}
}
