/*
 * Sifa Poliklinigi Bilgi Sistemi - Veritabani Kayit Ekleme ( db- - KayitEkleme )
 * Bu class fonksiyonlar ile cesitli tablolara fonksiyonlara girilen parametreler ile kayıt ekler.
 * Burada Yapilan Islemler; Veritabanina Kayit Ekleme
 */
package db;

/**
 *
 * @author burhan
 */
import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

public class KayitEkleme extends Configuration {

    //bu fonksiyon poliklinkler tablosuna yeni kayıt ekler
    public void poliklinikEkle(int no, String ad, int ucret) {

        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);

            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("INSERT INTO HR.POLIKLINIKLER (POLIKLINIK_ID, POLIKLINIK_ADI, MUAYENE_UCRETİ,KAYIT_TARİHİ) VALUES ('" + no + "','" + ad + "','" + ucret + "',TO_DATE('2016-05-01 06:35:37', 'YYYY-MM-DD HH24:MI:SS'))");
            JOptionPane.showMessageDialog(null, "Yeni Poliklinik Oluşturuldu.", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz.En Az Bir Doktor Seçmelisiniz!!! " + e, "Sonuç", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    //bu fonksiyon doktorlar tablosuna yeni kayıt ekler
    public void DoktorEkle(int no, String ad, String soyad, int tckn, int brans, int telefon, String email, String username, String sifre, int poliklinik, String unvan) {

        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);

            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("INSERT INTO HR.DOKTORLAR (DOKTOR_ID, ADI, SOYADI, TC_NO, BRANS_ID, TELEFON, MAIL, KULLANICI_ADI, KULLANICI_SIFRE, POLIKLINIK_ID, UNVAN) VALUES ('" + no + "','" + ad + "','" + soyad + "','" + tckn + "','" + brans + "','" + telefon + "','" + email + "','" + username + "','" + sifre + "','" + poliklinik + "','" + unvan + "')");
            JOptionPane.showMessageDialog(null, "Yeni Doktor Bilgileri Kaydedildi..", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz!!! " + e, "Sonuç", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    //bu fonksiyon yeni hasta kaydi olusturur.
    public void hastaEkle(String ad, String soyad, long tckn, String adres, long tel) {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);

            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("INSERT INTO HR.HASTALAR (HASTA_ID, ADI, SOYADI, TC_NO, ADRES, TELEFON, DOSYA_ID) VALUES ('" + (int) (Math.random() * 100 + 1) + "','" + ad + "','" + soyad + "','" + tckn + "','" + adres + "','" + tel + "','" + (int) (Math.random() * 1000 + 100) + "')");
            JOptionPane.showMessageDialog(null, "Yeni Hasta Kaydedildi..", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz!!! " + e, "Sonuç", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    //bu fonksiyon randevu kaydediyor
    public void randevuKaydet(int hastaId, String poliklinikAdi, String doktorAdi, int gun, String saat) {
        try {
            int r = (int) (Math.random() * 100 + 1);
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);

            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("INSERT INTO HR.RANDEVULAR (RANDEVU_ID,HASTA_ID,DOKTOR_ID,POLIKLINIK_ID,GUN,SAAT,UCRET) VALUES ('" + r + "','" + hastaId + "' ,(SELECT DOKTOR_ID FROM HR.DOKTORLAR d WHERE d.ADI='" + doktorAdi + "'),(SELECT p.POLIKLINIK_ID FROM HR.POLIKLINIKLER p WHERE p.POLIKLINIK_ADI='" + poliklinikAdi + "'),'" + gun + "','" + saat + "',(SELECT p.MUAYENE_UCRETİ FROM HR.POLIKLINIKLER p WHERE p.POLIKLINIK_ADI='" + poliklinikAdi + "'))");

            JOptionPane.showMessageDialog(null, "Yeni Randevu Kaydedildi. Randevu Numarası: " + r, "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz!!! " + e, "Sonuç", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    //muayene tamamlandiginda dosyaya yeni kayit ekleniyor
    public void dosyaKaydet(int hastaId, int doktorId, int randevuId, String teshis, String aciklama) {

        try {
            int r = (int) (Math.random() * 100 + 1);
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);

            conn = ods.getConnection();
            Statement stmt = conn.createStatement();

            rset = stmt.executeQuery("INSERT INTO HR.DOSYALAR (DOSYA_ID,HASTA_ID,DOKTOR_ID,RANDEVU_ID,TESHIS,ACIKLAMA) VALUES ('" + r + "','" + hastaId + "' ,'" + doktorId + "' ,'" + randevuId + "','" + teshis + "','" + aciklama + "')");

            JOptionPane.showMessageDialog(null, "Muayene Tamamlandı.", "İşlem Başarılı", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz!!! " + e, "Sonuç", JOptionPane.INFORMATION_MESSAGE);

        }
    }

}
