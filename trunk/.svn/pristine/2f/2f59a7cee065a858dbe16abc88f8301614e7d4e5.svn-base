/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bks.datenhaltung.bksdbmodel.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mhenk
 */
@Entity
@Table(name = "Antrag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antrag.findAll", query = "SELECT a FROM Antrag a"),
    @NamedQuery(name = "Antrag.findByAtid", query = "SELECT a FROM Antrag a WHERE a.atid = :atid"),
    @NamedQuery(name = "Antrag.findByTyp", query = "SELECT a FROM Antrag a WHERE a.typ = :typ"),
    @NamedQuery(name = "Antrag.findByStatus", query = "SELECT a FROM Antrag a WHERE a.status = :status")})
public class Antrag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "atid")
    private Integer atid;
    @Basic(optional = false)
    @Column(name = "typ")
    private String typ;
    @Basic(optional = false)
    @Lob
    @Column(name = "daten")
    private String daten;
    @Basic(optional = false)
    @Lob
    @Column(name = "kommentare")
    private String kommentare;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "admin", referencedColumnName = "aid")
    @ManyToOne
    private Admin admin;
    @JoinColumn(name = "sachbearbeiter", referencedColumnName = "sid")
    @ManyToOne
    private Sachbearbeiter sachbearbeiter;
    @JoinColumn(name = "manager", referencedColumnName = "mid")
    @ManyToOne
    private Manager manager;

    public Antrag() {
    }

    public Antrag(Integer atid) {
        this.atid = atid;
    }

    public Antrag(Integer atid, String typ, String daten, String kommentare, String status) {
        this.atid = atid;
        this.typ = typ;
        this.daten = daten;
        this.kommentare = kommentare;
        this.status = status;
    }

    public Integer getAtid() {
        return atid;
    }

    public void setAtid(Integer atid) {
        this.atid = atid;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getDaten() {
        return daten;
    }

    public void setDaten(String daten) {
        this.daten = daten;
    }

    public String getKommentare() {
        return kommentare;
    }

    public void setKommentare(String kommentare) {
        this.kommentare = kommentare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Sachbearbeiter getSachbearbeiter() {
        return sachbearbeiter;
    }

    public void setSachbearbeiter(Sachbearbeiter sachbearbeiter) {
        this.sachbearbeiter = sachbearbeiter;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atid != null ? atid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antrag)) {
            return false;
        }
        Antrag other = (Antrag) object;
        if ((this.atid == null && other.atid != null) || (this.atid != null && !this.atid.equals(other.atid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bks.datenhaltung.bksdbmodel.entities.Antrag[ atid=" + atid + " ]";
    }
    
}
