package com.artivisi.penagihan.dao;

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
}
