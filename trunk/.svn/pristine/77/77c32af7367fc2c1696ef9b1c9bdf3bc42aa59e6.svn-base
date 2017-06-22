package bks.fachlogik.kontosteuerung.impl;

import bks.datenhaltung.bksdbmodel.entities.Ueberweisung;
import bks.datenhaltung.bksdbmodel.impl.IDatabaseImpl;
import bks.datenhaltung.bksdbmodel.services.IDatabase;
import bks.datenhaltung.kontodaten.impl.IKontoServiceImpl;
import bks.datenhaltung.kontodaten.services.IKontoService;
import bks.fachlogik.kontosteuerung.grenz.UeberweisungGrenz;
import bks.fachlogik.kontosteuerung.services.IKontoSteuerung;
import bks.datenhaltung.sachbearbeiterdaten.impl.IUeberweisungsVorlageImpl;
import bks.datenhaltung.sachbearbeiterdaten.services.IUeberweisungsVorlage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Diese Klasse stellt Methoden zur Steuerung von Überweisungen bereit.
 * 
 * @author Barthélémy Bonhomme
 */
public class IKontoSteuerungImpl implements IKontoSteuerung {

    /**
     * Holt alle löschbaren Überweisungen und stellt diese als Grenzklassen für
     * die GUI bereit.
     * 
     * @author Barthélémy Bonhomme
     * @return Liste mit Überweisungen, falls kein Fehler auftritt,
     * null falls doch
     */
    @Override
    public List<UeberweisungGrenz> getLoeschbareUeberweisungen() {
        IDatabase db = new IDatabaseImpl();
        EntityManager em = db.getEntityManager();
        IKontoServiceImpl kontoService = new IKontoServiceImpl();
        kontoService.setEntityManager(em);
        
        List<Ueberweisung> uList = kontoService.getLoeschbareUeberweisungen();
        if(uList != null){
            ArrayList<UeberweisungGrenz> uGrenzList = new ArrayList<>();
            
            uList.forEach((u) -> {
                UeberweisungGrenz uG = new UeberweisungGrenz();
                uG.setBetrag(u.getBetrag());
                uG.setDatum(u.getDatum());
                uG.setKid(u.getKunde().getKid());
                uG.setStatus(u.getStatus());
                uG.setUbid(u.getUbid());
                uG.setVerwendungszweck(u.getVerwendungszweck());
                uG.setVonkonto(u.getVonkonto().getKtoid());
                uG.setZukonto(u.getZukonto().getKtoid());
                uGrenzList.add(uG);
            });
            
            return uGrenzList;
        }else {
            return null;
        }
    }

    /**
     * Erhält eine Liste von Überweisungen von der GUI und löscht diese unter
     * Verwendung der {@link IKontoServiceImpl} Klasse.
     * 
     * @author Barthélémy Bonhomme
     * @param uList Liste mit zu löschenden Überweisungen
     * @return false, falls ein Fehler aufgetreten ist, true falls alle 
     * Überweisungen gelöscht wurden.
     */
    @Override
    public boolean ueberweisungenLoeschen(List<UeberweisungGrenz> uList) {
        IDatabase db = new IDatabaseImpl();
        EntityManager em = db.getEntityManager();
        IKontoServiceImpl kontoService = new IKontoServiceImpl();
        kontoService.setEntityManager(em);
        
        em.getTransaction().begin();
        
        for(UeberweisungGrenz u : uList){
            if(!kontoService.ueberweisungLoeschen(u.getUbid())){
                em.getTransaction().rollback();
                return false;
            }
        }
        
        em.getTransaction().commit();
        
        return true;
    };

    /**
     * Fürt die Methode iKontoService.ueberweisungAusfuehren(ubid) mit einer
     * übergebenen UeberweisungsId aus
     *
     * @author Alexander Merkel
     * @param ubid UeberweisungsId der zu ueberweisenden Ueberweisung
     * @return true bei Erfolg, false bei Mißerfolg nach Datum
     */
    @Override
    public boolean ueberweisungAusfuehren(int ubid) {
        IDatabase db = new IDatabaseImpl();
        EntityManager em = db.getEntityManager();
        IKontoService iKontoService = new IKontoServiceImpl();
        iKontoService.setEntityManager(em);
        em.getTransaction().begin();

        if (iKontoService.ueberweisungAusfuehren(ubid)) {
            em.getTransaction().commit();
            return true;
        } else {
            em.getTransaction().rollback();
            return false;
        }

    }

