package com.artivisi.penagihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.artivisi.penagihan.domain.Nasabah;
import com.artivisi.penagihan.domain.StatusTagihan;
import com.artivisi.penagihan.domain.Tagihan;

@Repository
public class TagihanDao {
	@PersistenceContext private EntityManager entityManager;
	
	public void simpan(Tagihan t){
		if(t.getId() == null) {
			entityManager.persist(t);
		} else {
			entityManager.merge(t);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tagihan> cariTagihanByNasabahDanStatus(Nasabah n,
			StatusTagihan status, Integer start, Integer rows) {
		if(start == null || start < 0){
			start = 0;
		}
		
		if(rows == null || rows < 1){
			rows = 10;
		}
		
		String jpql = "select t from Tagihan t " +
				"where t.nasabah.id = :idNasabah " +
				"and t.status = :status " +
				"order by t.tanggalJatuhTempo";
		
		
		return entityManager.createQuery(jpql)
				.setParameter("idNasabah", n.getId())
				.setParameter("status", status)
				.setFirstResult(start)
				.setMaxResults(rows)
				.getResultList();
	}
}
