---
#### Datenhaltung | KundeDaten
---
#### bks.datenhaltung.kundedaten.services(Interfaces)
- [ICrudKunde]

```
import javax.persistence.EntityManager;
import bks.datenhaltung.bksdbmodel.entities.Kunde;
```
#### bks.datenhaltung.kundedaten.impl
- [ICrudKundeImpl]

```
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

```

#### test.bks.datenhaltung.kundedaten.impl
- [ICRUDKundeImplTest]


```    
    private static EntityManager entityManager;
    private final static IDatabase iDatabase = new IDatabaseImpl();
    private ICRUDKunde classUnderTest;

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
