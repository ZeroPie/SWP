package bks.gui.kontogui.gui;

import bks.fachlogik.kontosteuerung.grenz.UeberweisungGrenz;
import bks.fachlogik.kontosteuerung.impl.IKontoSteuerungImpl;
import bks.fachlogik.kontosteuerung.services.IKontoSteuerung;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander Merkel
 */
public class UeberweisungAusfuehrenFrame extends javax.swing.JFrame {

    private final IKontoSteuerung kontoSteuerung = new IKontoSteuerungImpl();
    boolean failed = false;
    String[] myCollumName = {"ID", "von Konto", "zu Konto", "Datum"};
    DefaultTableModel ueberweisungenModel;
    DefaultTableModel ueberweisungenModelChecked;
    DefaultTableModel ausfuehrenModel ;

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form ueberweisungErfassenFrame
     */
    public UeberweisungAusfuehrenFrame() {
        initComponents();
        jcheckHeute.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ueberweisungenModelChecked = new DefaultTableModel(myCollumName, 0);

                int size = jtabUeberweisungen.getModel().getRowCount();

                String heute = formatter.format(new Date(System.currentTimeMillis()));

                for (int i = 0; i < size; ++i) {
                    Object[] checkedrow = new Object[4];
                    String ueberweisungsDatum = jtabUeberweisungen.getModel().getValueAt(i, 3).toString();
                    if (ueberweisungsDatum.equals(heute)) {

                        for (int j = 0; j <= 3; ++j) {
                            checkedrow[j] = jtabUeberweisungen.getModel().getValueAt(i, j).toString();

                        }
                        ueberweisungenModelChecked.addRow(checkedrow);
                    }

                }
                jtabUeberweisungen.setModel(ueberweisungenModelChecked);
            } else {
                jtabUeberweisungen.setModel(ueberweisungenModel);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExecut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtabUeberweisungen = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtKid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKtoid = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jcheckHeute = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtabAuszufuehren = new javax.swing.JTable();
        btnToRight = new javax.swing.JButton();
        btnToLeft = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ueberweisung ausführen");
        setResizable(false);

        btnExecut.setText("Ausführen");
        btnExecut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExecutMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Überweisungen"));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        jtabUeberweisungen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "von Konto", "zu Konto", "Datum"
            }
        ));
        jScrollPane2.setViewportView(jtabUeberweisungen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Suche"));

        jLabel1.setText("Kundennummer:");

        jLabel2.setText("oder");

        jLabel3.setText("Kontonummer:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bks/gui/kontogui/resources/icon-lupe.png"))); // NOI18N
        btnSearch.setText("Suche");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        jcheckHeute.setText("Heute");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKtoid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKid, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch)
                    .addComponent(jcheckHeute))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKtoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcheckHeute))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bks/gui/kontogui/resources/bank.png"))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Auszuführen"));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 50));

        jtabAuszufuehren.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "von Konto", "zu Konto", "Datum"
            }
        ));
        jScrollPane3.setViewportView(jtabAuszufuehren);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnToRight.setText(">");
        btnToRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnToRightMouseClicked(evt);
            }
        });

        btnToLeft.setText("<");
        btnToLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnToLeftMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExecut, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnToRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnToLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(jLabel4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnToRight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnToLeft)
                        .addGap(138, 138, 138)))
                .addComponent(btnExecut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        ueberweisungenModel = new DefaultTableModel(myCollumName, 0);
        ausfuehrenModel=new DefaultTableModel(myCollumName, 0);
        List<UeberweisungGrenz> searchedUeberweisungen = null;
        if (txtKid.getText().isEmpty() && (!txtKtoid.getText().isEmpty())) {
            try {
                int ktoid = Integer.parseInt(txtKtoid.getText());

                searchedUeberweisungen = kontoSteuerung.getWartendeUeberweisungenByKtoid(ktoid);
                failed = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Bitte geben Sie Zahlen ein.\n\n", "Buchstaben", JOptionPane.ERROR_MESSAGE);
                failed = true;
            }
        } else if ((!txtKid.getText().isEmpty()) && txtKtoid.getText().isEmpty()) {
            try {
                int kid = Integer.parseInt(txtKid.getText());

                searchedUeberweisungen = kontoSteuerung.getWartendeUeberweisungenByKid(kid);
                failed = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Bitte geben Sie Zahlen ein.\n\n", "Buchstaben", JOptionPane.ERROR_MESSAGE);
                failed = true;
            }
        } else if ((!txtKid.getText().isEmpty()) && (!txtKtoid.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Bitte geben Sie \neine Kundennummer ODER Kontonummer ein.\n\n", "Keine Suchdaten vorhanden", JOptionPane.ERROR_MESSAGE);
            failed = true;
        } else if ((txtKid.getText().isEmpty()) && (txtKtoid.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Bitte geben Sie \neine Kundennummer oder Kontonummer ein.\n\n", "Keine Suchdaten vorhanden", JOptionPane.ERROR_MESSAGE);
            failed = true;
        }
        if (!failed) {
            if (searchedUeberweisungen.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Es wurden keine Überweisungen gefunden.\n\n", "Suchfehler", JOptionPane.ERROR_MESSAGE);
            }
            try {
                for (UeberweisungGrenz u : searchedUeberweisungen) {
                    Date date = u.getDatum();
                    Object[] row = {"" + u.getUbid(), "" + u.getVonkonto(), "" + u.getZukonto(), formatter.format(date)};
                    ueberweisungenModel.addRow(row);
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Es wurden keine Überweisungen gefunden.\n\n", "Suchfehler", JOptionPane.ERROR_MESSAGE);
            }
            jtabUeberweisungen.setModel(ueberweisungenModel);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnToRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnToRightMouseClicked
        int selectedRow = jtabUeberweisungen.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel aktuellesModel = (DefaultTableModel) jtabUeberweisungen.getModel();
            Object[] objectedRow = new Object[4];
            for (int i = 0; i <= 3; ++i) {
                objectedRow[i] = jtabUeberweisungen.getModel().getValueAt(selectedRow, i);
            }
            ausfuehrenModel.addRow(objectedRow);
            jtabAuszufuehren.setModel(ausfuehrenModel);
            aktuellesModel.removeRow(selectedRow);
        }
    }//GEN-LAST:event_btnToRightMouseClicked

    private void btnToLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnToLeftMouseClicked
        
        int selectedRow = jtabAuszufuehren.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel aktuellesModel = (DefaultTableModel) jtabUeberweisungen.getModel();
            Object[] objectedRow = new Object[4];
            for (int i = 0; i <= 3; ++i) {
                objectedRow[i] = jtabAuszufuehren.getModel().getValueAt(selectedRow, i);
            }
            aktuellesModel.addRow(objectedRow);
            jtabUeberweisungen.setModel(aktuellesModel);
            ausfuehrenModel.removeRow(selectedRow);
        }
    }//GEN-LAST:event_btnToLeftMouseClicked

    private void btnExecutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExecutMouseClicked
        DefaultTableModel aktuellesModel = (DefaultTableModel) jtabAuszufuehren.getModel();
        int anzahlRow = aktuellesModel.getRowCount();
        String[] ids = new String[anzahlRow];
        for (int i = 0; i < anzahlRow; ++i) {
            ids[i] = aktuellesModel.getValueAt(i, 0).toString();
        }
        for (int i = 0; i < ids.length; ++i) {
            int ubid =Integer.parseInt(ids[i]);
            if(!kontoSteuerung.ueberweisungAusfuehren(ubid)){
                JOptionPane.showMessageDialog(this, "Die Überweisung "+ubid+" konnte nicht ausgeführt werden.\n\n", "Überweisungsfehler", JOptionPane.ERROR_MESSAGE);
            }
        }
        ausfuehrenModel = new DefaultTableModel(myCollumName, 0);
        jtabAuszufuehren.setModel(ausfuehrenModel);
    }//GEN-LAST:event_btnExecutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UeberweisungAusfuehrenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UeberweisungAusfuehrenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UeberweisungAusfuehrenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UeberweisungAusfuehrenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UeberweisungAusfuehrenFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecut;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnToLeft;
    private javax.swing.JButton btnToRight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox jcheckHeute;
    private javax.swing.JTable jtabAuszufuehren;
    private javax.swing.JTable jtabUeberweisungen;
    private javax.swing.JTextField txtKid;
    private javax.swing.JTextField txtKtoid;
    // End of variables declaration//GEN-END:variables
}