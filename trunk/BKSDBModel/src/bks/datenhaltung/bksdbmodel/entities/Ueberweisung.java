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
@Table(name = "Ueberweisung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ueberweisung.findAll", query = "SELECT u FROM Ueberweisung u"),
    @NamedQuery(name = "Ueberweisung.findByUbid", query = "SELECT u FROM Ueberweisung u WHERE u.ubid = :ubid"),
    @NamedQuery(name = "Ueberweisung.findByBetrag", query = "SELECT u FROM Ueberweisung u WHERE u.betrag = :betrag"),
    @NamedQuery(name = "Ueberweisung.findByVerwendungszweck", query = "SELECT u FROM Ueberweisung u WHERE u.verwendungszweck = :verwendungszweck"),
    @NamedQuery(name = "Ueberweisung.findByDatum", query = "SELECT u FROM Ueberweisung u WHERE u.datum = :datum"),
    @NamedQuery(name = "Ueberweisung.findByStatus", query = "SELECT u FROM Ueberweisung u WHERE u.status = :status")})
public class Ueberweisung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ubid")
    private Integer ubid;
    @Basic(optional = false)
    @Column(name = "betrag")
    private double betrag;
    @Column(name = "verwendungszweck")
    private String verwendungszweck;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "kunde", referencedColumnName = "kid")
    @ManyToOne(optional = false)
    private Kunde kunde;
    @JoinColumn(name = "vonkonto", referencedColumnName = "ktoid")
    @ManyToOne(optional = false)
    private Konto vonkonto;
    @JoinColumn(name = "zukonto", referencedColumnName = "ktoid")
    @ManyToOne(optional = false)
    private Konto zukonto;

    public Ueberweisung() {
    }

    public Ueberweisung(Integer ubid) {
        this.ubid = ubid;
    }

    public Ueberweisung(Integer ubid, double betrag, Date datum, String status) {
        this.ubid = ubid;
        this.betrag = betrag;
        this.datum = datum;
        this.status = status;
    }

    public Integer getUbid() {
        return ubid;
    }

    public void setUbid(Integer ubid) {
        this.ubid = ubid;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public String getVerwendungszweck() {
        return verwendungszweck;
    }

    public void setVerwendungszweck(String verwendungszweck) {
        this.verwendungszweck = verwendungszweck;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Konto getVonkonto() {
        return vonkonto;
    }

    public void setVonkonto(Konto vonkonto) {
        this.vonkonto = vonkonto;
    }

    public Konto getZukonto() {
        return zukonto;
    }

    public void setZukonto(Konto zukonto) {
        this.zukonto = zukonto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubid != null ? ubid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ueberweisung)) {
            return false;
        }
        Ueberweisung other = (Ueberweisung) object;
        if ((this.ubid == null && other.ubid != null) || (this.ubid != null && !this.ubid.equals(other.ubid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.Ueberweisung[ ubid=" + ubid + " ]";
    }
    
}
