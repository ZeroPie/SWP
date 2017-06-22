/*
 * LoginGUI.java
 *
 * Created on 29.03.2011, 17:31:45
 */
package bks.gui.bootloader.gui;

import bks.gui.bootloader.grenz.LoginGUIAttributen;
import bks.gui.bootloader.grenz.Message;
import bks.gui.bootloader.steuerung.LoginVerwaltung;
import java.awt.Color;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author farhan
 */
public class LoginGUI extends javax.swing.JFrame implements IMessageLogger {

    
    // <editor-fold defaultstate="collapsed" desc="Localized strings">
    private static final ResourceBundle bundle = ResourceBundle.getBundle("bks/gui/bootloader/gui/Bundle");
    private final String loginErrTxt = bundle.getString("LOGINERR");
    private final String logoutErrTxt = bundle.getString("LOGOUTERR");
    private final String loginErflgTxt = bundle.getString("LOGINOK");
    private final String logoutErflgTxt = bundle.getString("LOGOUTOK");
    private final String keinUserIDTxt = bundle.getString("NOUSERID");
    private final String ADM = bundle.getString("ADM");
    private final String MNG = bundle.getString("MNG");
    private final String CLK = bundle.getString("CLK");
    private final String CUS = bundle.getString("CUS");
    private final String TRA = bundle.getString("TRA");
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Associations">
    private UserIDConverter userIDConverter;
    private UserIDValidator userIDValidator;
    private LoginVerwaltung lv;
    private LoginGUIAttributen attributen;
    private Timer t;
    // </editor-fold>

