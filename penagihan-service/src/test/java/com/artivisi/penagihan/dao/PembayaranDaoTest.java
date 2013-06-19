package com.artivisi.penagihan.dao;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.artivisi.penagihan.domain.Pembayaran;
import com.artivisi.penagihan.domain.PenagihanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:com/artivisi/**/applicationContext.xml")
public class PembayaranDaoTest {
	@Autowired
	private PenagihanService penagihanService;

	@Autowired
	private DataSource dataSource;

	@Before
	public void hapusDataTest() throws Exception {
		IDataSet[] daftarDataset = new IDataSet[] {
				new FlatXmlDataSetBuilder().build(new File(
						"src/test/resources/dbunit/nasabah.xml")),
				new FlatXmlDataSetBuilder().build(new File(
						"src/test/resources/dbunit/tagihan.xml")) };

		Connection conn = dataSource.getConnection();

		// untuk oracle, harus pakai skema
		/*
		 * DatabaseOperation.CLEAN_INSERT.execute (new DatabaseConnection(conn,
		 * "skema"), new CompositeDataSet(daftarDataset));
		 */

		// non oracle, tidak pakai skema
		DatabaseOperation.CLEAN_INSERT.execute(new DatabaseConnection(conn),
				new CompositeDataSet(daftarDataset));

		conn.close();
	}

	@Test
	public void testCariPembayaranByNomerNasabah(){
		List<Pembayaran> hasil = penagihanService.cariPembayaranByNomerNasabah("N-123");
		Assert.assertTrue(hasil.size() == 0);
	}
}
