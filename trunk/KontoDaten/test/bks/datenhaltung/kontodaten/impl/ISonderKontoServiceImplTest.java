package bks.datenhaltung.kontodaten.impl;

import javax.persistence.EntityManager;
import bks.datenhaltung.bksdbmodel.entities.Konto;
import bks.datenhaltung.kontodaten.services.ISonderKontoService;
import bks.datenhaltung.bksdbmodel.impl.IDatabaseImpl;
import bks.datenhaltung.bksdbmodel.services.IDatabase;
import bks.datenhaltung.kontodaten.impl.ISonderKontoServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.junit.*;
import static org.junit.Assert.*;

public class ISonderKontoServiceImplTest {
    
    private static EntityManager entityManager;
    private final static IDatabase iDatabase = new IDatabaseImpl();
    private ISonderKontoServiceImpl classUnderTest;

    @BeforeClass
    public static void setUp() {
        entityManager = iDatabase.getEntityManager();
    }

    
    /* Angenommen der EntityManager wird korrekt geholt,
     * UND die Implementierung der ISonderKontoService Schnittstelle wird als classUnderTest instanziiert,
     * UND der EntityManager em wird per setEntityManager Methode der classUnderTest gesetzt,
     * UND die Transaktion von em wird gestartet,
     * UND die Daten der betreffenden Entitäten wurden in der DB gelöscht. *///
    @Before
    public void angenommen() {
        classUnderTest = new ISonderKontoServiceImpl();
        classUnderTest.setEntityManager(entityManager);
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("DELETE FROM Zahlungsverkehr").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Konto").executeUpdate();
    }

    /* Am Ende wird die Transaktion zurück gesetzt. */
    @After
    public void amEnde() {
        entityManager.getTransaction().rollback();
    }

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND die Methode getKontoByID mit der Id des Testkontos aufgerufen wird,
     * DANN sollte sie das Testkonto zurückliefern. */
    @Test
    public void getKontoByID_00() {
        Konto testKonto = createTestKonto(10, 1);
        Konto databaseKonto = classUnderTest.getKontoByID(testKonto.getKtoid());
        assertEquals(testKonto, databaseKonto);
    }

    /* WENN ein Testkonto nicht in der DB existiert,
     * UND die Methode getKontoByID mit der Id des Testkontos aufgerufen wird,
     * DANN sollte sie NULL zurückliefern. */
    @Test
    public void getKontoByID_01() {
        Konto testKonto = createTestKonto(10, 1);
        entityManager.remove(testKonto);
        Konto databaseKonto = classUnderTest.getKontoByID(testKonto.getKtoid());
        assertNull(databaseKonto);
    }

    /* WENN x (x>0) Konten mit Status ”soll” oder Status ”gesperrt” in der DB existieren,
     * UND die Methode getUeberzogeneKontosaufgerufen wird,
     * DANN sollte sie die Liste dieser x Konten zurückliefern. */
    @Test
    public void getUeberzogeneKontos_00() {
        Konto testKonto = createTestKonto(-10, -10);
        testKonto.setStatus("s");
        List<Konto> testKontoList = new ArrayList<>();
        List<Konto> kontoList = new ArrayList<>();
        kontoList = classUnderTest.getUeberzogeneKontos();
        testKontoList.add(testKonto);
        assertEquals(testKontoList, kontoList);
    }

    /* WENN keine Konten mit Status ”soll” oder Status ”gesperrt” in der DB existieren,
     * UND die Methode getUeberzogeneKontos aufgerufen wird,
     * DANN sollte sie eine leere Liste zurückliefern. */
    @Test
    public void getUeberzogeneKontos_01() {
        Konto testKonto = createTestKonto(-10, -10);
        entityManager.remove(testKonto);
        List<Konto> kontoList = new ArrayList<>();
        kontoList = classUnderTest.getUeberzogeneKontos();
        assertEquals(0, kontoList.size());
    }

