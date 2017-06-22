package bks.datenhaltung.kundedaten.impl;

import bks.datenhaltung.bksdbmodel.entities.Kunde;
import bks.datenhaltung.bksdbmodel.impl.IDatabaseImpl;
import bks.datenhaltung.bksdbmodel.services.IDatabase;
import bks.datenhaltung.kundedaten.services.ICRUDKunde;
import org.junit.*;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.*;

public class ICRUDKundeImplTest {

    private static EntityManager entityManager;
    private final static IDatabase iDatabase = new IDatabaseImpl();
    private ICRUDKunde classUnderTest;

    /* Angenommen der EntityManager wird korrekt geholt,
     * UND die Implementierung der ICRUDKunde Schnittstelle wird als classUnderTest instanziiert,
     * UND der EntityManager em wird per setEntityManager Methode der classUnderTest gesetzt,
     * UND die Transaktion von em wird gestartet,
     * UND die Daten der betreffenden Entitäten wurden in der DB gelöscht. */
    @Before
    public void angenommen(){
        entityManager = iDatabase.getEntityManager();
        classUnderTest = new ICRUDKundeImpl();
        classUnderTest.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("DELETE FROM Zahlungsverkehr").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Konto").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Kunde").executeUpdate();
    }

    /* Am Ende wird die Transaktion zurück gesetzt. */
    @After
    public void amEnde(){
        entityManager.getTransaction().rollback();
    }


    /* WENN ein Testkunde bereits in der DB existiert,
     * UND die Methode getKundeById mit der Id des Testkunden aufgerufen wird,
     * DANN sollte sie den Testkunden zurückliefern. */
    @Test
    public void getKundeById_00(){
        Kunde testKunde     = createpersistedKunde();
        Kunde databaseKunde = classUnderTest.getKundeByID(testKunde.getKid());
        assertEquals(testKunde, databaseKunde);
    }


    /* WENN ein Testkunde nicht in der DB existiert,
     * UND die Methode getKundeById mit der Id des Testkunden aufgerufen wird,
     * DANN sollte sie NULL zurückliefern.*/
    @Test
    public void getKundeById_01(){
        Kunde testKunde = createpersistedKunde();
        entityManager.remove(testKunde);
        Kunde databaseKunde = classUnderTest.getKundeByID(testKunde.getKid());
        assertNull(databaseKunde);
    }

    /* WENN x (x>0) Kunden in der DB existieren,
     * UND die Methode getKundenListe aufgerufen wird,
     * DANN sollte sie eine Liste mit x Kunden zurückliefern.*/
    @Test
    public void getKundenListe_00(){
        Kunde testKunde            = createpersistedKunde();
        List<Kunde> testkundenList = new ArrayList<>();
        List<Kunde> kundenList     = new ArrayList<>();
        kundenList                 = classUnderTest.getKundenListe();
        testkundenList.add(testKunde);
        assertEquals(testkundenList, kundenList);
    }


    /* WENN keine Kunden in der DB existieren,
     * UND die Methode getKundenListe aufgerufen wird,
     * DANN sollte sie eine leere Liste zurückliefern */
    @Test
    public void getKundenListe_01(){
        List<Kunde> testkundenList    = new ArrayList<>();
        testkundenList                = classUnderTest.getKundenListe();      
        assertEquals(0, testkundenList.size());
    }

    /* WENN die Methode insertKunde mit einem Testkunden aufgerufen wird,
     * UND die ID des Testkunden gleich null ist,
     * DANN sollte sie TRUE zurückliefern,
     * UND der Testkunde sollte in der DB existieren*/
    @Test
    public void insertKunde_00(){
        Kunde testKunde = createlocalKunde();
        assertTrue(classUnderTest.insertKunde(testKunde));     
        entityManager.flush();
        assertEquals(testKunde,entityManager.find(Kunde.class, testKunde.getKid()));
    }


    /* WENN die Methode insertKunde mit einem Testkunden aufgerufen wird,
     * UND die ID des Testkunden ungleich null ist,
     * DANN sollte sie FALSE zurückliefern,
     * UND die DB wurde nicht verändert. */
    @Test
    public void insertKunde_01(){
        Kunde testKunde = createpersistedKunde();
        classUnderTest.insertKunde(testKunde);
        assertFalse(classUnderTest.insertKunde(testKunde));
        entityManager.flush();
        assertNotNull(entityManager.find(Kunde.class, testKunde.getKid()));
    }

    /* WENN ein Testkunde in der DB existiert,
     * UND die Methode updatekunde mit einem veränderten Testkunden (aber gleicher ID)
     * aufgerufen wird,
     * DANN sollte sie TRUE zurückliefern,
     * UND der Testkunde sollte in der DB verändert sein. */
    @Test
    public void editKunde_00(){
        Kunde testKunde = createpersistedKunde();
        testKunde.setTelefon("123456789");
        assertTrue(classUnderTest.editKunde(testKunde));
        Kunde editedKunde = classUnderTest.getKundeByID(testKunde.getKid());
        assertEquals(editedKunde, testKunde);
    }


    /**
     * WENN ein Testkunde nicht in der DB existiert,
     * UND die Methode updateKunde mit dem Testkunden aufgerufen wird,
     * DANN sollte sie FALSE zurückliefern,
     * UND der Testkunde sollte nicht in der DB existieren.
     */
    @Test
    public void editKunde_01(){
        Kunde testkunde = createpersistedKunde();
        entityManager.remove(testkunde);
        assertFalse(entityManager.contains(testkunde));
    }


    /* WENN ein Testkunde in der DB existiert,
     * UND die Methode deleteKunde mit der ID des Testkunden aufgerufen wird,
     * DANN sollte sie TRUE zurückliefern,
     * UND der Testkunde sollte nicht mehr in der DB existieren.*/
    @Test
    public void deleteKunde_00(){
        Kunde testkunde = createpersistedKunde();
        assertTrue(classUnderTest.deleteKunde(testkunde.getKid()));
        assertFalse(entityManager.contains(testkunde));
    }


    /* WENN ein Testkunde nicht in der DB existiert,
     * UND die Methode deleteKunde mit der ID des Testkunden aufgerufen wird,
     * DANN sollte sie FALSE zurückliefern. */
    @Test
    public void deleteKunde_01(){
        Kunde testkunde = createpersistedKunde();
        entityManager.remove(testkunde);
        assertFalse(classUnderTest.deleteKunde(testkunde.getKid()));
    }

    Kunde createpersistedKunde(){
        Kunde testKunde = new Kunde(
                null,
                "Dr.",
                "King",
                "Wasfuer",
                new Date(),
                "m",
                "v"
        );
        entityManager.persist(testKunde);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testKunde;
    }
    
        Kunde createlocalKunde(){
        Kunde localTestKunde = new Kunde(
                null,
                "Dr.",
                "King",
                "Wasfuer",
                new Date(),
                "m",
                "v"
        );
        return localTestKunde;
    }
    
    

}
