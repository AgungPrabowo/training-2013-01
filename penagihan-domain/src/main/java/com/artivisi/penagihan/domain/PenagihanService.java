package com.artivisi.penagihan.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PenagihanService {
    void simpan(Nasabah n);
    Nasabah cariNasabahById(String id);
    Nasabah cariNasabahByNomer(String nomer);
    Long hitungSemuaNasabah();
    List<Nasabah> cariSemuaNasabah(Integer start, Integer rows);
    void hapus(Nasabah n);
    
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
    
    BigDecimal totalOutstandingByNasabah(Nasabah n);
    Map<String, BigDecimal> rekapOutstandingMap();
    List<RekapOutstanding> rekapOutstandingObject();
    
    List<Tagihan> cariTagihanByNomerNasabah(String nomer);
    
    List<Pembayaran> cariPembayaranByNomerNasabah(String nomer);
    
    void simpan(Pembayaran p);
    
    List<Menu> cariSemuaMenu();
    List<Menu> getTreeNode(Menu menu);
    List<Menu> getParent();
}
