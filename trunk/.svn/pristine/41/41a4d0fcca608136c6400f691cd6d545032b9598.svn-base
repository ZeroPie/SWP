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
@Table(name = "UeberweisungsVorlage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UeberweisungsVorlage.findAll", query = "SELECT u FROM UeberweisungsVorlage u"),
    @NamedQuery(name = "UeberweisungsVorlage.findByUvid", query = "SELECT u FROM UeberweisungsVorlage u WHERE u.uvid = :uvid"),
    @NamedQuery(name = "UeberweisungsVorlage.findByDatum", query = "SELECT u FROM UeberweisungsVorlage u WHERE u.datum = :datum"),
    @NamedQuery(name = "UeberweisungsVorlage.findByErlaeuterung", query = "SELECT u FROM UeberweisungsVorlage u WHERE u.erlaeuterung = :erlaeuterung"),
    @NamedQuery(name = "UeberweisungsVorlage.findByBetrag", query = "SELECT u FROM UeberweisungsVorlage u WHERE u.betrag = :betrag")})
public class UeberweisungsVorlage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uvid")
    private Integer uvid;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "erlaeuterung")
    private String erlaeuterung;
    @Basic(optional = false)
    @Column(name = "betrag")
    private double betrag;
    @JoinColumn(name = "kunde", referencedColumnName = "kid")
    @ManyToOne(optional = false)
    private Kunde kunde;
    @JoinColumn(name = "vonkonto", referencedColumnName = "ktoid")
    @ManyToOne(optional = false)
    private Konto vonkonto;

    public UeberweisungsVorlage() {
    }

    public UeberweisungsVorlage(Integer uvid) {
        this.uvid = uvid;
    }

    public UeberweisungsVorlage(Integer uvid, Date datum, String erlaeuterung, double betrag) {
        this.uvid = uvid;
        this.datum = datum;
        this.erlaeuterung = erlaeuterung;
        this.betrag = betrag;
    }

    public Integer getUvid() {
        return uvid;
    }

    public void setUvid(Integer uvid) {
        this.uvid = uvid;
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

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uvid != null ? uvid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UeberweisungsVorlage)) {
            return false;
        }
        UeberweisungsVorlage other = (UeberweisungsVorlage) object;
        if ((this.uvid == null && other.uvid != null) || (this.uvid != null && !this.uvid.equals(other.uvid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.UeberweisungsVorlage[ uvid=" + uvid + " ]";
    }
    
}
