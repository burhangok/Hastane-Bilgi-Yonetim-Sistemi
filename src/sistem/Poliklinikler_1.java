/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author burhan
 */
@Entity
@Table(name = "POLIKLINIKLER", catalog = "", schema = "HR")
@NamedQueries({
    @NamedQuery(name = "Poliklinikler_1.findAll", query = "SELECT p FROM Poliklinikler_1 p"),
    @NamedQuery(name = "Poliklinikler_1.findByPoliklinikId", query = "SELECT p FROM Poliklinikler_1 p WHERE p.poliklinikId = :poliklinikId"),
    @NamedQuery(name = "Poliklinikler_1.findByPoliklinikAdi", query = "SELECT p FROM Poliklinikler_1 p WHERE p.poliklinikAdi = :poliklinikAdi"),
    @NamedQuery(name = "Poliklinikler_1.findByMuayeneUcreti", query = "SELECT p FROM Poliklinikler_1 p WHERE p.muayeneUcreti = :muayeneUcreti"),
    @NamedQuery(name = "Poliklinikler_1.findByKayitTariHi", query = "SELECT p FROM Poliklinikler_1 p WHERE p.kayitTariHi = :kayitTariHi")})
public class Poliklinikler_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "POLIKLINIK_ID")
    private BigDecimal poliklinikId;
    @Basic(optional = false)
    @Column(name = "POLIKLINIK_ADI")
    private String poliklinikAdi;
    @Basic(optional = false)
    @Column(name = "MUAYENE_UCRET\u0130")
    private BigInteger muayeneUcreti;
    @Basic(optional = false)
    @Column(name = "KAYIT_TAR\u0130H\u0130")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kayitTariHi;

    public Poliklinikler_1() {
    }

    public Poliklinikler_1(BigDecimal poliklinikId) {
        this.poliklinikId = poliklinikId;
    }

    public Poliklinikler_1(BigDecimal poliklinikId, String poliklinikAdi, BigInteger muayeneUcreti, Date kayitTariHi) {
        this.poliklinikId = poliklinikId;
        this.poliklinikAdi = poliklinikAdi;
        this.muayeneUcreti = muayeneUcreti;
        this.kayitTariHi = kayitTariHi;
    }

    public BigDecimal getPoliklinikId() {
        return poliklinikId;
    }

    public void setPoliklinikId(BigDecimal poliklinikId) {
        BigDecimal oldPoliklinikId = this.poliklinikId;
        this.poliklinikId = poliklinikId;
        changeSupport.firePropertyChange("poliklinikId", oldPoliklinikId, poliklinikId);
    }

    public String getPoliklinikAdi() {
        return poliklinikAdi;
    }

    public void setPoliklinikAdi(String poliklinikAdi) {
        String oldPoliklinikAdi = this.poliklinikAdi;
        this.poliklinikAdi = poliklinikAdi;
        changeSupport.firePropertyChange("poliklinikAdi", oldPoliklinikAdi, poliklinikAdi);
    }

    public BigInteger getMuayeneUcreti() {
        return muayeneUcreti;
    }

    public void setMuayeneUcreti(BigInteger muayeneUcreti) {
        BigInteger oldMuayeneUcreti = this.muayeneUcreti;
        this.muayeneUcreti = muayeneUcreti;
        changeSupport.firePropertyChange("muayeneUcreti", oldMuayeneUcreti, muayeneUcreti);
    }

    public Date getKayitTariHi() {
        return kayitTariHi;
    }

    public void setKayitTariHi(Date kayitTariHi) {
        Date oldKayitTariHi = this.kayitTariHi;
        this.kayitTariHi = kayitTariHi;
        changeSupport.firePropertyChange("kayitTariHi", oldKayitTariHi, kayitTariHi);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poliklinikId != null ? poliklinikId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poliklinikler_1)) {
            return false;
        }
        Poliklinikler_1 other = (Poliklinikler_1) object;
        if ((this.poliklinikId == null && other.poliklinikId != null) || (this.poliklinikId != null && !this.poliklinikId.equals(other.poliklinikId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistem.Poliklinikler_1[ poliklinikId=" + poliklinikId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
