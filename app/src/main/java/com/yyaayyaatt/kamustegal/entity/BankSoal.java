package com.yyaayyaatt.kamustegal.entity;

public class BankSoal {

    public int id;
    public String pertanyaan;
    public String pil1;
    public String pil2;
    public String pil3;
    public String pil4;
    public String pil5;
    public int gambar;
    public String jawaban_benar;
    public String kategori;//id matematika, id bahasa, dll
    public String jenis;//pilgan, isian
    public String level;//mudah, sedang, susah

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getPil1() {
        return pil1;
    }

    public void setPil1(String pil1) {
        this.pil1 = pil1;
    }

    public String getPil2() {
        return pil2;
    }

    public void setPil2(String pil2) {
        this.pil2 = pil2;
    }

    public String getPil3() {
        return pil3;
    }

    public void setPil3(String pil3) {
        this.pil3 = pil3;
    }

    public String getPil4() {
        return pil4;
    }

    public void setPil4(String pil4) {
        this.pil4 = pil4;
    }

    public String getPil5() {
        return pil5;
    }

    public void setPil5(String pil5) {
        this.pil5 = pil5;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getJawaban_benar() {
        return jawaban_benar;
    }

    public void setJawaban_benar(String jawaban_benar) {
        this.jawaban_benar = jawaban_benar;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
