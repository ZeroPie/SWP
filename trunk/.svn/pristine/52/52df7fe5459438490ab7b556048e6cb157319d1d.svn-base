package bks.datenhaltung.kontodaten.impl;

import java.util.List;
import javax.persistence.EntityManager;
import bks.datenhaltung.bksdbmodel.entities.Konto;
import bks.datenhaltung.kontodaten.services.ISonderKontoService;
import javax.persistence.Query;

public class ISonderKontoServiceImpl implements ISonderKontoService{
    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Konto getKontoByID(int ktoid) {
        Konto konto = null;
        if(entityManager != null)
            konto = entityManager.find(Konto.class, ktoid);
        return konto;    }

    @Override
    public List<Konto> getUeberzogeneKontos() {
        List<Konto> kontoList = null;
        if(entityManager != null) {
        Query query = entityManager.createNativeQuery("SELECT * FROM Konto WHERE status='s' OR status='g'", Konto.class);
        kontoList = query.getResultList();
        }
        return kontoList;
    }

    @Override
    public boolean neuesDispoSetzen(int ktoid, double neuesDispo) {
        boolean executed = false;
        Konto k = null;
        
        if(entityManager != null) {
            k = entityManager.find(Konto.class, ktoid);    
            if(k == null) {}
            else{
            if(k.getStatus() == "h") {
                k.setDispo(neuesDispo);
                kontoAktualisieren(k.getKtoid());
                executed = true;
            
            }else if( (k.getStatus() == "s") && (k.getKontostand()+neuesDispo) < 0) {
                k.setDispo(neuesDispo);
                kontoAktualisieren(k.getKtoid());
                executed = true;
            
            }else if( (k.getStatus() =="g") && (k.getKontostand()+neuesDispo) > 0) {
                k.setDispo(neuesDispo);
                kontoAktualisieren(k.getKtoid());
                executed = true;
            }           
            }
        }
        return executed;
    }

    @Override
    public void kontoAktualisieren(int ktoid) {
        Konto k = null;
        
        if(entityManager != null) {        
        k = entityManager.find(Konto.class, ktoid);   
        double kontostandDispo = k.getKontostand() + k.getDispo();
        
        switch(k.getStatus() ) {
            case "h": 
                if((k.getKontostand() < 0) && (kontostandDispo < 0 )) {
                    k.setStatus("g");
                //    entityManager.getTransaction().begin();
                    entityManager.merge(k);
                 //   entityManager.getTransaction().commit(); 
                }
                if((k.getKontostand() < 0) && (kontostandDispo >= 0)) {
                    k.setStatus("s");
               //     entityManager.getTransaction().begin();
                    entityManager.merge(k);
               //    entityManager.getTransaction().commit();  
                }
                if(k.getKontostand() >= 0) {
                    k.setStatus("h");
               //     entityManager.getTransaction().begin();
                    entityManager.merge(k);
               //     entityManager.getTransaction().commit();  
                }
                break;
            case "s":
                if((k.getKontostand() < 0) && (kontostandDispo < 0)) {
                    k.setStatus("g");
               //     entityManager.getTransaction().begin();
                    entityManager.merge(k);
            //        entityManager.getTransaction().commit(); 
                }
                if(k.getKontostand() >= 0) {
                    k.setStatus("h");
                    //entityManager.getTransaction().begin();
                    entityManager.merge(k);
               //     entityManager.getTransaction().commit(); 
                }
                if((k.getKontostand() < 0) && (kontostandDispo >= 0)) {
                    k.setStatus("s");
               //     entityManager.getTransaction().begin();
                    entityManager.merge(k);
                //    entityManager.getTransaction().commit(); 
                }
                break;
            case "g": 
                if((k.getKontostand() < 0) && (kontostandDispo >= 0)) {
                    k.setStatus("s");
                //    entityManager.getTransaction().begin();
                    entityManager.merge(k);
                //    entityManager.getTransaction().commit(); 
                }
                if(k.getKontostand() >= 0) {
                    k.setStatus("h");
               //     entityManager.getTransaction().begin();
                    entityManager.merge(k);
                //    entityManager.getTransaction().commit(); 
                }
                if((k.getKontostand() < 0) && (kontostandDispo < 0)) {
                    k.setStatus("g");
                 //   entityManager.getTransaction().begin();
                    entityManager.merge(k);
                //    entityManager.getTransaction().commit(); 
                }
                break;
            }
        }
    }
}