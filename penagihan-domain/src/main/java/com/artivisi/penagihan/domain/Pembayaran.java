package com.artivisi.penagihan.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_pembayaran")
public class Pembayaran extends Booking {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "kode_cabang", referencedColumnName = "kode_cabang", nullable = false),
        @JoinColumn(name = "nomer_booking", referencedColumnName = "nomer_booking", nullable = false)
    })
    private Tagihan tagihan;
    @Column(name = "waktu_transaksi", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuTransaksi;
    private BigDecimal nilai;
}
