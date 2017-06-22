package bks.datenhaltung.kontodaten.impl;

import bks.datenhaltung.bksdbmodel.entities.Konto;
import bks.datenhaltung.bksdbmodel.entities.Kunde;
import bks.datenhaltung.bksdbmodel.entities.Zahlungsverkehr;
import bks.datenhaltung.bksdbmodel.impl.IDatabaseImpl;
import bks.datenhaltung.bksdbmodel.services.IDatabase;
import bks.datenhaltung.kontodaten.services.ICRUDKonto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Barthy
 * AP4 Barthélémy Bonhomme
 */
public class ICRUDKontoImplTest {
    
    private static EntityManager entityManager;
    private final static IDatabase iDatabase = new IDatabaseImpl();
    
    private ICRUDKonto classUnderTest;
    
    @Before
    public void angenommen() {
        entityManager = ICRUDKontoImplTest.iDatabase.getEntityManager();
        this.classUnderTest = new ICRUDKontoImpl();
        this.classUnderTest.setEntityManager(ICRUDKontoImplTest.entityManager);
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("DELETE FROM Zahlungsverkehr").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Konto").executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Kunde").executeUpdate();
    }
    
    @After
    public void amEnde() {
        entityManager.getTransaction().rollback();
    }
    
    /*
    WENN ein Testkonto bereits in der DB existiert,
    UND die Methode getKontoById mit der Id des Testkontos aufgerufen wird,
    DANN sollte sie das Testkonto zurückliefern.
    */
    @Test
    public void getKontoById_00(){
        Konto testKonto = createTestKonto();
        Konto dbKonto = this.classUnderTest.getKontoByID(testKonto.getKtoid());
        assertEquals(testKonto, dbKonto);
    }
    
    /*
    WENN ein Testkonto nicht in der DB existiert,
    UND die Methode getKontoById mit der Id des Testkontos aufgerufen wird,
    DANN sollte sie NULL zurückliefern.
    */
    @Test
    public void getKontoById_01(){
        Konto testKonto = createTestKonto();
        entityManager.remove(testKonto);
        Konto dbKonto = this.classUnderTest.getKontoByID(testKonto.getKtoid());
        assertNull(dbKonto);
    }
    
    /*
    WENN ein Testkunde bereits in der DB existiert,
    UND für diesen Testkunden x (x>0) Konten in der DB existieren,
    UND die Methode getKontoListeDesKunden mit der ID des Testkunden aufgerufen
    wird,
    DANN sollte sie die Liste seiner x Konten zurückliefern.
    */
    @Test
    public void getKontoListeDesKunden_00(){
        Kunde testKunde = createTestKunde();
        Konto testKonto = new Konto(
                null,
                "g",
                new Date(),
                1000,
                500,
                "i"
        );
        testKonto.setKunde(testKunde);
        entityManager.persist(testKonto);
        
        ArrayList<Konto> testList = new ArrayList<>();
        ArrayList<Konto> dbList = new ArrayList<>(this.classUnderTest.getKontoListeDesKunden(testKunde.getKid()));
        testList.add(testKonto);
        assertEquals(testList, dbList);
    }
    
    /*
    WENN ein Testkunde bereits in der DB existiert,
    UND für diesen Testkunden keine Konten in der DB existieren,
    UND die Methode getKontoListeDesKunden mit der ID des Testkunden aufgerufen
    wird,
    DANN sollte sie eine leere Liste zurückliefern. 
    */
    @Test
    public void getKontoListeDesKunden_01(){
        Kunde testKunde = createTestKunde();
        ArrayList<Konto> dbList = new ArrayList<>(this.classUnderTest.getKontoListeDesKunden(testKunde.getKid()));
        assertEquals(0, dbList.size());
    }
    
    /*
    WENN ein Testkunde nicht in der DB existiert,
    UND die Methode getKontoListeDesKunden mit der ID des Testkunden aufgerufen
    wird,
    DANN sollte sie eine leere Liste zurückliefern.
    */
    @Test
    public void getKontoListeDesKunden_02(){
        Kunde testKunde = createTestKunde();
        entityManager.remove(testKunde);
        ArrayList<Konto> dbList = new ArrayList<>(this.classUnderTest.getKontoListeDesKunden(testKunde.getKid()));
        assertEquals(0, dbList.size());
    }
    
    /*
    WENN die Methode insertKonto mit einem Testkonto aufgerufen wird,
    UND die ID des Testkontos gleich null ist,
    DANN sollte sie TRUE zurückliefern,
    UND das Testkonto sollte in der DB existieren.
    */
    @Test
    public void insertKonto_00(){
        Konto testKonto = new Konto(
                null,
                "g",
                new Date(),
                1000,
                500,
                "i"
        );
        
        boolean result = this.classUnderTest.insertKonto(testKonto);
        assertTrue(result);
        
        entityManager.flush();
        
        Konto dbKonto = entityManager.find(Konto.class, testKonto.getKtoid());
        assertNotNull(dbKonto);
    }
    
    /*
    WENN die Methode insertKonto mit einem Testkonto aufgerufen wird,
    UND die ID des Testkontos ungleich null ist,
    DANN sollte sie FALSE zurückliefern,
    UND die DB wurde nicht verändert.
    */
    @Test
    public void insertKonto_01(){
        Konto testKonto = new Konto(
                10,
                "g",
                new Date(),
                1000,
                500,
                "i"
        );
        
        boolean result = this.classUnderTest.insertKonto(testKonto);
        assertFalse(result);
       
        entityManager.flush();
        
        Konto dbKonto = entityManager.find(Konto.class, testKonto.getKtoid());
        assertNull(dbKonto);
    }
    
    /*
    WENN ein Testkonto in der DB existiert,
    UND die Methode deleteKonto mit der ID des Testkontos aufgerufen wird,
    DANN sollte sie TRUE zurückliefern,
    UND das Testkonto sollte nicht mehr in der DB existieren.
    */
    @Test
    public void deleteKonto_00(){
        Konto testKonto = createTestKonto();
        
        boolean result = this.classUnderTest.deleteKonto(testKonto.getKtoid());
        assertTrue(result);
        
        Konto dbKonto = entityManager.find(Konto.class, testKonto.getKtoid());
        assertNull(dbKonto);
    }
    
    /*
    WENN ein Testkonto nicht in der DB existiert,
    UND die Methode deleteKonto mit der ID des Testkontos aufgerufen wird,
    DANN sollte sie FALSE zurückliefern.
    */
    @Test
    public void deleteKonto_01(){
        Konto testKonto = createTestKonto();
        entityManager.remove(testKonto);
        
        boolean result = this.classUnderTest.deleteKonto(testKonto.getKtoid());
        assertFalse(result);
    }
    
    /*
    WENN ein Testkonto bereits in der DB existiert,
    UND die Methode geldEinzahlen mit der ID des Testkontos, dem Betrag b und 
    dem Text t aufgerufen wird,
    DANN sollte sie TRUE zurückliefern.
    UND der Kontostand des Testkontos ist um den Betrag b erhöht worden,
    UND es wurde ein neues Objekt der Klasse Zahlungsverkehr angelegt,
    UND dieses Objekt besitzt die ID von Testkonto als Wert des Attributs konto,
    UND dieses Objekt besitzt das korrekte Datum als Wert des Attributs datum,
    UND dieses Objekt besitzt den Text t als Wert des Attributs erlaeueterung,
    UND dieses Objekt besitzt den Betrag b als Wert des Attribute haben,
    UND dieses Objekt besitzt 0 als Wert des Attribute soll,
    UND dieses Objekt besitzt 0 als Wert des Attribute ausgedruckt.
    */
    @Test
    public void geldEinzahlen_00(){
        Konto testKonto = createTestKonto();
        String text = "Einzahlung Automat 4711";
        double betrag = 19.11;
        double erwarteterKontostand = testKonto.getKontostand() + betrag;
        
        boolean result = this.classUnderTest.geldEinzahlen(testKonto.getKtoid(), betrag, text);
        assertTrue(result);
        
        entityManager.flush();
        assertEquals(erwarteterKontostand, testKonto.getKontostand(), 0.001);
        
        Query query = entityManager.createNativeQuery("SELECT * FROM Zahlungsverkehr", Zahlungsverkehr.class);
        List<Zahlungsverkehr> list = query.getResultList();
        assertTrue(list.size() > 0);
        if(list.size() > 0){
            Zahlungsverkehr zVk = list.get(0);
            assertEquals(testKonto, zVk.getKonto());
            
            SimpleDateFormat dtFormat = new SimpleDateFormat("y-M-d H"); // vergleiche year, month, day & hour
            Date now = new Date();
            assertEquals(dtFormat.format(now), dtFormat.format(zVk.getDatum()));
            
            assertEquals(text, zVk.getErlaeuterung());
            assertEquals(new Double(betrag), zVk.getHaben());
            assertEquals(new Double(0), zVk.getSoll());
            assertEquals(false, zVk.getAusgedruckt());
        }
    }
    
    /*
    WENN ein Testkonto nicht in der DB existiert,
    UND die Methode geldEinzahlen mit der ID des Testkontos aufgerufen wird,
    DANN sollte sie FALSE zurückliefern.
    */
    @Test
    public void geldEinzahlen_01(){
        Konto testKonto = createTestKonto();
        entityManager.remove(testKonto);
        
        String text = "Einzahlung Automat 4711";
        double betrag = 19.11;
        
        boolean result = this.classUnderTest.geldEinzahlen(testKonto.getKtoid(), betrag, text);
        assertFalse(result);
    }
    
    /*
    WENN ein Testkonto bereits in der DB existiert,
    UND dieses Testkonto nicht den Zustand gesperrt (g) besitzt,
    UND die Methode geldAbheben mit der ID des Testkontos, dem Betrag b und dem Text t
    aufgerufen wird,
    DANN sollte sie TRUE zurückliefern.
    UND der Kontostand des Testkontos ist um den Betrag b verringert worden,
    UND es wurde ein neues Objekt der Klasse Zahlungsverkehr angelegt,
    UND dieses Objekt besitzt die ID von Testkonto als Wert des Attributs konto,
    UND dieses Objekt besitzt das korrekte Datum als Wert des Attributs datum,
    UND dieses Objekt besitzt den Text t als Wert des Attributs erlaeueterung,
    UND dieses Objekt besitzt 0 als Wert des Attribute haben,
    UND dieses Objekt besitzt den Betrag b als Wert des Attribute soll,
    UND dieses Objekt besitzt 0 als Wert des Attribute ausgedruckt.
    */
    @Test
    public void geldAbheben_00(){
        Konto testKonto = createTestKonto();
        String text = "Auszahlung Automat 4711";
        double betrag = 19.11;
        double erwarteterKontostand = testKonto.getKontostand() - betrag;
        
        boolean result = this.classUnderTest.geldAbheben(testKonto.getKtoid(), betrag, text);
        assertTrue(result);
        
        entityManager.flush();
        assertEquals(erwarteterKontostand, testKonto.getKontostand(), 0.001);
        
        Query query = entityManager.createNativeQuery("SELECT * FROM Zahlungsverkehr", Zahlungsverkehr.class);
        List<Zahlungsverkehr> list = query.getResultList();
        assertTrue(list.size() > 0);
        if(list.size() > 0){
            Zahlungsverkehr zVk = list.get(0);
            assertEquals(testKonto, zVk.getKonto());
            
            SimpleDateFormat dtFormat = new SimpleDateFormat("y-M-d H"); // vergleiche year, month, day & hour
            Date now = new Date();
            assertEquals(dtFormat.format(now), dtFormat.format(zVk.getDatum()));
            
            assertEquals(text, zVk.getErlaeuterung());
            assertEquals(new Double(0), zVk.getHaben());
            assertEquals(new Double(betrag), zVk.getSoll());
            assertEquals(false, zVk.getAusgedruckt());
        }
    }
    
    /*
    WENN ein Testkonto bereits in der DB existiert,
    UND dieses Testkonto den Zustand gesperrt (g) besitzt,
    UND die Methode geldAbheben mit der ID des Testkontos aufgerufen wird,
    DANN sollte sie FALSE zurückliefern.
    */
    @Test
    public void geldAbheben_01(){
        Konto testKonto = createTestKonto();
        testKonto.setStatus("g");
        String text = "Auszahlung Automat 4711";
        double betrag = 19.11;
        
        boolean result = this.classUnderTest.geldAbheben(testKonto.getKtoid(), betrag, text);
        assertFalse(result);
    }
    
    /*
    WENN ein Testkonto nicht in der DB existiert,
    UND die Methode geldAbheben mit der ID des Testkontos aufgerufen wird,
    DANN sollte sie FALSE zurückliefern.
    */
    @Test
    public void geldAbheben_02(){
        Konto testKonto = createTestKonto();
        entityManager.remove(testKonto);
        
        String text = "Auszahlung Automat 4711";
        double betrag = 19.11;
        
        boolean result = this.classUnderTest.geldAbheben(testKonto.getKtoid(), betrag, text);
        assertFalse(result);
    }
    
    private Kunde createTestKunde(){
        Kunde testKunde = new Kunde(
                null,
                "Dr.",
                "Walter",
                "Bishop",
                new Date(),
                "m",
                "v"
        );
        entityManager.persist(testKunde);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testKunde;
    }
    
    private Konto createTestKonto(){
        Konto testKonto = new Konto(
                null,
                "g",
                new Date(),
                1000,
                500,
                "i"
        );
        entityManager.persist(testKonto);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testKonto;
    }
}
