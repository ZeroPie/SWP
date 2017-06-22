package bks.gui.bootloader.steuerung;

import bks.fachlogik.componentcontroller.services.IActivateComponent;
import bks.gui.admingui.gui.FrameAdmin;
import bks.gui.bootloader.grenz.LoginGUIAttributen;
import bks.gui.kontogui.gui.FrameKonto;
import bks.gui.kundegui.gui.FrameKunde;
import bks.gui.managergui.gui.FrameManager;
import bks.gui.sachbearbeitergui.gui.FrameSachbearbeiter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author farhan
 */
public class LoginVerwaltung {

    private List<IActivateComponent> actList;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("bks/gui/bootloader/gui/Bundle");
    private final String ADM = bundle.getString("ADM");
    private final String MNG = bundle.getString("MNG");
    private final String CLK = bundle.getString("CLK");
    private final String CUS = bundle.getString("CUS");
    private final String TRA = bundle.getString("TRA");

    private FrameAdmin frameAdmin;
    private FrameKunde frameKunde;
    private FrameKonto frameKonto;
    private FrameManager frameManager;
    private FrameSachbearbeiter frameSachbearbeiter;
    
    public LoginVerwaltung() {
        actList = new ArrayList<IActivateComponent>(6);
        checkComponentsAvailability();
    }

    public boolean doLogin(LoginGUIAttributen attributen) {
        boolean ret = false;
        IActivateComponent act = actList.get(getRollIndex(attributen.getRolle()));
        if (act != null) {
            if (act.activateComponent(attributen.getUserid())) {
                //act.getComponentGUI().setVisible(true);
                // TODO alle
                switch(act.getComponentType())
                {
                    case ADMIN:
                        frameAdmin = new FrameAdmin();
                        frameAdmin.setVisible(true);
                        break;
                        
                    case KONTO:
                        frameKonto = new FrameKonto();
                        frameKonto.setVisible(true);
                        break;
                        
                    case KUNDE:
                        frameKunde = new FrameKunde();
                        frameKunde.setVisible(true);
                        break;
                        
                    case MANAGER:
                        frameManager = new FrameManager();
                        frameManager.setVisible(true);
                        break;
                        
                    case SACHBEARBEITER:
                        frameSachbearbeiter = new FrameSachbearbeiter();
                        frameSachbearbeiter.setVisible(true);
                        break;
                        
                }
                ret = true;
            }
        }
        return ret;
    }

    public boolean doLogout(LoginGUIAttributen attributen) {
        boolean ret = false;
        IActivateComponent act = actList.get(getRollIndex(attributen.getRolle()));
        if (act != null) {
            if (act.deactivateComponent()) {
                switch(act.getComponentType())
                {
                    case ADMIN:
                        frameAdmin.dispose();
                        break;
                        
                    case KONTO:
                        frameKonto.dispose();
                        break;
                        
                    case KUNDE:
                        frameKunde.dispose();
                        break;
                        
                    case MANAGER:
                        frameManager.dispose();
                        break;
                        
                    case SACHBEARBEITER:
                        frameSachbearbeiter.dispose();
                        break;
                        
                }
                ret = true;
            }
        }
        return ret;
    }

    private int getRollIndex(String rolle) {
        int ret = -1;
        if (rolle.equals(ADM)) {
            ret = 0;
        } else if (rolle.equals(MNG)) {
            ret = 1;
        } else if (rolle.equals(CLK)) {
            ret = 2;
        } else if (rolle.equals(CUS)) {
            ret = 3;
        } else if (rolle.equals(TRA)) {
            ret = 4;
        }
        return ret;
    }

    private void checkComponentsAvailability() {
        actList.add(new bks.fachlogik.adminsteuerung.impl.IActivateComponentImpl()); // ADM
        actList.add(new bks.fachlogik.managersteuerung.impl.IActivateComponentImpl());  // MNG
        actList.add(new bks.fachlogik.sachbearbeitersteuerung.impl.IActivateComponentImpl()); // CLK
        actList.add(new bks.fachlogik.kundesteuerung.impl.IActivateComponentImpl()); // CUS
        actList.add(new bks.fachlogik.kontosteuerung.impl.IActivateComponentImpl());  // TRA
    }
}
