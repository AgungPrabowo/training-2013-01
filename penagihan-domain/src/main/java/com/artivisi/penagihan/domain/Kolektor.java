package com.artivisi.penagihan.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name="m_kolektor")
public class Kolektor {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "nama_kolektor", nullable = false, unique = true)
    private String nama;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "m_nasabah_kolektor",
            joinColumns = @JoinColumn(name = "id_kolektor", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_nasabah", nullable = false)
    )
    private List<Nasabah> daftarNasabah = new ArrayList<Nasabah>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Nasabah> getDaftarNasabah() {
        return daftarNasabah;
    }

    public void setDaftarNasabah(List<Nasabah> daftarNasabah) {
        this.daftarNasabah = daftarNasabah;
    }
    
    
}
