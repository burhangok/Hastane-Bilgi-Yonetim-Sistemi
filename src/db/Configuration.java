/*
 * Sifa Poliklinigi Bilgi Sistemi - Veritabani Yapilandirma ( db- - Configuration )
 * Bu class sistem ile veritabani Oracle arasindaki baglantiyi saglar.
 * Burada Yapilan Islemler; Veritabani baglantisi
 */
package db;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author burhan
 */
public class Configuration {
    
     // -------- Global Degiskenler  -------- //
    
        public static   int indis, kayit_sayisi;
        public static   String connection_string = "jdbc:oracle:thin:system/bqb@localhost:1521:XE";
        public static   Connection conn;
        public static   ResultSet rset;
        
        // -------- Global Degiskenler  -------- //
 
    
    }
 

    
  