    public LoginGUI() {
        this.lv = new LoginVerwaltung();
        this.attributen = new LoginGUIAttributen();
        this.attributen.setRolle(ADM);
        this.attributen.setColor(new Color(0, 153, 0));
        this.attributen.setUserid(1);
        this.attributen.setDeactivate(ADM);
        this.attributen.setDeactivate(MNG);
        this.attributen.setDeactivate(CLK);
        this.attributen.setDeactivate(CUS);
        this.attributen.setDeactivate(TRA);        
        userIDConverter = new UserIDConverter();
        userIDValidator = new UserIDValidator();
        initComponents();
        this.bindingGroup.addBindingListener(new LoggingBindingListener(this));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblAdmin = new javax.swing.JLabel();
        lblManager = new javax.swing.JLabel();
        lblSach = new javax.swing.JLabel();
        lblKunde = new javax.swing.JLabel();
        lblUeb = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jcmbRolle = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserid = new javax.swing.JTextField();
        jptxtPasswort = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblOutput = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("bks/gui/bootloader/gui/Bundle"); // NOI18N
        setTitle(bundle.getString("LoginGUI.title")); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18));
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/bank.png"))); // NOI18N
        jLabel1.setText(bundle.getString("LoginGUI.lblLogo.text")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("LoginGUI.jPanel1.border.title"))); // NOI18N

        lblAdmin.setText(bundle.getString("LoginGUI.lblAdmin.text")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.adminIcon}"), lblAdmin, org.jdesktop.beansbinding.BeanProperty.create("icon"));
        bindingGroup.addBinding(binding);

        lblManager.setText(bundle.getString("LoginGUI.lblManager.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.managerIcon}"), lblManager, org.jdesktop.beansbinding.BeanProperty.create("icon"));
        bindingGroup.addBinding(binding);

        lblSach.setText(bundle.getString("LoginGUI.lblSach.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.sachIcon}"), lblSach, org.jdesktop.beansbinding.BeanProperty.create("icon"));
        bindingGroup.addBinding(binding);

        lblKunde.setText(bundle.getString("LoginGUI.lblKunde.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.kundeIcon}"), lblKunde, org.jdesktop.beansbinding.BeanProperty.create("icon"));
        bindingGroup.addBinding(binding);

        lblUeb.setText(bundle.getString("LoginGUI.lblUeb.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.uebIcon}"), lblUeb, org.jdesktop.beansbinding.BeanProperty.create("icon"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdmin)
                    .addComponent(lblManager)
                    .addComponent(lblSach)
                    .addComponent(lblKunde)
                    .addComponent(lblUeb))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblManager)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblKunde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUeb)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("LoginGUI.jPanel2.border.title"))); // NOI18N

        jcmbRolle.setToolTipText(bundle.getString("LoginGUI.jcmbRolle.toolTipText")); // NOI18N

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${attributen.rollen}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jcmbRolle);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.rolle}"), jcmbRolle, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/rollen.png"))); // NOI18N
        jLabel2.setText(bundle.getString("LoginGUI.jLabel2.text")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/user.png"))); // NOI18N
        jLabel3.setText(bundle.getString("LoginGUI.jLabel3.text")); // NOI18N

        txtUserid.setToolTipText(bundle.getString("userid.tooltip")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.userid}"), txtUserid, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setConverter(userIDConverter);
        binding.setValidator(userIDValidator);
        bindingGroup.addBinding(binding);

        jptxtPasswort.setText(bundle.getString("LoginGUI.jptxtPasswort.text")); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/password16x16.png"))); // NOI18N
        jLabel4.setText(bundle.getString("LoginGUI.jLabel4.text")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11));
        jLabel5.setText(bundle.getString("LoginGUI.lblPassinfo.text")); // NOI18N

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/login.png"))); // NOI18N
        btnLogin.setText(bundle.getString("LoginGUI.btnLogin.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${!attributen.error}"), btnLogin, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bks/gui/bootloader/gui/resources/logout.png"))); // NOI18N
        btnExit.setText(bundle.getString("LoginGUI.btnExit.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${!attributen.error}"), btnExit, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcmbRolle, 0, 250, Short.MAX_VALUE)
                            .addComponent(txtUserid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jptxtPasswort, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcmbRolle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUserid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jptxtPasswort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("LoginGUI.jPanel3.border.title"))); // NOI18N

        lblOutput.setFont(new java.awt.Font("Tahoma", 1, 12));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.color}"), lblOutput, org.jdesktop.beansbinding.BeanProperty.create("foreground"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${attributen.outputIcon}"), lblOutput, org.jdesktop.beansbinding.BeanProperty.create("icon"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblOutput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // if user has not made an input
        if (txtUserid.getText().length() == 0) {
            logMessage(keinUserIDTxt, Message.Error);
        } else {
            if (lv.doLogin(attributen)) {
                this.attributen.setActivate(attributen.getRolle());
                logMessage(loginErflgTxt, Message.Ok);
            } else {
                logMessage(loginErrTxt, Message.LoginError);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if (lv.doLogout(attributen)) {
            this.attributen.setDeactivate(attributen.getRolle());
            logMessage(logoutErflgTxt, Message.Ok);
        } else {
            logMessage(logoutErrTxt, Message.LoginError);
        }
    }//GEN-LAST:event_btnExitActionPerformed

   

    // <editor-fold defaultstate="collapsed" desc="Generated property for boundary class">
    public static final String PROP_ATTRIBUTEN = "attributen";

    public LoginGUIAttributen getAttributen() {
        return attributen;
    }    

    public void setAttributen(LoginGUIAttributen attributen) {
        LoginGUIAttributen oldAttributen = this.attributen;
        this.attributen = attributen;
        this.firePropertyChange(PROP_ATTRIBUTEN, oldAttributen, attributen);
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="IMessageLogger implementation">
    public void logMessage(String msg, Message msgTyp) {
        this.attributen.setMsgTyp(msgTyp);
        lblOutput.setText(msg);
        scheduleClearTextTask(lblOutput);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Clear Task logic">

    /**
     * Delegator to generate a clear Task for a label.
     * @param lbl Label to be cleared
     */
    private void scheduleClearTextTask(JLabel lbl) {
        if (t != null) {
            t.cancel();
        }
        t = new Timer();
        t.schedule(new ClearTextTask(lbl), 5000);

    }

    class ClearTextTask extends TimerTask {

        private JTextField txtField;
        private JLabel lbl;
        private JTextArea txtArea;

        public ClearTextTask(JTextField txtField) {
            this.txtField = txtField;
            txtArea = null;
            lbl = null;
        }

        public ClearTextTask(JLabel lbl) {
            txtArea = null;
            txtField = null;
            this.lbl = lbl;
        }

        public ClearTextTask(JTextArea txtArea) {
            this.txtArea = txtArea;
            lbl = null;
            txtField = null;
        }

        public ClearTextTask(JTextField txtField, JLabel lbl) {
            this.txtField = txtField;
            this.lbl = lbl;
        }

        @Override
        public void run() {
            if (txtField != null) {
                txtField.setText("");
            }
            if (lbl != null) {
                lbl.setText("");
                lbl.setIcon(null);
            }
            if (txtArea != null) {
                txtArea.setText("");
            }
        }
    }
    // </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox jcmbRolle;
    private javax.swing.JPasswordField jptxtPasswort;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblKunde;
    private javax.swing.JLabel lblManager;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblSach;
    private javax.swing.JLabel lblUeb;
    private javax.swing.JTextField txtUserid;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    // <editor-fold defaultstate="collapsed" desc="Main Method">
    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }// </editor-fold>
}
