package com.artivisi.penagihan.domain;

import java.util.Date;
import java.util.List;

public interface PenagihanService {
    void simpan(Nasabah n);
    Nasabah cariNasabahById(String id);
    Nasabah cariNasabahByNomer(String nomer);
    Long hitungSemuaNasabah();
    List<Nasabah> cariSemuaNasabah(Integer start, Integer rows);
    
    void simpan(Kolektor k);
    Kolektor cariKolektorById(String id);
    Long hitungSemuaKolektor();
    List<Kolektor> cariSemuaKolektor(Integer start, Integer rows);
    
    void simpan(Tagihan t);
    Tagihan cariTagihanById(TagihanPK id);
    Long hitungTagihanByPeriodeJatuhTempo(Date mulai, Date sampai);
    List<Tagihan> cariTagihanByPeriodeJatuhTempo(Date mulai, Date sampai, Integer start, Integer rows);
    Long hitungTagihanByNasabahDanStatus(Nasabah n, StatusTagihan status);
    List<Tagihan> cariTagihanByNasabahDanStatus(Nasabah n, StatusTagihan status, Integer start, Integer rows);
}
