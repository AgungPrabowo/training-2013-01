package com.artivisi.penagihan.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_tagihan")
public class Tagihan {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "id_nasabah", nullable = false)
    private Nasabah nasabah;
    
    @Column(name = "tanggal_jatuh_tempo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tanggalJatuhTempo;
    
    private BigDecimal nilai;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status_tagihan", nullable = false)
    private StatusTagihan status = StatusTagihan.BELUM_DIBAYAR;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public Date getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public StatusTagihan getStatus() {
        return status;
    }

    public void setStatus(StatusTagihan status) {
        this.status = status;
    }
    
    
}
