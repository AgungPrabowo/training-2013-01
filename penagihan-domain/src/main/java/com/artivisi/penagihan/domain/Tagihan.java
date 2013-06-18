package com.artivisi.penagihan.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_tagihan")
public class Tagihan extends Booking {

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name="kodeCabang", column=@Column(name="kode_cabang")),
        @AttributeOverride(name="nomerBooking", column=@Column(name="nomer_booking"))
    })
    private TagihanPK id;
    
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
