package bks.gui.bootloader.grenz;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;

/**
 * Grenzklasse zur LoginGUI
 * @author farhan
 */
public class LoginGUIAttributen {

    // <editor-fold defaultstate="collapsed" desc="Private Fields">
    private static final ResourceBundle bundle = ResourceBundle.getBundle("bks/gui/bootloader/gui/Bundle");
    private Message msgTyp;
    private List<String> rollen;
    private int userid;
    private ImageIcon okIcon;
    private ImageIcon warningIcon;
    private ImageIcon errorIcon;
    private ImageIcon loginErrorIcon;
    private ImageIcon infoIcon;
    private ImageIcon adminIcon;
    private ImageIcon managerIcon;
    private ImageIcon sachIcon;
    private ImageIcon kundeIcon;
    private ImageIcon uebIcon;
    private ImageIcon yellowLightIcon;
    private ImageIcon greenLightIcon;
    private ImageIcon currentLoginIcon;
    private ImageIcon currentLogoutIcon;
    private ImageIcon outputIcon;
    private String rolle;
    private Color color;
    private boolean error;// </editor-fold>


    public LoginGUIAttributen() {
        rollen = new ArrayList<String>(5);
        rollen.add(bundle.getString("ADM"));
        rollen.add(bundle.getString("MNG"));
        rollen.add(bundle.getString("CLK"));
        rollen.add(bundle.getString("CUS"));
        rollen.add(bundle.getString("TRA"));
        okIcon = new ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/ok.png"));
        infoIcon = new ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/info.png"));
        warningIcon = new ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/warning.png"));
        errorIcon = new ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/error.png"));
        loginErrorIcon = new ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/erroruserid.png"));
        yellowLightIcon = new ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/yellowlight24x24.png"));
        greenLightIcon = new ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/greenlight24x24.png"));
        currentLoginIcon = greenLightIcon;
        currentLogoutIcon = yellowLightIcon;
        error = false;

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Properties">
    public static final String PROP_ERROR = "error";

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        boolean oldError = this.error;
        this.error = error;
        propertyChangeSupport.firePropertyChange(PROP_ERROR, oldError, error);
    }
    public static final String PROP_UEBICON = "uebIcon";

    public ImageIcon getUebIcon() {
        return uebIcon;
    }

    public void setUebIcon(ImageIcon uebIcon) {
        ImageIcon oldUebIcon = this.uebIcon;
        this.uebIcon = uebIcon;
        propertyChangeSupport.firePropertyChange(PROP_UEBICON, oldUebIcon, uebIcon);
    }
    public static final String PROP_KUNDEICON = "kundeIcon";

    public ImageIcon getKundeIcon() {
        return kundeIcon;
    }

    public void setKundeIcon(ImageIcon kundeIcon) {
        ImageIcon oldKundeIcon = this.kundeIcon;
        this.kundeIcon = kundeIcon;
        propertyChangeSupport.firePropertyChange(PROP_KUNDEICON, oldKundeIcon, kundeIcon);
    }
    public static final String PROP_SACHICON = "sachIcon";

    public ImageIcon getSachIcon() {
        return sachIcon;
    }

    public void setSachIcon(ImageIcon sachIcon) {
        ImageIcon oldSachIcon = this.sachIcon;
        this.sachIcon = sachIcon;
        propertyChangeSupport.firePropertyChange(PROP_SACHICON, oldSachIcon, sachIcon);
    }
    public static final String PROP_MANAGERICON = "managerIcon";

    public ImageIcon getManagerIcon() {
        return managerIcon;
    }

    public void setManagerIcon(ImageIcon managerIcon) {
        ImageIcon oldManagerIcon = this.managerIcon;
        this.managerIcon = managerIcon;
        propertyChangeSupport.firePropertyChange(PROP_MANAGERICON, oldManagerIcon, managerIcon);
    }
    public static final String PROP_ADMINICON = "adminIcon";

    public ImageIcon getAdminIcon() {
        return adminIcon;
    }

