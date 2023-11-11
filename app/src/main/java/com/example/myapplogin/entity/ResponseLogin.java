package com.example.myapplogin.entity;

public class ResponseLogin {
    private String KullaniciAdi;
    private String ID;
    private Boolean Sonuc ;

    public void setKullaniciAdi(String kullaniciAdi) {
        KullaniciAdi = kullaniciAdi;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setSonuc(Boolean sonuc) {
        Sonuc = sonuc;
    }

    public String getKullaniciAdi() {
        return KullaniciAdi;
    }

    public String getID() {
        return ID;
    }

    public Boolean getSonuc() {
        return Sonuc;
    }

}
