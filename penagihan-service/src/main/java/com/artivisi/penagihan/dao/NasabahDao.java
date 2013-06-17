package com.artivisi.penagihan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.artivisi.penagihan.domain.Nasabah;

public class NasabahDao {
	
	private DataSource dataSource;
	
	public NasabahDao(DataSource ds){
		this.dataSource = ds;
	}
	
	public void simpan(Nasabah n) throws Exception {
		String sql = "insert into m_nasabah(nomer,nama) values (?,?)";
		
		Connection connection = dataSource.getConnection();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "N-001");
		ps.setString(2, "Nasabah 001");
		ps.executeUpdate();
		
		connection.close();
	}
	
	public Nasabah findNasabahById(String id){
		return null;
	}
	
	
}
