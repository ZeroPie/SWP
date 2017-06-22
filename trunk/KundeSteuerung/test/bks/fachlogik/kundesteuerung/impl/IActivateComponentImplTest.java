package bks.fachlogik.kundesteuerung.impl;

import bks.datenhaltung.bksdbmodel.entities.Kunde;
import bks.datenhaltung.bksdbmodel.impl.IDatabaseImpl;
import bks.datenhaltung.bksdbmodel.services.IDatabase;
import bks.fachlogik.componentcontroller.services.*;
import java.util.Date;
import javax.persistence.EntityManager;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Alexander
 */
public class IActivateComponentImplTest {

    private static EntityManager entityManager;
    private final static IDatabase iDatabase = new IDatabaseImpl();
    private IActivateComponent classUnderTest;

    @BeforeClass
    public static void setUp() {
        entityManager = iDatabase.getEntityManager();
    }

    /*
    @After
    Nach dem Test Datenbank rollback
     */
    @After
    public void amEnde() {
        entityManager.getTransaction().rollback();
    }

    /*
    @Before: angenommen()
    ANGENOMMEN die Implementierung 
    der IActivateComponent-Schnittstelle 
    wird als classUnderTest instanziiert.
     */
    @Before
    public void angenommen() {
        classUnderTest = new IActivateComponentImpl();
        entityManager.getTransaction().begin();
    }

    /*
    @Test: getCompType_00()
    WENN die Methode getCompType aufgerufen wird,
    UND die Komponente aktiviert ist,
    DANN sollte sie den CompType KUNDE zurückliefern.
     */
    @Test
    public void getCompType_00() {
        Kunde testKunde = createTestKunde(); //TestKunden in die Datenbank einfügen
        classUnderTest.activateComponent(testKunde.getKid()); //Komponente aktivieren
        assertTrue(classUnderTest.isActivated()); //UND die Komponente aktiviert ist,

        CompType expectetCompType = CompType.KUNDE;
        CompType compType = classUnderTest.getComponentType(); //WENN die Methode getCompType aufgerufen wird,
        assertEquals(expectetCompType, compType); //DANN sollte sie den CompType KUNDE zurückliefern.
    }

    /*
    @Test: getCompType_01()
    WENN die Methode getCompType aufgerufen wird,
    UND die Komponente deaktiviert ist,
    DANN sollte sie null zurückliefern.
     */
    @Test
    public void getCompType_01() {
        classUnderTest.deactivateComponent(); //Komponente deaktivieren
        assertFalse(classUnderTest.isActivated()); //UND die Komponente deaktiviert ist,
        CompType compType = classUnderTest.getComponentType(); //WENN die Methode getCompType aufgerufen wird,
        assertNull(compType); //DANN sollte sie null zurückliefern.
    }

    /*
    @Test: activateComponent_00()
    WENN ein Testkunde bereits in der DB existiert,
    UND die Methode activateComponent mit der Id des Testkunden aufgerufen wird,
    UND die Komponente sich im Zustand deactivated befindet,
    DANN sollte sie TRUE zurückliefern,
    UND der Zustand in activated gewechselt sein.
     */
    @Test
    public void activateComponent_00() {
        Kunde testKunde = createTestKunde(); //Testkunde in Datenbank einfügen
        assertNotNull(entityManager.find(Kunde.class, testKunde.getKid())); //WENN ein Testkunde bereits in der DB existiert,

        classUnderTest.deactivateComponent(); //Komponente deaktivieren
        assertFalse(classUnderTest.isActivated()); //UND die Komponente sich im Zustand deactivated befindet,

        boolean ergebnis = classUnderTest.activateComponent(testKunde.getKid()); //UND die Methode activateComponent mit der Id des TestKunde aufgerufen wird,
        boolean aktiv = classUnderTest.isActivated();

        assertTrue(ergebnis); //DANN sollte sie TRUE zurückliefern,
        assertTrue(aktiv); //UND der Zustand in activated gewechselt sein.
    }

    /*
    @Test: activateComponent_01()
    WENN ein Testkunde bereits in der DB existiert,
    UND die Methode activateComponent mit der Id des Testkunden aufgerufen wird,
    UND die Komponente sich im Zustand activated befindet,
    DANN sollte sie FALSE zurückliefern,
    UND der Zustand in activated bleiben.
     */
    @Test
    public void activateComponent_01() {
        Kunde testKunde = createTestKunde(); //Testkunde in Datenbank einfügen
        assertNotNull(entityManager.find(Kunde.class, testKunde.getKid())); //WENN ein Testkunde bereits in der DB existiert,

        classUnderTest.activateComponent(testKunde.getKid()); //Komponente aktivieren
        assertTrue(classUnderTest.isActivated()); //UND die Komponente sich im Zustand activated befindet,

        boolean ergebnis = classUnderTest.activateComponent(testKunde.getKid()); //UND die Methode activateComponent mit der Id des TestKunde aufgerufen wird,
        boolean aktiv = classUnderTest.isActivated();

        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern,
        assertTrue(aktiv); //UND der Zustand in activated bleiben.
    }

