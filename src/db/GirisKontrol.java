/*
 * Sifa Poliklinigi Bilgi Sistemi - Veritabani Giris Kontrolu ( db- - GirisKontrol )
 * Bu class sistem ile giris formundaki verileri db de ki veriler ile kontrol edip yonlendirme saglar.
 * Burada Yapilan Islemler; Veritabani baglantisi
 */
package db;

/**
 *
 * @author burhan
 */


import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;
import sistem.SistemAnaEkran;
import doktor.DoktorAnaEkran;
import gorevli.GorevliAnaEkran;
import muhasebe.MuhasebeAnaEkran;



public class GirisKontrol extends Configuration{
   
    //değerine göre yetkilendirme yapacağımız değişken
    public int kullaniciGrup;
    public int doktorId,employeeId;

    //siniflar ile etkilesim icin nesnelerimiz olusturuyoruz
   
    SistemAnaEkran sistem = new SistemAnaEkran();
    DoktorAnaEkran doktor = new DoktorAnaEkran();
    GorevliAnaEkran gorevli = new GorevliAnaEkran();
    MuhasebeAnaEkran muhasebe = new MuhasebeAnaEkran();
    
    //giris formdan alinan bilgiler ile veritabanindan kullanici belirleniyor.
    public  void bilgileriKontrolEt(String kAdi, String kSifre) 
    {
        
        try
        {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);
 
            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT TYPE_ID FROM HR.KULLANICILAR WHERE KULLANICI_ADI='"+kAdi+"' AND KULLANICI_SIFRE='"+kSifre+"'");
 
            indis = 0;
 
          while(rset.next()){

              this.kullaniciGrup=Integer.parseInt(rset.getString(1));
             
          }
          
          switch(kullaniciGrup)    {
            case 101 : sistem.setVisible(true);
            break;
            
            case 102 : gorevli.setVisible(true);
            break;
            
            case 103 : muhasebe.setVisible(true);
            break;
            
            case 104 : doktor.setVisible(true);
            break;
            default  : JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz.", "Sonuç" , JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            break;
            
            
            
        } 
        
        }     
 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz.", "Sonuç" , JOptionPane.INFORMATION_MESSAGE);
       
        }
 
    }
    
     
        
    }
    

 
 

    
  
