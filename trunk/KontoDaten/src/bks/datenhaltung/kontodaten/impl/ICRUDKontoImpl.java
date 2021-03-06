package bks.datenhaltung.kontodaten.impl;

import bks.datenhaltung.bksdbmodel.entities.Konto;
import bks.datenhaltung.bksdbmodel.entities.Zahlungsverkehr;
import bks.datenhaltung.kontodaten.services.ICRUDKonto;
import bks.datenhaltung.kontodaten.services.IKontoService;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Barthy
 * AP4 Barthélémy Bonhomme
 */
public class ICRUDKontoImpl implements ICRUDKonto {

    private EntityManager entityManager;
    private final IKontoService iKontoService;
    
    public ICRUDKontoImpl() {
        this.iKontoService = new IKontoServiceImpl();
    }
    
    @Override
    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
        this.iKontoService.setEntityManager(em);
    }

    @Override
    public Konto getKontoByID(int ktoid) {
        return this.entityManager.find(Konto.class, ktoid);
    }

    @Override
    public List<Konto> getKontoListeDesKunden(int kid) {
        List<Konto> kontoList = null;
        Query query = this.entityManager.createNativeQuery("SELECT * FROM Konto k WHERE k.kunde = ?1", Konto.class);
        kontoList =  query.setParameter(1, kid).getResultList();
        
        return kontoList;
    }

    @Override
    public boolean insertKonto(Konto kto) {
        if(kto.getKtoid() == null){
            this.entityManager.persist(kto);
           
            return true;
        }
        
        return false;
    }

    @Override
    public boolean deleteKonto(int ktoid) {
        Konto konto = this.entityManager.find(Konto.class, ktoid);
        if(konto != null){
            this.entityManager.remove(konto);
            
            return true;
        }
        
        return false;
    }

    @Override
    public boolean geldEinzahlen(int ktoid, double betrag, String text) {
        Konto konto = this.getKontoByID(ktoid);
        if(konto != null){
            double aktuellerKontostand = konto.getKontostand();
            
            konto.setKontostand(aktuellerKontostand + betrag);
            this.entityManager.merge(konto);
            
            Zahlungsverkehr zVk = new Zahlungsverkehr();
            zVk.setKonto(konto);
            zVk.setDatum(new Date());
            zVk.setErlaeuterung(text);
            zVk.setHaben(betrag);
            zVk.setSoll(0d);
            zVk.setAusgedruckt(false);
            this.entityManager.persist(zVk);
            this.iKontoService.kontoAktualisieren(konto.getKtoid());
            
            return true;
        }
        
        return false;
    }

    @Override
    public boolean geldAbheben(int ktoid, double betrag, String text) {
        Konto konto = this.getKontoByID(ktoid);
        if(konto != null && !konto.getStatus().equals("g")){
            double aktuellerKontostand = konto.getKontostand();
            
            konto.setKontostand(aktuellerKontostand - betrag);
            this.entityManager.merge(konto);
                    
            Zahlungsverkehr zVk = new Zahlungsverkehr();
            zVk.setKonto(konto);
            zVk.setDatum(new Date());
            zVk.setErlaeuterung(text);
            zVk.setHaben(0d);
            zVk.setSoll(betrag);
            zVk.setAusgedruckt(false);
            this.entityManager.persist(zVk);
            this.iKontoService.kontoAktualisieren(konto.getKtoid());
            
            return true;
        }
        
        return false;
    }
    
}