    /*
    @Test: activateComponent_02()
    WENN ein Testkunde nicht in der DB existiert,
    WENN die Methode activateComponent mit der Id des Testkunden aufgerufen wird,
    UND die Komponente sich im Zustand deactivated befindet,
    DANN sollte sie FALSE zurückliefern,
    UND der Zustand in deactivated bleibe
     */
    @Test
    public void activateComponent_02() {
        Kunde testKunde = createTestKunde(); //Testkunde in Datenbank einfügen
        entityManager.remove(entityManager.find(Kunde.class, testKunde.getKid())); //Testkunde aus Datenbank entfernen
        assertNull(entityManager.find(Kunde.class, testKunde.getKid())); //WENN ein Testkunde nicht in der DB existiert,

        classUnderTest.deactivateComponent(); //Komponente deaktivieren
        assertFalse(classUnderTest.isActivated()); //UND die Komponente sich im Zustand deactivated befindet,

        boolean ergebnis = classUnderTest.activateComponent(testKunde.getKid()); //UND die Methode activateComponent mit der Id des TestKunde aufgerufen wird,
        boolean aktiv = classUnderTest.isActivated();

        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern,
        assertFalse(aktiv); //UND der Zustand in deactivated bleiben.
    }

    /*
    @Test: activateComponent_03()
    WENN ein Testkunde nicht in der DB existiert,
    WENN die Methode activateComponent mit der Id des Testkunden aufgerufen wird,
    UND die Komponente sich im Zustand activated befindet,
    DANN sollte sie FALSE zurückliefern,
    UND der Zustand in activated bleiben.
     */
    @Test
    public void activateComponent_03() {
        Kunde testKunde = createTestKunde(); //Testkunde in Datenbank einfügen

        classUnderTest.activateComponent(testKunde.getKid()); //Komponente aktivieren
        assertTrue(classUnderTest.isActivated()); //UND die Komponente sich im Zustand activated befindet,

        entityManager.remove(entityManager.find(Kunde.class, testKunde.getKid())); //Testkunde aus Datenbank entfernen
        assertNull(entityManager.find(Kunde.class, testKunde.getKid())); //WENN ein Testkunde nicht in der DB existiert,

        boolean ergebnis = classUnderTest.activateComponent(testKunde.getKid()); //UND die Methode activateComponent mit der Id des TestKunde aufgerufen wird,
        boolean aktiv = classUnderTest.isActivated();

        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern,
        assertTrue(aktiv); //UND der Zustand in activated bleiben.
    }

    /*
    @Test: deactivateComponent_00()
    WENN die Methode deactivateComponent aufgerufen wird,
    UND die Komponente sich im Zustand activated befindet,
    DANN sollte sie TRUE zurückliefern,
    UND der Zustand in deactivated gewechselt sein.
     */
    @Test
    public void deactivateComponent_00() {
        Kunde testKunde = createTestKunde(); //Testkunde in Datenbank einfügen
        classUnderTest.activateComponent(testKunde.getKid()); //Komponente aktivieren

        assertTrue(classUnderTest.isActivated()); //UND die Komponente sich im Zustand activated befindet,

        boolean ergebnis = classUnderTest.deactivateComponent(); //WENN die Methode deactivateComponent aufgerufen wird,
        boolean aktiv = classUnderTest.isActivated();

        assertTrue(ergebnis); //DANN sollte sie TRUE zurückliefern,
        assertFalse(aktiv); //UND der Zustand in deactivated gewechselt sein.
    }

    /*
    @Test: deactivateComponent_01()
    WENN die Methode deactivateComponent aufgerufen wird,
    UND die Komponente sich im Zustand deactivated befindet,
    DANN sollte sie FALSE zurückliefern,
    UND der Zustand in deactivated bleiben.
     */
    @Test
    public void deactivateComponent_01() {
        classUnderTest.deactivateComponent(); //Komponente deaktivieren
        assertFalse(classUnderTest.isActivated()); //UND die Komponente sich im Zustand deaktivated befindet,

        boolean ergebnis = classUnderTest.deactivateComponent(); //WENN die Methode deactivateComponent() aufgerufen wird,
        assertFalse(ergebnis); //Dann sollte sie FALSE zurückliefern

        boolean aktiv = classUnderTest.isActivated();
        assertFalse(aktiv); //UND der Zustand in deactivated bleiben.
    }

    /*
    @Test: isActivated_00()
    WENN die Methode isActivated aufgerufen wird,
    UND die Komponente aktiviert ist,
    DANN sollte sie TRUE zurückliefern.
     */
    @Test
    public void isActivated_00() {
        Kunde testKunde = createTestKunde(); //Testkunde in Datenbank einfügen
        classUnderTest.activateComponent(testKunde.getKid()); //UND die Komponente aktiviert ist,
        boolean ergebnis;
        ergebnis = classUnderTest.isActivated(); //WENN die Methode isActivated() aufgerufen wird,
        assertTrue(ergebnis); //DANN sollte sie TRUE zurückliefern.
    }

    /*
    @Test: isActivated_01()
    WENN die Methode isActivated aufgerufen wird,
    UND die Komponente deaktiviert ist,
    DANN sollte sie FALSE zurückliefern
     */
    @Test
    public void isActivated_01() {
        classUnderTest.deactivateComponent(); //Status der Komponente auf deaktiv setzen
        assertFalse(classUnderTest.isActivated()); //Und die Komponente deaktiviert ist,
        boolean ergebnis;
        ergebnis = classUnderTest.isActivated(); //WENN die Methode isActivated() aufgerufen wird,
        assertFalse(ergebnis); //DANN sollte sie FALSE zurückliefern.
    }

    public static Kunde createTestKunde() {
        Kunde testKunde = new Kunde(null, "Dr.", "Fast", "Richtig", new Date(), "m", "v");
        entityManager.persist(testKunde);
        entityManager.flush(); // <== Erhaelt damit ID aus der DB
        return testKunde;
    }

}
