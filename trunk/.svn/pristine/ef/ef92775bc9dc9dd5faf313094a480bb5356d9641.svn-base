/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bks.datenhaltung.bksdbmodel.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mhenk
 */
@Entity
@Table(name = "Zahlungsverkehr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zahlungsverkehr.findAll", query = "SELECT z FROM Zahlungsverkehr z"),
    @NamedQuery(name = "Zahlungsverkehr.findByZid", query = "SELECT z FROM Zahlungsverkehr z WHERE z.zid = :zid"),
    @NamedQuery(name = "Zahlungsverkehr.findByDatum", query = "SELECT z FROM Zahlungsverkehr z WHERE z.datum = :datum"),
    @NamedQuery(name = "Zahlungsverkehr.findByErlaeuterung", query = "SELECT z FROM Zahlungsverkehr z WHERE z.erlaeuterung = :erlaeuterung"),
    @NamedQuery(name = "Zahlungsverkehr.findByHaben", query = "SELECT z FROM Zahlungsverkehr z WHERE z.haben = :haben"),
    @NamedQuery(name = "Zahlungsverkehr.findBySoll", query = "SELECT z FROM Zahlungsverkehr z WHERE z.soll = :soll"),
    @NamedQuery(name = "Zahlungsverkehr.findByAusgedruckt", query = "SELECT z FROM Zahlungsverkehr z WHERE z.ausgedruckt = :ausgedruckt")})
public class Zahlungsverkehr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zid")
    private Integer zid;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "erlaeuterung")
    private String erlaeuterung;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "haben")
    private Double haben;
    @Column(name = "soll")
    private Double soll;
    @Basic(optional = false)
    @Column(name = "ausgedruckt")
    private boolean ausgedruckt;
    @JoinColumn(name = "konto", referencedColumnName = "ktoid")
    @ManyToOne(optional = false)
    private Konto konto;

    public Zahlungsverkehr() {
    }

    public Zahlungsverkehr(Integer zid) {
        this.zid = zid;
    }

    public Zahlungsverkehr(Integer zid, Date datum, String erlaeuterung, boolean ausgedruckt) {
        this.zid = zid;
        this.datum = datum;
        this.erlaeuterung = erlaeuterung;
        this.ausgedruckt = ausgedruckt;
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getErlaeuterung() {
        return erlaeuterung;
    }

    public void setErlaeuterung(String erlaeuterung) {
        this.erlaeuterung = erlaeuterung;
    }

    public Double getHaben() {
        return haben;
    }

    public void setHaben(Double haben) {
        this.haben = haben;
    }

    public Double getSoll() {
        return soll;
    }

    public void setSoll(Double soll) {
        this.soll = soll;
    }

    public boolean getAusgedruckt() {
        return ausgedruckt;
    }

    public void setAusgedruckt(boolean ausgedruckt) {
        this.ausgedruckt = ausgedruckt;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zid != null ? zid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zahlungsverkehr)) {
            return false;
        }
        Zahlungsverkehr other = (Zahlungsverkehr) object;
        if ((this.zid == null && other.zid != null) || (this.zid != null && !this.zid.equals(other.zid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.Zahlungsverkehr[ zid=" + zid + " ]";
    }
    
}
