package com.artivisi.penagihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.artivisi.penagihan.domain.Pembayaran;

@Repository
public class PembayaranDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Pembayaran> cariPembayaranByNomerNasabah(String nomer){
		String jpql = "select p from Pembayaran p " +
				"inner join p.tagihan as tagihan " +
				"inner join tagihan.nasabah as nasabah " +
				"where p.tagihan.nasabah.nomer = :nomer";
		return entityManager.createQuery(jpql)
				.setParameter("nomer", nomer)
				.getResultList();
	}
}
