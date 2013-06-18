package com.artivisi.penagihan.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;


@Embeddable
public class TagihanPK implements Serializable {
    private String kodeCabang;
    private String nomerBooking;

    public String getKodeCabang() {
        return kodeCabang;
    }

    public void setKodeCabang(String kodeCabang) {
        this.kodeCabang = kodeCabang;
    }

    public String getNomerBooking() {
        return nomerBooking;
    }

    public void setNomerBooking(String nomerBooking) {
        this.nomerBooking = nomerBooking;
    }
    
    
}
