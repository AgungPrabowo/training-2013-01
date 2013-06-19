package com.artivisi.penagihan.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Booking implements Serializable {
    
    private String user;
    
    @Column(name="waktu_booking")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waktuBooking;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getWaktuBooking() {
        return waktuBooking;
    }

    public void setWaktuBooking(Date waktuBooking) {
        this.waktuBooking = waktuBooking;
    }
    
    
}
