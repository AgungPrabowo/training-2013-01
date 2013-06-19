package com.artivisi.penagihan.domain;

import java.math.BigDecimal;

public class RekapOutstanding {
	private Nasabah nasabah;
	private BigDecimal outstanding;
	
	public RekapOutstanding() {
		// default constructor sebagai pelengkap saja
	}

	public RekapOutstanding(Nasabah nasabah, BigDecimal outstanding) {
		this.nasabah = nasabah;
		this.outstanding = outstanding;
	}

	public Nasabah getNasabah() {
		return nasabah;
	}

	public void setNasabah(Nasabah nasabah) {
		this.nasabah = nasabah;
	}

	public BigDecimal getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(BigDecimal outstanding) {
		this.outstanding = outstanding;
	}
	
	
}
