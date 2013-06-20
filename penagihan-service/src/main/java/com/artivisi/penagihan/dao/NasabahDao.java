package com.artivisi.penagihan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.artivisi.penagihan.domain.Nasabah;

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

    public void hapus(Nasabah n) {
        entityManager.detach(n);
        entityManager.remove(n);
        entityManager.flush();
    }

    public Nasabah findNasabahById(String id) {
        return entityManager.find(Nasabah.class, id);
    }

    @SuppressWarnings("unchecked")
    public Nasabah findNasabahByNomer(String nomer) {
        if (nomer == null || nomer.trim().length() < 1) {
            return null;
        }

        List<Nasabah> hasil = entityManager.createQuery("select n from Nasabah n where n.nomer = :nomer")
                .setParameter("nomer", nomer)
                .getResultList();

        if (hasil.size() == 0) {
            return null;
        }

        if (hasil.size() > 1) {
            throw new IllegalStateException("Nasabah dengan nomer " + nomer + " duplikat");
        }

        return hasil.get(0);

    }

    public Long hitungSemua() {
        return (Long) entityManager.createQuery("select count(n) from Nasabah n")
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Nasabah> cariSemua(Integer start, Integer rows) {
        if (start == null || start < 0) {
            start = 0;
        }

        if (rows == null || rows < 1) {
            rows = 10;
        }

        return entityManager.createQuery("select n from Nasabah n order by n.nomer")
                .setFirstResult(start)
                .setMaxResults(rows)
                .getResultList();
    }
}
