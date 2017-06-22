package bks.datenhaltung.kundedaten.impl;

import bks.datenhaltung.bksdbmodel.entities.Kunde;
import bks.datenhaltung.kundedaten.services.ICRUDKunde;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;

import java.util.ArrayList;

public class ICRUDKundeImpl implements ICRUDKunde{

    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Kunde getKundeByID(int kid) {
        Kunde kunde = null;
        if(entityManager != null)
            kunde = entityManager.find(Kunde.class, kid);
        return kunde;
    }

    @Override
    public List<Kunde> getKundenListe() {
        List<Kunde> kundenList = null;
        Query query = entityManager.createNativeQuery("SELECT * FROM Kunde", Kunde.class);
        kundenList = query.getResultList();
        return kundenList;
    }

    @Override
    public boolean insertKunde(Kunde kunde) {
        if(kunde.getKid() == null) {
            entityManager.persist(kunde);
            entityManager.flush();
            return true;
        }
        return false;
    }

    @Override
    public boolean editKunde(Kunde kunde) {
        Kunde kundeedit = entityManager.find(Kunde.class, kunde.getKid());
        if (kundeedit == null) { return false; }
        entityManager.merge(kunde);
        return true;
    }

    @Override
    public boolean deleteKunde(int kid) {
        Kunde kunde = entityManager.find(Kunde.class, kid);
        if(kunde != null) {
            entityManager.remove(kunde);
            return true;
        }
        return false;
    }

}
