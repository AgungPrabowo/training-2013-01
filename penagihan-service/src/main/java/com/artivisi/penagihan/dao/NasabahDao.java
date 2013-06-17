package com.artivisi.penagihan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.artivisi.penagihan.domain.Nasabah;

@Repository("nasabahDaoAsli")
public class NasabahDao {
	
	@Autowired private DataSource dataSource;
	
	public void simpan(Nasabah n) {
		String sql = "insert into m_nasabah(nomer,nama) values (?,?)";

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, "N-001");
			ps.setString(2, "Nasabah 001");
			ps.executeUpdate();
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Nasabah findNasabahById(String id){
		return null;
	}
	
	
}
