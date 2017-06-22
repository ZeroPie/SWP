package bks.datenhaltung.sachbearbeiterdaten.impl;

import javax.persistence.EntityManager;
import bks.datenhaltung.bksdbmodel.entities.*;
import bks.datenhaltung.sachbearbeiterdaten.services.IUeberweisungsVorlage;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;


public class IUeberweisungsVorlageImpl implements IUeberweisungsVorlage {
    private EntityManager entityManager;
    
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public UeberweisungsVorlage getUeberweisungsVorlageByID(int uvid) {
        return entityManager.find(UeberweisungsVorlage.class, uvid);
    }

    @Override
    public List<UeberweisungsVorlage> getUeberweisungsVorlagenDesKunden(int kid) {
        Query query = entityManager.createNativeQuery("SELECT * FROM UeberweisungsVorlage WHERE KUNDE = " + kid, UeberweisungsVorlage.class);
        List<UeberweisungsVorlage> ueberweisungsVorlageList = query.getResultList();
        return ueberweisungsVorlageList;
    }

    @Override
    public List<UeberweisungsVorlage> getUeberweisungsVorlagenDesKontos(int ktoid) {
        Query query = entityManager.createNativeQuery("SELECT * FROM UeberweisungsVorlage WHERE vonkonto = " + ktoid, UeberweisungsVorlage.class);
        List<UeberweisungsVorlage> ueberweisungsVorlageList = query.getResultList();
        return ueberweisungsVorlageList;
    }

    @Override
    public boolean insertUeberweisungsVorlage(UeberweisungsVorlage uv) {
        Konto vonKonto = entityManager.find(Konto.class, uv.getVonkonto().getKtoid());
        if(uv.getUvid() == null) {
            uv.setVonkonto(vonKonto);
            entityManager.persist(uv);
            entityManager.flush();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUeberweisungsVorlage(int uvid) {
        UeberweisungsVorlage deleteueberweisungsVorlage = entityManager.find(UeberweisungsVorlage.class, uvid);
        if(deleteueberweisungsVorlage != null){
            entityManager.remove(deleteueberweisungsVorlage);
            return true;
        }
        return false;
    }

    @Override
    public boolean editUeberweisungsVorlage(UeberweisungsVorlage uv) {
        UeberweisungsVorlage editUeberweisungsVorlage = entityManager.find(UeberweisungsVorlage.class, uv.getUvid());
        if(editUeberweisungsVorlage == null){ return false; }
            entityManager.merge(uv);
            return true;
    }


    @Override
    public List<Ueberweisung> getUeberweisungenZuKonto(int ktoid) {
        List<Ueberweisung> listeUeberweisungen = new ArrayList();
         if (entityManager.find(Konto.class, ktoid) != null) { 
            Query query = entityManager.createNativeQuery("SELECT * FROM Ueberweisung WHERE zukonto = " + ktoid, Ueberweisung.class); //
            listeUeberweisungen = query.getResultList();  
        }
        return listeUeberweisungen;
    }

    @Override
    public List<Ueberweisung> getUeberweisungenVonKonto(int ktoid) {
        List<Ueberweisung> listeUeberweisungen = new ArrayList();
         if (entityManager.find(Konto.class, ktoid) != null) { 
            Query q = entityManager.createNativeQuery("SELECT * FROM Ueberweisung WHERE vonkonto = " + ktoid, Ueberweisung.class); //
            listeUeberweisungen = q.getResultList();  
        }
        return listeUeberweisungen;
    }

    @Override
    public List<Ueberweisung> getLoeschbareUeberweisungen() {
        List<Ueberweisung> UeberweisungenListe = new ArrayList();
        Query q = entityManager.createNativeQuery("SELECT * FROM Ueberweisung WHERE status = \"us\" OR status = \"st\" OR status = \"nu\" "); //
        UeberweisungenListe = q.getResultList();  
        return UeberweisungenListe;
    }

    @Override
    public boolean loescheUeberweisung(int ubid) {
                Ueberweisung zuloeschendeUeberweisung = entityManager.find(Ueberweisung.class, ubid);
                if(zuloeschendeUeberweisung==null){
                    return false;
                }
                if(zuloeschendeUeberweisung.getStatus()
                        .equals("us")||zuloeschendeUeberweisung.getStatus()
                        .equals("st")||zuloeschendeUeberweisung.getStatus()
                        .equals("nu")){
                            entityManager.remove(zuloeschendeUeberweisung);
                            entityManager.flush();
                    return true;
                }else{
                    return false;
                }
    }
    
}