    /**
     * Holt eine Liste aller wartenden Ueberweisungen vom einem Kunden mit
     * gegebener Kundennummer kid mithilfe von
     * IKontoService.getStornierbareUeberweisungen(kid), und speichert diese in
     * einer ArrayList von UeberweisungGrenz und sortiert diese ArrayList mit
     * Collections.sort nach Datum
     *
     * @author Alexander Merkel
     * @param kid Kundennummer
     * @return Liste aller Ueberweisungen eines Kunden als Grenzklassen sortiert
     * nach Datum
     */
    @Override
    public List<UeberweisungGrenz> getWartendeUeberweisungenByKid(int kid) {
        ArrayList<UeberweisungGrenz> ueberweisungsGrenzList = new ArrayList();

        IDatabase db = new IDatabaseImpl();
        EntityManager em = db.getEntityManager();
        IKontoService iKontoService = new IKontoServiceImpl();
        iKontoService.setEntityManager(em);
        try {
            List<Ueberweisung> listUeberweisung = iKontoService.getStornierbareUeberweisungen(kid);

            for (Ueberweisung u : listUeberweisung) {
                UeberweisungGrenz ueberweisungGrenz = new UeberweisungGrenz();
                ueberweisungGrenz.setUbid(u.getUbid());
                ueberweisungGrenz.setBetrag(u.getBetrag());
                ueberweisungGrenz.setDatum(u.getDatum());
                ueberweisungGrenz.setKid(u.getKunde().getKid());
                ueberweisungGrenz.setStatus(u.getStatus());
                ueberweisungGrenz.setVerwendungszweck(u.getVerwendungszweck());
                ueberweisungGrenz.setVonkonto(u.getVonkonto().getKtoid());
                ueberweisungGrenz.setZukonto(u.getZukonto().getKtoid());
                ueberweisungsGrenzList.add(ueberweisungGrenz);

            }
            Collections.sort(ueberweisungsGrenzList, (UeberweisungGrenz o1, UeberweisungGrenz o2) -> {
                if (o1.getDatum() == null || o2.getDatum() == null) {
                    return -1;
                }
                return o1.getDatum().compareTo(o2.getDatum());
            });
        } catch (NullPointerException e) {
            return ueberweisungsGrenzList;
        }
        return ueberweisungsGrenzList;
    }

    /**
     * Holt eine Liste aller wartenden Ueberweisungen vom einem Konto mit
     * gegebener Kontonummer ktoid mithilfe von
     * IUeberweisungsVorlage.getUeberweisungenVonKonto(ktoid), und speichert
     * diese in einer ArrayList von UeberweisungGrenz und sortiert diese
     * ArrayList mit Collections.sort nach Datum
     *
     * @author Alexander Merkel
     * @param ktoid Kontonummer
     * @return Liste aller Ueberweisungen eines Kontos als Grenzklassen sortiert
     * nach Datum
     */
    @Override
    public List<UeberweisungGrenz> getWartendeUeberweisungenByKtoid(int ktoid) {
        ArrayList<UeberweisungGrenz> ueberweisungsGrenzList = new ArrayList();

        IDatabase db = new IDatabaseImpl();
        EntityManager em = db.getEntityManager();
        IUeberweisungsVorlage iUeberweisungsVorlage = new IUeberweisungsVorlageImpl();
        iUeberweisungsVorlage.setEntityManager(em);
        try {
            List<Ueberweisung> listUeberweisung = iUeberweisungsVorlage.getUeberweisungenVonKonto(ktoid);
            for (Ueberweisung u : listUeberweisung) {
                if (u.getStatus().equals("wt")) {
                    UeberweisungGrenz ueberweisungGrenz = new UeberweisungGrenz();
                    ueberweisungGrenz.setUbid(u.getUbid());
                    ueberweisungGrenz.setBetrag(u.getBetrag());
                    ueberweisungGrenz.setDatum(u.getDatum());
                    ueberweisungGrenz.setKid(u.getKunde().getKid());
                    ueberweisungGrenz.setStatus(u.getStatus());
                    ueberweisungGrenz.setVerwendungszweck(u.getVerwendungszweck());
                    ueberweisungGrenz.setVonkonto(u.getVonkonto().getKtoid());
                    ueberweisungGrenz.setZukonto(u.getZukonto().getKtoid());
                    ueberweisungsGrenzList.add(ueberweisungGrenz);
                }

            }
            Collections.sort(ueberweisungsGrenzList, (UeberweisungGrenz o1, UeberweisungGrenz o2) -> {
                if (o1.getDatum() == null || o2.getDatum() == null) {
                    return -1;
                }
                return o1.getDatum().compareTo(o2.getDatum());
            });
        } catch (NullPointerException e) {
            return ueberweisungsGrenzList;
        }
        return ueberweisungsGrenzList;
    }

}
