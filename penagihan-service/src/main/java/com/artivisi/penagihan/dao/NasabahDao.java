package com.artivisi.penagihan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.artivisi.penagihan.domain.Nasabah;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("nasabahDaoAsli")
public class NasabahDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void simpan(Nasabah n) {
        if (n.getId() == null) {
            entityManager.persist(n);
        } else {
            entityManager.merge(n);
        }
    }

    public Nasabah findNasabahById(String id) {
        return entityManager.find(Nasabah.class, id);
    }

	@SuppressWarnings("unchecked")
	public Nasabah findNasabahByNomer(String nomer) {
		if(nomer == null || nomer.trim().length() < 1){
			return null;
		}
		
		List<Nasabah> hasil = entityManager.createQuery("select n from Nasabah n where n.nomer = :nomer")
				.setParameter("nomer", nomer)
				.getResultList();
		
		if(hasil.size() == 0){
			return null;
		}
		
		if(hasil.size() > 1){
			throw new IllegalStateException("Nasabah dengan nomer "+nomer+" duplikat");
		}
		
		return hasil.get(0);
		
	}
}
