package bks.gui.kundegui.gui;

import bks.fachlogik.kundesteuerung.grenz.KontoGrenz;
import bks.fachlogik.kundesteuerung.grenz.KontoauszugGrenz;
import bks.fachlogik.kundesteuerung.impl.IKontoauszugSteuerungImpl;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bilal
 */
public class KontoListeAuszugFrame extends javax.swing.JFrame {
    private final IKontoauszugSteuerungImpl kontoSteuerung = new IKontoauszugSteuerungImpl();
    private List<KontoGrenz> kontoListe = null;
    private List<KontoauszugGrenz> kontoauszugListe = null;
    DefaultTableModel tableKonto = null;
    DefaultTableModel tableKAuszug = null;
    char tmp;
    boolean rowsCreated = false;
    boolean kontozug = false;

    public KontoListeAuszugFrame() {        
        initComponents();        
        kontoListe = kontoSteuerung.getKundenKontoListe();
        initKontoListe(kontoListe);                        
    }
    
    private void initKontoListe(List<KontoGrenz> kListe) {
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd"); // vergleiche year, month, day & hour          
        String date_String = null;
        tableKonto = (DefaultTableModel) kontoListTable.getModel();
        
        if(kontoListe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Keine Konten vorhanden\n\n", "Hinweis", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false); 
            this.dispose();           
          //  return;
        }
        
        for (int i = 0; i < kontoListe.size(); i++){
           int ktoid = kontoListe.get(i).getKtoid();
           date_String  = dtFormat.format(kontoListe.get(i).getErstellungsdatum() );            
           double kontostand = kontoListe.get(i).getKontostand();
           double dispo = kontoListe.get(i).getDispo();
           String status = kontoListe.get(i).getStatus();
           int kid = kontoListe.get(i).getKid();           

           Object[] data = {ktoid, date_String, kontostand, dispo, status, kid };
           
           tableKonto.addRow(data);
        }
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        kontoListTable = new javax.swing.JTable();
        btnCloseFrame = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        kAuszuegeTable = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        kontoauszugBtn = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        textField_Ktoid = new javax.swing.JFormattedTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jTextPane1.setText("Konto Liste");
        jTextPane1.setFocusable(false);
        jScrollPane2.setViewportView(jTextPane1);

        kontoListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Konto Nr.", "Erstellungsdatum", "Kontostand", "Dispo", "Status", "Kunden Nr."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kontoListTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(kontoListTable);

        btnCloseFrame.setText("Beenden");
        btnCloseFrame.setToolTipText("");
        btnCloseFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseFrame(evt);
            }
        });
        btnCloseFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseFrameActionPerformed(evt);
            }
        });

        kAuszuegeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Auszug Nr.", "BIZ", "Konto Nr.", "Datum", "Bankname", "Buchungstext", "Stadt", "Betrag", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kAuszuegeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(kAuszuegeTable);

        btnPrint.setText("Kontoauszug drucken");
        btnPrint.setActionCommand("btnDrucken");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        kontoauszugBtn.setText("Kontoauszuege Anzeigen");
        kontoauszugBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontoauszugBtnActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setText("Konto Nr. eingeben fuer Kontoauszug:");

        textField_Ktoid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0"))));
        textField_Ktoid.setToolTipText("Konto Nr. eingeben");
        textField_Ktoid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textField_KtoidKeyTyped(evt);
            }
        });

        jTextPane2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jTextPane2.setText("Kontoauszuege");
        jScrollPane4.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_Ktoid, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrint)
                        .addGap(18, 18, 18)
                        .addComponent(kontoauszugBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCloseFrame)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kontoauszugBtn)
                    .addComponent(textField_Ktoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCloseFrame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField_KtoidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField_KtoidKeyTyped
        char c;
        try {
            c = evt.getKeyChar();
            kontoauszugBtn.setEnabled(true);
            btnPrint.setEnabled(true);

            if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)
                || (c==KeyEvent.VK_DELETE) ) ) {
            // getToolkit().beep();
            evt.consume();
        }
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(this, "Fehler bei Eingabe\n\n", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textField_KtoidKeyTyped

    private void kontoauszugBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontoauszugBtnActionPerformed

        // String textFieldValue = textField_Ktoid.getIntegerInstance();
        int ktoid = 0;
        try {
            ktoid = ((Number)textField_Ktoid.getValue()).intValue();
            kontoauszugBtn.setEnabled(false);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Fehler bei Formatierung\n\n", "Error", JOptionPane.WARNING_MESSAGE);

        }
        /*
        tableKAuszug= (DefaultTableModel) kAuszuegeTable.getModel();
        int column = 0;
        int row = kAuszuegeTable.getSelectedRow();
        String value = (kAuszuegeTable.getModel().getValueAt(row, column).toString() );
        int kaid = Integer.parseInt(value);
        */
        //int kaid = 150;
        initKontoauszuegeList(ktoid);
    }//GEN-LAST:event_kontoauszugBtnActionPerformed

    private void btnCloseFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCloseFrameActionPerformed

    private void btnCloseFrame(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseFrame
        this.dispose();
    }//GEN-LAST:event_btnCloseFrame

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        int ktoid=0;
        boolean success = false;
        try {
            ktoid = ((Number)textField_Ktoid.getValue()).intValue();
            btnPrint.setEnabled(false);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Fehler bei Formatierung\n\n", "Error", JOptionPane.WARNING_MESSAGE);

        }

        for(int i=0;i<kontoauszugListe.size();i++) {
            if(kontoauszugListe.get(i).getKonto() == ktoid)
            {
                kontozug = true; break;
            }
        }
        if(kontozug) {
            success = kontoSteuerung.kontoauszugDrucken(ktoid, kontoauszugListe);
        }else {
            JOptionPane.showMessageDialog(this, "Keine Kontoauszuege zum ausdrucken\n\n", "Warnung", JOptionPane.WARNING_MESSAGE);
        }
        if(success) {
            JOptionPane.showMessageDialog(this, "Drucken erfolgreich\n\n", "Hinweis", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(this, "Fehler beim Drucken\n\n", "Warnung", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void initKontoauszuegeList(int ktoid) {
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd"); // vergleiche year, month, day & hour          
        String date_String = null;
        tableKAuszug = (DefaultTableModel) kAuszuegeTable.getModel();
        
        //Check for previous generated Rows and delete if needed 
        if(tableKAuszug.getRowCount() != 0) {
            for(int i=0;i< tableKAuszug.getRowCount(); i++) {
                tableKAuszug.removeRow(i);
            }
        }
        
        kontoauszugListe = kontoSteuerung.getKontoauszuege(ktoid);
        
        if(kontoauszugListe.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Keine Kontoauszuege vorhanden\n\n", "Hinweis", JOptionPane.INFORMATION_MESSAGE);
           // this.setVisible(false);
           // this.dispose();           
          //  return;          
        }
        
        for (int i = 0; i < kontoauszugListe.size(); i++){
           int kaidTemp = kontoauszugListe.get(i).getKaid();
           int blz = kontoauszugListe.get(i).getBlz();
           int konto = kontoauszugListe.get(i).getKonto();
           date_String  = dtFormat.format(kontoauszugListe.get(i).getDatum() );     
           String bankname = kontoauszugListe.get(i).getBankname();
           String buchungstext = kontoauszugListe.get(i).getBuchungstext();
           String stadt = kontoauszugListe.get(i).getStadt();
           double betrag = kontoauszugListe.get(i).getBetrag();
           double saldo = kontoauszugListe.get(i).getSaldo();
       

           Object[] data = {kaidTemp,blz,konto, date_String,bankname,buchungstext,stadt,betrag,saldo};
           
           tableKAuszug.addRow(data);
            }
        
    }
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
            java.util.logging.Logger.getLogger(KontoListeAuszugFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KontoListeAuszugFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KontoListeAuszugFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KontoListeAuszugFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KontoListeAuszugFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseFrame;
    private javax.swing.JButton btnPrint;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTable kAuszuegeTable;
    private javax.swing.JTable kontoListTable;
    private javax.swing.JButton kontoauszugBtn;
    private java.awt.List list1;
    private javax.swing.JFormattedTextField textField_Ktoid;
    // End of variables declaration//GEN-END:variables
}