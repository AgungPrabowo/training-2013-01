package com.artivisi.penagihan.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "m_nasabah")
public class Nasabah {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @Column(nullable = false, unique = true)
    private String nomer;
    @Column(name = "nama", nullable = false)
    private String nama;
    
    @Lob
    private byte[] foto;
    
    @OneToMany(mappedBy = "nasabah")
    private List<Tagihan> daftarTagihan = new ArrayList<Tagihan>();

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

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public List<Tagihan> getDaftarTagihan() {
        return daftarTagihan;
    }

    public void setDaftarTagihan(List<Tagihan> daftarTagihan) {
        this.daftarTagihan = daftarTagihan;
    }
}
