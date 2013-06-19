package com.artivisi.penagihan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.penagihan.dao.NasabahDao;
import com.artivisi.penagihan.domain.Nasabah;
import com.artivisi.penagihan.domain.PenagihanService;

@Service("penagihanService") 
@Transactional(propagation=Propagation.REQUIRED)
public class PenagihanServiceImpl implements PenagihanService {

	@Autowired private NasabahDao nasabahDao;
	
	public void simpan(Nasabah n) {
		nasabahDao.simpan(n);
	}
	
	public Nasabah cariNasabahById(String id) {
		return nasabahDao.findNasabahById(id);
	}

	public Nasabah cariNasabahByNomer(String nomer) {
		return nasabahDao.findNasabahByNomer(nomer);
	}

	public Long hitungSemuaNasabah() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Nasabah> cariSemuaNasabah(Integer start, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

}
