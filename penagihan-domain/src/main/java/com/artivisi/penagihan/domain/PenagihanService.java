package com.artivisi.penagihan.domain;

import java.util.List;

public interface PenagihanService {
    void simpan(Nasabah n);
    Nasabah cariNasabahById(String id);
    Nasabah cariNasabahByNomer(String nomer);
    Long hitungSemuaNasabah();
    List<Nasabah> cariSemuaNasabah(Integer start, Integer rows);
}
