package bks.datenhaltung.kontodaten.impl;

import bks.datenhaltung.bksdbmodel.entities.Konto;
import bks.datenhaltung.bksdbmodel.entities.Kunde;
import bks.datenhaltung.bksdbmodel.entities.Ueberweisung;
import bks.datenhaltung.bksdbmodel.entities.Zahlungsverkehr;
import javax.persistence.EntityManager;
import bks.datenhaltung.bksdbmodel.impl.IDatabaseImpl;
import bks.datenhaltung.bksdbmodel.services.IDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IKontoServiceImplTest {

    private static EntityManager entityManager;
    private final static IDatabase iDatabase = new IDatabaseImpl();
    private IKontoServiceImpl classUnderTest;

    @BeforeClass
    public static void setUp() {
        entityManager = iDatabase.getEntityManager();
    }

    /* 
    @Before: angenommen()
    Angenommen der EntityManager wird korrekt geholt,
    UND die Implementierung der IKontoService Schnittstelle wird als classUnderTest instanziiert,
    UND der EntityManager em wird per setEntityManager Methode der classUnderTest gesetzt,
    UND die Transaktion von em wird gestartet,
    UND die Daten der betreffenden Entitäten wurden in der DB gelöscht.
     */
    @Before
    public void angenommen() {
        classUnderTest = new IKontoServiceImpl(); //UND die Implementierung der IKontoService Schnittstelle wird als classUnderTest instanziiert,
        classUnderTest.setEntityManager(entityManager); //UND der EntityManager em wird per setEntityManager Methode der classUnderTest gesetzt,
        entityManager.getTransaction().begin(); //UND die Transaktion von em wird gestartet,
        entityManager.createNativeQuery("DELETE FROM Zahlungsverkehr").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Konto").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Ueberweisung").executeUpdate(); //UND die Daten der betreffenden Entitäten wurden in der DB gelöscht.            
    }

    /* 
    @After amEnde()
    Am Ende wird die Transaktion zurück gesetzt.
     */
    @After
    public void amEnde() {
        entityManager.getTransaction().rollback();
    }

    /* WENN ein Testkonto bereits i1999n der DB existiert,
     * UND fuer dieses Testkonto x (x>0) Zahlungsverkehre in der DB existieren, die innerhalb des Datumsintervalls liegen,
     * UND die Methode getKontoauszug mit der Id des Testkontos aufgerufen wird,
     * DANN sollte sie die Liste mit x Zahlungsverkehren zurueckliefern */
    @Test
    public void getKontoauszug_00() {
        Konto testKonto = createTestKonto(10, 1);
        Zahlungsverkehr testZahlungsverkehr = createTestZahlungsverkehr(testKonto); 
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid()));     

        ArrayList<Zahlungsverkehr> testList = new ArrayList<>();
        ArrayList<Zahlungsverkehr> zahlList = new ArrayList<>(this.classUnderTest.getKontoauszug(testKonto.getKtoid(),new Date(99,1,1), new Date(101, 1, 1)));
        testList.add(testZahlungsverkehr);
        assertEquals(testList, zahlList);

    }

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND für dieses Testkonto keine Zahlungsverkehre in der DB existieren, die innerhalb des
     * Datumsintervalls liegen,
     * UND die Methode getKontoauszug mit der Id des Testkontos aufgerufen wird,
     * DANN sollte sie die leere Liste zurückliefern. */
    @Test
    public void getKontoauszug_01() {
        Konto testKonto = createTestKonto(10, 1);               
        Zahlungsverkehr testZahlungsverkehr = createTestZahlungsverkehr(testKonto);      
        ArrayList<Zahlungsverkehr> zahlList = new ArrayList<>(this.classUnderTest.getKontoauszug(testKonto.getKtoid(),new Date(97, 1, 1), new Date(98, 1, 1)));      
        assertEquals(0, zahlList.size() );

    }

    /* WENN ein Testkonto nicht in der DB existiert,
      * UND die Methode getKontoauszug mit der Id des Testkontos aufgerufen wird,
      * DANN sollte sie die leere Liste zurückliefern. */
    @Test
    public void getKontoauszug_02() {
        Konto testKonto = createTestKonto(10, 1);
        entityManager.remove(testKonto);
        ArrayList<Zahlungsverkehr> zahlList = new ArrayList<>(this.classUnderTest.getKontoauszug(testKonto.getKtoid(),new Date(98,1,1), new Date(99,1,1) ) );
        assertEquals(0, zahlList.size());

    }

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND für dieses Testkonto x (x>0) Zahlungsverkehre in der DB existieren, die als nicht
     * ausgedruckt markiert sind,
     * UND die Methode getKontoauszugDrucken mit der Id des Testkontos aufgerufen wird,
     * DANN sollte sie die Liste mit diesen x Zahlungsverkehren zurückliefern,
     * UND diese x Zahlungsverkehre sind dann als ausgedruckt in der DB markiert.  */
    @Test
    public void getKontoauszugDrucken_00() {
        Konto testKonto = createTestKonto(10, 1);
        Zahlungsverkehr testZahlungsverkehr = createTestZahlungsverkehr(testKonto);
        testZahlungsverkehr.setAusgedruckt(false);

        ArrayList<Zahlungsverkehr> testList = new ArrayList<>();
        ArrayList<Zahlungsverkehr> zahlList = new ArrayList<>(this.classUnderTest.getKontoauszugDrucken(testKonto.getKtoid()));
        testList.add(testZahlungsverkehr);
        assertEquals(testList, zahlList);
        assertTrue( zahlList.get(0).getAusgedruckt()  );
      //  assertTrue(zahlList.get(0).getAusgedruckt() );
    }

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND für dieses Testkonto keine Zahlungsverkehre in der DB existieren, die als nicht ausge-
     * druckt markiert sind,
     * UND die Methode getKontoauszugDrucken mit der Id des Testkontos aufgerufen wird,
     * DANN sollte sie die leere Liste zurückliefern.  */
    @Test
    public void getKontoauszugDrucken_01() {
        Konto testKonto = createTestKonto(10, 1);
        Zahlungsverkehr testZahlungsverkehr = createTestZahlungsverkehr(testKonto);
        testZahlungsverkehr.setAusgedruckt(true);

        ArrayList<Zahlungsverkehr> zahlList = new ArrayList<>(this.classUnderTest.getKontoauszugDrucken(testKonto.getKtoid()));
        assertEquals(0, zahlList.size());
    }

    /* WENN ein Testkonto nicht in der DB existiert,
     * UND die Methode getKontoauszugDrucken mit der Id des Testkontos aufgerufen wird,
     * DANN sollte sie die leere Liste zurückliefern. */
    @Test
    public void getKontoauszugDrucken_02() {
        Konto testKonto = createTestKonto(10, 1);
        entityManager.remove(testKonto);
        ArrayList<Zahlungsverkehr> zahlList = new ArrayList<>(this.classUnderTest.getKontoauszugDrucken(testKonto.getKtoid()));
        assertEquals(0, zahlList.size());
    }

    /* WENN ein Testkunde bereits in der DB existiert,
     * UND für diesen Testkunden x (x>0) Konten in der DB existieren,
     * UND die Methode getKontoListe mit der ID des Testkunden aufgerufen wird,
     * DANN sollte sie die Liste seiner x Konten zurückliefern. */
    @Test
    public void getKontoListe_00() {
        Kunde testKunde = createTestKunde();
        Konto testKonto = createTestKonto(-10, -10);
        testKonto.setKunde(testKunde);

        ArrayList<Konto> testList = new ArrayList<>();
        ArrayList<Konto> kontoList = new ArrayList<>(this.classUnderTest.getKontoListe(testKunde.getKid()));
        testList.add(testKonto);
        assertEquals(testList, kontoList);
    }

    /* WENN ein Testkunde bereits in der DB existiert,
     * UND für diesen Testkunden keine Konten in der DB existieren,
     * UND die Methode getKontoListe mit der ID des Testkunden aufgerufen wird,
     * DANN sollte sie eine leere Liste zurückliefern. */
    @Test
    public void getKontoListe_01() {
        Kunde testKunde = createTestKunde();
        ArrayList<Konto> kontoList = new ArrayList<>(this.classUnderTest.getKontoListe(testKunde.getKid()));
        assertEquals(0, kontoList.size());
    }

    /* WENN ein Testkunde nicht in der DB existiert,
     * UND die Methode getKontoListe mit der ID des Testkunden aufgerufen wird,
     * DANN sollte sie eine leere Liste zurückliefern. */
    @Test
    public void getKontoListe_02() {
        Kunde testKunde = createTestKunde();
        entityManager.remove(testKunde);
        ArrayList<Konto> kontoList = new ArrayList<>(this.classUnderTest.getKontoListe(testKunde.getKid()));
        assertEquals(0, kontoList.size());

    }

    /* WENN x (x>0) Konten mit dem Status ”init” in der DB existieren,
     * UND die Methode getNichtFreigeschalteteKonten aufgerufen wird,
     * DANN sollte sie die Liste der x Konten zurückliefern.  */
    @Test
    public void getNichtFreigeschalteteKonten_00() {
        Konto testKonto = createTestKonto(-10, -10);
        ArrayList<Konto> kontoList = new ArrayList<>(this.classUnderTest.getNichtFreigeschalteteKonten());
        assertNotEquals(0, kontoList.size());

    }

    /* WENN keine Konten mit dem Status ”init” in der DB existieren,
     * UND die Methode getNichtFreigeschalteteKonten aufgerufen wird,
     * DANN sollte sie eine leere Liste zurückliefern.  */
    @Test
    public void getNichtFreigeschalteteKonten_01() {
        ArrayList<Konto> kontoList = new ArrayList<>(this.classUnderTest.getNichtFreigeschalteteKonten());
        assertEquals(0, kontoList.size());

    }

    /*
    @Test: ueberweisungErfassen_00()
    WENN die Methode ueberweisungErfassen mit einer TestUeberweisung aufgerufen wird,
    UND die ID der TestUeberweisung gleich null ist,
    UND das Attribut vonkonto der TestUeberweisung auf ein in der DB existierendes Konto verweist,
    UND das Attribut zukonto der TestUeberweisung auf ein in der DB existierendes Konto verweist,
    DANN sollte sie TRUE zurückliefern,
    UND die TestUeberweisung sollte in der DB existieren, 
    UND die TestUeberweisung sollte den Status wartet (wt) besitzen.
    @author Alexander
     */
    @Test
    public void ueberweisungErfassen_00() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberweisung erstellen

        assertNull(testUeberweisung.getUbid()); //UND die ID der TestUeberweisung gleich null ist,
        assertNotNull(entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid())); //UND das Attribut vonkonto der TestUeberweisung auf ein in der DB existierendes Konto verweist,
        assertNotNull(entityManager.find(Konto.class, testUeberweisung.getZukonto().getKtoid())); //UND das Attribut zukonto der TestUeberweisung auf ein in der DB existierendes Konto verweist,

        boolean ergebnis = classUnderTest.ueberweisungErfassen(testUeberweisung); //WENN die Methode ueberweisungErfassen mit einer TestUeberweisung aufgerufen wird,
        assertTrue(ergebnis); //DANN sollte sie TRUE zurückliefern,
        assertNotNull(entityManager.find(Ueberweisung.class, testUeberweisung.getUbid())); //UND die TestUeberweisung sollte in der DB existieren, UND die TestUeberweisung sollte
        assertEquals("wt", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND die TestUeberweisung sollte den Status wartet (wt) besitzen.

    }

    /*
    @Test: ueberweisungErfassen_01()
    WENN die Methode ueberweisungErfassen mit einer TestUeberweisung aufgerufen wird,
    UND die ID der TestUeberweisung ungleich null ist,
    DANN sollte sie FALSE zurückliefern,
    UND die TestUeberweisung sollte nicht in der DB existieren.
    @author Alexander
     */
    @Test
    public void ueberweisungErfassen_01() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberweisung erstellen

        testUeberweisung.setUbid(11); //UND die ID der TestUeberweisung ungleich null ist,
        boolean ergebnis = classUnderTest.ueberweisungErfassen(testUeberweisung); //WENN die Methode ueberweisungErfassen mit einer TestUeberweisung aufgerufen wird,
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern,
        assertNull(entityManager.find(Ueberweisung.class, testUeberweisung.getUbid())); // UND die TestUeberweisung sollte nicht in der DB existieren.
    }

    /*
    @Test: ueberweisungErfassen_02()
    WENN die Methode ueberweisungErfassen mit einer TestUeberweisung aufgerufen wird,
    UND das Attribut vonkonto der TestUeberweisung auf ein in der DB nicht existierendes Konto verweist,
    DANN sollte sie FALSE zurückliefern,
    UND die TestUeberweisung sollte nicht in der DB existieren.
    @author Alexander
     */
    @Test
    public void ueberweisungErfassen_02() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberweisung erstellen

        testUeberweisung.getVonkonto().setKtoid(44); //UND das Attribut vonkonto der TestUeberweisung auf ein in der DB nicht existierendes Konto verweist,
        boolean ergebnis = classUnderTest.ueberweisungErfassen(testUeberweisung); //WENN die Methode ueberweisungErfassen mit einer TestUeberweisung aufgerufen wird,
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern,
        assertNull(testUeberweisung.getUbid()); //UND die TestUeberweisung sollte nicht in der DB existieren.
    }

    /*
    @Test: ueberweisungErfassen_03()
    WENN die Methode ueberweisungErfassen mit einer TestUeberweisung aufgerufen wird,
    UND das Attribut zukonto der TestUeberweisung auf ein in der DB nicht existierendes Konto verweist,
    DANN sollte sie FALSE zurückliefern,
    UND die TestUeberweisung sollte nicht in der DB existieren.
    @author Alexander
     */
    @Test
    public void ueberweisungErfassen_03() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberweisung erstellen

        testUeberweisung.getZukonto().setKtoid(44); //UND das Attribut zukonto der TestUeberweisung auf ein in der DB nicht existierendes Konto verweist,
        boolean ergebnis = classUnderTest.ueberweisungErfassen(testUeberweisung); //WENN die Methode ueberweisungErfassen mit einer TestUeberweisung aufgerufen wird,
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern,
        assertNull(testUeberweisung.getUbid()); //UND die TestUeberweisung sollte nicht in der DB existieren.
    }

    /*
    @Test: getStornierbareUeberweisungen_00()
    WENN ein Testkunde bereits in der DB existiert,
    UND für diesen Testkunden x (x>0) Überweisungen in der DB existieren, die den Status wartet (wt) haben,
    UND die Methode getStornierbareUeberweisungen mit der ID des Testkunden aufgerufen wird,
    DANN sollte sie die Liste mit x Überweisungen zurückliefern.
    @author Alexander
     */
    @Test
    public void getStornierbareUeberweisungen_00() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberweisung mit TestKunde erstellen
        assertNotNull(entityManager.find(Kunde.class, testUeberweisung.getKunde().getKid())); //WENN ein Testkunde bereits in der DB existiert,
        int x = 1; //UND für diesen Testkunden x (x>0) Überweisungen in der DB existieren, die den Status wartet (wt) haben,
        List<Ueberweisung> testList = null;
        //for(int i = 0;i<x;++i){
        classUnderTest.ueberweisungErfassen(testUeberweisung);
        assertEquals("wt", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND für diesen Testkunden x (x>0) Überweisungen in der DB existieren, die den Status wartet (wt) haben,
        //}
        testList = classUnderTest.getStornierbareUeberweisungen(testUeberweisung.getKunde().getKid()); //UND die Methode getStornierbareUeberweisungen mit der ID des Testkunden aufgerufen wird,
        assertEquals(testList.size(), x); //DANN sollte sie die Liste mit x Überweisungen zurückliefern.

    }

    /*
    @Test: getStornierbareUeberweisungen_01()
    WENN ein Testkunde bereits in der DB existiert,
    UND für diesen Testkunden keine Überweisungen in der DB existieren, die den Status wartet(wt) haben,
    UND die Methode getStornierbareUeberweisungen mit der ID des Testkunden aufgerufen wird,
    DANN sollte sie eine leere Liste zurückliefern.
    @author Alexander
     */
    @Test
    public void getStornierbareUeberweisungen_01() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberweisung mit TestKunden erstellen
        assertNotNull(entityManager.find(Kunde.class, testUeberweisung.getKunde().getKid()));
        classUnderTest.ueberweisungErfassen(testUeberweisung);
        testUeberweisung.setStatus("st");
        entityManager.merge(testUeberweisung);
        assertNotEquals("wt", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND für diesen Testkunden keine Überweisungen in der DB existieren, die den Status wartet(wt) haben,
        List testList = classUnderTest.getStornierbareUeberweisungen(testUeberweisung.getKunde().getKid()); //UND die Methode getStornierbareUeberweisungen mit der ID des Testkunden aufgerufen wird,
        assertTrue(testList.isEmpty()); //DANN sollte sie eine leere Liste zurückliefern. 
    }

    /*
    @Test: getStornierbareUeberweisungen_02()
    WENN ein Testkunde nicht in der DB existiert,
    UND die Methode getStornierbareUeberweisungen mit der ID des Testkunden aufgerufen wird,
    DANN sollte sie eine leere Liste zurückliefern.
    @author Alexander
     */
    @Test
    public void getStornierbareUeberweisungen_02() {
        Kunde testKunde = createTestKunde(); //TestKunde erstellen
        entityManager.remove(testKunde);
        assertNull(entityManager.find(Kunde.class, testKunde.getKid())); //WENN ein Testkunde nicht in der DB existiert,
        List testList = classUnderTest.getStornierbareUeberweisungen(testKunde.getKid()); //UND die Methode getStornierbareUeberweisungen mit der ID des Testkunden aufgerufen wird,
        assertTrue(testList.isEmpty()); //DANN sollte sie eine leere Liste zurückliefern.        
    }

    /*
    @Test: ueberweisungStornieren_00()
    WENN eine TestUeberweisung bereits in der DB existiert,
    UND die TestUeberweisung den Status ”wartet” besitzt,
    UND die Methode ueberweisungStornieren mit der Id der TestUeberweisung aufgerufen wird,
    DANN sollte sie TRUE zurückliefern,
    UND der Status der TestUeberweisung auf ”storniert” gesetzt sein.
    @author Alexander
     */
    @Test
    public void ueberweisungStornieren_00() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberwesiung erstellen
        classUnderTest.ueberweisungErfassen(testUeberweisung);
        testUeberweisung = entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()); //WENN eine TestUeberweisung bereits in der DB existiert,
        assertEquals("wt", testUeberweisung.getStatus()); //UND die TestUeberweisung den Status ”wartet” besitzt,

        boolean ergebnis = classUnderTest.ueberweisungStornieren(testUeberweisung.getUbid()); //UND die Methode ueberweisungStornieren mit der Id der TestUeberweisung aufgerufen wird,
        assertTrue(ergebnis); //DANN sollte sie TRUE zurückliefern,
        assertEquals("st", testUeberweisung.getStatus()); //UND der Status der TestUeberweisung auf ”storniert” gesetzt sein.
    }

    /*
    @Test: ueberweisungStornieren_01()
    WENN eine TestUeberweisung bereits in der DB existiert,
    UND die TestUeberweisung den Status ”storniert” besitzt,
    UND die Methode ueberweisungStornieren mit der Id der TestUeberweisung aufgerufen wird,
    DANN sollte sie FALSE zurückliefern,
    UND die TestUeberweisung wurde nicht verändert.
    @author Alexander
     */
    @Test
    public void ueberweisungStornieren_01() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberwesiung erstellen
        classUnderTest.ueberweisungErfassen(testUeberweisung);
        Ueberweisung expectetTestUeberweisung = entityManager.find(Ueberweisung.class, testUeberweisung.getUbid());
        testUeberweisung = entityManager.find(Ueberweisung.class, testUeberweisung.getUbid());
        assertNotNull(testUeberweisung); //WENN eine TestUeberweisung bereits in der DB existiert,
        classUnderTest.ueberweisungStornieren(testUeberweisung.getUbid());

        assertEquals("st", testUeberweisung.getStatus()); //UND die TestUeberweisung den Status ”storniert” besitzt,

        boolean ergebnis = classUnderTest.ueberweisungStornieren(testUeberweisung.getUbid()); //UND die Methode ueberweisungStornieren mit der Id der TestUeberweisung aufgerufen wird,
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern,
        assertEquals(expectetTestUeberweisung, testUeberweisung); //UND die TestUeberweisung wurde nicht verändert.
    }

    /*
    @Test: ueberweisungStornieren_02()
    WENN ein TestUeberweisung nicht in der DB existiert,
    UND die Methode ueberweisungStornieren mit der Id der TestUeberweisung aufgerufen wird,
    DANN sollte sie FALSE zurückliefern.
    @author Alexander
     */
    @Test
    public void ueberweisungStornieren_02() {
        Ueberweisung testUeberweisung = createTestUeberweisung(); //TestUeberwesiung erstellen
        classUnderTest.ueberweisungErfassen(testUeberweisung);
        entityManager.remove(testUeberweisung);
        assertNull(entityManager.find(Ueberweisung.class, testUeberweisung.getUbid())); //WENN ein TestUeberweisung nicht in der DB existiert,
        boolean ergebnis = classUnderTest.ueberweisungStornieren(testUeberweisung.getUbid()); //UND die Methode ueberweisungStornieren mit der Id der TestUeberweisung aufgerufen wird,
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern.
    }

    /*
    @Test: kontoAktualisieren_00()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status ”haben” besitzt,
    UND das Testkonto einen Kontostand < 0 besitzt,
    UND für das Testkonto Kontostand + dispo < 0 gilt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_00() {
        Konto testKonto = createTestKonto(-1, 0); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        classUnderTest.kontoFreischalten(testKonto.getKtoid());
        assertEquals("h", testKonto.getStatus()); //UND das Testkonto den Status ”haben” besitzt,

        assertTrue(testKonto.getKontostand() < 0); //UND das Testkonto einen Kontostand < 0 besitzt,
        assertTrue(testKonto.getKontostand() + testKonto.getDispo() < 0); //UND für das Testkonto Kontostand + dispo < 0 gilt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("g", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen.
    }

    /*
    @Test: kontoAktualisieren_01()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status ”haben” besitzt,
    UND das Testkonto einen Kontostand < 0 besitzt,
    UND für das Testkonto Kontostand + dispo >= 0 gilt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert ”soll” besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_01() {
        Konto testKonto = createTestKonto(-1, 2); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        classUnderTest.kontoFreischalten(testKonto.getKtoid());
        assertEquals("h", testKonto.getStatus()); //UND das Testkonto den Status ”haben” besitzt,

        assertTrue(testKonto.getKontostand() < 0); //UND das Testkonto einen Kontostand < 0 besitzt,
        assertTrue(testKonto.getKontostand() + testKonto.getDispo() >= 0); //UND für das Testkonto Kontostand + dispo >= 0 gilt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("s", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”soll” besitzen.
    }

    /*@Test: kontoAktualisieren_02()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status ”haben” besitzt,
    UND das Testkonto einen Kontostand >= 0 besitzt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_02() {
        Konto testKonto = createTestKonto(20, 2); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        classUnderTest.kontoFreischalten(testKonto.getKtoid());
        assertEquals("h", testKonto.getStatus()); //UND das Testkonto den Status ”haben” besitzt,

        assertTrue(testKonto.getKontostand() >= 0); //UND das Testkonto einen Kontostand >= 0 besitzt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("h", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen.
    }

    /*@Test: kontoAktualisieren_03()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status ”soll” besitzt,
    UND das Testkonto einen Kontostand < 0 besitzt,
    UND für das Testkonto Kontostand + dispo < 0 gilt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_03() {
        Konto testKonto = createTestKonto(-1, 0); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("s");
        assertEquals("s", testKonto.getStatus()); //UND das Testkonto den Status ”soll” besitzt,

        assertTrue(testKonto.getKontostand() < 0); //UND das Testkonto einen Kontostand < 0 besitzt,
        assertTrue(testKonto.getKontostand() + testKonto.getDispo() < 0); //UND für das Testkonto Kontostand + dispo < 0 gilt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("g", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen.
    }

    /*
    @Test: kontoAktualisieren_04()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status soll (s) besitzt,
    UND das Testkonto einen Kontostand < 0 besitzt,
    UND für das Testkonto Kontostand + dispo >= 0 gilt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert soll (s) besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_04() {
        Konto testKonto = createTestKonto(-1, 2); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("s");
        assertEquals("s", testKonto.getStatus()); //UND das Testkonto den Status ”soll” besitzt,

        assertTrue(testKonto.getKontostand() < 0); //UND das Testkonto einen Kontostand < 0 besitzt,
        assertTrue(testKonto.getKontostand() + testKonto.getDispo() >= 0); //UND für das Testkonto Kontostand + dispo >= 0 gilt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("s", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”soll” besitzen.
    }

    /*
    @Test: kontoAktualisieren_05()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status ”soll” besitzt,
    UND das Testkonto einen Kontostand >= 0 besitzt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_05() {
        Konto testKonto = createTestKonto(20, 2); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("s");
        assertEquals("s", testKonto.getStatus()); //UND das Testkonto den Status ”soll” besitzt,

        assertTrue(testKonto.getKontostand() >= 0); //UND das Testkonto einen Kontostand >= 0 besitzt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("h", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen.
    }

    /*
    @Test: kontoAktualisieren_06()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status ”gesperrt” besitzt,
    UND das Testkonto einen Kontostand < 0 besitzt,
    UND für das Testkonto Kontostand + dispo < 0 gilt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_06() {
        Konto testKonto = createTestKonto(-1, 0); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("g");
        assertEquals("g", testKonto.getStatus()); //UND das Testkonto den Status ”gesperrt” besitzt,

        assertTrue(testKonto.getKontostand() < 0); //UND das Testkonto einen Kontostand < 0 besitzt,
        assertTrue(testKonto.getKontostand() + testKonto.getDispo() < 0); //UND für das Testkonto Kontostand + dispo < 0 gilt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("g", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen.
    }

    /*
    @Test: kontoAktualisieren_07()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status ”gesperrt” besitzt,
    UND das Testkonto einen Kontostand < 0 besitzt,
    UND für das Testkonto Kontostand + dispo >= 0 gilt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert ”soll” besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_07() {
        Konto testKonto = createTestKonto(-1, 2); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("g");
        assertEquals("g", testKonto.getStatus()); //UND das Testkonto den Status ”gesperrt” besitzt,

        assertTrue(testKonto.getKontostand() < 0); //UND das Testkonto einen Kontostand < 0 besitzt,
        assertTrue(testKonto.getKontostand() + testKonto.getDispo() >= 0); //UND für das Testkonto Kontostand + dispo >= 0 gilt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("s", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”soll” besitzen.
    }

    /*
    @Test: kontoAktualisieren_08()
    WENN ein Testkonto bereits in der DB existiert,
    UND das Testkonto den Status ”gesperrt” besitzt,
    UND das Testkonto einen Kontostand >= 0 besitzt,
    UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
    DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen.
    @author Alexander
     */
    @Test
    public void kontoAktualisieren_08() {
        Konto testKonto = createTestKonto(20, 2); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("g");
        assertEquals("g", testKonto.getStatus()); //UND das Testkonto den Status ”soll” besitzt,

        assertTrue(testKonto.getKontostand() >= 0); //UND das Testkonto einen Kontostand >= 0 besitzt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("h", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen.
    }

    /*
    @Test: ueberweisungAusfuehren_00()
    WENN eine TestUeberweisung bereits in der DB existiert,
    UND die TestUeberweisung den Status ”wartet” besitzt,
    UND das über das Attribut vonkonto referenzierte Konto den Status ”haben” besitzt,
    UND die Methode ueberweisungAusfuehren mit der Id der TestUeberweisung aufgerufen wird,
    DANN sollte sie TRUE zurückliefern,
    UND der Status der TestUeberweisung sollte auf ”ueberwiesen” gesetzt sein,
    UND der Kontostand des zu belastenden Kontos sollte um den Betrag der TestUeberweisung reduziert sein,
    UND der Kontostand des gutgeschriebenen Kontos sollte um den Betrag der TestUeberweisung erhöht sein.
    @author Alexander
     */
    @Test
    public void ueberweisungAusfuehren_00() {
        Ueberweisung testUeberweisung = createTestUeberweisung();//TestUeberweisung erstellen
        classUnderTest.ueberweisungErfassen(testUeberweisung);

        assertNotNull(entityManager.find(Ueberweisung.class, testUeberweisung.getUbid())); //WENN eine TestUeberweisung bereits in der DB existiert,
        assertEquals("wt", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND die TestUeberweisung den Status ”wartet” besitzt,
        classUnderTest.kontoFreischalten(testUeberweisung.getVonkonto().getKtoid());
        assertEquals("h", entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid()).getStatus()); //UND das über das Attribut vonkonto referenzierte Konto den Status ”haben” besitzt,
        boolean ergebnis = classUnderTest.ueberweisungAusfuehren(testUeberweisung.getUbid()); //UND die Methode ueberweisungAusfuehren mit der Id der TestUeberweisung aufgerufen wird,
        assertTrue(ergebnis);
        assertEquals("us", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND der Status der TestUeberweisung sollte auf ”ueberwiesen” gesetzt sein,
        assertTrue(entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid()).getKontostand() == 0); //UND der Kontostand des zu belastenden Kontos sollte um den Betrag der TestUeberweisung reduziert sein,
        assertTrue(entityManager.find(Konto.class, testUeberweisung.getZukonto().getKtoid()).getKontostand() == 60.50); //UND der Kontostand des gutgeschriebenen Kontos sollte um den Betrag der TestUeberweisung erhöht sein.      
    }

    /*
    @Test: ueberweisungAusfuehren_01()
    WENN eine TestUeberweisung bereits in der DB existiert,
    UND die TestUeberweisung den Status ”wartet” besitzt,
    UND das über das Attribut vonkonto referenzierte Konto den Status ”gesperrt” besitzt,
    UND die Methode ueberweisungAusfuehren mit der Id der TestUeberweisung aufgerufen wird,
    DANN sollte sie FALSE zurückliefern,
    UND der Status der TestUeberweisung sollte auf ”nicht ueberweisbar” gesetzt sein,
    UND der Kontostand des zu belastenden Kontos sollte nicht verändert worden sein,
    UND der Kontostand des gutgeschriebenen Kontos sollte nicht verändert worden sein.
    @author Alexander
     */
    @Test
    public void ueberweisungAusfuehren_01() {
        Ueberweisung testUeberweisung = createTestUeberweisung();//TestUeberweisung erstellen
        classUnderTest.ueberweisungErfassen(testUeberweisung);

        assertNotNull(entityManager.find(Ueberweisung.class, testUeberweisung.getUbid())); //WENN eine TestUeberweisung bereits in der DB existiert,
        assertEquals("wt", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND die TestUeberweisung den Status ”wartet” besitzt,
        classUnderTest.kontoFreischalten(testUeberweisung.getVonkonto().getKtoid());
        testUeberweisung.getVonkonto().setStatus("g");
        assertEquals("g", entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid()).getStatus()); //UND das über das Attribut vonkonto referenzierte Konto den Status ”gesperrt” besitzt,
        boolean ergebnis = classUnderTest.ueberweisungAusfuehren(testUeberweisung.getUbid()); //UND die Methode ueberweisungAusfuehren mit der Id der TestUeberweisung aufgerufen wird,
        assertFalse(ergebnis);
        assertEquals("nu", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND der Status der TestUeberweisung sollte auf ”nicht ueberweisbar” gesetzt sein,
        assertTrue(entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid()).getKontostand() == 30.25); //UND der Kontostand des zu belastenden Kontos sollte nicht verändert worden sein,
        assertTrue(entityManager.find(Konto.class, testUeberweisung.getZukonto().getKtoid()).getKontostand() == 30.25); //UND der Kontostand des gutgeschriebenen Kontos sollte nicht verändert worden sein.

    }

    /*
    @Test: ueberweisungAusfuehren_02()
    WENN eine TestUeberweisung bereits in der DB existiert,
    UND die TestUeberweisung den Status ”wartet” besitzt,
    UND das Attribut vonkonto das Konto VonKonto referenziert,
    UND das Konto VonKonto den Status ”haben” besitzt,
    UND für VonKonto gilt: kontostand + dispo < Betrag von TestUeberweisung,
    UND das Attribut zukonto das Konto ZuKonto referenziert,
    UND das Konto ZuKonto den Status ”gesperrt” besitzt,
    UND für ZuKonto gilt: kontostand + Betrag von TestUeberweisung > 0,
    UND die Methode ueberweisungAusfuehren mit der Id der TestUeberweisung aufgerufen wird,
    DANN sollte sie TRUE zurückliefern,
    UND der Status der TestUeberweisung sollte auf ”ueberwiesen” gesetzt sein,
    UND der Kontostand des zu belastenden Kontos sollte um den Betrag der TestUeberweisung reduziert sein,
    UND der Kontostand des gutgeschriebenen Kontos sollte um den Betrag der TestUeberweisung erhöht sein,
    UND der Status von VonKonto sollte auf ”gesperrt” gesetzt sein,
    UND der Status von ZuKonto sollte auf ”haben” gesetzt sein.
    @author Alexander
     */
    @Test
    public void ueberweisungAusfuehren_02() {
        Ueberweisung testUeberweisung = createTestUeberweisung();//TestUeberweisung erstellen
        testUeberweisung.setBetrag(30.30);

        classUnderTest.ueberweisungErfassen(testUeberweisung);

        assertNotNull(entityManager.find(Ueberweisung.class, testUeberweisung.getUbid())); //WENN eine TestUeberweisung bereits in der DB existiert,
        assertEquals("wt", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND die TestUeberweisung den Status ”wartet” besitzt,

        assertEquals(testUeberweisung.getVonkonto(), entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid())); //UND das Attribut vonkonto das Konto VonKonto referenziert,
        classUnderTest.kontoFreischalten(testUeberweisung.getVonkonto().getKtoid());

        assertEquals("h", entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid()).getStatus()); //UND das Konto VonKonto den Status ”haben” besitzt,
        assertTrue(testUeberweisung.getVonkonto().getKontostand() + testUeberweisung.getVonkonto().getDispo() < testUeberweisung.getBetrag()); //UND für VonKonto gilt: kontostand + dispo < Betrag von TestUeberweisung,

        assertEquals(testUeberweisung.getZukonto(), entityManager.find(Konto.class, testUeberweisung.getZukonto().getKtoid())); //UND das Attribut zukonto das Konto ZuKonto referenziert,
        testUeberweisung.getZukonto().setStatus("g");
        assertEquals("g", testUeberweisung.getZukonto().getStatus()); //UND das Konto ZuKonto den Status ”gesperrt” besitzt,
        assertTrue(testUeberweisung.getZukonto().getKontostand() + testUeberweisung.getBetrag() > 0); //UND für ZuKonto gilt: kontostand + Betrag von TestUeberweisung > 0,

        boolean ergebnis = classUnderTest.ueberweisungAusfuehren(testUeberweisung.getUbid()); //UND die Methode ueberweisungAusfuehren mit der Id der TestUeberweisung aufgerufen wird,
        assertTrue(ergebnis); //DANN sollte sie TRUE zurückliefern,

        assertEquals("us", entityManager.find(Ueberweisung.class, testUeberweisung.getUbid()).getStatus()); //UND der Status der TestUeberweisung sollte auf ”ueberwiesen” gesetzt sein,
        assertTrue(entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid()).getKontostand() < 0); //UND der Kontostand des zu belastenden Kontos sollte um den Betrag der TestUeberweisung reduziert sein,
        assertTrue(entityManager.find(Konto.class, testUeberweisung.getZukonto().getKtoid()).getKontostand() == 60.55); //UND der Kontostand des gutgeschriebenen Kontos sollte um den Betrag der TestUeberweisung erhöht sein.      
        assertEquals("g", entityManager.find(Konto.class, testUeberweisung.getVonkonto().getKtoid()).getStatus()); //UND der Status von VonKonto sollte auf ”gesperrt” gesetzt sein,
        assertEquals("h", entityManager.find(Konto.class, testUeberweisung.getZukonto().getKtoid()).getStatus()); //UND der Status von ZuKonto sollte auf ”haben” gesetzt sein.
    }

    /*
    @Test: kontoFreischalten_00()
    WENN ein TestKonto bereits in der DB existiert,
    UND das TestKonto den Status ”init” besitzt,
    UND die Methode kontoFreischalten mit der Id der TestKontos aufgerufen wird,
    DANN sollte sie TRUE zurückliefern,
    UND der Status des TestKonto sollte auf ”haben” gesetzt sein.
    @author Alexander
     */
    @Test
    public void kontoFreischalten_00() {
        Konto testKonto = createTestKonto(20, 0); //TestKonto erstellen

        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein TestKonto bereits in der DB existiert,
        assertEquals("i", testKonto.getStatus()); //UND das TestKonto den Status ”init” besitzt,

        boolean ergebnis = classUnderTest.kontoFreischalten(testKonto.getKtoid()); //UND die Methode kontoFreischalten mit der Id der TestKontos aufgerufen wird,
        assertTrue(ergebnis); //DANN sollte sie TRUE zurückliefern,
        assertEquals("h", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //UND der Status des TestKonto sollte auf ”haben” gesetzt sein.

    }

    /*
    @Test: kontoFreischalten_01()
    WENN ein TestKonto bereits in der DB existiert,
    UND das TestKonto nicht den Status ”init” besitzt,
    UND die Methode kontoFreischalten mit der Id der TestKontos aufgerufen wird,
    DANN sollte sie FALSE zurückliefern,
    UND der Status des TestKonto sollte nicht verändert worden sein.
    @author Alexander
     */
    @Test
    public void kontoFreischalten_01() {
        Konto testKonto = createTestKonto(20, 0); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein TestKonto bereits in der DB existiert,

        testKonto.setStatus("h");
        assertNotEquals("i", testKonto.getStatus()); //UND das TestKonto nicht den Status ”init” besitzt,

        boolean ergebnis = classUnderTest.kontoFreischalten(testKonto.getKtoid()); //UND die Methode kontoFreischalten mit der Id der TestKontos aufgerufen wird,
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern,
        assertEquals("h", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //UND der Status des TestKonto sollte nicht verändert worden sein.
    }

    /*
    @Test: kontoFreischalten_02()
    WENN ein TestKonto nicht in der DB existiert,
    UND die Methode kontoFreischalten mit der Id der TestKontos aufgerufen wird,
    DANN sollte sie FALSE zurückliefern.
    @author Alexander
     */
    @Test
    public void kontoFreischalten_02() {
        Konto testKonto = createTestKonto(20, 0); //TestKonto erstellen

        entityManager.remove(testKonto);
        assertNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein TestKonto nicht in der DB existiert,

        boolean ergebnis = classUnderTest.kontoFreischalten(testKonto.getKtoid()); //UND die Methode kontoFreischalten mit der Id der TestKontos aufgerufen wird,
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern.       
    }

    public Kunde createTestKunde() {
        Kunde testKunde = new Kunde(null, "Dr.", "Fast", "Richtig", new Date(), "m", "v");
        entityManager.persist(testKunde);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testKunde;
    }

    public Kunde createTestKundeMitKonto(Konto k) {
        Kunde testKunde = new Kunde(null, "Dr.", "Fast", "Richtig", new Date(), "m", "v");
        List<Konto> kontoList = new ArrayList<>();
        kontoList.add(k);
        testKunde.setKontoList(kontoList);
        entityManager.persist(testKunde);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testKunde;
    }

    public Konto createTestKonto(double kontostand, double dispo) {
        Konto testKonto = new Konto(null, "g", new Date(), kontostand, dispo, "i");
        entityManager.persist(testKonto);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testKonto;
    }

    public Ueberweisung createTestUeberweisung() {
        Ueberweisung testUeberweisung = new Ueberweisung(null, 30.25, new Date(), "");
        testUeberweisung.setVonkonto(createTestKonto(30.25, 0));
        testUeberweisung.setZukonto(createTestKonto(30.25, 0));
        testUeberweisung.setKunde(createTestKunde());
        return testUeberweisung;
    }

    public Zahlungsverkehr createTestZahlungsverkehr(Konto k) {
        Zahlungsverkehr testZahlungsverkehr = new Zahlungsverkehr(null, new Date(100, 1, 1), "testErlaeuterung", false);
        testZahlungsverkehr.setKonto(k);
        testZahlungsverkehr.setHaben(10.00);
        testZahlungsverkehr.setSoll(0.00);
        entityManager.persist(testZahlungsverkehr);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testZahlungsverkehr;
    }
}
