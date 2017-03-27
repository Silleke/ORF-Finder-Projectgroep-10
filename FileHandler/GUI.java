/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandler;

import ORF.findORF;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author amberjanssengroesbeek
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
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

        TF_Path = new javax.swing.JTextField();
        BladerButton = new javax.swing.JButton();
        ControleerButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SearchORFbutton = new javax.swing.JButton();
        ExportORFButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_Statistics = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BladerButton.setText("Bladeren");
        BladerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BladerButtonActionPerformed(evt);
            }
        });

        ControleerButton.setText("Controleren");
        ControleerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControleerButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("File");

        SearchORFbutton.setText("Search ORF");
        SearchORFbutton.setEnabled(false);
        SearchORFbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchORFbuttonActionPerformed(evt);
            }
        });

        ExportORFButton.setText("Export ORF");
        ExportORFButton.setEnabled(false);

        jButton5.setText("Visualiseer");

        jButton6.setText("BLAST");

        jButton7.setText("Export BLAST");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        TA_Statistics.setBackground(new java.awt.Color(204, 204, 204));
        TA_Statistics.setColumns(20);
        TA_Statistics.setRows(5);
        jScrollPane1.setViewportView(TA_Statistics);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TF_Path, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BladerButton))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExportORFButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchORFbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ControleerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BladerButton)
                    .addComponent(jLabel1)
                    .addComponent(ControleerButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(SearchORFbutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExportORFButton))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(3, 3, 3)
                        .addComponent(jButton7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BladerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BladerButtonActionPerformed
        FileChooser bladerBestand = new FileChooser();
        bladerBestand.ChooseFile();
        
        // pad toegevoegd aan textfield. Verkregen uit de class Bladeren. 
        TF_Path.setText(bladerBestand.getPath());
    }//GEN-LAST:event_BladerButtonActionPerformed

    private void ControleerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControleerButtonActionPerformed
        FileReader reader = new FileReader();
        try {
            // FileReader class wordt aangeroepen waarin het pad van het bestand wordt meegegeven. 
            reader.Read(TF_Path.getText());
        } catch (NotNuclSequence ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // nadat de template strand is aangemaakt, wordt a.d.h.v de template strand de complementaire strand gemaakt.
        reader.setComplementStrand();
        
        // als de complementaire streng gegenereerd is, dan is de DNA sequentie goedgekeurd. 
        if(!reader.getComplementStrand().isEmpty()){
            TA_Statistics.setText("Goede DNA sequentie!");
        }
        
        // Als de textarea niet leeg is, dan staat er goede DNA sequentie dus kan er een ORF gezocht worden. Als het geen DNA sequentie is, kan er geen ORF gezocht worden
        if(!TA_Statistics.getText().isEmpty()){
            SearchORFbutton.setEnabled(rootPaneCheckingEnabled);
        }
    }//GEN-LAST:event_ControleerButtonActionPerformed

    private void SearchORFbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchORFbuttonActionPerformed
        // De gebruiker geeft aan hoelang het ORF minimaal moet zijn, default staat op 100 nucleotiden lang
        String settings = JOptionPane.showInputDialog("ORF length: ", 100);
        
        findORF orf = new findORF();
        orf.setORF(settings);
        
        // Als er op de search button wordt geklikt, dan wordt de text area leeg gemaakt.
        TA_Statistics.setText(null);
        
        // Doormiddel van de indexen van de arraylists de statistieken van de template strand in de text area zetten.
        for (int ArrayIndex_Temp = 0; ArrayIndex_Temp < orf.getORFsequenceTemp().size(); ArrayIndex_Temp++) {
            TA_Statistics.append("ORF template strand: " + "\t" +orf.getORFsequenceTemp().get(ArrayIndex_Temp) + "\n");
            TA_Statistics.append("Positie start codon: " + "\t" + orf.getORFstartTemp().get(ArrayIndex_Temp) + "\n");
            TA_Statistics.append("Positie stop codon: " + "\t" + orf.getORFendTemp().get(ArrayIndex_Temp) + "\n");
            TA_Statistics.append("Reading frame: " + "\t" + "+" + orf.getORFrfTemp().get(ArrayIndex_Temp) + "\n");
            TA_Statistics.append("\n");
        }
        
        // Doormiddel van de indexen van de arraylists de statistieken van de complement strand in de text area zetten.
        for (int ArrayIndex_Comp = 0; ArrayIndex_Comp < orf.getORFsequenceComp().size(); ArrayIndex_Comp++) {
            TA_Statistics.append("ORF complement strand: " + "\t" +orf.getORFsequenceComp().get(ArrayIndex_Comp) + "\n");
            TA_Statistics.append("Positie start codon: " + "\t" + orf.getORFstartComp().get(ArrayIndex_Comp) + "\n");
            TA_Statistics.append("Positie stop codon: " + "\t" + orf.getORFendComp().get(ArrayIndex_Comp) + "\n");
            TA_Statistics.append("Reading frame: " + "\t" + "-" + orf.getORFrfComp().get(ArrayIndex_Comp) + "\n");
            TA_Statistics.append("\n");            
        }
        
        // Als de textarea niet leeg is, dan zijn er waardes om te exporteren dus kan de button enabled worden. 
        if(!TA_Statistics.getText().isEmpty()){
            ExportORFButton.setEnabled(rootPaneCheckingEnabled);
        }else{
            TA_Statistics.append("Er kan niets geëxporteerd worden");
        }
    }//GEN-LAST:event_SearchORFbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BladerButton;
    private javax.swing.JButton ControleerButton;
    private javax.swing.JButton ExportORFButton;
    private javax.swing.JButton SearchORFbutton;
    private javax.swing.JTextArea TA_Statistics;
    private javax.swing.JTextField TF_Path;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
