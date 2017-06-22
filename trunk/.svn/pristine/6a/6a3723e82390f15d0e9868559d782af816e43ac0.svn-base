package bks.manager.impl;

import bks.componentcontroller.services.CompType;
import bks.componentcontroller.services.IActivateComponent;
import javax.swing.JFrame;

/**
 *
 * @author farhan
 */
public class IActivateComponentManager implements IActivateComponent{

   private boolean isActivated;
   private JFrame gui;

    public IActivateComponentManager() {
        isActivated = false;
        gui = null;
    }

    /**
     * Returns the Component Type.
     * @return
     */
    public CompType getComponentType() {
        return CompType.MANAGER;
    }

    /**
     * Activates the Component. It should be considered as the
     * Constructor of a Component.
     * @param userid for which the component should be activated.
     * There is only one userid for which the ComponentController can
     * be activated and that is 1.
     * @return it returns true if the activation was successful else false.
     */
    public boolean activateComponent(int userid) {
        boolean ret = false;
        if (!isActivated && userid == 1) {
            isActivated = true;
            ret = true;

        }
        return ret;
    }

    /**
     * This Method just creates an empty JFram with Title "Demo" and returns it.
     * @return a JFrame with title "Demo".
     */
    public JFrame getComponentGUI() {
        // just create an empty JFrame for demo purposes and return it.
        if (isActivated) {
            gui = new JFrame(CompType.MANAGER.toString());
            gui.setBounds(100, 10, 400, 600);
        }
        return gui;
    }

    /**
     * Deactivates the Component
     * @return
     */
    public boolean deactivateComponent() {
        if (isActivated) {
            isActivated = false;
            gui.dispose();
            gui = null;
            return true;
        }
        return false;
    }

}