    public void setAdminIcon(ImageIcon adminIcon) {
        ImageIcon oldAdminIcon = this.adminIcon;
        this.adminIcon = adminIcon;
        propertyChangeSupport.firePropertyChange(PROP_ADMINICON, oldAdminIcon, adminIcon);
    }
    public static final String PROP_ROLLEN = "rollen";

    public List<String> getRollen() {
        return rollen;
    }

    public void setRollen(List<String> rollen) {
        List<String> oldRollen = this.rollen;
        this.rollen = rollen;
        propertyChangeSupport.firePropertyChange(PROP_ROLLEN, oldRollen, rollen);
    }
    public static final String PROP_ROLLE = "rolle";

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        String oldRolle = this.rolle;
        this.rolle = rolle;
        propertyChangeSupport.firePropertyChange(PROP_ROLLE, oldRolle, rolle);
    }
    public static final String PROP_USERID = "userid";

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        int oldUserid = this.userid;
        this.userid = userid;
        propertyChangeSupport.firePropertyChange(PROP_USERID, oldUserid, userid);
    }
    
        public static final String PROP_COLOR = "color";

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        Color oldColor = this.color;
        this.color = color;
        propertyChangeSupport.firePropertyChange(PROP_COLOR, oldColor, color);
    }
    
    public static final String PROP_OUTPUTICON = "outputIcon";

    public ImageIcon getOutputIcon() {
        return outputIcon;
    }

    public void setOutputIcon(ImageIcon outputIcon) {
        ImageIcon oldOutputIcon = this.outputIcon;
        this.outputIcon = outputIcon;
        propertyChangeSupport.firePropertyChange(PROP_OUTPUTICON, oldOutputIcon, outputIcon);
    }
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Error display logic">
    public static final String PROP_MSGTYP = "msgTyp";

    public Message getMsgTyp() {
        return msgTyp;
    }

    public void setMsgTyp(Message msgTyp) {
        switch (msgTyp) {
            case Error:
                setColor(new Color(255, 0, 0));
                setOutputIcon(errorIcon);
                setError(true);
                break;
            case LoginError:
                setColor(new Color(255, 0, 0));
                setOutputIcon(loginErrorIcon);
                setError(false);
                break;
            case Info:
                setColor(new Color(0, 153, 0));
                setOutputIcon(infoIcon);
                setError(false);
                break;
            case Ok:
                setColor(new Color(0, 153, 0));
                setOutputIcon(okIcon);
                setError(false);
                break;
            case Warning:
                setColor(new Color(155, 153, 155));
                setOutputIcon(warningIcon);
                setError(false);
                break;
        }
        Message oldMsgTyp = this.msgTyp;
        this.msgTyp = msgTyp;
        propertyChangeSupport.firePropertyChange(PROP_MSGTYP, oldMsgTyp, msgTyp);

    }

    public void setActivate(String rolle) {
        if (rolle.equals(bundle.getString("ADM"))) {
            setAdminIcon(currentLoginIcon);
        } else if (rolle.equals(bundle.getString("MNG"))) {
            setManagerIcon(currentLoginIcon);
        } else if (rolle.equals(bundle.getString("CLK"))) {
            setSachIcon(currentLoginIcon);
        } else if (rolle.equals(bundle.getString("CUS"))) {
            setKundeIcon(currentLoginIcon);
        } else if (rolle.equals(bundle.getString("TRA"))) {
            setUebIcon(currentLoginIcon);
        }
    }

    public void setDeactivate(String rolle) {
        if (rolle.equals(bundle.getString("ADM"))) {
            setAdminIcon(currentLogoutIcon);
        } else if (rolle.equals(bundle.getString("MNG"))) {
            setManagerIcon(currentLogoutIcon);
        } else if (rolle.equals(bundle.getString("CLK"))) {
            setSachIcon(currentLogoutIcon);
        } else if (rolle.equals(bundle.getString("CUS"))) {
            setKundeIcon(currentLogoutIcon);
        } else if (rolle.equals(bundle.getString("TRA"))) {
            setUebIcon(currentLogoutIcon);
        }
    }

    // </editor-fold>
}
