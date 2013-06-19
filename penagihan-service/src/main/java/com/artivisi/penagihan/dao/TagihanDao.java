package com.artivisi.penagihan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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
}
