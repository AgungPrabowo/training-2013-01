package com.artivisi.penagihan.dao;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.artivisi.penagihan.domain.Nasabah;
import com.artivisi.penagihan.domain.PenagihanService;
import com.artivisi.penagihan.domain.StatusTagihan;
import com.artivisi.penagihan.domain.Tagihan;
import com.artivisi.penagihan.domain.TagihanPK;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:com/artivisi/**/applicationContext.xml")
public class TagihanDaoTest {
	@Autowired
	private PenagihanService penagihanService;

	@Autowired
	private DataSource dataSource;

	@Before
	public void hapusDataTest() throws Exception {
		IDataSet[] daftarDataset = new IDataSet[] { 
				new FlatXmlDataSetBuilder()
				.build(new File("src/test/resources/dbunit/nasabah.xml")),
				new FlatXmlDataSetBuilder()
				.build(new File("src/test/resources/dbunit/tagihan.xml"))
		};

		Connection conn = dataSource.getConnection();
		
		// untuk oracle, harus pakai skema
		/*
		DatabaseOperation.CLEAN_INSERT.execute
			(new DatabaseConnection(conn, "skema"),
				new CompositeDataSet(daftarDataset));
		*/
		
		// non oracle, tidak pakai skema
		DatabaseOperation.CLEAN_INSERT.execute(new DatabaseConnection(conn),
				new CompositeDataSet(daftarDataset));

		conn.close();
	}
	
	@Test
	public void testSimpan() throws Exception {
		TagihanPK pk = new TagihanPK();
		pk.setKodeCabang("CAB-002");
		pk.setNomerBooking("BOOK-001");
		
		Tagihan t = new Tagihan();
		t.setId(pk);
		
		Nasabah n = new Nasabah();
		n.setId("abcd1234");
		t.setNasabah(n);
		
		t.setNilai(new BigDecimal(101000.01));
		t.setStatus(StatusTagihan.BELUM_DIBAYAR);
		t.setTanggalJatuhTempo(new DateTime().withDayOfMonth(20).toDate());
		t.setUser("endy");
		t.setWaktuBooking(new Date());
		
		penagihanService.simpan(t);
		
		String sql = "select * from t_tagihan where kode_cabang = ? and nomer_booking = ?";
		Connection conn = dataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "CAB-002");
		ps.setString(2, "BOOK-001");
		ResultSet rs = ps.executeQuery();
		Assert.assertTrue(rs.next());
		
		conn.close();
	}
}
