/*
 * Sifa Poliklinigi Bilgi Sistemi - Veritabani Kayit Sorgulama ( db- - KayitSorgula )
 * Bu class fonskiyonlar ile cesitli tablolarda spesifik aramalar yapar.
 * Burada Yapilan Islemler; Veritabaninda Kayit Sorgulama
 */
package db;

/**
 *
 * @author burhan
 */

import static db.Configuration.conn;
import static db.Configuration.connection_string;
import static db.Configuration.rset;
import java.sql.Statement;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author burhan
 */
public class KayitSorgula extends Configuration {

    //global degiskenimiz
    public static String doktorId;
    public String hid,adi,soyadi;
    public String hid2,hadi2,hsoyadi2,hdosyaId2;
    
    //global degiskenimiz
    
    //bu fonksyion poliklinik doktor ve gün bilgileri ile randevu tablosunda sorgulama yapmaktadır.
    public String[] randevuSorgula(String poliklinik, String doktor, int gun) {

        String saat[] = new String[10];
      
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);

            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT r.SAAT FROM HR.RANDEVULAR r ,HR.DOKTORLAR d, HR.POLIKLINIKLER p"
                    + " WHERE r.DOKTOR_ID= d.DOKTOR_ID AND r.POLIKLINIK_ID = p.POLIKLINIK_ID "
                    + "AND r.DOKTOR_ID = (SELECT DOKTOR_ID FROM HR.DOKTORLAR WHERE ADI='" + doktor + "') "
                    + "AND r.POLIKLINIK_ID = (SELECT POLIKLINIK_ID FROM HR.POLIKLINIKLER WHERE POLIKLINIK_ADI = '" + poliklinik + "' ) "
                    + "AND r.GUN='" + gun + "' ");

            int i = 0;
            
            while (rset.next()) {

                saat[i] = rset.getString(1);
                i++;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz. " + e, "Sonuç", JOptionPane.INFORMATION_MESSAGE);

        }

        return saat;
    }

    public void doktorSorgula(String doktorAdi) {

    }

    public void odemeSorgula(String hastaAdi) {

    }
    
    
    //bu fonksiyon tckn ile hasta sorgusu yapiyor
    public void hastaSorgula (long tckn) {
        
        try
        {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);
 
            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM HR.HASTALAR WHERE TC_NO='"+tckn+"'");
 
            indis = 0;
 
          while(rset.next()){

           hid=rset.getString(1);
          adi=rset.getString(2);
          soyadi=rset.getString(3);
            
            JOptionPane.showMessageDialog(null, hid+" ' NUMARALI " +adi +" "+soyadi , "Hasta Kayıtlı" , JOptionPane.INFORMATION_MESSAGE);

          }
          

           }     
 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz.", "Sonuç" , JOptionPane.INFORMATION_MESSAGE);
       
        }
    }
    
       public void randevuDogrula(int randevuId) {

 try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);

            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM HR.RANDEVULAR r , HR.HASTALAR h WHERE h.HASTA_ID = r.HASTA_ID AND r.RANDEVU_ID='"+randevuId+"' ");

            int i = 0;
            
            while (rset.next()) {

                doktorId=rset.getString(3);
              hid2=rset.getString(2);
          hadi2=rset.getString(8);
          hsoyadi2=rset.getString(9);
          hdosyaId2=rset.getString(14);  
            
            }
            if (hid2!=null){
            JOptionPane.showMessageDialog(null, hid2+" ' NUMARALI " +hadi2 +" "+hsoyadi2 , " Kişinin Randevusu Kayıtlı" , JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                
              JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz. " , "Sonuç", JOptionPane.INFORMATION_MESSAGE);
            }
          

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz. " + e, "Sonuç", JOptionPane.INFORMATION_MESSAGE);

        }

       
    }
       
       
        
       
    
    
      

    
    

}