    /* WENN eine TestKonto bereits in der DB existiert,
     * UND das TestKonto den Status ”haben” besitzt,
     * UND die Methode neuesDispoSetzen mit der Id des TestKontos und dem neuen Dispo d aufgerufen wird,
     * DANN sollte sie TRUE zurückliefern,
     * UND der Status des TestKontos sollte auf ”haben” gesetzt sein,
     * UND der Dispo des TestKontos sollte auf den Wert d gesetzt sein. */
    @Test
    public void neuesDispoSetzen_00() {
        Konto testKonto = createTestKonto(10, 1); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("h");
        assertEquals("h", testKonto.getStatus()); //UND das Testkonto den Status ”haben” besitzt,

        boolean ergebnis = classUnderTest.neuesDispoSetzen(testKonto.getKtoid(), 10); //UND die Methode neuesDispoSetzen mit der Id des TestKontos und dem neuen Dispo d aufgerufen wird,
        assertTrue(ergebnis);       //DANN sollte sie TRUE zurückliefern,
        assertEquals("h", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //UND der Status des TestKontos sollte auf ”haben” gesetzt sein,
        assertEquals(10, entityManager.find(Konto.class, testKonto.getKtoid()).getDispo(), 0); //UND der Dispo des TestKontos sollte auf den Wert d gesetzt sein.
    }

    /* WENN eine TestKonto bereits in der DB existiert,
     * UND das TestKonto den Status ”soll” besitzt,
     * UND für TestKonto gilt: kontostand + d < 0,
     * UND die Methode neuesDispoSetzen mit der Id des TestKontos und dem neuen Dispo
     * d aufgerufen wird,
     * DANN sollte sie TRUE zurückliefern,
     * UND der Status des TestKontos sollte auf ”gesperrt” gesetzt sein,
     * UND der Dispo des TestKontos sollte auf den Wert d gesetzt sein. */
    @Test
    public void neuesDispoSetzen_01() {
        Konto testKonto = createTestKonto(-1, 1); //TestKonto erstellen
        int d = -10;
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("s");
        assertEquals("s", testKonto.getStatus()); //UND das Testkonto den Status ”soll” besitzt,

        assertTrue(testKonto.getKontostand() + d < 0);  //UND für TestKonto gilt: kontostand + d < 0,

        boolean ergebnis = classUnderTest.neuesDispoSetzen(testKonto.getKtoid(), d); //UND die Methode neuesDispoSetzen mit der Id des TestKontos und dem neuen Dispo d aufgerufen wird,
        assertTrue(ergebnis);       //DANN sollte sie TRUE zurückliefern,
        assertEquals("g", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //UND der Status des TestKontos sollte auf ”gesperrt” gesetzt sein,
        assertEquals(d, entityManager.find(Konto.class, testKonto.getKtoid()).getDispo(), 0); //UND der Dispo des TestKontos sollte auf den Wert d gesetzt sein.
    }

    /* WENN eine TestKonto bereits in der DB existiert,
     * UND das TestKonto den Status ”gesperrt” besitzt,
     * UND für TestKonto gilt: kontostand + d > 0,
     * UND die Methode neuesDispoSetzen mit der Id des TestKontos und dem neuen Dispo
     * d aufgerufen wird,
     * DANN sollte sie TRUE zurückliefern,
     * UND der Status des TestKontos sollte auf ”soll” gesetzt sein,
     * UND der Dispo des TestKontos sollte auf den Wert d gesetzt sein. */
    @Test
    public void neuesDispoSetzen_02() {
        Konto testKonto = createTestKonto(10, -1); //TestKonto erstellen
        int d = 10;
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("g");
        assertEquals("g", testKonto.getStatus()); //UND das Testkonto den Status ”gesperrt” besitzt,

        assertTrue(testKonto.getKontostand() + d > 0);  //UND für TestKonto gilt: kontostand + d > 0,

        boolean ergebnis = classUnderTest.neuesDispoSetzen(testKonto.getKtoid(), d); //UND die Methode neuesDispoSetzen mit der Id des TestKontos und dem neuen Dispo d aufgerufen wird,
        assertTrue(ergebnis);       //DANN sollte sie TRUE zurückliefern,
        assertEquals("h", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //UND der Status des TestKontos sollte auf ”haben” gesetzt sein,
        assertEquals(d, entityManager.find(Konto.class, testKonto.getKtoid()).getDispo(), 0); //UND der Dispo des TestKontos sollte auf den Wert d gesetzt sein.
    }

    /* WENN eine TestKonto nicht in der DB existiert,
     * UND die Methode neuesDispoSetzen mit der Id des TestKontos und dem neuen Dispo
     * d aufgerufen wird,
     * DANN sollte sie FALSE zurückliefern. */
    @Test
    public void neuesDispoSetzen_03() {
        Konto testKonto = createTestKonto(10, -1); //TestKonto erstellen                     
        entityManager.remove(testKonto); //WENN eine TestKonto nicht in der DB existiert,
        boolean ergebnis = classUnderTest.neuesDispoSetzen(testKonto.getKtoid(), 10); //UND die Methode neuesDispoSetzen mit der Id des TestKontos und dem neuen Dispo d aufgerufen wird,        
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern.

    }

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status ”haben” besitzt,
     * UND das Testkonto einen Kontostand < 0 besitzt,
     * UND für das Testkonto Kontostand + dispo < 0 gilt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen. */
    @Test
    public void kontoAktualisieren_00() {
        Konto testKonto = createTestKonto(-1, -1); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("h");
        assertEquals("h", testKonto.getStatus()); //UND das Testkonto den Status ”haben” besitzt,

        assertTrue(testKonto.getKontostand() < 0); //UND das Testkonto einen Kontostand < 0 besitzt,
        assertTrue(testKonto.getKontostand() + testKonto.getDispo() < 0); //UND für das Testkonto Kontostand + dispo < 0 gilt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("g", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen.
        //assertEquals("g", testKonto.getStatus() );

    }

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status ”haben” besitzt,
     * UND das Testkonto einen Kontostand < 0 besitzt,
     * UND für das Testkonto Kontostand + dispo >= 0 gilt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert ”soll” besitzen. */
    @Test
    public void kontoAktualisieren_01() {
        Konto testKonto = createTestKonto(-1, 2); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("h");
        assertEquals("h", testKonto.getStatus()); //UND das Testkonto den Status ”haben” besitzt,

        assertTrue(testKonto.getKontostand() < 0); //UND das Testkonto einen Kontostand < 0 besitzt,
        assertTrue(testKonto.getKontostand() + testKonto.getDispo() >= 0); //UND für das Testkonto Kontostand + dispo >= 0 gilt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("s", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”soll” besitzen.        
    }

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status ”haben” besitzt,
     * UND das Testkonto einen Kontostand >= 0 besitzt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen. */
    @Test
    public void kontoAktualisieren_02() {
        Konto testKonto = createTestKonto(20, 2); //TestKonto erstellen
        assertNotNull(entityManager.find(Konto.class, testKonto.getKtoid())); //WENN ein Testkonto bereits in der DB existiert,

        testKonto.setStatus("h");
        assertEquals("h", testKonto.getStatus()); //UND das Testkonto den Status ”haben” besitzt,

        assertTrue(testKonto.getKontostand() >= 0); //UND das Testkonto einen Kontostand >= 0 besitzt,

        classUnderTest.kontoAktualisieren(testKonto.getKtoid()); //UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
        assertEquals("h", entityManager.find(Konto.class, testKonto.getKtoid()).getStatus()); //DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen.
    }

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status ”soll” besitzt,
     * UND das Testkonto einen Kontostand < 0 besitzt,
     * UND für das Testkonto Kontostand + dispo < 0 gilt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen. */
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

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status soll (s) besitzt,
     * UND das Testkonto einen Kontostand < 0 besitzt,
     * UND für das Testkonto Kontostand + dispo >= 0 gilt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert soll (s) besitzen. */
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

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status ”soll” besitzt,
     * UND das Testkonto einen Kontostand >= 0 besitzt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen. */
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

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status ”gesperrt” besitzt,
     * UND das Testkonto einen Kontostand < 0 besitzt,
     * UND für das Testkonto Kontostand + dispo < 0 gilt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert ”gesperrt” besitzen. */
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

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status ”gesperrt” besitzt,
     * UND das Testkonto einen Kontostand < 0 besitzt,
     * UND für das Testkonto Kontostand + dispo >= 0 gilt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert ”soll” besitzen. */
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

    /* WENN ein Testkonto bereits in der DB existiert,
     * UND das Testkonto den Status ”gesperrt” besitzt,
     * UND das Testkonto einen Kontostand >= 0 besitzt,
     * UND die Methode kontoAktualisieren mit der ID des Testkontos aufgerufen wird,
     * DANN sollte danach der Status des Testkontos in der DB den Wert ”haben” besitzen. */
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

    public Konto createTestKonto(double kontostand, double dispo) {
        Konto testKonto = new Konto(null, "g", new Date(), kontostand, dispo, "h");
        entityManager.persist(testKonto);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testKonto;
    }
}