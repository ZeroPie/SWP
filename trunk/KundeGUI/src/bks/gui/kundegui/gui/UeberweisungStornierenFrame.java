/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bks.gui.kundegui.gui;

import bks.fachlogik.kundesteuerung.grenz.UeberweisungGrenz;
import bks.fachlogik.kundesteuerung.impl.IUeberweisungSteuerungImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alejandro Palacios
 */
public class UeberweisungStornierenFrame extends javax.swing.JFrame {

    private final JFrame hauptfenster = this;
    private final IUeberweisungSteuerungImpl ueberweisungSteuerung = new IUeberweisungSteuerungImpl();
    private List<UeberweisungGrenz> ueberweisungGrenzList= null;
    DefaultTableModel ubTableModel = null;

    /** Creates new form UeberweisungStornieren */
    public UeberweisungStornierenFrame() {
        super();
        initComponents();

        initKontoListe();
        hauptfenster.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
    private void initKontoListe(){

        ueberweisungGrenzList = ueberweisungSteuerung.getStornierbareUeberweisungen();
        ubTableModel = (DefaultTableModel) ubTable.getModel();
        for (int i = 0; i < ueberweisungGrenzList.size(); i++){
            int ubid      = ueberweisungGrenzList.get(i).getUbid();
            int vonKonto  = ueberweisungGrenzList.get(i).getVonkonto();
            int zuKonto   = ueberweisungGrenzList.get(i).getZukonto();
            double betrag = ueberweisungGrenzList.get(i).getBetrag();
            Date datum    = ueberweisungGrenzList.get(i).getDatum();
            String vZweck = ueberweisungGrenzList.get(i).getVerwendungszweck();
            String status = ueberweisungGrenzList.get(i).getStatus();
            int kundeID   = ueberweisungGrenzList.get(i).getKid();

            Object[] data = { ubid, vonKonto, zuKonto, betrag, vZweck, datum, kundeID, status};
            ubTableModel.addRow(data);

        }

    }

    private void clearKontoListe(){

        ubTableModel = (DefaultTableModel) ubTable.getModel();
        ubTableModel.setRowCount(0);

    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ubTable = new javax.swing.JTable();
        StornierenButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Überweisung Stornieren");

        ubTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UBID", "Von Konto", "Zu Konto", "Betrag", "Verwendungszweck", "Datum", "Kunde", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ubTable);

        StornierenButton.setText("Überweisung Stornieren");
        StornierenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StornierenButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(StornierenButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StornierenButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StornierenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StornierenButtonActionPerformed

        int row = ubTable.getSelectedRow();
        int ubid = (int) ubTable.getValueAt(row, 0);
        ueberweisungSteuerung.ueberweisungStornieren(ubid);
        clearKontoListe();
        initKontoListe();

    }//GEN-LAST:event_StornierenButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UeberweisungStornierenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UeberweisungStornierenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UeberweisungStornierenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UeberweisungStornierenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UeberweisungStornierenFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StornierenButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ubTable;
    // End of variables declaration//GEN-END:variables

}
