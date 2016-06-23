/*
 * Sifa Poliklinigi Bilgi Sistemi - Veritabani Kayit Silme ( db- - KayitSilme )
 * Bu class fonksiyonlar ile cesitli tablolardaki kayitlari silme işlemlerini gerçekleştirir.
 * Burada Yapilan Islemler; Veritabanindaki Kaydi Silme
 */
package db;

/**
 *
 * @author burhan
 */
import static db.Configuration.conn;
import static db.Configuration.connection_string;
import static db.Configuration.rset;
import java.sql.*;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

public class KayitSilme extends Configuration {
    
    public void randevuSil (int randevuId) {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(connection_string);

            conn = ods.getConnection();
            Statement stmt = conn.createStatement();
            rset = stmt.executeQuery("DELETE FROM HR.RANDEVULAR r WHERE r.RANDEVU_ID='"+randevuId+"' ");

          
        

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Ediniz. " + e, "Sonuç", JOptionPane.INFORMATION_MESSAGE);

        }
    }
    
}
