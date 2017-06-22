package bks.gui.kundegui.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bks.fachlogik.kundesteuerung.grenz.UeberweisungsvorlageGrenz;
import bks.fachlogik.kundesteuerung.impl.IActivateComponentImpl;
import bks.fachlogik.kundesteuerung.impl.IUeberweisungSteuerungImpl;
import bks.fachlogik.kundesteuerung.impl.IUeberweisungVorlageSteuerungImpl;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alejandro Palacios
 */
public class UeberweisungVorlageAnlegenFrame extends javax.swing.JFrame {

    private final IUeberweisungSteuerungImpl ueberweisungSteuerung = new IUeberweisungSteuerungImpl();
    private final IUeberweisungVorlageSteuerungImpl vorlageSteuerung = new IUeberweisungVorlageSteuerungImpl();

    /**
     * Creates new form UeberweisungVorlageAnlegen
     */
    public UeberweisungVorlageAnlegenFrame() {
        initComponents();
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldVonKonto = new javax.swing.JTextField();
        textFieldVerwendungszweck = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AnlegenButton = new javax.swing.JButton();
        jFormattedTextFieldDatum = new javax.swing.JFormattedTextField();
        BetragTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textFieldVonKonto.setText("00000");
        textFieldVonKonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldVonKontoActionPerformed(evt);
            }
        });

        textFieldVerwendungszweck.setText("Verwendungszweck");

        jLabel1.setText("Betrag");

        jLabel2.setText("Datum JJJJ/MM/TT");

        jLabel3.setText("von Konto");

        jLabel4.setText("Verwendungszweck");

        jLabel5.setText("Ueberweisungsvorlage Anlegen");

        AnlegenButton.setText("Anlegen");
        AnlegenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnlegenButtonActionPerformed(evt);
            }
        });

        jFormattedTextFieldDatum.setText("JJJJ/MM/TT");
        jFormattedTextFieldDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDatumActionPerformed(evt);
            }
        });

        BetragTextField.setText("00.00");
        BetragTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BetragTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textFieldVerwendungszweck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(textFieldVonKonto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AnlegenButton)
                            .addComponent(jFormattedTextFieldDatum, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BetragTextField, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BetragTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFormattedTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldVonKonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldVerwendungszweck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(AnlegenButton)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnlegenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnlegenButtonActionPerformed

        double betrag = Double.parseDouble(this.BetragTextField.getText());
        String vZweck = this.textFieldVerwendungszweck.getText();
        int vonKonto  = Integer.parseInt(this.textFieldVonKonto.getText());
        Date datum    = (Date) this.jFormattedTextFieldDatum.getValue();
        System.out.println(Integer.parseInt(this.textFieldVonKonto.getText()));

        try {
            if(vZweck.length() > 0 && betrag > 0 && vonKonto > 0){
                UeberweisungsvorlageGrenz ueberweisungsvorlageGrenz = new UeberweisungsvorlageGrenz();
                ueberweisungsvorlageGrenz.setBetrag(betrag);
                ueberweisungsvorlageGrenz.setVonkonto(vonKonto);
                ueberweisungsvorlageGrenz.setDatum(datum);
                ueberweisungsvorlageGrenz.setVerwendungszweck(vZweck);


                if(this.vorlageSteuerung.ueberweisungsvorlageAnlegen(ueberweisungsvorlageGrenz)){
                    JOptionPane.showMessageDialog(this, "Überweisung erfolgreich erstellt.", "Erfolg", JOptionPane.INFORMATION_MESSAGE);
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }else {
                    throw new RuntimeException("Die Überweisungvorlage konnte nicht erstellt werden.");
                }
            }else {
                throw new RuntimeException("Das Formular enthält Fehler.");
            }
        } catch(RuntimeException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }


        


    }//GEN-LAST:event_AnlegenButtonActionPerformed

    private void jFormattedTextFieldDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDatumActionPerformed

    private void textFieldVonKontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldVonKontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldVonKontoActionPerformed

    private void BetragTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BetragTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BetragTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(UeberweisungVorlageAnlegenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UeberweisungVorlageAnlegenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UeberweisungVorlageAnlegenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UeberweisungVorlageAnlegenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UeberweisungVorlageAnlegenFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnlegenButton;
    private javax.swing.JTextField BetragTextField;
    private javax.swing.JFormattedTextField jFormattedTextFieldDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField textFieldVerwendungszweck;
    private javax.swing.JTextField textFieldVonKonto;
    // End of variables declaration//GEN-END:variables
}
