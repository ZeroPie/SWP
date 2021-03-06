package bks.fachlogik.kundesteuerung.grenz;

import java.util.Date;

public class UeberweisungsvorlageGrenz {
    
    private int     uvid;
    private double  betrag;
    private Date    datum;
    private int     vonkonto;
    private int     kid;
    private String  verwendungszweck;

    public int getUvid() {
        return uvid;
    }

    public void setUvid(int uvid) {
        this.uvid = uvid;
    }

    public double getBetrag() {
        return betrag;
    }

    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getVonkonto() {
        return vonkonto;
    }

    public void setVonkonto(int vonkonto) {
        this.vonkonto = vonkonto;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getVerwendungszweck() {
        return verwendungszweck;
    }

    public void setVerwendungszweck(String verwendungszweck) {
        this.verwendungszweck = verwendungszweck;
    }
}
