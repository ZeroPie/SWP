---
#### Datenhaltung | KundeDaten
---
#### bks.datenhaltung.kundedaten.services(Interfaces)
- [ICrudKunde]

#### bks.datenhaltung.kundedaten.impl
- [ICrudKundeImpl]
```
import javax.persistence.Query;
import javax.persistence.EntityManager;
```

#### test.bks.datenhaltung.kundedaten.impl
- [ICRUDKundeImplTest]
---
#### Steuerung | KundeSteuerung
---

#### bks.fachlogik.kundesteuerung.grenz;
- [KundeGrenz]
#### bks.fachlogik.kundesteuerung.impl;
- [IKundeSteuerungImpl]
```
import bks.datenhaltung.kundedaten.impl.ICRUDKundeImpl; 
```
#### bks.fachlogik.kundesteuerung.services;
- [IKundeSteuerung]
---
#### GUI | KundeGUI |
---
#### bks.gui.kundegui.gui;
- [FrameKunde]
```
import bks.fachlogik.kundesteuerung.impl.IKundeSteuerungImpl;
```
- [KundeGUI]

[ICRUDKundeImpl]: <https://github.com/ZeroPie/SWP/blob/master/trunk/KundeDaten/src/bks/datenhaltung/kundedaten/impl/ICRUDKundeImpl.java>

[ICrudKunde]:
<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeDaten/src/bks/datenhaltung/kundedaten/services/ICRUDKunde.java>

[ICRUDKundeImplTest]:
<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeDaten/test/bks/datenhaltung/kundedaten/impl/ICRUDKundeImplTest.java>

[KundeGrenz]: <https://github.com/ZeroPie/SWP/blob/master/trunk/KundeSteuerung/src/bks/fachlogik/kundesteuerung/grenz/KundeGrenz.java>

[ICRUDKundeImpl]:
<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeSteuerung/src/bks/fachlogik/kundesteuerung/services/IKundeSteuerung.java>

[IKundeSteuerung]:
<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeSteuerung/src/bks/fachlogik/kundesteuerung/services/IKundeSteuerung.java>

[IKundeSteuerungImpl]:
<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeSteuerung/src/bks/fachlogik/kundesteuerung/impl/IKundeSteuerungImpl.java>

[KundeGUI]:
<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeGUI/src/bks/gui/kundegui/gui/ProfilBearbeitenFrame.java>

[FrameKunde]:<https://github.com/ZeroPie/SWP/blob/master/trunk/KundeGUI/src/bks/gui/kundegui/gui/FrameKunde.java>
