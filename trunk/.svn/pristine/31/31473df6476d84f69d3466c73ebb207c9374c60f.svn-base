package bks.fachlogik.kontosteuerung.impl;

import bks.fachlogik.componentcontroller.services.CompType;
import bks.fachlogik.componentcontroller.services.IActivateComponent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Barthy
 * AP4 Barthélémy Bonhomme
 */
public class IActivateComponentImplTest {
    
    private IActivateComponent classUnderTest;
    
    @Before
    public void angenommen() {
        this.classUnderTest = new IActivateComponentImpl();
    }

    /*
    @Test: getCompType()_00
    WENN die Methode getCompType aufgerufen wird,
    UND die Komponente aktiviert ist,
    DANN sollte sie den CompType KONTO zurückliefern.
    */
    @Test
    public void getCompType_00() {
        this.classUnderTest.activateComponent(23);                  // Komponente aktivieren
        assertTrue(this.classUnderTest.isActivated());              // UND die Komponente aktiviert ist,

        CompType expectetCompType = CompType.KONTO;
        CompType compType = this.classUnderTest.getComponentType(); // WENN die Methode getCompType aufgerufen wird,
        assertEquals(expectetCompType, compType);                   // DANN sollte sie den CompType KONTO zurückliefern.
    }
    
    /*
    @Test: activateComponent()_00
    WENN die Methode activateComponent mit der userid 23 aufgerufen wird,
    UND die Komponente sich im Zustand deactivated befindet,
    DANN sollte sie TRUE zurückliefern,
    UND der Zustand in activated gewechselt sein.
    */
    @Test
    public void activateComponent_00(){
        this.classUnderTest.deactivateComponent();
        assertFalse(this.classUnderTest.isActivated());             // UND die Komponente sich im Zustand deactivated befindet,
        
        boolean result = this.classUnderTest.activateComponent(23); // WENN die Methode activateComponent mit der userid 23 aufgerufen wird,
        assertTrue(result);                                         // DANN sollte sie TRUE zurückliefern,
        assertTrue(this.classUnderTest.isActivated());              // UND der Zustand in activated gewechselt sein.
    }
    
    /*
     @Test: activateComponent()_01
    WENN die Methode activateComponent mit der userid 23 aufgerufen wird,
    UND die Komponente sich im Zustand activated befindet,
    DANN sollte sie FALSE zurückliefern,
    UND der Zustand in activated bleiben.
    */
    @Test
    public void activateComponent_01(){
        this.classUnderTest.activateComponent(23);
        assertTrue(this.classUnderTest.isActivated());              // UND die Komponente sich im Zustand activated befindet,
        
        boolean result = this.classUnderTest.activateComponent(23); // WENN die Methode activateComponent mit der userid 23 aufgerufen wird,
        assertFalse(result);                                        // DANN sollte sie FALSE zurückliefern,
        assertTrue(this.classUnderTest.isActivated());              // UND der Zustand in activated bleiben.
    }
    
     /*
    @Test: activateComponent()_02
    WENN die Methode activateComponent mit einer userid ungleich 23 aufgerufen wird,
    UND die Komponente sich im Zustand deactivated befindet,
    DANN sollte sie FALSE zurückliefern,
    UND der Zustand in deactivated bleiben.
    */
    @Test
    public void activateComponent_02(){
        this.classUnderTest.deactivateComponent();
        assertFalse(this.classUnderTest.isActivated());             // UND die Komponente sich im Zustand deactivated befindet,
        
        boolean result = this.classUnderTest.activateComponent(10); // WENN die Methode activateComponent mit einer userid ungleich 23 aufgerufen wird,
        assertFalse(result);                                        // DANN sollte sie FALSE zurückliefern,
        assertFalse(this.classUnderTest.isActivated());             // UND der Zustand in deactivated bleiben.
    }
    
    /*
    @Test: activateComponent()_03
    WENN die Methode activateComponent mit einer userid ungleich 23 aufgerufen wird,
    UND die Komponente sich im Zustand activated befindet,
    DANN sollte sie FALSE zurückliefern,
    UND der Zustand in activated bleiben.
    */
    @Test
    public void activateComponent_03(){
        this.classUnderTest.activateComponent(23);
        assertTrue(this.classUnderTest.isActivated());              // UND die Komponente sich im Zustand activated befindet,
        
        boolean result = this.classUnderTest.activateComponent(10); // WENN die Methode activateComponent mit einer userid ungleich 23 aufgerufen wird,
        assertFalse(result);                                        // DANN sollte sie FALSE zurückliefern,
        assertTrue(this.classUnderTest.isActivated());              // UND der Zustand in activated bleiben.
    }
    
    /*
    @Test: deactivateComponent()_00
    WENN die Methode deactivateComponent aufgerufen wird,
    UND die Komponente sich im Zustand activated befindet,
    DANN sollte sie TRUE zurückliefern,
    UND der Zustand in deactivated gewechselt sein.
    */
    @Test
    public void deactivateComponent_00(){
        this.classUnderTest.activateComponent(23);
        assertTrue(this.classUnderTest.isActivated());      // UND die Komponente sich im Zustand activated befindet,
        
        boolean result = this.classUnderTest.deactivateComponent(); // WENN die Methode deactivateComponent aufgerufen wird,
        assertTrue(result);                                 // DANN sollte sie FALSE zurückliefern,
        assertFalse(this.classUnderTest.isActivated());     // UND der Zustand in deactivated gewechselt sein.
    }
    
    /*
    @Test: deactivateComponent()_01
    WENN die Methode deactivateComponent aufgerufen wird,
    UND die Komponente sich im Zustand deactivated befindet,
    DANN sollte sie FALSE zurückliefern,
    UND der Zustand in deactivated bleiben.
    */
    @Test
    public void deactivateComponent_01(){
        this.classUnderTest.deactivateComponent();
        assertFalse(this.classUnderTest.isActivated());     // UND die Komponente sich im Zustand deactivated befindet,
    
        boolean result = this.classUnderTest.deactivateComponent(); // WENN die Methode deactivateComponent aufgerufen wird,
        assertFalse(result);                                // DANN sollte sie FALSE zurückliefern,
        assertFalse(this.classUnderTest.isActivated());     // UND der Zustand in deactivated bleiben.
    }
    
    /*
    @Test: isActivated()_00
    WENN die Methode isActivated aufgerufen wird,
    UND die Komponente aktiviert ist,
    DANN sollte sie TRUE zurückliefern.
    */
    @Test
    public void isActivated_00(){
        this.classUnderTest.activateComponent(23);
        assertTrue(this.classUnderTest.isActivated());      // UND die Komponente aktiviert ist,
        
        boolean result = this.classUnderTest.isActivated(); // WENN die Methode isActivated aufgerufen wird,
        assertTrue(result);                                 // DANN sollte sie TRUE zurückliefern.
    }
    
    /*
    @Test: isActivated()_01
    WENN die Methode isActivated aufgerufen wird,
    UND die Komponente deaktiviert ist,
    DANN sollte sie FALSE zurückliefern.
    */
    @Test
    public void isActivated_01(){
        this.classUnderTest.deactivateComponent();
        assertFalse(this.classUnderTest.isActivated());     // UND die Komponente deaktiviert ist,
        
        boolean result = this.classUnderTest.isActivated(); // WENN die Methode isActivated aufgerufen wird,
        assertFalse(result);                                // DANN sollte sie FALSE zurückliefern.
    }
    
}
