---
##### Datenhaltung | KundeDaten
---

#### kundedaten.impl
- [ICrudKundeImpl

#### kundedaten.services(Interfaces)
- [ICrudKunde]

#### test
- [ICRUDKundeImplTest]

```    
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
  
```

---
##### Steuerung | KundeSteuerung
---


---
GUI
---




[ICRUDKundeImpl]: <https://github.com/ZeroPie/SWP/blob/master/trunk/KundeDaten/src/bks/datenhaltung/kundedaten/impl/ICRUDKundeImpl.java>


[ICrudKunde]:
<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeDaten/src/bks/datenhaltung/kundedaten/services/ICRUDKunde.java>

[ICRUDKundeImplTest]:
<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeDaten/test/bks/datenhaltung/kundedaten/impl/ICRUDKundeImplTest.java>
